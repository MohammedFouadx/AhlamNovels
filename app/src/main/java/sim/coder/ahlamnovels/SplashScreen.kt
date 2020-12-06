package sim.coder.ahlamnovels

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.Exception

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val background = object : Thread(){

            override fun run() {
                try {
                    Thread.sleep(3000)

                    val toMain= Intent(baseContext, MainActivity::class.java)
                    startActivity(toMain)

                }catch (e: Exception){
                    e.printStackTrace()
                }
            }

        }

        background.start()





    }

    override fun onBackPressed() {

        finish()
        super.onBackPressed()
    }
}
