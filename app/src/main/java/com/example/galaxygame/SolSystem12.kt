package com.example.galaxygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class SolSystem12 : AppCompatActivity() {



    lateinit var solSystem12Planet1 : TextView
    lateinit var solSystem12WarmPlanet1 : TextView
    lateinit var solSystem12WarmPlanet2 : TextView
    lateinit var solSystem12AcidPlanet : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sol_system12)


        solSystem12Planet1 = findViewById(R.id.solSystem12Planet1)
        solSystem12WarmPlanet1 = findViewById(R.id.solSystem12WarmPlanet1)
        solSystem12WarmPlanet2 = findViewById(R.id.solSystem12WarmPlanet2)
        solSystem12AcidPlanet = findViewById(R.id.solSystem12AcidPlanet)


        val sharedSelectedPlanet = getSharedPreferences("SelectedPlanet", AppCompatActivity.MODE_PRIVATE)
        var SelectedPlanet = sharedSelectedPlanet.getInt("SelectedPlanet", 0)


        solSystem12Planet1.setOnClickListener {

            SelectedPlanet = 12

            val editSelectedPlanet = sharedSelectedPlanet.edit()
            editSelectedPlanet.putInt("SelectedPlanet", SelectedPlanet)
            editSelectedPlanet.commit()

            val intent = Intent(this, VisitAlienPlanetActivity :: class.java)
            startActivity(intent)

        }



        solSystem12WarmPlanet1.setOnClickListener {

            Toast.makeText(this, "This planet is too warm to visit", Toast.LENGTH_SHORT).show()

        }


        solSystem12WarmPlanet2.setOnClickListener {

            Toast.makeText(this, "This planet is too warm to visit", Toast.LENGTH_SHORT).show()

        }

        solSystem12AcidPlanet.setOnClickListener {

            Toast.makeText(this, "This planet is too acid to visit", Toast.LENGTH_SHORT).show()

        }







    }
}