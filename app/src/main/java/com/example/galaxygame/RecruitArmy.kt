package com.example.galaxygame

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class RecruitArmy : AppCompatActivity() {

    lateinit var soldierUnitImg : ImageView
    lateinit var airUnitImg : ImageView
    lateinit var cargoUnitImg : ImageView
    lateinit var sateliteUnitImg : ImageView
    lateinit var tankUnitImg : ImageView
    lateinit var airUnit2Img : ImageView

    lateinit var soldierRecruitArrow : ImageView
    lateinit var airplaneRecruitArrow : ImageView
    lateinit var cargoplaneRecruitArrow : ImageView
    lateinit var airplane2RecruitArrow : ImageView
    lateinit var tankRecruitArrow : ImageView
    lateinit var sateliteRecruitArrow : ImageView


    lateinit var soldierQuantityTxt : TextView
    lateinit var airplanequantityTxt : TextView
    lateinit var cargoplaneQuantityTxt : TextView
    lateinit var airplane2QuantityTxt : TextView
    lateinit var tankQuantityTxt : TextView
    lateinit var sateliteQuantityTxt : TextView

    lateinit var soldierTxt : TextView
    lateinit var airplaneTxt : TextView
    lateinit var cargoplaneTxt : TextView
    lateinit var airplane2Txt : TextView
    lateinit var tankTxt : TextView
    lateinit var sateliteTxt : TextView


    lateinit var recruitBtn : Button
    lateinit var backBtnMilitary : Button


    lateinit var database : FirebaseFirestore
    lateinit var savedDataOfUser : playerData






    var money : Int = 0
    var resourses : Int = 0
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




    lateinit var savedDataOfAliens : aliens













    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recruit_army)



        soldierUnitImg = findViewById(R.id.soldierUnitImg)
        airUnitImg = findViewById(R.id.airUnitImg)
        cargoUnitImg = findViewById(R.id.cargoUnitImg)
        sateliteUnitImg = findViewById(R.id.sateliteUnitImg)
        tankUnitImg = findViewById(R.id.tankUnitImg)
        airUnit2Img = findViewById(R.id.plane2Img)

        soldierRecruitArrow = findViewById(R.id.soldierRecruitArrow)
        airplaneRecruitArrow = findViewById(R.id.airplaneRecruitArrow)
        cargoplaneRecruitArrow = findViewById(R.id.cargoplaneRecruitArrow)
        airplane2RecruitArrow = findViewById(R.id.airplane2RecruitArrow)
        tankRecruitArrow = findViewById(R.id.tankRecruitArrow)
        sateliteRecruitArrow = findViewById(R.id.sateliteRecruitArrow)


        soldierQuantityTxt = findViewById(R.id.soldierQuantityTxt)
        airplanequantityTxt = findViewById(R.id.airUnitQuantityTxt)
        cargoplaneQuantityTxt = findViewById(R.id.cargoUnitQuantityTxt)
        airplane2QuantityTxt = findViewById(R.id.airUnit2QuantityTxt)
        tankQuantityTxt = findViewById(R.id.tankUnitQuantityTxt)
        sateliteQuantityTxt = findViewById(R.id.sateliteUnitQuantityTxt)


        soldierTxt = findViewById(R.id.soldierTxt)
        airplaneTxt = findViewById(R.id.airUnitTxt)
        cargoplaneTxt = findViewById(R.id.cargoUnitTxt)
        airplane2Txt = findViewById(R.id.airUnit2Txt)
        tankTxt = findViewById(R.id.tankUnitTxt)
        sateliteTxt = findViewById(R.id.sateliteUnitTxt)


        recruitBtn = findViewById(R.id.recruitBtn)
        backBtnMilitary = findViewById(R.id.backBtnMilitary)



        tankUnitImg.isVisible = false
        airUnit2Img.isVisible = false
        sateliteUnitImg.isVisible = false

        airplane2RecruitArrow.isVisible = false
        tankRecruitArrow.isVisible = false
        sateliteRecruitArrow.isVisible = false

        airplane2RecruitArrow.isEnabled = false
        tankRecruitArrow.isEnabled = false
        sateliteRecruitArrow.isEnabled = false

        airplane2QuantityTxt.isVisible = false
        tankQuantityTxt.isVisible = false
        sateliteQuantityTxt.isVisible = false

        airplane2Txt.isVisible = false
        tankTxt.isVisible = false
        sateliteTxt.isVisible = false



        database = Firebase.firestore





        soldierQuantityTxt.text = "$soldierQuantity"
        airplanequantityTxt.text = "$airplaneQuantity"
        cargoplaneQuantityTxt.text = "$cargoplaneQuantity"
        airplane2QuantityTxt.text = "$airplane2Quantity"
        tankQuantityTxt.text = "$tankQuantity"
        sateliteQuantityTxt.text = "$sateliteQuantity"




        database.collection("users").document("User path")
            .collection("Saved data")

            .addSnapshotListener { snapshot, e ->
                if (snapshot != null) {
                    for (document in snapshot.documents) {

                        savedDataOfUser = document.toObject()!!



                        // Sets the saved values from the database to the variables of the activity

                        money = savedDataOfUser.savedMoneyAmount
                        resourses = savedDataOfUser.savedResoursesAmount
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









                        // Displays the saved state and values of the views




                        soldierQuantityTxt.text = "$soldierQuantity"
                        airplanequantityTxt.text = "$airplaneQuantity"
                        cargoplaneQuantityTxt.text = "$cargoplaneQuantity"
                        airplane2QuantityTxt.text = "$airplane2Quantity"
                        tankQuantityTxt.text = "$tankQuantity"
                        sateliteQuantityTxt.text = "$sateliteQuantity"




                        if (levelMilitaryBase == 2) {

                            soldierUnitImg.setImageResource(R.drawable.trooptwo)
                            soldierTxt.text = "Soldier (currently LV2). HP= 20, damage= 10, speed = 20, critical probability= 10%. Money: 10, resourses: 25 for 1 unit "

                            tankUnitImg.isVisible = true
                            tankRecruitArrow.isVisible = true
                            tankRecruitArrow.isEnabled = true
                            tankQuantityTxt.isVisible = true
                            tankTxt.isVisible = true
                            tankRecruitArrow.isEnabled = true


                        } else if (levelMilitaryBase == 3) {

                            soldierUnitImg.setImageResource(R.drawable.trooptwo)
                            soldierTxt.text = "Soldier (currently LV2). HP= 20, damage= 10, speed = 20, critical probability= 10%. Money: 10, resourses: 25 for 1 unit "

                            tankUnitImg.isVisible = true
                            airUnit2Img.isVisible = true
                            sateliteUnitImg.isVisible = true
                            airplane2RecruitArrow.isVisible = true
                            tankRecruitArrow.isVisible = true
                            sateliteRecruitArrow.isVisible = true
                            airplane2QuantityTxt.isVisible = true
                            tankQuantityTxt.isVisible = true
                            sateliteQuantityTxt.isVisible = true
                            airplane2Txt.isVisible = true
                            tankTxt.isVisible = true
                            sateliteTxt.isVisible = true
                            airplane2RecruitArrow.isEnabled = true
                            tankRecruitArrow.isEnabled = true
                            sateliteRecruitArrow.isEnabled = true

                        } else if (levelMilitaryBase == 4) {

                            soldierUnitImg.setImageResource(R.drawable.troopthree)
                            soldierTxt.text = "Soldier (currently LV3). HP= 20, damage= 10, speed = 20, critical probability= 10%. Money: 10, resourses: 25 for 1 unit "

                            tankUnitImg.setImageResource(R.drawable.tanktwo)
                            tankTxt.text = "Tank (currently LV2). HP= 20, damage= 10, speed = 20, critical probability= 10%. Money: 10, resourses: 25 for 1 unit "

                            tankUnitImg.isVisible = true
                            airUnit2Img.isVisible = true
                            sateliteUnitImg.isVisible = true
                            airplane2RecruitArrow.isVisible = true
                            tankRecruitArrow.isVisible = true
                            sateliteRecruitArrow.isVisible = true
                            airplane2QuantityTxt.isVisible = true
                            tankQuantityTxt.isVisible = true
                            sateliteQuantityTxt.isVisible = true
                            airplane2Txt.isVisible = true
                            tankTxt.isVisible = true
                            sateliteTxt.isVisible = true
                            airplane2RecruitArrow.isEnabled = true
                            tankRecruitArrow.isEnabled = true
                            sateliteRecruitArrow.isEnabled = true

                        } else if (levelMilitaryBase == 5) {

                            soldierUnitImg.setImageResource(R.drawable.troopthree)
                            soldierTxt.text = "Soldier (currently LV3). HP= 20, damage= 10, speed = 20, critical probability= 10%. Money: 10, resourses: 25 for 1 unit "


                            tankUnitImg.setImageResource(R.drawable.tanktwo)
                            tankTxt.text = "Tank (currently LV2). HP= 20, damage= 10, speed = 20, critical probability= 10%. Money: 10, resourses: 25 for 1 unit "

                            sateliteUnitImg.setImageResource(R.drawable.ufo)
                            sateliteTxt.text = "Nuclear satelite (currently LV2). HP= 20, damage= 10, speed = 20, critical probability= 10%. Money: 10, resourses: 25 for 1 unit "

                            tankUnitImg.isVisible = true
                            airUnit2Img.isVisible = true
                            sateliteUnitImg.isVisible = true
                            airplane2RecruitArrow.isVisible = true
                            tankRecruitArrow.isVisible = true
                            sateliteRecruitArrow.isVisible = true
                            airplane2QuantityTxt.isVisible = true
                            tankQuantityTxt.isVisible = true
                            sateliteQuantityTxt.isVisible = true
                            airplane2Txt.isVisible = true
                            tankTxt.isVisible = true
                            sateliteTxt.isVisible = true
                            airplane2RecruitArrow.isEnabled = true
                            tankRecruitArrow.isEnabled = true
                            sateliteRecruitArrow.isEnabled = true

                        }








                    }
                }
            }







        // Fetching data of all alien civilisations



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













                    }
                }
            }

































        soldierRecruitArrow.setOnClickListener {

            if (money >= 10 && resourses >= 25) {
                money -= 10
                resourses -= 25
                soldierQuantity += 100
                soldierQuantityTxt.text = "$soldierQuantity"
            }


        }


        airplaneRecruitArrow.setOnClickListener {

            if (money >= 10 && resourses >= 25) {
                money -= 10
                resourses -= 25
                airplaneQuantity += 10
                airplanequantityTxt.text = "$airplaneQuantity"
            }

        }





        cargoplaneRecruitArrow.setOnClickListener {

            if (money >= 10 && resourses >= 25) {
                money -= 10
                resourses -= 25
                cargoplaneQuantity ++
                cargoplaneQuantityTxt.text = "$cargoplaneQuantity"
            }

        }




        airplane2RecruitArrow.setOnClickListener {

            if (money >= 10 && resourses >= 25) {
                money -= 10
                resourses -= 25
                airplane2Quantity += 10
                airplane2QuantityTxt.text = "$airplane2Quantity"
            }

        }





        tankRecruitArrow.setOnClickListener {

            if (money >= 10 && resourses >= 25) {
                money -= 10
                resourses -= 25
                tankQuantity += 10
                tankQuantityTxt.text = "$tankQuantity"
            }

        }



        sateliteRecruitArrow.setOnClickListener {

            if (money >= 10 && resourses >= 25) {
                money -= 10
                resourses -= 25
                sateliteQuantity ++
                sateliteQuantityTxt.text = "$sateliteQuantity"
            }

        }







        recruitBtn.setOnClickListener {

            // Aliens recruit too and their planet repairs

            var ifTheyRecruit = (1..10).shuffled().last()


            if (ifTheyRecruit == 5) {

                aliensRecruit()
                saveDataOfAliens()

            }



            savePlayerData()


        }


        backBtnMilitary.setOnClickListener {

            val intent = Intent(this, MainActivity :: class.java)
            startActivity(intent)

        }





    }


    override fun onBackPressed() {

        Toast.makeText(this, "This action is not allowed", Toast.LENGTH_SHORT).show()

    }






    fun saveDataOfAliens() {



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























    fun savePlayerData() {








        var data = playerData(savedMoneyAmount = money, savedResoursesAmount = resourses,
            savedLevelInfrastructure = levelInfrastructure, savedLevelFactory = levelFactory, savedLevelMilitaryBase= levelMilitaryBase,
            savedLevelGeneralDevelopment = levelGeneralDevelopment, savedLevelScienficResearch = levelScientificDevelopment, savedLevelSpionage = levelSpionage,
            savedSoldierUnitQuantity = soldierQuantity, savedAirplaneUnitQuantity = airplaneQuantity,
            savedCargoPlaneQuantity = cargoplaneQuantity, savedAirplane2UnitQuantity= airplane2Quantity, savedTankUnitQuantity= tankQuantity,
            savedSateliteUnitQuantity= sateliteQuantity, isDamagedAlive = isDamagedAlivePlayer, colonyId1 = colonyId1,
            colonyResourses1 = colonyResourses1)



        database.collection("users").document("User path").collection("Saved data")
            .document("hmkogjk").set(data)


            .addOnCompleteListener {

                Toast.makeText(this, "Units recruited succesfully", Toast.LENGTH_SHORT).show()


            }






    }





    fun aliensRecruit() {


        var soldiersIncrease = (50..100).shuffled().last()
        var spacePlaneIncrease = (10..20).shuffled().last()
        var tanksIncrease = (5..10).shuffled().last()
        var spaceJetsIncrease = (5..10).shuffled().last()

        var repaiPlanet = (1..3).shuffled().last()


        // Alien 1


        if (AlienCiv1MilitaryBase!! == 1.0) {

            AlienCiv1Soldiers = AlienCiv1Soldiers!! + soldiersIncrease
            AlienCiv1SpacePlanes = AlienCiv1SpacePlanes!! + spacePlaneIncrease

        } else if (AlienCiv1MilitaryBase!! == 2.0) {

            AlienCiv1Soldiers = AlienCiv1Soldiers!! + soldiersIncrease
            AlienCiv1SpacePlanes = AlienCiv1SpacePlanes!! + spacePlaneIncrease
            AlienCiv1Tanks = AlienCiv1Tanks!! + tanksIncrease

        } else if (AlienCiv1MilitaryBase!! >= 3.0) {

            AlienCiv1Soldiers = AlienCiv1Soldiers!! + soldiersIncrease
            AlienCiv1SpacePlanes = AlienCiv1SpacePlanes!! + spacePlaneIncrease
            AlienCiv1Tanks = AlienCiv1Tanks!! + tanksIncrease
            AlienCiv1SpaceJets = AlienCiv1SpaceJets!! + spaceJetsIncrease


        }

        if (repaiPlanet == 2 && isAlienCiv1Damaged!! > 0) {
            isAlienCiv1Damaged = 2.0
        }







        // Alien 2


        if (AlienCiv2MilitaryBase!! == 1.0) {

            AlienCiv2Soldiers = AlienCiv2Soldiers!! + soldiersIncrease
            AlienCiv2SpacePlanes = AlienCiv2SpacePlanes!! + spacePlaneIncrease

        } else if (AlienCiv2MilitaryBase!! == 2.0) {

            AlienCiv2Soldiers = AlienCiv2Soldiers!! + soldiersIncrease
            AlienCiv2SpacePlanes = AlienCiv2SpacePlanes!! + spacePlaneIncrease
            AlienCiv2Tanks = AlienCiv2Tanks!! + tanksIncrease

        } else if (AlienCiv2MilitaryBase!! >= 3.0) {

            AlienCiv2Soldiers = AlienCiv2Soldiers!! + soldiersIncrease
            AlienCiv2SpacePlanes = AlienCiv2SpacePlanes!! + spacePlaneIncrease
            AlienCiv2Tanks = AlienCiv2Tanks!! + tanksIncrease
            AlienCiv2SpaceJets = AlienCiv2SpaceJets!! + spaceJetsIncrease


        }

        if (repaiPlanet == 2 && isAlienCiv2Damaged!! > 0) {
            isAlienCiv2Damaged = 2.0
        }














    }














}