package com.example.galaxygame

import android.content.Intent
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
import org.w3c.dom.Text

class WarSimulatorActivity : AppCompatActivity() {







    var soldierQuantity : Double = 100.0
    var airplaneQuantity : Double = 40.0
    var cargoplaneQuantity : Double = 10.0
    var airplane2Quantity : Double = 0.0
    var tankQuantity : Double = 0.0
    var sateliteQuantity : Double = 0.0


    var moneyAmount : Int = 0
    var resoursesAmount : Int = 0
    var levelInfrastructure : Int = 1
    var levelFactory : Int = 1
    var militaryBaseLevel : Int = 0
    var levelGeneralDevelopment : Int = 1
    var levelScientificDevelopment : Int = 1
    var levelSpionage : Int = 1
    var damageToPlayerPlanet : Double = 0.0




    var colonyId1 : Int = 1000
    var colonyResourses1 : Int = 0




    // Aliens


    // Alien 1



    var AlienCiv1Name : String? = null
    var AlienCiv1Picture : Int? = null
    var AlienCiv1MilitaryBase : Double? = null
    var AlienCiv1Soldiers : Double? = null
    var AlienCiv1SpacePlanes : Double? = null
    var AlienCiv1SpaceJets : Double? = null
    var AlienCiv1Tanks : Double? = null
    var AlienCiv1NuclearSatelites : Double? = null
    var isAlienCiv1Damaged : Double? = null
    var alienCiv1RelationWithPlayer : Double? = null


    // Alien 2


    var AlienCiv2Name : String? = null
    var AlienCiv2Picture : Int? = null
    var AlienCiv2MilitaryBase : Double? = null
    var AlienCiv2Soldiers : Double? = null
    var AlienCiv2SpacePlanes : Double? = null
    var AlienCiv2SpaceJets : Double? = null
    var AlienCiv2Tanks : Double? = null
    var AlienCiv2NuclearSatelites : Double? = null
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








    // Aliens universal variables


    var alienSoldiersLeft : Double? = 10.0
    var alienSpacePlanesLeft : Double? = 0.0
    var alienTanksLeft : Double? = 0.0
    var alienSpaceJetsLeft : Double? = 0.0
    var alienMilitaryBase : Double? = null
    var levelDamageToAlienPlanet : Double = 0.0
    var alienRelationship : Double = 0.0



    var selectedSoldiersInt : Int = 0
    var selectedSpacePlanesInt : Int = 0
    var selectedCargoPlanesInt : Int = 0
    var selectedSpaceJetsInt : Int = 0
    var selectedTanksInt : Int = 0


    var selectedSoldiersDouble : Double = 0.0
    var selectedSpacePlanesDouble : Double = 0.0
    var selectedCargoPlanesDouble : Double = 0.0
    var selectedSpaceJetsDouble : Double = 0.0
    var selectedTanksDouble : Double = 0.0


    lateinit var savedMessages : messages
    var newMessageNotifyV : Boolean = false
    var messageText : String = ""
    var calculator : Int = 0





    var attacker = warUnits(0.0, 0.0, 0.0, 0.0)
    var attacked = warUnits(0.0, 0.0, 0.0, 0.0)




    var soldierLv1 = warUnits(5.0, 10.0, 20.0, 10.0)
    var soldierLv2 = warUnits(15.0, 25.0, 20.0, 15.0)
    var soldierLv3 = warUnits(40.0, 40.0, 35.0, 20.0)

    var spacePlane = warUnits(120.0, 240.0, 30.0, 5.0)
    var spaceJet = warUnits(480.0, 800.0, 50.0, 8.0)

    var tankLv1 = warUnits(2000.0, 100.0, 5.0, 10.0)
    var tankLv2 = warUnits(8000.0, 400.0, 10.0, 15.0)


    var soldierUnits = warUnits(5.0, 10.0, 20.0, 10.0)
    var spacePlaneUnits = warUnits(120.0, 240.0, 80.0, 5.0)
    var spaceJetUnits = warUnits(480.0, 800.0, 95.0, 8.0)
    var tankUnits = warUnits(2000.0, 100.0, 5.0, 10.0)






    var alienSoldierLv1 = warUnits(5.0, 10.0, 20.0, 10.0)
    var alienSoldierLv2 = warUnits(15.0, 25.0, 20.0, 15.0)
    var alienSoldierLv3 = warUnits(40.0, 40.0, 35.0, 20.0)

    var alienSpacePlane = warUnits(120.0, 240.0, 30.0, 5.0)
    var alienSpaceJet = warUnits(480.0, 800.0, 50.0, 8.0)

    var alienTankLv1 = warUnits(2000.0, 100.0, 5.0, 10.0)
    var alienTankLv2 = warUnits(8000.0, 400.0, 10.0, 15.0)


    var alienSoldierUnits = warUnits(5.0, 10.0, 20.0, 10.0)
    var alienSpacePlaneUnits = warUnits(120.0, 240.0, 80.0, 5.0)
    var alienSpaceJetUnits = warUnits(480.0, 800.0, 95.0, 8.0)
    var alienTankUnits = warUnits(2000.0, 100.0, 5.0, 10.0)




    var selectedPlanetV : Int = 0








    lateinit var soldiersTxt : TextView
    lateinit var spacePlaneTxt : TextView
    lateinit var tankTxt : TextView
    lateinit var spaceJetsTxt : TextView
    lateinit var cargoPlanesTxt : TextView

    lateinit var soldiersEt : TextView
    lateinit var spacePlanesEt : TextView
    lateinit var tanksEt : TextView
    lateinit var spaceJetsEt : TextView
    lateinit var cargoPlanesEt : TextView

    lateinit var attackBtn : Button



    lateinit var savedDataOfAliens : aliens
    lateinit var savedDataOfUser : playerData
    lateinit var database : FirebaseFirestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_war_simulator)

        database = Firebase.firestore



        soldiersTxt = findViewById(R.id.soldiersTxt)
        spacePlaneTxt = findViewById(R.id.spacePlaneTxt)
        tankTxt = findViewById(R.id.tankTxt)
        spaceJetsTxt = findViewById(R.id.spaceJetsTxt)
        cargoPlanesTxt = findViewById(R.id.cargoPlanesTxt)
        soldiersEt = findViewById(R.id.soldiersEt)
        spacePlanesEt = findViewById(R.id.spacePlanesEt)
        tanksEt = findViewById(R.id.tanksEt)
        spaceJetsEt = findViewById(R.id.spaceJetsEt)
        cargoPlanesEt = findViewById(R.id.cargoPlanesEt)
        attackBtn = findViewById(R.id.attackBtn)




        val sharedSelectedPlanet = getSharedPreferences("SelectedPlanet", AppCompatActivity.MODE_PRIVATE)
        var SelectedPlanet = sharedSelectedPlanet.getInt("SelectedPlanet", 0)




        val sharedNewMessageNotify = getSharedPreferences("NewMessageNotify", AppCompatActivity.MODE_PRIVATE)
        var NewMessageNotify = sharedNewMessageNotify.getBoolean("NewMessageNotify", false)




        selectedPlanetV = SelectedPlanet



        attackBtn.setOnClickListener {

            selectedSoldiersInt = soldiersEt.text.toString().toInt()
            selectedSpacePlanesInt = spacePlanesEt.text.toString().toInt()
            selectedCargoPlanesInt = cargoPlanesEt.text.toString().toInt()
            selectedTanksInt = tanksEt.text.toString().toInt()
            selectedSpaceJetsInt = spaceJetsEt.text.toString().toInt()


            selectedSoldiersDouble = soldiersEt.text.toString().toDouble()
            selectedSpacePlanesDouble = spacePlanesEt.text.toString().toDouble()
            selectedCargoPlanesDouble = cargoPlanesEt.text.toString().toDouble()
            selectedTanksDouble = tanksEt.text.toString().toDouble()
            selectedSpaceJetsDouble = spaceJetsEt.text.toString().toDouble()



            if (selectedSoldiersDouble <= soldierQuantity && selectedSpacePlanesDouble <= airplaneQuantity
                && selectedCargoPlanesDouble <= cargoplaneQuantity && selectedTanksDouble <= tankQuantity
                && selectedSpaceJetsDouble <= airplane2Quantity) {



                soldierQuantity -= selectedSoldiersDouble
                airplaneQuantity -= selectedSpacePlanesDouble
                cargoplaneQuantity -= selectedCargoPlanesDouble
                tankQuantity -= selectedTanksDouble
                airplane2Quantity -= selectedSpaceJetsDouble


                NewMessageNotify = true

                val editNewMessageNotify = sharedNewMessageNotify.edit()
                editNewMessageNotify.putBoolean("NewMessageNotify", NewMessageNotify)
                editNewMessageNotify.commit()


                simulateWar()

                saveChangesInArmyAfterWar()

                saveAlienData()

                val intent = Intent(this, GalaxyViewActivity :: class.java)
                startActivity(intent)



            } else {
                Toast.makeText(this, "You typed more troops than you have!", Toast.LENGTH_SHORT).show()
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





















        database.collection("users").document("User path")
            .collection("Saved data")

            .addSnapshotListener { snapshot, e ->
                if (snapshot != null) {
                    for (document in snapshot.documents) {

                        savedDataOfUser = document.toObject()!!



                        // Sets the saved values from the database to the variables of the activity

                        soldierQuantity = savedDataOfUser.savedSoldierUnitQuantity
                        airplaneQuantity = savedDataOfUser.savedAirplaneUnitQuantity
                        cargoplaneQuantity = savedDataOfUser.savedCargoPlaneQuantity
                        airplane2Quantity = savedDataOfUser.savedAirplane2UnitQuantity
                        tankQuantity = savedDataOfUser.savedTankUnitQuantity
                        sateliteQuantity = savedDataOfUser.savedSateliteUnitQuantity

                        moneyAmount = savedDataOfUser.savedMoneyAmount
                        resoursesAmount = savedDataOfUser.savedResoursesAmount
                        levelInfrastructure = savedDataOfUser.savedLevelInfrastructure
                        levelFactory = savedDataOfUser.savedLevelFactory
                        militaryBaseLevel = savedDataOfUser.savedLevelMilitaryBase
                        levelGeneralDevelopment = savedDataOfUser.savedLevelGeneralDevelopment
                        levelScientificDevelopment = savedDataOfUser.savedLevelScienficResearch
                        levelSpionage = savedDataOfUser.savedLevelSpionage

                        damageToPlayerPlanet = savedDataOfUser.isDamagedAlive
                        colonyId1 = savedDataOfUser.colonyId1
                        colonyResourses1 = savedDataOfUser.colonyResourses1



                        if (militaryBaseLevel < 2) {
                            soldiersTxt.text = "Soldiers Lv1 : $soldierQuantity"
                            spacePlaneTxt.text = "Space planes quantity : $airplaneQuantity"
                            cargoPlanesTxt.text = "Cargo planes quantity : $cargoplaneQuantity"
                        } else if (militaryBaseLevel == 2) {
                            soldiersTxt.text = "Soldiers Lv2 : $soldierQuantity"
                            spacePlaneTxt.text = "Space planes quantity : $airplaneQuantity"
                            cargoPlanesTxt.text = "Cargo planes quantity : $cargoplaneQuantity"
                            tankTxt.text = "Tanks Lv1 quantity : $tankQuantity"
                        } else if (militaryBaseLevel == 3) {
                            soldiersTxt.text = "Soldiers Lv2 : $soldierQuantity"
                            spacePlaneTxt.text = "Space planes quantity : $airplaneQuantity"
                            cargoPlanesTxt.text = "Cargo planes quantity : $cargoplaneQuantity"
                            tankTxt.text = "Tanks Lv1 quantity : $tankQuantity"
                            spaceJetsTxt.text = "Space jets quantity : $airplane2Quantity"
                        } else if (militaryBaseLevel == 4) {
                            soldiersTxt.text = "Soldiers Lv3 : $soldierQuantity"
                            spacePlaneTxt.text = "Space planes quantity : $airplaneQuantity"
                            cargoPlanesTxt.text = "Cargo planes quantity : $cargoplaneQuantity"
                            tankTxt.text = "Tanks Lv2 quantity : $tankQuantity"
                            spaceJetsTxt.text = "Space jets quantity : $airplane2Quantity"
                        } else if (militaryBaseLevel == 5) {
                            soldiersTxt.text = "Soldiers Lv3 : $soldierQuantity"
                            spacePlaneTxt.text = "Space planes quantity : $airplaneQuantity"
                            cargoPlanesTxt.text = "Cargo planes quantity : $cargoplaneQuantity"
                            tankTxt.text = "Tanks Lv2 quantity : $tankQuantity"
                            spaceJetsTxt.text = "Space jets quantity : $airplane2Quantity"
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
                            AlienCiv1MilitaryBase = savedDataOfAliens.militaryBaseAlienRace1
                            AlienCiv1Soldiers = savedDataOfAliens.soldiersAlienRace1
                            AlienCiv1SpacePlanes = savedDataOfAliens.spacePlanesAlienRace1
                            AlienCiv1SpaceJets = savedDataOfAliens.spaceJetsAlienRace1
                            AlienCiv1Tanks = savedDataOfAliens.tanksAlienRace1
                            AlienCiv1NuclearSatelites = savedDataOfAliens.nuclearSatelitesAlienRace1
                            isAlienCiv1Damaged = savedDataOfAliens.isAlienRace1Damaged
                            alienCiv1RelationWithPlayer = savedDataOfAliens.alienRace1RelationWithPlayer





                        // Fetches the data of second civilisation in galaxy

                        AlienCiv2Name = savedDataOfAliens.nameAlienRace2
                        AlienCiv2Picture = savedDataOfAliens.pictureAlienRace2
                        AlienCiv2MilitaryBase = savedDataOfAliens.militaryBaseAlienRace2
                        AlienCiv2Soldiers = savedDataOfAliens.soldiersAlienRace2
                        AlienCiv2SpacePlanes = savedDataOfAliens.spacePlanesAlienRace2
                        AlienCiv2SpaceJets = savedDataOfAliens.spaceJetsAlienRace2
                        AlienCiv2Tanks = savedDataOfAliens.tanksAlienRace2
                        AlienCiv2NuclearSatelites = savedDataOfAliens.nuclearSatelitesAlienRace2
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







                        }

                    }
                }

















    }



    fun simulateWar() {


        // Preparing players army


        if (militaryBaseLevel == 1) {

            soldierUnits.HP = soldierLv1.HP * selectedSoldiersDouble
            soldierUnits.damage = soldierLv1.damage * selectedSoldiersDouble
            soldierUnits.speed = soldierLv1.speed
            soldierUnits.criticalProbability = soldierLv1.criticalProbability

            spacePlaneUnits.HP = spacePlane.HP * selectedSpacePlanesDouble
            spacePlaneUnits.damage = spacePlane.damage * selectedSpacePlanesDouble
            spacePlaneUnits.speed = spacePlane.speed
            spacePlaneUnits.criticalProbability = spacePlane.criticalProbability


        } else if (militaryBaseLevel == 2) {

            soldierUnits.HP = soldierLv2.HP * selectedSoldiersDouble
            soldierUnits.damage = soldierLv2.damage * selectedSoldiersDouble
            soldierUnits.speed = soldierLv2.speed
            soldierUnits.criticalProbability = soldierLv2.criticalProbability

            spacePlaneUnits.HP = spacePlane.HP * selectedSpacePlanesDouble
            spacePlaneUnits.damage = spacePlane.damage * selectedSpacePlanesDouble
            spacePlaneUnits.speed = spacePlane.speed
            spacePlaneUnits.criticalProbability = spacePlane.criticalProbability

            tankUnits.HP = tankLv1.HP * selectedTanksDouble
            tankUnits.damage = tankLv1.damage * selectedTanksDouble
            tankUnits.speed = tankLv1.speed
            tankUnits.criticalProbability = tankLv1.criticalProbability

        } else if (militaryBaseLevel == 3) {

            soldierUnits.HP = soldierLv2.HP * selectedSoldiersDouble
            soldierUnits.damage = soldierLv2.damage * selectedSoldiersDouble
            soldierUnits.speed = soldierLv2.speed
            soldierUnits.criticalProbability = soldierLv2.criticalProbability

            spacePlaneUnits.HP = spacePlane.HP * selectedSpacePlanesDouble
            spacePlaneUnits.damage = spacePlane.damage * selectedSpacePlanesDouble
            spacePlaneUnits.speed = spacePlane.speed
            spacePlaneUnits.criticalProbability = spacePlane.criticalProbability

            tankUnits.HP = tankLv1.HP * selectedTanksDouble
            tankUnits.damage = tankLv1.damage * selectedTanksDouble
            tankUnits.speed = tankLv1.speed
            tankUnits.criticalProbability = tankLv1.criticalProbability

            spaceJetUnits.HP = spaceJet.HP * selectedSpaceJetsDouble
            spaceJetUnits.damage = spaceJet.damage * selectedSpaceJetsDouble
            spaceJetUnits.speed = spaceJet.speed
            spaceJetUnits.criticalProbability = spaceJet.criticalProbability

        } else if (militaryBaseLevel == 4) {

            soldierUnits.HP = soldierLv3.HP * selectedSoldiersDouble
            soldierUnits.damage = soldierLv3.damage * selectedSoldiersDouble
            soldierUnits.speed = soldierLv3.speed
            soldierUnits.criticalProbability = soldierLv3.criticalProbability

            spacePlaneUnits.HP = spacePlane.HP * selectedSpacePlanesDouble
            spacePlaneUnits.damage = spacePlane.damage * selectedSpacePlanesDouble
            spacePlaneUnits.speed = spacePlane.speed
            spacePlaneUnits.criticalProbability = spacePlane.criticalProbability

            tankUnits.HP = tankLv2.HP * selectedTanksDouble
            tankUnits.damage = tankLv2.damage * selectedTanksDouble
            tankUnits.speed = tankLv2.speed
            tankUnits.criticalProbability = tankLv2.criticalProbability


            spaceJetUnits.HP = spaceJet.HP * selectedSpaceJetsDouble
            spaceJetUnits.damage = spaceJet.damage * selectedSpaceJetsDouble
            spaceJetUnits.speed = spaceJet.speed
            spaceJetUnits.criticalProbability = spaceJet.criticalProbability

        } else if (militaryBaseLevel == 5) {

            soldierUnits.HP = soldierLv3.HP * selectedSoldiersDouble
            soldierUnits.damage = soldierLv3.damage * selectedSoldiersDouble
            soldierUnits.speed = soldierLv3.speed
            soldierUnits.criticalProbability = soldierLv3.criticalProbability

            spacePlaneUnits.HP = spacePlane.HP * selectedSpacePlanesDouble
            spacePlaneUnits.damage = spacePlane.damage * selectedSpacePlanesDouble
            spacePlaneUnits.speed = spacePlane.speed
            spacePlaneUnits.criticalProbability = spacePlane.criticalProbability

            tankUnits.HP = tankLv2.HP * selectedTanksDouble
            tankUnits.damage = tankLv2.damage * selectedTanksDouble
            tankUnits.speed = tankLv2.speed
            tankUnits.criticalProbability = tankLv2.criticalProbability


            spaceJetUnits.HP = spaceJet.HP * selectedSpaceJetsDouble
            spaceJetUnits.damage = spaceJet.damage * selectedSpaceJetsDouble
            spaceJetUnits.speed = spaceJet.speed
            spaceJetUnits.criticalProbability = spaceJet.criticalProbability

        }





        // Preparing enemy army


        // Preparing alien 1 army

        if (selectedPlanetV == 1) { //

            // Chosen alien civilisations army is selected by shared pref


            if (AlienCiv1MilitaryBase == 1.0) { //

                alienSoldierUnits.HP = alienSoldierLv1.HP * AlienCiv1Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv1.damage * AlienCiv1Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv1.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv1.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv1SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv1SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability


            } else if (AlienCiv1MilitaryBase == 2.0) { //

                alienSoldierUnits.HP = alienSoldierLv2.HP * AlienCiv1Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv2.damage * AlienCiv1Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv2.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv2.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv1SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv1SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv1.HP * AlienCiv1Tanks!! //
                alienTankUnits.damage = alienTankLv1.damage * AlienCiv1Tanks!! //

                alienTankUnits.speed = alienTankLv1.speed
                alienTankUnits.criticalProbability = alienTankLv1.criticalProbability

            } else if (AlienCiv1MilitaryBase == 3.0) { //

                alienSoldierUnits.HP = alienSoldierLv2.HP * AlienCiv1Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv2.damage * AlienCiv1Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv2.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv2.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv1SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv1SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv1.HP * AlienCiv1Tanks!! //
                alienTankUnits.damage = alienTankLv1.damage * AlienCiv1Tanks!! //

                alienTankUnits.speed = alienTankLv1.speed
                alienTankUnits.criticalProbability = alienTankLv1.criticalProbability

                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv1SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv1SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability

            } else if (AlienCiv1MilitaryBase == 4.0) { //

                alienSoldierUnits.HP = alienSoldierLv3.HP * AlienCiv1Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv3.damage * AlienCiv1Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv3.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv3.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv1SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv1SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv2.HP * AlienCiv1Tanks!! //
                alienTankUnits.damage = alienTankLv2.damage * AlienCiv1Tanks!! //

                alienTankUnits.speed = alienTankLv2.speed
                alienTankUnits.criticalProbability = alienTankLv2.criticalProbability


                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv1SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv1SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability

            } else if (AlienCiv1MilitaryBase == 5.0) { //

                alienSoldierUnits.HP = alienSoldierLv3.HP * AlienCiv1Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv3.damage * AlienCiv1Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv3.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv3.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv1SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv1SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv2.HP * AlienCiv1Tanks!! //
                alienTankUnits.damage = alienTankLv2.damage * AlienCiv1Tanks!! //

                alienTankUnits.speed = alienTankLv2.speed
                alienTankUnits.criticalProbability = alienTankLv2.criticalProbability


                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv1SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv1SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability
            }


            alienMilitaryBase = AlienCiv1MilitaryBase //
            levelDamageToAlienPlanet = isAlienCiv1Damaged!! //
            alienRelationship = alienCiv1RelationWithPlayer!! //


        }







        // Preparing alien 2 army

        if (selectedPlanetV == 2) { //

            // Chosen alien civilisations army is selected by shared pref


            if (AlienCiv2MilitaryBase == 1.0) { //

                alienSoldierUnits.HP = alienSoldierLv1.HP * AlienCiv2Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv1.damage * AlienCiv2Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv1.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv1.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv2SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv2SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability


            } else if (AlienCiv2MilitaryBase == 2.0) { //

                alienSoldierUnits.HP = alienSoldierLv2.HP * AlienCiv2Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv2.damage * AlienCiv2Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv2.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv2.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv2SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv2SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv1.HP * AlienCiv2Tanks!! //
                alienTankUnits.damage = alienTankLv1.damage * AlienCiv2Tanks!! //

                alienTankUnits.speed = alienTankLv1.speed
                alienTankUnits.criticalProbability = alienTankLv1.criticalProbability

            } else if (AlienCiv2MilitaryBase == 3.0) { //

                alienSoldierUnits.HP = alienSoldierLv2.HP * AlienCiv2Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv2.damage * AlienCiv2Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv2.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv2.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv2SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv2SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv1.HP * AlienCiv2Tanks!! //
                alienTankUnits.damage = alienTankLv1.damage * AlienCiv2Tanks!! //

                alienTankUnits.speed = alienTankLv1.speed
                alienTankUnits.criticalProbability = alienTankLv1.criticalProbability

                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv2SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv2SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability

            } else if (AlienCiv2MilitaryBase == 4.0) { //

                alienSoldierUnits.HP = alienSoldierLv3.HP * AlienCiv2Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv3.damage * AlienCiv2Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv3.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv3.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv2SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv2SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv2.HP * AlienCiv2Tanks!! //
                alienTankUnits.damage = alienTankLv2.damage * AlienCiv2Tanks!! //

                alienTankUnits.speed = alienTankLv2.speed
                alienTankUnits.criticalProbability = alienTankLv2.criticalProbability


                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv2SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv2SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability

            } else if (AlienCiv2MilitaryBase == 5.0) { //

                alienSoldierUnits.HP = alienSoldierLv3.HP * AlienCiv2Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv3.damage * AlienCiv2Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv3.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv3.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv2SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv2SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv2.HP * AlienCiv2Tanks!! //
                alienTankUnits.damage = alienTankLv2.damage * AlienCiv2Tanks!! //

                alienTankUnits.speed = alienTankLv2.speed
                alienTankUnits.criticalProbability = alienTankLv2.criticalProbability


                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv2SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv2SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability
            }


            alienMilitaryBase = AlienCiv2MilitaryBase //
            levelDamageToAlienPlanet = isAlienCiv2Damaged!! //
            alienRelationship = alienCiv1RelationWithPlayer!! //


        }



        // Alien 3



        if (selectedPlanetV == 3) { //

            // Chosen alien civilisations army is selected by shared pref


            if (AlienCiv3MilitaryBase == 1.0) { //

                alienSoldierUnits.HP = alienSoldierLv1.HP * AlienCiv3Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv1.damage * AlienCiv3Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv1.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv1.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv3SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv3SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability


            } else if (AlienCiv3MilitaryBase == 2.0) { //

                alienSoldierUnits.HP = alienSoldierLv2.HP * AlienCiv3Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv2.damage * AlienCiv3Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv2.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv2.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv3SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv3SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv1.HP * AlienCiv3Tanks!! //
                alienTankUnits.damage = alienTankLv1.damage * AlienCiv3Tanks!! //

                alienTankUnits.speed = alienTankLv1.speed
                alienTankUnits.criticalProbability = alienTankLv1.criticalProbability

            } else if (AlienCiv3MilitaryBase == 3.0) { //

                alienSoldierUnits.HP = alienSoldierLv2.HP * AlienCiv3Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv2.damage * AlienCiv3Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv2.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv2.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv3SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv3SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv1.HP * AlienCiv3Tanks!! //
                alienTankUnits.damage = alienTankLv1.damage * AlienCiv3Tanks!! //

                alienTankUnits.speed = alienTankLv1.speed
                alienTankUnits.criticalProbability = alienTankLv1.criticalProbability

                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv3SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv3SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability

            } else if (AlienCiv3MilitaryBase == 4.0) { //

                alienSoldierUnits.HP = alienSoldierLv3.HP * AlienCiv3Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv3.damage * AlienCiv3Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv3.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv3.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv3SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv3SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv2.HP * AlienCiv3Tanks!! //
                alienTankUnits.damage = alienTankLv2.damage * AlienCiv3Tanks!! //

                alienTankUnits.speed = alienTankLv2.speed
                alienTankUnits.criticalProbability = alienTankLv2.criticalProbability


                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv3SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv3SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability

            } else if (AlienCiv3MilitaryBase == 5.0) { //

                alienSoldierUnits.HP = alienSoldierLv3.HP * AlienCiv3Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv3.damage * AlienCiv3Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv3.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv3.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv3SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv3SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv2.HP * AlienCiv3Tanks!! //
                alienTankUnits.damage = alienTankLv2.damage * AlienCiv3Tanks!! //

                alienTankUnits.speed = alienTankLv2.speed
                alienTankUnits.criticalProbability = alienTankLv2.criticalProbability


                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv3SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv3SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability
            }


            alienMilitaryBase = AlienCiv3MilitaryBase //
            levelDamageToAlienPlanet = isAlienCiv3Damaged!! //
            alienRelationship = alienCiv3RelationWithPlayer!! //


        }






        // Alien 4



        if (selectedPlanetV == 4) { //

            // Chosen alien civilisations army is selected by shared pref


            if (AlienCiv4MilitaryBase == 1.0) { //

                alienSoldierUnits.HP = alienSoldierLv1.HP * AlienCiv4Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv1.damage * AlienCiv4Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv1.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv1.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv4SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv4SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability


            } else if (AlienCiv4MilitaryBase == 2.0) { //

                alienSoldierUnits.HP = alienSoldierLv2.HP * AlienCiv4Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv2.damage * AlienCiv4Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv2.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv2.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv4SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv4SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv1.HP * AlienCiv4Tanks!! //
                alienTankUnits.damage = alienTankLv1.damage * AlienCiv4Tanks!! //

                alienTankUnits.speed = alienTankLv1.speed
                alienTankUnits.criticalProbability = alienTankLv1.criticalProbability

            } else if (AlienCiv4MilitaryBase == 3.0) { //

                alienSoldierUnits.HP = alienSoldierLv2.HP * AlienCiv4Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv2.damage * AlienCiv4Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv2.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv2.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv4SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv4SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv1.HP * AlienCiv4Tanks!! //
                alienTankUnits.damage = alienTankLv1.damage * AlienCiv4Tanks!! //

                alienTankUnits.speed = alienTankLv1.speed
                alienTankUnits.criticalProbability = alienTankLv1.criticalProbability

                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv4SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv4SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability

            } else if (AlienCiv4MilitaryBase == 4.0) { //

                alienSoldierUnits.HP = alienSoldierLv3.HP * AlienCiv4Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv3.damage * AlienCiv4Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv3.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv3.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv4SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv4SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv2.HP * AlienCiv4Tanks!! //
                alienTankUnits.damage = alienTankLv2.damage * AlienCiv4Tanks!! //

                alienTankUnits.speed = alienTankLv2.speed
                alienTankUnits.criticalProbability = alienTankLv2.criticalProbability


                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv4SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv4SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability

            } else if (AlienCiv4MilitaryBase == 5.0) { //

                alienSoldierUnits.HP = alienSoldierLv3.HP * AlienCiv4Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv3.damage * AlienCiv4Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv3.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv3.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv4SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv4SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv2.HP * AlienCiv4Tanks!! //
                alienTankUnits.damage = alienTankLv2.damage * AlienCiv4Tanks!! //

                alienTankUnits.speed = alienTankLv2.speed
                alienTankUnits.criticalProbability = alienTankLv2.criticalProbability


                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv4SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv4SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability
            }


            alienMilitaryBase = AlienCiv4MilitaryBase //
            levelDamageToAlienPlanet = isAlienCiv4Damaged!! //
            alienRelationship = alienCiv4RelationWithPlayer!! //


        }







// Alien 5



        if (selectedPlanetV == 5) { //

            // Chosen alien civilisations army is selected by shared pref


            if (AlienCiv5MilitaryBase == 1.0) { //

                alienSoldierUnits.HP = alienSoldierLv1.HP * AlienCiv5Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv1.damage * AlienCiv5Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv1.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv1.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv5SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv5SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability


            } else if (AlienCiv5MilitaryBase == 2.0) { //

                alienSoldierUnits.HP = alienSoldierLv2.HP * AlienCiv5Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv2.damage * AlienCiv5Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv2.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv2.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv5SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv5SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv1.HP * AlienCiv5Tanks!! //
                alienTankUnits.damage = alienTankLv1.damage * AlienCiv5Tanks!! //

                alienTankUnits.speed = alienTankLv1.speed
                alienTankUnits.criticalProbability = alienTankLv1.criticalProbability

            } else if (AlienCiv5MilitaryBase == 3.0) { //

                alienSoldierUnits.HP = alienSoldierLv2.HP * AlienCiv5Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv2.damage * AlienCiv5Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv2.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv2.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv5SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv5SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv1.HP * AlienCiv5Tanks!! //
                alienTankUnits.damage = alienTankLv1.damage * AlienCiv5Tanks!! //

                alienTankUnits.speed = alienTankLv1.speed
                alienTankUnits.criticalProbability = alienTankLv1.criticalProbability

                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv5SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv5SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability

            } else if (AlienCiv5MilitaryBase == 4.0) { //

                alienSoldierUnits.HP = alienSoldierLv3.HP * AlienCiv5Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv3.damage * AlienCiv5Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv3.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv3.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv5SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv5SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv2.HP * AlienCiv5Tanks!! //
                alienTankUnits.damage = alienTankLv2.damage * AlienCiv5Tanks!! //

                alienTankUnits.speed = alienTankLv2.speed
                alienTankUnits.criticalProbability = alienTankLv2.criticalProbability


                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv5SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv5SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability

            } else if (AlienCiv5MilitaryBase == 5.0) { //

                alienSoldierUnits.HP = alienSoldierLv3.HP * AlienCiv5Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv3.damage * AlienCiv5Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv3.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv3.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv5SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv5SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv2.HP * AlienCiv5Tanks!! //
                alienTankUnits.damage = alienTankLv2.damage * AlienCiv5Tanks!! //

                alienTankUnits.speed = alienTankLv2.speed
                alienTankUnits.criticalProbability = alienTankLv2.criticalProbability


                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv5SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv5SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability
            }


            alienMilitaryBase = AlienCiv5MilitaryBase //
            levelDamageToAlienPlanet = isAlienCiv5Damaged!! //
            alienRelationship = alienCiv5RelationWithPlayer!! //


        }




// Alien 6



        if (selectedPlanetV == 6) { //

            // Chosen alien civilisations army is selected by shared pref


            if (AlienCiv6MilitaryBase == 1.0) { //

                alienSoldierUnits.HP = alienSoldierLv1.HP * AlienCiv6Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv1.damage * AlienCiv6Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv1.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv1.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv6SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv6SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability


            } else if (AlienCiv6MilitaryBase == 2.0) { //

                alienSoldierUnits.HP = alienSoldierLv2.HP * AlienCiv6Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv2.damage * AlienCiv6Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv2.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv2.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv6SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv6SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv1.HP * AlienCiv6Tanks!! //
                alienTankUnits.damage = alienTankLv1.damage * AlienCiv6Tanks!! //

                alienTankUnits.speed = alienTankLv1.speed
                alienTankUnits.criticalProbability = alienTankLv1.criticalProbability

            } else if (AlienCiv6MilitaryBase == 3.0) { //

                alienSoldierUnits.HP = alienSoldierLv2.HP * AlienCiv6Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv2.damage * AlienCiv6Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv2.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv2.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv6SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv6SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv1.HP * AlienCiv6Tanks!! //
                alienTankUnits.damage = alienTankLv1.damage * AlienCiv6Tanks!! //

                alienTankUnits.speed = alienTankLv1.speed
                alienTankUnits.criticalProbability = alienTankLv1.criticalProbability

                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv6SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv6SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability

            } else if (AlienCiv6MilitaryBase == 4.0) { //

                alienSoldierUnits.HP = alienSoldierLv3.HP * AlienCiv6Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv3.damage * AlienCiv6Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv3.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv3.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv6SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv6SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv2.HP * AlienCiv6Tanks!! //
                alienTankUnits.damage = alienTankLv2.damage * AlienCiv6Tanks!! //

                alienTankUnits.speed = alienTankLv2.speed
                alienTankUnits.criticalProbability = alienTankLv2.criticalProbability


                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv6SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv6SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability

            } else if (AlienCiv6MilitaryBase == 5.0) { //

                alienSoldierUnits.HP = alienSoldierLv3.HP * AlienCiv6Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv3.damage * AlienCiv6Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv3.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv3.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv6SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv6SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv2.HP * AlienCiv6Tanks!! //
                alienTankUnits.damage = alienTankLv2.damage * AlienCiv6Tanks!! //

                alienTankUnits.speed = alienTankLv2.speed
                alienTankUnits.criticalProbability = alienTankLv2.criticalProbability


                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv6SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv6SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability
            }


            alienMilitaryBase = AlienCiv6MilitaryBase //
            levelDamageToAlienPlanet = isAlienCiv6Damaged!! //
            alienRelationship = alienCiv6RelationWithPlayer!! //


        }




// Alien 7



        if (selectedPlanetV == 7) { //

            // Chosen alien civilisations army is selected by shared pref


            if (AlienCiv7MilitaryBase == 1.0) { //

                alienSoldierUnits.HP = alienSoldierLv1.HP * AlienCiv7Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv1.damage * AlienCiv7Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv1.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv1.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv7SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv7SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability


            } else if (AlienCiv7MilitaryBase == 2.0) { //

                alienSoldierUnits.HP = alienSoldierLv2.HP * AlienCiv7Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv2.damage * AlienCiv7Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv2.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv2.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv7SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv7SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv1.HP * AlienCiv7Tanks!! //
                alienTankUnits.damage = alienTankLv1.damage * AlienCiv7Tanks!! //

                alienTankUnits.speed = alienTankLv1.speed
                alienTankUnits.criticalProbability = alienTankLv1.criticalProbability

            } else if (AlienCiv7MilitaryBase == 3.0) { //

                alienSoldierUnits.HP = alienSoldierLv2.HP * AlienCiv7Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv2.damage * AlienCiv7Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv2.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv2.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv7SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv7SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv1.HP * AlienCiv7Tanks!! //
                alienTankUnits.damage = alienTankLv1.damage * AlienCiv7Tanks!! //

                alienTankUnits.speed = alienTankLv1.speed
                alienTankUnits.criticalProbability = alienTankLv1.criticalProbability

                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv7SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv7SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability

            } else if (AlienCiv7MilitaryBase == 4.0) { //

                alienSoldierUnits.HP = alienSoldierLv3.HP * AlienCiv7Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv3.damage * AlienCiv7Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv3.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv3.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv7SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv7SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv2.HP * AlienCiv7Tanks!! //
                alienTankUnits.damage = alienTankLv2.damage * AlienCiv7Tanks!! //

                alienTankUnits.speed = alienTankLv2.speed
                alienTankUnits.criticalProbability = alienTankLv2.criticalProbability


                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv7SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv7SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability

            } else if (AlienCiv7MilitaryBase == 5.0) { //

                alienSoldierUnits.HP = alienSoldierLv3.HP * AlienCiv7Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv3.damage * AlienCiv7Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv3.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv3.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv7SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv7SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv2.HP * AlienCiv7Tanks!! //
                alienTankUnits.damage = alienTankLv2.damage * AlienCiv7Tanks!! //

                alienTankUnits.speed = alienTankLv2.speed
                alienTankUnits.criticalProbability = alienTankLv2.criticalProbability


                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv7SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv7SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability
            }


            alienMilitaryBase = AlienCiv7MilitaryBase //
            levelDamageToAlienPlanet = isAlienCiv7Damaged!! //
            alienRelationship = alienCiv7RelationWithPlayer!! //


        }




// Alien 8



        if (selectedPlanetV == 8) { //

            // Chosen alien civilisations army is selected by shared pref


            if (AlienCiv8MilitaryBase == 1.0) { //

                alienSoldierUnits.HP = alienSoldierLv1.HP * AlienCiv8Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv1.damage * AlienCiv8Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv1.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv1.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv8SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv8SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability


            } else if (AlienCiv8MilitaryBase == 2.0) { //

                alienSoldierUnits.HP = alienSoldierLv2.HP * AlienCiv8Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv2.damage * AlienCiv8Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv2.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv2.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv8SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv8SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv1.HP * AlienCiv8Tanks!! //
                alienTankUnits.damage = alienTankLv1.damage * AlienCiv8Tanks!! //

                alienTankUnits.speed = alienTankLv1.speed
                alienTankUnits.criticalProbability = alienTankLv1.criticalProbability

            } else if (AlienCiv8MilitaryBase == 3.0) { //

                alienSoldierUnits.HP = alienSoldierLv2.HP * AlienCiv8Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv2.damage * AlienCiv8Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv2.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv2.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv8SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv8SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv1.HP * AlienCiv8Tanks!! //
                alienTankUnits.damage = alienTankLv1.damage * AlienCiv8Tanks!! //

                alienTankUnits.speed = alienTankLv1.speed
                alienTankUnits.criticalProbability = alienTankLv1.criticalProbability

                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv8SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv8SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability

            } else if (AlienCiv8MilitaryBase == 4.0) { //

                alienSoldierUnits.HP = alienSoldierLv3.HP * AlienCiv8Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv3.damage * AlienCiv8Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv3.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv3.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv8SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv8SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv2.HP * AlienCiv8Tanks!! //
                alienTankUnits.damage = alienTankLv2.damage * AlienCiv8Tanks!! //

                alienTankUnits.speed = alienTankLv2.speed
                alienTankUnits.criticalProbability = alienTankLv2.criticalProbability


                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv8SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv8SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability

            } else if (AlienCiv8MilitaryBase == 5.0) { //

                alienSoldierUnits.HP = alienSoldierLv3.HP * AlienCiv8Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv3.damage * AlienCiv8Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv3.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv3.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv8SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv8SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv2.HP * AlienCiv8Tanks!! //
                alienTankUnits.damage = alienTankLv2.damage * AlienCiv8Tanks!! //

                alienTankUnits.speed = alienTankLv2.speed
                alienTankUnits.criticalProbability = alienTankLv2.criticalProbability


                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv8SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv8SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability
            }


            alienMilitaryBase = AlienCiv8MilitaryBase //
            levelDamageToAlienPlanet = isAlienCiv8Damaged!! //
            alienRelationship = alienCiv8RelationWithPlayer!! //


        }




// Alien 9



        if (selectedPlanetV == 9) { //

            // Chosen alien civilisations army is selected by shared pref


            if (AlienCiv9MilitaryBase == 1.0) { //

                alienSoldierUnits.HP = alienSoldierLv1.HP * AlienCiv9Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv1.damage * AlienCiv9Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv1.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv1.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv9SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv9SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability


            } else if (AlienCiv9MilitaryBase == 2.0) { //

                alienSoldierUnits.HP = alienSoldierLv2.HP * AlienCiv9Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv2.damage * AlienCiv9Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv2.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv2.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv9SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv9SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv1.HP * AlienCiv9Tanks!! //
                alienTankUnits.damage = alienTankLv1.damage * AlienCiv9Tanks!! //

                alienTankUnits.speed = alienTankLv1.speed
                alienTankUnits.criticalProbability = alienTankLv1.criticalProbability

            } else if (AlienCiv9MilitaryBase == 3.0) { //

                alienSoldierUnits.HP = alienSoldierLv2.HP * AlienCiv9Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv2.damage * AlienCiv9Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv2.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv2.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv9SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv9SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv1.HP * AlienCiv9Tanks!! //
                alienTankUnits.damage = alienTankLv1.damage * AlienCiv9Tanks!! //

                alienTankUnits.speed = alienTankLv1.speed
                alienTankUnits.criticalProbability = alienTankLv1.criticalProbability

                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv9SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv9SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability

            } else if (AlienCiv9MilitaryBase == 4.0) { //

                alienSoldierUnits.HP = alienSoldierLv3.HP * AlienCiv9Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv3.damage * AlienCiv9Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv3.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv3.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv9SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv9SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv2.HP * AlienCiv9Tanks!! //
                alienTankUnits.damage = alienTankLv2.damage * AlienCiv9Tanks!! //

                alienTankUnits.speed = alienTankLv2.speed
                alienTankUnits.criticalProbability = alienTankLv2.criticalProbability


                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv9SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv9SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability

            } else if (AlienCiv9MilitaryBase == 5.0) { //

                alienSoldierUnits.HP = alienSoldierLv3.HP * AlienCiv9Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv3.damage * AlienCiv9Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv3.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv3.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv9SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv9SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv2.HP * AlienCiv9Tanks!! //
                alienTankUnits.damage = alienTankLv2.damage * AlienCiv9Tanks!! //

                alienTankUnits.speed = alienTankLv2.speed
                alienTankUnits.criticalProbability = alienTankLv2.criticalProbability


                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv9SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv9SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability
            }


            alienMilitaryBase = AlienCiv9MilitaryBase //
            levelDamageToAlienPlanet = isAlienCiv9Damaged!! //
            alienRelationship = alienCiv9RelationWithPlayer!! //


        }






        // Alien 10



        if (selectedPlanetV == 10) { //

            // Chosen alien civilisations army is selected by shared pref


            if (AlienCiv10MilitaryBase == 1.0) { //

                alienSoldierUnits.HP = alienSoldierLv1.HP * AlienCiv10Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv1.damage * AlienCiv10Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv1.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv1.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv10SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv10SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability


            } else if (AlienCiv10MilitaryBase == 2.0) { //

                alienSoldierUnits.HP = alienSoldierLv2.HP * AlienCiv10Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv2.damage * AlienCiv10Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv2.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv2.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv10SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv10SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv1.HP * AlienCiv10Tanks!! //
                alienTankUnits.damage = alienTankLv1.damage * AlienCiv10Tanks!! //

                alienTankUnits.speed = alienTankLv1.speed
                alienTankUnits.criticalProbability = alienTankLv1.criticalProbability

            } else if (AlienCiv10MilitaryBase == 3.0) { //

                alienSoldierUnits.HP = alienSoldierLv2.HP * AlienCiv10Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv2.damage * AlienCiv10Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv2.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv2.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv10SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv10SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv1.HP * AlienCiv10Tanks!! //
                alienTankUnits.damage = alienTankLv1.damage * AlienCiv10Tanks!! //

                alienTankUnits.speed = alienTankLv1.speed
                alienTankUnits.criticalProbability = alienTankLv1.criticalProbability

                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv10SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv10SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability

            } else if (AlienCiv10MilitaryBase == 4.0) { //

                alienSoldierUnits.HP = alienSoldierLv3.HP * AlienCiv10Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv3.damage * AlienCiv10Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv3.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv3.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv10SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv10SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv2.HP * AlienCiv10Tanks!! //
                alienTankUnits.damage = alienTankLv2.damage * AlienCiv10Tanks!! //

                alienTankUnits.speed = alienTankLv2.speed
                alienTankUnits.criticalProbability = alienTankLv2.criticalProbability


                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv10SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv10SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability

            } else if (AlienCiv10MilitaryBase == 5.0) { //

                alienSoldierUnits.HP = alienSoldierLv3.HP * AlienCiv10Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv3.damage * AlienCiv10Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv3.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv3.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv10SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv10SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv2.HP * AlienCiv10Tanks!! //
                alienTankUnits.damage = alienTankLv2.damage * AlienCiv10Tanks!! //

                alienTankUnits.speed = alienTankLv2.speed
                alienTankUnits.criticalProbability = alienTankLv2.criticalProbability


                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv10SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv10SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability
            }


            alienMilitaryBase = AlienCiv10MilitaryBase //
            levelDamageToAlienPlanet = isAlienCiv10Damaged!! //
            alienRelationship = alienCiv10RelationWithPlayer!! //


        }






// Alien 11



        if (selectedPlanetV == 999) { //

            // Chosen alien civilisations army is selected by shared pref


            if (AlienCiv11MilitaryBase == 1.0) { //

                alienSoldierUnits.HP = alienSoldierLv1.HP * AlienCiv11Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv1.damage * AlienCiv11Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv1.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv1.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv11SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv11SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability


            } else if (AlienCiv11MilitaryBase == 2.0) { //

                alienSoldierUnits.HP = alienSoldierLv2.HP * AlienCiv11Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv2.damage * AlienCiv11Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv2.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv2.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv11SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv11SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv1.HP * AlienCiv11Tanks!! //
                alienTankUnits.damage = alienTankLv1.damage * AlienCiv11Tanks!! //

                alienTankUnits.speed = alienTankLv1.speed
                alienTankUnits.criticalProbability = alienTankLv1.criticalProbability

            } else if (AlienCiv11MilitaryBase == 3.0) { //

                alienSoldierUnits.HP = alienSoldierLv2.HP * AlienCiv11Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv2.damage * AlienCiv11Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv2.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv2.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv11SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv11SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv1.HP * AlienCiv11Tanks!! //
                alienTankUnits.damage = alienTankLv1.damage * AlienCiv11Tanks!! //

                alienTankUnits.speed = alienTankLv1.speed
                alienTankUnits.criticalProbability = alienTankLv1.criticalProbability

                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv11SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv11SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability

            } else if (AlienCiv11MilitaryBase == 4.0) { //

                alienSoldierUnits.HP = alienSoldierLv3.HP * AlienCiv11Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv3.damage * AlienCiv11Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv3.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv3.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv11SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv11SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv2.HP * AlienCiv11Tanks!! //
                alienTankUnits.damage = alienTankLv2.damage * AlienCiv11Tanks!! //

                alienTankUnits.speed = alienTankLv2.speed
                alienTankUnits.criticalProbability = alienTankLv2.criticalProbability


                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv11SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv11SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability

            } else if (AlienCiv11MilitaryBase == 5.0) { //

                alienSoldierUnits.HP = alienSoldierLv3.HP * AlienCiv11Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv3.damage * AlienCiv11Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv3.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv3.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv11SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv11SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv2.HP * AlienCiv11Tanks!! //
                alienTankUnits.damage = alienTankLv2.damage * AlienCiv11Tanks!! //

                alienTankUnits.speed = alienTankLv2.speed
                alienTankUnits.criticalProbability = alienTankLv2.criticalProbability


                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv11SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv11SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability
            }


            alienMilitaryBase = AlienCiv11MilitaryBase //
            levelDamageToAlienPlanet = isAlienCiv11Damaged!! //
            alienRelationship = alienCiv11RelationWithPlayer!! //


        }



// Alien 12



        if (selectedPlanetV == 101010) { //

            // Chosen alien civilisations army is selected by shared pref


            if (AlienCiv12MilitaryBase == 1.0) { //

                alienSoldierUnits.HP = alienSoldierLv1.HP * AlienCiv12Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv1.damage * AlienCiv12Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv1.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv1.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv12SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv12SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability


            } else if (AlienCiv12MilitaryBase == 2.0) { //

                alienSoldierUnits.HP = alienSoldierLv2.HP * AlienCiv12Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv2.damage * AlienCiv12Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv2.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv2.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv12SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv12SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv1.HP * AlienCiv12Tanks!! //
                alienTankUnits.damage = alienTankLv1.damage * AlienCiv12Tanks!! //

                alienTankUnits.speed = alienTankLv1.speed
                alienTankUnits.criticalProbability = alienTankLv1.criticalProbability

            } else if (AlienCiv12MilitaryBase == 3.0) { //

                alienSoldierUnits.HP = alienSoldierLv2.HP * AlienCiv12Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv2.damage * AlienCiv12Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv2.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv2.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv12SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv12SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv1.HP * AlienCiv12Tanks!! //
                alienTankUnits.damage = alienTankLv1.damage * AlienCiv12Tanks!! //

                alienTankUnits.speed = alienTankLv1.speed
                alienTankUnits.criticalProbability = alienTankLv1.criticalProbability

                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv12SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv12SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability

            } else if (AlienCiv12MilitaryBase == 4.0) { //

                alienSoldierUnits.HP = alienSoldierLv3.HP * AlienCiv12Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv3.damage * AlienCiv12Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv3.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv3.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv12SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv12SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv2.HP * AlienCiv12Tanks!! //
                alienTankUnits.damage = alienTankLv2.damage * AlienCiv12Tanks!! //

                alienTankUnits.speed = alienTankLv2.speed
                alienTankUnits.criticalProbability = alienTankLv2.criticalProbability


                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv12SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv12SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability

            } else if (AlienCiv12MilitaryBase == 5.0) { //

                alienSoldierUnits.HP = alienSoldierLv3.HP * AlienCiv12Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv3.damage * AlienCiv12Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv3.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv3.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv12SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv12SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv2.HP * AlienCiv12Tanks!! //
                alienTankUnits.damage = alienTankLv2.damage * AlienCiv12Tanks!! //

                alienTankUnits.speed = alienTankLv2.speed
                alienTankUnits.criticalProbability = alienTankLv2.criticalProbability


                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv12SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv12SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability
            }


            alienMilitaryBase = AlienCiv12MilitaryBase //
            levelDamageToAlienPlanet = isAlienCiv12Damaged!! //
            alienRelationship = alienCiv12RelationWithPlayer!! //


        }






// Alien 13



        if (selectedPlanetV == 10101010) { //

            // Chosen alien civilisations army is selected by shared pref


            if (AlienCiv13MilitaryBase == 1.0) { //

                alienSoldierUnits.HP = alienSoldierLv1.HP * AlienCiv13Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv1.damage * AlienCiv13Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv1.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv1.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv13SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv13SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability


            } else if (AlienCiv13MilitaryBase == 2.0) { //

                alienSoldierUnits.HP = alienSoldierLv2.HP * AlienCiv13Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv2.damage * AlienCiv13Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv2.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv2.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv13SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv13SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv1.HP * AlienCiv13Tanks!! //
                alienTankUnits.damage = alienTankLv1.damage * AlienCiv13Tanks!! //

                alienTankUnits.speed = alienTankLv1.speed
                alienTankUnits.criticalProbability = alienTankLv1.criticalProbability

            } else if (AlienCiv13MilitaryBase == 3.0) { //

                alienSoldierUnits.HP = alienSoldierLv2.HP * AlienCiv13Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv2.damage * AlienCiv13Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv2.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv2.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv13SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv13SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv1.HP * AlienCiv13Tanks!! //
                alienTankUnits.damage = alienTankLv1.damage * AlienCiv13Tanks!! //

                alienTankUnits.speed = alienTankLv1.speed
                alienTankUnits.criticalProbability = alienTankLv1.criticalProbability

                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv13SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv13SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability

            } else if (AlienCiv13MilitaryBase == 4.0) { //

                alienSoldierUnits.HP = alienSoldierLv3.HP * AlienCiv13Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv3.damage * AlienCiv13Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv3.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv3.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv13SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv13SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv2.HP * AlienCiv13Tanks!! //
                alienTankUnits.damage = alienTankLv2.damage * AlienCiv13Tanks!! //

                alienTankUnits.speed = alienTankLv2.speed
                alienTankUnits.criticalProbability = alienTankLv2.criticalProbability


                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv13SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv13SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability

            } else if (AlienCiv13MilitaryBase == 5.0) { //

                alienSoldierUnits.HP = alienSoldierLv3.HP * AlienCiv13Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv3.damage * AlienCiv13Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv3.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv3.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv13SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv13SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv2.HP * AlienCiv13Tanks!! //
                alienTankUnits.damage = alienTankLv2.damage * AlienCiv13Tanks!! //

                alienTankUnits.speed = alienTankLv2.speed
                alienTankUnits.criticalProbability = alienTankLv2.criticalProbability


                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv13SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv13SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability
            }


            alienMilitaryBase = AlienCiv13MilitaryBase //
            levelDamageToAlienPlanet = isAlienCiv13Damaged!! //
            alienRelationship = alienCiv13RelationWithPlayer!! //


        }





// Alien 14



        if (selectedPlanetV == 14) { //

            // Chosen alien civilisations army is selected by shared pref


            if (AlienCiv14MilitaryBase == 1.0) { //

                alienSoldierUnits.HP = alienSoldierLv1.HP * AlienCiv14Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv1.damage * AlienCiv14Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv1.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv1.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv14SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv14SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability


            } else if (AlienCiv14MilitaryBase == 2.0) { //

                alienSoldierUnits.HP = alienSoldierLv2.HP * AlienCiv14Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv2.damage * AlienCiv14Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv2.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv2.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv14SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv14SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv1.HP * AlienCiv14Tanks!! //
                alienTankUnits.damage = alienTankLv1.damage * AlienCiv14Tanks!! //

                alienTankUnits.speed = alienTankLv1.speed
                alienTankUnits.criticalProbability = alienTankLv1.criticalProbability

            } else if (AlienCiv14MilitaryBase == 3.0) { //

                alienSoldierUnits.HP = alienSoldierLv2.HP * AlienCiv14Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv2.damage * AlienCiv14Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv2.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv2.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv14SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv14SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv1.HP * AlienCiv14Tanks!! //
                alienTankUnits.damage = alienTankLv1.damage * AlienCiv14Tanks!! //

                alienTankUnits.speed = alienTankLv1.speed
                alienTankUnits.criticalProbability = alienTankLv1.criticalProbability

                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv14SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv14SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability

            } else if (AlienCiv14MilitaryBase == 4.0) { //

                alienSoldierUnits.HP = alienSoldierLv3.HP * AlienCiv14Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv3.damage * AlienCiv14Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv3.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv3.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv14SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv14SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv2.HP * AlienCiv14Tanks!! //
                alienTankUnits.damage = alienTankLv2.damage * AlienCiv14Tanks!! //

                alienTankUnits.speed = alienTankLv2.speed
                alienTankUnits.criticalProbability = alienTankLv2.criticalProbability


                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv14SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv14SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability

            } else if (AlienCiv14MilitaryBase == 5.0) { //

                alienSoldierUnits.HP = alienSoldierLv3.HP * AlienCiv14Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv3.damage * AlienCiv14Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv3.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv3.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv14SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv14SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv2.HP * AlienCiv14Tanks!! //
                alienTankUnits.damage = alienTankLv2.damage * AlienCiv14Tanks!! //

                alienTankUnits.speed = alienTankLv2.speed
                alienTankUnits.criticalProbability = alienTankLv2.criticalProbability


                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv14SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv14SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability
            }


            alienMilitaryBase = AlienCiv14MilitaryBase //
            levelDamageToAlienPlanet = isAlienCiv14Damaged!! //
            alienRelationship = alienCiv14RelationWithPlayer!! //


        }








        // Alien 15



        if (selectedPlanetV == 15) { //

            // Chosen alien civilisations army is selected by shared pref


            if (AlienCiv15MilitaryBase == 1.0) { //

                alienSoldierUnits.HP = alienSoldierLv1.HP * AlienCiv15Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv1.damage * AlienCiv15Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv1.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv1.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv15SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv15SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability


            } else if (AlienCiv15MilitaryBase == 2.0) { //

                alienSoldierUnits.HP = alienSoldierLv2.HP * AlienCiv15Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv2.damage * AlienCiv15Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv2.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv2.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv15SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv15SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv1.HP * AlienCiv15Tanks!! //
                alienTankUnits.damage = alienTankLv1.damage * AlienCiv15Tanks!! //

                alienTankUnits.speed = alienTankLv1.speed
                alienTankUnits.criticalProbability = alienTankLv1.criticalProbability

            } else if (AlienCiv15MilitaryBase == 3.0) { //

                alienSoldierUnits.HP = alienSoldierLv2.HP * AlienCiv15Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv2.damage * AlienCiv15Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv2.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv2.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv15SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv15SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv1.HP * AlienCiv15Tanks!! //
                alienTankUnits.damage = alienTankLv1.damage * AlienCiv15Tanks!! //

                alienTankUnits.speed = alienTankLv1.speed
                alienTankUnits.criticalProbability = alienTankLv1.criticalProbability

                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv15SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv15SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability

            } else if (AlienCiv15MilitaryBase == 4.0) { //

                alienSoldierUnits.HP = alienSoldierLv3.HP * AlienCiv15Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv3.damage * AlienCiv15Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv3.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv3.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv15SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv15SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv2.HP * AlienCiv15Tanks!! //
                alienTankUnits.damage = alienTankLv2.damage * AlienCiv15Tanks!! //

                alienTankUnits.speed = alienTankLv2.speed
                alienTankUnits.criticalProbability = alienTankLv2.criticalProbability


                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv15SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv15SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability

            } else if (AlienCiv15MilitaryBase == 5.0) { //

                alienSoldierUnits.HP = alienSoldierLv3.HP * AlienCiv15Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv3.damage * AlienCiv15Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv3.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv3.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv15SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv15SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv2.HP * AlienCiv15Tanks!! //
                alienTankUnits.damage = alienTankLv2.damage * AlienCiv15Tanks!! //

                alienTankUnits.speed = alienTankLv2.speed
                alienTankUnits.criticalProbability = alienTankLv2.criticalProbability


                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv15SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv15SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability
            }


            alienMilitaryBase = AlienCiv15MilitaryBase //
            levelDamageToAlienPlanet = isAlienCiv15Damaged!! //
            alienRelationship = alienCiv15RelationWithPlayer!! //


        }





// Alien 16



        if (selectedPlanetV == 16) { //

            // Chosen alien civilisations army is selected by shared pref


            if (AlienCiv16MilitaryBase == 1.0) { //

                alienSoldierUnits.HP = alienSoldierLv1.HP * AlienCiv16Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv1.damage * AlienCiv16Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv1.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv1.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv16SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv16SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability


            } else if (AlienCiv16MilitaryBase == 2.0) { //

                alienSoldierUnits.HP = alienSoldierLv2.HP * AlienCiv16Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv2.damage * AlienCiv16Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv2.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv2.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv16SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv16SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv1.HP * AlienCiv16Tanks!! //
                alienTankUnits.damage = alienTankLv1.damage * AlienCiv16Tanks!! //

                alienTankUnits.speed = alienTankLv1.speed
                alienTankUnits.criticalProbability = alienTankLv1.criticalProbability

            } else if (AlienCiv16MilitaryBase == 3.0) { //

                alienSoldierUnits.HP = alienSoldierLv2.HP * AlienCiv16Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv2.damage * AlienCiv16Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv2.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv2.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv16SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv16SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv1.HP * AlienCiv16Tanks!! //
                alienTankUnits.damage = alienTankLv1.damage * AlienCiv16Tanks!! //

                alienTankUnits.speed = alienTankLv1.speed
                alienTankUnits.criticalProbability = alienTankLv1.criticalProbability

                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv16SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv16SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability

            } else if (AlienCiv16MilitaryBase == 4.0) { //

                alienSoldierUnits.HP = alienSoldierLv3.HP * AlienCiv16Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv3.damage * AlienCiv16Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv3.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv3.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv16SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv16SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv2.HP * AlienCiv16Tanks!! //
                alienTankUnits.damage = alienTankLv2.damage * AlienCiv16Tanks!! //

                alienTankUnits.speed = alienTankLv2.speed
                alienTankUnits.criticalProbability = alienTankLv2.criticalProbability


                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv16SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv16SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability

            } else if (AlienCiv16MilitaryBase == 5.0) { //

                alienSoldierUnits.HP = alienSoldierLv3.HP * AlienCiv16Soldiers!! //
                alienSoldierUnits.damage = alienSoldierLv3.damage * AlienCiv16Soldiers!! //

                alienSoldierUnits.speed = alienSoldierLv3.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv3.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv16SpacePlanes!! //
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv16SpacePlanes!! //

                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv2.HP * AlienCiv16Tanks!! //
                alienTankUnits.damage = alienTankLv2.damage * AlienCiv16Tanks!! //

                alienTankUnits.speed = alienTankLv2.speed
                alienTankUnits.criticalProbability = alienTankLv2.criticalProbability


                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv16SpaceJets!! //
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv16SpaceJets!! //

                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability
            }


            alienMilitaryBase = AlienCiv16MilitaryBase //
            levelDamageToAlienPlanet = isAlienCiv16Damaged!! //
            alienRelationship = alienCiv16RelationWithPlayer!! //


        }
















        // Fighting simulation



        var selector = 1

        var attackedUnit = 0


        while (true) {



            if (soldierUnits.HP > 0.0 && selector == 1) {

                while (true) {

                       attackedUnit = (1..4).shuffled().last()

                    if (attackedUnit == 1 && alienSoldierUnits.HP > 0.0) {

                        attacker = soldierUnits
                        attacked = alienSoldierUnits

                        break

                    } else if (attackedUnit == 2 && alienSpacePlaneUnits.HP > 0.0) {

                        attacker = soldierUnits
                        attacked = alienSpacePlaneUnits

                        break

                    } else if (attackedUnit == 3 && alienTankUnits.HP > 0.0) {

                        attacker = soldierUnits
                        attacked = alienTankUnits

                        break

                    } else if (attackedUnit == 4 && alienSpaceJetUnits.HP > 0.0) {

                        attacker = soldierUnits
                        attacked = alienSpaceJetUnits

                        break

                    }


                }

            } else if (soldierUnits.HP <= 0.0 && selector == 1) {
                selector += 1
            }



                    if (spacePlaneUnits.HP > 0.0 && selector == 2) {

                        while (true) {

                               attackedUnit = (1..4).shuffled().last()

                            if (attackedUnit == 1 && alienSoldierUnits.HP > 0.0) {

                                attacker = spacePlaneUnits
                                attacked = alienSoldierUnits

                                break

                            } else if (attackedUnit == 2 && alienSpacePlaneUnits.HP > 0.0) {

                                attacker = spacePlaneUnits
                                attacked = alienSpacePlaneUnits

                                break

                            } else if (attackedUnit == 3 && alienTankUnits.HP > 0.0) {

                                attacker = spacePlaneUnits
                                attacked = alienTankUnits

                                break

                            } else if (attackedUnit == 4 && alienSpaceJetUnits.HP > 0.0) {

                                attacker = spacePlaneUnits
                                attacked = alienSpaceJetUnits

                                break

                            }



                        }



            }  else if (spacePlaneUnits.HP <= 0.0 && selector == 2) {
                        selector += 1
                    }








            if (tankUnits.HP > 0.0 && selector == 3) {

                while (true) {

                       attackedUnit = (1..4).shuffled().last()

                    if (attackedUnit == 1 && alienSoldierUnits.HP > 0.0) {

                        attacker = tankUnits
                        attacked = alienSoldierUnits

                        break

                    } else if (attackedUnit == 2 && alienSpacePlaneUnits.HP > 0.0) {

                        attacker = tankUnits
                        attacked = alienSpacePlaneUnits

                        break

                    } else if (attackedUnit == 3 && alienTankUnits.HP > 0.0) {

                        attacker = tankUnits
                        attacked = alienTankUnits

                        break

                    } else if (attackedUnit == 4 && alienSpaceJetUnits.HP > 0.0) {

                        attacker = tankUnits
                        attacked = alienSpaceJetUnits

                        break

                    }



                }



            }  else if (tankUnits.HP <= 0.0 && selector == 3) {
                selector += 1
            }








            if (spaceJetUnits.HP > 0.0 && selector == 4) {

                while (true) {

                        attackedUnit = (1..4).shuffled().last()

                    if (attackedUnit == 1 && alienSoldierUnits.HP > 0.0) {

                        attacker = spaceJetUnits
                        attacked = alienSoldierUnits

                        break

                    } else if (attackedUnit == 2 && alienSpacePlaneUnits.HP > 0.0) {

                        attacker = spaceJetUnits
                        attacked = alienSpacePlaneUnits

                        break

                    } else if (attackedUnit == 3 && alienTankUnits.HP > 0.0) {

                        attacker = spaceJetUnits
                        attacked = alienTankUnits

                        break

                    } else if (attackedUnit == 4 && alienSpaceJetUnits.HP > 0.0) {

                        attacker = spaceJetUnits
                        attacked = alienSpaceJetUnits

                        break

                    }



                }



            }  else if (spaceJetUnits.HP <= 0.0 && selector == 4) {
                selector += 1
            }









            if (alienSoldierUnits.HP > 0.0 && selector == 5) {

                while (true) {

                    attackedUnit = (1..4).shuffled().last()

                    if (attackedUnit == 1 && soldierUnits.HP > 0.0) {

                        attacker = alienSoldierUnits
                        attacked = soldierUnits

                        break

                    } else if (attackedUnit == 2 && spacePlaneUnits.HP > 0.0) {

                        attacker = alienSoldierUnits
                        attacked = spacePlaneUnits

                        break

                    } else if (attackedUnit == 3 && tankUnits.HP > 0.0) {

                        attacker = alienSoldierUnits
                        attacked = tankUnits

                        break

                    } else if (attackedUnit == 4 && spaceJetUnits.HP > 0.0) {

                        attacker = alienSoldierUnits
                        attacked = spaceJetUnits

                        break

                    }


                }

            } else if (alienSoldierUnits.HP <= 0.0 && selector == 5) {
                selector += 1
            }







            if (alienSpacePlaneUnits.HP > 0.0 && selector == 6) {  //

                while (true) {

                    attackedUnit = (1..4).shuffled().last()

                    if (attackedUnit == 1 && soldierUnits.HP > 0.0) {

                        attacker = alienSpacePlaneUnits  //
                        attacked = soldierUnits

                        break

                    } else if (attackedUnit == 2 && spacePlaneUnits.HP > 0.0) {

                        attacker = alienSpacePlaneUnits //
                        attacked = spacePlaneUnits

                        break

                    } else if (attackedUnit == 3 && tankUnits.HP > 0.0) {

                        attacker = alienSpacePlaneUnits //
                        attacked = tankUnits

                        break

                    } else if (attackedUnit == 4 && spaceJetUnits.HP > 0.0) {

                        attacker = alienSpacePlaneUnits //
                        attacked = spaceJetUnits

                        break

                    }


                }

            } else if (alienSpacePlaneUnits.HP <= 0.0 && selector == 6) {  //
                selector += 1
            }








            if (alienTankUnits.HP > 0.0 && selector == 7) {

                while (true) {

                    attackedUnit = (1..4).shuffled().last()

                    if (attackedUnit == 1 && soldierUnits.HP > 0.0) {

                        attacker = alienTankUnits
                        attacked = soldierUnits

                        break

                    } else if (attackedUnit == 2 && spacePlaneUnits.HP > 0.0) {

                        attacker = alienTankUnits
                        attacked = spacePlaneUnits

                        break

                    } else if (attackedUnit == 3 && tankUnits.HP > 0.0) {

                        attacker = alienTankUnits
                        attacked = tankUnits

                        break

                    } else if (attackedUnit == 4 && spaceJetUnits.HP > 0.0) {

                        attacker = alienTankUnits
                        attacked = spaceJetUnits

                        break

                    }


                }

            } else if (alienTankUnits.HP <= 0.0 && selector == 7) {
                selector += 1
            }












            if (alienSpaceJetUnits.HP > 0.0 && selector == 8) {

                while (true) {

                    attackedUnit = (1..4).shuffled().last()

                    if (attackedUnit == 1 && soldierUnits.HP > 0.0) {

                        attacker = alienSpaceJetUnits
                        attacked = soldierUnits

                        break

                    } else if (attackedUnit == 2 && spacePlaneUnits.HP > 0.0) {

                        attacker = alienSpaceJetUnits
                        attacked = spacePlaneUnits

                        break

                    } else if (attackedUnit == 3 && tankUnits.HP > 0.0) {

                        attacker = alienSpaceJetUnits
                        attacked = tankUnits

                        break

                    } else if (attackedUnit == 4 && spaceJetUnits.HP > 0.0) {

                        attacker = alienSpaceJetUnits
                        attacked = spaceJetUnits

                        break

                    }


                }

            } else if (alienSpaceJetUnits.HP <= 0.0 && selector == 8) {
                selector += 1
            }










            if (selector < 9) {




            var isEnemyHit = (1..100).shuffled().last()


            if (attacked.speed <= isEnemyHit) {

                  var isItCritical = (1..100).shuffled().last()

                if (attacker.criticalProbability >= isItCritical) {

                    attacked.HP = attacked.HP - (attacker.damage * 4)


                } else if (attacker.criticalProbability < isItCritical) {

                    attacked.HP = attacked.HP - attacker.damage


                }




            } else {

                Log.d("!!!", "Dodged")


            }






            // HP confirmer


            if (selector == 1 && attackedUnit == 1) {
                alienSoldierUnits = attacked
            } else if (selector == 1 && attackedUnit == 2) {
                alienSpacePlane = attacked
            } else if (selector == 1 && attackedUnit == 3) {
                alienTankUnits = attacked
            } else if (selector == 1 && attackedUnit == 4) {
                alienSpaceJetUnits = attacked
            }


            if (selector == 2 && attackedUnit == 1) {
                alienSoldierUnits = attacked
            } else if (selector == 2 && attackedUnit == 2) {
                alienSpacePlane = attacked
            } else if (selector == 2 && attackedUnit == 3) {
                alienTankUnits = attacked
            } else if (selector == 2 && attackedUnit == 4) {
                alienSpaceJetUnits = attacked
            }



            if (selector == 3 && attackedUnit == 1) {
                alienSoldierUnits = attacked
            } else if (selector == 3 && attackedUnit == 2) {
                alienSpacePlane = attacked
            } else if (selector == 3 && attackedUnit == 3) {
                alienTankUnits = attacked
            } else if (selector == 3 && attackedUnit == 4) {
                alienSpaceJetUnits = attacked
            }



            if (selector == 4 && attackedUnit == 1) {
                alienSoldierUnits = attacked
            } else if (selector == 4 && attackedUnit == 2) {
                alienSpacePlane = attacked
            } else if (selector == 4 && attackedUnit == 3) {
                alienTankUnits = attacked
            } else if (selector == 4 && attackedUnit == 4) {
                alienSpaceJetUnits = attacked
            }






            if (selector == 5 && attackedUnit == 1) {
                soldierUnits = attacked
            } else if (selector == 5 && attackedUnit == 2) {
                spacePlane = attacked
            } else if (selector == 5 && attackedUnit == 3) {
                tankUnits = attacked
            } else if (selector == 5 && attackedUnit == 4) {
                spaceJetUnits = attacked
            }




            if (selector == 6 && attackedUnit == 1) {
                soldierUnits = attacked
            } else if (selector == 6 && attackedUnit == 2) {
                spacePlane = attacked
            } else if (selector == 6 && attackedUnit == 3) {
                tankUnits = attacked
            } else if (selector == 6 && attackedUnit == 4) {
                spaceJetUnits = attacked
            }






            if (selector == 7 && attackedUnit == 1) {
                soldierUnits = attacked
            } else if (selector == 7 && attackedUnit == 2) {
                spacePlane = attacked
            } else if (selector == 7 && attackedUnit == 3) {
                tankUnits = attacked
            } else if (selector == 7 && attackedUnit == 4) {
                spaceJetUnits = attacked
            }







            if (selector == 8 && attackedUnit == 1) {
                soldierUnits = attacked
            } else if (selector == 8 && attackedUnit == 2) {
                spacePlane = attacked
            } else if (selector == 8 && attackedUnit == 3) {
                tankUnits = attacked
            } else if (selector == 8 && attackedUnit == 4) {
                spaceJetUnits = attacked
            }



            }



            // Checks if there is a winner



            if (soldierUnits.HP <= 0 && spacePlaneUnits.HP <= 0 && tankUnits.HP <= 0 && spaceJetUnits.HP <= 0) {

                // If alien wins


                Toast.makeText(this, "You lost the war, take a look at your army to see the losses", Toast.LENGTH_SHORT).show()


                // Turns negative numbers of overkilled troops in 0

                if (alienSoldierUnits.HP <= 0) {

                    alienSoldierUnits.HP = 0.0

                    // Save soldierQuantity as it is

                } else if (alienSoldierUnits.HP > 0) {

                    if (alienMilitaryBase == 1.0) {

                        var numberSoldiersLeft = (alienSoldierUnits.HP / alienSoldierLv1.HP)
                        var rounded = Math.round(numberSoldiersLeft)

                        alienSoldiersLeft = rounded + 0.0


                        Log.d("!!!", "$rounded")

                    } else if (alienMilitaryBase == 2.0) {

                        var numberSoldiersLeft = (alienSoldierUnits.HP / alienSoldierLv2.HP)
                        var rounded = Math.round(numberSoldiersLeft)
                        Log.d("!!!", "$rounded")

                        alienSoldiersLeft = rounded + 0.0


                    } else if (alienMilitaryBase == 3.0) {

                        var numberSoldiersLeft = (alienSoldierUnits.HP / alienSoldierLv2.HP)
                        var rounded = Math.round(numberSoldiersLeft)
                        Log.d("!!!", "$rounded")

                        alienSoldiersLeft = rounded + 0.0

                    } else if (militaryBaseLevel >= 4) {

                        var numberSoldiersLeft = (alienSoldierUnits.HP / alienSoldierLv3.HP)
                        var rounded = Math.round(numberSoldiersLeft)
                        Log.d("!!!", "$rounded")

                        alienSoldiersLeft = rounded + 0.0

                    }

                }



                if (alienSpacePlaneUnits.HP <= 0.0) {

                    alienSpacePlaneUnits.HP = 0.0

                } else if (alienSpacePlaneUnits.HP > 0.0) {

                    var numberSpacePlanesLeft =  (alienSpacePlaneUnits.HP / alienSpacePlane.HP)
                    var rounded = Math.round(numberSpacePlanesLeft)
                    Log.d("!!!", "$rounded")


                    alienSpacePlanesLeft = rounded + 0.0




                }




                if (alienTankUnits.HP <= 0.0) {

                    alienTankUnits.HP = 0.0

                } else if (alienTankUnits.HP > 0.0) {

                    if (alienMilitaryBase!! <= 3.0) {

                        var numberTankUnitsLeft = (alienTankUnits.HP / alienTankLv1.HP)
                        var rounded = Math.round(numberTankUnitsLeft)
                        Log.d("!!!", "$rounded")

                        alienTanksLeft = rounded + 0.0

                    } else if (alienMilitaryBase!! >= 4) {

                        var numberTankUnitsLeft = (alienTankUnits.HP / alienTankLv2.HP)
                        var rounded = Math.round(numberTankUnitsLeft)
                        Log.d("!!!", "$rounded")

                        alienTanksLeft = rounded + 0.0


                    }

                }





                if (alienSpaceJetUnits.HP <= 0.0) {

                    alienSpaceJetUnits.HP = 0.0

                } else if (alienSpaceJetUnits.HP > 0.0) {

                    var numberSpaceJetsLeft =  (alienSpaceJetUnits.HP / alienSpaceJet.HP)
                    var rounded = Math.round(numberSpaceJetsLeft)
                    Log.d("!!!", "$rounded")

                    alienSpaceJetsLeft = rounded + 0.0

                }




                    alienWinningAttackMessage()
                    alienRelationship = 0.0








                Log.d("!!!", "Alien wins")

                break







            } else if (alienSoldierUnits.HP <= 0 && alienSpacePlaneUnits.HP <= 0 && alienTankUnits.HP <= 0 && alienSpaceJetUnits.HP <= 0) {


                // If player wins

                Toast.makeText(this, "You won the war. Take a look at your troops to see the losses", Toast.LENGTH_SHORT).show()

                // Alien army turns to nothing

                alienSoldierUnits.HP = 0.0
                alienSpacePlaneUnits.HP = 0.0
                alienTankUnits.HP = 0.0
                alienSpaceJetUnits.HP = 0.0

                // Turns negative numbers of overkilled troops in 0

                if (soldierUnits.HP <= 0) {

                    soldierUnits.HP = 0.0

                    // Save soldierQuantity as it is

                } else if (soldierUnits.HP > 0) {

                    if (militaryBaseLevel == 1) {

                        var numberSoldiersLeft = (soldierUnits.HP / soldierLv1.HP)
                        var rounded = Math.round(numberSoldiersLeft)

                        soldierQuantity += rounded


                        Log.d("!!!", "$rounded")

                    } else if (militaryBaseLevel == 2) {

                        var numberSoldiersLeft = (soldierUnits.HP / soldierLv2.HP)
                        var rounded = Math.round(numberSoldiersLeft)
                        Log.d("!!!", "$rounded")

                        soldierQuantity += rounded


                    } else if (militaryBaseLevel == 3) {

                        var numberSoldiersLeft = (soldierUnits.HP / soldierLv2.HP)
                        var rounded = Math.round(numberSoldiersLeft)
                        Log.d("!!!", "$rounded")

                        soldierQuantity += rounded

                    } else if (militaryBaseLevel >= 4) {

                        var numberSoldiersLeft = (soldierUnits.HP / soldierLv3.HP)
                        var rounded = Math.round(numberSoldiersLeft)
                        Log.d("!!!", "$rounded")

                        soldierQuantity += rounded

                    }

                }



                if (spacePlaneUnits.HP <= 0.0) {

                    spacePlaneUnits.HP = 0.0

                } else if (spacePlaneUnits.HP > 0.0) {

                    var numberSpacePlanesLeft =  (spacePlaneUnits.HP / spacePlane.HP)
                    var rounded = Math.round(numberSpacePlanesLeft)
                    Log.d("!!!", "$rounded")


                    airplaneQuantity += rounded




                }




                if (tankUnits.HP <= 0.0) {

                    tankUnits.HP = 0.0

                } else if (tankUnits.HP > 0.0) {

                    if (militaryBaseLevel <= 3) {

                        var numberTankUnitsLeft = (tankUnits.HP / tankLv1.HP)
                        var rounded = Math.round(numberTankUnitsLeft)
                        Log.d("!!!", "$rounded")

                        tankQuantity += rounded

                    } else if (militaryBaseLevel >= 4) {

                        var numberTankUnitsLeft = (tankUnits.HP / tankLv2.HP)
                        var rounded = Math.round(numberTankUnitsLeft)
                        Log.d("!!!", "$rounded")

                        tankQuantity += rounded


                    }

                }





                if (spaceJetUnits.HP <= 0.0) {

                    spaceJetUnits.HP = 0.0

                } else if (spaceJetUnits.HP > 0.0) {

                    var numberSpaceJetsLeft =  (spaceJetUnits.HP / spaceJet.HP)
                    var rounded = Math.round(numberSpaceJetsLeft)
                    Log.d("!!!", "$rounded")

                    airplane2Quantity += rounded

                }



                // Alien planet becomes more damaged and relationship with player change

                levelDamageToAlienPlanet -= 1

                var relationsChange = (1..10).shuffled().last()

                if (relationsChange <= 7) {
                    alienRelationship = 6.0
                    friendlyAttackMessage()
                } else {
                    alienRelationship = 0.0
                    angryAttackMessage()
                }






                // Stealing resourses from alien based on cargoplanes number

                moneyAmount += (selectedCargoPlanesInt * 100)
                resoursesAmount += (selectedCargoPlanesInt * 100)
                cargoplaneQuantity += selectedCargoPlanesDouble


                Log.d("!!!", "Player wins")

                break


            }




            if (selector < 8) {

                selector += 1

            } else if (selector >= 8) {

                selector = 1

            }






        } // Battle loop











    }




    fun alienWinningAttackMessage() {

        var nuclearStrikeMessage = (1..4).shuffled().last()



        if (selectedPlanetV == 1) { // Alien 1

            if (nuclearStrikeMessage == 1) {
                messageText = "$AlienCiv1Name :  How did you even think you could win against us?"
            } else if (nuclearStrikeMessage == 2) {
                messageText =
                    "$AlienCiv1Name :  You have no idea how much trouble you just caused yourself"
            } else if (nuclearStrikeMessage == 3) {
                messageText =
                    "$AlienCiv1Name :  We will show your how civilisations get extint "
            } else if (nuclearStrikeMessage == 4) {
                messageText = "$AlienCiv1Name :  The next beating is coming soon"
            }

        }




        if (selectedPlanetV == 2) { // Alien 2

            if (nuclearStrikeMessage == 1) {
                messageText = "$AlienCiv2Name :  How did you even think you could win against us?"
            } else if (nuclearStrikeMessage == 2) {
                messageText =
                    "$AlienCiv2Name :  You have no idea how much trouble you just caused yourself"
            } else if (nuclearStrikeMessage == 3) {
                messageText =
                    "$AlienCiv2Name :  We will show your how civilisations get extint "
            } else if (nuclearStrikeMessage == 4) {
                messageText = "$AlienCiv2Name :  The next beating is coming soon"
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




















    fun friendlyAttackMessage() {

        var nuclearStrikeMessage = (1..4).shuffled().last()



        if (selectedPlanetV == 1) { // Alien 1

            if (nuclearStrikeMessage == 1) {
                messageText = "$AlienCiv1Name :  We underestimated you, we would like to have a better relationship with you"
            } else if (nuclearStrikeMessage == 2) {
                messageText =
                    "$AlienCiv1Name :  Please dont destroy our civilisation, we are sorry for angering you"
            } else if (nuclearStrikeMessage == 3) {
                messageText =
                    "$AlienCiv1Name :  We dont want war, please consider peace. We will not bother you anymore"
            } else if (nuclearStrikeMessage == 4) {
                messageText = "$AlienCiv1Name :  Our people is in trouble because of this war, can we be friends ?"
            }

        }




        if (selectedPlanetV == 2) { // Alien 2

            if (nuclearStrikeMessage == 1) {
                messageText = "$AlienCiv2Name :  We underestimated you, we would like to have a better relationship with you"
            } else if (nuclearStrikeMessage == 2) {
                messageText =
                    "$AlienCiv2Name :  Please dont destroy our civilisation, we are sorry for angering you"
            } else if (nuclearStrikeMessage == 3) {
                messageText =
                    "$AlienCiv2Name :  We dont want war, please consider peace. We will not bother you anymore"
            } else if (nuclearStrikeMessage == 4) {
                messageText = "$AlienCiv2Name :  Our people is in trouble because of this war, can we be friends ?"
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









    fun angryAttackMessage() {

        var nuclearStrikeMessage = (1..4).shuffled().last()



        if (selectedPlanetV == 1) { // Alien 1

            if (nuclearStrikeMessage == 1) {
                messageText = "$AlienCiv1Name :  Next time we will annihilate your entire civilisation"
            } else if (nuclearStrikeMessage == 2) {
                messageText =
                    "$AlienCiv1Name :  We will have our revenge in the next war"
            } else if (nuclearStrikeMessage == 3) {
                messageText =
                    "$AlienCiv1Name :  We cant believe that we lost against such a pathetic civilisation such as yours"
            } else if (nuclearStrikeMessage == 4) {
                messageText = "$AlienCiv1Name :  You will payyyyyy for thiiissss buuuaaaaggaaaaaa"
            }

        }




        if (selectedPlanetV == 2) { // Alien 2

            if (nuclearStrikeMessage == 1) {
                messageText = "$AlienCiv2Name :  Next time we will annihilate your entire civilisation"
            } else if (nuclearStrikeMessage == 2) {
                messageText =
                    "$AlienCiv2Name :  We will have our revenge in the next war"
            } else if (nuclearStrikeMessage == 3) {
                messageText =
                    "$AlienCiv2Name :  We cant believe that we lost against such a pathetic civilisation such as yours"
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


















    fun saveChangesInArmyAfterWar() {







            var data = playerData(savedMoneyAmount = moneyAmount, savedResoursesAmount = resoursesAmount,
                savedLevelInfrastructure = levelInfrastructure, savedLevelFactory = levelFactory, savedLevelMilitaryBase= militaryBaseLevel,
                savedLevelGeneralDevelopment = levelGeneralDevelopment, savedLevelScienficResearch = levelScientificDevelopment,
                savedLevelSpionage = levelSpionage, savedSoldierUnitQuantity = soldierQuantity, savedAirplaneUnitQuantity = airplaneQuantity,
                savedCargoPlaneQuantity = cargoplaneQuantity, savedAirplane2UnitQuantity= airplane2Quantity, savedTankUnitQuantity= tankQuantity,
                savedSateliteUnitQuantity= sateliteQuantity, isDamagedAlive = damageToPlayerPlanet, colonyId1 = colonyId1,
                colonyResourses1 = colonyResourses1)



            database.collection("users").document("User path").collection("Saved data")
                .document("hmkogjk").set(data)


                .addOnCompleteListener {



                }





    }








    fun saveAlienData() {


        // War with alien 1


        if (selectedPlanetV == 1) {

            var dataOfAlienCivilisations = aliens(

                // Alien 1
                nameAlienRace1 = AlienCiv1Name,
                pictureAlienRace1 = AlienCiv1Picture,
                militaryBaseAlienRace1 = AlienCiv1MilitaryBase,

                // Army Alien 1
                soldiersAlienRace1 = alienSoldiersLeft,   //
                spacePlanesAlienRace1 = alienSpacePlanesLeft,  //
                spaceJetsAlienRace1 = alienSpaceJetsLeft,   //
                tanksAlienRace1 = alienTanksLeft,   //
                nuclearSatelitesAlienRace1 = AlienCiv1NuclearSatelites,

                // Level damage alien planet 1 and relations
                alienRace1RelationWithPlayer = alienRelationship,  //
                isAlienRace1Damaged = levelDamageToAlienPlanet,  //




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
                isAlienRace2Damaged = isAlienCiv2Damaged)



            database.collection("users").document("User path").collection("Saved aliens data")
                .document("Aliens data").set(dataOfAlienCivilisations)


                .addOnCompleteListener {


                }

        }



        // War with alien 2


        if (selectedPlanetV == 2) {

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

                // Level damage alien 1 planet
                alienRace1RelationWithPlayer = alienCiv1RelationWithPlayer,
                isAlienRace1Damaged = isAlienCiv1Damaged,



                // Alien 2
                nameAlienRace2 = AlienCiv2Name,
                pictureAlienRace2 = AlienCiv2Picture,
                militaryBaseAlienRace2 = AlienCiv2MilitaryBase,

                // Army Alien 2
                soldiersAlienRace2 = alienSoldiersLeft,
                spacePlanesAlienRace2 = alienSpacePlanesLeft,
                spaceJetsAlienRace2 = alienSpaceJetsLeft,
                tanksAlienRace2 = alienTanksLeft,
                nuclearSatelitesAlienRace2 = AlienCiv2NuclearSatelites,


                // Level damage alien 2 planet
                alienRace2RelationWithPlayer = alienRelationship,
                isAlienRace2Damaged = levelDamageToAlienPlanet)



            database.collection("users").document("User path").collection("Saved aliens data")
                .document("Aliens data").set(dataOfAlienCivilisations)


                .addOnCompleteListener {


                }

        }












    }






}