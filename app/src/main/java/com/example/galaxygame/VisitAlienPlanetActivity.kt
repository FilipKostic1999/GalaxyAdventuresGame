package com.example.galaxygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.firestore.model.FieldIndex
import com.google.firebase.ktx.Firebase
import java.util.*

class VisitAlienPlanetActivity : AppCompatActivity() {


    lateinit var nameOfAlienTxt : TextView
    lateinit var spyArmyTextView : TextView
    lateinit var pictureofAlien : ImageView
    lateinit var attackImg : ImageView
    lateinit var explosionPic : ImageView





    var moneyAmount : Int = 0
    var resoursesAmount : Int = 0
    var levelInfrastructure : Int = 1
    var levelFactory : Int = 1
    var levelMilitaryBase : Int = 1
    var levelGeneralDevelopment : Int = 1
    var levelScientificDevelopment : Int = 1
    var spionageLevelPlayer : Int = 1
    var isDamagedAlivePlayer : Double = 2.0


    var soldierQuantity : Double = 100.0
    var airplaneQuantity : Double = 40.0
    var cargoplaneQuantity : Double = 10.0
    var airplane2Quantity : Double = 0.0
    var tankQuantity : Double = 0.0
    var sateliteQuantity : Double = 0.0



    var messageText : String = ""
    var calculator : Int = 0
    var SelectedPlanetV : Int = 0
    lateinit var savedMessages : messages













    var AlienCiv1Name : String? = null
    var AlienCiv1Picture : Int? = null
    var AlienCiv1Soldiers : Double? = null
    var AlienCiv1SpacePlanes : Double? = null
    var AlienCiv1SpaceJets : Double? = null
    var AlienCiv1Tanks : Double? = null
    var AlienCiv1NuclearSatelites : Double? = null
    var AlienCiv1MilitaryBase : Double? = null
    var isAlienCiv1Damaged : Double? = null
    var alienCiv1RelationWithPlayer : Double? = null


    var AlienCiv2Name : String? = null
    var AlienCiv2Picture : Int? = null
    var AlienCiv2Soldiers : Double? = null
    var AlienCiv2SpacePlanes : Double? = null
    var AlienCiv2SpaceJets : Double? = null
    var AlienCiv2Tanks : Double? = null
    var AlienCiv2NuclearSatelites : Double? = null
    var AlienCiv2MilitaryBase : Double? = null
    var isAlienCiv2Damaged : Double? = null
    var alienCiv2RelationWithPlayer : Double? = null








    var alienMilitaryBase : Double? = null
    var civilisationSpies = (1..2).shuffled().last()
    lateinit var savedDataOfUser : playerData







    lateinit var savedDataOfAliens : aliens
    lateinit var database : FirebaseFirestore
    lateinit var visitAlienWorldLayout : ConstraintLayout


    lateinit var spyBtn : ImageView
    lateinit var strikeWithNuclearSatelitesBtn : ImageView
    lateinit var strikeBtn : Button
    lateinit var nuclearSateliteImg : ImageView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visit_alien_planet)


        visitAlienWorldLayout = findViewById(R.id.visitAlienWorldLayout)
        nameOfAlienTxt = findViewById(R.id.nameOfAlienTxt)
        pictureofAlien = findViewById(R.id.pictureOfAlien)
        attackImg = findViewById(R.id.attackImg)
        spyArmyTextView = findViewById(R.id.spyArmyTextView)
        spyBtn = findViewById(R.id.spyBtn)
        strikeWithNuclearSatelitesBtn = findViewById(R.id.strikeWithNuclearSatelitesBtn)
        nuclearSateliteImg = findViewById(R.id.nuclearSateliteImg)
        strikeBtn = findViewById(R.id.strikeBtn)
        explosionPic = findViewById(R.id.explosionPic)






        database = Firebase.firestore


        strikeBtn.isVisible = false
        strikeBtn.isEnabled = false
        nuclearSateliteImg.isVisible = false


        explosionPic.isVisible = false



        val sharedNewMessageNotify = getSharedPreferences("NewMessageNotify", AppCompatActivity.MODE_PRIVATE)
        var NewMessageNotify = sharedNewMessageNotify.getBoolean("NewMessageNotify", false)


        val sharedSelectedPlanet = getSharedPreferences("SelectedPlanet", AppCompatActivity.MODE_PRIVATE)
        var SelectedPlanet = sharedSelectedPlanet.getInt("SelectedPlanet", 0)


        SelectedPlanetV = SelectedPlanet




        var isPlayerSpied = (1..5).shuffled().last()

        var skipFirs : Int = 0





        database.collection("users").document("User path")
            .collection("Saved data")

            .addSnapshotListener { snapshot, e ->
                if (snapshot != null) {
                    for (document in snapshot.documents) {

                        savedDataOfUser = document.toObject()!!

                        moneyAmount = savedDataOfUser.savedMoneyAmount
                        resoursesAmount = savedDataOfUser.savedResoursesAmount
                        levelInfrastructure = savedDataOfUser.savedLevelInfrastructure
                        levelFactory = savedDataOfUser.savedLevelFactory
                        levelMilitaryBase = savedDataOfUser.savedLevelMilitaryBase
                        levelGeneralDevelopment = savedDataOfUser.savedLevelGeneralDevelopment
                        levelScientificDevelopment = savedDataOfUser.savedLevelScienficResearch
                        spionageLevelPlayer = savedDataOfUser.savedLevelSpionage


                        soldierQuantity = savedDataOfUser.savedSoldierUnitQuantity
                        airplaneQuantity = savedDataOfUser.savedAirplaneUnitQuantity
                        cargoplaneQuantity = savedDataOfUser.savedCargoPlaneQuantity
                        airplane2Quantity = savedDataOfUser.savedAirplane2UnitQuantity
                        tankQuantity = savedDataOfUser.savedTankUnitQuantity
                        sateliteQuantity = savedDataOfUser.savedSateliteUnitQuantity


                        isDamagedAlivePlayer = savedDataOfUser.isDamagedAlive



                    }
                }
            }















        database.collection("users").document("User path")
            .collection("Saved aliens data")

            .addSnapshotListener { snapshot, e ->
                if (snapshot != null) {
                    for (document in snapshot.documents) {

                        savedDataOfAliens = document.toObject()!!




                            // Fetches the data of first civilisation in galaxy

                            AlienCiv1Name = savedDataOfAliens.nameAlienRace1
                            AlienCiv1Picture = savedDataOfAliens.pictureAlienRace1
                            AlienCiv1Soldiers = savedDataOfAliens.soldiersAlienRace1
                            AlienCiv1SpacePlanes = savedDataOfAliens.spacePlanesAlienRace1
                            AlienCiv1SpaceJets = savedDataOfAliens.spaceJetsAlienRace1
                            AlienCiv1Tanks = savedDataOfAliens.tanksAlienRace1
                            AlienCiv1NuclearSatelites = savedDataOfAliens.nuclearSatelitesAlienRace1
                            AlienCiv1MilitaryBase = savedDataOfAliens.militaryBaseAlienRace1

                            isAlienCiv1Damaged = savedDataOfAliens.isAlienRace1Damaged
                            alienCiv1RelationWithPlayer = savedDataOfAliens.alienRace1RelationWithPlayer






                        if (SelectedPlanet == 1) {

                            // Displays name and picture of alien based on number

                            nameOfAlienTxt.text = "$AlienCiv1Name"


                            if (AlienCiv1Picture == 1) {
                                pictureofAlien.setImageResource(R.drawable.alien1)
                            } else if (AlienCiv1Picture == 2) {
                                pictureofAlien.setImageResource(R.drawable.sporealientwo)
                            } else if (AlienCiv1Picture == 3) {
                                pictureofAlien.setImageResource(R.drawable.alien3)
                            } else if (AlienCiv1Picture == 4) {
                                pictureofAlien.setImageResource(R.drawable.alien4)
                            }


                            if (isAlienCiv1Damaged!! <= 0) {
                                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.destoiedplanet)
                            } else if (isAlienCiv1Damaged!! == 1.0) {
                                explosionPic.isVisible = true
                            }




                        }





                            // Fetches the data of second civilisation in galaxy

                            AlienCiv2Name = savedDataOfAliens.nameAlienRace2
                            AlienCiv2Picture = savedDataOfAliens.pictureAlienRace2
                            AlienCiv2Soldiers = savedDataOfAliens.soldiersAlienRace2
                            AlienCiv2SpacePlanes = savedDataOfAliens.spacePlanesAlienRace2
                            AlienCiv2SpaceJets = savedDataOfAliens.spaceJetsAlienRace2
                            AlienCiv2Tanks = savedDataOfAliens.tanksAlienRace2
                            AlienCiv2NuclearSatelites = savedDataOfAliens.nuclearSatelitesAlienRace2
                            AlienCiv2MilitaryBase = savedDataOfAliens.militaryBaseAlienRace2

                            isAlienCiv2Damaged = savedDataOfAliens.isAlienRace2Damaged
                            alienCiv2RelationWithPlayer = savedDataOfAliens.alienRace2RelationWithPlayer











                        if (SelectedPlanet == 2) {


                            // Displays name and picture of alien based on number

                            nameOfAlienTxt.text = "$AlienCiv2Name"


                            if (AlienCiv2Picture == 1) {
                                pictureofAlien.setImageResource(R.drawable.alien1)
                            } else if (AlienCiv2Picture == 2) {
                                pictureofAlien.setImageResource(R.drawable.sporealientwo)
                            } else if (AlienCiv2Picture == 3) {
                                pictureofAlien.setImageResource(R.drawable.alien3)
                            } else if (AlienCiv2Picture == 4) {
                                pictureofAlien.setImageResource(R.drawable.alien4)
                            }



                            if (isAlienCiv2Damaged!! <= 0) {
                                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.destoiedplanet)
                            } else if (isAlienCiv2Damaged!! == 1.0) {
                                explosionPic.isVisible = true
                            }


















                        }



                    }
                }
            }











        // Snapshot of messages


        database.collection("users").document("User path")
            .collection("Messages")

            .addSnapshotListener { snapshot, e ->
                if (snapshot != null) {
                    for (document in snapshot.documents) {

                        savedMessages = document.toObject()!!

                        calculator += savedMessages.constantNumber






                    }
                }
            }






        Timer().scheduleAtFixedRate( object : TimerTask() {
            override fun run () {



                // Is player spied


                if (isPlayerSpied == 3 && skipFirs == 1) {


                    // Alien 1


                    if (isAlienCiv1Damaged!! > 0 && civilisationSpies == 1) {


                        if (alienCiv1RelationWithPlayer!! > 0) {
                            alienCiv1RelationWithPlayer = alienCiv1RelationWithPlayer!! - 1.0
                        }

                        alienSpiesPlayerMessage()
                        saveAlienData()



                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()
                    }



                    // Alien 2

                    if (isAlienCiv2Damaged!! > 0 && civilisationSpies == 2) {


                        if (alienCiv2RelationWithPlayer!! > 0) {
                            alienCiv2RelationWithPlayer = alienCiv2RelationWithPlayer!! - 1.0
                        }

                        alienSpiesPlayerMessage()
                        saveAlienData()



                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()
                    }



                }


                skipFirs ++
            }
        }, 0, 1000)


















        attackImg.setOnClickListener {

            // Alien 1

            if (SelectedPlanet == 1 && isAlienCiv1Damaged!! > 0) {

                val intent = Intent(this, WarSimulatorActivity :: class.java)
                startActivity(intent)

            } else if (SelectedPlanet == 1 && isAlienCiv1Damaged!! <= 0) {

                Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()

            }


            // Alien 2


            if (SelectedPlanet == 2 && isAlienCiv2Damaged!! > 0) {

                val intent = Intent(this, WarSimulatorActivity :: class.java)
                startActivity(intent)

            } else if (SelectedPlanet == 2 && isAlienCiv2Damaged!! <= 0) {

                Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()

            }



        }





        strikeWithNuclearSatelitesBtn.setOnClickListener {

            strikeBtn.isVisible = true
            strikeBtn.isEnabled = true
            nuclearSateliteImg.isVisible = true



        }










        strikeBtn.setOnClickListener {



            if (sateliteQuantity > 0) {



                // Alien civilisation 1


                if (SelectedPlanet == 1 && isAlienCiv1Damaged!! > 0) { // Alien 1

                    if(levelMilitaryBase < 5) {

                        isAlienCiv1Damaged = isAlienCiv1Damaged!! - 1.0
                        alienCiv1RelationWithPlayer = 0.0

                    } else if (levelMilitaryBase == 5) {

                        isAlienCiv1Damaged = isAlienCiv1Damaged!! - 2.0
                        alienCiv1RelationWithPlayer = 0.0

                    }



                    sateliteQuantity -= 1

                    Toast.makeText(this, "You struck this civilisation with a rain of nuclear missiles", Toast.LENGTH_SHORT).show()





                    if (AlienCiv1NuclearSatelites!! > 0.0) {

                        AlienCiv1NuclearSatelites = AlienCiv1NuclearSatelites!! - 1.0
                        isDamagedAlivePlayer = isDamagedAlivePlayer - 1.0

                        Toast.makeText(this, "You were struck back by the aliens nuclear satelites", Toast.LENGTH_SHORT).show()

                        nuclearAttackMessage()

                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()

                    } else if (AlienCiv1NuclearSatelites!! <= 0) {
                        failedNuclearResponseMessage()

                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()
                    }



                } else if (SelectedPlanet == 1 && isAlienCiv1Damaged!! <= 0) {

                    Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()

                }




                // Alien civilisation 2




                if (SelectedPlanet == 2 && isAlienCiv2Damaged!! > 0) { // Alien 2

                    if(levelMilitaryBase < 5) {

                        isAlienCiv2Damaged = isAlienCiv2Damaged!! - 1.0
                        alienCiv2RelationWithPlayer = 0.0

                    } else if (levelMilitaryBase == 5) {

                        isAlienCiv2Damaged = isAlienCiv2Damaged!! - 2.0
                        alienCiv2RelationWithPlayer = 0.0

                    }


                    sateliteQuantity -= 1

                    Toast.makeText(this, "You struck this civilisation with a rain of nuclear missiles", Toast.LENGTH_SHORT).show()



                    if (AlienCiv2NuclearSatelites!! > 0.0) {

                        AlienCiv2NuclearSatelites = AlienCiv2NuclearSatelites!! - 1.0
                        isDamagedAlivePlayer = isDamagedAlivePlayer - 1.0

                        Toast.makeText(this, "You were struck back by the aliens nuclear satelites", Toast.LENGTH_SHORT).show()

                        nuclearAttackMessage()

                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()

                    }  else if (AlienCiv2NuclearSatelites!! <= 0) {
                        failedNuclearResponseMessage()

                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()
                    }


                } else if (SelectedPlanet == 2 && isAlienCiv2Damaged!! <= 0) {

                    Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()

                }




                savePlayerData()
                saveAlienData()


            }



        }














        spyBtn.setOnClickListener {


            if (SelectedPlanet == 1 && isAlienCiv1Damaged!! > 0) {

                var spied = (1..5).shuffled().last()

                if(spied <= spionageLevelPlayer) {

                    if (AlienCiv1MilitaryBase == 1.0) {

                        spyArmyTextView.text = "Soldiers LV1: $AlienCiv1Soldiers,  Space planes LV1: $AlienCiv1SpacePlanes,  Tanks LV1: $AlienCiv1Tanks,  Space Jets LV1: $AlienCiv1SpaceJets,  Nuclear satelites LV1: $AlienCiv1NuclearSatelites"

                    } else if (AlienCiv1MilitaryBase == 2.0) {

                        spyArmyTextView.text = "Soldiers LV2: $AlienCiv1Soldiers,  Space planes LV1: $AlienCiv1SpacePlanes,  Tanks LV1: $AlienCiv1Tanks,  Space Jets LV1: $AlienCiv1SpaceJets,  Nuclear satelites LV1: $AlienCiv1NuclearSatelites"

                    } else if (AlienCiv1MilitaryBase == 3.0) {

                        spyArmyTextView.text = "Soldiers LV2: $AlienCiv1Soldiers,  Space planes LV1: $AlienCiv1SpacePlanes,  Tanks LV1: $AlienCiv1Tanks,  Space Jets LV1: $AlienCiv1SpaceJets,  Nuclear satelites LV1: $AlienCiv1NuclearSatelites"

                    } else if (AlienCiv1MilitaryBase == 4.0) {

                        spyArmyTextView.text = "Soldiers LV3: $AlienCiv1Soldiers,  Space planes LV1: $AlienCiv1SpacePlanes,  Tanks LV2: $AlienCiv1Tanks,  Space Jets LV1: $AlienCiv1SpaceJets,  Nuclear satelites LV1: $AlienCiv1NuclearSatelites"


                    } else if (AlienCiv1MilitaryBase == 5.0) {

                        spyArmyTextView.text = "Soldiers LV3: $AlienCiv1Soldiers,  Space planes LV1: $AlienCiv1SpacePlanes,  Tanks LV2: $AlienCiv1Tanks,  Space Jets LV1: $AlienCiv1SpaceJets,  Nuclear satelites LV2: $AlienCiv1NuclearSatelites"

                    }


                    Toast.makeText(this, "Your spy reported the numbers in alien army", Toast.LENGTH_SHORT).show()




                } else {

                    Toast.makeText(this, "Your spy has been captured, this will have consequences", Toast.LENGTH_SHORT).show()

                    if (alienCiv1RelationWithPlayer!! > 0) {
                        alienCiv1RelationWithPlayer = alienCiv1RelationWithPlayer!! - 1.0
                    }

                    spionageDiscoveredMessage()
                    saveAlienData()

                    NewMessageNotify = true

                    val editNewMessageNotify = sharedNewMessageNotify.edit()
                    editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                    editNewMessageNotify.commit()

                }


            } else if (SelectedPlanet == 1 && isAlienCiv1Damaged!! <= 0) {

                Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()


            } // Alien 1








            if (SelectedPlanet == 2 && isAlienCiv2Damaged!! > 0) {

                var spied = (1..5).shuffled().last()

                if(spied <= spionageLevelPlayer) {

                    if (AlienCiv2MilitaryBase == 1.0) {

                        spyArmyTextView.text = "Soldiers LV1: $AlienCiv2Soldiers,  Space planes LV1: $AlienCiv2SpacePlanes,  Tanks LV1: $AlienCiv2Tanks,  Space Jets LV1: $AlienCiv2SpaceJets,  Nuclear satelites LV1: $AlienCiv2NuclearSatelites"

                    } else if (AlienCiv2MilitaryBase == 2.0) {

                        spyArmyTextView.text = "Soldiers LV2: $AlienCiv2Soldiers,  Space planes LV1: $AlienCiv2SpacePlanes,  Tanks LV1: $AlienCiv2Tanks,  Space Jets LV1: $AlienCiv2SpaceJets,  Nuclear satelites LV1: $AlienCiv2NuclearSatelites"

                    } else if (AlienCiv2MilitaryBase == 3.0) {

                        spyArmyTextView.text = "Soldiers LV2: $AlienCiv2Soldiers,  Space planes LV1: $AlienCiv2SpacePlanes,  Tanks LV1: $AlienCiv2Tanks,  Space Jets LV1: $AlienCiv2SpaceJets,  Nuclear satelites LV1: $AlienCiv2NuclearSatelites"

                    } else if (AlienCiv2MilitaryBase == 4.0) {

                        spyArmyTextView.text = "Soldiers LV3: $AlienCiv2Soldiers,  Space planes LV1: $AlienCiv2SpacePlanes,  Tanks LV2: $AlienCiv2Tanks,  Space Jets LV1: $AlienCiv2SpaceJets,  Nuclear satelites LV1: $AlienCiv2NuclearSatelites"


                    } else if (AlienCiv2MilitaryBase == 5.0) {

                        spyArmyTextView.text = "Soldiers LV3: $AlienCiv2Soldiers,  Space planes LV1: $AlienCiv2SpacePlanes,  Tanks LV1: $AlienCiv2Tanks,  Space Jets LV1: $AlienCiv2SpaceJets,  Nuclear satelites LV2: $AlienCiv2NuclearSatelites"

                    }


                    Toast.makeText(this, "Your spy reported the numbers in alien army", Toast.LENGTH_SHORT).show()




                } else {

                    Toast.makeText(this, "Your spy has been captured, this will have consequences", Toast.LENGTH_SHORT).show()

                   if (alienCiv2RelationWithPlayer!! > 0) {
                       alienCiv2RelationWithPlayer = alienCiv2RelationWithPlayer!! - 1.0
                   }

                    spionageDiscoveredMessage()
                    saveAlienData()

                    NewMessageNotify = true

                    val editNewMessageNotify = sharedNewMessageNotify.edit()
                    editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                    editNewMessageNotify.commit()
                }



            } else if (SelectedPlanet == 2 && isAlienCiv2Damaged!! <= 0) {

                Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()


            } // Alien 2




        }











        // Displays specific alien world based on what planet was selected and recorded by shared pref


        if (SelectedPlanet == 0) {

            visitAlienWorldLayout.background = resources.getDrawable(R.drawable.world0)

        } else if (SelectedPlanet == 1) {

            visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvone)

        } else if (SelectedPlanet == 111) {

            /* Id number of a second visitable planet in the same solar system is the same number of
           the first visitable planet in the system repeated three times
            */

            visitAlienWorldLayout.background = resources.getDrawable(R.drawable.world0)

        } else if (SelectedPlanet == 2) {

            visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvtwo)

        } else if (SelectedPlanet == 3) {

            visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvone)

        } else if (SelectedPlanet == 4) {

            visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvone)

        } else if (SelectedPlanet == 444) {

            visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvone)

        } else if (SelectedPlanet == 5) {

            visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvone)

        } else if (SelectedPlanet == 6) {

            visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvone)

        } else if (SelectedPlanet == 7) {

            visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvone)

        } else if (SelectedPlanet == 777) {

            visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvone)

        } else if (SelectedPlanet == 8) {

            visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvone)

        } else if (SelectedPlanet == 9) {

            visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvone)

        } else if (SelectedPlanet == 999) {

            visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvone)

        } else if (SelectedPlanet == 10) {



        } else if (SelectedPlanet== 101010) {



        } else if (SelectedPlanet==10101010) {



        } else if (SelectedPlanet == 11) {



        } else if (SelectedPlanet == 111111) {



        } else if(SelectedPlanet==12) {



        } else if (SelectedPlanet == 13) {



        }





    }




















    fun alienSpiesPlayerMessage() {


        var spionageMessage = (1..4).shuffled().last()





         // Alien 1

        if (civilisationSpies == 1) {

            if (spionageMessage == 1) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv1Name :  Sorry for sending that spy, we were only curious"
            } else if (spionageMessage == 2) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv1Name :  Your planet is very attractive, and we have many more spies who can confirm that"
            } else if (spionageMessage == 3) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv1Name :  We could react for killing our spy"
            } else if (spionageMessage == 4) {
                messageText = "A spy has been captured in your planet. $AlienCiv1Name :  We are not planning anything bad for you, we sent that spy for prevention"
            }
        }




         // Alien 2


        if (civilisationSpies == 2) {

            if (spionageMessage == 1) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv2Name :  Sorry for sending that spy, we were only curious"
            } else if (spionageMessage == 2) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv2Name :  Your planet is very attractive, and we have many more spies who can confirm that"
            } else if (spionageMessage == 3) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv2Name :  We could react for killing our spy"
            } else if (spionageMessage == 4) {
                messageText = "A spy has been captured in your planet. $AlienCiv2Name :  We are not planning anything bad for you, we sent that spy for prevention"
            }

        }




        var newMessage = messages(messageContent = messageText, isItNewMessage = true, constantNumber = 1,
            docNumber = calculator)



        database.collection("users").document("User path")
            .collection("Messages").add(newMessage)


            .addOnCompleteListener {



            }

        calculator = 0










    }


















  fun  savePlayerData() {

      var data = playerData(savedMoneyAmount = moneyAmount, savedResoursesAmount = resoursesAmount,
          savedLevelInfrastructure = levelInfrastructure, savedLevelFactory = levelFactory, savedLevelMilitaryBase= levelMilitaryBase,
          savedLevelGeneralDevelopment = levelGeneralDevelopment, savedLevelScienficResearch = levelScientificDevelopment,
          savedLevelSpionage = spionageLevelPlayer, savedSoldierUnitQuantity = soldierQuantity, savedAirplaneUnitQuantity = airplaneQuantity,
          savedCargoPlaneQuantity = cargoplaneQuantity, savedAirplane2UnitQuantity= airplane2Quantity, savedTankUnitQuantity= tankQuantity,
          savedSateliteUnitQuantity= sateliteQuantity, isDamagedAlive = isDamagedAlivePlayer)



      database.collection("users").document("User path").collection("Saved data")
          .document("hmkogjk").set(data)


          .addOnCompleteListener {



          }




  }





    fun failedNuclearResponseMessage() {

        var nuclearStrikeMessage = (1..4).shuffled().last()




        if (SelectedPlanetV == 1) { // Alien 1

            if (nuclearStrikeMessage == 1) {
                messageText = "$AlienCiv1Name :  You are lucky we dont have nuclear satelites, we will turn your planet to ash with conventional means you coward"
            } else if (nuclearStrikeMessage == 2) {
                messageText =
                    "$AlienCiv1Name :  We will make you pay for every single palace of ours that you destroyed with that nuclear strike"
            } else if (nuclearStrikeMessage == 3) {
                messageText =
                    "$AlienCiv1Name :  This is a declaration of war, your nuking random civilisations without a reason must be addressed with the right punishment"
            } else if (nuclearStrikeMessage == 4) {
                messageText = "$AlienCiv1Name :  You will payyyyyy for thiiissss buuuaaaaggaaaaaa"
            }

        }




        if (SelectedPlanetV == 2) { // Alien 2

            if (nuclearStrikeMessage == 1) {
                messageText = "$AlienCiv2Name :  You are lucky we dont have nuclear satelites, we will turn your planet to ash with conventional means you coward"
            } else if (nuclearStrikeMessage == 2) {
                messageText = "$AlienCiv2Name :  We will make you pay for every single palace of ours that you destroyed with that nuclear strike"
            } else if (nuclearStrikeMessage == 3) {
                messageText = "$AlienCiv2Name :  This is a declaration of war, your nuking random civilisations without a reason must be addressed with the right punishment"
            } else if (nuclearStrikeMessage == 4) {
                messageText = "$AlienCiv2Name :  You will payyyyyy for thiiissss buuuaaaaggaaaaaa"
            }

        }







        var newMessage = messages(messageContent = messageText, isItNewMessage = true, constantNumber = 1,
            docNumber = calculator)



        database.collection("users").document("User path")
            .collection("Messages").add(newMessage)


            .addOnCompleteListener {



            }

        calculator = 0






    }









    fun spionageDiscoveredMessage() {

        var spionageMessage = (1..4).shuffled().last()




        if (SelectedPlanetV == 1) { // Alien 1

            if (spionageMessage == 1) {
                messageText = "$AlienCiv1Name :  We captured one of your spies, what are you planing?"
            } else if (spionageMessage == 2) {
                messageText =
                    "$AlienCiv1Name :  We had a lot of fun torturing your spy, please send another one"
            } else if (spionageMessage == 3) {
                messageText =
                    "$AlienCiv1Name :  Never dare to try to spy on us again"
            } else if (spionageMessage == 4) {
                messageText = "$AlienCiv1Name :  A few more spies and we end up both in a war"
            }

        }




        if (SelectedPlanetV == 2) { // Alien 2

            if (spionageMessage == 1) {
                messageText = "$AlienCiv2Name :  We captured one of your spies, what are you planing?"
            } else if (spionageMessage == 2) {
                messageText =
                    "$AlienCiv2Name :  We had a lot of fun torturing your spy, please send another one"
            } else if (spionageMessage == 3) {
                messageText =
                    "$AlienCiv2Name :  Never dare to try to spy on us again"
            } else if (spionageMessage == 4) {
                messageText = "$AlienCiv2Name :  A few more spies and we end up both in a war"
            }

        }







        var newMessage = messages(messageContent = messageText, isItNewMessage = true, constantNumber = 1,
            docNumber = calculator)



        database.collection("users").document("User path")
            .collection("Messages").add(newMessage)


            .addOnCompleteListener {



            }

        calculator = 0












    }














    fun nuclearAttackMessage() {

        var nuclearStrikeMessage = (1..4).shuffled().last()




        if (SelectedPlanetV == 1) { // Alien 1

            if (nuclearStrikeMessage == 1) {
                messageText = "$AlienCiv1Name :  If you nuke us, we nuke you right back!"
            } else if (nuclearStrikeMessage == 2) {
                messageText =
                    "$AlienCiv1Name :  We will make you pay for every single palace of ours that you destroyed with that nuclear strike"
            } else if (nuclearStrikeMessage == 3) {
                messageText =
                    "$AlienCiv1Name :  This is a declaration of war, your nuking random civilisations without a reason must be addressed with the right punishment"
            } else if (nuclearStrikeMessage == 4) {
                messageText = "$AlienCiv1Name :  You will payyyyyy for thiiissss buuuaaaaggaaaaaa"
            }

        }




        if (SelectedPlanetV == 2) { // Alien 2

            if (nuclearStrikeMessage == 1) {
                messageText = "$AlienCiv2Name :  If you nuke us, we nuke you right back!"
            } else if (nuclearStrikeMessage == 2) {
                messageText = "$AlienCiv2Name :  We will make you pay for every single palace of ours that you destroyed with that nuclear strike"
            } else if (nuclearStrikeMessage == 3) {
                messageText = "$AlienCiv2Name :  This is a declaration of war, your nuking random civilisations without a reason must be addressed with the right punishment"
            } else if (nuclearStrikeMessage == 4) {
                messageText = "$AlienCiv2Name :  You will payyyyyy for thiiissss buuuaaaaggaaaaaa"
            }

        }







        var newMessage = messages(messageContent = messageText, isItNewMessage = true, constantNumber = 1,
            docNumber = calculator)



        database.collection("users").document("User path")
            .collection("Messages").add(newMessage)


            .addOnCompleteListener {



            }

        calculator = 0






    }


















  fun  saveAlienData() {

      // War with alien 1



          var dataOfAlienCivilisations = aliens(

              // Alien 1
              nameAlienRace1 = AlienCiv1Name,
              pictureAlienRace1 = AlienCiv1Picture,
              militaryBaseAlienRace1 = AlienCiv1MilitaryBase,

              // Army Alien 1
              soldiersAlienRace1 = AlienCiv1Soldiers,
              spacePlanesAlienRace1 = AlienCiv1SpacePlanes,
              spaceJetsAlienRace1 = AlienCiv1SpaceJets,
              tanksAlienRace1 = AlienCiv1Tanks,
              nuclearSatelitesAlienRace1 = AlienCiv1NuclearSatelites,

              // Level damage alien planet 1 and relations
              alienRace1RelationWithPlayer = alienCiv1RelationWithPlayer,
              isAlienRace1Damaged = isAlienCiv1Damaged,


              // Alien 2
              nameAlienRace2 = AlienCiv2Name,
              pictureAlienRace2 = AlienCiv2Picture,
              militaryBaseAlienRace2 = AlienCiv2MilitaryBase,

              // Army Alien 2
              soldiersAlienRace2 = AlienCiv2Soldiers,
              spacePlanesAlienRace2 = AlienCiv2SpacePlanes,
              spaceJetsAlienRace2 = AlienCiv2SpaceJets,
              tanksAlienRace2 = AlienCiv2Tanks,
              nuclearSatelitesAlienRace2 = AlienCiv2NuclearSatelites,

              // Level damage alien planet 1 and relations
              alienRace2RelationWithPlayer = alienCiv2RelationWithPlayer,
              isAlienRace2Damaged = isAlienCiv2Damaged
          )



          database.collection("users").document("User path").collection("Saved aliens data")
              .document("Aliens data").set(dataOfAlienCivilisations)


              .addOnCompleteListener {


              }


      }






















}