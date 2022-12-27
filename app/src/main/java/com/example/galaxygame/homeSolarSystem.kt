package com.example.galaxygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class homeSolarSystem : AppCompatActivity() {


    lateinit var homeSolarSystemWorld : TextView
    lateinit var homeSolSystemSecondPlanet : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_solar_system)




        homeSolarSystemWorld = findViewById(R.id.homeSolarSystemWorld)
        homeSolSystemSecondPlanet = findViewById(R.id.homeSolSystemSecondPlanet)



        val sharedSelectedPlanet = getSharedPreferences("SelectedPlanet", AppCompatActivity.MODE_PRIVATE)
        var SelectedPlanet = sharedSelectedPlanet.getInt("SelectedPlanet", 0)




        homeSolarSystemWorld.setOnClickListener {

            val intent = Intent(this, MainActivity :: class.java)
            startActivity(intent)

        }



        homeSolSystemSecondPlanet.setOnClickListener {


            SelectedPlanet = 0

            val editSelectedPlanet = sharedSelectedPlanet.edit()
            editSelectedPlanet.putInt("SelectedPlanet", SelectedPlanet)
            editSelectedPlanet.commit()

            val intent = Intent(this, VisitAlienPlanetActivity :: class.java)
            startActivity(intent)

        }





    }
}