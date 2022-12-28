package com.example.galaxygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class SolSystem13 : AppCompatActivity() {



    lateinit var solSystem13Planet1 : TextView
    lateinit var solSystem13WarmPlanet : TextView
    lateinit var solSystem13StormyPlanet : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sol_system13)


        solSystem13Planet1 = findViewById(R.id.solSystem13Planet1)
        solSystem13WarmPlanet = findViewById(R.id.solSystem13WarmPlanet)
        solSystem13StormyPlanet = findViewById(R.id.solSystem13StormyPlanet)


        val sharedSelectedPlanet = getSharedPreferences("SelectedPlanet", AppCompatActivity.MODE_PRIVATE)
        var SelectedPlanet = sharedSelectedPlanet.getInt("SelectedPlanet", 0)



        solSystem13Planet1.setOnClickListener {

            SelectedPlanet = 13

            val editSelectedPlanet = sharedSelectedPlanet.edit()
            editSelectedPlanet.putInt("SelectedPlanet", SelectedPlanet)
            editSelectedPlanet.commit()

            val intent = Intent(this, VisitAlienPlanetActivity :: class.java)
            startActivity(intent)

        }



        solSystem13WarmPlanet.setOnClickListener {

            Toast.makeText(this, "This planet is too warm to visit", Toast.LENGTH_SHORT).show()

        }


        solSystem13StormyPlanet.setOnClickListener {

            Toast.makeText(this, "This planet is too stormy to visit", Toast.LENGTH_SHORT).show()

        }


    }
}