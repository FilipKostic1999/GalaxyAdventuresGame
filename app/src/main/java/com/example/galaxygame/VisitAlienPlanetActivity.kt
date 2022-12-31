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

class VisitAlienPlanetActivity : AppCompatActivity() {


    lateinit var nameOfAlienTxt : TextView
    lateinit var spyArmyTextView : TextView
    lateinit var pictureofAlien : ImageView
    lateinit var attackImg : ImageView


    var AlienCiv1Name : String? = null
    var AlienCiv1Picture : Int? = null
    var AlienCiv1Soldiers : Double? = null
    var AlienCiv1SpacePlanes : Double? = null
    var AlienCiv1SpaceJets : Double? = null
    var AlienCiv1Tanks : Double? = null
    var AlienCiv1NuclearSatelites : Double? = null

    var AlienCiv2Name : String? = null
    var AlienCiv2Picture : Int? = null
    var AlienCiv2Soldiers : Double? = null
    var AlienCiv2SpacePlanes : Double? = null
    var AlienCiv2SpaceJets : Double? = null
    var AlienCiv2Tanks : Double? = null
    var AlienCiv2NuclearSatelites : Double? = null








    var soldiers : Double? = null
    var spacePlanes : Double? = null
    var spaceJets : Double? = null
    var tanks : Double? = null
    var nuclearSatelites : Double? = null


    var alienMilitaryBase : Double? = null
    lateinit var playerDataSpionage : playerData
    var spionageLevelPlayer : Int = 0




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


        database = Firebase.firestore


        strikeBtn.isVisible = false
        strikeBtn.isEnabled = false
        nuclearSateliteImg.isVisible = false



        val sharedSelectedPlanet = getSharedPreferences("SelectedPlanet", AppCompatActivity.MODE_PRIVATE)
        var SelectedPlanet = sharedSelectedPlanet.getInt("SelectedPlanet", 0)






        database.collection("users").document("User path")
            .collection("Saved data")

            .addSnapshotListener { snapshot, e ->
                if (snapshot != null) {
                    for (document in snapshot.documents) {

                        playerDataSpionage = document.toObject()!!


                        spionageLevelPlayer = playerDataSpionage.savedLevelSpionage






                    }
                }
            }















        database.collection("users").document("User path")
            .collection("Saved aliens data")

            .addSnapshotListener { snapshot, e ->
                if (snapshot != null) {
                    for (document in snapshot.documents) {

                        savedDataOfAliens = document.toObject()!!



                        if (SelectedPlanet == 1) {   /* Number of alien civilisation always matches

                        the number of the planet and solar system where it resides. In order to display
                        the alien civilisation that is selected by planet the shared pref displays
                        only the content that is connected to selected planet number

                        */

                            // Fetches the data of first civilisation in galaxy

                            AlienCiv1Name = savedDataOfAliens.nameAlienRace1
                            nameOfAlienTxt.text = "$AlienCiv1Name"
                            AlienCiv1Picture = savedDataOfAliens.pictureAlienRace1
                            AlienCiv1Soldiers = savedDataOfAliens.soldiersAlienRace1
                            AlienCiv1SpacePlanes = savedDataOfAliens.spacePlanesAlienRace1
                            AlienCiv1SpaceJets = savedDataOfAliens.spaceJetsAlienRace1
                            AlienCiv1Tanks = savedDataOfAliens.tanksAlienRace1
                            AlienCiv1NuclearSatelites = savedDataOfAliens.nuclearSatelitesAlienRace1




                            // Prepares views for spionage

                            soldiers = savedDataOfAliens.soldiersAlienRace1
                            spacePlanes = savedDataOfAliens.spacePlanesAlienRace1
                            spaceJets = savedDataOfAliens.spaceJetsAlienRace1
                            tanks = savedDataOfAliens.tanksAlienRace1
                            nuclearSatelites = savedDataOfAliens.nuclearSatelitesAlienRace1

                            alienMilitaryBase = savedDataOfAliens.militaryBaseAlienRace1





                            // Displays picture of alien based on number

                            if (AlienCiv1Picture == 1) {
                                pictureofAlien.setImageResource(R.drawable.alien1)
                            } else if (AlienCiv1Picture == 2) {
                                pictureofAlien.setImageResource(R.drawable.sporealientwo)
                            } else if (AlienCiv1Picture == 3) {
                                pictureofAlien.setImageResource(R.drawable.alien3)
                            } else if (AlienCiv1Picture == 4) {
                                pictureofAlien.setImageResource(R.drawable.alien4)
                            }


                        }



                        if (SelectedPlanet == 2) {


                            // Fetches the data of second civilisation in galaxy

                            AlienCiv2Name = savedDataOfAliens.nameAlienRace2
                            nameOfAlienTxt.text = "$AlienCiv2Name"
                            AlienCiv2Picture = savedDataOfAliens.pictureAlienRace2
                            AlienCiv2Soldiers = savedDataOfAliens.soldiersAlienRace2
                            AlienCiv2SpacePlanes = savedDataOfAliens.spacePlanesAlienRace2
                            AlienCiv2SpaceJets = savedDataOfAliens.spaceJetsAlienRace2
                            AlienCiv2Tanks = savedDataOfAliens.tanksAlienRace2
                            AlienCiv2NuclearSatelites = savedDataOfAliens.nuclearSatelitesAlienRace2





                            // Prepares views for spionage

                            soldiers = savedDataOfAliens.soldiersAlienRace2
                            spacePlanes = savedDataOfAliens.spacePlanesAlienRace2
                            spaceJets = savedDataOfAliens.spaceJetsAlienRace2
                            tanks = savedDataOfAliens.tanksAlienRace2
                            nuclearSatelites = savedDataOfAliens.nuclearSatelitesAlienRace2

                            alienMilitaryBase = savedDataOfAliens.militaryBaseAlienRace2








                            // Displays picture of alien based on number

                            if (AlienCiv2Picture == 1) {
                                pictureofAlien.setImageResource(R.drawable.alien1)
                            } else if (AlienCiv2Picture == 2) {
                                pictureofAlien.setImageResource(R.drawable.sporealientwo)
                            } else if (AlienCiv2Picture == 3) {
                                pictureofAlien.setImageResource(R.drawable.alien3)
                            } else if (AlienCiv2Picture == 4) {
                                pictureofAlien.setImageResource(R.drawable.alien4)
                            }

                        }










                    }
                }
            }





        attackImg.setOnClickListener {

            val intent = Intent(this, WarSimulatorActivity :: class.java)
            startActivity(intent)

        }





        strikeWithNuclearSatelitesBtn.setOnClickListener {

            strikeBtn.isVisible = true
            strikeBtn.isEnabled = true
            nuclearSateliteImg.isVisible = true



        }










        spyBtn.setOnClickListener {


            if (SelectedPlanet == 1) {

                var spied = (1..5).shuffled().last()

                if(spied <= spionageLevelPlayer) {

                    if (alienMilitaryBase == 1.0) {

                        spyArmyTextView.text = "Soldiers LV1: $soldiers,  Space planes LV1: $spacePlanes,  Tanks LV1: $tanks,  Space Jets LV1: $spaceJets "

                    } else if (alienMilitaryBase == 2.0) {

                        spyArmyTextView.text = "Soldiers LV2: $soldiers,  Space planes LV1: $spacePlanes,  Tanks LV1: $tanks,  Space Jets LV1: $spaceJets "

                    } else if (alienMilitaryBase == 3.0) {

                        spyArmyTextView.text = "Soldiers LV2: $soldiers,  Space planes LV1: $spacePlanes,  Tanks LV1: $tanks,  Space Jets LV1: $spaceJets "

                    } else if (alienMilitaryBase == 4.0) {

                        spyArmyTextView.text = "Soldiers LV3: $soldiers,  Space planes LV1: $spacePlanes,  Tanks LV2: $tanks,  Space Jets LV1: $spaceJets "


                    } else if (alienMilitaryBase == 5.0) {

                        spyArmyTextView.text = "Soldiers LV3: $soldiers,  Space planes LV1: $spacePlanes,  Tanks LV2: $tanks,  Space Jets LV1: $spaceJets "

                    }


                    Toast.makeText(this, "Your spy reported the numbers in alien army", Toast.LENGTH_SHORT).show()




                } else {

                    Toast.makeText(this, "Your spy has been captured", Toast.LENGTH_SHORT).show()

                }


            }  // Firs alien








            if (SelectedPlanet == 2) {

                var spied = (1..5).shuffled().last()

                if(spied <= spionageLevelPlayer) {

                    if (alienMilitaryBase == 1.0) {

                        spyArmyTextView.text = "Soldiers LV1: $soldiers,  Space planes LV1: $spacePlanes,  Tanks LV1: $tanks,  Space Jets LV1: $spaceJets "

                    } else if (alienMilitaryBase == 2.0) {

                        spyArmyTextView.text = "Soldiers LV2: $soldiers,  Space planes LV1: $spacePlanes,  Tanks LV1: $tanks,  Space Jets LV1: $spaceJets "

                    } else if (alienMilitaryBase == 3.0) {

                        spyArmyTextView.text = "Soldiers LV2: $soldiers,  Space planes LV1: $spacePlanes,  Tanks LV1: $tanks,  Space Jets LV1: $spaceJets "

                    } else if (alienMilitaryBase == 4.0) {

                        spyArmyTextView.text = "Soldiers LV3: $soldiers,  Space planes LV1: $spacePlanes,  Tanks LV2: $tanks,  Space Jets LV1: $spaceJets "


                    } else if (alienMilitaryBase == 5.0) {

                        spyArmyTextView.text = "Soldiers LV3: $soldiers,  Space planes LV1: $spacePlanes,  Tanks LV2: $tanks,  Space Jets LV1: $spaceJets "

                    }


                    Toast.makeText(this, "Your spy reported the numbers in alien army", Toast.LENGTH_SHORT).show()




                } else {

                    Toast.makeText(this, "Your spy has been captured", Toast.LENGTH_SHORT).show()

                }



            } // Second Alien










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
}