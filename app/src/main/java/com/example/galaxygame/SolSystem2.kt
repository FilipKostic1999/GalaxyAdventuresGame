package com.example.galaxygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class SolSystem2 : AppCompatActivity() {

    lateinit var solSystem2IcyPlanetTxt : TextView
    lateinit var solSystem2Planet1Txt : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sol_system2)



        solSystem2IcyPlanetTxt = findViewById(R.id.solSystem2IcyPlanetTxt)
        solSystem2Planet1Txt = findViewById(R.id.solSystem2Planet1Txt)


        val sharedSelectedPlanet = getSharedPreferences("SelectedPlanet", AppCompatActivity.MODE_PRIVATE)
        var SelectedPlanet = sharedSelectedPlanet.getInt("SelectedPlanet", 0)



        solSystem2IcyPlanetTxt.setOnClickListener {

            Toast.makeText(this, "This planet is too cold to visit", Toast.LENGTH_SHORT).show()

        }



        solSystem2Planet1Txt.setOnClickListener {

            SelectedPlanet = 2

            val editSelectedPlanet = sharedSelectedPlanet.edit()
            editSelectedPlanet.putInt("SelectedPlanet", SelectedPlanet)
            editSelectedPlanet.commit()

            val intent = Intent(this, VisitAlienPlanetActivity :: class.java)
            startActivity(intent)


        }








    }
}