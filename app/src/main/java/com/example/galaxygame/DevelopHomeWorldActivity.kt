package com.example.galaxygame

import android.content.Intent
import android.media.Image
import android.media.ImageWriter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class DevelopHomeWorldActivity : AppCompatActivity() {


    lateinit var developeHomeBackBtn : Button


    lateinit var upgradeInfArrow : ImageView
    lateinit var upgradeFactoryArrow : ImageView
    lateinit var upgradeMilitaryBaseArrow : ImageView
    lateinit var upgradeGeneralDevelopmentArrow : ImageView
    lateinit var upgradeScientificDevelopmentArrow : ImageView
    lateinit var upgradeSpionageArrow : ImageView


    lateinit var infrastructureTextView : TextView
    lateinit var factoryTextView : TextView
    lateinit var militaryBaseTextView : TextView
    lateinit var generalDevelopmentTextView : TextView
    lateinit var scientificDevelopmentTextView : TextView
    lateinit var spionageTextView : TextView


    var moneyAmmount : Int = 0
    var resoursces : Int = 0
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




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_develop_home_world)





        developeHomeBackBtn = findViewById(R.id.developeHomeBackBtn)
        upgradeInfArrow = findViewById(R.id.upgradeInfArrow)
        upgradeFactoryArrow = findViewById(R.id.upgradeFactoryArrow)
        upgradeMilitaryBaseArrow = findViewById(R.id.upgradeMilitaryBaseArrow)
        upgradeGeneralDevelopmentArrow = findViewById(R.id.upgradeGeneralDevelopmentArrow)
        upgradeScientificDevelopmentArrow = findViewById(R.id.upgradeScientificDevelopmentArrow)
        upgradeSpionageArrow = findViewById(R.id.upgradeSpionageArrow)

        infrastructureTextView = findViewById(R.id.infrastructureTextView)
        factoryTextView = findViewById(R.id.factoryTextView)
        militaryBaseTextView = findViewById(R.id.militaryBaseTextView)
        generalDevelopmentTextView = findViewById(R.id.generalDevelopmentTextView)
        scientificDevelopmentTextView = findViewById(R.id.scientificResearchTextView)
        spionageTextView = findViewById(R.id.spionageTextView)


        database = Firebase.firestore













        database.collection("users").document("User path")
            .collection("Saved data")

            .addSnapshotListener { snapshot, e ->
                if (snapshot != null) {
                    for (document in snapshot.documents) {

                        savedDataOfUser = document.toObject()!!




                        // Sets the saved values from the database to the variables of the activity


                        moneyAmmount = savedDataOfUser.savedMoneyAmount
                        resoursces = savedDataOfUser.savedResoursesAmount
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






                        // Displays the saved state and values of the views


                        Log.d("!!!", "$levelInfrastructure")

                        if (levelInfrastructure == 2) {

                            infrastructureTextView.text = "Infrastructure (currently LV2). Icreases ammount of money collected by taxes. (Resourses:450 and money: 800 required to upgrade)"


                        } else if (levelInfrastructure == 3) {

                            infrastructureTextView.text = "Infrastructure (currently LV3). Icreases ammount of money collected by taxes. (Resourses:1200 and money: 1600 required to upgrade)"


                        } else if (levelInfrastructure == 4) {

                            infrastructureTextView.text = "Infrastructure (currently LV4). Icreases ammount of money collected by taxes. (Resourses:5000 and money: 9000 required to upgrade)"


                        } else if (levelInfrastructure == 5) {

                            infrastructureTextView.text = "Infrastructure LV 5"

                        }




                        if (levelFactory == 2) {

                            factoryTextView.text = "Infrastructure (currently LV2). Icreases ammount of money collected by taxes. (Resourses:450 and money: 800 required to upgrade)"


                        } else if (levelFactory == 3) {

                            factoryTextView.text = "Infrastructure (currently LV3). Icreases ammount of money collected by taxes. (Resourses:1200 and money: 1600 required to upgrade)"


                        } else if (levelFactory == 4) {

                            factoryTextView.text = "Infrastructure (currently LV4). Icreases ammount of money collected by taxes. (Resourses:5000 and money: 9000 required to upgrade)"


                        } else if (levelFactory == 5) {

                            factoryTextView.text = "Infrastructure LV 5"

                        }








                        if (levelMilitaryBase == 2) {

                            militaryBaseTextView.text = "Infrastructure (currently LV2). Icreases ammount of money collected by taxes. (Resourses:450 and money: 800 required to upgrade)"


                        } else if (levelMilitaryBase == 3) {

                            militaryBaseTextView.text = "Infrastructure (currently LV3). Icreases ammount of money collected by taxes. (Resourses:1200 and money: 1600 required to upgrade)"


                        } else if (levelMilitaryBase == 4) {

                            militaryBaseTextView.text = "Infrastructure (currently LV4). Icreases ammount of money collected by taxes. (Resourses:5000 and money: 9000 required to upgrade)"


                        } else if (levelMilitaryBase == 5) {

                            militaryBaseTextView.text = "Infrastructure LV 5"

                        }










                        if (levelGeneralDevelopment == 2) {

                            generalDevelopmentTextView.text = "Infrastructure (currently LV2). Icreases ammount of money collected by taxes. (Resourses:450 and money: 800 required to upgrade)"


                        } else if (levelGeneralDevelopment == 3) {

                            generalDevelopmentTextView.text = "Infrastructure LV3"

                        }






                        if (levelScientificDevelopment == 2) {

                            scientificDevelopmentTextView.text = "Infrastructure (currently LV2). Icreases ammount of money collected by taxes. (Resourses:450 and money: 800 required to upgrade)"


                        } else if (levelScientificDevelopment == 3) {

                            scientificDevelopmentTextView.text = "Infrastructure (currently LV3). Icreases ammount of money collected by taxes. (Resourses:1200 and money: 1600 required to upgrade)"


                        } else if (levelScientificDevelopment == 4) {

                            scientificDevelopmentTextView.text = "Infrastructure (currently LV4). Icreases ammount of money collected by taxes. (Resourses:5000 and money: 9000 required to upgrade)"


                        } else if (levelScientificDevelopment == 5) {

                            scientificDevelopmentTextView.text = "Infrastructure LV 5"

                        }










                        if (levelSpionage == 2) {

                            spionageTextView.text = "Infrastructure (currently LV2). Icreases ammount of money collected by taxes. (Resourses:450 and money: 800 required to upgrade)"


                        } else if (levelSpionage == 3) {

                            spionageTextView.text = "Infrastructure (currently LV3). Icreases ammount of money collected by taxes. (Resourses:1200 and money: 1600 required to upgrade)"


                        } else if (levelSpionage == 4) {

                            spionageTextView.text = "Infrastructure (currently LV4). Icreases ammount of money collected by taxes. (Resourses:5000 and money: 9000 required to upgrade)"


                        } else if (levelSpionage == 5) {

                            spionageTextView.text = "Infrastructure LV 5"

                        }










                    }
                }
            }


















        upgradeInfArrow.setOnClickListener {

            if (levelInfrastructure == 1 && moneyAmmount >= 150 && resoursces >= 200) {

                infrastructureTextView.text = "Infrastructure (currently LV2). Icreases ammount of money collected by taxes. (Resourses:450 and money: 800 required to upgrade)"
                moneyAmmount -= 150
                resoursces -= 200
                levelInfrastructure += 1

                savePlayerData()

            } else if (levelInfrastructure == 2 && moneyAmmount >= 800 && resoursces >= 450) {

                infrastructureTextView.text = "Infrastructure (currently LV3). Icreases ammount of money collected by taxes. (Resourses:1200 and money: 1600 required to upgrade)"
                moneyAmmount -= 800
                resoursces -= 450
                levelInfrastructure += 1

                savePlayerData()

            } else if (levelInfrastructure == 3 && moneyAmmount >= 2400 && resoursces >= 1200) {

                infrastructureTextView.text = "Infrastructure (currently LV4). Icreases ammount of money collected by taxes. (Resourses:4000 and money: 6000 required to upgrade)"
                moneyAmmount -= 2400
                resoursces -= 1200
                levelInfrastructure += 1

                savePlayerData()

            } else if (levelInfrastructure == 4 && moneyAmmount >= 6000 && resoursces >= 4000) {

                infrastructureTextView.text = "Infrastructure LV5"
                moneyAmmount -= 6000
                resoursces -= 4000
                levelInfrastructure += 1

                savePlayerData()

            }







        }









        upgradeFactoryArrow.setOnClickListener {

            if (levelFactory == 1 && moneyAmmount >= 150 && resoursces >= 200) {

                factoryTextView.text = "Infrastructure (currently LV2). Icreases ammount of money collected by taxes. (Resourses:450 and money: 800 required to upgrade)"
                moneyAmmount -= 150
                resoursces -= 200
                levelFactory += 1

                savePlayerData()

            } else if (levelFactory == 2 && moneyAmmount >= 800 && resoursces >= 450) {

                factoryTextView.text = "Infrastructure (currently LV3). Icreases ammount of money collected by taxes. (Resourses:1200 and money: 1600 required to upgrade)"
                moneyAmmount -= 800
                resoursces -= 450
                levelFactory += 1

                savePlayerData()

            } else if (levelFactory == 3 && moneyAmmount >= 2400 && resoursces >= 1200) {

                factoryTextView.text = "Infrastructure (currently LV4). Icreases ammount of money collected by taxes. (Resourses:4000 and money: 6000 required to upgrade)"
                moneyAmmount -= 2400
                resoursces -= 1200
                levelFactory += 1

                savePlayerData()

            } else if (levelFactory == 4 && moneyAmmount >= 6000 && resoursces >= 4000) {

                factoryTextView.text = "Infrastructure LV5"
                moneyAmmount -= 6000
                resoursces -= 4000
                levelFactory += 1

                savePlayerData()

            }







        }







        upgradeMilitaryBaseArrow.setOnClickListener {

            if (levelMilitaryBase == 1 && moneyAmmount >= 150 && resoursces >= 200) {

                militaryBaseTextView.text = "Infrastructure (currently LV2). Icreases ammount of money collected by taxes. (Resourses:450 and money: 800 required to upgrade)"
                moneyAmmount -= 150
                resoursces -= 200
                levelMilitaryBase += 1

                savePlayerData()

            } else if (levelMilitaryBase == 2 && moneyAmmount >= 800 && resoursces >= 450) {

                militaryBaseTextView.text = "Infrastructure (currently LV3). Icreases ammount of money collected by taxes. (Resourses:1200 and money: 1600 required to upgrade)"
                moneyAmmount -= 800
                resoursces -= 450
                levelMilitaryBase += 1

                savePlayerData()

            } else if (levelMilitaryBase == 3 && moneyAmmount >= 2400 && resoursces >= 1200) {

                militaryBaseTextView.text = "Infrastructure (currently LV4). Icreases ammount of money collected by taxes. (Resourses:4000 and money: 6000 required to upgrade)"
                moneyAmmount -= 2400
                resoursces -= 1200
                levelMilitaryBase += 1

                savePlayerData()

            } else if (levelMilitaryBase == 4 && moneyAmmount >= 6000 && resoursces >= 4000) {

                militaryBaseTextView.text = "Infrastructure LV5"
                moneyAmmount -= 6000
                resoursces -= 4000
                levelMilitaryBase += 1

                savePlayerData()

            }







        }











        upgradeGeneralDevelopmentArrow.setOnClickListener {

            if (levelGeneralDevelopment == 1 && moneyAmmount >= 150 && resoursces >= 200) {

                generalDevelopmentTextView.text = "Infrastructure (currently LV2). Icreases ammount of money collected by taxes. (Resourses:450 and money: 800 required to upgrade)"
                moneyAmmount -= 150
                resoursces -= 200
                levelGeneralDevelopment += 1

                savePlayerData()

            } else if (levelGeneralDevelopment == 2 && moneyAmmount >= 800 && resoursces >= 450) {

                generalDevelopmentTextView.text = "Infrastructure (currently LV3). Icreases ammount of money collected by taxes. (Resourses:1200 and money: 1600 required to upgrade)"
                moneyAmmount -= 800
                resoursces -= 450
                levelGeneralDevelopment += 1

                savePlayerData()

            }







        }






        upgradeScientificDevelopmentArrow.setOnClickListener {

            if (levelScientificDevelopment == 1 && moneyAmmount >= 150 && resoursces >= 200) {

                scientificDevelopmentTextView.text = "Infrastructure (currently LV2). Icreases ammount of money collected by taxes. (Resourses:450 and money: 800 required to upgrade)"
                moneyAmmount -= 150
                resoursces -= 200
                levelScientificDevelopment += 1

                savePlayerData()

            } else if (levelScientificDevelopment == 2 && moneyAmmount >= 800 && resoursces >= 450) {

                scientificDevelopmentTextView.text = "Infrastructure (currently LV3). Icreases ammount of money collected by taxes. (Resourses:1200 and money: 1600 required to upgrade)"
                moneyAmmount -= 800
                resoursces -= 450
                levelScientificDevelopment += 1

                savePlayerData()

            } else if (levelScientificDevelopment == 3 && moneyAmmount >= 2400 && resoursces >= 1200) {

                scientificDevelopmentTextView.text = "Infrastructure (currently LV4). Icreases ammount of money collected by taxes. (Resourses:4000 and money: 6000 required to upgrade)"
                moneyAmmount -= 2400
                resoursces -= 1200
                levelScientificDevelopment += 1

                savePlayerData()

            } else if (levelScientificDevelopment == 4 && moneyAmmount >= 6000 && resoursces >= 4000) {

                scientificDevelopmentTextView.text = "Infrastructure LV5"
                moneyAmmount -= 6000
                resoursces -= 4000
                levelScientificDevelopment += 1

                savePlayerData()

            }







        }











        upgradeSpionageArrow.setOnClickListener {

            if (levelSpionage == 1 && moneyAmmount >= 150 && resoursces >= 200) {

                spionageTextView.text = "Infrastructure (currently LV2). Icreases ammount of money collected by taxes. (Resourses:450 and money: 800 required to upgrade)"
                moneyAmmount -= 150
                resoursces -= 200
                levelSpionage += 1

                savePlayerData()

            } else if (levelSpionage == 2 && moneyAmmount >= 800 && resoursces >= 450) {

                spionageTextView.text = "Infrastructure (currently LV3). Icreases ammount of money collected by taxes. (Resourses:1200 and money: 1600 required to upgrade)"
                moneyAmmount -= 800
                resoursces -= 450
                levelSpionage += 1

                savePlayerData()

            } else if (levelSpionage == 3 && moneyAmmount >= 2400 && resoursces >= 1200) {

                spionageTextView.text = "Infrastructure (currently LV4). Icreases ammount of money collected by taxes. (Resourses:4000 and money: 6000 required to upgrade)"
                moneyAmmount -= 2400
                resoursces -= 1200
                levelSpionage += 1

                savePlayerData()

            } else if (levelSpionage == 4 && moneyAmmount >= 6000 && resoursces >= 4000) {

                spionageTextView.text = "Infrastructure LV5"
                moneyAmmount -= 6000
                resoursces -= 4000
                levelSpionage += 1

                savePlayerData()

            }







        }
















        developeHomeBackBtn.setOnClickListener {

            val intent = Intent(this, MainActivity :: class.java)
            startActivity(intent)

        }




    }








    override fun onBackPressed() {

        Toast.makeText(this, "This action is not allowed", Toast.LENGTH_SHORT).show()

    }







    fun savePlayerData() {






        var data = playerData(savedMoneyAmount = moneyAmmount, savedResoursesAmount = resoursces,
            savedLevelInfrastructure = levelInfrastructure, savedLevelFactory = levelFactory, savedLevelMilitaryBase= levelMilitaryBase,
            savedLevelGeneralDevelopment = levelGeneralDevelopment, savedLevelScienficResearch = levelScientificDevelopment,
            savedLevelSpionage = levelSpionage, savedSoldierUnitQuantity = soldierQuantity, savedAirplaneUnitQuantity = airplaneQuantity,
            savedCargoPlaneQuantity = cargoplaneQuantity, savedAirplane2UnitQuantity= airplane2Quantity, savedTankUnitQuantity= tankQuantity,
            savedSateliteUnitQuantity= sateliteQuantity)



        database.collection("users").document("User path").collection("Saved data")
            .document("hmkogjk").set(data)


            .addOnCompleteListener {



            }


        moneyAmmount = 0
        resoursces = 0

        levelInfrastructure = 1
        levelFactory = 1
        levelMilitaryBase = 1
        levelGeneralDevelopment = 1
        levelScientificDevelopment = 1
        levelSpionage = 1



    }



}