package com.avinash.shaadi.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitClient {

    private var retrofit: Retrofit? = null

    private var gson = GsonBuilder()
        .serializeNulls()
        .serializeSpecialFloatingPointValues()
        .setLenient()
        .create()


    fun getNormalClient(baseUrl: String): Retrofit? {
        if (retrofit == null) {
            val client = OkHttpClient.Builder()
                .readTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .build()
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }
        return retrofit
    }

}