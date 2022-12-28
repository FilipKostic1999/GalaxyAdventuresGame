package com.example.galaxygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout

class VisitAlienPlanetActivity : AppCompatActivity() {




    lateinit var visitAlienWorldLayout : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visit_alien_planet)


        visitAlienWorldLayout = findViewById(R.id.visitAlienWorldLayout)



        val sharedSelectedPlanet = getSharedPreferences("SelectedPlanet", AppCompatActivity.MODE_PRIVATE)
        var SelectedPlanet = sharedSelectedPlanet.getInt("SelectedPlanet", 0)




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