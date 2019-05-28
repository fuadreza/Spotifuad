package io.github.fuadreza.spotifuad

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import io.github.fuadreza.spotifuad.ui.lengkap.LengkapActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var skor: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnUpgrade.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnUpgrade -> {
                skor++
                Toast.makeText(this, "Hidup anda terupgrade $skor%", Toast.LENGTH_SHORT).show()

                if(skor==100){
                    intent = Intent(this, LengkapActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}
