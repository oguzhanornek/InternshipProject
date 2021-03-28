package com.oguzornek.internshipproject.servis

import com.oguzornek.internshipproject.model.Users
import com.oguzornek.internshipproject.model.Photos
import com.oguzornek.internshipproject.model.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api
{
    @GET("/posts")
    fun getPosts(@Query("userId") userId : Int) : Call<List<Post>>

    @GET("/users")
    fun getKullanici():Call<List<Users>>

    @GET("/photos")
    fun getPhotos(@Query("photoId") photoId : Int): Call<List<Photos>>

}