package com.example.fitnessjust4you


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class AppActivity : AppCompatActivity() {

    lateinit var bottomNav : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)

        //val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)  as NavHostFragment
        //val navController = navHostFragment.navController

        //val navController = findNavController(R.id.nav_graph_app)

        //val navView: BottomNavigationView = findViewById(R.id.buttomnavbar)

        //navView.setupWithNavController(navController)

        loadFragment(HomeFragment())
        bottomNav = findViewById(R.id.buttomnavbar) as BottomNavigationView
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navbar_home_button -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.navbar_profile_button -> {
                    loadFragment(ProfileFragment())
                    true
                }
                R.id.navbar_training_button -> {
                    loadFragment(TrainingOVFragment())
                    true
                }
                else -> {false}
            }
        }
    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host_fragment,fragment)
        transaction.commit()
    }

    }
