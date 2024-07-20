package com.james.soccerplayers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.james.soccerplayers.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    var test = 1
    var test2  = 2
    var test3 = 3
    var test4 = 4
    var test5 = 5
    var master5 = 5
    var test6 = 6
    var master6 = 6
    var test7 = 7
    var master7 = 7
    var test8 = 8
    var test9 = 9
    var master8 = 8
    var master9 = 9
    var master10 = 10
    var test10 = 10
    var test11 = 11
    var feature1 =1
    var feature2= 2
    var feature3 = 3
    var feature4 = 4
    var master11 = 11
    var master12 = 12
    var master13 = 13


    var test3 =3

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)


        val navigationHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        val navigationController = navigationHostFragment.navController

        activityMainBinding.bottomNav.setupWithNavController(navigationController)

        var master1 = 1
        var master2 = 2
        var master3 = 3
        var master4 = 4


    }

}