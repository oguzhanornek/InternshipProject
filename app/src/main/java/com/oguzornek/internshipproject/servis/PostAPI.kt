package com.oguzornek.internshipproject.servis

import com.oguzornek.internshipproject.model.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PostAPI {

    @GET("/posts")
    fun getPosts(@Query("userId") userId : Int) : Call<List<Post>>
}