package com.oguzornek.internshipproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.oguzornek.internshipproject.model.Users
import com.oguzornek.internshipproject.servis.ApiServis
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserListViewModel: ViewModel() {
    private val userAPIServis = ApiServis()

    val users = MutableLiveData<List<Users>>()

    fun getUserData(){
       val response =  userAPIServis.getData()

        response.enqueue(object : Callback<List<Users>>{
            override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {

                if( response.isSuccessful){
                    users.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<Users>>, t: Throwable) {

            }


        })}

}