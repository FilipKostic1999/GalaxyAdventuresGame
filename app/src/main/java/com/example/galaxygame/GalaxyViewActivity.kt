package com.example.galaxygame

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView

class GalaxyViewActivity : AppCompatActivity() {



    lateinit var yourSolSystemArrowImg : ImageView


    lateinit var signalSolarSystem1 : ImageView
    lateinit var signalSolSystem2 : ImageView
    lateinit var signalSolSystem3 : ImageView
    lateinit var signalSolSystem4 : ImageView
    lateinit var signalSolSystem5 : ImageView
    lateinit var signalSolSystem6 : ImageView
    lateinit var signalSolSystem7 : ImageView
    lateinit var signalSolSystem8 : ImageView

    lateinit var signalSolSystem9ZorgonColony: ImageView


    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_galaxy_view)



        yourSolSystemArrowImg = findViewById(R.id.yourSolSystemArrowImg)


        signalSolarSystem1 = findViewById(R.id.signalSolSystem1)
        signalSolSystem2 = findViewById(R.id.signalSolSystem2)
        signalSolSystem3 = findViewById(R.id.signalSolSystem3)
        signalSolSystem4 = findViewById(R.id.signalSolSystem4)
        signalSolSystem5 = findViewById(R.id.signalSolSystem5)
        signalSolSystem6 = findViewById(R.id.signalSolSystem6)
        signalSolSystem7 = findViewById(R.id.signalSolSystem7)
        signalSolSystem8 = findViewById(R.id.signalSolSystem8)

        signalSolSystem9ZorgonColony = findViewById(R.id.signalSolSystem9ZorgonColony)




        val sharedSelectedPlanet = getSharedPreferences("SelectedPlanet", AppCompatActivity.MODE_PRIVATE)
        var SelectedPlanet = sharedSelectedPlanet.getInt("SelectedPlanet", 0)









        yourSolSystemArrowImg.setOnClickListener {

            val intent = Intent(this, homeSolarSystem :: class.java)
            startActivity(intent)

        }





        signalSolarSystem1.setOnClickListener {

            val intent = Intent(this, SolSystem1 :: class.java)
            startActivity(intent)

        }

        signalSolSystem2.setOnClickListener {

            val intent = Intent(this, SolSystem2 :: class.java)
            startActivity(intent)

        }

        signalSolSystem3.setOnClickListener {

            val intent = Intent(this, SolSystem3 :: class.java)
            startActivity(intent)

        }




        signalSolSystem4.setOnClickListener {

            val intent = Intent(this, SolSystem4 :: class.java)
            startActivity(intent)

        }


        signalSolSystem5.setOnClickListener {

            val intent = Intent(this, SolSystem5 :: class.java)
            startActivity(intent)

        }


        signalSolSystem6.setOnClickListener {

            val intent = Intent(this, SolSystem6 :: class.java)
            startActivity(intent)

        }



        signalSolSystem7.setOnClickListener {

            val intent = Intent(this, SolSystem7 :: class.java)
            startActivity(intent)

        }




        signalSolSystem8.setOnClickListener {

            val intent = Intent(this, SolSystem8 :: class.java)
            startActivity(intent)

        }


        signalSolSystem9ZorgonColony.setOnClickListener {

            val intent = Intent(this, solSystem9 :: class.java)
            startActivity(intent)

        }









    }
}