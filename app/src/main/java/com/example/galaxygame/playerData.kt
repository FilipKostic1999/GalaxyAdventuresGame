package com.example.galaxygame


import com.google.firebase.firestore.DocumentId

data class playerData(@DocumentId var DocumentId: String? = null, var savedMoneyAmount : Int = 0,
                      var savedResoursesAmount : Int = 0, var savedLevelInfrastructure : Int = 1,
var savedLevelFactory : Int = 1, var savedLevelMilitaryBase : Int = 1, var savedLevelGeneralDevelopment : Int = 1,
var savedLevelScienficResearch : Int = 1, var savedLevelSpionage : Int = 1, var savedSoldierUnitQuantity : Double = 100.0,
var savedAirplaneUnitQuantity : Double = 40.0, var savedCargoPlaneQuantity : Double = 10.0, var savedAirplane2UnitQuantity : Double = 0.0,
var savedTankUnitQuantity : Double = 0.0, var savedSateliteUnitQuantity : Double = 0.0, var isDamagedAlive : Double = 2.0)





