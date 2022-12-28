package com.example.galaxygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class SolSystem4 : AppCompatActivity() {


    lateinit var solSystem4Planet1 : TextView
    lateinit var solSystem4GreenPlanet : TextView
    lateinit var solSystem4AcidPlanet : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sol_system4)



        solSystem4Planet1 = findViewById(R.id.solSystem4Planet1)
        solSystem4GreenPlanet = findViewById(R.id.solSystem4GreenPlanet)
        solSystem4AcidPlanet = findViewById(R.id.solSystem4AcidPlanet)



        val sharedSelectedPlanet = getSharedPreferences("SelectedPlanet", AppCompatActivity.MODE_PRIVATE)
        var SelectedPlanet = sharedSelectedPlanet.getInt("SelectedPlanet", 0)



        solSystem4Planet1.setOnClickListener {

            SelectedPlanet = 4

            val editSelectedPlanet = sharedSelectedPlanet.edit()
            editSelectedPlanet.putInt("SelectedPlanet", SelectedPlanet)
            editSelectedPlanet.commit()

            val intent = Intent(this, VisitAlienPlanetActivity :: class.java)
            startActivity(intent)

        }



        solSystem4GreenPlanet.setOnClickListener {

            SelectedPlanet = 444

            val editSelectedPlanet = sharedSelectedPlanet.edit()
            editSelectedPlanet.putInt("SelectedPlanet", SelectedPlanet)
            editSelectedPlanet.commit()

            val intent = Intent(this, VisitAlienPlanetActivity :: class.java)
            startActivity(intent)

        }



        solSystem4AcidPlanet.setOnClickListener {

            Toast.makeText(this, "This planet is too acid to visit", Toast.LENGTH_SHORT).show()

        }





    }
}