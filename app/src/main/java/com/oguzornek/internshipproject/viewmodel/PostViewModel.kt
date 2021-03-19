package com.oguzornek.internshipproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.oguzornek.internshipproject.model.Post
import com.oguzornek.internshipproject.servis.PostAPIServis
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostViewModel : ViewModel() {
    private val apiServis = PostAPIServis()

    val postlar = MutableLiveData<List<Post>>()

    fun getPost(alinanId : Int){
       val response = apiServis.getData(alinanId)

        response.enqueue(object  : Callback<List<Post>>{
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {

                if (response.isSuccessful){
                    postlar.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {

            }

        })



    }



}


