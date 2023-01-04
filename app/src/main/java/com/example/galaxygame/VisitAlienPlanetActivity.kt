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
    lateinit var coloniseImg : ImageView
    lateinit var coloniseTxt : TextView
    lateinit var sendASpyText : TextView
    lateinit var attackTxt : TextView
    lateinit var nuclearSateliteText : TextView
    lateinit var donateText : TextView
    lateinit var collectColonyMoney : ImageView





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




    var colonyId1 : Int = 1000
    var colonyResourses1 : Int = 0



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











    var alienMilitaryBase : Double? = null
    var civilisationSpies = (1..11).shuffled().last()
    lateinit var savedDataOfUser : playerData







    lateinit var savedDataOfAliens : aliens
    lateinit var database : FirebaseFirestore
    lateinit var visitAlienWorldLayout : ConstraintLayout


    lateinit var spyBtn : ImageView
    lateinit var strikeWithNuclearSatelitesBtn : ImageView
    lateinit var strikeBtn : Button
    lateinit var nuclearSateliteImg : ImageView
    lateinit var donateImg : ImageView




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
        donateImg = findViewById(R.id.donateImg)
        coloniseImg = findViewById(R.id.coloniseImg)
        coloniseTxt = findViewById(R.id.coloniseTxt)
        sendASpyText = findViewById(R.id.sendASpyText)
        attackTxt = findViewById(R.id.attackTxt)
        nuclearSateliteText = findViewById(R.id.nuclearSateliteText)
        donateText = findViewById(R.id.donateText)
        collectColonyMoney = findViewById(R.id.collectColonyMoney)






        database = Firebase.firestore


        strikeBtn.isVisible = false
        strikeBtn.isEnabled = false
        nuclearSateliteImg.isVisible = false


        explosionPic.isVisible = false

        coloniseImg.isVisible = false
        coloniseImg.isEnabled = false
        coloniseTxt.isVisible = false

        collectColonyMoney.isVisible = false
        collectColonyMoney.isEnabled = false





        val sharedNewMessageNotify = getSharedPreferences("NewMessageNotify", AppCompatActivity.MODE_PRIVATE)
        var NewMessageNotify = sharedNewMessageNotify.getBoolean("NewMessageNotify", false)


        val sharedSelectedPlanet = getSharedPreferences("SelectedPlanet", AppCompatActivity.MODE_PRIVATE)
        var SelectedPlanet = sharedSelectedPlanet.getInt("SelectedPlanet", 0)





        if (SelectedPlanet == 0 && colonyId1 == 1000) {

            coloniseImg.isVisible = true
            coloniseImg.isEnabled = true
            coloniseTxt.isVisible = true

            pictureofAlien.isVisible = false
            spyArmyTextView.isVisible = false
            spyBtn.isVisible = false
            spyBtn.isEnabled = false
            attackImg.isVisible = false
            attackImg.isEnabled = false
            strikeWithNuclearSatelitesBtn.isVisible = false
            strikeWithNuclearSatelitesBtn.isEnabled = false
            donateImg.isVisible = false
            donateImg.isEnabled = false
            sendASpyText.isVisible = false
            attackTxt.isVisible = false
            nuclearSateliteText.isVisible = false
            donateText.isVisible = false




        } else if (SelectedPlanet == 111 && colonyId1 == 1000) {

            coloniseImg.isVisible = true
            coloniseImg.isEnabled = true
            coloniseTxt.isVisible = true

            pictureofAlien.isVisible = false
            spyArmyTextView.isVisible = false
            spyBtn.isVisible = false
            spyBtn.isEnabled = false
            attackImg.isVisible = false
            attackImg.isEnabled = false
            strikeWithNuclearSatelitesBtn.isVisible = false
            strikeWithNuclearSatelitesBtn.isEnabled = false
            donateImg.isVisible = false
            donateImg.isEnabled = false
            sendASpyText.isVisible = false
            attackTxt.isVisible = false
            nuclearSateliteText.isVisible = false
            donateText.isVisible = false

        } else if (SelectedPlanet == 444 && colonyId1 == 1000) {

            coloniseImg.isVisible = true
            coloniseImg.isEnabled = true
            coloniseTxt.isVisible = true

            pictureofAlien.isVisible = false
            spyArmyTextView.isVisible = false
            spyBtn.isVisible = false
            spyBtn.isEnabled = false
            attackImg.isVisible = false
            attackImg.isEnabled = false
            strikeWithNuclearSatelitesBtn.isVisible = false
            strikeWithNuclearSatelitesBtn.isEnabled = false
            donateImg.isVisible = false
            donateImg.isEnabled = false
            sendASpyText.isVisible = false
            attackTxt.isVisible = false
            nuclearSateliteText.isVisible = false
            donateText.isVisible = false

        } else if (SelectedPlanet == 777 && colonyId1 == 1000) {

            coloniseImg.isVisible = true
            coloniseImg.isEnabled = true
            coloniseTxt.isVisible = true

            pictureofAlien.isVisible = false
            spyArmyTextView.isVisible = false
            spyBtn.isVisible = false
            spyBtn.isEnabled = false
            attackImg.isVisible = false
            attackImg.isEnabled = false
            strikeWithNuclearSatelitesBtn.isVisible = false
            strikeWithNuclearSatelitesBtn.isEnabled = false
            donateImg.isVisible = false
            donateImg.isEnabled = false
            sendASpyText.isVisible = false
            attackTxt.isVisible = false
            nuclearSateliteText.isVisible = false
            donateText.isVisible = false

        }













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


                        colonyId1 = savedDataOfUser.colonyId1
                        colonyResourses1 = savedDataOfUser.colonyResourses1




                        if (SelectedPlanet == 0 && colonyId1 == 0) {

                            visitAlienWorldLayout.background = resources.getDrawable(R.drawable.playercolonized)

                            coloniseImg.isVisible = false
                            coloniseImg.isEnabled = false
                            coloniseTxt.isVisible = false

                            collectColonyMoney.isVisible = true
                            collectColonyMoney.isEnabled = true

                            pictureofAlien.isVisible = false
                            spyArmyTextView.isVisible = false
                            spyBtn.isVisible = false
                            spyBtn.isEnabled = false
                            attackImg.isVisible = false
                            attackImg.isEnabled = false
                            strikeWithNuclearSatelitesBtn.isVisible = false
                            strikeWithNuclearSatelitesBtn.isEnabled = false
                            donateImg.isVisible = false
                            donateImg.isEnabled = false
                            sendASpyText.isVisible = false
                            attackTxt.isVisible = false
                            nuclearSateliteText.isVisible = false
                            donateText.isVisible = false


                        } else if (SelectedPlanet == 111 && colonyId1 == 111) {

                            visitAlienWorldLayout.background = resources.getDrawable(R.drawable.playercolonized)

                            coloniseImg.isVisible = false
                            coloniseImg.isEnabled = false
                            coloniseTxt.isVisible = false

                            collectColonyMoney.isVisible = true
                            collectColonyMoney.isEnabled = true

                            pictureofAlien.isVisible = false
                            spyArmyTextView.isVisible = false
                            spyBtn.isVisible = false
                            spyBtn.isEnabled = false
                            attackImg.isVisible = false
                            attackImg.isEnabled = false
                            strikeWithNuclearSatelitesBtn.isVisible = false
                            strikeWithNuclearSatelitesBtn.isEnabled = false
                            donateImg.isVisible = false
                            donateImg.isEnabled = false
                            sendASpyText.isVisible = false
                            attackTxt.isVisible = false
                            nuclearSateliteText.isVisible = false
                            donateText.isVisible = false

                        } else if (SelectedPlanet == 444 && colonyId1 == 444) {

                            visitAlienWorldLayout.background = resources.getDrawable(R.drawable.playercolonized)

                            coloniseImg.isVisible = false
                            coloniseImg.isEnabled = false
                            coloniseTxt.isVisible = false

                            collectColonyMoney.isVisible = true
                            collectColonyMoney.isEnabled = true

                            pictureofAlien.isVisible = false
                            spyArmyTextView.isVisible = false
                            spyBtn.isVisible = false
                            spyBtn.isEnabled = false
                            attackImg.isVisible = false
                            attackImg.isEnabled = false
                            strikeWithNuclearSatelitesBtn.isVisible = false
                            strikeWithNuclearSatelitesBtn.isEnabled = false
                            donateImg.isVisible = false
                            donateImg.isEnabled = false
                            sendASpyText.isVisible = false
                            attackTxt.isVisible = false
                            nuclearSateliteText.isVisible = false
                            donateText.isVisible = false

                        } else if (SelectedPlanet == 777 && colonyId1 == 777) {

                            visitAlienWorldLayout.background = resources.getDrawable(R.drawable.playercolonized)

                            coloniseImg.isVisible = false
                            coloniseImg.isEnabled = false
                            coloniseTxt.isVisible = false

                            collectColonyMoney.isVisible = true
                            collectColonyMoney.isEnabled = true

                            pictureofAlien.isVisible = false
                            spyArmyTextView.isVisible = false
                            spyBtn.isVisible = false
                            spyBtn.isEnabled = false
                            attackImg.isVisible = false
                            attackImg.isEnabled = false
                            strikeWithNuclearSatelitesBtn.isVisible = false
                            strikeWithNuclearSatelitesBtn.isEnabled = false
                            donateImg.isVisible = false
                            donateImg.isEnabled = false
                            sendASpyText.isVisible = false
                            attackTxt.isVisible = false
                            nuclearSateliteText.isVisible = false
                            donateText.isVisible = false

                        }



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
                        alienCiv3RelationWithPlayer = savedDataOfAliens.alienRace3RelationWithPlayer




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
                        alienCiv4RelationWithPlayer = savedDataOfAliens.alienRace4RelationWithPlayer






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
                        alienCiv5RelationWithPlayer = savedDataOfAliens.alienRace5RelationWithPlayer








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
                        alienCiv6RelationWithPlayer = savedDataOfAliens.alienRace6RelationWithPlayer









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
                        alienCiv7RelationWithPlayer = savedDataOfAliens.alienRace7RelationWithPlayer













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
                        alienCiv8RelationWithPlayer = savedDataOfAliens.alienRace8RelationWithPlayer










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
                        alienCiv9RelationWithPlayer = savedDataOfAliens.alienRace9RelationWithPlayer










                        // Fetches the data of 10 civilisation in galaxy

                        AlienCiv10Name = savedDataOfAliens.nameAlienRace10
                        AlienCiv10Picture = savedDataOfAliens.pictureAlienRace10
                        AlienCiv10MilitaryBase = savedDataOfAliens.militaryBaseAlienRace10
                        AlienCiv10Soldiers = savedDataOfAliens.soldiersAlienRace10
                        AlienCiv10SpacePlanes = savedDataOfAliens.spacePlanesAlienRace10
                        AlienCiv10SpaceJets = savedDataOfAliens.spaceJetsAlienRace10
                        AlienCiv10Tanks = savedDataOfAliens.tanksAlienRace10
                        AlienCiv10NuclearSatelites = savedDataOfAliens.nuclearSatelitesAlienRace10
                        isAlienCiv10Damaged = savedDataOfAliens.isAlienRace10Damaged
                        alienCiv10RelationWithPlayer = savedDataOfAliens.alienRace10RelationWithPlayer









                        // Fetches the data of 11 civilisation in galaxy

                        AlienCiv11Name = savedDataOfAliens.nameAlienRace11
                        AlienCiv11Picture = savedDataOfAliens.pictureAlienRace11
                        AlienCiv11MilitaryBase = savedDataOfAliens.militaryBaseAlienRace11
                        AlienCiv11Soldiers = savedDataOfAliens.soldiersAlienRace11
                        AlienCiv11SpacePlanes = savedDataOfAliens.spacePlanesAlienRace11
                        AlienCiv11SpaceJets = savedDataOfAliens.spaceJetsAlienRace11
                        AlienCiv11Tanks = savedDataOfAliens.tanksAlienRace11
                        AlienCiv11NuclearSatelites = savedDataOfAliens.nuclearSatelitesAlienRace11
                        isAlienCiv11Damaged = savedDataOfAliens.isAlienRace11Damaged
                        alienCiv11RelationWithPlayer = savedDataOfAliens.alienRace11RelationWithPlayer








                        // Fetches the data of 12 civilisation in galaxy

                        AlienCiv12Name = savedDataOfAliens.nameAlienRace12
                        AlienCiv12Picture = savedDataOfAliens.pictureAlienRace12
                        AlienCiv12MilitaryBase = savedDataOfAliens.militaryBaseAlienRace12
                        AlienCiv12Soldiers = savedDataOfAliens.soldiersAlienRace12
                        AlienCiv12SpacePlanes = savedDataOfAliens.spacePlanesAlienRace12
                        AlienCiv12SpaceJets = savedDataOfAliens.spaceJetsAlienRace12
                        AlienCiv12Tanks = savedDataOfAliens.tanksAlienRace12
                        AlienCiv12NuclearSatelites = savedDataOfAliens.nuclearSatelitesAlienRace12
                        isAlienCiv12Damaged = savedDataOfAliens.isAlienRace12Damaged
                        alienCiv12RelationWithPlayer = savedDataOfAliens.alienRace12RelationWithPlayer









                        // Fetches the data of 13 civilisation in galaxy

                        AlienCiv13Name = savedDataOfAliens.nameAlienRace13
                        AlienCiv13Picture = savedDataOfAliens.pictureAlienRace13
                        AlienCiv13MilitaryBase = savedDataOfAliens.militaryBaseAlienRace13
                        AlienCiv13Soldiers = savedDataOfAliens.soldiersAlienRace13
                        AlienCiv13SpacePlanes = savedDataOfAliens.spacePlanesAlienRace13
                        AlienCiv13SpaceJets = savedDataOfAliens.spaceJetsAlienRace13
                        AlienCiv13Tanks = savedDataOfAliens.tanksAlienRace13
                        AlienCiv13NuclearSatelites = savedDataOfAliens.nuclearSatelitesAlienRace13
                        isAlienCiv13Damaged = savedDataOfAliens.isAlienRace13Damaged
                        alienCiv13RelationWithPlayer = savedDataOfAliens.alienRace13RelationWithPlayer











                        // Fetches the data of 14 civilisation in galaxy

                        AlienCiv14Name = savedDataOfAliens.nameAlienRace14
                        AlienCiv14Picture = savedDataOfAliens.pictureAlienRace14
                        AlienCiv14MilitaryBase = savedDataOfAliens.militaryBaseAlienRace14
                        AlienCiv14Soldiers = savedDataOfAliens.soldiersAlienRace14
                        AlienCiv14SpacePlanes = savedDataOfAliens.spacePlanesAlienRace14
                        AlienCiv14SpaceJets = savedDataOfAliens.spaceJetsAlienRace14
                        AlienCiv14Tanks = savedDataOfAliens.tanksAlienRace14
                        AlienCiv14NuclearSatelites = savedDataOfAliens.nuclearSatelitesAlienRace14
                        isAlienCiv14Damaged = savedDataOfAliens.isAlienRace14Damaged
                        alienCiv14RelationWithPlayer = savedDataOfAliens.alienRace14RelationWithPlayer











                        // Fetches the data of 15 civilisation in galaxy

                        AlienCiv15Name = savedDataOfAliens.nameAlienRace15
                        AlienCiv15Picture = savedDataOfAliens.pictureAlienRace15
                        AlienCiv15MilitaryBase = savedDataOfAliens.militaryBaseAlienRace15
                        AlienCiv15Soldiers = savedDataOfAliens.soldiersAlienRace15
                        AlienCiv15SpacePlanes = savedDataOfAliens.spacePlanesAlienRace15
                        AlienCiv15SpaceJets = savedDataOfAliens.spaceJetsAlienRace15
                        AlienCiv15Tanks = savedDataOfAliens.tanksAlienRace15
                        AlienCiv15NuclearSatelites = savedDataOfAliens.nuclearSatelitesAlienRace15
                        isAlienCiv15Damaged = savedDataOfAliens.isAlienRace15Damaged
                        alienCiv15RelationWithPlayer = savedDataOfAliens.alienRace15RelationWithPlayer








                        // Fetches the data of 16 civilisation in galaxy

                        AlienCiv16Name = savedDataOfAliens.nameAlienRace16
                        AlienCiv16Picture = savedDataOfAliens.pictureAlienRace16
                        AlienCiv16MilitaryBase = savedDataOfAliens.militaryBaseAlienRace16
                        AlienCiv16Soldiers = savedDataOfAliens.soldiersAlienRace16
                        AlienCiv16SpacePlanes = savedDataOfAliens.spacePlanesAlienRace16
                        AlienCiv16SpaceJets = savedDataOfAliens.spaceJetsAlienRace16
                        AlienCiv16Tanks = savedDataOfAliens.tanksAlienRace16
                        AlienCiv16NuclearSatelites = savedDataOfAliens.nuclearSatelitesAlienRace16
                        isAlienCiv16Damaged = savedDataOfAliens.isAlienRace16Damaged
                        alienCiv16RelationWithPlayer = savedDataOfAliens.alienRace16RelationWithPlayer










                        if (SelectedPlanet == 1) {

                            // Displays name and picture of alien based on number

                            nameOfAlienTxt.text = "$AlienCiv1Name"


                            if (AlienCiv1Picture == 1) {
                                pictureofAlien.setImageResource(R.drawable.alien1)
                            } else if (AlienCiv1Picture == 2) {
                                pictureofAlien.setImageResource(R.drawable.alien2)
                            } else if (AlienCiv1Picture == 3) {
                                pictureofAlien.setImageResource(R.drawable.alien3)
                            } else if (AlienCiv1Picture == 4) {
                                pictureofAlien.setImageResource(R.drawable.alien4)
                            } else if (AlienCiv1Picture == 5) {
                                pictureofAlien.setImageResource(R.drawable.alien5)
                            } else if (AlienCiv1Picture == 6) {
                                pictureofAlien.setImageResource(R.drawable.alien6)
                            } else if (AlienCiv1Picture == 7) {
                                pictureofAlien.setImageResource(R.drawable.alien7)
                            } else if (AlienCiv1Picture == 8) {
                                pictureofAlien.setImageResource(R.drawable.alien8)
                            } else if (AlienCiv1Picture == 9) {
                                pictureofAlien.setImageResource(R.drawable.alien9)
                            }  else if (AlienCiv1Picture == 10) {
                                pictureofAlien.setImageResource(R.drawable.alien10)
                            }




                            if (isAlienCiv1Damaged!! <= 0) {
                                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.destoiedplanet)
                            } else if (isAlienCiv1Damaged!! == 1.0) {
                                explosionPic.isVisible = true
                            }

                        }








                        if (SelectedPlanet == 2) {

                            // Displays name and picture of alien based on number

                            nameOfAlienTxt.text = "$AlienCiv2Name"


                            if (AlienCiv2Picture == 1) {
                                pictureofAlien.setImageResource(R.drawable.alien1)
                            } else if (AlienCiv2Picture == 2) {
                                pictureofAlien.setImageResource(R.drawable.alien2)
                            } else if (AlienCiv2Picture == 3) {
                                pictureofAlien.setImageResource(R.drawable.alien3)
                            } else if (AlienCiv2Picture == 4) {
                                pictureofAlien.setImageResource(R.drawable.alien4)
                            } else if (AlienCiv2Picture == 5) {
                                pictureofAlien.setImageResource(R.drawable.alien5)
                            } else if (AlienCiv2Picture == 6) {
                                pictureofAlien.setImageResource(R.drawable.alien6)
                            } else if (AlienCiv2Picture == 7) {
                                pictureofAlien.setImageResource(R.drawable.alien7)
                            } else if (AlienCiv2Picture == 8) {
                                pictureofAlien.setImageResource(R.drawable.alien8)
                            } else if (AlienCiv2Picture == 9) {
                                pictureofAlien.setImageResource(R.drawable.alien9)
                            }  else if (AlienCiv2Picture == 10) {
                                pictureofAlien.setImageResource(R.drawable.alien10)
                            }




                            if (isAlienCiv2Damaged!! <= 0) {
                                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.destoiedplanet)
                            } else if (isAlienCiv2Damaged!! == 1.0) {
                                explosionPic.isVisible = true
                            }

                        }




                        if (SelectedPlanet == 3) {

                            // Displays name and picture of alien based on number

                            nameOfAlienTxt.text = "$AlienCiv3Name"


                            if (AlienCiv3Picture == 1) {
                                pictureofAlien.setImageResource(R.drawable.alien1)
                            } else if (AlienCiv3Picture == 2) {
                                pictureofAlien.setImageResource(R.drawable.alien2)
                            } else if (AlienCiv3Picture == 3) {
                                pictureofAlien.setImageResource(R.drawable.alien3)
                            } else if (AlienCiv3Picture == 4) {
                                pictureofAlien.setImageResource(R.drawable.alien4)
                            } else if (AlienCiv3Picture == 5) {
                                pictureofAlien.setImageResource(R.drawable.alien5)
                            } else if (AlienCiv3Picture == 6) {
                                pictureofAlien.setImageResource(R.drawable.alien6)
                            } else if (AlienCiv3Picture == 7) {
                                pictureofAlien.setImageResource(R.drawable.alien7)
                            } else if (AlienCiv3Picture == 8) {
                                pictureofAlien.setImageResource(R.drawable.alien8)
                            } else if (AlienCiv3Picture == 9) {
                                pictureofAlien.setImageResource(R.drawable.alien9)
                            }  else if (AlienCiv3Picture == 10) {
                                pictureofAlien.setImageResource(R.drawable.alien10)
                            }




                            if (isAlienCiv3Damaged!! <= 0) {
                                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.destoiedplanet)
                            } else if (isAlienCiv3Damaged!! == 1.0) {
                                explosionPic.isVisible = true
                            }

                        }




                        if (SelectedPlanet == 4) {

                            // Displays name and picture of alien based on number

                            nameOfAlienTxt.text = "$AlienCiv4Name"


                            if (AlienCiv4Picture == 1) {
                                pictureofAlien.setImageResource(R.drawable.alien1)
                            } else if (AlienCiv4Picture == 2) {
                                pictureofAlien.setImageResource(R.drawable.alien2)
                            } else if (AlienCiv4Picture == 3) {
                                pictureofAlien.setImageResource(R.drawable.alien3)
                            } else if (AlienCiv4Picture == 4) {
                                pictureofAlien.setImageResource(R.drawable.alien4)
                            } else if (AlienCiv4Picture == 5) {
                                pictureofAlien.setImageResource(R.drawable.alien5)
                            } else if (AlienCiv4Picture == 6) {
                                pictureofAlien.setImageResource(R.drawable.alien6)
                            } else if (AlienCiv4Picture == 7) {
                                pictureofAlien.setImageResource(R.drawable.alien7)
                            } else if (AlienCiv4Picture == 8) {
                                pictureofAlien.setImageResource(R.drawable.alien8)
                            } else if (AlienCiv4Picture == 9) {
                                pictureofAlien.setImageResource(R.drawable.alien9)
                            }  else if (AlienCiv4Picture == 10) {
                                pictureofAlien.setImageResource(R.drawable.alien10)
                            }




                            if (isAlienCiv4Damaged!! <= 0) {
                                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.destoiedplanet)
                            } else if (isAlienCiv4Damaged!! == 1.0) {
                                explosionPic.isVisible = true
                            }

                        }





                        if (SelectedPlanet == 5) {

                            // Displays name and picture of alien based on number

                            nameOfAlienTxt.text = "$AlienCiv5Name"


                            if (AlienCiv5Picture == 1) {
                                pictureofAlien.setImageResource(R.drawable.alien1)
                            } else if (AlienCiv5Picture == 2) {
                                pictureofAlien.setImageResource(R.drawable.alien2)
                            } else if (AlienCiv5Picture == 3) {
                                pictureofAlien.setImageResource(R.drawable.alien3)
                            } else if (AlienCiv5Picture == 4) {
                                pictureofAlien.setImageResource(R.drawable.alien4)
                            } else if (AlienCiv5Picture == 5) {
                                pictureofAlien.setImageResource(R.drawable.alien5)
                            } else if (AlienCiv5Picture == 6) {
                                pictureofAlien.setImageResource(R.drawable.alien6)
                            } else if (AlienCiv5Picture == 7) {
                                pictureofAlien.setImageResource(R.drawable.alien7)
                            } else if (AlienCiv5Picture == 8) {
                                pictureofAlien.setImageResource(R.drawable.alien8)
                            } else if (AlienCiv5Picture == 9) {
                                pictureofAlien.setImageResource(R.drawable.alien9)
                            }  else if (AlienCiv5Picture == 10) {
                                pictureofAlien.setImageResource(R.drawable.alien10)
                            }




                            if (isAlienCiv5Damaged!! <= 0) {
                                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.destoiedplanet)
                            } else if (isAlienCiv5Damaged!! == 1.0) {
                                explosionPic.isVisible = true
                            }

                        }




                        if (SelectedPlanet == 6) {

                            // Displays name and picture of alien based on number

                            nameOfAlienTxt.text = "$AlienCiv6Name"


                            if (AlienCiv6Picture == 1) {
                                pictureofAlien.setImageResource(R.drawable.alien1)
                            } else if (AlienCiv6Picture == 2) {
                                pictureofAlien.setImageResource(R.drawable.alien2)
                            } else if (AlienCiv6Picture == 3) {
                                pictureofAlien.setImageResource(R.drawable.alien3)
                            } else if (AlienCiv6Picture == 4) {
                                pictureofAlien.setImageResource(R.drawable.alien4)
                            } else if (AlienCiv6Picture == 5) {
                                pictureofAlien.setImageResource(R.drawable.alien5)
                            } else if (AlienCiv6Picture == 6) {
                                pictureofAlien.setImageResource(R.drawable.alien6)
                            } else if (AlienCiv6Picture == 7) {
                                pictureofAlien.setImageResource(R.drawable.alien7)
                            } else if (AlienCiv6Picture == 8) {
                                pictureofAlien.setImageResource(R.drawable.alien8)
                            } else if (AlienCiv6Picture == 9) {
                                pictureofAlien.setImageResource(R.drawable.alien9)
                            }  else if (AlienCiv6Picture == 10) {
                                pictureofAlien.setImageResource(R.drawable.alien10)
                            }




                            if (isAlienCiv6Damaged!! <= 0) {
                                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.destoiedplanet)
                            } else if (isAlienCiv6Damaged!! == 1.0) {
                                explosionPic.isVisible = true
                            }

                        }




                        if (SelectedPlanet == 7) {

                            // Displays name and picture of alien based on number

                            nameOfAlienTxt.text = "$AlienCiv7Name"


                            if (AlienCiv7Picture == 1) {
                                pictureofAlien.setImageResource(R.drawable.alien1)
                            } else if (AlienCiv7Picture == 2) {
                                pictureofAlien.setImageResource(R.drawable.alien2)
                            } else if (AlienCiv7Picture == 3) {
                                pictureofAlien.setImageResource(R.drawable.alien3)
                            } else if (AlienCiv7Picture == 4) {
                                pictureofAlien.setImageResource(R.drawable.alien4)
                            } else if (AlienCiv7Picture == 5) {
                                pictureofAlien.setImageResource(R.drawable.alien5)
                            } else if (AlienCiv7Picture == 6) {
                                pictureofAlien.setImageResource(R.drawable.alien6)
                            } else if (AlienCiv7Picture == 7) {
                                pictureofAlien.setImageResource(R.drawable.alien7)
                            } else if (AlienCiv7Picture == 8) {
                                pictureofAlien.setImageResource(R.drawable.alien8)
                            } else if (AlienCiv7Picture == 9) {
                                pictureofAlien.setImageResource(R.drawable.alien9)
                            }  else if (AlienCiv7Picture == 10) {
                                pictureofAlien.setImageResource(R.drawable.alien10)
                            }




                            if (isAlienCiv7Damaged!! <= 0) {
                                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.destoiedplanet)
                            } else if (isAlienCiv7Damaged!! == 1.0) {
                                explosionPic.isVisible = true
                            }

                        }



                        if (SelectedPlanet == 8) {

                            // Displays name and picture of alien based on number

                            nameOfAlienTxt.text = "$AlienCiv8Name"


                            if (AlienCiv8Picture == 1) {
                                pictureofAlien.setImageResource(R.drawable.alien1)
                            } else if (AlienCiv8Picture == 2) {
                                pictureofAlien.setImageResource(R.drawable.alien2)
                            } else if (AlienCiv8Picture == 3) {
                                pictureofAlien.setImageResource(R.drawable.alien3)
                            } else if (AlienCiv8Picture == 4) {
                                pictureofAlien.setImageResource(R.drawable.alien4)
                            } else if (AlienCiv8Picture == 5) {
                                pictureofAlien.setImageResource(R.drawable.alien5)
                            } else if (AlienCiv8Picture == 6) {
                                pictureofAlien.setImageResource(R.drawable.alien6)
                            } else if (AlienCiv8Picture == 7) {
                                pictureofAlien.setImageResource(R.drawable.alien7)
                            } else if (AlienCiv8Picture == 8) {
                                pictureofAlien.setImageResource(R.drawable.alien8)
                            } else if (AlienCiv8Picture == 9) {
                                pictureofAlien.setImageResource(R.drawable.alien9)
                            }  else if (AlienCiv8Picture == 10) {
                                pictureofAlien.setImageResource(R.drawable.alien10)
                            }




                            if (isAlienCiv8Damaged!! <= 0) {
                                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.destoiedplanet)
                            } else if (isAlienCiv8Damaged!! == 1.0) {
                                explosionPic.isVisible = true
                            }

                        }




                        if (SelectedPlanet == 9) {

                            // Displays name and picture of alien based on number

                            nameOfAlienTxt.text = "$AlienCiv9Name"


                            pictureofAlien.setImageResource(R.drawable.sporealientwo)



                            if (isAlienCiv9Damaged!! <= 0) {
                                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.destoiedplanet)
                            } else if (isAlienCiv9Damaged!! == 1.0) {
                                explosionPic.isVisible = true
                            }

                        }




                        if (SelectedPlanet == 10) {

                            // Displays name and picture of alien based on number

                            nameOfAlienTxt.text = "$AlienCiv10Name"


                            pictureofAlien.setImageResource(R.drawable.sporealientwo)



                            if (isAlienCiv10Damaged!! <= 0) {
                                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.destoiedplanet)
                            } else if (isAlienCiv10Damaged!! == 1.0) {
                                explosionPic.isVisible = true
                            }

                        }




                        if (SelectedPlanet == 999) {

                            // Displays name and picture of alien based on number

                            nameOfAlienTxt.text = "$AlienCiv11Name"


                            pictureofAlien.setImageResource(R.drawable.sporealientwo)




                            if (isAlienCiv11Damaged!! <= 0) {
                                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.destoiedplanet)
                            } else if (isAlienCiv11Damaged!! == 1.0) {
                                explosionPic.isVisible = true
                            }

                        }




                        if (SelectedPlanet == 101010) {

                            // Displays name and picture of alien based on number

                            nameOfAlienTxt.text = "$AlienCiv12Name"


                            pictureofAlien.setImageResource(R.drawable.sporealientwo)




                            if (isAlienCiv12Damaged!! <= 0) {
                                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.destoiedplanet)
                            } else if (isAlienCiv12Damaged!! == 1.0) {
                                explosionPic.isVisible = true
                            }

                        }




                        if (SelectedPlanet == 10101010) {

                            // Displays name and picture of alien based on number

                            nameOfAlienTxt.text = "$AlienCiv13Name"


                            pictureofAlien.setImageResource(R.drawable.sporealientwo)



                            if (isAlienCiv13Damaged!! <= 0) {
                                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.destoiedplanet)
                            } else if (isAlienCiv13Damaged!! == 1.0) {
                                explosionPic.isVisible = true
                            }

                        }



                        if (SelectedPlanet == 11) {

                            // Displays name and picture of alien based on number

                            nameOfAlienTxt.text = "$AlienCiv14Name"


                            if (AlienCiv14Picture == 1) {
                                pictureofAlien.setImageResource(R.drawable.alien1)
                            } else if (AlienCiv14Picture == 2) {
                                pictureofAlien.setImageResource(R.drawable.alien2)
                            } else if (AlienCiv14Picture == 3) {
                                pictureofAlien.setImageResource(R.drawable.alien3)
                            } else if (AlienCiv14Picture == 4) {
                                pictureofAlien.setImageResource(R.drawable.alien4)
                            } else if (AlienCiv14Picture == 5) {
                                pictureofAlien.setImageResource(R.drawable.alien5)
                            } else if (AlienCiv14Picture == 6) {
                                pictureofAlien.setImageResource(R.drawable.alien6)
                            } else if (AlienCiv14Picture == 7) {
                                pictureofAlien.setImageResource(R.drawable.alien7)
                            } else if (AlienCiv14Picture == 8) {
                                pictureofAlien.setImageResource(R.drawable.alien8)
                            } else if (AlienCiv14Picture == 9) {
                                pictureofAlien.setImageResource(R.drawable.alien9)
                            }  else if (AlienCiv14Picture == 10) {
                                pictureofAlien.setImageResource(R.drawable.alien10)
                            }




                            if (isAlienCiv14Damaged!! <= 0) {
                                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.destoiedplanet)
                            } else if (isAlienCiv14Damaged!! == 1.0) {
                                explosionPic.isVisible = true
                            }

                        }




                        if (SelectedPlanet == 12) {

                            // Displays name and picture of alien based on number

                            nameOfAlienTxt.text = "$AlienCiv15Name"


                            if (AlienCiv15Picture == 1) {
                                pictureofAlien.setImageResource(R.drawable.alien1)
                            } else if (AlienCiv15Picture == 2) {
                                pictureofAlien.setImageResource(R.drawable.alien2)
                            } else if (AlienCiv15Picture == 3) {
                                pictureofAlien.setImageResource(R.drawable.alien3)
                            } else if (AlienCiv15Picture == 4) {
                                pictureofAlien.setImageResource(R.drawable.alien4)
                            } else if (AlienCiv15Picture == 5) {
                                pictureofAlien.setImageResource(R.drawable.alien5)
                            } else if (AlienCiv15Picture == 6) {
                                pictureofAlien.setImageResource(R.drawable.alien6)
                            } else if (AlienCiv15Picture == 7) {
                                pictureofAlien.setImageResource(R.drawable.alien7)
                            } else if (AlienCiv15Picture == 8) {
                                pictureofAlien.setImageResource(R.drawable.alien8)
                            } else if (AlienCiv15Picture == 9) {
                                pictureofAlien.setImageResource(R.drawable.alien9)
                            }  else if (AlienCiv15Picture == 10) {
                                pictureofAlien.setImageResource(R.drawable.alien10)
                            }




                            if (isAlienCiv15Damaged!! <= 0) {
                                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.destoiedplanet)
                            } else if (isAlienCiv15Damaged!! == 1.0) {
                                explosionPic.isVisible = true
                            }

                        }




                        if (SelectedPlanet == 13) {

                            // Displays name and picture of alien based on number

                            nameOfAlienTxt.text = "$AlienCiv16Name"


                            if (AlienCiv16Picture == 1) {
                                pictureofAlien.setImageResource(R.drawable.alien1)
                            } else if (AlienCiv16Picture == 2) {
                                pictureofAlien.setImageResource(R.drawable.alien2)
                            } else if (AlienCiv16Picture == 3) {
                                pictureofAlien.setImageResource(R.drawable.alien3)
                            } else if (AlienCiv1Picture == 4) {
                                pictureofAlien.setImageResource(R.drawable.alien4)
                            } else if (AlienCiv16Picture == 5) {
                                pictureofAlien.setImageResource(R.drawable.alien5)
                            } else if (AlienCiv16Picture == 6) {
                                pictureofAlien.setImageResource(R.drawable.alien6)
                            } else if (AlienCiv16Picture == 7) {
                                pictureofAlien.setImageResource(R.drawable.alien7)
                            } else if (AlienCiv16Picture == 8) {
                                pictureofAlien.setImageResource(R.drawable.alien8)
                            } else if (AlienCiv16Picture == 9) {
                                pictureofAlien.setImageResource(R.drawable.alien9)
                            }  else if (AlienCiv16Picture == 10) {
                                pictureofAlien.setImageResource(R.drawable.alien10)
                            }




                            if (isAlienCiv16Damaged!! <= 0) {
                                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.destoiedplanet)
                            } else if (isAlienCiv16Damaged!! == 1.0) {
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




                    // Alien 3


                    if (isAlienCiv3Damaged!! > 0 && civilisationSpies == 3) {


                        if (alienCiv3RelationWithPlayer!! > 0) {
                            alienCiv3RelationWithPlayer = alienCiv3RelationWithPlayer!! - 1.0
                        }

                        alienSpiesPlayerMessage()
                        saveAlienData()



                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()
                    }




                    // Alien 4


                    if (isAlienCiv4Damaged!! > 0 && civilisationSpies == 4) {


                        if (alienCiv4RelationWithPlayer!! > 0) {
                            alienCiv4RelationWithPlayer = alienCiv4RelationWithPlayer!! - 1.0
                        }

                        alienSpiesPlayerMessage()
                        saveAlienData()



                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()
                    }




                    // Alien 5


                    if (isAlienCiv5Damaged!! > 0 && civilisationSpies == 5) {


                        if (alienCiv5RelationWithPlayer!! > 0) {
                            alienCiv5RelationWithPlayer = alienCiv5RelationWithPlayer!! - 1.0
                        }

                        alienSpiesPlayerMessage()
                        saveAlienData()



                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()
                    }




                    // Alien 6


                    if (isAlienCiv6Damaged!! > 0 && civilisationSpies == 6) {


                        if (alienCiv6RelationWithPlayer!! > 0) {
                            alienCiv6RelationWithPlayer = alienCiv6RelationWithPlayer!! - 1.0
                        }

                        alienSpiesPlayerMessage()
                        saveAlienData()



                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()
                    }





                    // Alien 7


                    if (isAlienCiv7Damaged!! > 0 && civilisationSpies == 7) {


                        if (alienCiv7RelationWithPlayer!! > 0) {
                            alienCiv7RelationWithPlayer = alienCiv7RelationWithPlayer!! - 1.0
                        }

                        alienSpiesPlayerMessage()
                        saveAlienData()



                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()
                    }





                    // Alien 8


                    if (isAlienCiv8Damaged!! > 0 && civilisationSpies == 8) {


                        if (alienCiv8RelationWithPlayer!! > 0) {
                            alienCiv8RelationWithPlayer = alienCiv8RelationWithPlayer!! - 1.0
                        }

                        alienSpiesPlayerMessage()
                        saveAlienData()



                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()
                    }



                    /*

                    // Alien 9


                    if (isAlienCiv9Damaged!! > 0 && civilisationSpies == 9) {


                        if (alienCiv9RelationWithPlayer!! > 0) {
                            alienCiv9RelationWithPlayer = alienCiv9RelationWithPlayer!! - 1.0
                        }

                        alienSpiesPlayerMessage()
                        saveAlienData()



                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()
                    }





                    // Alien 10


                    if (isAlienCiv10Damaged!! > 0 && civilisationSpies == 10) {


                        if (alienCiv10RelationWithPlayer!! > 0) {
                            alienCiv10RelationWithPlayer = alienCiv10RelationWithPlayer!! - 1.0
                        }

                        alienSpiesPlayerMessage()
                        saveAlienData()



                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()
                    }




                    // Alien 11


                    if (isAlienCiv11Damaged!! > 0 && civilisationSpies == 11) {


                        if (alienCiv11RelationWithPlayer!! > 0) {
                            alienCiv11RelationWithPlayer = alienCiv11RelationWithPlayer!! - 1.0
                        }

                        alienSpiesPlayerMessage()
                        saveAlienData()



                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()
                    }





                    // Alien 12


                    if (isAlienCiv12Damaged!! > 0 && civilisationSpies == 12) {


                        if (alienCiv12RelationWithPlayer!! > 0) {
                            alienCiv12RelationWithPlayer = alienCiv12RelationWithPlayer!! - 1.0
                        }

                        alienSpiesPlayerMessage()
                        saveAlienData()



                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()
                    }




                    // Alien 13


                    if (isAlienCiv13Damaged!! > 0 && civilisationSpies == 13) {


                        if (alienCiv13RelationWithPlayer!! > 0) {
                            alienCiv13RelationWithPlayer = alienCiv13RelationWithPlayer!! - 1.0
                        }

                        alienSpiesPlayerMessage()
                        saveAlienData()



                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()
                    }


                     */




                    // Alien 14


                    if (isAlienCiv14Damaged!! > 0 && civilisationSpies == 9) {


                        if (alienCiv14RelationWithPlayer!! > 0) {
                            alienCiv14RelationWithPlayer = alienCiv14RelationWithPlayer!! - 1.0
                        }

                        alienSpiesPlayerMessage()
                        saveAlienData()



                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()
                    }




                    // Alien 15


                    if (isAlienCiv15Damaged!! > 0 && civilisationSpies == 10) {


                        if (alienCiv15RelationWithPlayer!! > 0) {
                            alienCiv15RelationWithPlayer = alienCiv15RelationWithPlayer!! - 1.0
                        }

                        alienSpiesPlayerMessage()
                        saveAlienData()



                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()
                    }






// Alien 16


                    if (isAlienCiv16Damaged!! > 0 && civilisationSpies == 11) {


                        if (alienCiv16RelationWithPlayer!! > 0) {
                            alienCiv16RelationWithPlayer = alienCiv16RelationWithPlayer!! - 1.0
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












        collectColonyMoney.setOnClickListener {

            moneyAmount += colonyResourses1
            Toast.makeText(this, "You collected $colonyResourses1 money", Toast.LENGTH_SHORT).show()

            colonyResourses1 = 0

            savePlayerData()




        }

















        coloniseImg.setOnClickListener {

            if (colonyId1 == 1000) {

                if (moneyAmount >= 2000 && resoursesAmount >= 2000) {

                    moneyAmount -= 2000
                    resoursesAmount -= 2000

                    colonyId1 = SelectedPlanet

                    coloniseImg.isVisible = false
                    coloniseImg.isEnabled = false

                    Toast.makeText(this, "You created a colony here", Toast.LENGTH_SHORT).show()


                    savePlayerData()

                } else {
                    Toast.makeText(this, "Not enough money and resourses to create a colony", Toast.LENGTH_SHORT).show()

                }




            } else {
                Toast.makeText(this, "You already have a colony", Toast.LENGTH_SHORT).show()

            }



        }









        donateImg.setOnClickListener {

            if (moneyAmount >= 500) {


                // Alien 1

                if (SelectedPlanet == 1 && isAlienCiv1Damaged!! > 0) {

                    alienCiv1RelationWithPlayer = alienCiv1RelationWithPlayer!! + 1.0

                    moneyAmount -= 500

                    donationMessage()

                    NewMessageNotify = true

                    val editNewMessageNotify = sharedNewMessageNotify.edit()
                    editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                    editNewMessageNotify.commit()

                    saveAlienData()
                    savePlayerData()

                    Toast.makeText(this, "You just sent a donation", Toast.LENGTH_SHORT).show()

                } else if (SelectedPlanet == 1 && isAlienCiv1Damaged!! <= 0) {
                    Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()
                }




                // Alien 2



                if (SelectedPlanet == 2 && isAlienCiv2Damaged!! > 0) {

                    alienCiv2RelationWithPlayer = alienCiv2RelationWithPlayer!! + 1.0

                    moneyAmount -= 500

                    donationMessage()

                    NewMessageNotify = true

                    val editNewMessageNotify = sharedNewMessageNotify.edit()
                    editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                    editNewMessageNotify.commit()

                    saveAlienData()
                    savePlayerData()

                    Toast.makeText(this, "You just sent a donation", Toast.LENGTH_SHORT).show()

                } else if (SelectedPlanet == 2 && isAlienCiv2Damaged!! <= 0) {
                    Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()
                }







                // Alien 3

                if (SelectedPlanet == 3 && isAlienCiv3Damaged!! > 0) {

                    alienCiv3RelationWithPlayer = alienCiv3RelationWithPlayer!! + 1.0

                    moneyAmount -= 500

                    donationMessage()

                    NewMessageNotify = true

                    val editNewMessageNotify = sharedNewMessageNotify.edit()
                    editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                    editNewMessageNotify.commit()

                    saveAlienData()
                    savePlayerData()

                    Toast.makeText(this, "You just sent a donation", Toast.LENGTH_SHORT).show()

                } else if (SelectedPlanet == 3 && isAlienCiv3Damaged!! <= 0) {
                    Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()
                }







                // Alien 4

                if (SelectedPlanet == 4 && isAlienCiv4Damaged!! > 0) {

                    alienCiv4RelationWithPlayer = alienCiv4RelationWithPlayer!! + 1.0

                    moneyAmount -= 500

                    donationMessage()

                    NewMessageNotify = true

                    val editNewMessageNotify = sharedNewMessageNotify.edit()
                    editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                    editNewMessageNotify.commit()

                    saveAlienData()
                    savePlayerData()

                    Toast.makeText(this, "You just sent a donation", Toast.LENGTH_SHORT).show()

                } else if (SelectedPlanet == 4 && isAlienCiv4Damaged!! <= 0) {
                    Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()
                }






                // Alien 5

                if (SelectedPlanet == 5 && isAlienCiv5Damaged!! > 0) {

                    alienCiv5RelationWithPlayer = alienCiv5RelationWithPlayer!! + 1.0

                    moneyAmount -= 500

                    donationMessage()

                    NewMessageNotify = true

                    val editNewMessageNotify = sharedNewMessageNotify.edit()
                    editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                    editNewMessageNotify.commit()

                    saveAlienData()
                    savePlayerData()

                    Toast.makeText(this, "You just sent a donation", Toast.LENGTH_SHORT).show()

                } else if (SelectedPlanet == 5 && isAlienCiv5Damaged!! <= 0) {
                    Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()
                }






                // Alien 6

                if (SelectedPlanet == 6 && isAlienCiv6Damaged!! > 0) {

                    alienCiv6RelationWithPlayer = alienCiv6RelationWithPlayer!! + 1.0

                    moneyAmount -= 500

                    donationMessage()

                    NewMessageNotify = true

                    val editNewMessageNotify = sharedNewMessageNotify.edit()
                    editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                    editNewMessageNotify.commit()

                    saveAlienData()
                    savePlayerData()

                    Toast.makeText(this, "You just sent a donation", Toast.LENGTH_SHORT).show()

                } else if (SelectedPlanet == 6 && isAlienCiv6Damaged!! <= 0) {
                    Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()
                }








                // Alien 7

                if (SelectedPlanet == 7 && isAlienCiv7Damaged!! > 0) {

                    alienCiv7RelationWithPlayer = alienCiv7RelationWithPlayer!! + 1.0

                    moneyAmount -= 500

                    donationMessage()

                    NewMessageNotify = true

                    val editNewMessageNotify = sharedNewMessageNotify.edit()
                    editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                    editNewMessageNotify.commit()

                    saveAlienData()
                    savePlayerData()

                    Toast.makeText(this, "You just sent a donation", Toast.LENGTH_SHORT).show()

                } else if (SelectedPlanet == 7 && isAlienCiv7Damaged!! <= 0) {
                    Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()
                }






                // Alien 8

                if (SelectedPlanet == 8 && isAlienCiv8Damaged!! > 0) {

                    alienCiv8RelationWithPlayer = alienCiv8RelationWithPlayer!! + 1.0

                    moneyAmount -= 500

                    donationMessage()

                    NewMessageNotify = true

                    val editNewMessageNotify = sharedNewMessageNotify.edit()
                    editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                    editNewMessageNotify.commit()

                    saveAlienData()
                    savePlayerData()

                    Toast.makeText(this, "You just sent a donation", Toast.LENGTH_SHORT).show()

                } else if (SelectedPlanet == 8 && isAlienCiv8Damaged!! <= 0) {
                    Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()
                }




                // Alien 9

                if (SelectedPlanet == 9 && isAlienCiv9Damaged!! > 0) {

                    alienCiv9RelationWithPlayer = alienCiv9RelationWithPlayer!! + 1.0

                    moneyAmount -= 500

                    donationMessage()

                    NewMessageNotify = true

                    val editNewMessageNotify = sharedNewMessageNotify.edit()
                    editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                    editNewMessageNotify.commit()

                    saveAlienData()
                    savePlayerData()

                    Toast.makeText(this, "You just sent a donation", Toast.LENGTH_SHORT).show()

                } else if (SelectedPlanet == 9 && isAlienCiv9Damaged!! <= 0) {
                    Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()
                }




                // Alien 10

                if (SelectedPlanet == 10 && isAlienCiv10Damaged!! > 0) {

                    alienCiv10RelationWithPlayer = alienCiv10RelationWithPlayer!! + 1.0

                    moneyAmount -= 500

                    donationMessage()

                    NewMessageNotify = true

                    val editNewMessageNotify = sharedNewMessageNotify.edit()
                    editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                    editNewMessageNotify.commit()

                    saveAlienData()
                    savePlayerData()

                    Toast.makeText(this, "You just sent a donation", Toast.LENGTH_SHORT).show()

                } else if (SelectedPlanet == 10 && isAlienCiv10Damaged!! <= 0) {
                    Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()
                }




                // Alien 11

                if (SelectedPlanet == 999 && isAlienCiv11Damaged!! > 0) {

                    alienCiv11RelationWithPlayer = alienCiv11RelationWithPlayer!! + 1.0

                    moneyAmount -= 500

                    donationMessage()

                    NewMessageNotify = true

                    val editNewMessageNotify = sharedNewMessageNotify.edit()
                    editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                    editNewMessageNotify.commit()

                    saveAlienData()
                    savePlayerData()

                    Toast.makeText(this, "You just sent a donation", Toast.LENGTH_SHORT).show()

                } else if (SelectedPlanet == 999 && isAlienCiv11Damaged!! <= 0) {
                    Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()
                }








                // Alien 12

                if (SelectedPlanet == 101010 && isAlienCiv12Damaged!! > 0) {

                    alienCiv12RelationWithPlayer = alienCiv12RelationWithPlayer!! + 1.0

                    moneyAmount -= 500

                    donationMessage()

                    NewMessageNotify = true

                    val editNewMessageNotify = sharedNewMessageNotify.edit()
                    editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                    editNewMessageNotify.commit()

                    saveAlienData()
                    savePlayerData()

                    Toast.makeText(this, "You just sent a donation", Toast.LENGTH_SHORT).show()

                } else if (SelectedPlanet == 101010 && isAlienCiv12Damaged!! <= 0) {
                    Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()
                }





                // Alien 13

                if (SelectedPlanet == 10101010 && isAlienCiv13Damaged!! > 0) {

                    alienCiv13RelationWithPlayer = alienCiv13RelationWithPlayer!! + 1.0

                    moneyAmount -= 500

                    donationMessage()

                    NewMessageNotify = true

                    val editNewMessageNotify = sharedNewMessageNotify.edit()
                    editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                    editNewMessageNotify.commit()

                    saveAlienData()
                    savePlayerData()

                    Toast.makeText(this, "You just sent a donation", Toast.LENGTH_SHORT).show()

                } else if (SelectedPlanet == 10101010 && isAlienCiv13Damaged!! <= 0) {
                    Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()
                }






                // Alien 14

                if (SelectedPlanet == 11 && isAlienCiv14Damaged!! > 0) {

                    alienCiv14RelationWithPlayer = alienCiv14RelationWithPlayer!! + 1.0

                    moneyAmount -= 500

                    donationMessage()

                    NewMessageNotify = true

                    val editNewMessageNotify = sharedNewMessageNotify.edit()
                    editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                    editNewMessageNotify.commit()

                    saveAlienData()
                    savePlayerData()

                    Toast.makeText(this, "You just sent a donation", Toast.LENGTH_SHORT).show()

                } else if (SelectedPlanet == 11 && isAlienCiv14Damaged!! <= 0) {
                    Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()
                }






                // Alien 15

                if (SelectedPlanet == 12 && isAlienCiv15Damaged!! > 0) {

                    alienCiv15RelationWithPlayer = alienCiv15RelationWithPlayer!! + 1.0

                    moneyAmount -= 500

                    donationMessage()

                    NewMessageNotify = true

                    val editNewMessageNotify = sharedNewMessageNotify.edit()
                    editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                    editNewMessageNotify.commit()

                    saveAlienData()
                    savePlayerData()

                    Toast.makeText(this, "You just sent a donation", Toast.LENGTH_SHORT).show()

                } else if (SelectedPlanet == 12 && isAlienCiv15Damaged!! <= 0) {
                    Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()
                }





                // Alien 16

                if (SelectedPlanet == 13 && isAlienCiv16Damaged!! > 0) {

                    alienCiv16RelationWithPlayer = alienCiv16RelationWithPlayer!! + 1.0

                    moneyAmount -= 500

                    donationMessage()

                    NewMessageNotify = true

                    val editNewMessageNotify = sharedNewMessageNotify.edit()
                    editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                    editNewMessageNotify.commit()

                    saveAlienData()
                    savePlayerData()

                    Toast.makeText(this, "You just sent a donation", Toast.LENGTH_SHORT).show()

                } else if (SelectedPlanet == 13 && isAlienCiv16Damaged!! <= 0) {
                    Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()
                }








            }



        }










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





            // Alien 3

            if (SelectedPlanet == 3 && isAlienCiv3Damaged!! > 0) {

                val intent = Intent(this, WarSimulatorActivity :: class.java)
                startActivity(intent)

            } else if (SelectedPlanet == 3 && isAlienCiv3Damaged!! <= 0) {

                Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()

            }



            // Alien 4

            if (SelectedPlanet == 4 && isAlienCiv4Damaged!! > 0) {

                val intent = Intent(this, WarSimulatorActivity :: class.java)
                startActivity(intent)

            } else if (SelectedPlanet == 4 && isAlienCiv4Damaged!! <= 0) {

                Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()

            }





            // Alien 5

            if (SelectedPlanet == 5 && isAlienCiv5Damaged!! > 0) {

                val intent = Intent(this, WarSimulatorActivity :: class.java)
                startActivity(intent)

            } else if (SelectedPlanet == 5 && isAlienCiv5Damaged!! <= 0) {

                Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()

            }







            // Alien 6

            if (SelectedPlanet == 6 && isAlienCiv6Damaged!! > 0) {

                val intent = Intent(this, WarSimulatorActivity :: class.java)
                startActivity(intent)

            } else if (SelectedPlanet == 6 && isAlienCiv6Damaged!! <= 0) {

                Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()

            }


            // Alien 7

            if (SelectedPlanet == 7 && isAlienCiv7Damaged!! > 0) {

                val intent = Intent(this, WarSimulatorActivity :: class.java)
                startActivity(intent)

            } else if (SelectedPlanet == 7 && isAlienCiv7Damaged!! <= 0) {

                Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()

            }



            // Alien 8

            if (SelectedPlanet == 8 && isAlienCiv8Damaged!! > 0) {

                val intent = Intent(this, WarSimulatorActivity :: class.java)
                startActivity(intent)

            } else if (SelectedPlanet == 8 && isAlienCiv8Damaged!! <= 0) {

                Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()

            }



            // Alien 9

            if (SelectedPlanet == 9 && isAlienCiv9Damaged!! > 0) {

                val intent = Intent(this, WarSimulatorActivity :: class.java)
                startActivity(intent)

            } else if (SelectedPlanet == 9 && isAlienCiv9Damaged!! <= 0) {

                Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()

            }



            // Alien 10

            if (SelectedPlanet == 10 && isAlienCiv10Damaged!! > 0) {

                val intent = Intent(this, WarSimulatorActivity :: class.java)
                startActivity(intent)

            } else if (SelectedPlanet == 10 && isAlienCiv10Damaged!! <= 0) {

                Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()

            }




            // Alien 11

            if (SelectedPlanet == 999 && isAlienCiv11Damaged!! > 0) {

                val intent = Intent(this, WarSimulatorActivity :: class.java)
                startActivity(intent)

            } else if (SelectedPlanet == 999 && isAlienCiv11Damaged!! <= 0) {

                Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()

            }



            // Alien 12

            if (SelectedPlanet == 101010 && isAlienCiv12Damaged!! > 0) {

                val intent = Intent(this, WarSimulatorActivity :: class.java)
                startActivity(intent)

            } else if (SelectedPlanet == 101010 && isAlienCiv12Damaged!! <= 0) {

                Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()

            }



            // Alien 13

            if (SelectedPlanet == 10101010 && isAlienCiv13Damaged!! > 0) {

                val intent = Intent(this, WarSimulatorActivity :: class.java)
                startActivity(intent)

            } else if (SelectedPlanet == 10101010 && isAlienCiv13Damaged!! <= 0) {

                Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()

            }



            // Alien 14

            if (SelectedPlanet == 11 && isAlienCiv14Damaged!! > 0) {

                val intent = Intent(this, WarSimulatorActivity :: class.java)
                startActivity(intent)

            } else if (SelectedPlanet == 11 && isAlienCiv14Damaged!! <= 0) {

                Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()

            }



            // Alien 15

            if (SelectedPlanet == 12 && isAlienCiv15Damaged!! > 0) {

                val intent = Intent(this, WarSimulatorActivity :: class.java)
                startActivity(intent)

            } else if (SelectedPlanet == 12 && isAlienCiv15Damaged!! <= 0) {

                Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()

            }




            // Alien 16

            if (SelectedPlanet == 13 && isAlienCiv16Damaged!! > 0) {

                val intent = Intent(this, WarSimulatorActivity :: class.java)
                startActivity(intent)

            } else if (SelectedPlanet == 13 && isAlienCiv16Damaged!! <= 0) {

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





                // Alien civilisation 3


                if (SelectedPlanet == 3 && isAlienCiv3Damaged!! > 0) { // Alien 1

                    if(levelMilitaryBase < 5) {

                        isAlienCiv3Damaged = isAlienCiv3Damaged!! - 1.0
                        alienCiv3RelationWithPlayer = 0.0

                    } else if (levelMilitaryBase == 5) {

                        isAlienCiv3Damaged = isAlienCiv3Damaged!! - 2.0
                        alienCiv3RelationWithPlayer = 0.0

                    }



                    sateliteQuantity -= 1

                    Toast.makeText(this, "You struck this civilisation with a rain of nuclear missiles", Toast.LENGTH_SHORT).show()





                    if (AlienCiv3NuclearSatelites!! > 0.0) {

                        AlienCiv3NuclearSatelites = AlienCiv3NuclearSatelites!! - 1.0
                        isDamagedAlivePlayer = isDamagedAlivePlayer - 1.0

                        Toast.makeText(this, "You were struck back by the aliens nuclear satelites", Toast.LENGTH_SHORT).show()

                        nuclearAttackMessage()

                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()

                    } else if (AlienCiv3NuclearSatelites!! <= 0) {
                        failedNuclearResponseMessage()

                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()
                    }



                } else if (SelectedPlanet == 3 && isAlienCiv3Damaged!! <= 0) {

                    Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()

                }




                // Alien civilisation 4


                if (SelectedPlanet == 4 && isAlienCiv4Damaged!! > 0) { // Alien 1

                    if(levelMilitaryBase < 5) {

                        isAlienCiv4Damaged = isAlienCiv4Damaged!! - 1.0
                        alienCiv4RelationWithPlayer = 0.0

                    } else if (levelMilitaryBase == 5) {

                        isAlienCiv4Damaged = isAlienCiv4Damaged!! - 2.0
                        alienCiv4RelationWithPlayer = 0.0

                    }



                    sateliteQuantity -= 1

                    Toast.makeText(this, "You struck this civilisation with a rain of nuclear missiles", Toast.LENGTH_SHORT).show()





                    if (AlienCiv4NuclearSatelites!! > 0.0) {

                        AlienCiv4NuclearSatelites = AlienCiv4NuclearSatelites!! - 1.0
                        isDamagedAlivePlayer = isDamagedAlivePlayer - 1.0

                        Toast.makeText(this, "You were struck back by the aliens nuclear satelites", Toast.LENGTH_SHORT).show()

                        nuclearAttackMessage()

                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()

                    } else if (AlienCiv4NuclearSatelites!! <= 0) {
                        failedNuclearResponseMessage()

                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()
                    }



                } else if (SelectedPlanet == 4 && isAlienCiv4Damaged!! <= 0) {

                    Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()

                }



                // Alien civilisation 5


                if (SelectedPlanet == 5 && isAlienCiv5Damaged!! > 0) { // Alien 1

                    if(levelMilitaryBase < 5) {

                        isAlienCiv5Damaged = isAlienCiv5Damaged!! - 1.0
                        alienCiv5RelationWithPlayer = 0.0

                    } else if (levelMilitaryBase == 5) {

                        isAlienCiv5Damaged = isAlienCiv5Damaged!! - 2.0
                        alienCiv5RelationWithPlayer = 0.0

                    }



                    sateliteQuantity -= 1

                    Toast.makeText(this, "You struck this civilisation with a rain of nuclear missiles", Toast.LENGTH_SHORT).show()





                    if (AlienCiv5NuclearSatelites!! > 0.0) {

                        AlienCiv5NuclearSatelites = AlienCiv5NuclearSatelites!! - 1.0
                        isDamagedAlivePlayer = isDamagedAlivePlayer - 1.0

                        Toast.makeText(this, "You were struck back by the aliens nuclear satelites", Toast.LENGTH_SHORT).show()

                        nuclearAttackMessage()

                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()

                    } else if (AlienCiv5NuclearSatelites!! <= 0) {
                        failedNuclearResponseMessage()

                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()
                    }



                } else if (SelectedPlanet == 5 && isAlienCiv5Damaged!! <= 0) {

                    Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()

                }




                // Alien civilisation 6


                if (SelectedPlanet == 6 && isAlienCiv6Damaged!! > 0) { // Alien 1

                    if(levelMilitaryBase < 5) {

                        isAlienCiv6Damaged = isAlienCiv6Damaged!! - 1.0
                        alienCiv6RelationWithPlayer = 0.0

                    } else if (levelMilitaryBase == 5) {

                        isAlienCiv6Damaged = isAlienCiv6Damaged!! - 2.0
                        alienCiv6RelationWithPlayer = 0.0

                    }



                    sateliteQuantity -= 1

                    Toast.makeText(this, "You struck this civilisation with a rain of nuclear missiles", Toast.LENGTH_SHORT).show()





                    if (AlienCiv6NuclearSatelites!! > 0.0) {

                        AlienCiv6NuclearSatelites = AlienCiv6NuclearSatelites!! - 1.0
                        isDamagedAlivePlayer = isDamagedAlivePlayer - 1.0

                        Toast.makeText(this, "You were struck back by the aliens nuclear satelites", Toast.LENGTH_SHORT).show()

                        nuclearAttackMessage()

                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()

                    } else if (AlienCiv6NuclearSatelites!! <= 0) {
                        failedNuclearResponseMessage()

                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()
                    }



                } else if (SelectedPlanet == 6 && isAlienCiv6Damaged!! <= 0) {

                    Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()

                }



                // Alien civilisation 7


                if (SelectedPlanet == 7 && isAlienCiv7Damaged!! > 0) { // Alien 1

                    if(levelMilitaryBase < 5) {

                        isAlienCiv7Damaged = isAlienCiv7Damaged!! - 1.0
                        alienCiv7RelationWithPlayer = 0.0

                    } else if (levelMilitaryBase == 5) {

                        isAlienCiv7Damaged = isAlienCiv7Damaged!! - 2.0
                        alienCiv7RelationWithPlayer = 0.0

                    }



                    sateliteQuantity -= 1

                    Toast.makeText(this, "You struck this civilisation with a rain of nuclear missiles", Toast.LENGTH_SHORT).show()





                    if (AlienCiv7NuclearSatelites!! > 0.0) {

                        AlienCiv7NuclearSatelites = AlienCiv7NuclearSatelites!! - 1.0
                        isDamagedAlivePlayer = isDamagedAlivePlayer - 1.0

                        Toast.makeText(this, "You were struck back by the aliens nuclear satelites", Toast.LENGTH_SHORT).show()

                        nuclearAttackMessage()

                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()

                    } else if (AlienCiv7NuclearSatelites!! <= 0) {
                        failedNuclearResponseMessage()

                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()
                    }



                } else if (SelectedPlanet == 7 && isAlienCiv7Damaged!! <= 0) {

                    Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()

                }





                // Alien civilisation 8


                if (SelectedPlanet == 8 && isAlienCiv8Damaged!! > 0) { // Alien 1

                    if(levelMilitaryBase < 5) {

                        isAlienCiv8Damaged = isAlienCiv8Damaged!! - 1.0
                        alienCiv8RelationWithPlayer = 0.0

                    } else if (levelMilitaryBase == 5) {

                        isAlienCiv8Damaged = isAlienCiv8Damaged!! - 2.0
                        alienCiv8RelationWithPlayer = 0.0

                    }



                    sateliteQuantity -= 1

                    Toast.makeText(this, "You struck this civilisation with a rain of nuclear missiles", Toast.LENGTH_SHORT).show()





                    if (AlienCiv8NuclearSatelites!! > 0.0) {

                        AlienCiv8NuclearSatelites = AlienCiv8NuclearSatelites!! - 1.0
                        isDamagedAlivePlayer = isDamagedAlivePlayer - 1.0

                        Toast.makeText(this, "You were struck back by the aliens nuclear satelites", Toast.LENGTH_SHORT).show()

                        nuclearAttackMessage()

                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()

                    } else if (AlienCiv8NuclearSatelites!! <= 0) {
                        failedNuclearResponseMessage()

                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()
                    }



                } else if (SelectedPlanet == 8 && isAlienCiv8Damaged!! <= 0) {

                    Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()

                }




                // Alien civilisation 9


                if (SelectedPlanet == 9 && isAlienCiv9Damaged!! > 0) { // Alien 1

                    if(levelMilitaryBase < 5) {

                        isAlienCiv9Damaged = isAlienCiv9Damaged!! - 1.0
                        alienCiv9RelationWithPlayer = 0.0

                    } else if (levelMilitaryBase == 5) {

                        isAlienCiv9Damaged = isAlienCiv9Damaged!! - 2.0
                        alienCiv9RelationWithPlayer = 0.0

                    }



                    sateliteQuantity -= 1

                    Toast.makeText(this, "You struck this civilisation with a rain of nuclear missiles", Toast.LENGTH_SHORT).show()





                    if (AlienCiv9NuclearSatelites!! > 0.0) {

                        AlienCiv9NuclearSatelites = AlienCiv9NuclearSatelites!! - 1.0
                        isDamagedAlivePlayer = isDamagedAlivePlayer - 1.0

                        Toast.makeText(this, "You were struck back by the aliens nuclear satelites", Toast.LENGTH_SHORT).show()

                        nuclearAttackMessage()

                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()

                    } else if (AlienCiv9NuclearSatelites!! <= 0) {
                        failedNuclearResponseMessage()

                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()
                    }



                } else if (SelectedPlanet == 9 && isAlienCiv9Damaged!! <= 0) {

                    Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()

                }



                // Alien civilisation 10


                if (SelectedPlanet == 10 && isAlienCiv10Damaged!! > 0) { // Alien 1

                    if(levelMilitaryBase < 5) {

                        isAlienCiv10Damaged = isAlienCiv10Damaged!! - 1.0
                        alienCiv10RelationWithPlayer = 0.0

                    } else if (levelMilitaryBase == 5) {

                        isAlienCiv10Damaged = isAlienCiv10Damaged!! - 2.0
                        alienCiv10RelationWithPlayer = 0.0

                    }



                    sateliteQuantity -= 1

                    Toast.makeText(this, "You struck this civilisation with a rain of nuclear missiles", Toast.LENGTH_SHORT).show()





                    if (AlienCiv10NuclearSatelites!! > 0.0) {

                        AlienCiv10NuclearSatelites = AlienCiv10NuclearSatelites!! - 1.0
                        isDamagedAlivePlayer = isDamagedAlivePlayer - 1.0

                        Toast.makeText(this, "You were struck back by the aliens nuclear satelites", Toast.LENGTH_SHORT).show()

                        nuclearAttackMessage()

                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()

                    } else if (AlienCiv10NuclearSatelites!! <= 0) {
                        failedNuclearResponseMessage()

                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()
                    }



                } else if (SelectedPlanet == 10 && isAlienCiv10Damaged!! <= 0) {

                    Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()

                }




                // Alien civilisation 11


                if (SelectedPlanet == 999 && isAlienCiv11Damaged!! > 0) { // Alien 1

                    if(levelMilitaryBase < 5) {

                        isAlienCiv11Damaged = isAlienCiv11Damaged!! - 1.0
                        alienCiv11RelationWithPlayer = 0.0

                    } else if (levelMilitaryBase == 5) {

                        isAlienCiv11Damaged = isAlienCiv11Damaged!! - 2.0
                        alienCiv11RelationWithPlayer = 0.0

                    }



                    sateliteQuantity -= 1

                    Toast.makeText(this, "You struck this civilisation with a rain of nuclear missiles", Toast.LENGTH_SHORT).show()





                    if (AlienCiv11NuclearSatelites!! > 0.0) {

                        AlienCiv11NuclearSatelites = AlienCiv11NuclearSatelites!! - 1.0
                        isDamagedAlivePlayer = isDamagedAlivePlayer - 1.0

                        Toast.makeText(this, "You were struck back by the aliens nuclear satelites", Toast.LENGTH_SHORT).show()

                        nuclearAttackMessage()

                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()

                    } else if (AlienCiv11NuclearSatelites!! <= 0) {
                        failedNuclearResponseMessage()

                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()
                    }



                } else if (SelectedPlanet == 999 && isAlienCiv11Damaged!! <= 0) {

                    Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()

                }





                // Alien civilisation 12


                if (SelectedPlanet == 101010 && isAlienCiv12Damaged!! > 0) { // Alien 1

                    if(levelMilitaryBase < 5) {

                        isAlienCiv12Damaged = isAlienCiv12Damaged!! - 1.0
                        alienCiv12RelationWithPlayer = 0.0

                    } else if (levelMilitaryBase == 5) {

                        isAlienCiv12Damaged = isAlienCiv12Damaged!! - 2.0
                        alienCiv12RelationWithPlayer = 0.0

                    }



                    sateliteQuantity -= 1

                    Toast.makeText(this, "You struck this civilisation with a rain of nuclear missiles", Toast.LENGTH_SHORT).show()





                    if (AlienCiv12NuclearSatelites!! > 0.0) {

                        AlienCiv12NuclearSatelites = AlienCiv12NuclearSatelites!! - 1.0
                        isDamagedAlivePlayer = isDamagedAlivePlayer - 1.0

                        Toast.makeText(this, "You were struck back by the aliens nuclear satelites", Toast.LENGTH_SHORT).show()

                        nuclearAttackMessage()

                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()

                    } else if (AlienCiv12NuclearSatelites!! <= 0) {
                        failedNuclearResponseMessage()

                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()
                    }



                } else if (SelectedPlanet == 101010 && isAlienCiv12Damaged!! <= 0) {

                    Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()

                }





                // Alien civilisation 13


                if (SelectedPlanet == 10101010 && isAlienCiv13Damaged!! > 0) { // Alien 1

                    if(levelMilitaryBase < 5) {

                        isAlienCiv13Damaged = isAlienCiv13Damaged!! - 1.0
                        alienCiv13RelationWithPlayer = 0.0

                    } else if (levelMilitaryBase == 5) {

                        isAlienCiv13Damaged = isAlienCiv13Damaged!! - 2.0
                        alienCiv13RelationWithPlayer = 0.0

                    }



                    sateliteQuantity -= 1

                    Toast.makeText(this, "You struck this civilisation with a rain of nuclear missiles", Toast.LENGTH_SHORT).show()





                    if (AlienCiv13NuclearSatelites!! > 0.0) {

                        AlienCiv13NuclearSatelites = AlienCiv13NuclearSatelites!! - 1.0
                        isDamagedAlivePlayer = isDamagedAlivePlayer - 1.0

                        Toast.makeText(this, "You were struck back by the aliens nuclear satelites", Toast.LENGTH_SHORT).show()

                        nuclearAttackMessage()

                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()

                    } else if (AlienCiv13NuclearSatelites!! <= 0) {
                        failedNuclearResponseMessage()

                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()
                    }



                } else if (SelectedPlanet == 10101010 && isAlienCiv13Damaged!! <= 0) {

                    Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()

                }



                // Alien civilisation 14


                if (SelectedPlanet == 11 && isAlienCiv14Damaged!! > 0) { // Alien 1

                    if(levelMilitaryBase < 5) {

                        isAlienCiv14Damaged = isAlienCiv14Damaged!! - 1.0
                        alienCiv14RelationWithPlayer = 0.0

                    } else if (levelMilitaryBase == 5) {

                        isAlienCiv14Damaged = isAlienCiv14Damaged!! - 2.0
                        alienCiv14RelationWithPlayer = 0.0

                    }



                    sateliteQuantity -= 1

                    Toast.makeText(this, "You struck this civilisation with a rain of nuclear missiles", Toast.LENGTH_SHORT).show()





                    if (AlienCiv14NuclearSatelites!! > 0.0) {

                        AlienCiv14NuclearSatelites = AlienCiv14NuclearSatelites!! - 1.0
                        isDamagedAlivePlayer = isDamagedAlivePlayer - 1.0

                        Toast.makeText(this, "You were struck back by the aliens nuclear satelites", Toast.LENGTH_SHORT).show()

                        nuclearAttackMessage()

                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()

                    } else if (AlienCiv14NuclearSatelites!! <= 0) {
                        failedNuclearResponseMessage()

                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()
                    }



                } else if (SelectedPlanet == 11 && isAlienCiv14Damaged!! <= 0) {

                    Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()

                }



                // Alien civilisation 15


                if (SelectedPlanet == 12 && isAlienCiv15Damaged!! > 0) { // Alien 1

                    if(levelMilitaryBase < 5) {

                        isAlienCiv15Damaged = isAlienCiv15Damaged!! - 1.0
                        alienCiv15RelationWithPlayer = 0.0

                    } else if (levelMilitaryBase == 5) {

                        isAlienCiv15Damaged = isAlienCiv15Damaged!! - 2.0
                        alienCiv15RelationWithPlayer = 0.0

                    }



                    sateliteQuantity -= 1

                    Toast.makeText(this, "You struck this civilisation with a rain of nuclear missiles", Toast.LENGTH_SHORT).show()





                    if (AlienCiv15NuclearSatelites!! > 0.0) {

                        AlienCiv15NuclearSatelites = AlienCiv15NuclearSatelites!! - 1.0
                        isDamagedAlivePlayer = isDamagedAlivePlayer - 1.0

                        Toast.makeText(this, "You were struck back by the aliens nuclear satelites", Toast.LENGTH_SHORT).show()

                        nuclearAttackMessage()

                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()

                    } else if (AlienCiv15NuclearSatelites!! <= 0) {
                        failedNuclearResponseMessage()

                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()
                    }



                } else if (SelectedPlanet == 12 && isAlienCiv15Damaged!! <= 0) {

                    Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()

                }






                // Alien civilisation 16


                if (SelectedPlanet == 13 && isAlienCiv16Damaged!! > 0) { // Alien 1

                    if(levelMilitaryBase < 5) {

                        isAlienCiv16Damaged = isAlienCiv16Damaged!! - 1.0
                        alienCiv16RelationWithPlayer = 0.0

                    } else if (levelMilitaryBase == 5) {

                        isAlienCiv16Damaged = isAlienCiv16Damaged!! - 2.0
                        alienCiv16RelationWithPlayer = 0.0

                    }



                    sateliteQuantity -= 1

                    Toast.makeText(this, "You struck this civilisation with a rain of nuclear missiles", Toast.LENGTH_SHORT).show()





                    if (AlienCiv16NuclearSatelites!! > 0.0) {

                        AlienCiv16NuclearSatelites = AlienCiv16NuclearSatelites!! - 1.0
                        isDamagedAlivePlayer = isDamagedAlivePlayer - 1.0

                        Toast.makeText(this, "You were struck back by the aliens nuclear satelites", Toast.LENGTH_SHORT).show()

                        nuclearAttackMessage()

                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()

                    } else if (AlienCiv16NuclearSatelites!! <= 0) {
                        failedNuclearResponseMessage()

                        NewMessageNotify = true

                        val editNewMessageNotify = sharedNewMessageNotify.edit()
                        editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                        editNewMessageNotify.commit()
                    }



                } else if (SelectedPlanet == 13 && isAlienCiv16Damaged!! <= 0) {

                    Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()

                }







                savePlayerData()
                saveAlienData()


            }



        }














        spyBtn.setOnClickListener {

            // Alien 1


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


            }






            // Alien 2


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


            }





            // Alien 3


            if (SelectedPlanet == 3 && isAlienCiv3Damaged!! > 0) {

                var spied = (1..5).shuffled().last()

                if(spied <= spionageLevelPlayer) {

                    if (AlienCiv3MilitaryBase == 1.0) {

                        spyArmyTextView.text = "Soldiers LV1: $AlienCiv3Soldiers,  Space planes LV1: $AlienCiv3SpacePlanes,  Tanks LV1: $AlienCiv3Tanks,  Space Jets LV1: $AlienCiv3SpaceJets,  Nuclear satelites LV1: $AlienCiv3NuclearSatelites"

                    } else if (AlienCiv3MilitaryBase == 2.0) {

                        spyArmyTextView.text = "Soldiers LV2: $AlienCiv3Soldiers,  Space planes LV1: $AlienCiv3SpacePlanes,  Tanks LV1: $AlienCiv3Tanks,  Space Jets LV1: $AlienCiv3SpaceJets,  Nuclear satelites LV1: $AlienCiv3NuclearSatelites"

                    } else if (AlienCiv3MilitaryBase == 3.0) {

                        spyArmyTextView.text = "Soldiers LV2: $AlienCiv3Soldiers,  Space planes LV1: $AlienCiv3SpacePlanes,  Tanks LV1: $AlienCiv3Tanks,  Space Jets LV1: $AlienCiv3SpaceJets,  Nuclear satelites LV1: $AlienCiv3NuclearSatelites"

                    } else if (AlienCiv3MilitaryBase == 4.0) {

                        spyArmyTextView.text = "Soldiers LV3: $AlienCiv3Soldiers,  Space planes LV1: $AlienCiv3SpacePlanes,  Tanks LV2: $AlienCiv3Tanks,  Space Jets LV1: $AlienCiv3SpaceJets,  Nuclear satelites LV1: $AlienCiv3NuclearSatelites"


                    } else if (AlienCiv3MilitaryBase == 5.0) {

                        spyArmyTextView.text = "Soldiers LV3: $AlienCiv3Soldiers,  Space planes LV1: $AlienCiv3SpacePlanes,  Tanks LV2: $AlienCiv3Tanks,  Space Jets LV1: $AlienCiv3SpaceJets,  Nuclear satelites LV2: $AlienCiv3NuclearSatelites"

                    }


                    Toast.makeText(this, "Your spy reported the numbers in alien army", Toast.LENGTH_SHORT).show()




                } else {

                    Toast.makeText(this, "Your spy has been captured, this will have consequences", Toast.LENGTH_SHORT).show()

                    if (alienCiv3RelationWithPlayer!! > 0) {
                        alienCiv3RelationWithPlayer = alienCiv3RelationWithPlayer!! - 1.0
                    }

                    spionageDiscoveredMessage()
                    saveAlienData()

                    NewMessageNotify = true

                    val editNewMessageNotify = sharedNewMessageNotify.edit()
                    editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                    editNewMessageNotify.commit()

                }


            } else if (SelectedPlanet == 3 && isAlienCiv3Damaged!! <= 0) {

                Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()


            }





            // Alien 4


            if (SelectedPlanet == 4 && isAlienCiv4Damaged!! > 0) {

                var spied = (1..5).shuffled().last()

                if(spied <= spionageLevelPlayer) {

                    if (AlienCiv4MilitaryBase == 1.0) {

                        spyArmyTextView.text = "Soldiers LV1: $AlienCiv4Soldiers,  Space planes LV1: $AlienCiv4SpacePlanes,  Tanks LV1: $AlienCiv4Tanks,  Space Jets LV1: $AlienCiv4SpaceJets,  Nuclear satelites LV1: $AlienCiv4NuclearSatelites"

                    } else if (AlienCiv4MilitaryBase == 2.0) {

                        spyArmyTextView.text = "Soldiers LV2: $AlienCiv4Soldiers,  Space planes LV1: $AlienCiv4SpacePlanes,  Tanks LV1: $AlienCiv4Tanks,  Space Jets LV1: $AlienCiv4SpaceJets,  Nuclear satelites LV1: $AlienCiv4NuclearSatelites"

                    } else if (AlienCiv4MilitaryBase == 3.0) {

                        spyArmyTextView.text = "Soldiers LV2: $AlienCiv4Soldiers,  Space planes LV1: $AlienCiv4SpacePlanes,  Tanks LV1: $AlienCiv4Tanks,  Space Jets LV1: $AlienCiv4SpaceJets,  Nuclear satelites LV1: $AlienCiv4NuclearSatelites"

                    } else if (AlienCiv4MilitaryBase == 4.0) {

                        spyArmyTextView.text = "Soldiers LV3: $AlienCiv4Soldiers,  Space planes LV1: $AlienCiv4SpacePlanes,  Tanks LV2: $AlienCiv4Tanks,  Space Jets LV1: $AlienCiv4SpaceJets,  Nuclear satelites LV1: $AlienCiv4NuclearSatelites"


                    } else if (AlienCiv4MilitaryBase == 5.0) {

                        spyArmyTextView.text = "Soldiers LV3: $AlienCiv4Soldiers,  Space planes LV1: $AlienCiv4SpacePlanes,  Tanks LV2: $AlienCiv4Tanks,  Space Jets LV1: $AlienCiv4SpaceJets,  Nuclear satelites LV2: $AlienCiv4NuclearSatelites"

                    }


                    Toast.makeText(this, "Your spy reported the numbers in alien army", Toast.LENGTH_SHORT).show()




                } else {

                    Toast.makeText(this, "Your spy has been captured, this will have consequences", Toast.LENGTH_SHORT).show()

                    if (alienCiv4RelationWithPlayer!! > 0) {
                        alienCiv4RelationWithPlayer = alienCiv4RelationWithPlayer!! - 1.0
                    }

                    spionageDiscoveredMessage()
                    saveAlienData()

                    NewMessageNotify = true

                    val editNewMessageNotify = sharedNewMessageNotify.edit()
                    editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                    editNewMessageNotify.commit()

                }


            } else if (SelectedPlanet == 4 && isAlienCiv4Damaged!! <= 0) {

                Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()


            }



            // Alien 5


            if (SelectedPlanet == 5 && isAlienCiv5Damaged!! > 0) {

                var spied = (1..5).shuffled().last()

                if(spied <= spionageLevelPlayer) {

                    if (AlienCiv5MilitaryBase == 1.0) {

                        spyArmyTextView.text = "Soldiers LV1: $AlienCiv5Soldiers,  Space planes LV1: $AlienCiv5SpacePlanes,  Tanks LV1: $AlienCiv5Tanks,  Space Jets LV1: $AlienCiv5SpaceJets,  Nuclear satelites LV1: $AlienCiv5NuclearSatelites"

                    } else if (AlienCiv5MilitaryBase == 2.0) {

                        spyArmyTextView.text = "Soldiers LV2: $AlienCiv5Soldiers,  Space planes LV1: $AlienCiv5SpacePlanes,  Tanks LV1: $AlienCiv5Tanks,  Space Jets LV1: $AlienCiv5SpaceJets,  Nuclear satelites LV1: $AlienCiv5NuclearSatelites"

                    } else if (AlienCiv5MilitaryBase == 3.0) {

                        spyArmyTextView.text = "Soldiers LV2: $AlienCiv5Soldiers,  Space planes LV1: $AlienCiv5SpacePlanes,  Tanks LV1: $AlienCiv5Tanks,  Space Jets LV1: $AlienCiv5SpaceJets,  Nuclear satelites LV1: $AlienCiv5NuclearSatelites"

                    } else if (AlienCiv5MilitaryBase == 4.0) {

                        spyArmyTextView.text = "Soldiers LV3: $AlienCiv5Soldiers,  Space planes LV1: $AlienCiv5SpacePlanes,  Tanks LV2: $AlienCiv5Tanks,  Space Jets LV1: $AlienCiv5SpaceJets,  Nuclear satelites LV1: $AlienCiv5NuclearSatelites"


                    } else if (AlienCiv5MilitaryBase == 5.0) {

                        spyArmyTextView.text = "Soldiers LV3: $AlienCiv5Soldiers,  Space planes LV1: $AlienCiv5SpacePlanes,  Tanks LV2: $AlienCiv5Tanks,  Space Jets LV1: $AlienCiv5SpaceJets,  Nuclear satelites LV2: $AlienCiv5NuclearSatelites"

                    }


                    Toast.makeText(this, "Your spy reported the numbers in alien army", Toast.LENGTH_SHORT).show()




                } else {

                    Toast.makeText(this, "Your spy has been captured, this will have consequences", Toast.LENGTH_SHORT).show()

                    if (alienCiv5RelationWithPlayer!! > 0) {
                        alienCiv5RelationWithPlayer = alienCiv5RelationWithPlayer!! - 1.0
                    }

                    spionageDiscoveredMessage()
                    saveAlienData()

                    NewMessageNotify = true

                    val editNewMessageNotify = sharedNewMessageNotify.edit()
                    editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                    editNewMessageNotify.commit()

                }


            } else if (SelectedPlanet == 5 && isAlienCiv5Damaged!! <= 0) {

                Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()


            }


            // Alien 6


            if (SelectedPlanet == 6 && isAlienCiv6Damaged!! > 0) {

                var spied = (1..5).shuffled().last()

                if(spied <= spionageLevelPlayer) {

                    if (AlienCiv6MilitaryBase == 1.0) {

                        spyArmyTextView.text = "Soldiers LV1: $AlienCiv6Soldiers,  Space planes LV1: $AlienCiv6SpacePlanes,  Tanks LV1: $AlienCiv6Tanks,  Space Jets LV1: $AlienCiv6SpaceJets,  Nuclear satelites LV1: $AlienCiv6NuclearSatelites"

                    } else if (AlienCiv6MilitaryBase == 2.0) {

                        spyArmyTextView.text = "Soldiers LV2: $AlienCiv6Soldiers,  Space planes LV1: $AlienCiv6SpacePlanes,  Tanks LV1: $AlienCiv6Tanks,  Space Jets LV1: $AlienCiv6SpaceJets,  Nuclear satelites LV1: $AlienCiv6NuclearSatelites"

                    } else if (AlienCiv6MilitaryBase == 3.0) {

                        spyArmyTextView.text = "Soldiers LV2: $AlienCiv6Soldiers,  Space planes LV1: $AlienCiv6SpacePlanes,  Tanks LV1: $AlienCiv6Tanks,  Space Jets LV1: $AlienCiv6SpaceJets,  Nuclear satelites LV1: $AlienCiv6NuclearSatelites"

                    } else if (AlienCiv6MilitaryBase == 4.0) {

                        spyArmyTextView.text = "Soldiers LV3: $AlienCiv6Soldiers,  Space planes LV1: $AlienCiv6SpacePlanes,  Tanks LV2: $AlienCiv6Tanks,  Space Jets LV1: $AlienCiv6SpaceJets,  Nuclear satelites LV1: $AlienCiv6NuclearSatelites"


                    } else if (AlienCiv6MilitaryBase == 5.0) {

                        spyArmyTextView.text = "Soldiers LV3: $AlienCiv6Soldiers,  Space planes LV1: $AlienCiv6SpacePlanes,  Tanks LV2: $AlienCiv6Tanks,  Space Jets LV1: $AlienCiv6SpaceJets,  Nuclear satelites LV2: $AlienCiv6NuclearSatelites"

                    }


                    Toast.makeText(this, "Your spy reported the numbers in alien army", Toast.LENGTH_SHORT).show()




                } else {

                    Toast.makeText(this, "Your spy has been captured, this will have consequences", Toast.LENGTH_SHORT).show()

                    if (alienCiv6RelationWithPlayer!! > 0) {
                        alienCiv6RelationWithPlayer = alienCiv6RelationWithPlayer!! - 1.0
                    }

                    spionageDiscoveredMessage()
                    saveAlienData()

                    NewMessageNotify = true

                    val editNewMessageNotify = sharedNewMessageNotify.edit()
                    editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                    editNewMessageNotify.commit()

                }


            } else if (SelectedPlanet == 6 && isAlienCiv6Damaged!! <= 0) {

                Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()


            }



            // Alien 7


            if (SelectedPlanet == 7 && isAlienCiv7Damaged!! > 0) {

                var spied = (1..5).shuffled().last()

                if(spied <= spionageLevelPlayer) {

                    if (AlienCiv7MilitaryBase == 1.0) {

                        spyArmyTextView.text = "Soldiers LV1: $AlienCiv7Soldiers,  Space planes LV1: $AlienCiv7SpacePlanes,  Tanks LV1: $AlienCiv7Tanks,  Space Jets LV1: $AlienCiv7SpaceJets,  Nuclear satelites LV1: $AlienCiv7NuclearSatelites"

                    } else if (AlienCiv7MilitaryBase == 2.0) {

                        spyArmyTextView.text = "Soldiers LV2: $AlienCiv7Soldiers,  Space planes LV1: $AlienCiv7SpacePlanes,  Tanks LV1: $AlienCiv7Tanks,  Space Jets LV1: $AlienCiv7SpaceJets,  Nuclear satelites LV1: $AlienCiv7NuclearSatelites"

                    } else if (AlienCiv7MilitaryBase == 3.0) {

                        spyArmyTextView.text = "Soldiers LV2: $AlienCiv7Soldiers,  Space planes LV1: $AlienCiv7SpacePlanes,  Tanks LV1: $AlienCiv7Tanks,  Space Jets LV1: $AlienCiv7SpaceJets,  Nuclear satelites LV1: $AlienCiv7NuclearSatelites"

                    } else if (AlienCiv7MilitaryBase == 4.0) {

                        spyArmyTextView.text = "Soldiers LV3: $AlienCiv7Soldiers,  Space planes LV1: $AlienCiv7SpacePlanes,  Tanks LV2: $AlienCiv7Tanks,  Space Jets LV1: $AlienCiv7SpaceJets,  Nuclear satelites LV1: $AlienCiv7NuclearSatelites"


                    } else if (AlienCiv7MilitaryBase == 5.0) {

                        spyArmyTextView.text = "Soldiers LV3: $AlienCiv7Soldiers,  Space planes LV1: $AlienCiv7SpacePlanes,  Tanks LV2: $AlienCiv7Tanks,  Space Jets LV1: $AlienCiv7SpaceJets,  Nuclear satelites LV2: $AlienCiv7NuclearSatelites"

                    }


                    Toast.makeText(this, "Your spy reported the numbers in alien army", Toast.LENGTH_SHORT).show()




                } else {

                    Toast.makeText(this, "Your spy has been captured, this will have consequences", Toast.LENGTH_SHORT).show()

                    if (alienCiv7RelationWithPlayer!! > 0) {
                        alienCiv7RelationWithPlayer = alienCiv7RelationWithPlayer!! - 1.0
                    }

                    spionageDiscoveredMessage()
                    saveAlienData()

                    NewMessageNotify = true

                    val editNewMessageNotify = sharedNewMessageNotify.edit()
                    editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                    editNewMessageNotify.commit()

                }


            } else if (SelectedPlanet == 7 && isAlienCiv7Damaged!! <= 0) {

                Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()


            }



            // Alien 8


            if (SelectedPlanet == 8 && isAlienCiv8Damaged!! > 0) {

                var spied = (1..5).shuffled().last()

                if(spied <= spionageLevelPlayer) {

                    if (AlienCiv8MilitaryBase == 1.0) {

                        spyArmyTextView.text = "Soldiers LV1: $AlienCiv8Soldiers,  Space planes LV1: $AlienCiv8SpacePlanes,  Tanks LV1: $AlienCiv8Tanks,  Space Jets LV1: $AlienCiv8SpaceJets,  Nuclear satelites LV1: $AlienCiv8NuclearSatelites"

                    } else if (AlienCiv8MilitaryBase == 2.0) {

                        spyArmyTextView.text = "Soldiers LV2: $AlienCiv8Soldiers,  Space planes LV1: $AlienCiv8SpacePlanes,  Tanks LV1: $AlienCiv8Tanks,  Space Jets LV1: $AlienCiv8SpaceJets,  Nuclear satelites LV1: $AlienCiv8NuclearSatelites"

                    } else if (AlienCiv8MilitaryBase == 3.0) {

                        spyArmyTextView.text = "Soldiers LV2: $AlienCiv8Soldiers,  Space planes LV1: $AlienCiv8SpacePlanes,  Tanks LV1: $AlienCiv8Tanks,  Space Jets LV1: $AlienCiv8SpaceJets,  Nuclear satelites LV1: $AlienCiv8NuclearSatelites"

                    } else if (AlienCiv8MilitaryBase == 4.0) {

                        spyArmyTextView.text = "Soldiers LV3: $AlienCiv8Soldiers,  Space planes LV1: $AlienCiv8SpacePlanes,  Tanks LV2: $AlienCiv8Tanks,  Space Jets LV1: $AlienCiv8SpaceJets,  Nuclear satelites LV1: $AlienCiv8NuclearSatelites"


                    } else if (AlienCiv8MilitaryBase == 5.0) {

                        spyArmyTextView.text = "Soldiers LV3: $AlienCiv8Soldiers,  Space planes LV1: $AlienCiv8SpacePlanes,  Tanks LV2: $AlienCiv8Tanks,  Space Jets LV1: $AlienCiv8SpaceJets,  Nuclear satelites LV2: $AlienCiv8NuclearSatelites"

                    }


                    Toast.makeText(this, "Your spy reported the numbers in alien army", Toast.LENGTH_SHORT).show()




                } else {

                    Toast.makeText(this, "Your spy has been captured, this will have consequences", Toast.LENGTH_SHORT).show()

                    if (alienCiv8RelationWithPlayer!! > 0) {
                        alienCiv8RelationWithPlayer = alienCiv8RelationWithPlayer!! - 1.0
                    }

                    spionageDiscoveredMessage()
                    saveAlienData()

                    NewMessageNotify = true

                    val editNewMessageNotify = sharedNewMessageNotify.edit()
                    editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                    editNewMessageNotify.commit()

                }


            } else if (SelectedPlanet == 8 && isAlienCiv8Damaged!! <= 0) {

                Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()


            }





            // Alien 9


            if (SelectedPlanet == 9 && isAlienCiv9Damaged!! > 0) {

                var spied = (1..5).shuffled().last()

                if(spied <= spionageLevelPlayer) {

                    if (AlienCiv9MilitaryBase == 1.0) {

                        spyArmyTextView.text = "Soldiers LV1: $AlienCiv9Soldiers,  Space planes LV1: $AlienCiv9SpacePlanes,  Tanks LV1: $AlienCiv9Tanks,  Space Jets LV1: $AlienCiv9SpaceJets,  Nuclear satelites LV1: $AlienCiv9NuclearSatelites"

                    } else if (AlienCiv9MilitaryBase == 2.0) {

                        spyArmyTextView.text = "Soldiers LV2: $AlienCiv9Soldiers,  Space planes LV1: $AlienCiv9SpacePlanes,  Tanks LV1: $AlienCiv9Tanks,  Space Jets LV1: $AlienCiv9SpaceJets,  Nuclear satelites LV1: $AlienCiv9NuclearSatelites"

                    } else if (AlienCiv9MilitaryBase == 3.0) {

                        spyArmyTextView.text = "Soldiers LV2: $AlienCiv9Soldiers,  Space planes LV1: $AlienCiv9SpacePlanes,  Tanks LV1: $AlienCiv9Tanks,  Space Jets LV1: $AlienCiv9SpaceJets,  Nuclear satelites LV1: $AlienCiv9NuclearSatelites"

                    } else if (AlienCiv9MilitaryBase == 4.0) {

                        spyArmyTextView.text = "Soldiers LV3: $AlienCiv9Soldiers,  Space planes LV1: $AlienCiv9SpacePlanes,  Tanks LV2: $AlienCiv9Tanks,  Space Jets LV1: $AlienCiv9SpaceJets,  Nuclear satelites LV1: $AlienCiv9NuclearSatelites"


                    } else if (AlienCiv9MilitaryBase == 5.0) {

                        spyArmyTextView.text = "Soldiers LV3: $AlienCiv9Soldiers,  Space planes LV1: $AlienCiv9SpacePlanes,  Tanks LV2: $AlienCiv9Tanks,  Space Jets LV1: $AlienCiv9SpaceJets,  Nuclear satelites LV2: $AlienCiv9NuclearSatelites"

                    }


                    Toast.makeText(this, "Your spy reported the numbers in alien army", Toast.LENGTH_SHORT).show()




                } else {

                    Toast.makeText(this, "Your spy has been captured, this will have consequences", Toast.LENGTH_SHORT).show()

                    if (alienCiv9RelationWithPlayer!! > 0) {
                        alienCiv9RelationWithPlayer = alienCiv9RelationWithPlayer!! - 1.0
                    }

                    spionageDiscoveredMessage()
                    saveAlienData()

                    NewMessageNotify = true

                    val editNewMessageNotify = sharedNewMessageNotify.edit()
                    editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                    editNewMessageNotify.commit()

                }


            } else if (SelectedPlanet == 9 && isAlienCiv9Damaged!! <= 0) {

                Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()


            }



            // Alien 10


            if (SelectedPlanet == 10 && isAlienCiv10Damaged!! > 0) {

                var spied = (1..5).shuffled().last()

                if(spied <= spionageLevelPlayer) {

                    if (AlienCiv10MilitaryBase == 1.0) {

                        spyArmyTextView.text = "Soldiers LV1: $AlienCiv10Soldiers,  Space planes LV1: $AlienCiv10SpacePlanes,  Tanks LV1: $AlienCiv10Tanks,  Space Jets LV1: $AlienCiv10SpaceJets,  Nuclear satelites LV1: $AlienCiv10NuclearSatelites"

                    } else if (AlienCiv10MilitaryBase == 2.0) {

                        spyArmyTextView.text = "Soldiers LV2: $AlienCiv10Soldiers,  Space planes LV1: $AlienCiv10SpacePlanes,  Tanks LV1: $AlienCiv10Tanks,  Space Jets LV1: $AlienCiv10SpaceJets,  Nuclear satelites LV1: $AlienCiv10NuclearSatelites"

                    } else if (AlienCiv10MilitaryBase == 3.0) {

                        spyArmyTextView.text = "Soldiers LV2: $AlienCiv10Soldiers,  Space planes LV1: $AlienCiv10SpacePlanes,  Tanks LV1: $AlienCiv10Tanks,  Space Jets LV1: $AlienCiv10SpaceJets,  Nuclear satelites LV1: $AlienCiv10NuclearSatelites"

                    } else if (AlienCiv10MilitaryBase == 4.0) {

                        spyArmyTextView.text = "Soldiers LV3: $AlienCiv10Soldiers,  Space planes LV1: $AlienCiv10SpacePlanes,  Tanks LV2: $AlienCiv10Tanks,  Space Jets LV1: $AlienCiv10SpaceJets,  Nuclear satelites LV1: $AlienCiv10NuclearSatelites"


                    } else if (AlienCiv10MilitaryBase == 5.0) {

                        spyArmyTextView.text = "Soldiers LV3: $AlienCiv10Soldiers,  Space planes LV1: $AlienCiv10SpacePlanes,  Tanks LV2: $AlienCiv10Tanks,  Space Jets LV1: $AlienCiv10SpaceJets,  Nuclear satelites LV2: $AlienCiv10NuclearSatelites"

                    }


                    Toast.makeText(this, "Your spy reported the numbers in alien army", Toast.LENGTH_SHORT).show()




                } else {

                    Toast.makeText(this, "Your spy has been captured, this will have consequences", Toast.LENGTH_SHORT).show()

                    if (alienCiv10RelationWithPlayer!! > 0) {
                        alienCiv10RelationWithPlayer = alienCiv10RelationWithPlayer!! - 1.0
                    }

                    spionageDiscoveredMessage()
                    saveAlienData()

                    NewMessageNotify = true

                    val editNewMessageNotify = sharedNewMessageNotify.edit()
                    editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                    editNewMessageNotify.commit()

                }


            } else if (SelectedPlanet == 10 && isAlienCiv10Damaged!! <= 0) {

                Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()


            }



            // Alien 11


            if (SelectedPlanet == 999 && isAlienCiv11Damaged!! > 0) {

                var spied = (1..5).shuffled().last()

                if(spied <= spionageLevelPlayer) {

                    if (AlienCiv11MilitaryBase == 1.0) {

                        spyArmyTextView.text = "Soldiers LV1: $AlienCiv1Soldiers,  Space planes LV1: $AlienCiv1SpacePlanes,  Tanks LV1: $AlienCiv1Tanks,  Space Jets LV1: $AlienCiv1SpaceJets,  Nuclear satelites LV1: $AlienCiv1NuclearSatelites"

                    } else if (AlienCiv11MilitaryBase == 2.0) {

                        spyArmyTextView.text = "Soldiers LV2: $AlienCiv11Soldiers,  Space planes LV1: $AlienCiv11SpacePlanes,  Tanks LV1: $AlienCiv11Tanks,  Space Jets LV1: $AlienCiv11SpaceJets,  Nuclear satelites LV1: $AlienCiv11NuclearSatelites"

                    } else if (AlienCiv11MilitaryBase == 3.0) {

                        spyArmyTextView.text = "Soldiers LV2: $AlienCiv11Soldiers,  Space planes LV1: $AlienCiv11SpacePlanes,  Tanks LV1: $AlienCiv11Tanks,  Space Jets LV1: $AlienCiv11SpaceJets,  Nuclear satelites LV1: $AlienCiv11NuclearSatelites"

                    } else if (AlienCiv11MilitaryBase == 4.0) {

                        spyArmyTextView.text = "Soldiers LV3: $AlienCiv11Soldiers,  Space planes LV1: $AlienCiv11SpacePlanes,  Tanks LV2: $AlienCiv11Tanks,  Space Jets LV1: $AlienCiv11SpaceJets,  Nuclear satelites LV1: $AlienCiv11NuclearSatelites"


                    } else if (AlienCiv11MilitaryBase == 5.0) {

                        spyArmyTextView.text = "Soldiers LV3: $AlienCiv11Soldiers,  Space planes LV1: $AlienCiv11SpacePlanes,  Tanks LV2: $AlienCiv11Tanks,  Space Jets LV1: $AlienCiv11SpaceJets,  Nuclear satelites LV2: $AlienCiv11NuclearSatelites"

                    }


                    Toast.makeText(this, "Your spy reported the numbers in alien army", Toast.LENGTH_SHORT).show()




                } else {

                    Toast.makeText(this, "Your spy has been captured, this will have consequences", Toast.LENGTH_SHORT).show()

                    if (alienCiv11RelationWithPlayer!! > 0) {
                        alienCiv11RelationWithPlayer = alienCiv11RelationWithPlayer!! - 1.0
                    }

                    spionageDiscoveredMessage()
                    saveAlienData()

                    NewMessageNotify = true

                    val editNewMessageNotify = sharedNewMessageNotify.edit()
                    editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                    editNewMessageNotify.commit()

                }


            } else if (SelectedPlanet == 999 && isAlienCiv11Damaged!! <= 0) {

                Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()


            }




            // Alien 12


            if (SelectedPlanet == 101010 && isAlienCiv12Damaged!! > 0) {

                var spied = (1..5).shuffled().last()

                if(spied <= spionageLevelPlayer) {

                    if (AlienCiv12MilitaryBase == 1.0) {

                        spyArmyTextView.text = "Soldiers LV1: $AlienCiv12Soldiers,  Space planes LV1: $AlienCiv12SpacePlanes,  Tanks LV1: $AlienCiv12Tanks,  Space Jets LV1: $AlienCiv12SpaceJets,  Nuclear satelites LV1: $AlienCiv12NuclearSatelites"

                    } else if (AlienCiv12MilitaryBase == 2.0) {

                        spyArmyTextView.text = "Soldiers LV2: $AlienCiv12Soldiers,  Space planes LV1: $AlienCiv12SpacePlanes,  Tanks LV1: $AlienCiv12Tanks,  Space Jets LV1: $AlienCiv12SpaceJets,  Nuclear satelites LV1: $AlienCiv12NuclearSatelites"

                    } else if (AlienCiv12MilitaryBase == 3.0) {

                        spyArmyTextView.text = "Soldiers LV2: $AlienCiv12Soldiers,  Space planes LV1: $AlienCiv12SpacePlanes,  Tanks LV1: $AlienCiv12Tanks,  Space Jets LV1: $AlienCiv12SpaceJets,  Nuclear satelites LV1: $AlienCiv12NuclearSatelites"

                    } else if (AlienCiv12MilitaryBase == 4.0) {

                        spyArmyTextView.text = "Soldiers LV3: $AlienCiv12Soldiers,  Space planes LV1: $AlienCiv12SpacePlanes,  Tanks LV2: $AlienCiv12Tanks,  Space Jets LV1: $AlienCiv12SpaceJets,  Nuclear satelites LV1: $AlienCiv12NuclearSatelites"


                    } else if (AlienCiv12MilitaryBase == 5.0) {

                        spyArmyTextView.text = "Soldiers LV3: $AlienCiv12Soldiers,  Space planes LV1: $AlienCiv12SpacePlanes,  Tanks LV2: $AlienCiv12Tanks,  Space Jets LV1: $AlienCiv12SpaceJets,  Nuclear satelites LV2: $AlienCiv12NuclearSatelites"

                    }


                    Toast.makeText(this, "Your spy reported the numbers in alien army", Toast.LENGTH_SHORT).show()




                } else {

                    Toast.makeText(this, "Your spy has been captured, this will have consequences", Toast.LENGTH_SHORT).show()

                    if (alienCiv12RelationWithPlayer!! > 0) {
                        alienCiv12RelationWithPlayer = alienCiv12RelationWithPlayer!! - 1.0
                    }

                    spionageDiscoveredMessage()
                    saveAlienData()

                    NewMessageNotify = true

                    val editNewMessageNotify = sharedNewMessageNotify.edit()
                    editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                    editNewMessageNotify.commit()

                }


            } else if (SelectedPlanet == 101010 && isAlienCiv12Damaged!! <= 0) {

                Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()


            }




            // Alien 13


            if (SelectedPlanet == 10101010 && isAlienCiv13Damaged!! > 0) {

                var spied = (1..5).shuffled().last()

                if(spied <= spionageLevelPlayer) {

                    if (AlienCiv13MilitaryBase == 1.0) {

                        spyArmyTextView.text = "Soldiers LV1: $AlienCiv13Soldiers,  Space planes LV1: $AlienCiv13SpacePlanes,  Tanks LV1: $AlienCiv13Tanks,  Space Jets LV1: $AlienCiv13SpaceJets,  Nuclear satelites LV1: $AlienCiv13NuclearSatelites"

                    } else if (AlienCiv13MilitaryBase == 2.0) {

                        spyArmyTextView.text = "Soldiers LV2: $AlienCiv13Soldiers,  Space planes LV1: $AlienCiv13SpacePlanes,  Tanks LV1: $AlienCiv13Tanks,  Space Jets LV1: $AlienCiv13SpaceJets,  Nuclear satelites LV1: $AlienCiv13NuclearSatelites"

                    } else if (AlienCiv13MilitaryBase == 3.0) {

                        spyArmyTextView.text = "Soldiers LV2: $AlienCiv13Soldiers,  Space planes LV1: $AlienCiv13SpacePlanes,  Tanks LV1: $AlienCiv13Tanks,  Space Jets LV1: $AlienCiv13SpaceJets,  Nuclear satelites LV1: $AlienCiv13NuclearSatelites"

                    } else if (AlienCiv13MilitaryBase == 4.0) {

                        spyArmyTextView.text = "Soldiers LV3: $AlienCiv13Soldiers,  Space planes LV1: $AlienCiv13SpacePlanes,  Tanks LV2: $AlienCiv13Tanks,  Space Jets LV1: $AlienCiv13SpaceJets,  Nuclear satelites LV1: $AlienCiv13NuclearSatelites"


                    } else if (AlienCiv13MilitaryBase == 5.0) {

                        spyArmyTextView.text = "Soldiers LV3: $AlienCiv13Soldiers,  Space planes LV1: $AlienCiv13SpacePlanes,  Tanks LV2: $AlienCiv13Tanks,  Space Jets LV1: $AlienCiv13SpaceJets,  Nuclear satelites LV2: $AlienCiv13NuclearSatelites"

                    }


                    Toast.makeText(this, "Your spy reported the numbers in alien army", Toast.LENGTH_SHORT).show()




                } else {

                    Toast.makeText(this, "Your spy has been captured, this will have consequences", Toast.LENGTH_SHORT).show()

                    if (alienCiv13RelationWithPlayer!! > 0) {
                        alienCiv13RelationWithPlayer = alienCiv13RelationWithPlayer!! - 1.0
                    }

                    spionageDiscoveredMessage()
                    saveAlienData()

                    NewMessageNotify = true

                    val editNewMessageNotify = sharedNewMessageNotify.edit()
                    editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                    editNewMessageNotify.commit()

                }


            } else if (SelectedPlanet == 10101010 && isAlienCiv13Damaged!! <= 0) {

                Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()


            }




            // Alien 14


            if (SelectedPlanet == 11 && isAlienCiv14Damaged!! > 0) {

                var spied = (1..5).shuffled().last()

                if(spied <= spionageLevelPlayer) {

                    if (AlienCiv14MilitaryBase == 1.0) {

                        spyArmyTextView.text = "Soldiers LV1: $AlienCiv14Soldiers,  Space planes LV1: $AlienCiv14SpacePlanes,  Tanks LV1: $AlienCiv14Tanks,  Space Jets LV1: $AlienCiv14SpaceJets,  Nuclear satelites LV1: $AlienCiv14NuclearSatelites"

                    } else if (AlienCiv14MilitaryBase == 2.0) {

                        spyArmyTextView.text = "Soldiers LV2: $AlienCiv14Soldiers,  Space planes LV1: $AlienCiv14SpacePlanes,  Tanks LV1: $AlienCiv14Tanks,  Space Jets LV1: $AlienCiv14SpaceJets,  Nuclear satelites LV1: $AlienCiv14NuclearSatelites"

                    } else if (AlienCiv14MilitaryBase == 3.0) {

                        spyArmyTextView.text = "Soldiers LV2: $AlienCiv14Soldiers,  Space planes LV1: $AlienCiv14SpacePlanes,  Tanks LV1: $AlienCiv14Tanks,  Space Jets LV1: $AlienCiv14SpaceJets,  Nuclear satelites LV1: $AlienCiv14NuclearSatelites"

                    } else if (AlienCiv14MilitaryBase == 4.0) {

                        spyArmyTextView.text = "Soldiers LV3: $AlienCiv14Soldiers,  Space planes LV1: $AlienCiv14SpacePlanes,  Tanks LV2: $AlienCiv14Tanks,  Space Jets LV1: $AlienCiv14SpaceJets,  Nuclear satelites LV1: $AlienCiv14NuclearSatelites"


                    } else if (AlienCiv14MilitaryBase == 5.0) {

                        spyArmyTextView.text = "Soldiers LV3: $AlienCiv14Soldiers,  Space planes LV1: $AlienCiv14SpacePlanes,  Tanks LV2: $AlienCiv14Tanks,  Space Jets LV1: $AlienCiv14SpaceJets,  Nuclear satelites LV2: $AlienCiv14NuclearSatelites"

                    }


                    Toast.makeText(this, "Your spy reported the numbers in alien army", Toast.LENGTH_SHORT).show()




                } else {

                    Toast.makeText(this, "Your spy has been captured, this will have consequences", Toast.LENGTH_SHORT).show()

                    if (alienCiv14RelationWithPlayer!! > 0) {
                        alienCiv14RelationWithPlayer = alienCiv14RelationWithPlayer!! - 1.0
                    }

                    spionageDiscoveredMessage()
                    saveAlienData()

                    NewMessageNotify = true

                    val editNewMessageNotify = sharedNewMessageNotify.edit()
                    editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                    editNewMessageNotify.commit()

                }


            } else if (SelectedPlanet == 11 && isAlienCiv14Damaged!! <= 0) {

                Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()


            }






            // Alien 15


            if (SelectedPlanet == 12 && isAlienCiv15Damaged!! > 0) {

                var spied = (1..5).shuffled().last()

                if(spied <= spionageLevelPlayer) {

                    if (AlienCiv15MilitaryBase == 1.0) {

                        spyArmyTextView.text = "Soldiers LV1: $AlienCiv15Soldiers,  Space planes LV1: $AlienCiv15SpacePlanes,  Tanks LV1: $AlienCiv15Tanks,  Space Jets LV1: $AlienCiv15SpaceJets,  Nuclear satelites LV1: $AlienCiv15NuclearSatelites"

                    } else if (AlienCiv15MilitaryBase == 2.0) {

                        spyArmyTextView.text = "Soldiers LV2: $AlienCiv15Soldiers,  Space planes LV1: $AlienCiv15SpacePlanes,  Tanks LV1: $AlienCiv15Tanks,  Space Jets LV1: $AlienCiv15SpaceJets,  Nuclear satelites LV1: $AlienCiv15NuclearSatelites"

                    } else if (AlienCiv15MilitaryBase == 3.0) {

                        spyArmyTextView.text = "Soldiers LV2: $AlienCiv15Soldiers,  Space planes LV1: $AlienCiv15SpacePlanes,  Tanks LV1: $AlienCiv15Tanks,  Space Jets LV1: $AlienCiv15SpaceJets,  Nuclear satelites LV1: $AlienCiv15NuclearSatelites"

                    } else if (AlienCiv15MilitaryBase == 4.0) {

                        spyArmyTextView.text = "Soldiers LV3: $AlienCiv15Soldiers,  Space planes LV1: $AlienCiv15SpacePlanes,  Tanks LV2: $AlienCiv15Tanks,  Space Jets LV1: $AlienCiv15SpaceJets,  Nuclear satelites LV1: $AlienCiv15NuclearSatelites"


                    } else if (AlienCiv15MilitaryBase == 5.0) {

                        spyArmyTextView.text = "Soldiers LV3: $AlienCiv15Soldiers,  Space planes LV1: $AlienCiv15SpacePlanes,  Tanks LV2: $AlienCiv15Tanks,  Space Jets LV1: $AlienCiv15SpaceJets,  Nuclear satelites LV2: $AlienCiv15NuclearSatelites"

                    }


                    Toast.makeText(this, "Your spy reported the numbers in alien army", Toast.LENGTH_SHORT).show()




                } else {

                    Toast.makeText(this, "Your spy has been captured, this will have consequences", Toast.LENGTH_SHORT).show()

                    if (alienCiv15RelationWithPlayer!! > 0) {
                        alienCiv15RelationWithPlayer = alienCiv15RelationWithPlayer!! - 1.0
                    }

                    spionageDiscoveredMessage()
                    saveAlienData()

                    NewMessageNotify = true

                    val editNewMessageNotify = sharedNewMessageNotify.edit()
                    editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                    editNewMessageNotify.commit()

                }


            } else if (SelectedPlanet == 12 && isAlienCiv15Damaged!! <= 0) {

                Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()


            }





            // Alien 16


            if (SelectedPlanet == 13 && isAlienCiv16Damaged!! > 0) {

                var spied = (1..5).shuffled().last()

                if(spied <= spionageLevelPlayer) {

                    if (AlienCiv16MilitaryBase == 1.0) {

                        spyArmyTextView.text = "Soldiers LV1: $AlienCiv16Soldiers,  Space planes LV1: $AlienCiv16SpacePlanes,  Tanks LV1: $AlienCiv16Tanks,  Space Jets LV1: $AlienCiv16SpaceJets,  Nuclear satelites LV1: $AlienCiv16NuclearSatelites"

                    } else if (AlienCiv16MilitaryBase == 2.0) {

                        spyArmyTextView.text = "Soldiers LV2: $AlienCiv16Soldiers,  Space planes LV1: $AlienCiv16SpacePlanes,  Tanks LV1: $AlienCiv16Tanks,  Space Jets LV1: $AlienCiv16SpaceJets,  Nuclear satelites LV1: $AlienCiv16NuclearSatelites"

                    } else if (AlienCiv16MilitaryBase == 3.0) {

                        spyArmyTextView.text = "Soldiers LV2: $AlienCiv16Soldiers,  Space planes LV1: $AlienCiv16SpacePlanes,  Tanks LV1: $AlienCiv16Tanks,  Space Jets LV1: $AlienCiv16SpaceJets,  Nuclear satelites LV1: $AlienCiv16NuclearSatelites"

                    } else if (AlienCiv16MilitaryBase == 4.0) {

                        spyArmyTextView.text = "Soldiers LV3: $AlienCiv16Soldiers,  Space planes LV1: $AlienCiv16SpacePlanes,  Tanks LV2: $AlienCiv16Tanks,  Space Jets LV1: $AlienCiv16SpaceJets,  Nuclear satelites LV1: $AlienCiv16NuclearSatelites"


                    } else if (AlienCiv16MilitaryBase == 5.0) {

                        spyArmyTextView.text = "Soldiers LV3: $AlienCiv16Soldiers,  Space planes LV1: $AlienCiv16SpacePlanes,  Tanks LV2: $AlienCiv16Tanks,  Space Jets LV1: $AlienCiv16SpaceJets,  Nuclear satelites LV2: $AlienCiv16NuclearSatelites"

                    }


                    Toast.makeText(this, "Your spy reported the numbers in alien army", Toast.LENGTH_SHORT).show()




                } else {

                    Toast.makeText(this, "Your spy has been captured, this will have consequences", Toast.LENGTH_SHORT).show()

                    if (alienCiv16RelationWithPlayer!! > 0) {
                        alienCiv16RelationWithPlayer = alienCiv16RelationWithPlayer!! - 1.0
                    }

                    spionageDiscoveredMessage()
                    saveAlienData()

                    NewMessageNotify = true

                    val editNewMessageNotify = sharedNewMessageNotify.edit()
                    editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                    editNewMessageNotify.commit()

                }


            } else if (SelectedPlanet == 13 && isAlienCiv16Damaged!! <= 0) {

                Toast.makeText(this, "Action not allowed, this alien race is destroyed", Toast.LENGTH_SHORT).show()


            }









        }











        // Displays specific alien world based on what planet was selected and recorded by shared pref


        if (SelectedPlanet == 0) {

            pictureofAlien.isVisible = false
            spyArmyTextView.isVisible = false
            spyBtn.isVisible = false
            spyBtn.isEnabled = false
            attackImg.isVisible = false
            attackImg.isEnabled = false
            strikeWithNuclearSatelitesBtn.isVisible = false
            strikeWithNuclearSatelitesBtn.isEnabled = false
            donateImg.isVisible = false
            donateImg.isEnabled = false
            sendASpyText.isVisible = false
            attackTxt.isVisible = false
            nuclearSateliteText.isVisible = false
            donateText.isVisible = false

            visitAlienWorldLayout.background = resources.getDrawable(R.drawable.world0)

        } else if (SelectedPlanet == 1) {

            if (AlienCiv1MilitaryBase!! <= 2.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvone)
            } else if (AlienCiv1MilitaryBase!! == 3.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvtwo)
            } else if (AlienCiv1MilitaryBase!! == 4.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvtwo)
            } else if (AlienCiv1MilitaryBase!! == 5.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlv3)
            }


        } else if (SelectedPlanet == 111) {

            /* Id number of a second visitable planet in the same solar system is the same number of
           the first visitable planet in the system repeated three times
            */


            pictureofAlien.isVisible = false
            spyArmyTextView.isVisible = false
            spyBtn.isVisible = false
            spyBtn.isEnabled = false
            attackImg.isVisible = false
            attackImg.isEnabled = false
            strikeWithNuclearSatelitesBtn.isVisible = false
            strikeWithNuclearSatelitesBtn.isEnabled = false
            donateImg.isVisible = false
            donateImg.isEnabled = false
            sendASpyText.isVisible = false
            attackTxt.isVisible = false
            nuclearSateliteText.isVisible = false
            donateText.isVisible = false




            visitAlienWorldLayout.background = resources.getDrawable(R.drawable.world0)

        } else if (SelectedPlanet == 2) {

            if (AlienCiv2MilitaryBase!! <= 2.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvone)
            } else if (AlienCiv2MilitaryBase!! == 3.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvtwo)
            } else if (AlienCiv2MilitaryBase!! == 4.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvtwo)
            } else if (AlienCiv2MilitaryBase!! == 5.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlv3)
            }

        } else if (SelectedPlanet == 3) {

            if (AlienCiv3MilitaryBase!! <= 2.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvone)
            } else if (AlienCiv3MilitaryBase!! == 3.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvtwo)
            } else if (AlienCiv3MilitaryBase!! == 4.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvtwo)
            } else if (AlienCiv3MilitaryBase!! == 5.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlv3)
            }

        } else if (SelectedPlanet == 4) {

            if (AlienCiv4MilitaryBase!! <= 2.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvone)
            } else if (AlienCiv4MilitaryBase!! == 3.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvtwo)
            } else if (AlienCiv4MilitaryBase!! == 4.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvtwo)
            } else if (AlienCiv4MilitaryBase!! == 5.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlv3)
            }

        } else if (SelectedPlanet == 444) {


            pictureofAlien.isVisible = false
            spyArmyTextView.isVisible = false
            spyBtn.isVisible = false
            spyBtn.isEnabled = false
            attackImg.isVisible = false
            attackImg.isEnabled = false
            strikeWithNuclearSatelitesBtn.isVisible = false
            strikeWithNuclearSatelitesBtn.isEnabled = false
            donateImg.isVisible = false
            donateImg.isEnabled = false
            sendASpyText.isVisible = false
            attackTxt.isVisible = false
            nuclearSateliteText.isVisible = false
            donateText.isVisible = false

            visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvone)

        } else if (SelectedPlanet == 5) {

            if (AlienCiv5MilitaryBase!! <= 2.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvone)
            } else if (AlienCiv5MilitaryBase!! == 3.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvtwo)
            } else if (AlienCiv5MilitaryBase!! == 4.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvtwo)
            } else if (AlienCiv5MilitaryBase!! == 5.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlv3)
            }

        } else if (SelectedPlanet == 6) {

            if (AlienCiv6MilitaryBase!! <= 2.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvone)
            } else if (AlienCiv6MilitaryBase!! == 3.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvtwo)
            } else if (AlienCiv6MilitaryBase!! == 4.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvtwo)
            } else if (AlienCiv6MilitaryBase!! == 5.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlv3)
            }

        } else if (SelectedPlanet == 7) {

            if (AlienCiv7MilitaryBase!! <= 2.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvone)
            } else if (AlienCiv7MilitaryBase!! == 3.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvtwo)
            } else if (AlienCiv7MilitaryBase!! == 4.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvtwo)
            } else if (AlienCiv7MilitaryBase!! == 5.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlv3)
            }

        } else if (SelectedPlanet == 777) {



            pictureofAlien.isVisible = false
            spyArmyTextView.isVisible = false
            spyBtn.isVisible = false
            spyBtn.isEnabled = false
            attackImg.isVisible = false
            attackImg.isEnabled = false
            strikeWithNuclearSatelitesBtn.isVisible = false
            strikeWithNuclearSatelitesBtn.isEnabled = false
            donateImg.isVisible = false
            donateImg.isEnabled = false
            sendASpyText.isVisible = false
            attackTxt.isVisible = false
            nuclearSateliteText.isVisible = false
            donateText.isVisible = false

            visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvone)

        } else if (SelectedPlanet == 8) {

            if (AlienCiv8MilitaryBase!! <= 2.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvone)
            } else if (AlienCiv8MilitaryBase!! == 3.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvtwo)
            } else if (AlienCiv8MilitaryBase!! == 4.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvtwo)
            } else if (AlienCiv8MilitaryBase!! == 5.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlv3)
            }

        } else if (SelectedPlanet == 9) {

            if (AlienCiv9MilitaryBase!! <= 2.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvone)
            } else if (AlienCiv9MilitaryBase!! == 3.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvtwo)
            } else if (AlienCiv9MilitaryBase!! == 4.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvtwo)
            } else if (AlienCiv9MilitaryBase!! == 5.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlv3)
            }

        } else if (SelectedPlanet == 999) {

            if (AlienCiv11MilitaryBase!! <= 2.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvone)
            } else if (AlienCiv11MilitaryBase!! == 3.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvtwo)
            } else if (AlienCiv11MilitaryBase!! == 4.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvtwo)
            } else if (AlienCiv11MilitaryBase!! == 5.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlv3)
            }

        } else if (SelectedPlanet == 10) {

            if (AlienCiv10MilitaryBase!! <= 2.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvone)
            } else if (AlienCiv10MilitaryBase!! == 3.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvtwo)
            } else if (AlienCiv10MilitaryBase!! == 4.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvtwo)
            } else if (AlienCiv10MilitaryBase!! == 5.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlv3)
            }

        } else if (SelectedPlanet== 101010) {

            if (AlienCiv12MilitaryBase!! <= 2.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvone)
            } else if (AlienCiv12MilitaryBase!! == 3.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvtwo)
            } else if (AlienCiv12MilitaryBase!! == 4.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvtwo)
            } else if (AlienCiv12MilitaryBase!! == 5.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlv3)
            }

        } else if (SelectedPlanet==10101010) {

            if (AlienCiv13MilitaryBase!! <= 2.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvone)
            } else if (AlienCiv13MilitaryBase!! == 3.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvtwo)
            } else if (AlienCiv13MilitaryBase!! == 4.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvtwo)
            } else if (AlienCiv13MilitaryBase!! == 5.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlv3)
            }

        } else if (SelectedPlanet == 11) {

            if (AlienCiv14MilitaryBase!! <= 2.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvone)
            } else if (AlienCiv14MilitaryBase!! == 3.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvtwo)
            } else if (AlienCiv14MilitaryBase!! == 4.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvtwo)
            } else if (AlienCiv14MilitaryBase!! == 5.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlv3)
            }

        } else if (SelectedPlanet == 111111) {



        } else if(SelectedPlanet==12) {

            if (AlienCiv15MilitaryBase!! <= 2.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvone)
            } else if (AlienCiv15MilitaryBase!! == 3.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvtwo)
            } else if (AlienCiv15MilitaryBase!! == 4.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvtwo)
            } else if (AlienCiv15MilitaryBase!! == 5.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlv3)
            }

        } else if (SelectedPlanet == 13) {

            if (AlienCiv16MilitaryBase!! <= 2.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvone)
            } else if (AlienCiv16MilitaryBase!! == 3.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvtwo)
            } else if (AlienCiv16MilitaryBase!! == 4.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlvtwo)
            } else if (AlienCiv16MilitaryBase!! == 5.0) {
                visitAlienWorldLayout.background = resources.getDrawable(R.drawable.alienworldlv3)
            }

        }





    }





    fun donationMessage() {


        var spionageMessage = (1..4).shuffled().last()





        // Alien 1

        if (SelectedPlanetV == 1) {

            if (spionageMessage == 1) {
                messageText =
                    "$AlienCiv1Name :  Thank you for the donation, we will update our relationship status"
            } else if (spionageMessage == 2) {
                messageText =
                    "$AlienCiv1Name :  We are grateful for your donation"
            } else if (spionageMessage == 3) {
                messageText =
                    "$AlienCiv1Name :  We changed our mind about you, thank you for your donation"
            } else if (spionageMessage == 4) {
                messageText = "$AlienCiv1Name :  I hope that this donation means that we are not enemies"
            }
        }




        // Alien 2


        if (SelectedPlanetV == 2) {

            if (spionageMessage == 1) {
                messageText =
                    "$AlienCiv2Name :  Thank you for the donation, we will update our relationship status"
            } else if (spionageMessage == 2) {
                messageText =
                    "$AlienCiv2Name :  We are grateful for your donation"
            } else if (spionageMessage == 3) {
                messageText =
                    "$AlienCiv2Name :  We changed our mind about you, thank you for your donation"
            } else if (spionageMessage == 4) {
                messageText = "$AlienCiv2Name :  I hope that this donation means that we are not enemies"
            }

        }




        // Alien 3

        if (SelectedPlanetV == 3) {

            if (spionageMessage == 1) {
                messageText =
                    "$AlienCiv3Name :  Thank you for the donation, we will update our relationship status"
            } else if (spionageMessage == 2) {
                messageText =
                    "$AlienCiv3Name :  We are grateful for your donation"
            } else if (spionageMessage == 3) {
                messageText =
                    "$AlienCiv3Name :  We changed our mind about you, thank you for your donation"
            } else if (spionageMessage == 4) {
                messageText = "$AlienCiv3Name :  I hope that this donation means that we are not enemies"
            }
        }




        // Alien 4

        if (SelectedPlanetV == 4) {

            if (spionageMessage == 1) {
                messageText =
                    "$AlienCiv4Name :  Thank you for the donation, we will update our relationship status"
            } else if (spionageMessage == 2) {
                messageText =
                    "$AlienCiv4Name :  We are grateful for your donation"
            } else if (spionageMessage == 3) {
                messageText =
                    "$AlienCiv4Name :  We changed our mind about you, thank you for your donation"
            } else if (spionageMessage == 4) {
                messageText = "$AlienCiv4Name :  I hope that this donation means that we are not enemies"
            }
        }





        // Alien 5

        if (SelectedPlanetV == 5) {

            if (spionageMessage == 1) {
                messageText =
                    "$AlienCiv5Name :  Thank you for the donation, we will update our relationship status"
            } else if (spionageMessage == 2) {
                messageText =
                    "$AlienCiv5Name :  We are grateful for your donation"
            } else if (spionageMessage == 3) {
                messageText =
                    "$AlienCiv5Name :  We changed our mind about you, thank you for your donation"
            } else if (spionageMessage == 4) {
                messageText = "$AlienCiv5Name :  I hope that this donation means that we are not enemies"
            }
        }





        // Alien 6

        if (SelectedPlanetV == 6) {

            if (spionageMessage == 1) {
                messageText =
                    "$AlienCiv6Name :  Thank you for the donation, we will update our relationship status"
            } else if (spionageMessage == 2) {
                messageText =
                    "$AlienCiv6Name :  We are grateful for your donation"
            } else if (spionageMessage == 3) {
                messageText =
                    "$AlienCiv6Name :  We changed our mind about you, thank you for your donation"
            } else if (spionageMessage == 4) {
                messageText = "$AlienCiv6Name :  I hope that this donation means that we are not enemies"
            }
        }





        // Alien 7

        if (SelectedPlanetV == 7) {

            if (spionageMessage == 1) {
                messageText =
                    "$AlienCiv7Name :  Thank you for the donation, we will update our relationship status"
            } else if (spionageMessage == 2) {
                messageText =
                    "$AlienCiv7Name :  We are grateful for your donation"
            } else if (spionageMessage == 3) {
                messageText =
                    "$AlienCiv7Name :  We changed our mind about you, thank you for your donation"
            } else if (spionageMessage == 4) {
                messageText = "$AlienCiv7Name :  I hope that this donation means that we are not enemies"
            }
        }



        // Alien 8

        if (SelectedPlanetV == 8) {

            if (spionageMessage == 1) {
                messageText =
                    "$AlienCiv8Name :  Thank you for the donation, we will update our relationship status"
            } else if (spionageMessage == 2) {
                messageText =
                    "$AlienCiv8Name :  We are grateful for your donation"
            } else if (spionageMessage == 3) {
                messageText =
                    "$AlienCiv8Name :  We changed our mind about you, thank you for your donation"
            } else if (spionageMessage == 4) {
                messageText = "$AlienCiv8Name :  I hope that this donation means that we are not enemies"
            }
        }



        // Alien 9

        if (SelectedPlanetV == 9) {

            if (spionageMessage == 1) {
                messageText =
                    "$AlienCiv9Name :  Thank you for the donation, we will update our relationship status"
            } else if (spionageMessage == 2) {
                messageText =
                    "$AlienCiv9Name :  We are grateful for your donation"
            } else if (spionageMessage == 3) {
                messageText =
                    "$AlienCiv9Name :  We changed our mind about you, thank you for your donation"
            } else if (spionageMessage == 4) {
                messageText = "$AlienCiv9Name :  I hope that this donation means that we are not enemies"
            }
        }



        // Alien 10

        if (SelectedPlanetV == 10) {

            if (spionageMessage == 1) {
                messageText =
                    "$AlienCiv10Name :  Thank you for the donation, we will update our relationship status"
            } else if (spionageMessage == 2) {
                messageText =
                    "$AlienCiv10Name :  We are grateful for your donation"
            } else if (spionageMessage == 3) {
                messageText =
                    "$AlienCiv10Name :  We changed our mind about you, thank you for your donation"
            } else if (spionageMessage == 4) {
                messageText = "$AlienCiv10Name :  I hope that this donation means that we are not enemies"
            }
        }



        // Alien 11

        if (SelectedPlanetV == 999) {

            if (spionageMessage == 1) {
                messageText =
                    "$AlienCiv11Name :  Thank you for the donation, we will update our relationship status"
            } else if (spionageMessage == 2) {
                messageText =
                    "$AlienCiv11Name :  We are grateful for your donation"
            } else if (spionageMessage == 3) {
                messageText =
                    "$AlienCiv11Name :  We changed our mind about you, thank you for your donation"
            } else if (spionageMessage == 4) {
                messageText = "$AlienCiv11Name :  I hope that this donation means that we are not enemies"
            }
        }




        // Alien 12

        if (SelectedPlanetV == 101010) {

            if (spionageMessage == 1) {
                messageText =
                    "$AlienCiv12Name :  Thank you for the donation, we will update our relationship status"
            } else if (spionageMessage == 2) {
                messageText =
                    "$AlienCiv12Name :  We are grateful for your donation"
            } else if (spionageMessage == 3) {
                messageText =
                    "$AlienCiv12Name :  We changed our mind about you, thank you for your donation"
            } else if (spionageMessage == 4) {
                messageText = "$AlienCiv12Name :  I hope that this donation means that we are not enemies"
            }
        }



        // Alien 13

        if (SelectedPlanetV == 10101010) {

            if (spionageMessage == 1) {
                messageText =
                    "$AlienCiv13Name :  Thank you for the donation, we will update our relationship status"
            } else if (spionageMessage == 2) {
                messageText =
                    "$AlienCiv13Name :  We are grateful for your donation"
            } else if (spionageMessage == 3) {
                messageText =
                    "$AlienCiv13Name :  We changed our mind about you, thank you for your donation"
            } else if (spionageMessage == 4) {
                messageText = "$AlienCiv13Name :  I hope that this donation means that we are not enemies"
            }
        }




        // Alien 14

        if (SelectedPlanetV == 11) {

            if (spionageMessage == 1) {
                messageText =
                    "$AlienCiv14Name :  Thank you for the donation, we will update our relationship status"
            } else if (spionageMessage == 2) {
                messageText =
                    "$AlienCiv14Name :  We are grateful for your donation"
            } else if (spionageMessage == 3) {
                messageText =
                    "$AlienCiv14Name :  We changed our mind about you, thank you for your donation"
            } else if (spionageMessage == 4) {
                messageText = "$AlienCiv14Name :  I hope that this donation means that we are not enemies"
            }
        }



        // Alien 15

        if (SelectedPlanetV == 12) {

            if (spionageMessage == 1) {
                messageText =
                    "$AlienCiv15Name :  Thank you for the donation, we will update our relationship status"
            } else if (spionageMessage == 2) {
                messageText =
                    "$AlienCiv15Name :  We are grateful for your donation"
            } else if (spionageMessage == 3) {
                messageText =
                    "$AlienCiv15Name :  We changed our mind about you, thank you for your donation"
            } else if (spionageMessage == 4) {
                messageText = "$AlienCiv15Name :  I hope that this donation means that we are not enemies"
            }
        }



        // Alien 16

        if (SelectedPlanetV == 13) {

            if (spionageMessage == 1) {
                messageText =
                    "$AlienCiv16Name :  Thank you for the donation, we will update our relationship status"
            } else if (spionageMessage == 2) {
                messageText =
                    "$AlienCiv16Name :  We are grateful for your donation"
            } else if (spionageMessage == 3) {
                messageText =
                    "$AlienCiv16Name :  We changed our mind about you, thank you for your donation"
            } else if (spionageMessage == 4) {
                messageText = "$AlienCiv16Name :  I hope that this donation means that we are not enemies"
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





        // Alien 3

        if (civilisationSpies == 3) {

            if (spionageMessage == 1) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv3Name :  Sorry for sending that spy, we were only curious"
            } else if (spionageMessage == 2) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv3Name :  Your planet is very attractive, and we have many more spies who can confirm that"
            } else if (spionageMessage == 3) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv3Name :  We could react for killing our spy"
            } else if (spionageMessage == 4) {
                messageText = "A spy has been captured in your planet. $AlienCiv3Name :  We are not planning anything bad for you, we sent that spy for prevention"
            }
        }


        // Alien 4

        if (civilisationSpies == 4) {

            if (spionageMessage == 1) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv4Name :  Sorry for sending that spy, we were only curious"
            } else if (spionageMessage == 2) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv4Name :  Your planet is very attractive, and we have many more spies who can confirm that"
            } else if (spionageMessage == 3) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv4Name :  We could react for killing our spy"
            } else if (spionageMessage == 4) {
                messageText = "A spy has been captured in your planet. $AlienCiv4Name :  We are not planning anything bad for you, we sent that spy for prevention"
            }
        }




        // Alien 5

        if (civilisationSpies == 5) {

            if (spionageMessage == 1) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv5Name :  Sorry for sending that spy, we were only curious"
            } else if (spionageMessage == 2) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv5Name :  Your planet is very attractive, and we have many more spies who can confirm that"
            } else if (spionageMessage == 3) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv5Name :  We could react for killing our spy"
            } else if (spionageMessage == 4) {
                messageText = "A spy has been captured in your planet. $AlienCiv5Name :  We are not planning anything bad for you, we sent that spy for prevention"
            }
        }




        // Alien 6

        if (civilisationSpies == 6) {

            if (spionageMessage == 1) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv6Name :  Sorry for sending that spy, we were only curious"
            } else if (spionageMessage == 2) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv6Name :  Your planet is very attractive, and we have many more spies who can confirm that"
            } else if (spionageMessage == 3) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv6Name :  We could react for killing our spy"
            } else if (spionageMessage == 4) {
                messageText = "A spy has been captured in your planet. $AlienCiv6Name :  We are not planning anything bad for you, we sent that spy for prevention"
            }
        }




        // Alien 7

        if (civilisationSpies == 7) {

            if (spionageMessage == 1) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv7Name :  Sorry for sending that spy, we were only curious"
            } else if (spionageMessage == 2) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv7Name :  Your planet is very attractive, and we have many more spies who can confirm that"
            } else if (spionageMessage == 3) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv7Name :  We could react for killing our spy"
            } else if (spionageMessage == 4) {
                messageText = "A spy has been captured in your planet. $AlienCiv7Name :  We are not planning anything bad for you, we sent that spy for prevention"
            }
        }



        // Alien 8

        if (civilisationSpies == 8) {

            if (spionageMessage == 1) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv8Name :  Sorry for sending that spy, we were only curious"
            } else if (spionageMessage == 2) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv8Name :  Your planet is very attractive, and we have many more spies who can confirm that"
            } else if (spionageMessage == 3) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv8Name :  We could react for killing our spy"
            } else if (spionageMessage == 4) {
                messageText = "A spy has been captured in your planet. $AlienCiv8Name :  We are not planning anything bad for you, we sent that spy for prevention"
            }
        }




        // Alien 9

        if (civilisationSpies == 9) {

            if (spionageMessage == 1) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv9Name :  Sorry for sending that spy, we were only curious"
            } else if (spionageMessage == 2) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv9Name :  Your planet is very attractive, and we have many more spies who can confirm that"
            } else if (spionageMessage == 3) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv9Name :  We could react for killing our spy"
            } else if (spionageMessage == 4) {
                messageText = "A spy has been captured in your planet. $AlienCiv9Name :  We are not planning anything bad for you, we sent that spy for prevention"
            }
        }



        // Alien 10

        if (civilisationSpies == 10) {

            if (spionageMessage == 1) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv10Name :  Sorry for sending that spy, we were only curious"
            } else if (spionageMessage == 2) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv10Name :  Your planet is very attractive, and we have many more spies who can confirm that"
            } else if (spionageMessage == 3) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv10Name :  We could react for killing our spy"
            } else if (spionageMessage == 4) {
                messageText = "A spy has been captured in your planet. $AlienCiv10Name :  We are not planning anything bad for you, we sent that spy for prevention"
            }
        }



        // Alien 11

        if (civilisationSpies == 999) {

            if (spionageMessage == 1) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv11Name :  Sorry for sending that spy, we were only curious"
            } else if (spionageMessage == 2) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv11Name :  Your planet is very attractive, and we have many more spies who can confirm that"
            } else if (spionageMessage == 3) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv11Name :  We could react for killing our spy"
            } else if (spionageMessage == 4) {
                messageText = "A spy has been captured in your planet. $AlienCiv11Name :  We are not planning anything bad for you, we sent that spy for prevention"
            }
        }


        // Alien 12

        if (civilisationSpies == 101010) {

            if (spionageMessage == 1) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv12Name :  Sorry for sending that spy, we were only curious"
            } else if (spionageMessage == 2) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv12Name :  Your planet is very attractive, and we have many more spies who can confirm that"
            } else if (spionageMessage == 3) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv12Name :  We could react for killing our spy"
            } else if (spionageMessage == 4) {
                messageText = "A spy has been captured in your planet. $AlienCiv12Name :  We are not planning anything bad for you, we sent that spy for prevention"
            }
        }


        // Alien 13

        if (civilisationSpies == 10101010) {

            if (spionageMessage == 1) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv13Name :  Sorry for sending that spy, we were only curious"
            } else if (spionageMessage == 2) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv13Name :  Your planet is very attractive, and we have many more spies who can confirm that"
            } else if (spionageMessage == 3) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv13Name :  We could react for killing our spy"
            } else if (spionageMessage == 4) {
                messageText = "A spy has been captured in your planet. $AlienCiv13Name :  We are not planning anything bad for you, we sent that spy for prevention"
            }
        }



        // Alien 14

        if (civilisationSpies == 11) {

            if (spionageMessage == 1) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv14Name :  Sorry for sending that spy, we were only curious"
            } else if (spionageMessage == 2) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv14Name :  Your planet is very attractive, and we have many more spies who can confirm that"
            } else if (spionageMessage == 3) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv14Name :  We could react for killing our spy"
            } else if (spionageMessage == 4) {
                messageText = "A spy has been captured in your planet. $AlienCiv14Name :  We are not planning anything bad for you, we sent that spy for prevention"
            }
        }




        // Alien 15

        if (civilisationSpies == 12) {

            if (spionageMessage == 1) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv15Name :  Sorry for sending that spy, we were only curious"
            } else if (spionageMessage == 2) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv15Name :  Your planet is very attractive, and we have many more spies who can confirm that"
            } else if (spionageMessage == 3) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv15Name :  We could react for killing our spy"
            } else if (spionageMessage == 4) {
                messageText = "A spy has been captured in your planet. $AlienCiv15Name :  We are not planning anything bad for you, we sent that spy for prevention"
            }
        }




        // Alien 16

        if (civilisationSpies == 13) {

            if (spionageMessage == 1) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv16Name :  Sorry for sending that spy, we were only curious"
            } else if (spionageMessage == 2) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv16Name :  Your planet is very attractive, and we have many more spies who can confirm that"
            } else if (spionageMessage == 3) {
                messageText =
                    "A spy has been captured in your planet. $AlienCiv16Name :  We could react for killing our spy"
            } else if (spionageMessage == 4) {
                messageText = "A spy has been captured in your planet. $AlienCiv16Name :  We are not planning anything bad for you, we sent that spy for prevention"
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
          savedSateliteUnitQuantity= sateliteQuantity, isDamagedAlive = isDamagedAlivePlayer, colonyId1 = colonyId1,
          colonyResourses1 = colonyResourses1)



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




        if (SelectedPlanetV == 3) { // Alien 3

            if (nuclearStrikeMessage == 1) {
                messageText = "$AlienCiv3Name :  You are lucky we dont have nuclear satelites, we will turn your planet to ash with conventional means you coward"
            } else if (nuclearStrikeMessage == 2) {
                messageText =
                    "$AlienCiv3Name :  We will make you pay for every single palace of ours that you destroyed with that nuclear strike"
            } else if (nuclearStrikeMessage == 3) {
                messageText =
                    "$AlienCiv3Name :  This is a declaration of war, your nuking random civilisations without a reason must be addressed with the right punishment"
            } else if (nuclearStrikeMessage == 4) {
                messageText = "$AlienCiv3Name :  You will payyyyyy for thiiissss buuuaaaaggaaaaaa"
            }

        }




        if (SelectedPlanetV == 4) { // Alien 4

            if (nuclearStrikeMessage == 1) {
                messageText = "$AlienCiv4Name :  You are lucky we dont have nuclear satelites, we will turn your planet to ash with conventional means you coward"
            } else if (nuclearStrikeMessage == 2) {
                messageText =
                    "$AlienCiv4Name :  We will make you pay for every single palace of ours that you destroyed with that nuclear strike"
            } else if (nuclearStrikeMessage == 3) {
                messageText =
                    "$AlienCiv4Name :  This is a declaration of war, your nuking random civilisations without a reason must be addressed with the right punishment"
            } else if (nuclearStrikeMessage == 4) {
                messageText = "$AlienCiv4Name :  You will payyyyyy for thiiissss buuuaaaaggaaaaaa"
            }

        }




        if (SelectedPlanetV == 5) { // Alien 5

            if (nuclearStrikeMessage == 1) {
                messageText = "$AlienCiv5Name :  You are lucky we dont have nuclear satelites, we will turn your planet to ash with conventional means you coward"
            } else if (nuclearStrikeMessage == 2) {
                messageText =
                    "$AlienCiv5Name :  We will make you pay for every single palace of ours that you destroyed with that nuclear strike"
            } else if (nuclearStrikeMessage == 3) {
                messageText =
                    "$AlienCiv5Name :  This is a declaration of war, your nuking random civilisations without a reason must be addressed with the right punishment"
            } else if (nuclearStrikeMessage == 4) {
                messageText = "$AlienCiv5Name :  You will payyyyyy for thiiissss buuuaaaaggaaaaaa"
            }

        }





        if (SelectedPlanetV == 6) { // Alien 6

            if (nuclearStrikeMessage == 1) {
                messageText = "$AlienCiv6Name :  You are lucky we dont have nuclear satelites, we will turn your planet to ash with conventional means you coward"
            } else if (nuclearStrikeMessage == 2) {
                messageText =
                    "$AlienCiv6Name :  We will make you pay for every single palace of ours that you destroyed with that nuclear strike"
            } else if (nuclearStrikeMessage == 3) {
                messageText =
                    "$AlienCiv6Name :  This is a declaration of war, your nuking random civilisations without a reason must be addressed with the right punishment"
            } else if (nuclearStrikeMessage == 4) {
                messageText = "$AlienCiv6Name :  You will payyyyyy for thiiissss buuuaaaaggaaaaaa"
            }

        }




        if (SelectedPlanetV == 7) { // Alien 7

            if (nuclearStrikeMessage == 1) {
                messageText = "$AlienCiv7Name :  You are lucky we dont have nuclear satelites, we will turn your planet to ash with conventional means you coward"
            } else if (nuclearStrikeMessage == 2) {
                messageText =
                    "$AlienCiv7Name :  We will make you pay for every single palace of ours that you destroyed with that nuclear strike"
            } else if (nuclearStrikeMessage == 3) {
                messageText =
                    "$AlienCiv7Name :  This is a declaration of war, your nuking random civilisations without a reason must be addressed with the right punishment"
            } else if (nuclearStrikeMessage == 4) {
                messageText = "$AlienCiv7Name :  You will payyyyyy for thiiissss buuuaaaaggaaaaaa"
            }

        }





        if (SelectedPlanetV == 8) { // Alien 8

            if (nuclearStrikeMessage == 1) {
                messageText = "$AlienCiv8Name :  You are lucky we dont have nuclear satelites, we will turn your planet to ash with conventional means you coward"
            } else if (nuclearStrikeMessage == 2) {
                messageText =
                    "$AlienCiv8Name :  We will make you pay for every single palace of ours that you destroyed with that nuclear strike"
            } else if (nuclearStrikeMessage == 3) {
                messageText =
                    "$AlienCiv8Name :  This is a declaration of war, your nuking random civilisations without a reason must be addressed with the right punishment"
            } else if (nuclearStrikeMessage == 4) {
                messageText = "$AlienCiv8Name :  You will payyyyyy for thiiissss buuuaaaaggaaaaaa"
            }

        }





        if (SelectedPlanetV == 9) { // Alien 9

            if (nuclearStrikeMessage == 1) {
                messageText = "$AlienCiv9Name :  You are lucky we dont have nuclear satelites, we will turn your planet to ash with conventional means you coward"
            } else if (nuclearStrikeMessage == 2) {
                messageText =
                    "$AlienCiv9Name :  We will make you pay for every single palace of ours that you destroyed with that nuclear strike"
            } else if (nuclearStrikeMessage == 3) {
                messageText =
                    "$AlienCiv9Name :  This is a declaration of war, your nuking random civilisations without a reason must be addressed with the right punishment"
            } else if (nuclearStrikeMessage == 4) {
                messageText = "$AlienCiv9Name :  You will payyyyyy for thiiissss buuuaaaaggaaaaaa"
            }

        }





        if (SelectedPlanetV == 10) { // Alien 10

            if (nuclearStrikeMessage == 1) {
                messageText = "$AlienCiv10Name :  You are lucky we dont have nuclear satelites, we will turn your planet to ash with conventional means you coward"
            } else if (nuclearStrikeMessage == 2) {
                messageText =
                    "$AlienCiv10Name :  We will make you pay for every single palace of ours that you destroyed with that nuclear strike"
            } else if (nuclearStrikeMessage == 3) {
                messageText =
                    "$AlienCiv10Name :  This is a declaration of war, your nuking random civilisations without a reason must be addressed with the right punishment"
            } else if (nuclearStrikeMessage == 4) {
                messageText = "$AlienCiv10Name :  You will payyyyyy for thiiissss buuuaaaaggaaaaaa"
            }

        }




        if (SelectedPlanetV == 999) { // Alien 11

            if (nuclearStrikeMessage == 1) {
                messageText = "$AlienCiv11Name :  You are lucky we dont have nuclear satelites, we will turn your planet to ash with conventional means you coward"
            } else if (nuclearStrikeMessage == 2) {
                messageText =
                    "$AlienCiv11Name :  We will make you pay for every single palace of ours that you destroyed with that nuclear strike"
            } else if (nuclearStrikeMessage == 3) {
                messageText =
                    "$AlienCiv11Name :  This is a declaration of war, your nuking random civilisations without a reason must be addressed with the right punishment"
            } else if (nuclearStrikeMessage == 4) {
                messageText = "$AlienCiv11Name :  You will payyyyyy for thiiissss buuuaaaaggaaaaaa"
            }

        }



        if (SelectedPlanetV == 101010) { // Alien 12

            if (nuclearStrikeMessage == 1) {
                messageText = "$AlienCiv12Name :  You are lucky we dont have nuclear satelites, we will turn your planet to ash with conventional means you coward"
            } else if (nuclearStrikeMessage == 2) {
                messageText =
                    "$AlienCiv12Name :  We will make you pay for every single palace of ours that you destroyed with that nuclear strike"
            } else if (nuclearStrikeMessage == 3) {
                messageText =
                    "$AlienCiv12Name :  This is a declaration of war, your nuking random civilisations without a reason must be addressed with the right punishment"
            } else if (nuclearStrikeMessage == 4) {
                messageText = "$AlienCiv12Name :  You will payyyyyy for thiiissss buuuaaaaggaaaaaa"
            }

        }



        if (SelectedPlanetV == 10101010) { // Alien 13

            if (nuclearStrikeMessage == 1) {
                messageText = "$AlienCiv13Name :  You are lucky we dont have nuclear satelites, we will turn your planet to ash with conventional means you coward"
            } else if (nuclearStrikeMessage == 2) {
                messageText =
                    "$AlienCiv13Name :  We will make you pay for every single palace of ours that you destroyed with that nuclear strike"
            } else if (nuclearStrikeMessage == 3) {
                messageText =
                    "$AlienCiv13Name :  This is a declaration of war, your nuking random civilisations without a reason must be addressed with the right punishment"
            } else if (nuclearStrikeMessage == 4) {
                messageText = "$AlienCiv13Name :  You will payyyyyy for thiiissss buuuaaaaggaaaaaa"
            }

        }





        if (SelectedPlanetV == 11) { // Alien 14

            if (nuclearStrikeMessage == 1) {
                messageText = "$AlienCiv14Name :  You are lucky we dont have nuclear satelites, we will turn your planet to ash with conventional means you coward"
            } else if (nuclearStrikeMessage == 2) {
                messageText =
                    "$AlienCiv14Name :  We will make you pay for every single palace of ours that you destroyed with that nuclear strike"
            } else if (nuclearStrikeMessage == 3) {
                messageText =
                    "$AlienCiv14Name :  This is a declaration of war, your nuking random civilisations without a reason must be addressed with the right punishment"
            } else if (nuclearStrikeMessage == 4) {
                messageText = "$AlienCiv14Name :  You will payyyyyy for thiiissss buuuaaaaggaaaaaa"
            }

        }








        if (SelectedPlanetV == 12) { // Alien 15

            if (nuclearStrikeMessage == 1) {
                messageText = "$AlienCiv15Name :  You are lucky we dont have nuclear satelites, we will turn your planet to ash with conventional means you coward"
            } else if (nuclearStrikeMessage == 2) {
                messageText =
                    "$AlienCiv15Name :  We will make you pay for every single palace of ours that you destroyed with that nuclear strike"
            } else if (nuclearStrikeMessage == 3) {
                messageText =
                    "$AlienCiv15Name :  This is a declaration of war, your nuking random civilisations without a reason must be addressed with the right punishment"
            } else if (nuclearStrikeMessage == 4) {
                messageText = "$AlienCiv15Name :  You will payyyyyy for thiiissss buuuaaaaggaaaaaa"
            }

        }






        if (SelectedPlanetV == 13) { // Alien 16

            if (nuclearStrikeMessage == 1) {
                messageText = "$AlienCiv16Name :  You are lucky we dont have nuclear satelites, we will turn your planet to ash with conventional means you coward"
            } else if (nuclearStrikeMessage == 2) {
                messageText =
                    "$AlienCiv16Name :  We will make you pay for every single palace of ours that you destroyed with that nuclear strike"
            } else if (nuclearStrikeMessage == 3) {
                messageText =
                    "$AlienCiv16Name :  This is a declaration of war, your nuking random civilisations without a reason must be addressed with the right punishment"
            } else if (nuclearStrikeMessage == 4) {
                messageText = "$AlienCiv16Name :  You will payyyyyy for thiiissss buuuaaaaggaaaaaa"
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




        if (SelectedPlanetV == 3) { // Alien 3

            if (spionageMessage == 1) {
                messageText = "$AlienCiv3Name :  We captured one of your spies, what are you planing?"
            } else if (spionageMessage == 2) {
                messageText =
                    "$AlienCiv3Name :  We had a lot of fun torturing your spy, please send another one"
            } else if (spionageMessage == 3) {
                messageText =
                    "$AlienCiv3Name :  Never dare to try to spy on us again"
            } else if (spionageMessage == 4) {
                messageText = "$AlienCiv3Name :  A few more spies and we end up both in a war"
            }

        }




        if (SelectedPlanetV == 4) { // Alien 4

            if (spionageMessage == 1) {
                messageText = "$AlienCiv4Name :  We captured one of your spies, what are you planing?"
            } else if (spionageMessage == 2) {
                messageText =
                    "$AlienCiv4Name :  We had a lot of fun torturing your spy, please send another one"
            } else if (spionageMessage == 3) {
                messageText =
                    "$AlienCiv4Name :  Never dare to try to spy on us again"
            } else if (spionageMessage == 4) {
                messageText = "$AlienCiv4Name :  A few more spies and we end up both in a war"
            }

        }




        if (SelectedPlanetV == 5) { // Alien 5

            if (spionageMessage == 1) {
                messageText = "$AlienCiv5Name :  We captured one of your spies, what are you planing?"
            } else if (spionageMessage == 2) {
                messageText =
                    "$AlienCiv5Name :  We had a lot of fun torturing your spy, please send another one"
            } else if (spionageMessage == 3) {
                messageText =
                    "$AlienCiv5Name :  Never dare to try to spy on us again"
            } else if (spionageMessage == 4) {
                messageText = "$AlienCiv5Name :  A few more spies and we end up both in a war"
            }

        }






        if (SelectedPlanetV == 6) { // Alien 6

            if (spionageMessage == 1) {
                messageText = "$AlienCiv6Name :  We captured one of your spies, what are you planing?"
            } else if (spionageMessage == 2) {
                messageText =
                    "$AlienCiv6Name :  We had a lot of fun torturing your spy, please send another one"
            } else if (spionageMessage == 3) {
                messageText =
                    "$AlienCiv6Name :  Never dare to try to spy on us again"
            } else if (spionageMessage == 4) {
                messageText = "$AlienCiv6Name :  A few more spies and we end up both in a war"
            }

        }






        if (SelectedPlanetV == 7) { // Alien 7

            if (spionageMessage == 1) {
                messageText = "$AlienCiv7Name :  We captured one of your spies, what are you planing?"
            } else if (spionageMessage == 2) {
                messageText =
                    "$AlienCiv7Name :  We had a lot of fun torturing your spy, please send another one"
            } else if (spionageMessage == 3) {
                messageText =
                    "$AlienCiv7Name :  Never dare to try to spy on us again"
            } else if (spionageMessage == 4) {
                messageText = "$AlienCiv7Name :  A few more spies and we end up both in a war"
            }

        }





        if (SelectedPlanetV == 8) { // Alien 8

            if (spionageMessage == 1) {
                messageText = "$AlienCiv8Name :  We captured one of your spies, what are you planing?"
            } else if (spionageMessage == 2) {
                messageText =
                    "$AlienCiv8Name :  We had a lot of fun torturing your spy, please send another one"
            } else if (spionageMessage == 3) {
                messageText =
                    "$AlienCiv8Name :  Never dare to try to spy on us again"
            } else if (spionageMessage == 4) {
                messageText = "$AlienCiv8Name :  A few more spies and we end up both in a war"
            }

        }





        if (SelectedPlanetV == 9) { // Alien 9

            if (spionageMessage == 1) {
                messageText = "$AlienCiv9Name :  We captured one of your spies, what are you planing?"
            } else if (spionageMessage == 2) {
                messageText =
                    "$AlienCiv9Name :  We had a lot of fun torturing your spy, please send another one"
            } else if (spionageMessage == 3) {
                messageText =
                    "$AlienCiv9Name :  Never dare to try to spy on us again"
            } else if (spionageMessage == 4) {
                messageText = "$AlienCiv9Name :  A few more spies and we end up both in a war"
            }

        }





        if (SelectedPlanetV == 10) { // Alien 10

            if (spionageMessage == 1) {
                messageText = "$AlienCiv10Name :  We captured one of your spies, what are you planing?"
            } else if (spionageMessage == 2) {
                messageText =
                    "$AlienCiv10Name :  We had a lot of fun torturing your spy, please send another one"
            } else if (spionageMessage == 3) {
                messageText =
                    "$AlienCiv10Name :  Never dare to try to spy on us again"
            } else if (spionageMessage == 4) {
                messageText = "$AlienCiv10Name :  A few more spies and we end up both in a war"
            }

        }





        if (SelectedPlanetV == 999) { // Alien 11

            if (spionageMessage == 1) {
                messageText = "$AlienCiv11Name :  We captured one of your spies, what are you planing?"
            } else if (spionageMessage == 2) {
                messageText =
                    "$AlienCiv11Name :  We had a lot of fun torturing your spy, please send another one"
            } else if (spionageMessage == 3) {
                messageText =
                    "$AlienCiv11Name :  Never dare to try to spy on us again"
            } else if (spionageMessage == 4) {
                messageText = "$AlienCiv11Name :  A few more spies and we end up both in a war"
            }

        }





        if (SelectedPlanetV == 101010) { // Alien 12

            if (spionageMessage == 1) {
                messageText = "$AlienCiv12Name :  We captured one of your spies, what are you planing?"
            } else if (spionageMessage == 2) {
                messageText =
                    "$AlienCiv12Name :  We had a lot of fun torturing your spy, please send another one"
            } else if (spionageMessage == 3) {
                messageText =
                    "$AlienCiv12Name :  Never dare to try to spy on us again"
            } else if (spionageMessage == 4) {
                messageText = "$AlienCiv12Name :  A few more spies and we end up both in a war"
            }

        }





        if (SelectedPlanetV == 10101010) { // Alien 13

            if (spionageMessage == 1) {
                messageText = "$AlienCiv13Name :  We captured one of your spies, what are you planing?"
            } else if (spionageMessage == 2) {
                messageText =
                    "$AlienCiv13Name :  We had a lot of fun torturing your spy, please send another one"
            } else if (spionageMessage == 3) {
                messageText =
                    "$AlienCiv13Name :  Never dare to try to spy on us again"
            } else if (spionageMessage == 4) {
                messageText = "$AlienCiv13Name :  A few more spies and we end up both in a war"
            }

        }






        if (SelectedPlanetV == 11) { // Alien 14

            if (spionageMessage == 1) {
                messageText = "$AlienCiv14Name :  We captured one of your spies, what are you planing?"
            } else if (spionageMessage == 2) {
                messageText =
                    "$AlienCiv14Name :  We had a lot of fun torturing your spy, please send another one"
            } else if (spionageMessage == 3) {
                messageText =
                    "$AlienCiv14Name :  Never dare to try to spy on us again"
            } else if (spionageMessage == 4) {
                messageText = "$AlienCiv14Name :  A few more spies and we end up both in a war"
            }

        }





        if (SelectedPlanetV == 12) { // Alien 15

            if (spionageMessage == 1) {
                messageText = "$AlienCiv15Name :  We captured one of your spies, what are you planing?"
            } else if (spionageMessage == 2) {
                messageText =
                    "$AlienCiv15Name :  We had a lot of fun torturing your spy, please send another one"
            } else if (spionageMessage == 3) {
                messageText =
                    "$AlienCiv15Name :  Never dare to try to spy on us again"
            } else if (spionageMessage == 4) {
                messageText = "$AlienCiv15Name :  A few more spies and we end up both in a war"
            }

        }





        if (SelectedPlanetV == 13) { // Alien 16

            if (spionageMessage == 1) {
                messageText = "$AlienCiv16Name :  We captured one of your spies, what are you planing?"
            } else if (spionageMessage == 2) {
                messageText =
                    "$AlienCiv16Name :  We had a lot of fun torturing your spy, please send another one"
            } else if (spionageMessage == 3) {
                messageText =
                    "$AlienCiv16Name :  Never dare to try to spy on us again"
            } else if (spionageMessage == 4) {
                messageText = "$AlienCiv16Name :  A few more spies and we end up both in a war"
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






        if (SelectedPlanetV == 3) { // Alien 3

            if (nuclearStrikeMessage == 1) {
                messageText = "$AlienCiv3Name :  If you nuke us, we nuke you right back!"
            } else if (nuclearStrikeMessage == 2) {
                messageText =
                    "$AlienCiv3Name :  We will make you pay for every single palace of ours that you destroyed with that nuclear strike"
            } else if (nuclearStrikeMessage == 3) {
                messageText =
                    "$AlienCiv3Name :  This is a declaration of war, your nuking random civilisations without a reason must be addressed with the right punishment"
            } else if (nuclearStrikeMessage == 4) {
                messageText = "$AlienCiv3Name :  You will payyyyyy for thiiissss buuuaaaaggaaaaaa"
            }

        }



        if (SelectedPlanetV == 4) { // Alien 4

            if (nuclearStrikeMessage == 1) {
                messageText = "$AlienCiv4Name :  If you nuke us, we nuke you right back!"
            } else if (nuclearStrikeMessage == 2) {
                messageText =
                    "$AlienCiv4Name :  We will make you pay for every single palace of ours that you destroyed with that nuclear strike"
            } else if (nuclearStrikeMessage == 3) {
                messageText =
                    "$AlienCiv4Name :  This is a declaration of war, your nuking random civilisations without a reason must be addressed with the right punishment"
            } else if (nuclearStrikeMessage == 4) {
                messageText = "$AlienCiv4Name :  You will payyyyyy for thiiissss buuuaaaaggaaaaaa"
            }

        }





        if (SelectedPlanetV == 5) { // Alien 5

            if (nuclearStrikeMessage == 1) {
                messageText = "$AlienCiv5Name :  If you nuke us, we nuke you right back!"
            } else if (nuclearStrikeMessage == 2) {
                messageText =
                    "$AlienCiv5Name :  We will make you pay for every single palace of ours that you destroyed with that nuclear strike"
            } else if (nuclearStrikeMessage == 3) {
                messageText =
                    "$AlienCiv5Name :  This is a declaration of war, your nuking random civilisations without a reason must be addressed with the right punishment"
            } else if (nuclearStrikeMessage == 4) {
                messageText = "$AlienCiv5Name :  You will payyyyyy for thiiissss buuuaaaaggaaaaaa"
            }

        }



        if (SelectedPlanetV == 6) { // Alien 6

            if (nuclearStrikeMessage == 1) {
                messageText = "$AlienCiv6Name :  If you nuke us, we nuke you right back!"
            } else if (nuclearStrikeMessage == 2) {
                messageText =
                    "$AlienCiv6Name :  We will make you pay for every single palace of ours that you destroyed with that nuclear strike"
            } else if (nuclearStrikeMessage == 3) {
                messageText =
                    "$AlienCiv6Name :  This is a declaration of war, your nuking random civilisations without a reason must be addressed with the right punishment"
            } else if (nuclearStrikeMessage == 4) {
                messageText = "$AlienCiv6Name :  You will payyyyyy for thiiissss buuuaaaaggaaaaaa"
            }

        }






        if (SelectedPlanetV == 7) { // Alien 7

            if (nuclearStrikeMessage == 1) {
                messageText = "$AlienCiv7Name :  If you nuke us, we nuke you right back!"
            } else if (nuclearStrikeMessage == 2) {
                messageText =
                    "$AlienCiv7Name :  We will make you pay for every single palace of ours that you destroyed with that nuclear strike"
            } else if (nuclearStrikeMessage == 3) {
                messageText =
                    "$AlienCiv7Name :  This is a declaration of war, your nuking random civilisations without a reason must be addressed with the right punishment"
            } else if (nuclearStrikeMessage == 4) {
                messageText = "$AlienCiv7Name :  You will payyyyyy for thiiissss buuuaaaaggaaaaaa"
            }

        }





        if (SelectedPlanetV == 8) { // Alien 8

            if (nuclearStrikeMessage == 1) {
                messageText = "$AlienCiv8Name :  If you nuke us, we nuke you right back!"
            } else if (nuclearStrikeMessage == 2) {
                messageText =
                    "$AlienCiv8Name :  We will make you pay for every single palace of ours that you destroyed with that nuclear strike"
            } else if (nuclearStrikeMessage == 3) {
                messageText =
                    "$AlienCiv8Name :  This is a declaration of war, your nuking random civilisations without a reason must be addressed with the right punishment"
            } else if (nuclearStrikeMessage == 4) {
                messageText = "$AlienCiv8Name :  You will payyyyyy for thiiissss buuuaaaaggaaaaaa"
            }

        }



        if (SelectedPlanetV == 9) { // Alien 9

            if (nuclearStrikeMessage == 1) {
                messageText = "$AlienCiv9Name :  If you nuke us, we nuke you right back!"
            } else if (nuclearStrikeMessage == 2) {
                messageText =
                    "$AlienCiv9Name :  We will make you pay for every single palace of ours that you destroyed with that nuclear strike"
            } else if (nuclearStrikeMessage == 3) {
                messageText =
                    "$AlienCiv9Name :  This is a declaration of war, your nuking random civilisations without a reason must be addressed with the right punishment"
            } else if (nuclearStrikeMessage == 4) {
                messageText = "$AlienCiv9Name :  You will payyyyyy for thiiissss buuuaaaaggaaaaaa"
            }

        }





        if (SelectedPlanetV == 10) { // Alien 10

            if (nuclearStrikeMessage == 1) {
                messageText = "$AlienCiv10Name :  If you nuke us, we nuke you right back!"
            } else if (nuclearStrikeMessage == 2) {
                messageText =
                    "$AlienCiv10Name :  We will make you pay for every single palace of ours that you destroyed with that nuclear strike"
            } else if (nuclearStrikeMessage == 3) {
                messageText =
                    "$AlienCiv10Name :  This is a declaration of war, your nuking random civilisations without a reason must be addressed with the right punishment"
            } else if (nuclearStrikeMessage == 4) {
                messageText = "$AlienCiv10Name :  You will payyyyyy for thiiissss buuuaaaaggaaaaaa"
            }

        }





        if (SelectedPlanetV == 999) { // Alien 11

            if (nuclearStrikeMessage == 1) {
                messageText = "$AlienCiv11Name :  If you nuke us, we nuke you right back!"
            } else if (nuclearStrikeMessage == 2) {
                messageText =
                    "$AlienCiv11Name :  We will make you pay for every single palace of ours that you destroyed with that nuclear strike"
            } else if (nuclearStrikeMessage == 3) {
                messageText =
                    "$AlienCiv11Name :  This is a declaration of war, your nuking random civilisations without a reason must be addressed with the right punishment"
            } else if (nuclearStrikeMessage == 4) {
                messageText = "$AlienCiv11Name :  You will payyyyyy for thiiissss buuuaaaaggaaaaaa"
            }

        }



        if (SelectedPlanetV == 101010) { // Alien 12

            if (nuclearStrikeMessage == 1) {
                messageText = "$AlienCiv12Name :  If you nuke us, we nuke you right back!"
            } else if (nuclearStrikeMessage == 2) {
                messageText =
                    "$AlienCiv12Name :  We will make you pay for every single palace of ours that you destroyed with that nuclear strike"
            } else if (nuclearStrikeMessage == 3) {
                messageText =
                    "$AlienCiv12Name :  This is a declaration of war, your nuking random civilisations without a reason must be addressed with the right punishment"
            } else if (nuclearStrikeMessage == 4) {
                messageText = "$AlienCiv12Name :  You will payyyyyy for thiiissss buuuaaaaggaaaaaa"
            }

        }




        if (SelectedPlanetV == 10101010) { // Alien 13

            if (nuclearStrikeMessage == 1) {
                messageText = "$AlienCiv13Name :  If you nuke us, we nuke you right back!"
            } else if (nuclearStrikeMessage == 2) {
                messageText =
                    "$AlienCiv13Name :  We will make you pay for every single palace of ours that you destroyed with that nuclear strike"
            } else if (nuclearStrikeMessage == 3) {
                messageText =
                    "$AlienCiv13Name :  This is a declaration of war, your nuking random civilisations without a reason must be addressed with the right punishment"
            } else if (nuclearStrikeMessage == 4) {
                messageText = "$AlienCiv13Name :  You will payyyyyy for thiiissss buuuaaaaggaaaaaa"
            }

        }



        if (SelectedPlanetV == 11) { // Alien 14

            if (nuclearStrikeMessage == 1) {
                messageText = "$AlienCiv14Name :  If you nuke us, we nuke you right back!"
            } else if (nuclearStrikeMessage == 2) {
                messageText =
                    "$AlienCiv14Name :  We will make you pay for every single palace of ours that you destroyed with that nuclear strike"
            } else if (nuclearStrikeMessage == 3) {
                messageText =
                    "$AlienCiv14Name :  This is a declaration of war, your nuking random civilisations without a reason must be addressed with the right punishment"
            } else if (nuclearStrikeMessage == 4) {
                messageText = "$AlienCiv14Name :  You will payyyyyy for thiiissss buuuaaaaggaaaaaa"
            }

        }




        if (SelectedPlanetV == 12) { // Alien 15

            if (nuclearStrikeMessage == 1) {
                messageText = "$AlienCiv15Name :  If you nuke us, we nuke you right back!"
            } else if (nuclearStrikeMessage == 2) {
                messageText =
                    "$AlienCiv15Name :  We will make you pay for every single palace of ours that you destroyed with that nuclear strike"
            } else if (nuclearStrikeMessage == 3) {
                messageText =
                    "$AlienCiv15Name :  This is a declaration of war, your nuking random civilisations without a reason must be addressed with the right punishment"
            } else if (nuclearStrikeMessage == 4) {
                messageText = "$AlienCiv15Name :  You will payyyyyy for thiiissss buuuaaaaggaaaaaa"
            }

        }



        if (SelectedPlanetV == 13) { // Alien 16

            if (nuclearStrikeMessage == 1) {
                messageText = "$AlienCiv16Name :  If you nuke us, we nuke you right back!"
            } else if (nuclearStrikeMessage == 2) {
                messageText =
                    "$AlienCiv16Name :  We will make you pay for every single palace of ours that you destroyed with that nuclear strike"
            } else if (nuclearStrikeMessage == 3) {
                messageText =
                    "$AlienCiv16Name :  This is a declaration of war, your nuking random civilisations without a reason must be addressed with the right punishment"
            } else if (nuclearStrikeMessage == 4) {
                messageText = "$AlienCiv16Name :  You will payyyyyy for thiiissss buuuaaaaggaaaaaa"
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



      database.collection("users").document("User path").collection("Saved aliens data")
              .document("Aliens data").set(dataOfAlienCivilisations)


              .addOnCompleteListener {


              }


      }






















}