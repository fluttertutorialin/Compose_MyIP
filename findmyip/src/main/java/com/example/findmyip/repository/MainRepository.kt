package com.example.findmyip.repository
import com.example.findmyip.retrofit.ApiHelper

class MainRepository(private val apiService: ApiHelper) {
    suspend fun getUsers() = apiService.getUsers()
}