package com.labelinsight.animation

import java.util.*
import kotlin.collections.ArrayList

/**
 * Running the main in Channel.kt, you have to
 * type in your speed, hit enter, then your chamber at init, and hit enter.
 *
 * Running the main in AnimationApplication.kt, you can
 * type in your speed, a comma, a space, then your chamber at init, and hit enter.
 */
open class Channel {
    companion object {
        @Throws(Exception::class)
        @JvmStatic
        fun main(args: Array<String>) {
            println("Type in your speed, hit enter, then your chamber at init, and hit enter.")

            val inputScanner = Scanner(System.`in`)
            val speed: Int
            var init = ""

            if (inputScanner.hasNextInt()) {
                speed = try {
                    inputScanner.nextInt()
                } catch (nfe: NumberFormatException) {
                    println("Speed was not an Int.  Aborting.")
                    return
                }
                if (inputScanner.hasNext()) {
                    init = inputScanner.next().uppercase(Locale.getDefault()).replace("\"", "")
                }

                val animationArray = animate(speed, init)
                animationArray.forEach {
                    println(it)
                }
            }

            inputScanner.close()
        }

        @Throws(Exception::class)
        fun animate(speed: Int, init: String): Array<String> {
            val particleList: MutableList<Particle> = ArrayList()
            val chamberList: MutableList<String> = ArrayList()
            var emptyChamber = false
            var stepCounter = 0

            for (p in init.indices) {
                particleList.add(Particle(speed, init[p], p))
            }

            while (stepCounter < init.length && !emptyChamber) {
                val chamber = arrayOfNulls<Char>(init.length)
                val iterator = particleList.iterator()

                while (iterator.hasNext()) {
                    val particle = iterator.next()
                    val location: Int? = particle.currentLocationGivenTime(stepCounter, init.length)
                    if (location == null || location < 0 || location >= init.length) {
                        iterator.remove()
                    } else {
                        chamber[location] = 'X'
                    }
                }

                val tempString = StringBuilder()
                for (p in init.indices) {
                    if ((null != chamber[p]) && (chamber[p] == 'X')) {
                        tempString.append(chamber[p])
                    } else {
                        tempString.append('.')
                    }
                }

                val channelAtState = tempString.toString()
                chamberList.add(channelAtState)

                if (!channelAtState.contains("X")) {
                    emptyChamber = true
                }
                stepCounter++
            }

            return chamberList.toTypedArray()
        }
    }
}