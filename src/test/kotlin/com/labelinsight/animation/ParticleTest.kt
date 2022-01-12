package com.labelinsight.animation

import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test


internal class ParticleTest {
    @Test
    fun `R with startLocation 2 and 9 length and speed 2`() {
        val particle = Particle(2, 'R', 2)

        var expected: Int? = 2
        var actual: Int? = particle.currentLocationGivenTime(0, 9)
        assert(expected == actual)

        expected = 4
        actual = particle.currentLocationGivenTime(1, 9)
        assert(expected == actual)

        expected = 6
        actual = particle.currentLocationGivenTime(2, 9)
        assert(expected == actual)

        expected = 8
        actual = particle.currentLocationGivenTime(3, 9)
        assert(expected == actual)

        actual = particle.currentLocationGivenTime(4, 9)
        assertNull(actual)
    }

    @Test
    fun `L with startLocation 2 and 9 length and speed 2`() {
        val particle = Particle(2, 'L', 2)

        var expected: Int? = 2
        var actual: Int? = particle.currentLocationGivenTime(0, 9)
        assert(expected == actual)

        expected = 0
        actual = particle.currentLocationGivenTime(1, 9)
        assert(expected == actual)

        actual = particle.currentLocationGivenTime(2, 9)
        assertNull(actual)
    }

    @Test
    fun `R with startLocation 2 and 7 length and speed 1`() {
        val particle = Particle(1, 'R', 2)

        var expected: Int? = 2
        var actual: Int? = particle.currentLocationGivenTime(0, 7)
        assert(expected == actual)

        expected = 3
        actual = particle.currentLocationGivenTime(1, 7)
        assert(expected == actual)

        expected = 4
        actual = particle.currentLocationGivenTime(2, 7)
        assert(expected == actual)

        expected = 5
        actual = particle.currentLocationGivenTime(3, 7)
        assert(expected == actual)

        expected = 6
        actual = particle.currentLocationGivenTime(4, 7)
        assert(expected == actual)

        actual = particle.currentLocationGivenTime(5, 7)
        assertNull(actual)
    }

    @Test
    fun `L with startLocation 2 and 7 length and speed 1`() {
        val particle = Particle(1, 'L', 2)

        var expected: Int? = 2
        var actual: Int? = particle.currentLocationGivenTime(0, 7)
        assert(expected == actual)

        expected = 1
        actual = particle.currentLocationGivenTime(1, 7)
        assert(expected == actual)

        expected = 0
        actual = particle.currentLocationGivenTime(2, 7)
        assert(expected == actual)

        actual = particle.currentLocationGivenTime(3, 7)
        assertNull(actual)
    }
}
