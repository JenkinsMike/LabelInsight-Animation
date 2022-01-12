package com.labelinsight.animation

internal class Particle(
    private val speed: Int,
    private val direction: Char,
    private val startingLocation: Int
) {
    fun currentLocationGivenTime(time: Int, channelLength: Int): Int? {
        var location: Int? = null

        when (direction) {
            'R' -> {
                location = startingLocation + speed * time
                location = if (location >= channelLength) null else location
            }
            'L' -> {
                location = startingLocation - speed * time
                location = if (location < 0) null else location
            }
        }

        return location
    }
}