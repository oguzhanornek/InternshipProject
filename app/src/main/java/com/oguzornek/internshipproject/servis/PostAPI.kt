package com.oguzornek.internshipproject.servis

import com.oguzornek.internshipproject.model.Post
import retrofit2.Call
import retrofit2.http.GET

interface PostAPI {

    @GET("/posts")
    fun getPosts() : Call<List<Post>>
}