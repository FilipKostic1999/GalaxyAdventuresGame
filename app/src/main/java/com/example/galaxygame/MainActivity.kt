package com.example.galaxygame

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import java.util.*

class MainActivity : AppCompatActivity() {



    lateinit var moneyTextView : TextView
    lateinit var militaryBase : TextView
    lateinit var comandCenterPicture : TextView
    lateinit var factory : TextView
    lateinit var resoursesAmountText : TextView


    lateinit var collectTaxBtn : ImageView
    lateinit var galaxyView : ImageView


    var moneyTaxAmount : Int = 0
    var moneyAmount : Int = 0
    var resoursesAmount : Int = 0
    var resoursesCollectedAmount : Int = 0
    var maximumCapacity : Int = 50
    var levelInfrastructure : Int = 1
    var levelFactory : Int = 1
    var levelMilitaryBase : Int = 1
    var levelGeneralDevelopment : Int = 1
    var levelScientificDevelopment : Int = 1
    var levelSpionage : Int = 1


    var soldierQuantity : Double = 100.0
    var airplaneQuantity : Double = 40.0
    var cargoplaneQuantity : Double = 10.0
    var airplane2Quantity : Double = 0.0
    var tankQuantity : Double = 0.0
    var sateliteQuantity : Double = 0.0



    lateinit var database : FirebaseFirestore
    lateinit var savedDataOfUser : playerData
    lateinit var containerRl : ConstraintLayout



    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        moneyTextView = findViewById(R.id.moneyTextView)
        militaryBase = findViewById(R.id.militaryBase)
        collectTaxBtn = findViewById(R.id.collectTax)
        galaxyView = findViewById(R.id.galaxyView)
        comandCenterPicture = findViewById(R.id.comandCenterPicture)
        factory = findViewById(R.id.factoryImage)
        resoursesAmountText = findViewById(R.id.resoursesAmountText)
        containerRl = findViewById(R.id.idRLayout)




        database = Firebase.firestore






            database.collection("users").document("User path")
                .collection("Saved data")

                .addSnapshotListener { snapshot, e ->
                    if (snapshot != null) {
                        for (document in snapshot.documents) {

                            savedDataOfUser = document.toObject()!!



                            // Sets the saved values from the database to the variables of the activity

                            moneyAmount = savedDataOfUser.savedMoneyAmount
                            resoursesAmount = savedDataOfUser.savedResoursesAmount
                            levelInfrastructure = savedDataOfUser.savedLevelInfrastructure
                            levelFactory = savedDataOfUser.savedLevelFactory
                            levelMilitaryBase = savedDataOfUser.savedLevelMilitaryBase
                            levelGeneralDevelopment = savedDataOfUser.savedLevelGeneralDevelopment
                            levelScientificDevelopment = savedDataOfUser.savedLevelScienficResearch
                            levelSpionage = savedDataOfUser.savedLevelSpionage
                            soldierQuantity = savedDataOfUser.savedSoldierUnitQuantity
                            airplaneQuantity = savedDataOfUser.savedAirplaneUnitQuantity
                            cargoplaneQuantity = savedDataOfUser.savedCargoPlaneQuantity
                            airplane2Quantity = savedDataOfUser.savedAirplane2UnitQuantity
                            tankQuantity = savedDataOfUser.savedTankUnitQuantity
                            sateliteQuantity = savedDataOfUser.savedSateliteUnitQuantity


                            Log.d("!!!", "$moneyAmount")







                            // Displays the saved state and values of the views

                            moneyTextView.text = "${savedDataOfUser.savedMoneyAmount} Trilion"
                            resoursesAmountText.text = "${savedDataOfUser.savedResoursesAmount}"







                            if (levelGeneralDevelopment == 2) {

                                containerRl.background = resources.getDrawable(R.drawable.evolvedsecond)

                            } else if (levelGeneralDevelopment == 3) {

                                containerRl.background = resources.getDrawable(R.drawable.developedthree)

                            }



                        }
                    }
                }














        Timer().scheduleAtFixedRate( object : TimerTask() {
                override fun run () {

                    if (moneyTaxAmount < maximumCapacity) {
                        moneyTaxAmount += 100000
                    }

                    if (resoursesCollectedAmount < maximumCapacity) {
                        resoursesCollectedAmount += 100000
                    }


                }
            }, 0, 1000)










        comandCenterPicture.setOnClickListener {

            val intent = Intent(this, DevelopHomeWorldActivity :: class.java)
            startActivity(intent)

        }





        militaryBase.setOnClickListener {

            val intent = Intent(this, RecruitArmy :: class.java)
            startActivity(intent)


        }




        factory.setOnClickListener {

            resoursesAmount += resoursesCollectedAmount
            resoursesAmountText.text = "$resoursesAmount"
            resoursesCollectedAmount = 0

            savePlayerData()

        }





        collectTaxBtn.setOnClickListener {

            moneyAmount += moneyTaxAmount
            moneyTextView.text = "$moneyAmount Trilion"
            moneyTaxAmount = 0

            savePlayerData()


        }







        galaxyView.setOnClickListener {

            val intent = Intent(this, GalaxyViewActivity :: class.java)
            startActivity(intent)

        }





    }






    override fun onBackPressed() {

        Toast.makeText(this, "This action is not allowed", Toast.LENGTH_SHORT).show()

    }







    fun savePlayerData() {





        var data = playerData(savedMoneyAmount = moneyAmount, savedResoursesAmount = resoursesAmount,
            savedLevelInfrastructure = levelInfrastructure, savedLevelFactory = levelFactory, savedLevelMilitaryBase= levelMilitaryBase,
            savedLevelGeneralDevelopment = levelGeneralDevelopment, savedLevelScienficResearch = levelScientificDevelopment,
            savedLevelSpionage = levelSpionage, savedSoldierUnitQuantity = soldierQuantity, savedAirplaneUnitQuantity = airplaneQuantity,
            savedCargoPlaneQuantity = cargoplaneQuantity, savedAirplane2UnitQuantity= airplane2Quantity, savedTankUnitQuantity= tankQuantity,
            savedSateliteUnitQuantity= sateliteQuantity)



        database.collection("users").document("User path").collection("Saved data")
            .document("hmkogjk").set(data)


            .addOnCompleteListener {



            }
    }
}