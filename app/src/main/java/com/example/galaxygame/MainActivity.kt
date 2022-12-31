package com.example.galaxygame

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
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


    var soldierQuantity : Double = 100.0
    var airplaneQuantity : Double = 40.0
    var cargoplaneQuantity : Double = 10.0
    var airplane2Quantity : Double = 0.0
    var tankQuantity : Double = 0.0
    var sateliteQuantity : Double = 0.0








    // Aliens data before generation of random civilisations in the galaxy


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









    lateinit var savedMessages : messages








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




        database = Firebase.firestore















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


                            Log.d("!!!", "$moneyAmount")







                            // Displays the saved state and values of the views

                            moneyTextView.text = "${savedDataOfUser.savedMoneyAmount} Trilion"
                            resoursesAmountText.text = "${savedDataOfUser.savedResoursesAmount}"







                            if (levelGeneralDevelopment == 2) {

                                containerRl.background = resources.getDrawable(R.drawable.evolvedsecond)

                            } else if (levelGeneralDevelopment == 3) {

                                containerRl.background = resources.getDrawable(R.drawable.developedthree)

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

                        // Fetches the data of second civilisation in galaxy

                        AlienCiv2Name = savedDataOfAliens.nameAlienRace2
                        AlienCiv2Picture = savedDataOfAliens.pictureAlienRace2





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



                        if (savedMessages.isItNewMessage == true) {

                            redMsgIcon.setImageResource(R.drawable.messageicon)

                        } else if (savedMessages.isItNewMessage == false) {

                            redMsgIcon.setImageResource(R.drawable.redmsgicon)

                        }





                    }
                }
            }


















        Timer().scheduleAtFixedRate( object : TimerTask() {
                override fun run () {

                    if (moneyTaxAmount < maximumCapacity) {
                        moneyTaxAmount += 100000
                    }

                    if (resoursesCollectedAmount < maximumCapacity) {
                        resoursesCollectedAmount += 100000
                    }


                }
            }, 0, 1000)





        redMsgIcon.setOnClickListener {



            var newMessage = messages(messageContent = savedMessages.messageContent, isItNewMessage = false)



            database.collection("users").document("User path").collection("Messages")
                .document("MessageDocument").set(newMessage)


                .addOnCompleteListener {



                }

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
            moneyTaxAmount = 0

            savePlayerData()


        }







        galaxyView.setOnClickListener {


            generateAlienCivilisations()


            var isThereGeneralMessage = (1..7).shuffled().last()

            if (isThereGeneralMessage == 1) {
                sendGeneralMessage()

            }


            val intent = Intent(this, GalaxyViewActivity :: class.java)
            startActivity(intent)

        }





    }





















    override fun onBackPressed() {

        Toast.makeText(this, "This action is not allowed", Toast.LENGTH_SHORT).show()

    }







    fun savePlayerData() {





        var data = playerData(savedMoneyAmount = moneyAmount, savedResoursesAmount = resoursesAmount,
            savedLevelInfrastructure = levelInfrastructure, savedLevelFactory = levelFactory, savedLevelMilitaryBase= levelMilitaryBase,
            savedLevelGeneralDevelopment = levelGeneralDevelopment, savedLevelScienficResearch = levelScientificDevelopment,
            savedLevelSpionage = levelSpionage, savedSoldierUnitQuantity = soldierQuantity, savedAirplaneUnitQuantity = airplaneQuantity,
            savedCargoPlaneQuantity = cargoplaneQuantity, savedAirplane2UnitQuantity= airplane2Quantity, savedTankUnitQuantity= tankQuantity,
            savedSateliteUnitQuantity= sateliteQuantity)



        database.collection("users").document("User path").collection("Saved data")
            .document("hmkogjk").set(data)


            .addOnCompleteListener {



            }
    }








    fun sendGeneralMessage() {



        var chooseMessage = (1..3).shuffled().last()
        var messageText = ""



        if (chooseMessage == 1) {
            messageText = "Zorgon have devastated a planet"
        } else if (chooseMessage == 2) {
            messageText = "You colonized a planet"
        } else if (chooseMessage == 3) {
            messageText = "Somebody wants to ally with you"
        }



        var newMessage = messages(messageContent = messageText, isItNewMessage = true)



        database.collection("users").document("User path").collection("Messages")
            .document("MessageDocument").set(newMessage)


            .addOnCompleteListener {



            }







    }













   fun generateAlienCivilisations() {

       var dataOfAlienCivilisations = aliens(nameAlienRace1 = AlienCiv1Name, nameAlienRace2 = AlienCiv2Name)




       if (dataOfAlienCivilisations.nameAlienRace1 == null) {



           // Generating random alien civilisations


           var randomNumString1 = (1..3).shuffled().last()  //random number from 1 to 3
           var randomNumString2 = (1..3).shuffled().last()


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





           // Choosing a picture for every alien civilisation

           var randomNumber1 = (1..4).shuffled().last()
           var randomNumber2 = (1..4).shuffled().last()






           // Selecting level military base for every alien civilisation

           var randomMilitaryBaseAlien1 = (1..5).shuffled().last()
           var randomMilitaryBaseAlien2 = (1..5).shuffled().last()


          var  randomMilitaryBaseAlien1Double = randomMilitaryBaseAlien1.toDouble()
          var  randomMilitaryBaseAlien2Double = randomMilitaryBaseAlien2.toDouble()



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














           // Inserting values to every alien civilisation


           dataOfAlienCivilisations = aliens(nameAlienRace1 = AlienCiv1Name, pictureAlienRace1 = randomNumber1,
               soldiersAlienRace1 = AlienCiv1Soldiers, spacePlanesAlienRace1 = AlienCiv1SpacePlanes,
               spaceJetsAlienRace1 = AlienCiv1SpaceJets, tanksAlienRace1 = AlienCiv1Tanks,
               nuclearSatelitesAlienRace1 = AlienCiv1NuclearSatelites,  militaryBaseAlienRace1 = randomMilitaryBaseAlien1Double,

               /*Alien civilisation 1 aspects written*/

               nameAlienRace2 = AlienCiv2Name, pictureAlienRace2 = randomNumber2,
               soldiersAlienRace2 = AlienCiv2Soldiers, spacePlanesAlienRace2 = AlienCiv2SpacePlanes,
               spaceJetsAlienRace2 = AlienCiv2SpaceJets, tanksAlienRace2 = AlienCiv2Tanks,
               nuclearSatelitesAlienRace2 = AlienCiv2NuclearSatelites, militaryBaseAlienRace2 = randomMilitaryBaseAlien2Double

               /*Alien civilisation 2 aspects written*/)






           // Saving generated data of alien civilisations


           database.collection("users").document("User path").collection("Saved aliens data")
               .document("Aliens data").set(dataOfAlienCivilisations)


               .addOnCompleteListener {



               }

       }


    }





















}