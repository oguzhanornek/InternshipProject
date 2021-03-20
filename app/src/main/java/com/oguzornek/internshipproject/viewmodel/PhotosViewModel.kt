package com.oguzornek.internshipproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.oguzornek.internshipproject.model.Photos
import com.oguzornek.internshipproject.servis.ApiServis
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhotosViewModel : ViewModel() {

    private val api = ApiServis()

    val photos = MutableLiveData<List<Photos>>()

    fun getPhotos(photoId : Int){
        val response = api.getDataPtohos(photoId)

        response.enqueue(object : Callback<List<Photos>>{
            override fun onResponse(call: Call<List<Photos>>, response: Response<List<Photos>>) {
               if (response.isSuccessful){
                   photos.value = response.body()
               }
            }

            override fun onFailure(call: Call<List<Photos>>, t: Throwable) {

            }

        })


    }
}