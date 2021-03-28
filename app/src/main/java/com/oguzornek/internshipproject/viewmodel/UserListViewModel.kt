package com.oguzornek.internshipproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.oguzornek.internshipproject.model.Kullanicilar
import com.oguzornek.internshipproject.servis.ApiServis
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserListViewModel: ViewModel() {
    private val userAPIServis = ApiServis()

    val kullancilar = MutableLiveData<List<Kullanicilar>>()

    fun verileriCek(){
       val response =  userAPIServis.getData()

        response.enqueue(object : Callback<List<Kullanicilar>>{
            override fun onResponse(call: Call<List<Kullanicilar>>, response: Response<List<Kullanicilar>>) {

                if( response.isSuccessful){
                    kullancilar.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<Kullanicilar>>, t: Throwable) {

            }


        })}

}