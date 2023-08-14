package uz.gita.fourpicsoneword

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.cardview.widget.CardView
import uz.gita.forpicsoneword.R
import uz.gita.fourpicsoneword.ui.game.GameActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<CardView>(R.id.start).setOnClickListener {
            startActivity(Intent(this, GameActivity::class.java))
        }
        findViewById<CardView>(R.id.quit).setOnClickListener { finish() }

    }

    override fun onStart() {
        super.onStart()
        Log.d("TTT", "onStart: called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("TTT", "onPause: called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("TTT", "onResume: called")
    }
    override fun onRestart() {
        super.onRestart()
        Log.d("TTT", "onRestart: called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TTT", "onDestroy: called")
    }
}


