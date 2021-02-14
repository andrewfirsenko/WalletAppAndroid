package ru.cutepool.walletapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.cutepool.walletapp.activities.main.MainActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startMainActivity()
    }

    private fun startMainActivity() {
        MainActivity.start(this, null)
    }

}
