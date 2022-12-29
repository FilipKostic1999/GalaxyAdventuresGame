package com.example.galaxygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class WarSimulatorActivity : AppCompatActivity() {







    var soldierQuantity : Double = 100.0
    var airplaneQuantity : Double = 40.0
    var cargoplaneQuantity : Double = 10.0
    var airplane2Quantity : Double = 0.0
    var tankQuantity : Double = 0.0
    var sateliteQuantity : Double = 0.0


    var AlienCiv1Name : String? = null
    var AlienCiv1Picture : Int? = null

    var AlienCiv2Name : String? = null
    var AlienCiv2Picture : Int? = null







    var soldierLv1 = warUnits(5.0, 10.0, 20.0, 10.0)
    var soldierLv2 = warUnits(15.0, 25.0, 20.0, 15.0)
    var soldierLv3 = warUnits(40.0, 40.0, 35.0, 20.0)

    var spacePlaneLv1 = warUnits(120.0, 240.0, 80.0, 5.0)
    var spacePlaneLv2 = warUnits(480.0, 800.0, 95.0, 8.0)

    var tankLv1 = warUnits(2000.0, 100.0, 5.0, 10.0)
    var tankLv2 = warUnits(8000.0, 400.0, 10.0, 15.0)


    lateinit var savedDataOfAliens : aliens
    lateinit var savedDataOfUser : playerData
    lateinit var database : FirebaseFirestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_war_simulator)

        database = Firebase.firestore





        val sharedSelectedPlanet = getSharedPreferences("SelectedPlanet", AppCompatActivity.MODE_PRIVATE)
        var SelectedPlanet = sharedSelectedPlanet.getInt("SelectedPlanet", 0)





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







                            // Fetches the data of second civilisation in galaxy

                            AlienCiv2Name = savedDataOfAliens.nameAlienRace2
                            AlienCiv2Picture = savedDataOfAliens.pictureAlienRace2




                        }

                    }
                }














    }
}