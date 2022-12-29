package com.example.galaxygame

import com.google.firebase.firestore.DocumentId

data class aliens(@DocumentId var DocumentId: String? = null, var nameAlienRace1: String? = null,
                  var pictureAlienRace1 : Int? = null, var soldiersAlienRace1 : Double? = null,
                  var spacePlanesAlienRace1 : Double? = null, var spaceJetsAlienRace1 : Double? = null,
                  var tanksAlienRace1 : Double? = null, var nuclearSatelitesAlienRace1 : Double? = null,
                  var militaryBaseAlienRace1 : Double? = null, /* first Alien Is Set */

                  var nameAlienRace2: String? = null,
                  var pictureAlienRace2 : Int? = null, var soldiersAlienRace2 : Double? = null,
                  var spacePlanesAlienRace2 : Double? = null, var spaceJetsAlienRace2 : Double? = null,
                  var tanksAlienRace2 : Double? = null, var nuclearSatelitesAlienRace2 : Double? = null,
                  var militaryBaseAlienRace2 : Double? = null, /* second Alien Is Set */)

