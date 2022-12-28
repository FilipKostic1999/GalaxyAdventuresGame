package com.example.galaxygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class solSystem11 : AppCompatActivity() {


    lateinit var solSystem11Planet1 : TextView
    lateinit var solSystem11Planet2 : TextView
    lateinit var solSystem11StormyPlanet : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sol_system11)


        solSystem11Planet1 = findViewById(R.id.solSystem11Planet1)
        solSystem11Planet2 = findViewById(R.id.solSystem11Planet2)
        solSystem11StormyPlanet = findViewById(R.id.solSystem11StormyPlanet)


        val sharedSelectedPlanet = getSharedPreferences("SelectedPlanet", AppCompatActivity.MODE_PRIVATE)
        var SelectedPlanet = sharedSelectedPlanet.getInt("SelectedPlanet", 0)



        solSystem11Planet1.setOnClickListener {

            SelectedPlanet = 11

            val editSelectedPlanet = sharedSelectedPlanet.edit()
            editSelectedPlanet.putInt("SelectedPlanet", SelectedPlanet)
            editSelectedPlanet.commit()

            val intent = Intent(this, VisitAlienPlanetActivity :: class.java)
            startActivity(intent)

        }




        solSystem11Planet2.setOnClickListener {

            SelectedPlanet = 111111

            val editSelectedPlanet = sharedSelectedPlanet.edit()
            editSelectedPlanet.putInt("SelectedPlanet", SelectedPlanet)
            editSelectedPlanet.commit()

            val intent = Intent(this, VisitAlienPlanetActivity :: class.java)
            startActivity(intent)

        }



        solSystem11StormyPlanet.setOnClickListener {

            Toast.makeText(this, "This planet is too stormy to visit", Toast.LENGTH_SHORT).show()

        }




    }
}