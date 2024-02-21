package com.example.mainapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.findmyip.retrofit.ApiHelper
import com.example.findmyip.retrofit.RetrofitBuilder
import com.example.mainapp.screen.HomeScreen
import com.example.mainapp.ui.theme.MyApplicationTheme
import com.example.mainapp.viewmodel.MainViewModel
import com.example.mainapp.viewmodel.ViewModelFactory

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setupViewModel()

        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        HomeScreen(viewModel)
                    }
                }
            }
        }
    }

    private fun setupViewModel() {
        val viewModelFactory = ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
    }
}

