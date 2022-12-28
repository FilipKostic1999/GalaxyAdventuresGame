package com.example.galaxygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class SolSystem1 : AppCompatActivity() {



    lateinit var ConstraintLayout : ConstraintLayout

    lateinit var solSystem1Planet1Txt : TextView
    lateinit var solSystem1HotPlanetTxt : TextView
    lateinit var solSystem1CoolPlanetTxt : TextView
    lateinit var solSystem1GreenPlanet : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sol_system1)



        ConstraintLayout = findViewById(R.id.SelectedSolLayout)
        solSystem1Planet1Txt = findViewById(R.id.solSystem1Planet1Txt)
        solSystem1HotPlanetTxt = findViewById(R.id.solSystem1HotPlanetTxt)
        solSystem1CoolPlanetTxt = findViewById(R.id.solSystem1CoolPlanetTxt)
        solSystem1GreenPlanet = findViewById(R.id.solSystem1GreenPlanetTxt)





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







        solSystem1GreenPlanet.setOnClickListener {


            /* Id number of a second visitable planet in the same solar system is the same number of
            the first visitable planet in the system repeated three times
             */



            SelectedPlanet = 111

            val editSelectedPlanet = sharedSelectedPlanet.edit()
            editSelectedPlanet.putInt("SelectedPlanet", SelectedPlanet)
            editSelectedPlanet.commit()

            val intent = Intent(this, VisitAlienPlanetActivity :: class.java)
            startActivity(intent)



        }





        solSystem1HotPlanetTxt.setOnClickListener {

            Toast.makeText(this, "This planet is too warm to visit", Toast.LENGTH_SHORT).show()

        }



        solSystem1CoolPlanetTxt.setOnClickListener {

            Toast.makeText(this, "This planet is too cold to visit", Toast.LENGTH_SHORT).show()

        }












    }
}