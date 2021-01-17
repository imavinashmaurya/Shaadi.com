package com.avinash.shaadi.api

object APICalling {

    fun apiCall(): APIServices {
        return RetrofitClient.getNormalClient(
            APIConstants.domain
        )!!.create<APIServices>(
            APIServices::class.java)
    }
}