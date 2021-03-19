package com.oguzornek.internshipproject.servis

import com.oguzornek.internshipproject.model.Post
import com.oguzornek.internshipproject.view.UserChooseFragment
import com.oguzornek.internshipproject.view.UserChooseFragmentArgs
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostAPIServis {

    val alinanID = UserChooseFragment().args.userId
    private val BASE_URL = "http://jsonplaceholder.typicode.com"
    private val api2 = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PostAPI::class.java)

    fun getData() : Call<List<Post>> {
        return api2.getPosts(alinanID)
    }
}