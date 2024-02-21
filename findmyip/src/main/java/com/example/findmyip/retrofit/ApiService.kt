package com.example.findmyip.retrofit

import com.example.findmyip.model.ComputerDetails
import retrofit2.Response
import retrofit2.http.GET

interface  ApiService {
    @GET("/json/")
    suspend fun getUsers(): Response<ComputerDetails>
}