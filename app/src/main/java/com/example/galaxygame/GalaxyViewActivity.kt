package com.example.galaxygame

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView

class GalaxyViewActivity : AppCompatActivity() {



    lateinit var yourSolSystemArrowImg : ImageView


    lateinit var signalSolarSystem1 : ImageView


    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_galaxy_view)



        yourSolSystemArrowImg = findViewById(R.id.yourSolSystemArrowImg)


        signalSolarSystem1 = findViewById(R.id.signalSolSystem1)




        val sharedSelectedPlanet = getSharedPreferences("SelectedPlanet", AppCompatActivity.MODE_PRIVATE)
        var SelectedPlanet = sharedSelectedPlanet.getInt("SelectedPlanet", 0)









        yourSolSystemArrowImg.setOnClickListener {

            val intent = Intent(this, homeSolarSystem :: class.java)
            startActivity(intent)

        }





        signalSolarSystem1.setOnClickListener {

            val intent = Intent(this, SolSystem1 :: class.java)
            startActivity(intent)

        }



    }
}