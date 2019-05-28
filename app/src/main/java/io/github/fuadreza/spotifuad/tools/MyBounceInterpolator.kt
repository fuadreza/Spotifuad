package io.github.fuadreza.spotifuad.tools

/**
 * Dibuat dengan kerjakerasbagaiquda oleh Shifu pada tanggal 14/05/2019.
 *
 */
class MyBounceInterpolator(amplitude: Double, frequency: Double) : android.view.animation.Interpolator {
    private var mAmplitude = 1.0
    private var mFrequency = 10.0

    init {
        mAmplitude = amplitude
        mFrequency = frequency
    }

    override fun getInterpolation(time: Float): Float {
        return (-1.0 * Math.pow(Math.E, -time / mAmplitude) *
                Math.cos(mFrequency * time) + 1).toFloat()
    }
}