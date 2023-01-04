package com.example.galaxygame

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
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
    lateinit var homeWorldExplosion : ImageView
    lateinit var saveGameIcon : ImageView


    lateinit var repairWorldBtn : Button


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
    var isDamagedAlivePlayer : Double = 2.0


    var soldierQuantity : Double = 100.0
    var airplaneQuantity : Double = 40.0
    var cargoplaneQuantity : Double = 10.0
    var airplane2Quantity : Double = 0.0
    var tankQuantity : Double = 0.0
    var sateliteQuantity : Double = 0.0

    var colonyId1 : Int = 1000
    var colonyResourses1 : Int = 0











    // Aliens data before generation of random civilisations in the galaxy


     var AlienCiv1Name : String? = null
     var AlienCiv1Picture : Int? = null
     var AlienCiv1Soldiers : Double? = null
     var AlienCiv1SpacePlanes : Double? = null
     var AlienCiv1SpaceJets : Double? = null
     var AlienCiv1Tanks : Double? = null
     var AlienCiv1NuclearSatelites : Double? = null
     var isAlienCiv1Damaged : Double? = null
     var alienCiv1RelationWithPlayer : Double? = null



     var AlienCiv2Name : String? = null
     var AlienCiv2Picture : Int? = null
     var AlienCiv2Soldiers : Double? = null
     var AlienCiv2SpacePlanes : Double? = null
     var AlienCiv2SpaceJets : Double? = null
     var AlienCiv2Tanks : Double? = null
     var AlienCiv2NuclearSatelites : Double? = null
     var isAlienCiv2Damaged : Double? = null
     var alienCiv2RelationWithPlayer : Double? = null



    var AlienCiv3Name : String? = null
    var AlienCiv3Picture : Int? = null
    var AlienCiv3Soldiers : Double? = null
    var AlienCiv3SpacePlanes : Double? = null
    var AlienCiv3SpaceJets : Double? = null
    var AlienCiv3Tanks : Double? = null
    var AlienCiv3NuclearSatelites : Double? = null
    var isAlienCiv3Damaged : Double? = null
    var alienCiv3RelationWithPlayer : Double? = null





    var AlienCiv4Name : String? = null
    var AlienCiv4Picture : Int? = null
    var AlienCiv4Soldiers : Double? = null
    var AlienCiv4SpacePlanes : Double? = null
    var AlienCiv4SpaceJets : Double? = null
    var AlienCiv4Tanks : Double? = null
    var AlienCiv4NuclearSatelites : Double? = null
    var isAlienCiv4Damaged : Double? = null
    var alienCiv4RelationWithPlayer : Double? = null






    var AlienCiv5Name : String? = null
    var AlienCiv5Picture : Int? = null
    var AlienCiv5Soldiers : Double? = null
    var AlienCiv5SpacePlanes : Double? = null
    var AlienCiv5SpaceJets : Double? = null
    var AlienCiv5Tanks : Double? = null
    var AlienCiv5NuclearSatelites : Double? = null
    var isAlienCiv5Damaged : Double? = null
    var alienCiv5RelationWithPlayer : Double? = null







    var AlienCiv6Name : String? = null
    var AlienCiv6Picture : Int? = null
    var AlienCiv6Soldiers : Double? = null
    var AlienCiv6SpacePlanes : Double? = null
    var AlienCiv6SpaceJets : Double? = null
    var AlienCiv6Tanks : Double? = null
    var AlienCiv6NuclearSatelites : Double? = null
    var isAlienCiv6Damaged : Double? = null
    var alienCiv6RelationWithPlayer : Double? = null




    var AlienCiv7Name : String? = null
    var AlienCiv7Picture : Int? = null
    var AlienCiv7Soldiers : Double? = null
    var AlienCiv7SpacePlanes : Double? = null
    var AlienCiv7SpaceJets : Double? = null
    var AlienCiv7Tanks : Double? = null
    var AlienCiv7NuclearSatelites : Double? = null
    var isAlienCiv7Damaged : Double? = null
    var alienCiv7RelationWithPlayer : Double? = null






    var AlienCiv8Name : String? = null
    var AlienCiv8Picture : Int? = null
    var AlienCiv8Soldiers : Double? = null
    var AlienCiv8SpacePlanes : Double? = null
    var AlienCiv8SpaceJets : Double? = null
    var AlienCiv8Tanks : Double? = null
    var AlienCiv8NuclearSatelites : Double? = null
    var isAlienCiv8Damaged : Double? = null
    var alienCiv8RelationWithPlayer : Double? = null







    var AlienCiv9Name : String? = null
    var AlienCiv9Picture : Int? = null
    var AlienCiv9Soldiers : Double? = null
    var AlienCiv9SpacePlanes : Double? = null
    var AlienCiv9SpaceJets : Double? = null
    var AlienCiv9Tanks : Double? = null
    var AlienCiv9NuclearSatelites : Double? = null
    var isAlienCiv9Damaged : Double? = null
    var alienCiv9RelationWithPlayer : Double? = null






    var AlienCiv10Name : String? = null
    var AlienCiv10Picture : Int? = null
    var AlienCiv10Soldiers : Double? = null
    var AlienCiv10SpacePlanes : Double? = null
    var AlienCiv10SpaceJets : Double? = null
    var AlienCiv10Tanks : Double? = null
    var AlienCiv10NuclearSatelites : Double? = null
    var isAlienCiv10Damaged : Double? = null
    var alienCiv10RelationWithPlayer : Double? = null





    var AlienCiv11Name : String? = null
    var AlienCiv11Picture : Int? = null
    var AlienCiv11Soldiers : Double? = null
    var AlienCiv11SpacePlanes : Double? = null
    var AlienCiv11SpaceJets : Double? = null
    var AlienCiv11Tanks : Double? = null
    var AlienCiv11NuclearSatelites : Double? = null
    var isAlienCiv11Damaged : Double? = null
    var alienCiv11RelationWithPlayer : Double? = null






    var AlienCiv12Name : String? = null
    var AlienCiv12Picture : Int? = null
    var AlienCiv12Soldiers : Double? = null
    var AlienCiv12SpacePlanes : Double? = null
    var AlienCiv12SpaceJets : Double? = null
    var AlienCiv12Tanks : Double? = null
    var AlienCiv12NuclearSatelites : Double? = null
    var isAlienCiv12Damaged : Double? = null
    var alienCiv12RelationWithPlayer : Double? = null






    var AlienCiv13Name : String? = null
    var AlienCiv13Picture : Int? = null
    var AlienCiv13Soldiers : Double? = null
    var AlienCiv13SpacePlanes : Double? = null
    var AlienCiv13SpaceJets : Double? = null
    var AlienCiv13Tanks : Double? = null
    var AlienCiv13NuclearSatelites : Double? = null
    var isAlienCiv13Damaged : Double? = null
    var alienCiv13RelationWithPlayer : Double? = null






    var AlienCiv14Name : String? = null
    var AlienCiv14Picture : Int? = null
    var AlienCiv14Soldiers : Double? = null
    var AlienCiv14SpacePlanes : Double? = null
    var AlienCiv14SpaceJets : Double? = null
    var AlienCiv14Tanks : Double? = null
    var AlienCiv14NuclearSatelites : Double? = null
    var isAlienCiv14Damaged : Double? = null
    var alienCiv14RelationWithPlayer : Double? = null




    var AlienCiv15Name : String? = null
    var AlienCiv15Picture : Int? = null
    var AlienCiv15Soldiers : Double? = null
    var AlienCiv15SpacePlanes : Double? = null
    var AlienCiv15SpaceJets : Double? = null
    var AlienCiv15Tanks : Double? = null
    var AlienCiv15NuclearSatelites : Double? = null
    var isAlienCiv15Damaged : Double? = null
    var alienCiv15RelationWithPlayer : Double? = null







    var AlienCiv16Name : String? = null
    var AlienCiv16Picture : Int? = null
    var AlienCiv16Soldiers : Double? = null
    var AlienCiv16SpacePlanes : Double? = null
    var AlienCiv16SpaceJets : Double? = null
    var AlienCiv16Tanks : Double? = null
    var AlienCiv16NuclearSatelites : Double? = null
    var isAlienCiv16Damaged : Double? = null
    var alienCiv16RelationWithPlayer : Double? = null





    var calculator : Int = 0






    lateinit var savedMessages : messages

    var SelectedPlanetV : Int = 0









    lateinit var redMsgIcon : ImageView



    lateinit var database : FirebaseFirestore
    lateinit var savedDataOfUser : playerData
    lateinit var savedDataOfAliens : aliens
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
        redMsgIcon = findViewById(R.id.redMsgIcon)
        homeWorldExplosion = findViewById(R.id.homeWorldExplosion)
        repairWorldBtn = findViewById(R.id.repairWorldBtn)
        saveGameIcon = findViewById(R.id.saveGameIcon)




        database = Firebase.firestore


        homeWorldExplosion.isVisible = false

        repairWorldBtn.isVisible = false
        repairWorldBtn.isEnabled = false
        saveGameIcon.isEnabled = false
        saveGameIcon.isVisible = false



        // The message icon knows if to turn green or red based on new messages and viewed messages

        val sharedNewMessageNotify = getSharedPreferences("NewMessageNotify", AppCompatActivity.MODE_PRIVATE)
        var NewMessageNotify = sharedNewMessageNotify.getBoolean("NewMessageNotify", false)



        // Selected planet Int matches civilisation number which allows the system to know which alien does an action in game


        val sharedSelectedPlanet = getSharedPreferences("SelectedPlanet", AppCompatActivity.MODE_PRIVATE)
        var SelectedPlanet = sharedSelectedPlanet.getInt("SelectedPlanet", 0)


        // Allows variable SelectedPlanet to be read in functions

        SelectedPlanetV = SelectedPlanet




        if (NewMessageNotify == true) {

            redMsgIcon.setImageResource(R.drawable.messageicon)

        } else if (NewMessageNotify == false) {

            redMsgIcon.setImageResource(R.drawable.redmsgicon)

        }










        // Snapshot of player data


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


                            isDamagedAlivePlayer = savedDataOfUser.isDamagedAlive

                            colonyId1 = savedDataOfUser.colonyId1
                            colonyResourses1 = savedDataOfUser.colonyResourses1




                            Log.d("!!!", "$moneyAmount")







                            // Displays the saved state and values of the views

                            moneyTextView.text = "${savedDataOfUser.savedMoneyAmount} Trilion"
                            resoursesAmountText.text = "${savedDataOfUser.savedResoursesAmount}"







                            if (levelGeneralDevelopment == 2) {

                                containerRl.background = resources.getDrawable(R.drawable.evolvedsecond)

                            } else if (levelGeneralDevelopment == 3) {

                                containerRl.background = resources.getDrawable(R.drawable.developedthree)

                            }






                            // If the homeworld of the player is destroied or damaged


                            if(isDamagedAlivePlayer <= 0) {

                                containerRl.background = resources.getDrawable(R.drawable.destoiedplanet)
                                comandCenterPicture.isEnabled = false
                                factory.isEnabled = false
                                militaryBase.isEnabled = false
                                galaxyView.isEnabled = false
                                collectTaxBtn.isEnabled = false
                                homeWorldExplosion.isVisible = false
                                repairWorldBtn.isVisible = false
                                repairWorldBtn.isEnabled = false
                                saveGameIcon.isVisible = true
                                saveGameIcon.isEnabled = true

                            } else if (isDamagedAlivePlayer == 1.0) {

                                homeWorldExplosion.isVisible = true
                                repairWorldBtn.isVisible = true
                                repairWorldBtn.isEnabled = true

                            } else if (isDamagedAlivePlayer >= 2) {

                                homeWorldExplosion.isVisible = false
                                repairWorldBtn.isVisible = false
                                repairWorldBtn.isEnabled = false

                            }



                        }
                    }
                }








        // Snapshot of alien civilisations data


        database.collection("users").document("User path")
            .collection("Saved aliens data")

            .addSnapshotListener { snapshot, e ->
                if (snapshot != null) {
                    for (document in snapshot.documents) {

                        savedDataOfAliens = document.toObject()!!

                        // Fetches the data of first civilisation in galaxy

                        AlienCiv1Name = savedDataOfAliens.nameAlienRace1
                        AlienCiv1Picture = savedDataOfAliens.pictureAlienRace1
                        alienCiv1RelationWithPlayer = savedDataOfAliens.alienRace1RelationWithPlayer
                        isAlienCiv1Damaged = savedDataOfAliens.isAlienRace1Damaged

                        // Fetches the data of second civilisation in galaxy

                        AlienCiv2Name = savedDataOfAliens.nameAlienRace2
                        AlienCiv2Picture = savedDataOfAliens.pictureAlienRace2
                        alienCiv2RelationWithPlayer = savedDataOfAliens.alienRace1RelationWithPlayer
                        isAlienCiv2Damaged = savedDataOfAliens.isAlienRace2Damaged


                        // Alien 3

                        AlienCiv3Name = savedDataOfAliens.nameAlienRace3
                        AlienCiv3Picture = savedDataOfAliens.pictureAlienRace3
                        alienCiv3RelationWithPlayer = savedDataOfAliens.alienRace3RelationWithPlayer
                        isAlienCiv3Damaged = savedDataOfAliens.isAlienRace3Damaged


                        // alien 4

                        AlienCiv4Name = savedDataOfAliens.nameAlienRace4
                        AlienCiv4Picture = savedDataOfAliens.pictureAlienRace4
                        alienCiv4RelationWithPlayer = savedDataOfAliens.alienRace4RelationWithPlayer
                        isAlienCiv4Damaged = savedDataOfAliens.isAlienRace4Damaged


                        // alien 5

                        AlienCiv5Name = savedDataOfAliens.nameAlienRace5
                        AlienCiv5Picture = savedDataOfAliens.pictureAlienRace5
                        alienCiv5RelationWithPlayer = savedDataOfAliens.alienRace5RelationWithPlayer
                        isAlienCiv5Damaged = savedDataOfAliens.isAlienRace5Damaged



                        // alien 6

                        AlienCiv6Name = savedDataOfAliens.nameAlienRace6
                        AlienCiv6Picture = savedDataOfAliens.pictureAlienRace6
                        alienCiv6RelationWithPlayer = savedDataOfAliens.alienRace6RelationWithPlayer
                        isAlienCiv6Damaged = savedDataOfAliens.isAlienRace6Damaged



                        // alien 7

                        AlienCiv7Name = savedDataOfAliens.nameAlienRace7
                        AlienCiv7Picture = savedDataOfAliens.pictureAlienRace7
                        alienCiv7RelationWithPlayer = savedDataOfAliens.alienRace7RelationWithPlayer
                        isAlienCiv7Damaged = savedDataOfAliens.isAlienRace7Damaged



                        // alien 8

                        AlienCiv8Name = savedDataOfAliens.nameAlienRace8
                        AlienCiv8Picture = savedDataOfAliens.pictureAlienRace8
                        alienCiv8RelationWithPlayer = savedDataOfAliens.alienRace8RelationWithPlayer
                        isAlienCiv8Damaged = savedDataOfAliens.isAlienRace8Damaged



                        // alien 9

                        AlienCiv9Name = savedDataOfAliens.nameAlienRace9
                        AlienCiv9Picture = savedDataOfAliens.pictureAlienRace9
                        alienCiv9RelationWithPlayer = savedDataOfAliens.alienRace9RelationWithPlayer
                        isAlienCiv9Damaged = savedDataOfAliens.isAlienRace9Damaged



                        // alien 10

                        AlienCiv10Name = savedDataOfAliens.nameAlienRace10
                        AlienCiv10Picture = savedDataOfAliens.pictureAlienRace10
                        alienCiv10RelationWithPlayer = savedDataOfAliens.alienRace10RelationWithPlayer
                        isAlienCiv10Damaged = savedDataOfAliens.isAlienRace10Damaged


                        // alien 11

                        AlienCiv11Name = savedDataOfAliens.nameAlienRace11
                        AlienCiv11Picture = savedDataOfAliens.pictureAlienRace11
                        alienCiv11RelationWithPlayer = savedDataOfAliens.alienRace11RelationWithPlayer
                        isAlienCiv11Damaged = savedDataOfAliens.isAlienRace11Damaged



                        // alien 12

                        AlienCiv12Name = savedDataOfAliens.nameAlienRace12
                        AlienCiv12Picture = savedDataOfAliens.pictureAlienRace12
                        alienCiv12RelationWithPlayer = savedDataOfAliens.alienRace12RelationWithPlayer
                        isAlienCiv12Damaged = savedDataOfAliens.isAlienRace12Damaged



                        // alien 13

                        AlienCiv13Name = savedDataOfAliens.nameAlienRace13
                        AlienCiv13Picture = savedDataOfAliens.pictureAlienRace13
                        alienCiv13RelationWithPlayer = savedDataOfAliens.alienRace13RelationWithPlayer
                        isAlienCiv13Damaged = savedDataOfAliens.isAlienRace13Damaged



                        // alien 14

                        AlienCiv14Name = savedDataOfAliens.nameAlienRace14
                        AlienCiv14Picture = savedDataOfAliens.pictureAlienRace14
                        alienCiv14RelationWithPlayer = savedDataOfAliens.alienRace14RelationWithPlayer
                        isAlienCiv14Damaged = savedDataOfAliens.isAlienRace14Damaged



                        // alien 15

                        AlienCiv15Name = savedDataOfAliens.nameAlienRace15
                        AlienCiv15Picture = savedDataOfAliens.pictureAlienRace15
                        alienCiv15RelationWithPlayer = savedDataOfAliens.alienRace15RelationWithPlayer
                        isAlienCiv15Damaged = savedDataOfAliens.isAlienRace15Damaged



                        // alien 16

                        AlienCiv16Name = savedDataOfAliens.nameAlienRace16
                        AlienCiv16Picture = savedDataOfAliens.pictureAlienRace16
                        alienCiv16RelationWithPlayer = savedDataOfAliens.alienRace16RelationWithPlayer
                        isAlienCiv16Damaged = savedDataOfAliens.isAlienRace16Damaged




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







        saveGameIcon.setOnClickListener {

            // Resets all data in case player loses the game


            resetGame()



        }














        Timer().scheduleAtFixedRate( object : TimerTask() {
                override fun run () {

                    if (moneyTaxAmount < maximumCapacity) {
                        if (levelInfrastructure == 1) {
                            moneyTaxAmount += 10000
                        } else if (levelInfrastructure == 2) {
                            moneyTaxAmount += 2
                        } else if (levelInfrastructure == 3) {
                            moneyTaxAmount += 5
                        } else if (levelInfrastructure == 4) {
                            moneyTaxAmount += 10
                        } else if (levelInfrastructure == 5) {
                            moneyTaxAmount += 50
                        }
                    }

                    if (resoursesCollectedAmount < maximumCapacity) {
                        if (levelFactory == 1) {
                            resoursesCollectedAmount += 10000
                        } else if (levelFactory == 2) {
                            resoursesCollectedAmount += 2
                        } else if (levelFactory == 3) {
                            resoursesCollectedAmount += 5
                        } else if (levelFactory == 4) {
                            resoursesCollectedAmount += 10
                        } else if (levelFactory == 5) {
                            resoursesCollectedAmount += 50
                        }
                    }


                }
            }, 0, 1000)










        repairWorldBtn.setOnClickListener {

            moneyAmount -= 1000

            isDamagedAlivePlayer += isDamagedAlivePlayer

            savePlayerData()

        }

















        redMsgIcon.setOnClickListener {


            redMsgIcon.setImageResource(R.drawable.redmsgicon)


            NewMessageNotify = false

            val editNewMessageNotify = sharedNewMessageNotify.edit()
            editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
            editNewMessageNotify.commit()



            val intent = Intent(this, MessagesActivity :: class.java)
            startActivity(intent)


        }






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

            if (colonyId1 != 1000) {
                colonyResourses1 += moneyTaxAmount
            }

            moneyTaxAmount = 0

            savePlayerData()


            // CPU automatic functions

            var isAlienAttacking = (1..50).shuffled().last()



            // Alien 1



            if (alienCiv1RelationWithPlayer != null) {
                if (alienCiv1RelationWithPlayer!! <= 0 && isAlienCiv1Damaged!! > 0.0) {


                    if (isAlienAttacking == 1) {
                        // Saves which alien attacks so that the simulator knows which army to use as the attacker
                        SelectedPlanet = 1
                        val editSelectedPlanet = sharedSelectedPlanet.edit()
                        editSelectedPlanet.putInt("SelectedPlanet", SelectedPlanet)
                        editSelectedPlanet.commit()

                        isPlayerAttacked()
                    }
                }
            }


            // Alien 2


            if (alienCiv2RelationWithPlayer != null) {
                if (alienCiv2RelationWithPlayer!! <= 0 && isAlienCiv2Damaged!! > 0.0) {


                    if (isAlienAttacking == 2) {
                        // Saves which alien attacks so that the simulator knows which army to use as the attacker
                        SelectedPlanet = 2
                        val editSelectedPlanet = sharedSelectedPlanet.edit()
                        editSelectedPlanet.putInt("SelectedPlanet", SelectedPlanet)
                        editSelectedPlanet.commit()

                        isPlayerAttacked()
                    }
                }





                // Alien 3



                if (alienCiv3RelationWithPlayer != null) {
                    if (alienCiv3RelationWithPlayer!! <= 0 && isAlienCiv3Damaged!! > 0.0) {


                        if (isAlienAttacking == 3) {
                            // Saves which alien attacks so that the simulator knows which army to use as the attacker
                            SelectedPlanet = 3
                            val editSelectedPlanet = sharedSelectedPlanet.edit()
                            editSelectedPlanet.putInt("SelectedPlanet", SelectedPlanet)
                            editSelectedPlanet.commit()

                            isPlayerAttacked()
                        }
                    }
                }



                // Alien 4



                if (alienCiv4RelationWithPlayer != null) {
                    if (alienCiv4RelationWithPlayer!! <= 0 && isAlienCiv4Damaged!! > 0.0) {


                        if (isAlienAttacking == 4) {
                            // Saves which alien attacks so that the simulator knows which army to use as the attacker
                            SelectedPlanet = 4
                            val editSelectedPlanet = sharedSelectedPlanet.edit()
                            editSelectedPlanet.putInt("SelectedPlanet", SelectedPlanet)
                            editSelectedPlanet.commit()

                            isPlayerAttacked()
                        }
                    }
                }



                // Alien 5



                if (alienCiv5RelationWithPlayer != null) {
                    if (alienCiv5RelationWithPlayer!! <= 0 && isAlienCiv5Damaged!! > 0.0) {


                        if (isAlienAttacking == 5) {
                            // Saves which alien attacks so that the simulator knows which army to use as the attacker
                            SelectedPlanet = 5
                            val editSelectedPlanet = sharedSelectedPlanet.edit()
                            editSelectedPlanet.putInt("SelectedPlanet", SelectedPlanet)
                            editSelectedPlanet.commit()

                            isPlayerAttacked()
                        }
                    }
                }



                        // Alien 6



                if (alienCiv6RelationWithPlayer != null) {
                    if (alienCiv6RelationWithPlayer!! <= 0 && isAlienCiv6Damaged!! > 0.0) {


                        if (isAlienAttacking == 6) {
                            // Saves which alien attacks so that the simulator knows which army to use as the attacker
                            SelectedPlanet = 6
                            val editSelectedPlanet = sharedSelectedPlanet.edit()
                            editSelectedPlanet.putInt("SelectedPlanet", SelectedPlanet)
                            editSelectedPlanet.commit()

                            isPlayerAttacked()
                        }
                    }
                }






                // Alien 7



                if (alienCiv7RelationWithPlayer != null) {
                    if (alienCiv7RelationWithPlayer!! <= 0 && isAlienCiv7Damaged!! > 0.0) {


                        if (isAlienAttacking == 7) {
                            // Saves which alien attacks so that the simulator knows which army to use as the attacker
                            SelectedPlanet = 7
                            val editSelectedPlanet = sharedSelectedPlanet.edit()
                            editSelectedPlanet.putInt("SelectedPlanet", SelectedPlanet)
                            editSelectedPlanet.commit()

                            isPlayerAttacked()
                        }
                    }
                }




                // Alien 8



                if (alienCiv8RelationWithPlayer != null) {
                    if (alienCiv8RelationWithPlayer!! <= 0 && isAlienCiv8Damaged!! > 0.0) {


                        if (isAlienAttacking == 8) {
                            // Saves which alien attacks so that the simulator knows which army to use as the attacker
                            SelectedPlanet = 8
                            val editSelectedPlanet = sharedSelectedPlanet.edit()
                            editSelectedPlanet.putInt("SelectedPlanet", SelectedPlanet)
                            editSelectedPlanet.commit()

                            isPlayerAttacked()
                        }
                    }
                }





                // Alien 9



                if (alienCiv9RelationWithPlayer != null) {
                    if (alienCiv9RelationWithPlayer!! <= 0 && isAlienCiv9Damaged!! > 0.0) {


                        if (isAlienAttacking == 9) {
                            // Saves which alien attacks so that the simulator knows which army to use as the attacker
                            SelectedPlanet = 9
                            val editSelectedPlanet = sharedSelectedPlanet.edit()
                            editSelectedPlanet.putInt("SelectedPlanet", SelectedPlanet)
                            editSelectedPlanet.commit()

                            isPlayerAttacked()
                        }
                    }
                }



                // Alien 10



                if (alienCiv10RelationWithPlayer != null) {
                    if (alienCiv10RelationWithPlayer!! <= 0 && isAlienCiv10Damaged!! > 0.0) {


                        if (isAlienAttacking == 10) {
                            // Saves which alien attacks so that the simulator knows which army to use as the attacker
                            SelectedPlanet = 10
                            val editSelectedPlanet = sharedSelectedPlanet.edit()
                            editSelectedPlanet.putInt("SelectedPlanet", SelectedPlanet)
                            editSelectedPlanet.commit()

                            isPlayerAttacked()
                        }
                    }
                }





                // Alien 11



                if (alienCiv11RelationWithPlayer != null) {
                    if (alienCiv11RelationWithPlayer!! <= 0 && isAlienCiv11Damaged!! > 0.0) {


                        if (isAlienAttacking == 11) {
                            // Saves which alien attacks so that the simulator knows which army to use as the attacker
                            SelectedPlanet = 999
                            val editSelectedPlanet = sharedSelectedPlanet.edit()
                            editSelectedPlanet.putInt("SelectedPlanet", SelectedPlanet)
                            editSelectedPlanet.commit()

                            isPlayerAttacked()
                        }
                    }
                }




                // Alien 12



                if (alienCiv12RelationWithPlayer != null) {
                    if (alienCiv12RelationWithPlayer!! <= 0 && isAlienCiv12Damaged!! > 0.0) {


                        if (isAlienAttacking == 12) {
                            // Saves which alien attacks so that the simulator knows which army to use as the attacker
                            SelectedPlanet = 101010
                            val editSelectedPlanet = sharedSelectedPlanet.edit()
                            editSelectedPlanet.putInt("SelectedPlanet", SelectedPlanet)
                            editSelectedPlanet.commit()

                            isPlayerAttacked()
                        }
                    }
                }






                // Alien 13



                if (alienCiv13RelationWithPlayer != null) {
                    if (alienCiv13RelationWithPlayer!! <= 0 && isAlienCiv13Damaged!! > 0.0) {


                        if (isAlienAttacking == 13) {
                            // Saves which alien attacks so that the simulator knows which army to use as the attacker
                            SelectedPlanet = 10101010
                            val editSelectedPlanet = sharedSelectedPlanet.edit()
                            editSelectedPlanet.putInt("SelectedPlanet", SelectedPlanet)
                            editSelectedPlanet.commit()

                            isPlayerAttacked()
                        }
                    }
                }



                // Alien 14



                if (alienCiv14RelationWithPlayer != null) {
                    if (alienCiv14RelationWithPlayer!! <= 0 && isAlienCiv14Damaged!! > 0.0) {


                        if (isAlienAttacking == 14) {
                            // Saves which alien attacks so that the simulator knows which army to use as the attacker
                            SelectedPlanet = 11
                            val editSelectedPlanet = sharedSelectedPlanet.edit()
                            editSelectedPlanet.putInt("SelectedPlanet", SelectedPlanet)
                            editSelectedPlanet.commit()

                            isPlayerAttacked()
                        }
                    }
                }





                // Alien 15



                if (alienCiv15RelationWithPlayer != null) {
                    if (alienCiv15RelationWithPlayer!! <= 0 && isAlienCiv15Damaged!! > 0.0) {


                        if (isAlienAttacking == 15) {
                            // Saves which alien attacks so that the simulator knows which army to use as the attacker
                            SelectedPlanet = 12
                            val editSelectedPlanet = sharedSelectedPlanet.edit()
                            editSelectedPlanet.putInt("SelectedPlanet", SelectedPlanet)
                            editSelectedPlanet.commit()

                            isPlayerAttacked()
                        }
                    }
                }





                // Alien 16



                if (alienCiv16RelationWithPlayer != null) {
                    if (alienCiv16RelationWithPlayer!! <= 0 && isAlienCiv16Damaged!! > 0.0) {


                        if (isAlienAttacking == 16) {
                            // Saves which alien attacks so that the simulator knows which army to use as the attacker
                            SelectedPlanet = 13
                            val editSelectedPlanet = sharedSelectedPlanet.edit()
                            editSelectedPlanet.putInt("SelectedPlanet", SelectedPlanet)
                            editSelectedPlanet.commit()

                            isPlayerAttacked()
                        }
                    }
                }










            } // CPU





        }







        galaxyView.setOnClickListener {


            generateAlienCivilisations()



            // CPU automatic functions


            var isThereGeneralMessage = (1..10).shuffled().last()

            if (isThereGeneralMessage == 5) {

                sendGeneralMessage()

                NewMessageNotify = true

                val editNewMessageNotify = sharedNewMessageNotify.edit()
                editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                editNewMessageNotify.commit()

                redMsgIcon.setImageResource(R.drawable.messageicon)

            }





            // CPU


            val intent = Intent(this, GalaxyViewActivity :: class.java)
            startActivity(intent)

        }





    }





















    override fun onBackPressed() {

        Toast.makeText(this, "This action is not allowed", Toast.LENGTH_SHORT).show()

    }




    fun resetGame() {




        var dataOfAlienCivilisations = aliens(nameAlienRace1 = null)


        database.collection("users").document("User path").collection("Saved aliens data")
            .document("Aliens data").set(dataOfAlienCivilisations)


            .addOnCompleteListener {



            }













        var data = playerData(savedMoneyAmount = 0, savedResoursesAmount = 0,
            savedLevelInfrastructure = 1, savedLevelFactory = 1, savedLevelMilitaryBase= 1,
            savedLevelGeneralDevelopment = 1, savedLevelScienficResearch = 1,
            savedLevelSpionage = 1, savedSoldierUnitQuantity = 100.0, savedAirplaneUnitQuantity = 40.0,
            savedCargoPlaneQuantity = 10.0, savedAirplane2UnitQuantity= 0.0, savedTankUnitQuantity= 0.0,
            savedSateliteUnitQuantity= 0.0, isDamagedAlive = 2.0, colonyId1 = 1000,
            colonyResourses1 = 0)



        database.collection("users").document("User path").collection("Saved data")
            .document("hmkogjk").set(data)


            .addOnCompleteListener {



            }






    }







    fun savePlayerData() {





        var data = playerData(savedMoneyAmount = moneyAmount, savedResoursesAmount = resoursesAmount,
            savedLevelInfrastructure = levelInfrastructure, savedLevelFactory = levelFactory, savedLevelMilitaryBase= levelMilitaryBase,
            savedLevelGeneralDevelopment = levelGeneralDevelopment, savedLevelScienficResearch = levelScientificDevelopment,
            savedLevelSpionage = levelSpionage, savedSoldierUnitQuantity = soldierQuantity, savedAirplaneUnitQuantity = airplaneQuantity,
            savedCargoPlaneQuantity = cargoplaneQuantity, savedAirplane2UnitQuantity= airplane2Quantity, savedTankUnitQuantity= tankQuantity,
            savedSateliteUnitQuantity= sateliteQuantity, isDamagedAlive = isDamagedAlivePlayer, colonyId1 = colonyId1,
            colonyResourses1 = colonyResourses1)



        database.collection("users").document("User path").collection("Saved data")
            .document("hmkogjk").set(data)


            .addOnCompleteListener {



            }
    }








    fun sendGeneralMessage() {



        var chooseMessage = (1..7).shuffled().last()
        var messageText = ""



        if (chooseMessage == 1) {
            messageText = "Zorgon have devastated a planet"
        } else if (chooseMessage == 2) {
            messageText = "Heelp heelp heeeelp, the Zorgon, they killed...please help us, anyone who is listening"
        } else if (chooseMessage == 3) {
            messageText = "Civilisations are being annihilated over the galaxy by the Zorgon"
        } else if (chooseMessage == 4) {
            messageText = "The civilisations in the galaxy consider forming an alliance against the Zorgon"
        } else if (chooseMessage == 5) {
            messageText = "Zorgon are colonising planets very fast"
        }  else if (chooseMessage == 6) {
            messageText = "You scientists have observed a strange spaceship in your solar system. The origin of the ship is unknown"
        }  else if (chooseMessage == 7) {
            messageText = "Scientists warn that meeting other civilisations can be...risky"
        }


        var newMessage = messages(messageContent = messageText, isItNewMessage = true, constantNumber = 1,
        docNumber = calculator)



        database.collection("users").document("User path")
            .collection("Messages").add(newMessage)


            .addOnCompleteListener {



            }

        calculator = 0







    }













   fun generateAlienCivilisations() {

       var dataOfAlienCivilisations = aliens(nameAlienRace1 = AlienCiv1Name, nameAlienRace2 = AlienCiv2Name)




       if (dataOfAlienCivilisations.nameAlienRace1 == null) {



           // Generating random alien civilisations


           var randomNumString1 = (1..3).shuffled().last()  //random number from 1 to 3
           var randomNumString2 = (1..3).shuffled().last()
           var randomNumString3 = (1..3).shuffled().last()
           var randomNumString4 = (1..3).shuffled().last()
           var randomNumString5 = (1..3).shuffled().last()
           var randomNumString6 = (1..3).shuffled().last()
           var randomNumString7 = (1..3).shuffled().last()
           var randomNumString8 = (1..3).shuffled().last()
           var randomNumString14 = (1..3).shuffled().last()
           var randomNumString15 = (1..3).shuffled().last()
           var randomNumString16 = (1..3).shuffled().last()


           // Chooses random name for civilisation 1

           if (randomNumString1 == 1) {
               AlienCiv1Name = "Gausians"
           } else if (randomNumString1 == 2) {
            AlienCiv1Name = "Rivians"
           } else if (randomNumString1 == 3) {
               AlienCiv1Name = "Polirians"
           }

           // Chooses random name for civilisation 2

           if (randomNumString2 == 1) {
               AlienCiv2Name = "Iritians"
           } else if (randomNumString2 == 2) {
               AlienCiv2Name = "Saurians"
           } else if (randomNumString2 == 3) {
               AlienCiv2Name = "Likatrians"
           }

           // 3

           if (randomNumString3 == 1) {
               AlienCiv3Name = "Alubians"
           } else if (randomNumString3 == 2) {
               AlienCiv3Name = "Saratosians"
           } else if (randomNumString3 == 3) {
               AlienCiv3Name = "Furionians"
           }


           // 4

           if (randomNumString4 == 1) {
               AlienCiv4Name = "Sakarians"
           } else if (randomNumString4 == 2) {
               AlienCiv4Name = "Akirians"
           } else if (randomNumString4 == 3) {
               AlienCiv4Name = "Luvians"
           }

// 5

           if (randomNumString5 == 1) {
               AlienCiv5Name = "Birians"
           } else if (randomNumString5 == 2) {
               AlienCiv5Name = "Gurians"
           } else if (randomNumString5 == 3) {
               AlienCiv5Name = "Opcatrians"
           }

           // 6

           if (randomNumString6 == 1) {
               AlienCiv6Name = "Firitians"
           } else if (randomNumString6 == 2) {
               AlienCiv6Name = "Satrunians"
           } else if (randomNumString6 == 3) {
               AlienCiv6Name = "Ioprians"
           }


// 7

           if (randomNumString7 == 1) {
               AlienCiv7Name = "Tuvilians"
           } else if (randomNumString7 == 2) {
               AlienCiv7Name = "Eliumians"
           } else if (randomNumString7 == 3) {
               AlienCiv7Name = "Apirians"
           }

// 8

           if (randomNumString8 == 1) {
               AlienCiv8Name = "Surivians"
           } else if (randomNumString8 == 2) {
               AlienCiv8Name = "Polastrians"
           } else if (randomNumString8 == 3) {
               AlienCiv8Name = "Kolovians"
           }



           // 9

           AlienCiv9Name = "Zorgon Planet 2"


// 10

           AlienCiv10Name = "Zorgon Planet 1"


// 11

           AlienCiv11Name = "Zorgon Colony Sol system 9"


           // 12


           AlienCiv12Name = "Zorgon Colony Sol system 10"


           // 13

           AlienCiv13Name = "Zorgon Colony 2 Sol system 10"


           // 14


           if (randomNumString14 == 1) {
               AlienCiv14Name = "Lareistinians"
           } else if (randomNumString14 == 2) {
               AlienCiv14Name = "Kerenians"
           } else if (randomNumString14 == 3) {
               AlienCiv14Name = "Dereivans"
           }


           // 15

           if (randomNumString15 == 1) {
               AlienCiv15Name = "Curevians"
           } else if (randomNumString15 == 2) {
               AlienCiv15Name = "Petrevians"
           } else if (randomNumString15 == 3) {
               AlienCiv15Name = "Gurvinians"
           }



           // 16

           if (randomNumString16 == 1) {
               AlienCiv16Name = "Dernakorans"
           } else if (randomNumString16 == 2) {
               AlienCiv16Name = "Prasvanians"
           } else if (randomNumString16 == 3) {
               AlienCiv16Name = "Sertinians"
           }







           // Choosing a picture for every alien civilisation

           var randomNumber1 = (1..10).shuffled().last()
           var randomNumber2 = (1..10).shuffled().last()
           var randomNumber3 = (1..10).shuffled().last()
           var randomNumber4 = (1..10).shuffled().last()
           var randomNumber5 = (1..10).shuffled().last()
           var randomNumber6 = (1..10).shuffled().last()
           var randomNumber7 = (1..10).shuffled().last()
           var randomNumber8 = (1..10).shuffled().last()
           var randomNumber14 = (1..10).shuffled().last()
           var randomNumber15 = (1..10).shuffled().last()
           var randomNumber16 = (1..10).shuffled().last()






           // Selecting level military base for every alien civilisation

           var randomMilitaryBaseAlien1 = (1..5).shuffled().last()
           var randomMilitaryBaseAlien2 = (1..5).shuffled().last()
           var randomMilitaryBaseAlien3 = (1..5).shuffled().last()
           var randomMilitaryBaseAlien4 = (1..5).shuffled().last()
           var randomMilitaryBaseAlien5 = (1..5).shuffled().last()
           var randomMilitaryBaseAlien6 = (1..5).shuffled().last()
           var randomMilitaryBaseAlien7 = (1..5).shuffled().last()
           var randomMilitaryBaseAlien8 = (1..5).shuffled().last()
           var randomMilitaryBaseAlien14 = (1..5).shuffled().last()
           var randomMilitaryBaseAlien15 = (1..5).shuffled().last()
           var randomMilitaryBaseAlien16 = (1..5).shuffled().last()



          var  randomMilitaryBaseAlien1Double = randomMilitaryBaseAlien1.toDouble()
          var  randomMilitaryBaseAlien2Double = randomMilitaryBaseAlien2.toDouble()
           var  randomMilitaryBaseAlien3Double = randomMilitaryBaseAlien3.toDouble()
           var  randomMilitaryBaseAlien4Double = randomMilitaryBaseAlien4.toDouble()
           var  randomMilitaryBaseAlien5Double = randomMilitaryBaseAlien5.toDouble()
           var  randomMilitaryBaseAlien6Double = randomMilitaryBaseAlien6.toDouble()
           var  randomMilitaryBaseAlien7Double = randomMilitaryBaseAlien7.toDouble()
           var  randomMilitaryBaseAlien8Double = randomMilitaryBaseAlien8.toDouble()
           var  randomMilitaryBaseAlien14Double = randomMilitaryBaseAlien14.toDouble()
           var  randomMilitaryBaseAlien15Double = randomMilitaryBaseAlien15.toDouble()
           var  randomMilitaryBaseAlien16Double = randomMilitaryBaseAlien16.toDouble()



           // Generating an army for every alien civilisation




           // First alien


           var randomSoldiersAlien1 = (100..800).shuffled().last()
           var randomSpacePlanesAlien1 = (40..320).shuffled().last()
           var randomTanksAlien1 = (80..400).shuffled().last()
           var randomSpaceJetsAlien1 = (20..160).shuffled().last()
           var randomNuclearSatelitesAlien1 = (1..10).shuffled().last()

           var randomSoldiersAlien1Double = randomSoldiersAlien1.toDouble()
           var randomSpacePlanesAlien1Double = randomSpacePlanesAlien1.toDouble()
           var randomTanksAlien1Double = randomTanksAlien1.toDouble()
           var randomSpaceJetsAlien1Double = randomSpaceJetsAlien1.toDouble()
           var randomNuclearSatelitesAlien1Double = randomNuclearSatelitesAlien1.toDouble()



           AlienCiv1Soldiers = randomSoldiersAlien1Double
           AlienCiv1SpacePlanes = randomSpacePlanesAlien1Double
           AlienCiv1Tanks = 0.0
           AlienCiv1SpaceJets = 0.0
           AlienCiv1NuclearSatelites = 0.0

           if (randomMilitaryBaseAlien1Double >= 2.0) {
               AlienCiv1Tanks = randomTanksAlien1Double
           }

           if (randomMilitaryBaseAlien1 >= 3) {
               AlienCiv1Tanks = randomTanksAlien1Double
               AlienCiv1SpaceJets = randomSpaceJetsAlien1Double
               AlienCiv1NuclearSatelites = randomNuclearSatelitesAlien1Double
           }




           // Second alien




           var randomSoldiersAlien2 = (100..800).shuffled().last()
           var randomSpacePlanesAlien2 = (40..320).shuffled().last()
           var randomTanksAlien2 = (80..400).shuffled().last()
           var randomSpaceJetsAlien2 = (20..160).shuffled().last()
           var randomNuclearSatelitesAlien2 = (1..10).shuffled().last()

           var randomSoldiersAlien2Double = randomSoldiersAlien2.toDouble()
           var randomSpacePlanesAlien2Double = randomSpacePlanesAlien2.toDouble()
           var randomTanksAlien2Double = randomTanksAlien2.toDouble()
           var randomSpaceJetsAlien2Double = randomSpaceJetsAlien2.toDouble()
           var randomNuclearSatelitesAlien2Double = randomNuclearSatelitesAlien2.toDouble()



           AlienCiv2Soldiers = randomSoldiersAlien2Double
           AlienCiv2SpacePlanes = randomSpacePlanesAlien2Double
           AlienCiv2Tanks = 0.0
           AlienCiv2SpaceJets = 0.0
           AlienCiv2NuclearSatelites = 0.0

           if (randomMilitaryBaseAlien2Double >= 2.0) {
               AlienCiv2Tanks = randomTanksAlien2Double
           }

           if (randomMilitaryBaseAlien2 >= 3) {
               AlienCiv2Tanks = randomTanksAlien2Double
               AlienCiv2SpaceJets = randomSpaceJetsAlien2Double
               AlienCiv2NuclearSatelites = randomNuclearSatelitesAlien2Double
           }





           // alien 3


           var randomSoldiersAlien3 = (100..800).shuffled().last()
           var randomSpacePlanesAlien3 = (40..320).shuffled().last()
           var randomTanksAlien3 = (80..400).shuffled().last()
           var randomSpaceJetsAlien3 = (20..160).shuffled().last()
           var randomNuclearSatelitesAlien3 = (1..10).shuffled().last()

           var randomSoldiersAlien3Double = randomSoldiersAlien3.toDouble()
           var randomSpacePlanesAlien3Double = randomSpacePlanesAlien3.toDouble()
           var randomTanksAlien3Double = randomTanksAlien3.toDouble()
           var randomSpaceJetsAlien3Double = randomSpaceJetsAlien3.toDouble()
           var randomNuclearSatelitesAlien3Double = randomNuclearSatelitesAlien3.toDouble()



           AlienCiv3Soldiers = randomSoldiersAlien3Double
           AlienCiv3SpacePlanes = randomSpacePlanesAlien3Double
           AlienCiv3Tanks = 0.0
           AlienCiv3SpaceJets = 0.0
           AlienCiv3NuclearSatelites = 0.0

           if (randomMilitaryBaseAlien3Double >= 2.0) {
               AlienCiv3Tanks = randomTanksAlien3Double
           }

           if (randomMilitaryBaseAlien3 >= 3) {
               AlienCiv3Tanks = randomTanksAlien3Double
               AlienCiv3SpaceJets = randomSpaceJetsAlien3Double
               AlienCiv3NuclearSatelites = randomNuclearSatelitesAlien3Double
           }






// alien 4


           var randomSoldiersAlien4 = (100..800).shuffled().last()
           var randomSpacePlanesAlien4 = (40..320).shuffled().last()
           var randomTanksAlien4 = (80..400).shuffled().last()
           var randomSpaceJetsAlien4 = (20..160).shuffled().last()
           var randomNuclearSatelitesAlien4 = (1..10).shuffled().last()

           var randomSoldiersAlien4Double = randomSoldiersAlien4.toDouble()
           var randomSpacePlanesAlien4Double = randomSpacePlanesAlien4.toDouble()
           var randomTanksAlien4Double = randomTanksAlien4.toDouble()
           var randomSpaceJetsAlien4Double = randomSpaceJetsAlien4.toDouble()
           var randomNuclearSatelitesAlien4Double = randomNuclearSatelitesAlien4.toDouble()



           AlienCiv4Soldiers = randomSoldiersAlien4Double
           AlienCiv4SpacePlanes = randomSpacePlanesAlien4Double
           AlienCiv4Tanks = 0.0
           AlienCiv4SpaceJets = 0.0
           AlienCiv4NuclearSatelites = 0.0

           if (randomMilitaryBaseAlien4Double >= 2.0) {
               AlienCiv4Tanks = randomTanksAlien4Double
           }

           if (randomMilitaryBaseAlien4 >= 3) {
               AlienCiv4Tanks = randomTanksAlien4Double
               AlienCiv4SpaceJets = randomSpaceJetsAlien4Double
               AlienCiv4NuclearSatelites = randomNuclearSatelitesAlien4Double
           }




           // alien 5




           var randomSoldiersAlien5 = (100..800).shuffled().last()
           var randomSpacePlanesAlien5 = (40..320).shuffled().last()
           var randomTanksAlien5 = (80..400).shuffled().last()
           var randomSpaceJetsAlien5 = (20..160).shuffled().last()
           var randomNuclearSatelitesAlien5 = (1..10).shuffled().last()

           var randomSoldiersAlien5Double = randomSoldiersAlien5.toDouble()
           var randomSpacePlanesAlien5Double = randomSpacePlanesAlien5.toDouble()
           var randomTanksAlien5Double = randomTanksAlien5.toDouble()
           var randomSpaceJetsAlien5Double = randomSpaceJetsAlien5.toDouble()
           var randomNuclearSatelitesAlien5Double = randomNuclearSatelitesAlien5.toDouble()



           AlienCiv5Soldiers = randomSoldiersAlien5Double
           AlienCiv5SpacePlanes = randomSpacePlanesAlien5Double
           AlienCiv5Tanks = 0.0
           AlienCiv5SpaceJets = 0.0
           AlienCiv5NuclearSatelites = 0.0

           if (randomMilitaryBaseAlien5Double >= 2.0) {
               AlienCiv5Tanks = randomTanksAlien5Double
           }

           if (randomMilitaryBaseAlien5 >= 3) {
               AlienCiv5Tanks = randomTanksAlien5Double
               AlienCiv5SpaceJets = randomSpaceJetsAlien5Double
               AlienCiv5NuclearSatelites = randomNuclearSatelitesAlien5Double
           }





// alien 6


           var randomSoldiersAlien6 = (100..800).shuffled().last()
           var randomSpacePlanesAlien6 = (40..320).shuffled().last()
           var randomTanksAlien6 = (80..400).shuffled().last()
           var randomSpaceJetsAlien6 = (20..160).shuffled().last()
           var randomNuclearSatelitesAlien6 = (1..10).shuffled().last()

           var randomSoldiersAlien6Double = randomSoldiersAlien6.toDouble()
           var randomSpacePlanesAlien6Double = randomSpacePlanesAlien6.toDouble()
           var randomTanksAlien6Double = randomTanksAlien6.toDouble()
           var randomSpaceJetsAlien6Double = randomSpaceJetsAlien6.toDouble()
           var randomNuclearSatelitesAlien6Double = randomNuclearSatelitesAlien6.toDouble()



           AlienCiv6Soldiers = randomSoldiersAlien6Double
           AlienCiv6SpacePlanes = randomSpacePlanesAlien6Double
           AlienCiv6Tanks = 0.0
           AlienCiv6SpaceJets = 0.0
           AlienCiv6NuclearSatelites = 0.0

           if (randomMilitaryBaseAlien6Double >= 2.0) {
               AlienCiv6Tanks = randomTanksAlien6Double
           }

           if (randomMilitaryBaseAlien6 >= 3) {
               AlienCiv6Tanks = randomTanksAlien6Double
               AlienCiv6SpaceJets = randomSpaceJetsAlien6Double
               AlienCiv6NuclearSatelites = randomNuclearSatelitesAlien6Double
           }





           // Alien 7


           var randomSoldiersAlien7 = (100..800).shuffled().last()
           var randomSpacePlanesAlien7 = (40..320).shuffled().last()
           var randomTanksAlien7 = (80..400).shuffled().last()
           var randomSpaceJetsAlien7 = (20..160).shuffled().last()
           var randomNuclearSatelitesAlien7 = (1..10).shuffled().last()

           var randomSoldiersAlien7Double = randomSoldiersAlien7.toDouble()
           var randomSpacePlanesAlien7Double = randomSpacePlanesAlien7.toDouble()
           var randomTanksAlien7Double = randomTanksAlien7.toDouble()
           var randomSpaceJetsAlien7Double = randomSpaceJetsAlien7.toDouble()
           var randomNuclearSatelitesAlien7Double = randomNuclearSatelitesAlien7.toDouble()



           AlienCiv7Soldiers = randomSoldiersAlien7Double
           AlienCiv7SpacePlanes = randomSpacePlanesAlien7Double
           AlienCiv7Tanks = 0.0
           AlienCiv7SpaceJets = 0.0
           AlienCiv7NuclearSatelites = 0.0

           if (randomMilitaryBaseAlien7Double >= 2.0) {
               AlienCiv7Tanks = randomTanksAlien7Double
           }

           if (randomMilitaryBaseAlien7 >= 3) {
               AlienCiv7Tanks = randomTanksAlien7Double
               AlienCiv7SpaceJets = randomSpaceJetsAlien7Double
               AlienCiv7NuclearSatelites = randomNuclearSatelitesAlien7Double
           }







// alien 8


           var randomSoldiersAlien8 = (100..800).shuffled().last()
           var randomSpacePlanesAlien8 = (40..320).shuffled().last()
           var randomTanksAlien8 = (80..400).shuffled().last()
           var randomSpaceJetsAlien8 = (20..160).shuffled().last()
           var randomNuclearSatelitesAlien8 = (1..10).shuffled().last()

           var randomSoldiersAlien8Double = randomSoldiersAlien8.toDouble()
           var randomSpacePlanesAlien8Double = randomSpacePlanesAlien8.toDouble()
           var randomTanksAlien8Double = randomTanksAlien8.toDouble()
           var randomSpaceJetsAlien8Double = randomSpaceJetsAlien8.toDouble()
           var randomNuclearSatelitesAlien8Double = randomNuclearSatelitesAlien8.toDouble()



           AlienCiv8Soldiers = randomSoldiersAlien8Double
           AlienCiv8SpacePlanes = randomSpacePlanesAlien8Double
           AlienCiv8Tanks = 0.0
           AlienCiv8SpaceJets = 0.0
           AlienCiv8NuclearSatelites = 0.0

           if (randomMilitaryBaseAlien8Double >= 2.0) {
               AlienCiv8Tanks = randomTanksAlien8Double
           }

           if (randomMilitaryBaseAlien8 >= 3) {
               AlienCiv8Tanks = randomTanksAlien8Double
               AlienCiv8SpaceJets = randomSpaceJetsAlien8Double
               AlienCiv8NuclearSatelites = randomNuclearSatelitesAlien8Double
           }





// alien 14

           var randomSoldiersAlien14 = (100..800).shuffled().last()
           var randomSpacePlanesAlien14 = (40..320).shuffled().last()
           var randomTanksAlien14 = (80..400).shuffled().last()
           var randomSpaceJetsAlien14 = (20..160).shuffled().last()
           var randomNuclearSatelitesAlien14 = (1..10).shuffled().last()

           var randomSoldiersAlien14Double = randomSoldiersAlien14.toDouble()
           var randomSpacePlanesAlien14Double = randomSpacePlanesAlien14.toDouble()
           var randomTanksAlien14Double = randomTanksAlien14.toDouble()
           var randomSpaceJetsAlien14Double = randomSpaceJetsAlien14.toDouble()
           var randomNuclearSatelitesAlien14Double = randomNuclearSatelitesAlien14.toDouble()



           AlienCiv14Soldiers = randomSoldiersAlien14Double
           AlienCiv14SpacePlanes = randomSpacePlanesAlien14Double
           AlienCiv14Tanks = 0.0
           AlienCiv14SpaceJets = 0.0
           AlienCiv14NuclearSatelites = 0.0

           if (randomMilitaryBaseAlien14Double >= 2.0) {
               AlienCiv14Tanks = randomTanksAlien14Double
           }

           if (randomMilitaryBaseAlien14 >= 3) {
               AlienCiv14Tanks = randomTanksAlien14Double
               AlienCiv14SpaceJets = randomSpaceJetsAlien14Double
               AlienCiv14NuclearSatelites = randomNuclearSatelitesAlien14Double
           }





// alien 15


           var randomSoldiersAlien15 = (100..800).shuffled().last()
           var randomSpacePlanesAlien15 = (40..320).shuffled().last()
           var randomTanksAlien15 = (80..400).shuffled().last()
           var randomSpaceJetsAlien15 = (20..160).shuffled().last()
           var randomNuclearSatelitesAlien15 = (1..10).shuffled().last()

           var randomSoldiersAlien15Double = randomSoldiersAlien15.toDouble()
           var randomSpacePlanesAlien15Double = randomSpacePlanesAlien15.toDouble()
           var randomTanksAlien15Double = randomTanksAlien15.toDouble()
           var randomSpaceJetsAlien15Double = randomSpaceJetsAlien15.toDouble()
           var randomNuclearSatelitesAlien15Double = randomNuclearSatelitesAlien15.toDouble()



           AlienCiv15Soldiers = randomSoldiersAlien15Double
           AlienCiv15SpacePlanes = randomSpacePlanesAlien15Double
           AlienCiv15Tanks = 0.0
           AlienCiv15SpaceJets = 0.0
           AlienCiv15NuclearSatelites = 0.0

           if (randomMilitaryBaseAlien15Double >= 2.0) {
               AlienCiv15Tanks = randomTanksAlien15Double
           }

           if (randomMilitaryBaseAlien15 >= 3) {
               AlienCiv15Tanks = randomTanksAlien15Double
               AlienCiv15SpaceJets = randomSpaceJetsAlien15Double
               AlienCiv15NuclearSatelites = randomNuclearSatelitesAlien15Double
           }







           // alien 16


           var randomSoldiersAlien16 = (100..800).shuffled().last()
           var randomSpacePlanesAlien16 = (40..320).shuffled().last()
           var randomTanksAlien16 = (80..400).shuffled().last()
           var randomSpaceJetsAlien16 = (20..160).shuffled().last()
           var randomNuclearSatelitesAlien16 = (1..10).shuffled().last()

           var randomSoldiersAlien16Double = randomSoldiersAlien16.toDouble()
           var randomSpacePlanesAlien16Double = randomSpacePlanesAlien16.toDouble()
           var randomTanksAlien16Double = randomTanksAlien16.toDouble()
           var randomSpaceJetsAlien16Double = randomSpaceJetsAlien16.toDouble()
           var randomNuclearSatelitesAlien16Double = randomNuclearSatelitesAlien16.toDouble()



           AlienCiv16Soldiers = randomSoldiersAlien16Double
           AlienCiv16SpacePlanes = randomSpacePlanesAlien16Double
           AlienCiv16Tanks = 0.0
           AlienCiv16SpaceJets = 0.0
           AlienCiv16NuclearSatelites = 0.0

           if (randomMilitaryBaseAlien16Double >= 2.0) {
               AlienCiv16Tanks = randomTanksAlien16Double
           }

           if (randomMilitaryBaseAlien16 >= 3) {
               AlienCiv16Tanks = randomTanksAlien16Double
               AlienCiv16SpaceJets = randomSpaceJetsAlien16Double
               AlienCiv16NuclearSatelites = randomNuclearSatelitesAlien16Double
           }









           // Creating random relations with player for every alien race

           // First alien


           var relationsAlien1 = (2..10).shuffled().last()
           var relationsAlien1ToDouble = relationsAlien1.toDouble()
           alienCiv1RelationWithPlayer = relationsAlien1ToDouble


           // Second Alien

           var relationsAlien2 = (2..10).shuffled().last()
           var relationsAlien2ToDouble = relationsAlien2.toDouble()
           alienCiv2RelationWithPlayer = relationsAlien2ToDouble




           // alien 3


           var relationsAlien3 = (2..10).shuffled().last()
           var relationsAlien3ToDouble = relationsAlien3.toDouble()
           alienCiv3RelationWithPlayer = relationsAlien3ToDouble




           // alien 4


           var relationsAlien4 = (2..10).shuffled().last()
           var relationsAlien4ToDouble = relationsAlien4.toDouble()
           alienCiv4RelationWithPlayer = relationsAlien4ToDouble



           // alien 5


           var relationsAlien5 = (2..10).shuffled().last()
           var relationsAlien5ToDouble = relationsAlien5.toDouble()
           alienCiv5RelationWithPlayer = relationsAlien5ToDouble





           // alien 6


           var relationsAlien6 = (2..10).shuffled().last()
           var relationsAlien6ToDouble = relationsAlien6.toDouble()
           alienCiv6RelationWithPlayer = relationsAlien6ToDouble




           // alien 7


           var relationsAlien7 = (2..10).shuffled().last()
           var relationsAlien7ToDouble = relationsAlien7.toDouble()
           alienCiv7RelationWithPlayer = relationsAlien7ToDouble




           // alien 8


           var relationsAlien8 = (2..10).shuffled().last()
           var relationsAlien8ToDouble = relationsAlien8.toDouble()
           alienCiv8RelationWithPlayer = relationsAlien8ToDouble




           // alien 14


           var relationsAlien14 = (2..10).shuffled().last()
           var relationsAlien14ToDouble = relationsAlien14.toDouble()
           alienCiv14RelationWithPlayer = relationsAlien14ToDouble



           // alien 15


           var relationsAlien15 = (2..10).shuffled().last()
           var relationsAlien15ToDouble = relationsAlien15.toDouble()
           alienCiv15RelationWithPlayer = relationsAlien15ToDouble





           // alien 16


           var relationsAlien16 = (2..10).shuffled().last()
           var relationsAlien16ToDouble = relationsAlien16.toDouble()
           alienCiv16RelationWithPlayer = relationsAlien16ToDouble





           // Inserting values to every alien civilisation


           dataOfAlienCivilisations = aliens(nameAlienRace1 = AlienCiv1Name, pictureAlienRace1 = randomNumber1,
               soldiersAlienRace1 = AlienCiv1Soldiers, spacePlanesAlienRace1 = AlienCiv1SpacePlanes,
               spaceJetsAlienRace1 = AlienCiv1SpaceJets, tanksAlienRace1 = AlienCiv1Tanks,
               nuclearSatelitesAlienRace1 = AlienCiv1NuclearSatelites,  militaryBaseAlienRace1 = randomMilitaryBaseAlien1Double,
               isAlienRace1Damaged = 2.0, alienRace1RelationWithPlayer = alienCiv1RelationWithPlayer,

               /*Alien civilisation 1 aspects written*/

               nameAlienRace2 = AlienCiv2Name, pictureAlienRace2 = randomNumber2,
               soldiersAlienRace2 = AlienCiv2Soldiers, spacePlanesAlienRace2 = AlienCiv2SpacePlanes,
               spaceJetsAlienRace2 = AlienCiv2SpaceJets, tanksAlienRace2 = AlienCiv2Tanks,
               nuclearSatelitesAlienRace2 = AlienCiv2NuclearSatelites, militaryBaseAlienRace2 = randomMilitaryBaseAlien2Double,
               isAlienRace2Damaged = 2.0, alienRace2RelationWithPlayer = alienCiv2RelationWithPlayer,

               /*Alien civilisation 2 aspects written*/


               nameAlienRace3 = AlienCiv3Name, pictureAlienRace3 = randomNumber3,
               soldiersAlienRace3 = AlienCiv3Soldiers, spacePlanesAlienRace3 = AlienCiv3SpacePlanes,
               spaceJetsAlienRace3 = AlienCiv3SpaceJets, tanksAlienRace3 = AlienCiv3Tanks,
               nuclearSatelitesAlienRace3 = AlienCiv3NuclearSatelites, militaryBaseAlienRace3 = randomMilitaryBaseAlien3Double,
               isAlienRace3Damaged = 2.0, alienRace3RelationWithPlayer = alienCiv3RelationWithPlayer,

               /* Alien 3 */

               nameAlienRace4 = AlienCiv4Name, pictureAlienRace4 = randomNumber4,
               soldiersAlienRace4 = AlienCiv4Soldiers, spacePlanesAlienRace4 = AlienCiv4SpacePlanes,
               spaceJetsAlienRace4 = AlienCiv4SpaceJets, tanksAlienRace4 = AlienCiv4Tanks,
               nuclearSatelitesAlienRace4 = AlienCiv4NuclearSatelites, militaryBaseAlienRace4 = randomMilitaryBaseAlien4Double,
               isAlienRace4Damaged = 2.0, alienRace4RelationWithPlayer = alienCiv4RelationWithPlayer,

               /* Alien 4 */


               nameAlienRace5 = AlienCiv5Name, pictureAlienRace5 = randomNumber5,
               soldiersAlienRace5 = AlienCiv5Soldiers, spacePlanesAlienRace5 = AlienCiv5SpacePlanes,
               spaceJetsAlienRace5 = AlienCiv5SpaceJets, tanksAlienRace5 = AlienCiv5Tanks,
               nuclearSatelitesAlienRace5 = AlienCiv5NuclearSatelites, militaryBaseAlienRace5 = randomMilitaryBaseAlien5Double,
               isAlienRace5Damaged = 2.0, alienRace5RelationWithPlayer = alienCiv5RelationWithPlayer,

               /* Alien 5 */

               nameAlienRace6 = AlienCiv6Name, pictureAlienRace6 = randomNumber6,
               soldiersAlienRace6 = AlienCiv6Soldiers, spacePlanesAlienRace6 = AlienCiv6SpacePlanes,
               spaceJetsAlienRace6 = AlienCiv6SpaceJets, tanksAlienRace6 = AlienCiv6Tanks,
               nuclearSatelitesAlienRace6 = AlienCiv6NuclearSatelites, militaryBaseAlienRace6 = randomMilitaryBaseAlien6Double,
               isAlienRace6Damaged = 2.0, alienRace6RelationWithPlayer = alienCiv6RelationWithPlayer,

               /* Alien 6 */

               nameAlienRace7 = AlienCiv7Name, pictureAlienRace7 = randomNumber7,
               soldiersAlienRace7 = AlienCiv7Soldiers, spacePlanesAlienRace7 = AlienCiv7SpacePlanes,
               spaceJetsAlienRace7 = AlienCiv7SpaceJets, tanksAlienRace7 = AlienCiv7Tanks,
               nuclearSatelitesAlienRace7 = AlienCiv7NuclearSatelites, militaryBaseAlienRace7 = randomMilitaryBaseAlien7Double,
               isAlienRace7Damaged = 2.0, alienRace7RelationWithPlayer = alienCiv7RelationWithPlayer,

               /* Alien 7 */

               nameAlienRace8 = AlienCiv8Name, pictureAlienRace8 = randomNumber8,
               soldiersAlienRace8 = AlienCiv8Soldiers, spacePlanesAlienRace8 = AlienCiv8SpacePlanes,
               spaceJetsAlienRace8 = AlienCiv8SpaceJets, tanksAlienRace8 = AlienCiv8Tanks,
               nuclearSatelitesAlienRace8 = AlienCiv8NuclearSatelites, militaryBaseAlienRace8 = randomMilitaryBaseAlien8Double,
               isAlienRace8Damaged = 2.0, alienRace8RelationWithPlayer = alienCiv8RelationWithPlayer,

               /* Alien 8 */


               nameAlienRace9 = AlienCiv9Name, pictureAlienRace9 = 11,
               soldiersAlienRace9 = 400000.0, spacePlanesAlienRace9 = 50000.0,
               spaceJetsAlienRace9 = 15000.0, tanksAlienRace9 = 20000.0,
               nuclearSatelitesAlienRace9 = 1000.0, militaryBaseAlienRace9 = 5.0,
               isAlienRace9Damaged = 2.0, alienRace9RelationWithPlayer = 1.0,

               /* Alien 9 */

               nameAlienRace10 = AlienCiv10Name, pictureAlienRace10 = 11,
               soldiersAlienRace10 = 500000.0, spacePlanesAlienRace10 = 20000.0,
               spaceJetsAlienRace10 = 10000.0, tanksAlienRace10 = 10000.0,
               nuclearSatelitesAlienRace10 = 200.0, militaryBaseAlienRace10 = 5.0,
               isAlienRace10Damaged = 2.0, alienRace10RelationWithPlayer = 1.0,

               /* Alien 10 */

               nameAlienRace11 = AlienCiv11Name, pictureAlienRace11 = 11,
               soldiersAlienRace11 = 500000.0, spacePlanesAlienRace11 = 20000.0,
               spaceJetsAlienRace11 = 10000.0, tanksAlienRace11 = 40000.0,
               nuclearSatelitesAlienRace11 = 400.0, militaryBaseAlienRace11 = 5.0,
               isAlienRace11Damaged = 2.0, alienRace11RelationWithPlayer = 1.0,

               /* Alien 11 */



               nameAlienRace12 = AlienCiv12Name, pictureAlienRace12 = 11,
               soldiersAlienRace12 = 400000.0, spacePlanesAlienRace12 = 20000.0,
               spaceJetsAlienRace12 = 80000.0, tanksAlienRace12 = 40000.0,
               nuclearSatelitesAlienRace12 = 500.0, militaryBaseAlienRace12 = 5.0,
               isAlienRace12Damaged = 2.0, alienRace12RelationWithPlayer = 1.0,

               /* Alien 12 */

               nameAlienRace13 = AlienCiv13Name, pictureAlienRace13 = 11,
               soldiersAlienRace13 = 700000.0, spacePlanesAlienRace13 = 20000.0,
               spaceJetsAlienRace13 = 10000.0, tanksAlienRace13 = 40000.0,
               nuclearSatelitesAlienRace13 = 500.0, militaryBaseAlienRace13 = 5.0,
               isAlienRace13Damaged = 2.0, alienRace13RelationWithPlayer = 1.0,

               /* Alien 13 */

               nameAlienRace14 = AlienCiv14Name, pictureAlienRace14 = randomNumber14,
               soldiersAlienRace14 = AlienCiv14Soldiers, spacePlanesAlienRace14 = AlienCiv14SpacePlanes,
               spaceJetsAlienRace14 = AlienCiv14SpaceJets, tanksAlienRace14 = AlienCiv14Tanks,
               nuclearSatelitesAlienRace14 = AlienCiv14NuclearSatelites, militaryBaseAlienRace14 = randomMilitaryBaseAlien14Double,
               isAlienRace14Damaged = 2.0, alienRace14RelationWithPlayer = alienCiv14RelationWithPlayer,

               /* Alien 14 */


               nameAlienRace15 = AlienCiv15Name, pictureAlienRace15= randomNumber15,
               soldiersAlienRace15 = AlienCiv15Soldiers, spacePlanesAlienRace15 = AlienCiv15SpacePlanes,
               spaceJetsAlienRace15 = AlienCiv15SpaceJets, tanksAlienRace15 = AlienCiv15Tanks,
               nuclearSatelitesAlienRace15 = AlienCiv15NuclearSatelites, militaryBaseAlienRace15 = randomMilitaryBaseAlien15Double,
               isAlienRace15Damaged = 2.0, alienRace15RelationWithPlayer = alienCiv15RelationWithPlayer,

               /* Alien 15 */




               nameAlienRace16 = AlienCiv16Name, pictureAlienRace16 = randomNumber16,
               soldiersAlienRace16 = AlienCiv16Soldiers, spacePlanesAlienRace16 = AlienCiv16SpacePlanes,
               spaceJetsAlienRace16 = AlienCiv16SpaceJets, tanksAlienRace16 = AlienCiv16Tanks,
               nuclearSatelitesAlienRace16 = AlienCiv16NuclearSatelites, militaryBaseAlienRace16 = randomMilitaryBaseAlien16Double,
               isAlienRace16Damaged = 2.0, alienRace16RelationWithPlayer = alienCiv16RelationWithPlayer)

               /* Alien 16 */





           // Saving generated data of alien civilisations


           database.collection("users").document("User path").collection("Saved aliens data")
               .document("Aliens data").set(dataOfAlienCivilisations)


               .addOnCompleteListener {



               }

       }


    }









    fun isPlayerAttacked() {



            val intent = Intent(this, PlayerAttackedWarSimulator :: class.java)
            startActivity(intent)



    }





















}