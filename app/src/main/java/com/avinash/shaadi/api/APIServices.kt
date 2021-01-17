package com.avinash.shaadi.api

import com.avinash.shaadi.data.model.MainResponse
import retrofit2.Response
import retrofit2.http.GET


interface APIServices {
    @GET("api/?results=10")
    suspend fun getUserData(): Response<MainResponse>
}

