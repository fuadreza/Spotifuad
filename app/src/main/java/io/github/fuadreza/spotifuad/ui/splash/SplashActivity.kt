package io.github.fuadreza.spotifuad.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import io.github.fuadreza.spotifuad.MainActivity
import io.github.fuadreza.spotifuad.R
import io.github.fuadreza.spotifuad.tools.MyBounceInterpolator
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * Dibuat dengan kerjakerasbagaiquda oleh Shifu pada tanggal 13/05/2019.
 *
 */
class SplashActivity: AppCompatActivity() {
    private var mDelayHandler: Handler? = null
    private val SPLASH_DELAY: Long = 4000 //3 seconds
    private var fromTop: Animation? = null
    private var fromBottom: Animation? = null
    private var rotate: Animation? = null
    private var zoom: Animation? = null
    private var bounce: Animation? = null

    internal val mRunnable: Runnable = Runnable {
        if (!isFinishing) {

            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        fromTop = AnimationUtils.loadAnimation(this, R.anim.fromtop)
        fromBottom = AnimationUtils.loadAnimation(this, R.anim.frombottom)
        rotate = AnimationUtils.loadAnimation(this, R.anim.rotate)
        zoom = AnimationUtils.loadAnimation(this, R.anim.zoombounce)
        bounce = AnimationUtils.loadAnimation(this, R.anim.bounce)

        val interpolator = MyBounceInterpolator(0.2, 20.0)
        bounce?.setInterpolator(interpolator)

//        logoApp.startAnimation(fromTop)

        logoApp.startAnimation(bounce)

        //Initialize the Handler
        mDelayHandler = Handler()

        //Navigate with delay
        mDelayHandler!!.postDelayed(mRunnable, SPLASH_DELAY)

    }

    public override fun onDestroy() {

        if (mDelayHandler != null) {
            mDelayHandler!!.removeCallbacks(mRunnable)
        }

        super.onDestroy()
    }
}