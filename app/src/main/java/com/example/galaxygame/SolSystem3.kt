package com.example.galaxygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class SolSystem3 : AppCompatActivity() {


    lateinit var solSystem3StormyPlanetTxt : TextView
    lateinit var SolSystem3Planet1 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sol_system3)



        solSystem3StormyPlanetTxt = findViewById(R.id.solSystem3StormyPlanetTxt)
        SolSystem3Planet1 = findViewById(R.id.SolSystem3Planet1)


        val sharedSelectedPlanet = getSharedPreferences("SelectedPlanet", AppCompatActivity.MODE_PRIVATE)
        var SelectedPlanet = sharedSelectedPlanet.getInt("SelectedPlanet", 0)


        solSystem3StormyPlanetTxt.setOnClickListener {

            Toast.makeText(this, "This planet is too stormy to visit", Toast.LENGTH_SHORT).show()

        }


        SolSystem3Planet1.setOnClickListener {

            SelectedPlanet = 3

            val editSelectedPlanet = sharedSelectedPlanet.edit()
            editSelectedPlanet.putInt("SelectedPlanet", SelectedPlanet)
            editSelectedPlanet.commit()


            val intent = Intent(this, VisitAlienPlanetActivity :: class.java)
            startActivity(intent)

        }










    }
}