package by.kos.hogwartsinfo.ui.scenes.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kos.hogwartsinfo.R
import by.kos.hogwartsinfo.helpers.Keys
import by.kos.hogwartsinfo.ui.scenes.hat.HatActivity
import by.kos.hogwartsinfo.ui.scenes.main.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val userName = getSharedPreferences(getString(R.string.app_name), 0)
            .getString(Keys.USERNAME.value, "")

        if (userName != null) {
            if (userName.isEmpty()) {
                startActivity(Intent(applicationContext, HatActivity::class.java))
            } else {
                startActivity(Intent(applicationContext, MainActivity::class.java))
            }
        }
    }
}