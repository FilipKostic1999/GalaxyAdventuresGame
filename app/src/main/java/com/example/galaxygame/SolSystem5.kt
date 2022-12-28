package com.example.galaxygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class SolSystem5 : AppCompatActivity() {


    lateinit var solSystem5Planet1 : TextView
    lateinit var solSystem5GassyGiant : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sol_system5)


        solSystem5Planet1 = findViewById(R.id.solSystem5Planet1)
        solSystem5GassyGiant = findViewById(R.id.solSystem5GassyGiant)


        val sharedSelectedPlanet = getSharedPreferences("SelectedPlanet", AppCompatActivity.MODE_PRIVATE)
        var SelectedPlanet = sharedSelectedPlanet.getInt("SelectedPlanet", 0)




        solSystem5Planet1.setOnClickListener {

            SelectedPlanet = 5

            val editSelectedPlanet = sharedSelectedPlanet.edit()
            editSelectedPlanet.putInt("SelectedPlanet", SelectedPlanet)
            editSelectedPlanet.commit()

            val intent = Intent(this, VisitAlienPlanetActivity :: class.java)
            startActivity(intent)

        }



        solSystem5GassyGiant.setOnClickListener {

            Toast.makeText(this, "This planet is a gassy giant", Toast.LENGTH_SHORT).show()

        }





    }
}