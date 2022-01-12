package com.labelinsight.animation

import com.labelinsight.animation.Channel.Companion.animate
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import java.util.*


@SpringBootApplication(
    exclude = [DataSourceAutoConfiguration::class]
)
class AnimationApplication

/**
 * Running the main in Channel.kt, you have to
 * type in your speed, hit enter,then your chamber at init, and hit enter.
 *
 * Running the main in AnimationApplication.kt, you can
 * type in your speed, a comma, a space, then your chamber at init, and hit enter.
 */
fun main(args: Array<String>) {
    runApplication<AnimationApplication>(*args)
    println("Type in your speed, a comma, a space, then your chamber at init, and hit enter.")

    val inputScanner = Scanner(System.`in`)
    val inputLine = inputScanner.nextLine()
    val inputArray = inputLine.split(", ").toTypedArray()
    val speed: Int
    val init: String

    if (inputArray.size == 2) {
        speed = try {
            inputArray[0].toInt()
        } catch (nfe: NumberFormatException) {
            println("Speed was not an Int.  Aborting.")
            return
        }
        init = inputArray[1].uppercase(Locale.getDefault()).replace("\"", "")

        if (init.isEmpty().not()) {
            val animationArray = animate(speed, init)
            animationArray.forEach {
                println(it)
            }
        } else {
            println("Your input was invalid.  Aborting.")
        }
    } else {
        println("Your input was invalid.  Aborting.")
    }

    inputScanner.close()
}
