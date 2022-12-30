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


    var alienSoldiersLeft : Double? = 10.0
    var alienSpacePlanesLeft : Double? = 0.0
    var alienTanksLeft : Double? = 0.0
    var alienSpaceJetsLeft : Double? = 0.0



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


    var alienMilitaryBase : Double? = null


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


                simulateWar()

                saveChangesInArmyAfterWar()

                saveAlienData()

                val intent = Intent(this, GalaxyViewActivity :: class.java)
                startActivity(intent)



            } else {
                Toast.makeText(this, "You typed more troops than you have!", Toast.LENGTH_SHORT).show()
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



        if (selectedPlanetV == 1) {

            // Chosen alien civilisations army is selected by shared pref


            if (AlienCiv1MilitaryBase == 1.0) {

                alienSoldierUnits.HP = alienSoldierLv1.HP * AlienCiv1Soldiers!!
                alienSoldierUnits.damage = alienSoldierLv1.damage * AlienCiv1Soldiers!!
                alienSoldierUnits.speed = alienSoldierLv1.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv1.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv1SpacePlanes!!
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv1SpacePlanes!!
                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability


            } else if (AlienCiv1MilitaryBase == 2.0) {

                alienSoldierUnits.HP = alienSoldierLv2.HP * AlienCiv1Soldiers!!
                alienSoldierUnits.damage = alienSoldierLv2.damage * AlienCiv1Soldiers!!
                alienSoldierUnits.speed = alienSoldierLv2.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv2.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv1SpacePlanes!!
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv1SpacePlanes!!
                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv1.HP * AlienCiv1Tanks!!
                alienTankUnits.damage = alienTankLv1.damage * AlienCiv1Tanks!!
                alienTankUnits.speed = alienTankLv1.speed
                alienTankUnits.criticalProbability = alienTankLv1.criticalProbability

            } else if (AlienCiv1MilitaryBase == 3.0) {

                alienSoldierUnits.HP = alienSoldierLv2.HP * AlienCiv1Soldiers!!
                alienSoldierUnits.damage = alienSoldierLv2.damage * AlienCiv1Soldiers!!
                alienSoldierUnits.speed = alienSoldierLv2.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv2.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv1SpacePlanes!!
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv1SpacePlanes!!
                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv1.HP * AlienCiv1Tanks!!
                alienTankUnits.damage = alienTankLv1.damage * AlienCiv1Tanks!!
                alienTankUnits.speed = alienTankLv1.speed
                alienTankUnits.criticalProbability = alienTankLv1.criticalProbability

                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv1SpaceJets!!
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv1SpaceJets!!
                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability

            } else if (AlienCiv1MilitaryBase == 4.0) {

                alienSoldierUnits.HP = alienSoldierLv3.HP * AlienCiv1Soldiers!!
                alienSoldierUnits.damage = alienSoldierLv3.damage * AlienCiv1Soldiers!!
                alienSoldierUnits.speed = alienSoldierLv3.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv3.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv1SpacePlanes!!
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv1SpacePlanes!!
                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv2.HP * AlienCiv1Tanks!!
                alienTankUnits.damage = alienTankLv2.damage * AlienCiv1Tanks!!
                alienTankUnits.speed = alienTankLv2.speed
                alienTankUnits.criticalProbability = alienTankLv2.criticalProbability


                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv1SpaceJets!!
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv1SpaceJets!!
                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability

            } else if (AlienCiv1MilitaryBase == 5.0) {

                alienSoldierUnits.HP = alienSoldierLv3.HP * AlienCiv1Soldiers!!
                alienSoldierUnits.damage = alienSoldierLv3.damage * AlienCiv1Soldiers!!
                alienSoldierUnits.speed = alienSoldierLv3.speed
                alienSoldierUnits.criticalProbability = alienSoldierLv3.criticalProbability

                alienSpacePlaneUnits.HP = alienSpacePlane.HP * AlienCiv1SpacePlanes!!
                alienSpacePlaneUnits.damage = alienSpacePlane.damage * AlienCiv1SpacePlanes!!
                alienSpacePlaneUnits.speed = alienSpacePlane.speed
                alienSpacePlaneUnits.criticalProbability = alienSpacePlane.criticalProbability

                alienTankUnits.HP = alienTankLv2.HP * AlienCiv1Tanks!!
                alienTankUnits.damage = alienTankLv2.damage * AlienCiv1Tanks!!
                alienTankUnits.speed = alienTankLv2.speed
                alienTankUnits.criticalProbability = alienTankLv2.criticalProbability


                alienSpaceJetUnits.HP = alienSpaceJet.HP * AlienCiv1SpaceJets!!
                alienSpaceJetUnits.damage = alienSpaceJet.damage * AlienCiv1SpaceJets!!
                alienSpaceJetUnits.speed = alienSpaceJet.speed
                alienSpaceJetUnits.criticalProbability = alienSpaceJet.criticalProbability
            }


            alienMilitaryBase = AlienCiv1MilitaryBase


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




    fun saveChangesInArmyAfterWar() {







            var data = playerData(savedMoneyAmount = moneyAmount, savedResoursesAmount = resoursesAmount,
                savedLevelInfrastructure = levelInfrastructure, savedLevelFactory = levelFactory, savedLevelMilitaryBase= militaryBaseLevel,
                savedLevelGeneralDevelopment = levelGeneralDevelopment, savedLevelScienficResearch = levelScientificDevelopment,
                savedLevelSpionage = levelSpionage, savedSoldierUnitQuantity = soldierQuantity, savedAirplaneUnitQuantity = airplaneQuantity,
                savedCargoPlaneQuantity = cargoplaneQuantity, savedAirplane2UnitQuantity= airplane2Quantity, savedTankUnitQuantity= tankQuantity,
                savedSateliteUnitQuantity= sateliteQuantity)



            database.collection("users").document("User path").collection("Saved data")
                .document("hmkogjk").set(data)


                .addOnCompleteListener {



                }





    }








    fun saveAlienData() {



        if (selectedPlanetV == 1) {

            var dataOfAlienCivilisations = aliens(
                nameAlienRace1 = AlienCiv1Name,
                pictureAlienRace1 = AlienCiv1Picture,
                militaryBaseAlienRace1 = AlienCiv1MilitaryBase,
                nuclearSatelitesAlienRace1 = AlienCiv1NuclearSatelites,
                soldiersAlienRace1 = alienSoldiersLeft,
                spacePlanesAlienRace1 = alienSpacePlanesLeft,
                spaceJetsAlienRace1 = alienSpaceJetsLeft,
                tanksAlienRace1 = alienTanksLeft
            )



            database.collection("users").document("User path").collection("Saved aliens data")
                .document("Aliens data").set(dataOfAlienCivilisations)


                .addOnCompleteListener {


                }

        }



    }






}