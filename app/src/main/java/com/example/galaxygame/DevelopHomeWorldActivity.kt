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



    var colonyId1 : Int = 1000
    var colonyResourses1 : Int = 0



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

                        colonyId1 = savedDataOfUser.colonyId1
                        colonyResourses1 = savedDataOfUser.colonyResourses1






                        // Displays the saved state and values of the views


                        Log.d("!!!", "$levelInfrastructure")

                        if (levelInfrastructure == 2) {

                            infrastructureTextView.text = "Infrastructure (LV2), + 2 money per s. Next upgrade + 5 money per s. Cost: 1000 money, 1000 resourses."


                        } else if (levelInfrastructure == 3) {

                            infrastructureTextView.text = "Infrastructure (LV3), + 5 money per s. Next upgrade + 10 money per s. Cost: 4500 money, 4500 resourses (general dev. LV 2 required)"


                        } else if (levelInfrastructure == 4) {

                            infrastructureTextView.text = "Infrastructure (LV4), + 10 money per s. Next upgrade + 50 money per s. Cost: 20000 money, 20000 resourses (general dev. LV 3 required)"


                        } else if (levelInfrastructure == 5) {

                            infrastructureTextView.text = "Infrastructure LV 5"

                        }




                        if (levelFactory == 2) {

                            factoryTextView.text = "Factory LV2, + 2 resourses per s. Next upgrade + 5 resourses per s. Cost: 1000 money, 1000 resourses"


                        } else if (levelFactory == 3) {

                            factoryTextView.text = "Factory LV3, + 5 resourses per s. Next upgrade + 10 resourses per s. Cost: 4500 money, 4500 resourses (general dev. LV 2 required)"

                        } else if (levelFactory == 4) {

                            factoryTextView.text = "Factory LV4, + 10 resourses per s. Next upgrade + 50 resourses per s. Cost: 20000 money, 15000 resourses (general dev. LV 3 required)"


                        } else if (levelFactory == 5) {

                            factoryTextView.text = "Factory LV 5"

                        }








                        if (levelMilitaryBase == 2) {

                            militaryBaseTextView.text = "Military base LV2. Unlocks new troops and levels up old ones. Next level cost: 3000 money, 2000 resourses (general dev. LV 2 required)"


                        } else if (levelMilitaryBase == 3) {

                            militaryBaseTextView.text = "Military base LV3. Unlocks new troops and levels up old ones. Next level cost: 20000 money, 15000 resourses"


                        } else if (levelMilitaryBase == 4) {

                            militaryBaseTextView.text = "Military base LV4. Unlocks new troops and levels up old ones. Next level cost: 40000 money, 40000 resourses (general dev. LV 3 required)"


                        } else if (levelMilitaryBase == 5) {

                            militaryBaseTextView.text = "Military base LV 5"

                        }










                        if (levelGeneralDevelopment == 2) {

                            generalDevelopmentTextView.text = "General Development of world LV2. Unlocks new structures and modernises the worlds design. Cost: 80000 money, 60000 resourses (science LV 5 required)"


                        } else if (levelGeneralDevelopment == 3) {

                            generalDevelopmentTextView.text = "General development LV3"

                        }






                        if (levelScientificDevelopment == 2) {

                            scientificDevelopmentTextView.text = "Scientific research LV2. Allow to travel further in space. Cost: money 800, reourses 450 (general dev. LV 2 required)"


                        } else if (levelScientificDevelopment == 3) {

                            scientificDevelopmentTextView.text = "Scientific research LV3. Allow to travel further in space. Cost: money 10000, reourses 10000"


                        } else if (levelScientificDevelopment == 4) {

                            scientificDevelopmentTextView.text = "Scientific research LV4. Allow to travel further in space. Cost: money 15000, reourses 15000"


                        } else if (levelScientificDevelopment == 5) {

                            scientificDevelopmentTextView.text = "Scientific research LV 5"

                        }










                        if (levelSpionage == 2) {

                            spionageTextView.text = "Spionage LV2. Improves chance of spying without being detected. Cost: money 4000, resourses 4000 (general dev. LV 2 required)"


                        } else if (levelSpionage == 3) {

                            spionageTextView.text = "Spionage LV3. Improves chance of spying without being detected. Cost: money 10000, resourses 10000"


                        } else if (levelSpionage == 4) {

                            spionageTextView.text = "Spionage LV4. Improves chance of spying without being detected. Cost: money 40000, resourses 40000"


                        } else if (levelSpionage == 5) {

                            spionageTextView.text = "Spionage LV 5"

                        }










                    }
                }
            }


















        upgradeInfArrow.setOnClickListener {

            if (levelInfrastructure == 1 && moneyAmmount >= 200 && resoursces >= 200) {

                infrastructureTextView.text = "Infrastructure (LV2), + 2 money per s. Next upgrade + 5 money per s. Cost: 1000 money, 1000 resourses"
                moneyAmmount -= 200
                resoursces -= 200
                levelInfrastructure += 1

                savePlayerData()

            } else if (levelInfrastructure == 2 && moneyAmmount >= 1000 && resoursces >= 1000) {

                infrastructureTextView.text = "Infrastructure (LV3), + 5 money per s. Next upgrade + 10 money per s. Cost: 4500 money, 4500 resourses"
                moneyAmmount -= 1000
                resoursces -= 1000
                levelInfrastructure += 1

                savePlayerData()

            } else if (levelInfrastructure == 3 && moneyAmmount >= 4500 && resoursces >= 4500 && levelGeneralDevelopment >= 2) {

                infrastructureTextView.text = "Infrastructure (LV4), + 10 money per s. Next upgrade + 50 money per s. Cost: 20000 money, 20000 resourses"
                moneyAmmount -= 4500
                resoursces -= 4500
                levelInfrastructure += 1

                savePlayerData()

            } else if (levelInfrastructure == 4 && moneyAmmount >= 20000 && resoursces >= 20000 && levelGeneralDevelopment >= 3) {

                infrastructureTextView.text = "Infrastructure LV5"
                moneyAmmount -= 20000
                resoursces -= 20000
                levelInfrastructure += 1

                savePlayerData()

            }







        }









        upgradeFactoryArrow.setOnClickListener {

            if (levelFactory == 1 && moneyAmmount >= 200 && resoursces >= 200) {

                factoryTextView.text = "Factory LV2, + 2 resourses per s. Next upgrade + 5 resourses per s. Cost: 1000 money, 1000 resourses"
                moneyAmmount -= 200
                resoursces -= 200
                levelFactory += 1

                savePlayerData()

            } else if (levelFactory == 2 && moneyAmmount >= 1000 && resoursces >= 1000) {

                factoryTextView.text = "Factory LV3, + 5 resourses per s. Next upgrade + 10 resourses per s. Cost: 4500 money, 4500 resourses"
                moneyAmmount -= 1000
                resoursces -= 1000
                levelFactory += 1

                savePlayerData()

            } else if (levelFactory == 3 && moneyAmmount >= 4500 && resoursces >= 4500 && levelGeneralDevelopment >= 2) {

                factoryTextView.text = "Factory LV4, + 10 resourses per s. Next upgrade + 50 resourses per s. Cost: 20000 money, 15000 resourses"
                moneyAmmount -= 4500
                resoursces -= 4500
                levelFactory += 1

                savePlayerData()

            } else if (levelFactory == 4 && moneyAmmount >= 20000 && resoursces >= 15000 && levelGeneralDevelopment >= 3) {

                factoryTextView.text = "Factory LV5"
                moneyAmmount -= 6000
                resoursces -= 4000
                levelFactory += 1

                savePlayerData()

            }







        }







        upgradeMilitaryBaseArrow.setOnClickListener {

            if (levelMilitaryBase == 1 && moneyAmmount >= 300 && resoursces >= 200) {

                militaryBaseTextView.text = "Military base LV2. Unlocks new troops and levels up old ones. Next level cost: 3000 money, 2000 resourses (general dev. LV 2 required)"
                moneyAmmount -= 300
                resoursces -= 200
                levelMilitaryBase += 1

                savePlayerData()

            } else if (levelMilitaryBase == 2 && moneyAmmount >= 3000 && resoursces >= 2000 && levelGeneralDevelopment >= 2) {

                militaryBaseTextView.text = "Military base LV3. Unlocks new troops and levels up old ones. Next level cost: 20000 money, 15000 resourses"
                moneyAmmount -= 3000
                resoursces -= 2000
                levelMilitaryBase += 1

                savePlayerData()

            } else if (levelMilitaryBase == 3 && moneyAmmount >= 20000 && resoursces >= 15000) {

                militaryBaseTextView.text = "Military base LV4. Unlocks new troops and levels up old ones. Next level cost: 40000 money, 40000 resourses (general dev. LV 3 required)"
                moneyAmmount -= 20000
                resoursces -= 15000
                levelMilitaryBase += 1

                savePlayerData()

            } else if (levelMilitaryBase == 4 && moneyAmmount >= 40000 && resoursces >= 40000 && levelGeneralDevelopment >= 3) {

                militaryBaseTextView.text = "Military base LV 5"
                moneyAmmount -= 40000
                resoursces -= 40000
                levelMilitaryBase += 1

                savePlayerData()

            }







        }











        upgradeGeneralDevelopmentArrow.setOnClickListener {

            if (levelGeneralDevelopment == 1 && moneyAmmount >= 3000 && resoursces >= 3000) {

                generalDevelopmentTextView.text = "General Development of world LV2. Unlocks new structures and modernises the worlds design. Cost: 80000 money, 60000 resourses (science LV 5 required)"
                moneyAmmount -= 3000
                resoursces -= 3000
                levelGeneralDevelopment += 1

                savePlayerData()

            } else if (levelGeneralDevelopment == 2 && moneyAmmount >= 80000 && resoursces >= 60000
                && levelScientificDevelopment == 5) {

                generalDevelopmentTextView.text = "General Development of world LV3"
                moneyAmmount -= 80000
                resoursces -= 60000
                levelGeneralDevelopment += 1

                savePlayerData()

            }







        }






        upgradeScientificDevelopmentArrow.setOnClickListener {

            if (levelScientificDevelopment == 1 && moneyAmmount >= 150 && resoursces >= 150) {

                scientificDevelopmentTextView.text = "Scientific research LV2. Allow to travel further in space. Cost: money 800, reourses 450 (general dev. LV 2 required)"
                moneyAmmount -= 150
                resoursces -= 150
                levelScientificDevelopment += 1

                savePlayerData()

            } else if (levelScientificDevelopment == 2 && moneyAmmount >= 800 && resoursces >= 450 && levelGeneralDevelopment >= 2) {

                scientificDevelopmentTextView.text = "Scientific research LV3. Allow to travel further in space. Cost: money 10000, reourses 10000"
                moneyAmmount -= 800
                resoursces -= 450
                levelScientificDevelopment += 1

                savePlayerData()

            } else if (levelScientificDevelopment == 3 && moneyAmmount >= 10000 && resoursces >= 10000) {

                scientificDevelopmentTextView.text = "Scientific research LV4. Allow to travel further in space. Cost: money 15000, reourses 15000"
                moneyAmmount -= 10000
                resoursces -= 10000
                levelScientificDevelopment += 1

                savePlayerData()

            } else if (levelScientificDevelopment == 4 && moneyAmmount >= 15000 && resoursces >= 15000) {

                scientificDevelopmentTextView.text = "Scientific research LV5"
                moneyAmmount -= 15000
                resoursces -= 15000
                levelScientificDevelopment += 1

                savePlayerData()

            }







        }











        upgradeSpionageArrow.setOnClickListener {

            if (levelSpionage == 1 && moneyAmmount >= 100 && resoursces >= 100) {

                spionageTextView.text = "Spionage LV2. Improves chance of spying without being detected. Cost: money 4000, resourses 4000 (general dev. LV 2 required)"
                moneyAmmount -= 100
                resoursces -= 100
                levelSpionage += 1

                savePlayerData()

            } else if (levelSpionage == 2 && moneyAmmount >= 4000 && resoursces >= 4000 && levelGeneralDevelopment >= 2) {

                spionageTextView.text = "Spionage LV3. Improves chance of spying without being detected. Cost: money 10000, resourses 10000"
                moneyAmmount -= 4000
                resoursces -= 4000
                levelSpionage += 1

                savePlayerData()

            } else if (levelSpionage == 3 && moneyAmmount >= 10000 && resoursces >= 10000) {

                spionageTextView.text = "Spionage LV4. Improves chance of spying without being detected. Cost: money 40000, resourses 40000"
                moneyAmmount -= 10000
                resoursces -= 10000
                levelSpionage += 1

                savePlayerData()

            } else if (levelSpionage == 4 && moneyAmmount >= 40000 && resoursces >= 40000) {

                spionageTextView.text = "Spionage LV5"
                moneyAmmount -= 40000
                resoursces -= 40000
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
            savedSateliteUnitQuantity= sateliteQuantity, colonyId1 = colonyId1,
            colonyResourses1 = colonyResourses1)



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