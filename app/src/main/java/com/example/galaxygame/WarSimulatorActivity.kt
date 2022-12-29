package com.example.galaxygame

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

    var militaryBaseLevel : Int = 0




    var AlienCiv1Name : String? = null
    var AlienCiv1Picture : Int? = null
    var AlienCiv1MilitaryBase : Double? = null
    var AlienCiv1Soldiers : Double? = null
    var AlienCiv1SpacePlanes : Double? = null
    var AlienCiv1SpaceJets : Double? = null
    var AlienCiv1Tanks : Double? = null
    var AlienCiv1NuclearSatelites : Double? = null

    var AlienCiv2Name : String? = null
    var AlienCiv2Picture : Int? = null
    var AlienCiv2MilitaryBase : Double? = null
    var AlienCiv2Soldiers : Double? = null
    var AlienCiv2SpacePlanes : Double? = null
    var AlienCiv2SpaceJets : Double? = null
    var AlienCiv2Tanks : Double? = null
    var AlienCiv2NuclearSatelites : Double? = null



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




    var soldierLv1 = warUnits(5.0, 10.0, 20.0, 10.0)
    var soldierLv2 = warUnits(15.0, 25.0, 20.0, 15.0)
    var soldierLv3 = warUnits(40.0, 40.0, 35.0, 20.0)

    var spacePlane = warUnits(120.0, 240.0, 80.0, 5.0)
    var spaceJet = warUnits(480.0, 800.0, 95.0, 8.0)

    var tankLv1 = warUnits(2000.0, 100.0, 5.0, 10.0)
    var tankLv2 = warUnits(8000.0, 400.0, 10.0, 15.0)


    var soldierUnits = warUnits(5.0, 10.0, 20.0, 10.0)
    var spacePlaneUnits = warUnits(120.0, 240.0, 80.0, 5.0)
    var spaceJetUnits = warUnits(480.0, 800.0, 95.0, 8.0)
    var tankUnits = warUnits(2000.0, 100.0, 5.0, 10.0)






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



            } else {
                Toast.makeText(this, "You typed more troops than you have!", Toast.LENGTH_SHORT).show()
            }




            simulateWar()

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

                        militaryBaseLevel = savedDataOfUser.savedLevelMilitaryBase


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





                        // Fetches the data of second civilisation in galaxy

                        AlienCiv2Name = savedDataOfAliens.nameAlienRace2
                        AlienCiv2Picture = savedDataOfAliens.pictureAlienRace2
                        AlienCiv2MilitaryBase = savedDataOfAliens.militaryBaseAlienRace2
                        AlienCiv2Soldiers = savedDataOfAliens.soldiersAlienRace2
                        AlienCiv2SpacePlanes = savedDataOfAliens.spacePlanesAlienRace2
                        AlienCiv2SpaceJets = savedDataOfAliens.spaceJetsAlienRace2
                        AlienCiv2Tanks = savedDataOfAliens.tanksAlienRace2
                        AlienCiv2NuclearSatelites = savedDataOfAliens.nuclearSatelitesAlienRace2




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
            spaceJet.damage = spaceJet.damage * selectedSpaceJetsDouble
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
            spaceJet.damage = spaceJet.damage * selectedSpaceJetsDouble
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
            spaceJet.damage = spaceJet.damage * selectedSpaceJetsDouble
            spaceJetUnits.speed = spaceJet.speed
            spaceJetUnits.criticalProbability = spaceJet.criticalProbability

        }





        // Preparing enemy army









    }






}