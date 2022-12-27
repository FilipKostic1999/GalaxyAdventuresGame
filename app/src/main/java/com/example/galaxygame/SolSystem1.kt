package com.example.galaxygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class SolSystem1 : AppCompatActivity() {



    lateinit var ConstraintLayout : ConstraintLayout

    lateinit var solSystem1Planet1Txt : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sol_system1)



        ConstraintLayout = findViewById(R.id.SelectedSolLayout)
        solSystem1Planet1Txt = findViewById(R.id.solSystem1Planet1Txt)





        val sharedSelectedPlanet = getSharedPreferences("SelectedPlanet", AppCompatActivity.MODE_PRIVATE)
        var SelectedPlanet = sharedSelectedPlanet.getInt("SelectedPlanet", 0)





        solSystem1Planet1Txt.setOnClickListener {


            SelectedPlanet = 1

            val editSelectedPlanet = sharedSelectedPlanet.edit()
            editSelectedPlanet.putInt("SelectedPlanet", SelectedPlanet)
            editSelectedPlanet.commit()

            val intent = Intent(this, VisitAlienPlanetActivity :: class.java)
            startActivity(intent)

        }








    }
}