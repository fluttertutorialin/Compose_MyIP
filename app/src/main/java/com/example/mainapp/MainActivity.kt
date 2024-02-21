package com.example.mainapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.mainapp.screen.HomeScreen
import com.example.mainapp.ui.theme.MyApplicationTheme
import com.example.mainapp.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    //private val viewModel: MainViewModel by viewModels()
    //private lateinit var viewModel: MainViewModel
    private val viewModel: MainViewModel by viewModels { MainViewModel.Factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //setupViewModel()

        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen(viewModel)
                }
            }
        }
    }

    //ViewModelFactory is class to instantiate and return ViewModel
    /*private fun setupViewModel() {
        val viewModelFactory = ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
    }*/
}

