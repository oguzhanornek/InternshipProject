package com.oguzornek.internshipproject.servis

import com.oguzornek.internshipproject.model.Kullanicilar
import retrofit2.Call
import retrofit2.http.GET

interface UserAPI {

    @GET("/users")
    fun getKullanici():Call<List<Kullanicilar>>
}