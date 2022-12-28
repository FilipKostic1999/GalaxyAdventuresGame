package com.example.galaxygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class SolSystem8 : AppCompatActivity() {


    lateinit var solSystem8Planet1 : TextView
    lateinit var solSystem8ColdPlanet : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sol_system8)




        solSystem8Planet1 = findViewById(R.id.solSystem8Planet1)
        solSystem8ColdPlanet = findViewById(R.id.solSystem8ColdPlanet)



        val sharedSelectedPlanet = getSharedPreferences("SelectedPlanet", AppCompatActivity.MODE_PRIVATE)
        var SelectedPlanet = sharedSelectedPlanet.getInt("SelectedPlanet", 0)



        solSystem8Planet1.setOnClickListener {

            SelectedPlanet = 8

            val editSelectedPlanet = sharedSelectedPlanet.edit()
            editSelectedPlanet.putInt("SelectedPlanet", SelectedPlanet)
            editSelectedPlanet.commit()

            val intent = Intent(this, VisitAlienPlanetActivity :: class.java)
            startActivity(intent)

        }


        solSystem8ColdPlanet.setOnClickListener {

            Toast.makeText(this, "This planet is too cold to visit", Toast.LENGTH_SHORT).show()

        }




    }
}