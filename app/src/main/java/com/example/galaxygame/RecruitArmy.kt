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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
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






    var AlienCiv3Name : String? = null
    var AlienCiv3Picture : Int? = null
    var AlienCiv3MilitaryBase : Double? = null
    var AlienCiv3Soldiers : Double? = null
    var AlienCiv3SpacePlanes : Double? = null
    var AlienCiv3SpaceJets : Double? = null
    var AlienCiv3Tanks : Double? = null
    var AlienCiv3NuclearSatelites : Double? = null
    var isAlienCiv3Damaged : Double? = null
    var alienCiv3RelationWithPlayer : Double? = null





    var AlienCiv4Name : String? = null
    var AlienCiv4Picture : Int? = null
    var AlienCiv4MilitaryBase : Double? = null
    var AlienCiv4Soldiers : Double? = null
    var AlienCiv4SpacePlanes : Double? = null
    var AlienCiv4SpaceJets : Double? = null
    var AlienCiv4Tanks : Double? = null
    var AlienCiv4NuclearSatelites : Double? = null
    var isAlienCiv4Damaged : Double? = null
    var alienCiv4RelationWithPlayer : Double? = null






    var AlienCiv5Name : String? = null
    var AlienCiv5Picture : Int? = null
    var AlienCiv5MilitaryBase : Double? = null
    var AlienCiv5Soldiers : Double? = null
    var AlienCiv5SpacePlanes : Double? = null
    var AlienCiv5SpaceJets : Double? = null
    var AlienCiv5Tanks : Double? = null
    var AlienCiv5NuclearSatelites : Double? = null
    var isAlienCiv5Damaged : Double? = null
    var alienCiv5RelationWithPlayer : Double? = null







    var AlienCiv6Name : String? = null
    var AlienCiv6Picture : Int? = null
    var AlienCiv6MilitaryBase : Double? = null
    var AlienCiv6Soldiers : Double? = null
    var AlienCiv6SpacePlanes : Double? = null
    var AlienCiv6SpaceJets : Double? = null
    var AlienCiv6Tanks : Double? = null
    var AlienCiv6NuclearSatelites : Double? = null
    var isAlienCiv6Damaged : Double? = null
    var alienCiv6RelationWithPlayer : Double? = null




    var AlienCiv7Name : String? = null
    var AlienCiv7Picture : Int? = null
    var AlienCiv7MilitaryBase : Double? = null
    var AlienCiv7Soldiers : Double? = null
    var AlienCiv7SpacePlanes : Double? = null
    var AlienCiv7SpaceJets : Double? = null
    var AlienCiv7Tanks : Double? = null
    var AlienCiv7NuclearSatelites : Double? = null
    var isAlienCiv7Damaged : Double? = null
    var alienCiv7RelationWithPlayer : Double? = null






    var AlienCiv8Name : String? = null
    var AlienCiv8Picture : Int? = null
    var AlienCiv8MilitaryBase : Double? = null
    var AlienCiv8Soldiers : Double? = null
    var AlienCiv8SpacePlanes : Double? = null
    var AlienCiv8SpaceJets : Double? = null
    var AlienCiv8Tanks : Double? = null
    var AlienCiv8NuclearSatelites : Double? = null
    var isAlienCiv8Damaged : Double? = null
    var alienCiv8RelationWithPlayer : Double? = null







    var AlienCiv9Name : String? = null
    var AlienCiv9Picture : Int? = null
    var AlienCiv9MilitaryBase : Double? = null
    var AlienCiv9Soldiers : Double? = null
    var AlienCiv9SpacePlanes : Double? = null
    var AlienCiv9SpaceJets : Double? = null
    var AlienCiv9Tanks : Double? = null
    var AlienCiv9NuclearSatelites : Double? = null
    var isAlienCiv9Damaged : Double? = null
    var alienCiv9RelationWithPlayer : Double? = null






    var AlienCiv10Name : String? = null
    var AlienCiv10Picture : Int? = null
    var AlienCiv10MilitaryBase : Double? = null
    var AlienCiv10Soldiers : Double? = null
    var AlienCiv10SpacePlanes : Double? = null
    var AlienCiv10SpaceJets : Double? = null
    var AlienCiv10Tanks : Double? = null
    var AlienCiv10NuclearSatelites : Double? = null
    var isAlienCiv10Damaged : Double? = null
    var alienCiv10RelationWithPlayer : Double? = null





    var AlienCiv11Name : String? = null
    var AlienCiv11Picture : Int? = null
    var AlienCiv11MilitaryBase : Double? = null
    var AlienCiv11Soldiers : Double? = null
    var AlienCiv11SpacePlanes : Double? = null
    var AlienCiv11SpaceJets : Double? = null
    var AlienCiv11Tanks : Double? = null
    var AlienCiv11NuclearSatelites : Double? = null
    var isAlienCiv11Damaged : Double? = null
    var alienCiv11RelationWithPlayer : Double? = null






    var AlienCiv12Name : String? = null
    var AlienCiv12Picture : Int? = null
    var AlienCiv12MilitaryBase : Double? = null
    var AlienCiv12Soldiers : Double? = null
    var AlienCiv12SpacePlanes : Double? = null
    var AlienCiv12SpaceJets : Double? = null
    var AlienCiv12Tanks : Double? = null
    var AlienCiv12NuclearSatelites : Double? = null
    var isAlienCiv12Damaged : Double? = null
    var alienCiv12RelationWithPlayer : Double? = null






    var AlienCiv13Name : String? = null
    var AlienCiv13Picture : Int? = null
    var AlienCiv13MilitaryBase : Double? = null
    var AlienCiv13Soldiers : Double? = null
    var AlienCiv13SpacePlanes : Double? = null
    var AlienCiv13SpaceJets : Double? = null
    var AlienCiv13Tanks : Double? = null
    var AlienCiv13NuclearSatelites : Double? = null
    var isAlienCiv13Damaged : Double? = null
    var alienCiv13RelationWithPlayer : Double? = null






    var AlienCiv14Name : String? = null
    var AlienCiv14Picture : Int? = null
    var AlienCiv14MilitaryBase : Double? = null
    var AlienCiv14Soldiers : Double? = null
    var AlienCiv14SpacePlanes : Double? = null
    var AlienCiv14SpaceJets : Double? = null
    var AlienCiv14Tanks : Double? = null
    var AlienCiv14NuclearSatelites : Double? = null
    var isAlienCiv14Damaged : Double? = null
    var alienCiv14RelationWithPlayer : Double? = null




    var AlienCiv15Name : String? = null
    var AlienCiv15Picture : Int? = null
    var AlienCiv15MilitaryBase : Double? = null
    var AlienCiv15Soldiers : Double? = null
    var AlienCiv15SpacePlanes : Double? = null
    var AlienCiv15SpaceJets : Double? = null
    var AlienCiv15Tanks : Double? = null
    var AlienCiv15NuclearSatelites : Double? = null
    var isAlienCiv15Damaged : Double? = null
    var alienCiv15RelationWithPlayer : Double? = null







    var AlienCiv16Name : String? = null
    var AlienCiv16Picture : Int? = null
    var AlienCiv16MilitaryBase : Double? = null
    var AlienCiv16Soldiers : Double? = null
    var AlienCiv16SpacePlanes : Double? = null
    var AlienCiv16SpaceJets : Double? = null
    var AlienCiv16Tanks : Double? = null
    var AlienCiv16NuclearSatelites : Double? = null
    var isAlienCiv16Damaged : Double? = null
    var alienCiv16RelationWithPlayer : Double? = null

















    lateinit var savedDataOfAliens : aliens
    lateinit var auth : FirebaseAuth













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
        auth = Firebase.auth
        val user = auth.currentUser





        soldierQuantityTxt.text = "$soldierQuantity"
        airplanequantityTxt.text = "$airplaneQuantity"
        cargoplaneQuantityTxt.text = "$cargoplaneQuantity"
        airplane2QuantityTxt.text = "$airplane2Quantity"
        tankQuantityTxt.text = "$tankQuantity"
        sateliteQuantityTxt.text = "$sateliteQuantity"




        if (user != null) {

            database.collection("users").document(user.uid)
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
                                soldierTxt.text =
                                    "Soldier (currently LV2). HP= 15, damage= 25, speed = 20, critical probability= 15%. Money: 30, resourses: 30 for 100 units "

                                tankUnitImg.isVisible = true
                                tankRecruitArrow.isVisible = true
                                tankRecruitArrow.isEnabled = true
                                tankQuantityTxt.isVisible = true
                                tankTxt.isVisible = true
                                tankRecruitArrow.isEnabled = true


                            } else if (levelMilitaryBase == 3) {

                                soldierUnitImg.setImageResource(R.drawable.trooptwo)
                                soldierTxt.text =
                                    "Soldier (currently LV2). HP= 15, damage= 25, speed = 20, critical probability= 15%. Money: 30, resourses: 30 for 100 units "

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
                                soldierTxt.text =
                                    "Soldier (currently LV3). HP= 40, damage= 40, speed = 35, critical probability= 20%. Money: 300, resourses: 300 for 100 units "

                                tankUnitImg.setImageResource(R.drawable.tanktwo)
                                tankTxt.text =
                                    "Tank (currently LV2). HP= 2000, damage= 100, speed = 10, critical probability= 15%. Money: 1000, resourses: 1000 for 10 units "

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
                                soldierTxt.text =
                                    "Soldier (currently LV3). HP= 40, damage= 40, speed = 35, critical probability= 20%. Money: 300, resourses: 300 for 100 units "


                                tankUnitImg.setImageResource(R.drawable.tanktwo)
                                tankTxt.text =
                                    "Tank (currently LV2). HP= 2000, damage= 100, speed = 10, critical probability= 15%. Money: 1000, resourses: 1000 for 10 units "

                                sateliteUnitImg.setImageResource(R.drawable.ufo)
                                sateliteTxt.text =
                                    "Nuclear satelite (currently LV2). Ends a civilisation in one strike (applies only to player and Zorgon). Cost 4000 money, 4000 resourses for 1 unit"

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

        }







        // Fetching data of all alien civilisations


        if (user != null) {


            database.collection("users").document(user.uid)
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
                            alienCiv1RelationWithPlayer =
                                savedDataOfAliens.alienRace1RelationWithPlayer


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
                            alienCiv2RelationWithPlayer =
                                savedDataOfAliens.alienRace2RelationWithPlayer


                            // Fetches the data of 3 civilisation in galaxy

                            AlienCiv3Name = savedDataOfAliens.nameAlienRace3
                            AlienCiv3Picture = savedDataOfAliens.pictureAlienRace3
                            AlienCiv3MilitaryBase = savedDataOfAliens.militaryBaseAlienRace3
                            AlienCiv3Soldiers = savedDataOfAliens.soldiersAlienRace3
                            AlienCiv3SpacePlanes = savedDataOfAliens.spacePlanesAlienRace3
                            AlienCiv3SpaceJets = savedDataOfAliens.spaceJetsAlienRace3
                            AlienCiv3Tanks = savedDataOfAliens.tanksAlienRace3
                            AlienCiv3NuclearSatelites = savedDataOfAliens.nuclearSatelitesAlienRace3
                            isAlienCiv3Damaged = savedDataOfAliens.isAlienRace3Damaged
                            alienCiv3RelationWithPlayer =
                                savedDataOfAliens.alienRace3RelationWithPlayer


                            // Fetches the data of 4 civilisation in galaxy

                            AlienCiv4Name = savedDataOfAliens.nameAlienRace4
                            AlienCiv4Picture = savedDataOfAliens.pictureAlienRace4
                            AlienCiv4MilitaryBase = savedDataOfAliens.militaryBaseAlienRace4
                            AlienCiv4Soldiers = savedDataOfAliens.soldiersAlienRace4
                            AlienCiv4SpacePlanes = savedDataOfAliens.spacePlanesAlienRace4
                            AlienCiv4SpaceJets = savedDataOfAliens.spaceJetsAlienRace4
                            AlienCiv4Tanks = savedDataOfAliens.tanksAlienRace4
                            AlienCiv4NuclearSatelites = savedDataOfAliens.nuclearSatelitesAlienRace4
                            isAlienCiv4Damaged = savedDataOfAliens.isAlienRace4Damaged
                            alienCiv4RelationWithPlayer =
                                savedDataOfAliens.alienRace4RelationWithPlayer


                            // Fetches the data of 5 civilisation in galaxy

                            AlienCiv5Name = savedDataOfAliens.nameAlienRace5
                            AlienCiv5Picture = savedDataOfAliens.pictureAlienRace5
                            AlienCiv5MilitaryBase = savedDataOfAliens.militaryBaseAlienRace5
                            AlienCiv5Soldiers = savedDataOfAliens.soldiersAlienRace5
                            AlienCiv5SpacePlanes = savedDataOfAliens.spacePlanesAlienRace5
                            AlienCiv5SpaceJets = savedDataOfAliens.spaceJetsAlienRace5
                            AlienCiv5Tanks = savedDataOfAliens.tanksAlienRace5
                            AlienCiv5NuclearSatelites = savedDataOfAliens.nuclearSatelitesAlienRace5
                            isAlienCiv5Damaged = savedDataOfAliens.isAlienRace5Damaged
                            alienCiv5RelationWithPlayer =
                                savedDataOfAliens.alienRace5RelationWithPlayer


                            // Fetches the data of 6 civilisation in galaxy

                            AlienCiv6Name = savedDataOfAliens.nameAlienRace6
                            AlienCiv6Picture = savedDataOfAliens.pictureAlienRace6
                            AlienCiv6MilitaryBase = savedDataOfAliens.militaryBaseAlienRace6
                            AlienCiv6Soldiers = savedDataOfAliens.soldiersAlienRace6
                            AlienCiv6SpacePlanes = savedDataOfAliens.spacePlanesAlienRace6
                            AlienCiv6SpaceJets = savedDataOfAliens.spaceJetsAlienRace6
                            AlienCiv6Tanks = savedDataOfAliens.tanksAlienRace6
                            AlienCiv6NuclearSatelites = savedDataOfAliens.nuclearSatelitesAlienRace6
                            isAlienCiv6Damaged = savedDataOfAliens.isAlienRace6Damaged
                            alienCiv6RelationWithPlayer =
                                savedDataOfAliens.alienRace6RelationWithPlayer


                            // Fetches the data of 7 civilisation in galaxy

                            AlienCiv7Name = savedDataOfAliens.nameAlienRace7
                            AlienCiv7Picture = savedDataOfAliens.pictureAlienRace7
                            AlienCiv7MilitaryBase = savedDataOfAliens.militaryBaseAlienRace7
                            AlienCiv7Soldiers = savedDataOfAliens.soldiersAlienRace7
                            AlienCiv7SpacePlanes = savedDataOfAliens.spacePlanesAlienRace7
                            AlienCiv7SpaceJets = savedDataOfAliens.spaceJetsAlienRace7
                            AlienCiv7Tanks = savedDataOfAliens.tanksAlienRace7
                            AlienCiv7NuclearSatelites = savedDataOfAliens.nuclearSatelitesAlienRace7
                            isAlienCiv7Damaged = savedDataOfAliens.isAlienRace7Damaged
                            alienCiv7RelationWithPlayer =
                                savedDataOfAliens.alienRace7RelationWithPlayer


                            // Fetches the data of 8 civilisation in galaxy

                            AlienCiv8Name = savedDataOfAliens.nameAlienRace8
                            AlienCiv8Picture = savedDataOfAliens.pictureAlienRace8
                            AlienCiv8MilitaryBase = savedDataOfAliens.militaryBaseAlienRace8
                            AlienCiv8Soldiers = savedDataOfAliens.soldiersAlienRace8
                            AlienCiv8SpacePlanes = savedDataOfAliens.spacePlanesAlienRace8
                            AlienCiv8SpaceJets = savedDataOfAliens.spaceJetsAlienRace8
                            AlienCiv8Tanks = savedDataOfAliens.tanksAlienRace8
                            AlienCiv8NuclearSatelites = savedDataOfAliens.nuclearSatelitesAlienRace8
                            isAlienCiv8Damaged = savedDataOfAliens.isAlienRace8Damaged
                            alienCiv8RelationWithPlayer =
                                savedDataOfAliens.alienRace8RelationWithPlayer


                            // Fetches the data of 9 civilisation in galaxy

                            AlienCiv9Name = savedDataOfAliens.nameAlienRace9
                            AlienCiv9Picture = savedDataOfAliens.pictureAlienRace9
                            AlienCiv9MilitaryBase = savedDataOfAliens.militaryBaseAlienRace9
                            AlienCiv9Soldiers = savedDataOfAliens.soldiersAlienRace9
                            AlienCiv9SpacePlanes = savedDataOfAliens.spacePlanesAlienRace9
                            AlienCiv9SpaceJets = savedDataOfAliens.spaceJetsAlienRace9
                            AlienCiv9Tanks = savedDataOfAliens.tanksAlienRace9
                            AlienCiv9NuclearSatelites = savedDataOfAliens.nuclearSatelitesAlienRace9
                            isAlienCiv9Damaged = savedDataOfAliens.isAlienRace9Damaged
                            alienCiv9RelationWithPlayer =
                                savedDataOfAliens.alienRace9RelationWithPlayer


                            // Fetches the data of 10 civilisation in galaxy

                            AlienCiv10Name = savedDataOfAliens.nameAlienRace10
                            AlienCiv10Picture = savedDataOfAliens.pictureAlienRace10
                            AlienCiv10MilitaryBase = savedDataOfAliens.militaryBaseAlienRace10
                            AlienCiv10Soldiers = savedDataOfAliens.soldiersAlienRace10
                            AlienCiv10SpacePlanes = savedDataOfAliens.spacePlanesAlienRace10
                            AlienCiv10SpaceJets = savedDataOfAliens.spaceJetsAlienRace10
                            AlienCiv10Tanks = savedDataOfAliens.tanksAlienRace10
                            AlienCiv10NuclearSatelites =
                                savedDataOfAliens.nuclearSatelitesAlienRace10
                            isAlienCiv10Damaged = savedDataOfAliens.isAlienRace10Damaged
                            alienCiv10RelationWithPlayer =
                                savedDataOfAliens.alienRace10RelationWithPlayer


                            // Fetches the data of 11 civilisation in galaxy

                            AlienCiv11Name = savedDataOfAliens.nameAlienRace11
                            AlienCiv11Picture = savedDataOfAliens.pictureAlienRace11
                            AlienCiv11MilitaryBase = savedDataOfAliens.militaryBaseAlienRace11
                            AlienCiv11Soldiers = savedDataOfAliens.soldiersAlienRace11
                            AlienCiv11SpacePlanes = savedDataOfAliens.spacePlanesAlienRace11
                            AlienCiv11SpaceJets = savedDataOfAliens.spaceJetsAlienRace11
                            AlienCiv11Tanks = savedDataOfAliens.tanksAlienRace11
                            AlienCiv11NuclearSatelites =
                                savedDataOfAliens.nuclearSatelitesAlienRace11
                            isAlienCiv11Damaged = savedDataOfAliens.isAlienRace11Damaged
                            alienCiv11RelationWithPlayer =
                                savedDataOfAliens.alienRace11RelationWithPlayer


                            // Fetches the data of 12 civilisation in galaxy

                            AlienCiv12Name = savedDataOfAliens.nameAlienRace12
                            AlienCiv12Picture = savedDataOfAliens.pictureAlienRace12
                            AlienCiv12MilitaryBase = savedDataOfAliens.militaryBaseAlienRace12
                            AlienCiv12Soldiers = savedDataOfAliens.soldiersAlienRace12
                            AlienCiv12SpacePlanes = savedDataOfAliens.spacePlanesAlienRace12
                            AlienCiv12SpaceJets = savedDataOfAliens.spaceJetsAlienRace12
                            AlienCiv12Tanks = savedDataOfAliens.tanksAlienRace12
                            AlienCiv12NuclearSatelites =
                                savedDataOfAliens.nuclearSatelitesAlienRace12
                            isAlienCiv12Damaged = savedDataOfAliens.isAlienRace12Damaged
                            alienCiv12RelationWithPlayer =
                                savedDataOfAliens.alienRace12RelationWithPlayer


                            // Fetches the data of 13 civilisation in galaxy

                            AlienCiv13Name = savedDataOfAliens.nameAlienRace13
                            AlienCiv13Picture = savedDataOfAliens.pictureAlienRace13
                            AlienCiv13MilitaryBase = savedDataOfAliens.militaryBaseAlienRace13
                            AlienCiv13Soldiers = savedDataOfAliens.soldiersAlienRace13
                            AlienCiv13SpacePlanes = savedDataOfAliens.spacePlanesAlienRace13
                            AlienCiv13SpaceJets = savedDataOfAliens.spaceJetsAlienRace13
                            AlienCiv13Tanks = savedDataOfAliens.tanksAlienRace13
                            AlienCiv13NuclearSatelites =
                                savedDataOfAliens.nuclearSatelitesAlienRace13
                            isAlienCiv13Damaged = savedDataOfAliens.isAlienRace13Damaged
                            alienCiv13RelationWithPlayer =
                                savedDataOfAliens.alienRace13RelationWithPlayer


                            // Fetches the data of 14 civilisation in galaxy

                            AlienCiv14Name = savedDataOfAliens.nameAlienRace14
                            AlienCiv14Picture = savedDataOfAliens.pictureAlienRace14
                            AlienCiv14MilitaryBase = savedDataOfAliens.militaryBaseAlienRace14
                            AlienCiv14Soldiers = savedDataOfAliens.soldiersAlienRace14
                            AlienCiv14SpacePlanes = savedDataOfAliens.spacePlanesAlienRace14
                            AlienCiv14SpaceJets = savedDataOfAliens.spaceJetsAlienRace14
                            AlienCiv14Tanks = savedDataOfAliens.tanksAlienRace14
                            AlienCiv14NuclearSatelites =
                                savedDataOfAliens.nuclearSatelitesAlienRace14
                            isAlienCiv14Damaged = savedDataOfAliens.isAlienRace14Damaged
                            alienCiv14RelationWithPlayer =
                                savedDataOfAliens.alienRace14RelationWithPlayer


                            // Fetches the data of 15 civilisation in galaxy

                            AlienCiv15Name = savedDataOfAliens.nameAlienRace15
                            AlienCiv15Picture = savedDataOfAliens.pictureAlienRace15
                            AlienCiv15MilitaryBase = savedDataOfAliens.militaryBaseAlienRace15
                            AlienCiv15Soldiers = savedDataOfAliens.soldiersAlienRace15
                            AlienCiv15SpacePlanes = savedDataOfAliens.spacePlanesAlienRace15
                            AlienCiv15SpaceJets = savedDataOfAliens.spaceJetsAlienRace15
                            AlienCiv15Tanks = savedDataOfAliens.tanksAlienRace15
                            AlienCiv15NuclearSatelites =
                                savedDataOfAliens.nuclearSatelitesAlienRace15
                            isAlienCiv15Damaged = savedDataOfAliens.isAlienRace15Damaged
                            alienCiv15RelationWithPlayer =
                                savedDataOfAliens.alienRace15RelationWithPlayer


                            // Fetches the data of 16 civilisation in galaxy

                            AlienCiv16Name = savedDataOfAliens.nameAlienRace16
                            AlienCiv16Picture = savedDataOfAliens.pictureAlienRace16
                            AlienCiv16MilitaryBase = savedDataOfAliens.militaryBaseAlienRace16
                            AlienCiv16Soldiers = savedDataOfAliens.soldiersAlienRace16
                            AlienCiv16SpacePlanes = savedDataOfAliens.spacePlanesAlienRace16
                            AlienCiv16SpaceJets = savedDataOfAliens.spaceJetsAlienRace16
                            AlienCiv16Tanks = savedDataOfAliens.tanksAlienRace16
                            AlienCiv16NuclearSatelites =
                                savedDataOfAliens.nuclearSatelitesAlienRace16
                            isAlienCiv16Damaged = savedDataOfAliens.isAlienRace16Damaged
                            alienCiv16RelationWithPlayer =
                                savedDataOfAliens.alienRace16RelationWithPlayer


                        }
                    }
                }

        }

































        soldierRecruitArrow.setOnClickListener {

            if (money >= 4 && resourses >= 4 && levelMilitaryBase == 1) {
                money -= 4
                resourses -= 4
                soldierQuantity += 100
                soldierQuantityTxt.text = "$soldierQuantity"

            } else if (money >= 30 && resourses >= 30 && levelMilitaryBase == 2) {

                money -= 30
                resourses -= 30
                soldierQuantity += 100
                soldierQuantityTxt.text = "$soldierQuantity"

            } else if (money >= 30 && resourses >= 30 && levelMilitaryBase == 3) {
                money -= 30
                resourses -= 30
                soldierQuantity += 100
                soldierQuantityTxt.text = "$soldierQuantity"

            } else if (money >= 300 && resourses >= 300 && levelMilitaryBase >= 4) {

                money -= 300
                resourses -= 300
                soldierQuantity += 100
                soldierQuantityTxt.text = "$soldierQuantity"

            }


        }









        airplaneRecruitArrow.setOnClickListener {

            if (money >= 40 && resourses >= 40) {
                money -= 40
                resourses -= 40
                airplaneQuantity += 10
                airplanequantityTxt.text = "$airplaneQuantity"
            }

        }





        cargoplaneRecruitArrow.setOnClickListener {

            if (money >= 100 && resourses >= 100) {
                money -= 100
                resourses -= 100
                cargoplaneQuantity ++
                cargoplaneQuantityTxt.text = "$cargoplaneQuantity"
            }

        }




        airplane2RecruitArrow.setOnClickListener {

            if (money >= 500 && resourses >= 500) {
                money -= 500
                resourses -= 500
                airplane2Quantity += 10
                airplane2QuantityTxt.text = "$airplane2Quantity"
            }

        }





        tankRecruitArrow.setOnClickListener {

            if (money >= 250 && resourses >= 250 && levelMilitaryBase < 4) {
                money -= 250
                resourses -= 250
                tankQuantity += 10
                tankQuantityTxt.text = "$tankQuantity"

            } else if (money >= 1000 && resourses >= 1000 && levelMilitaryBase >= 4) {

                money -= 1000
                resourses -= 1000
                tankQuantity += 10
                tankQuantityTxt.text = "$tankQuantity"


            }

        }



        sateliteRecruitArrow.setOnClickListener {

            if (money >= 1000 && resourses >= 1000 && levelMilitaryBase < 5) {
                money -= 1000
                resourses -= 1000
                sateliteQuantity ++
                sateliteQuantityTxt.text = "$sateliteQuantity"

            } else if (money >= 4000 && resourses >= 4000 && levelMilitaryBase == 5) {

                money -= 4000
                resourses -= 4000
                sateliteQuantity ++
                sateliteQuantityTxt.text = "$sateliteQuantity"

            }

        }







        recruitBtn.setOnClickListener {

            // Aliens recruit too and their planet repairs

            var ifTheyRecruit = (1..10).shuffled().last()


            if (ifTheyRecruit == 5 && AlienCiv1Name != null) {

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



        var dataOfAlienCivilisations = aliens(nameAlienRace1 = AlienCiv1Name, pictureAlienRace1 = AlienCiv1Picture,
            soldiersAlienRace1 = AlienCiv1Soldiers, spacePlanesAlienRace1 = AlienCiv1SpacePlanes,
            spaceJetsAlienRace1 = AlienCiv1SpaceJets, tanksAlienRace1 = AlienCiv1Tanks,
            nuclearSatelitesAlienRace1 = AlienCiv1NuclearSatelites,  militaryBaseAlienRace1 = AlienCiv1MilitaryBase,
            isAlienRace1Damaged = isAlienCiv1Damaged, alienRace1RelationWithPlayer = alienCiv1RelationWithPlayer,

            /*Alien civilisation 1 aspects written*/

            nameAlienRace2 = AlienCiv2Name, pictureAlienRace2 = AlienCiv2Picture,
            soldiersAlienRace2 = AlienCiv2Soldiers, spacePlanesAlienRace2 = AlienCiv2SpacePlanes,
            spaceJetsAlienRace2 = AlienCiv2SpaceJets, tanksAlienRace2 = AlienCiv2Tanks,
            nuclearSatelitesAlienRace2 = AlienCiv2NuclearSatelites, militaryBaseAlienRace2 = AlienCiv2MilitaryBase,
            isAlienRace2Damaged = isAlienCiv2Damaged, alienRace2RelationWithPlayer = alienCiv2RelationWithPlayer,

            /*Alien civilisation 2 aspects written*/


            nameAlienRace3 = AlienCiv3Name, pictureAlienRace3 = AlienCiv3Picture,
            soldiersAlienRace3 = AlienCiv3Soldiers, spacePlanesAlienRace3 = AlienCiv3SpacePlanes,
            spaceJetsAlienRace3 = AlienCiv3SpaceJets, tanksAlienRace3 = AlienCiv3Tanks,
            nuclearSatelitesAlienRace3 = AlienCiv3NuclearSatelites, militaryBaseAlienRace3 = AlienCiv3MilitaryBase,
            isAlienRace3Damaged = isAlienCiv3Damaged, alienRace3RelationWithPlayer = alienCiv3RelationWithPlayer,

            /* Alien 3 */

            nameAlienRace4 = AlienCiv4Name, pictureAlienRace4 = AlienCiv4Picture,
            soldiersAlienRace4 = AlienCiv4Soldiers, spacePlanesAlienRace4 = AlienCiv4SpacePlanes,
            spaceJetsAlienRace4 = AlienCiv4SpaceJets, tanksAlienRace4 = AlienCiv4Tanks,
            nuclearSatelitesAlienRace4 = AlienCiv4NuclearSatelites, militaryBaseAlienRace4 = AlienCiv4MilitaryBase,
            isAlienRace4Damaged = isAlienCiv4Damaged, alienRace4RelationWithPlayer = alienCiv4RelationWithPlayer,

            /* Alien 4 */


            nameAlienRace5 = AlienCiv5Name, pictureAlienRace5 = AlienCiv5Picture,
            soldiersAlienRace5 = AlienCiv5Soldiers, spacePlanesAlienRace5 = AlienCiv5SpacePlanes,
            spaceJetsAlienRace5 = AlienCiv5SpaceJets, tanksAlienRace5 = AlienCiv5Tanks,
            nuclearSatelitesAlienRace5 = AlienCiv5NuclearSatelites, militaryBaseAlienRace5 = AlienCiv5MilitaryBase,
            isAlienRace5Damaged = isAlienCiv5Damaged, alienRace5RelationWithPlayer = alienCiv5RelationWithPlayer,

            /* Alien 5 */

            nameAlienRace6 = AlienCiv6Name, pictureAlienRace6 = AlienCiv6Picture,
            soldiersAlienRace6 = AlienCiv6Soldiers, spacePlanesAlienRace6 = AlienCiv6SpacePlanes,
            spaceJetsAlienRace6 = AlienCiv6SpaceJets, tanksAlienRace6 = AlienCiv6Tanks,
            nuclearSatelitesAlienRace6 = AlienCiv6NuclearSatelites, militaryBaseAlienRace6 = AlienCiv6MilitaryBase,
            isAlienRace6Damaged = isAlienCiv6Damaged, alienRace6RelationWithPlayer = alienCiv6RelationWithPlayer,

            /* Alien 6 */

            nameAlienRace7 = AlienCiv7Name, pictureAlienRace7 = AlienCiv7Picture,
            soldiersAlienRace7 = AlienCiv7Soldiers, spacePlanesAlienRace7 = AlienCiv7SpacePlanes,
            spaceJetsAlienRace7 = AlienCiv7SpaceJets, tanksAlienRace7 = AlienCiv7Tanks,
            nuclearSatelitesAlienRace7 = AlienCiv7NuclearSatelites, militaryBaseAlienRace7 = AlienCiv7MilitaryBase,
            isAlienRace7Damaged = isAlienCiv7Damaged, alienRace7RelationWithPlayer = alienCiv7RelationWithPlayer,

            /* Alien 7 */

            nameAlienRace8 = AlienCiv8Name, pictureAlienRace8 = AlienCiv8Picture,
            soldiersAlienRace8 = AlienCiv8Soldiers, spacePlanesAlienRace8 = AlienCiv8SpacePlanes,
            spaceJetsAlienRace8 = AlienCiv8SpaceJets, tanksAlienRace8 = AlienCiv8Tanks,
            nuclearSatelitesAlienRace8 = AlienCiv8NuclearSatelites, militaryBaseAlienRace8 = AlienCiv8MilitaryBase,
            isAlienRace8Damaged = isAlienCiv8Damaged, alienRace8RelationWithPlayer = alienCiv8RelationWithPlayer,

            /* Alien 8 */


            nameAlienRace9 = AlienCiv9Name, pictureAlienRace9 = AlienCiv9Picture,
            soldiersAlienRace9 = AlienCiv9Soldiers, spacePlanesAlienRace9 = AlienCiv9SpacePlanes,
            spaceJetsAlienRace9 = AlienCiv9SpaceJets, tanksAlienRace9 = AlienCiv9Tanks,
            nuclearSatelitesAlienRace9 = AlienCiv9NuclearSatelites, militaryBaseAlienRace9 = AlienCiv9MilitaryBase,
            isAlienRace9Damaged = isAlienCiv9Damaged, alienRace9RelationWithPlayer = alienCiv9RelationWithPlayer,

            /* Alien 9 */

            nameAlienRace10 = AlienCiv10Name, pictureAlienRace10 = AlienCiv10Picture,
            soldiersAlienRace10 = AlienCiv10Soldiers, spacePlanesAlienRace10 = AlienCiv10SpacePlanes,
            spaceJetsAlienRace10 = AlienCiv10SpaceJets, tanksAlienRace10 = AlienCiv10Tanks,
            nuclearSatelitesAlienRace10 = AlienCiv10NuclearSatelites, militaryBaseAlienRace10 = AlienCiv10MilitaryBase,
            isAlienRace10Damaged = isAlienCiv10Damaged, alienRace10RelationWithPlayer = alienCiv10RelationWithPlayer,

            /* Alien 10 */

            nameAlienRace11 = AlienCiv11Name, pictureAlienRace11 = AlienCiv11Picture,
            soldiersAlienRace11 = AlienCiv11Soldiers, spacePlanesAlienRace11 = AlienCiv11SpacePlanes,
            spaceJetsAlienRace11 = AlienCiv11SpaceJets, tanksAlienRace11 = AlienCiv11Tanks,
            nuclearSatelitesAlienRace11 = AlienCiv11NuclearSatelites, militaryBaseAlienRace11 = AlienCiv11MilitaryBase,
            isAlienRace11Damaged = isAlienCiv11Damaged, alienRace11RelationWithPlayer = alienCiv11RelationWithPlayer,

            /* Alien 11 */



            nameAlienRace12 = AlienCiv12Name, pictureAlienRace12 = AlienCiv12Picture,
            soldiersAlienRace12 = AlienCiv12Soldiers, spacePlanesAlienRace12 = AlienCiv12SpacePlanes,
            spaceJetsAlienRace12 = AlienCiv12SpaceJets, tanksAlienRace12 = AlienCiv12Tanks,
            nuclearSatelitesAlienRace12 = AlienCiv12NuclearSatelites, militaryBaseAlienRace12 = AlienCiv12MilitaryBase,
            isAlienRace12Damaged = isAlienCiv12Damaged, alienRace12RelationWithPlayer = alienCiv12RelationWithPlayer,

            /* Alien 12 */

            nameAlienRace13 = AlienCiv13Name, pictureAlienRace13 = AlienCiv13Picture,
            soldiersAlienRace13 = AlienCiv13Soldiers, spacePlanesAlienRace13 = AlienCiv13SpacePlanes,
            spaceJetsAlienRace13 = AlienCiv13SpaceJets, tanksAlienRace13 = AlienCiv13Tanks,
            nuclearSatelitesAlienRace13 = AlienCiv13NuclearSatelites, militaryBaseAlienRace13 = AlienCiv13MilitaryBase,
            isAlienRace13Damaged = isAlienCiv13Damaged, alienRace13RelationWithPlayer = alienCiv13RelationWithPlayer,

            /* Alien 13 */

            nameAlienRace14 = AlienCiv14Name, pictureAlienRace14 = AlienCiv14Picture,
            soldiersAlienRace14 = AlienCiv14Soldiers, spacePlanesAlienRace14 = AlienCiv14SpacePlanes,
            spaceJetsAlienRace14 = AlienCiv14SpaceJets, tanksAlienRace14 = AlienCiv14Tanks,
            nuclearSatelitesAlienRace14 = AlienCiv14NuclearSatelites, militaryBaseAlienRace14 = AlienCiv14MilitaryBase,
            isAlienRace14Damaged = isAlienCiv14Damaged, alienRace14RelationWithPlayer = alienCiv14RelationWithPlayer,

            /* Alien 14 */


            nameAlienRace15 = AlienCiv15Name, pictureAlienRace15= AlienCiv15Picture,
            soldiersAlienRace15 = AlienCiv15Soldiers, spacePlanesAlienRace15 = AlienCiv15SpacePlanes,
            spaceJetsAlienRace15 = AlienCiv15SpaceJets, tanksAlienRace15 = AlienCiv15Tanks,
            nuclearSatelitesAlienRace15 = AlienCiv15NuclearSatelites, militaryBaseAlienRace15 = AlienCiv15MilitaryBase,
            isAlienRace15Damaged = isAlienCiv15Damaged, alienRace15RelationWithPlayer = alienCiv15RelationWithPlayer,

            /* Alien 15 */




            nameAlienRace16 = AlienCiv16Name, pictureAlienRace16 = AlienCiv16Picture,
            soldiersAlienRace16 = AlienCiv16Soldiers, spacePlanesAlienRace16 = AlienCiv16SpacePlanes,
            spaceJetsAlienRace16 = AlienCiv16SpaceJets, tanksAlienRace16 = AlienCiv16Tanks,
            nuclearSatelitesAlienRace16 = AlienCiv16NuclearSatelites, militaryBaseAlienRace16 = AlienCiv16MilitaryBase,
            isAlienRace16Damaged = isAlienCiv16Damaged, alienRace16RelationWithPlayer = alienCiv16RelationWithPlayer)

        /* Alien 16 */


        auth = Firebase.auth
        val user = auth.currentUser


        if (user != null) {

            database.collection("users").document(user.uid).collection("Saved aliens data")
                .document("Aliens data").set(dataOfAlienCivilisations)


                .addOnCompleteListener {


                }

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


        auth = Firebase.auth
        val user = auth.currentUser

        if (user != null) {


            database.collection("users").document(user.uid).collection("Saved data")
                .document("hmkogjk").set(data)


                .addOnCompleteListener {

                    Toast.makeText(this, "Units recruited succesfully", Toast.LENGTH_SHORT).show()


                }

        }






    }





    fun aliensRecruit() {


        var soldiersIncrease = (400..1000).shuffled().last()
        var spacePlaneIncrease = (40..80).shuffled().last()
        var tanksIncrease = (5..10).shuffled().last()
        var spaceJetsIncrease = (10..15).shuffled().last()

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







        // Alien 3


        if (AlienCiv3MilitaryBase!! == 1.0) {

            AlienCiv3Soldiers = AlienCiv3Soldiers!! + soldiersIncrease
            AlienCiv3SpacePlanes = AlienCiv3SpacePlanes!! + spacePlaneIncrease

        } else if (AlienCiv3MilitaryBase!! == 2.0) {

            AlienCiv3Soldiers = AlienCiv3Soldiers!! + soldiersIncrease
            AlienCiv3SpacePlanes = AlienCiv3SpacePlanes!! + spacePlaneIncrease
            AlienCiv3Tanks = AlienCiv3Tanks!! + tanksIncrease

        } else if (AlienCiv3MilitaryBase!! >= 3.0) {

            AlienCiv3Soldiers = AlienCiv3Soldiers!! + soldiersIncrease
            AlienCiv3SpacePlanes = AlienCiv3SpacePlanes!! + spacePlaneIncrease
            AlienCiv3Tanks = AlienCiv3Tanks!! + tanksIncrease
            AlienCiv3SpaceJets = AlienCiv3SpaceJets!! + spaceJetsIncrease


        }

        if (repaiPlanet == 2 && isAlienCiv3Damaged!! > 0) {
            isAlienCiv3Damaged = 2.0
        }






        // Alien 4


        if (AlienCiv4MilitaryBase!! == 1.0) {

            AlienCiv4Soldiers = AlienCiv4Soldiers!! + soldiersIncrease
            AlienCiv4SpacePlanes = AlienCiv4SpacePlanes!! + spacePlaneIncrease

        } else if (AlienCiv4MilitaryBase!! == 2.0) {

            AlienCiv4Soldiers = AlienCiv4Soldiers!! + soldiersIncrease
            AlienCiv4SpacePlanes = AlienCiv4SpacePlanes!! + spacePlaneIncrease
            AlienCiv4Tanks = AlienCiv4Tanks!! + tanksIncrease

        } else if (AlienCiv4MilitaryBase!! >= 3.0) {

            AlienCiv4Soldiers = AlienCiv4Soldiers!! + soldiersIncrease
            AlienCiv4SpacePlanes = AlienCiv4SpacePlanes!! + spacePlaneIncrease
            AlienCiv4Tanks = AlienCiv4Tanks!! + tanksIncrease
            AlienCiv4SpaceJets = AlienCiv4SpaceJets!! + spaceJetsIncrease


        }

        if (repaiPlanet == 2 && isAlienCiv4Damaged!! > 0) {
            isAlienCiv4Damaged = 2.0
        }






// Alien 5


        if (AlienCiv5MilitaryBase!! == 1.0) {

            AlienCiv5Soldiers = AlienCiv5Soldiers!! + soldiersIncrease
            AlienCiv5SpacePlanes = AlienCiv5SpacePlanes!! + spacePlaneIncrease

        } else if (AlienCiv5MilitaryBase!! == 2.0) {

            AlienCiv5Soldiers = AlienCiv5Soldiers!! + soldiersIncrease
            AlienCiv5SpacePlanes = AlienCiv5SpacePlanes!! + spacePlaneIncrease
            AlienCiv5Tanks = AlienCiv5Tanks!! + tanksIncrease

        } else if (AlienCiv5MilitaryBase!! >= 3.0) {

            AlienCiv5Soldiers = AlienCiv5Soldiers!! + soldiersIncrease
            AlienCiv5SpacePlanes = AlienCiv5SpacePlanes!! + spacePlaneIncrease
            AlienCiv5Tanks = AlienCiv5Tanks!! + tanksIncrease
            AlienCiv5SpaceJets = AlienCiv5SpaceJets!! + spaceJetsIncrease


        }

        if (repaiPlanet == 2 && isAlienCiv5Damaged!! > 0) {
            isAlienCiv5Damaged = 2.0
        }





        // Alien 6


        if (AlienCiv6MilitaryBase!! == 1.0) {

            AlienCiv6Soldiers = AlienCiv6Soldiers!! + soldiersIncrease
            AlienCiv6SpacePlanes = AlienCiv6SpacePlanes!! + spacePlaneIncrease

        } else if (AlienCiv6MilitaryBase!! == 2.0) {

            AlienCiv6Soldiers = AlienCiv6Soldiers!! + soldiersIncrease
            AlienCiv6SpacePlanes = AlienCiv6SpacePlanes!! + spacePlaneIncrease
            AlienCiv6Tanks = AlienCiv6Tanks!! + tanksIncrease

        } else if (AlienCiv6MilitaryBase!! >= 3.0) {

            AlienCiv6Soldiers = AlienCiv6Soldiers!! + soldiersIncrease
            AlienCiv6SpacePlanes = AlienCiv6SpacePlanes!! + spacePlaneIncrease
            AlienCiv6Tanks = AlienCiv6Tanks!! + tanksIncrease
            AlienCiv6SpaceJets = AlienCiv6SpaceJets!! + spaceJetsIncrease


        }

        if (repaiPlanet == 2 && isAlienCiv6Damaged!! > 0) {
            isAlienCiv6Damaged = 2.0
        }




        // Alien 7


        if (AlienCiv7MilitaryBase!! == 1.0) {

            AlienCiv7Soldiers = AlienCiv7Soldiers!! + soldiersIncrease
            AlienCiv7SpacePlanes = AlienCiv7SpacePlanes!! + spacePlaneIncrease

        } else if (AlienCiv7MilitaryBase!! == 2.0) {

            AlienCiv7Soldiers = AlienCiv7Soldiers!! + soldiersIncrease
            AlienCiv7SpacePlanes = AlienCiv7SpacePlanes!! + spacePlaneIncrease
            AlienCiv7Tanks = AlienCiv7Tanks!! + tanksIncrease

        } else if (AlienCiv7MilitaryBase!! >= 3.0) {

            AlienCiv7Soldiers = AlienCiv7Soldiers!! + soldiersIncrease
            AlienCiv7SpacePlanes = AlienCiv7SpacePlanes!! + spacePlaneIncrease
            AlienCiv7Tanks = AlienCiv7Tanks!! + tanksIncrease
            AlienCiv7SpaceJets = AlienCiv7SpaceJets!! + spaceJetsIncrease


        }

        if (repaiPlanet == 2 && isAlienCiv7Damaged!! > 0) {
            isAlienCiv7Damaged = 2.0
        }




        // Alien 8


        if (AlienCiv8MilitaryBase!! == 1.0) {

            AlienCiv8Soldiers = AlienCiv8Soldiers!! + soldiersIncrease
            AlienCiv8SpacePlanes = AlienCiv8SpacePlanes!! + spacePlaneIncrease

        } else if (AlienCiv8MilitaryBase!! == 2.0) {

            AlienCiv8Soldiers = AlienCiv8Soldiers!! + soldiersIncrease
            AlienCiv8SpacePlanes = AlienCiv8SpacePlanes!! + spacePlaneIncrease
            AlienCiv8Tanks = AlienCiv8Tanks!! + tanksIncrease

        } else if (AlienCiv8MilitaryBase!! >= 3.0) {

            AlienCiv8Soldiers = AlienCiv8Soldiers!! + soldiersIncrease
            AlienCiv8SpacePlanes = AlienCiv8SpacePlanes!! + spacePlaneIncrease
            AlienCiv8Tanks = AlienCiv8Tanks!! + tanksIncrease
            AlienCiv8SpaceJets = AlienCiv8SpaceJets!! + spaceJetsIncrease


        }

        if (repaiPlanet == 2 && isAlienCiv8Damaged!! > 0) {
            isAlienCiv8Damaged = 2.0
        }



        // Alien 9


        if (AlienCiv9MilitaryBase!! == 1.0) {

            AlienCiv9Soldiers = AlienCiv9Soldiers!! + soldiersIncrease
            AlienCiv9SpacePlanes = AlienCiv9SpacePlanes!! + spacePlaneIncrease

        } else if (AlienCiv9MilitaryBase!! == 2.0) {

            AlienCiv9Soldiers = AlienCiv9Soldiers!! + soldiersIncrease
            AlienCiv9SpacePlanes = AlienCiv9SpacePlanes!! + spacePlaneIncrease
            AlienCiv9Tanks = AlienCiv9Tanks!! + tanksIncrease

        } else if (AlienCiv9MilitaryBase!! >= 3.0) {

            AlienCiv9Soldiers = AlienCiv9Soldiers!! + soldiersIncrease
            AlienCiv9SpacePlanes = AlienCiv9SpacePlanes!! + spacePlaneIncrease
            AlienCiv9Tanks = AlienCiv9Tanks!! + tanksIncrease
            AlienCiv9SpaceJets = AlienCiv9SpaceJets!! + spaceJetsIncrease


        }

        if (repaiPlanet == 2 && isAlienCiv9Damaged!! > 0) {
            isAlienCiv9Damaged = 2.0
        }




        // Alien 10


        if (AlienCiv10MilitaryBase!! == 1.0) {

            AlienCiv10Soldiers = AlienCiv10Soldiers!! + soldiersIncrease
            AlienCiv10SpacePlanes = AlienCiv10SpacePlanes!! + spacePlaneIncrease

        } else if (AlienCiv10MilitaryBase!! == 2.0) {

            AlienCiv10Soldiers = AlienCiv10Soldiers!! + soldiersIncrease
            AlienCiv10SpacePlanes = AlienCiv10SpacePlanes!! + spacePlaneIncrease
            AlienCiv10Tanks = AlienCiv10Tanks!! + tanksIncrease

        } else if (AlienCiv10MilitaryBase!! >= 3.0) {

            AlienCiv10Soldiers = AlienCiv10Soldiers!! + soldiersIncrease
            AlienCiv10SpacePlanes = AlienCiv10SpacePlanes!! + spacePlaneIncrease
            AlienCiv10Tanks = AlienCiv10Tanks!! + tanksIncrease
            AlienCiv10SpaceJets = AlienCiv10SpaceJets!! + spaceJetsIncrease


        }

        if (repaiPlanet == 2 && isAlienCiv10Damaged!! > 0) {
            isAlienCiv10Damaged = 2.0
        }



        // Alien 11


        if (AlienCiv11MilitaryBase!! == 1.0) {

            AlienCiv11Soldiers = AlienCiv11Soldiers!! + soldiersIncrease
            AlienCiv11SpacePlanes = AlienCiv11SpacePlanes!! + spacePlaneIncrease

        } else if (AlienCiv11MilitaryBase!! == 2.0) {

            AlienCiv11Soldiers = AlienCiv11Soldiers!! + soldiersIncrease
            AlienCiv11SpacePlanes = AlienCiv11SpacePlanes!! + spacePlaneIncrease
            AlienCiv11Tanks = AlienCiv11Tanks!! + tanksIncrease

        } else if (AlienCiv11MilitaryBase!! >= 3.0) {

            AlienCiv11Soldiers = AlienCiv11Soldiers!! + soldiersIncrease
            AlienCiv11SpacePlanes = AlienCiv11SpacePlanes!! + spacePlaneIncrease
            AlienCiv11Tanks = AlienCiv11Tanks!! + tanksIncrease
            AlienCiv11SpaceJets = AlienCiv11SpaceJets!! + spaceJetsIncrease


        }

        if (repaiPlanet == 2 && isAlienCiv11Damaged!! > 0) {
            isAlienCiv11Damaged = 2.0
        }




        // Alien 12


        if (AlienCiv12MilitaryBase!! == 1.0) {

            AlienCiv12Soldiers = AlienCiv12Soldiers!! + soldiersIncrease
            AlienCiv12SpacePlanes = AlienCiv12SpacePlanes!! + spacePlaneIncrease

        } else if (AlienCiv12MilitaryBase!! == 2.0) {

            AlienCiv12Soldiers = AlienCiv12Soldiers!! + soldiersIncrease
            AlienCiv12SpacePlanes = AlienCiv12SpacePlanes!! + spacePlaneIncrease
            AlienCiv12Tanks = AlienCiv12Tanks!! + tanksIncrease

        } else if (AlienCiv12MilitaryBase!! >= 3.0) {

            AlienCiv12Soldiers = AlienCiv12Soldiers!! + soldiersIncrease
            AlienCiv12SpacePlanes = AlienCiv12SpacePlanes!! + spacePlaneIncrease
            AlienCiv12Tanks = AlienCiv12Tanks!! + tanksIncrease
            AlienCiv12SpaceJets = AlienCiv12SpaceJets!! + spaceJetsIncrease


        }

        if (repaiPlanet == 2 && isAlienCiv12Damaged!! > 0) {
            isAlienCiv12Damaged = 2.0
        }




        // Alien 13



        if (AlienCiv13MilitaryBase!! == 1.0) {

            AlienCiv13Soldiers = AlienCiv13Soldiers!! + soldiersIncrease
            AlienCiv13SpacePlanes = AlienCiv13SpacePlanes!! + spacePlaneIncrease

        } else if (AlienCiv13MilitaryBase!! == 2.0) {

            AlienCiv13Soldiers = AlienCiv13Soldiers!! + soldiersIncrease
            AlienCiv13SpacePlanes = AlienCiv13SpacePlanes!! + spacePlaneIncrease
            AlienCiv13Tanks = AlienCiv13Tanks!! + tanksIncrease

        } else if (AlienCiv13MilitaryBase!! >= 3.0) {

            AlienCiv13Soldiers = AlienCiv13Soldiers!! + soldiersIncrease
            AlienCiv13SpacePlanes = AlienCiv13SpacePlanes!! + spacePlaneIncrease
            AlienCiv13Tanks = AlienCiv13Tanks!! + tanksIncrease
            AlienCiv13SpaceJets = AlienCiv13SpaceJets!! + spaceJetsIncrease


        }

        if (repaiPlanet == 2 && isAlienCiv13Damaged!! > 0) {
            isAlienCiv13Damaged = 2.0
        }



        // Alien 14


        if (AlienCiv14MilitaryBase!! == 1.0) {

            AlienCiv14Soldiers = AlienCiv14Soldiers!! + soldiersIncrease
            AlienCiv14SpacePlanes = AlienCiv14SpacePlanes!! + spacePlaneIncrease

        } else if (AlienCiv14MilitaryBase!! == 2.0) {

            AlienCiv14Soldiers = AlienCiv14Soldiers!! + soldiersIncrease
            AlienCiv14SpacePlanes = AlienCiv14SpacePlanes!! + spacePlaneIncrease
            AlienCiv14Tanks = AlienCiv14Tanks!! + tanksIncrease

        } else if (AlienCiv14MilitaryBase!! >= 3.0) {

            AlienCiv14Soldiers = AlienCiv14Soldiers!! + soldiersIncrease
            AlienCiv14SpacePlanes = AlienCiv14SpacePlanes!! + spacePlaneIncrease
            AlienCiv14Tanks = AlienCiv14Tanks!! + tanksIncrease
            AlienCiv14SpaceJets = AlienCiv14SpaceJets!! + spaceJetsIncrease


        }

        if (repaiPlanet == 2 && isAlienCiv14Damaged!! > 0) {
            isAlienCiv14Damaged = 2.0
        }



        // Alien 15


        if (AlienCiv15MilitaryBase!! == 1.0) {

            AlienCiv15Soldiers = AlienCiv15Soldiers!! + soldiersIncrease
            AlienCiv15SpacePlanes = AlienCiv15SpacePlanes!! + spacePlaneIncrease

        } else if (AlienCiv15MilitaryBase!! == 2.0) {

            AlienCiv15Soldiers = AlienCiv15Soldiers!! + soldiersIncrease
            AlienCiv15SpacePlanes = AlienCiv15SpacePlanes!! + spacePlaneIncrease
            AlienCiv15Tanks = AlienCiv15Tanks!! + tanksIncrease

        } else if (AlienCiv15MilitaryBase!! >= 3.0) {

            AlienCiv15Soldiers = AlienCiv15Soldiers!! + soldiersIncrease
            AlienCiv15SpacePlanes = AlienCiv15SpacePlanes!! + spacePlaneIncrease
            AlienCiv15Tanks = AlienCiv15Tanks!! + tanksIncrease
            AlienCiv15SpaceJets = AlienCiv15SpaceJets!! + spaceJetsIncrease


        }

        if (repaiPlanet == 2 && isAlienCiv15Damaged!! > 0) {
            isAlienCiv15Damaged = 2.0
        }





        // Alien 16


        if (AlienCiv16MilitaryBase!! == 1.0) {

            AlienCiv16Soldiers = AlienCiv16Soldiers!! + soldiersIncrease
            AlienCiv16SpacePlanes = AlienCiv16SpacePlanes!! + spacePlaneIncrease

        } else if (AlienCiv16MilitaryBase!! == 2.0) {

            AlienCiv16Soldiers = AlienCiv16Soldiers!! + soldiersIncrease
            AlienCiv16SpacePlanes = AlienCiv16SpacePlanes!! + spacePlaneIncrease
            AlienCiv16Tanks = AlienCiv16Tanks!! + tanksIncrease

        } else if (AlienCiv16MilitaryBase!! >= 3.0) {

            AlienCiv16Soldiers = AlienCiv16Soldiers!! + soldiersIncrease
            AlienCiv16SpacePlanes = AlienCiv16SpacePlanes!! + spacePlaneIncrease
            AlienCiv16Tanks = AlienCiv16Tanks!! + tanksIncrease
            AlienCiv16SpaceJets = AlienCiv16SpaceJets!! + spaceJetsIncrease


        }

        if (repaiPlanet == 2 && isAlienCiv16Damaged!! > 0) {
            isAlienCiv16Damaged = 2.0
        }







    }














}