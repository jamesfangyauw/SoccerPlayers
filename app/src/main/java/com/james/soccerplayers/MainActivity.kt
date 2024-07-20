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
    var master6 = 6


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


    }

}