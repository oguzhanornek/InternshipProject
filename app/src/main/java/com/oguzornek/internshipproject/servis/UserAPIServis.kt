package com.oguzornek.internshipproject.servis

import com.oguzornek.internshipproject.model.Kullanicilar
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class UserAPIServis {

    private val BASE_URL = "http://jsonplaceholder.typicode.com"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(UserAPI::class.java)

    fun getData() : Call<List<Kullanicilar>>{
        return api.getKullanici()
    }
}