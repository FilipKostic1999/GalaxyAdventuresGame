package com.example.galaxygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class solSystem9 : AppCompatActivity() {


    lateinit var solSystem9Planet1: TextView
    lateinit var solSystem9Planet2: TextView
    lateinit var solSystem9GasGiant: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sol_system9)


        solSystem9Planet1 = findViewById(R.id.solSystem9Planet1)
        solSystem9Planet2 = findViewById(R.id.solSystem9Planet2)
        solSystem9GasGiant = findViewById(R.id.solSystem9GasGiant)



        val sharedSelectedPlanet = getSharedPreferences("SelectedPlanet", AppCompatActivity.MODE_PRIVATE)
        var SelectedPlanet = sharedSelectedPlanet.getInt("SelectedPlanet", 0)




        solSystem9Planet1.setOnClickListener {

            SelectedPlanet = 9

            val editSelectedPlanet = sharedSelectedPlanet.edit()
            editSelectedPlanet.putInt("SelectedPlanet", SelectedPlanet)
            editSelectedPlanet.commit()

            val intent = Intent(this, VisitAlienPlanetActivity :: class.java)
            startActivity(intent)

        }





        solSystem9Planet2.setOnClickListener {

            SelectedPlanet = 999

            val editSelectedPlanet = sharedSelectedPlanet.edit()
            editSelectedPlanet.putInt("SelectedPlanet", SelectedPlanet)
            editSelectedPlanet.commit()

            val intent = Intent(this, VisitAlienPlanetActivity :: class.java)
            startActivity(intent)

        }



        solSystem9GasGiant.setOnClickListener {

            Toast.makeText(this, "This planet is a gassy giant", Toast.LENGTH_SHORT).show()

        }







    }
}