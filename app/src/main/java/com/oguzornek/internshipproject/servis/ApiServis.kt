package com.oguzornek.internshipproject.servis

import com.oguzornek.internshipproject.model.Users
import com.oguzornek.internshipproject.model.Photos
import com.oguzornek.internshipproject.model.Post
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiServis {

    private val BASE_URL = "http://jsonplaceholder.typicode.com"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(Api::class.java)

    fun getData() : Call<List<Users>> {
        return api.getKullanici()
    }
    fun getData(alinanId : Int) : Call<List<Post>> {
        return api.getPosts(alinanId)
    }

    fun getDataPtohos(photoId: Int) : Call<List<Photos>>{
        return api.getPhotos(photoId)
    }
}