package com.example.galaxygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class SolSystem6 : AppCompatActivity() {



    lateinit var solSystem6GasGiant : TextView
    lateinit var solSystem6WarmPlanet: TextView
    lateinit var solSystem6StormyPlanet: TextView
    lateinit var solSystem6Planet1 : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sol_system6)


        solSystem6GasGiant = findViewById(R.id.solSystem6GasGiant)
        solSystem6WarmPlanet = findViewById(R.id.solSystem6WarmPlanet)
        solSystem6StormyPlanet = findViewById(R.id.solSystem6StormyPlanet)
        solSystem6Planet1 = findViewById(R.id.solSystem6Planet1)



        val sharedSelectedPlanet = getSharedPreferences("SelectedPlanet", AppCompatActivity.MODE_PRIVATE)
        var SelectedPlanet = sharedSelectedPlanet.getInt("SelectedPlanet", 0)


        solSystem6Planet1.setOnClickListener {

            SelectedPlanet = 6

            val editSelectedPlanet = sharedSelectedPlanet.edit()
            editSelectedPlanet.putInt("SelectedPlanet", SelectedPlanet)
            editSelectedPlanet.commit()

            val intent = Intent(this, VisitAlienPlanetActivity :: class.java)
            startActivity(intent)

        }



        solSystem6GasGiant.setOnClickListener {

            Toast.makeText(this, "This planet is a gas giant", Toast.LENGTH_SHORT).show()

        }


        solSystem6WarmPlanet.setOnClickListener {

            Toast.makeText(this, "This planet is too warm to visit", Toast.LENGTH_SHORT).show()

        }



        solSystem6StormyPlanet.setOnClickListener {

            Toast.makeText(this, "This planet is too stormy to visit", Toast.LENGTH_SHORT).show()

        }










    }
}