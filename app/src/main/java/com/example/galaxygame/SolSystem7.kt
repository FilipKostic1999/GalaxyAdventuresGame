package com.example.galaxygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class SolSystem7 : AppCompatActivity() {


    lateinit var solSystem7Planet1: TextView
    lateinit var solSystem7VisitablePlanet: TextView
    lateinit var solSystem7ColdPlanet : TextView
    lateinit var solSystem7WarmPlanet : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sol_system7)


        solSystem7Planet1 = findViewById(R.id.solSystem7Planet1)
        solSystem7VisitablePlanet = findViewById(R.id.solSystem7VisitablePlanet)
        solSystem7ColdPlanet = findViewById(R.id.solSystem7ColdPlanet)
        solSystem7WarmPlanet = findViewById(R.id.solSystem7WarmPlanet)


        val sharedSelectedPlanet = getSharedPreferences("SelectedPlanet", AppCompatActivity.MODE_PRIVATE)
        var SelectedPlanet = sharedSelectedPlanet.getInt("SelectedPlanet", 0)







        solSystem7Planet1.setOnClickListener {

            SelectedPlanet = 7

            val editSelectedPlanet = sharedSelectedPlanet.edit()
            editSelectedPlanet.putInt("SelectedPlanet", SelectedPlanet)
            editSelectedPlanet.commit()

            val intent = Intent(this, VisitAlienPlanetActivity :: class.java)
            startActivity(intent)


        }






        solSystem7VisitablePlanet.setOnClickListener {

            SelectedPlanet = 777

            val editSelectedPlanet = sharedSelectedPlanet.edit()
            editSelectedPlanet.putInt("SelectedPlanet", SelectedPlanet)
            editSelectedPlanet.commit()

            val intent = Intent(this, VisitAlienPlanetActivity :: class.java)
            startActivity(intent)

        }




        solSystem7ColdPlanet.setOnClickListener {

            Toast.makeText(this, "This planet is too cold to visit", Toast.LENGTH_SHORT).show()

        }


        solSystem7WarmPlanet.setOnClickListener {

            Toast.makeText(this, "This planet is too warm to visit", Toast.LENGTH_SHORT).show()

        }





    }
}