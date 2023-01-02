package com.example.galaxygame

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.isVisible
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

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
    lateinit var signalSolSystem11 : ImageView
    lateinit var signalSolSystem12 : ImageView
    lateinit var signalSolSystem13 : ImageView

    lateinit var signalSolSystem9ZorgonColony: ImageView
    lateinit var signalSolSystem10ZorgonColony: ImageView


    lateinit var savedDataOfUser : playerData
    lateinit var database : FirebaseFirestore



    var scientificDevelopment : Int = 1


    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_galaxy_view)



        database = Firebase.firestore



        yourSolSystemArrowImg = findViewById(R.id.yourSolSystemArrowImg)


        signalSolarSystem1 = findViewById(R.id.signalSolSystem1)
        signalSolSystem2 = findViewById(R.id.signalSolSystem2)
        signalSolSystem3 = findViewById(R.id.signalSolSystem3)
        signalSolSystem4 = findViewById(R.id.signalSolSystem4)
        signalSolSystem5 = findViewById(R.id.signalSolSystem5)
        signalSolSystem6 = findViewById(R.id.signalSolSystem6)
        signalSolSystem7 = findViewById(R.id.signalSolSystem7)
        signalSolSystem8 = findViewById(R.id.signalSolSystem8)
        signalSolSystem11 = findViewById(R.id.signalSolSystem11)
        signalSolSystem12 = findViewById(R.id.signalSolSystem12)
        signalSolSystem13 = findViewById(R.id.signalSolSystem13)

        signalSolSystem9ZorgonColony = findViewById(R.id.signalSolSystem9ZorgonColony)
        signalSolSystem10ZorgonColony = findViewById(R.id.signalSolSystem10ZorgonColony)




        val sharedSelectedPlanet = getSharedPreferences("SelectedPlanet", AppCompatActivity.MODE_PRIVATE)
        var SelectedPlanet = sharedSelectedPlanet.getInt("SelectedPlanet", 0)







        database.collection("users").document("User path")
            .collection("Saved data")

            .addSnapshotListener { snapshot, e ->
                if (snapshot != null) {
                    for (document in snapshot.documents) {

                        savedDataOfUser = document.toObject()!!

                        scientificDevelopment = savedDataOfUser.savedLevelScienficResearch





                    }
                }
            }



























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



        signalSolSystem10ZorgonColony.setOnClickListener {

            val intent = Intent(this, SolSystem10 :: class.java)
            startActivity(intent)

        }






        signalSolSystem11.setOnClickListener {

            if (scientificDevelopment >= 2) {

                val intent = Intent(this, solSystem11::class.java)
                startActivity(intent)

            } else {
                Toast.makeText(this, "You need scientific research LV 2 or higher to visit this system", Toast.LENGTH_SHORT).show()

            }

        }



        signalSolSystem12.setOnClickListener {

            val intent = Intent(this, SolSystem12 :: class.java)
            startActivity(intent)

        }



        signalSolSystem13.setOnClickListener {

            val intent = Intent(this, SolSystem13 :: class.java)
            startActivity(intent)

        }










    }
}