package com.example.galaxygame

import com.google.firebase.firestore.DocumentId

data class aliens(@DocumentId var DocumentId: String? = null, var nameAlienRace1: String? = null,
                  var pictureAlienRace1 : Int? = null, var soldiersAlienRace1 : Double? = null,
                  var spacePlanesAlienRace1 : Double? = null, var spaceJetsAlienRace1 : Double? = null,
                  var tanksAlienRace1 : Double? = null, var nuclearSatelitesAlienRace1 : Double? = null,
                  var militaryBaseAlienRace1 : Double? = null, var isAlienRace1Damaged : Double? = null,
                  var alienRace1RelationWithPlayer : Double? = null, /* first Alien Is Set */

                  var nameAlienRace2: String? = null,
                  var pictureAlienRace2 : Int? = null, var soldiersAlienRace2 : Double? = null,
                  var spacePlanesAlienRace2 : Double? = null, var spaceJetsAlienRace2 : Double? = null,
                  var tanksAlienRace2 : Double? = null, var nuclearSatelitesAlienRace2 : Double? = null,
                  var militaryBaseAlienRace2 : Double? = null, var isAlienRace2Damaged : Double? = null,
                  var alienRace2RelationWithPlayer : Double? = null, /* second Alien Is Set */

                  var nameAlienRace3: String? = null,
                  var pictureAlienRace3 : Int? = null, var soldiersAlienRace3 : Double? = null,
                  var spacePlanesAlienRace3 : Double? = null, var spaceJetsAlienRace3 : Double? = null,
                  var tanksAlienRace3 : Double? = null, var nuclearSatelitesAlienRace3 : Double? = null,
                  var militaryBaseAlienRace3 : Double? = null, var isAlienRace3Damaged : Double? = null,
                  var alienRace3RelationWithPlayer : Double? = null, /* Alien 3 */

                  var nameAlienRace4: String? = null,
                  var pictureAlienRace4 : Int? = null, var soldiersAlienRace4 : Double? = null,
                  var spacePlanesAlienRace4 : Double? = null, var spaceJetsAlienRace4 : Double? = null,
                  var tanksAlienRace4 : Double? = null, var nuclearSatelitesAlienRace4 : Double? = null,
                  var militaryBaseAlienRace4 : Double? = null, var isAlienRace4Damaged : Double? = null,
                  var alienRace4RelationWithPlayer : Double? = null, /* alien 4 */

                  var nameAlienRace5: String? = null,
                  var pictureAlienRace5 : Int? = null, var soldiersAlienRace5 : Double? = null,
                  var spacePlanesAlienRace5 : Double? = null, var spaceJetsAlienRace5 : Double? = null,
                  var tanksAlienRace5 : Double? = null, var nuclearSatelitesAlienRace5 : Double? = null,
                  var militaryBaseAlienRace5 : Double? = null, var isAlienRace5Damaged : Double? = null,
                  var alienRace5RelationWithPlayer : Double? = null, /* alien 5 */

                  var nameAlienRace6: String? = null,
                  var pictureAlienRace6 : Int? = null, var soldiersAlienRace6 : Double? = null,
                  var spacePlanesAlienRace6 : Double? = null, var spaceJetsAlienRace6 : Double? = null,
                  var tanksAlienRace6 : Double? = null, var nuclearSatelitesAlienRace6 : Double? = null,
                  var militaryBaseAlienRace6 : Double? = null, var isAlienRace6Damaged : Double? = null,
                  var alienRace6RelationWithPlayer : Double? = null, /* alien 6 */

                  var nameAlienRace7: String? = null,
                  var pictureAlienRace7 : Int? = null, var soldiersAlienRace7 : Double? = null,
                  var spacePlanesAlienRace7 : Double? = null, var spaceJetsAlienRace7 : Double? = null,
                  var tanksAlienRace7 : Double? = null, var nuclearSatelitesAlienRace7 : Double? = null,
                  var militaryBaseAlienRace7 : Double? = null, var isAlienRace7Damaged : Double? = null,
                  var alienRace7RelationWithPlayer : Double? = null, /* alien 7 */

                  var nameAlienRace8: String? = null,
                  var pictureAlienRace8 : Int? = null, var soldiersAlienRace8 : Double? = null,
                  var spacePlanesAlienRace8 : Double? = null, var spaceJetsAlienRace8 : Double? = null,
                  var tanksAlienRace8 : Double? = null, var nuclearSatelitesAlienRace8 : Double? = null,
                  var militaryBaseAlienRace8 : Double? = null, var isAlienRace8Damaged : Double? = null,
                  var alienRace8RelationWithPlayer : Double? = null, /* alien 8 */

                  var nameAlienRace9: String? = null,
                  var pictureAlienRace9 : Int? = null, var soldiersAlienRace9 : Double? = null,
                  var spacePlanesAlienRace9 : Double? = null, var spaceJetsAlienRace9 : Double? = null,
                  var tanksAlienRace9 : Double? = null, var nuclearSatelitesAlienRace9 : Double? = null,
                  var militaryBaseAlienRace9 : Double? = null, var isAlienRace9Damaged : Double? = null,
                  var alienRace9RelationWithPlayer : Double? = null, /* alien 9 */

                  var nameAlienRace10: String? = null,
                  var pictureAlienRace10 : Int? = null, var soldiersAlienRace10 : Double? = null,
                  var spacePlanesAlienRace10 : Double? = null, var spaceJetsAlienRace10 : Double? = null,
                  var tanksAlienRace10 : Double? = null, var nuclearSatelitesAlienRace10 : Double? = null,
                  var militaryBaseAlienRace10 : Double? = null, var isAlienRace10Damaged : Double? = null,
                  var alienRace10RelationWithPlayer : Double? = null, /* alien 10 */

                  var nameAlienRace11: String? = null,
                  var pictureAlienRace11 : Int? = null, var soldiersAlienRace11 : Double? = null,
                  var spacePlanesAlienRace11 : Double? = null, var spaceJetsAlienRace11 : Double? = null,
                  var tanksAlienRace11 : Double? = null, var nuclearSatelitesAlienRace11 : Double? = null,
                  var militaryBaseAlienRace11 : Double? = null, var isAlienRace11Damaged : Double? = null,
                  var alienRace11RelationWithPlayer : Double? = null, /* alien 11 */

                  var nameAlienRace12: String? = null,
                  var pictureAlienRace12 : Int? = null, var soldiersAlienRace12 : Double? = null,
                  var spacePlanesAlienRace12 : Double? = null, var spaceJetsAlienRace12 : Double? = null,
                  var tanksAlienRace12 : Double? = null, var nuclearSatelitesAlienRace12 : Double? = null,
                  var militaryBaseAlienRace12 : Double? = null, var isAlienRace12Damaged : Double? = null,
                  var alienRace12RelationWithPlayer : Double? = null, /* alien 12 */

                  var nameAlienRace13: String? = null,
                  var pictureAlienRace13 : Int? = null, var soldiersAlienRace13 : Double? = null,
                  var spacePlanesAlienRace13 : Double? = null, var spaceJetsAlienRace13 : Double? = null,
                  var tanksAlienRace13 : Double? = null, var nuclearSatelitesAlienRace13 : Double? = null,
                  var militaryBaseAlienRace13 : Double? = null, var isAlienRace13Damaged : Double? = null,
                  var alienRace13RelationWithPlayer : Double? = null, /* alien 13 */

                  var nameAlienRace14: String? = null,
                  var pictureAlienRace14 : Int? = null, var soldiersAlienRace14 : Double? = null,
                  var spacePlanesAlienRace14 : Double? = null, var spaceJetsAlienRace14 : Double? = null,
                  var tanksAlienRace14 : Double? = null, var nuclearSatelitesAlienRace14 : Double? = null,
                  var militaryBaseAlienRace14 : Double? = null, var isAlienRace14Damaged : Double? = null,
                  var alienRace14RelationWithPlayer : Double? = null, /* alien 14 */

                  var nameAlienRace15: String? = null,
                  var pictureAlienRace15 : Int? = null, var soldiersAlienRace15 : Double? = null,
                  var spacePlanesAlienRace15 : Double? = null, var spaceJetsAlienRace15 : Double? = null,
                  var tanksAlienRace15 : Double? = null, var nuclearSatelitesAlienRace15 : Double? = null,
                  var militaryBaseAlienRace15 : Double? = null, var isAlienRace15Damaged : Double? = null,
                  var alienRace15RelationWithPlayer : Double? = null, /* alien 15 */

                  var nameAlienRace16: String? = null,
                  var pictureAlienRace16 : Int? = null, var soldiersAlienRace16 : Double? = null,
                  var spacePlanesAlienRace16 : Double? = null, var spaceJetsAlienRace16 : Double? = null,
                  var tanksAlienRace16 : Double? = null, var nuclearSatelitesAlienRace16 : Double? = null,
                  var militaryBaseAlienRace16 : Double? = null, var isAlienRace16Damaged : Double? = null,
                  var alienRace16RelationWithPlayer : Double? = null /* alien 16 */)