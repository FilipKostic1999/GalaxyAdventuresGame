package com.example.galaxygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SolSystem10 : AppCompatActivity() {


    lateinit var solSystem10Planet1: TextView
    lateinit var solSystem10Planet2: TextView
    lateinit var solSystem10Planet3: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sol_system10)


        solSystem10Planet1 = findViewById(R.id.solSystem10Planet1)
        solSystem10Planet2 = findViewById(R.id.solSystem10Planet2)
        solSystem10Planet3 = findViewById(R.id.solSystem10Planet3)


        val sharedSelectedPlanet = getSharedPreferences("SelectedPlanet", AppCompatActivity.MODE_PRIVATE)
        var SelectedPlanet = sharedSelectedPlanet.getInt("SelectedPlanet", 0)



        solSystem10Planet1.setOnClickListener {

            SelectedPlanet = 10

            val editSelectedPlanet = sharedSelectedPlanet.edit()
            editSelectedPlanet.putInt("SelectedPlanet", SelectedPlanet)
            editSelectedPlanet.commit()

            val intent = Intent(this, VisitAlienPlanetActivity :: class.java)
            startActivity(intent)

        }




        solSystem10Planet2.setOnClickListener {

            SelectedPlanet = 101010

            val editSelectedPlanet = sharedSelectedPlanet.edit()
            editSelectedPlanet.putInt("SelectedPlanet", SelectedPlanet)
            editSelectedPlanet.commit()

            val intent = Intent(this, VisitAlienPlanetActivity :: class.java)
            startActivity(intent)

        }



        solSystem10Planet3.setOnClickListener {

            SelectedPlanet = 10101010

            val editSelectedPlanet = sharedSelectedPlanet.edit()
            editSelectedPlanet.putInt("SelectedPlanet", SelectedPlanet)
            editSelectedPlanet.commit()

            val intent = Intent(this, VisitAlienPlanetActivity :: class.java)
            startActivity(intent)

        }





    }
}