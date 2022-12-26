package com.example.galaxygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class GalaxyViewActivity : AppCompatActivity() {


    lateinit var signalSolarSystem1 : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_galaxy_view)



        signalSolarSystem1 = findViewById(R.id.signalSolSystem1)






        signalSolarSystem1.setOnClickListener {

            val intent = Intent(this, SolSystem1 :: class.java)
            startActivity(intent)

        }



    }
}