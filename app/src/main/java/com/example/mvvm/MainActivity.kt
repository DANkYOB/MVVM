package com.example.mvvm

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //MVVM (Model View View Model Architecture)
    //MVC, MVP

    /**
     * MVVM
     *
     * Model - Data Class, (POJO Class), (Getter, Setter)
     * View - UIs
     *
     * ViewModel -
     * 1. Data sustains even after activity/fragment recreates
     * 2. Better code
     * 3. Don't refer view/context in viewmodel
     *
     * ** Always use different view model for different screens
     *
     * Repository
     *
     * LiveData
     *
     * Context -
     * 1. Application context
     * 2. Activity context
     *
     *
     *
     *
     */

    private lateinit var binding: ActivityMainBinding

    private val viewModel by lazy {
        ViewModelProvider(this)[MainActivityViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("onCreate", "onCreate")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        val navController = navHostFragment.navController

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy", "onDestroy")
    }

}