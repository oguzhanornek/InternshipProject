package com.oguzornek.internshipproject.model

import com.google.gson.annotations.SerializedName

data class Users(
    @SerializedName("id")
    val userId : Int? ,
    @SerializedName("username")
    val userName : String?,
    @SerializedName("name")
    val name:String?,
    @SerializedName("email")
    val userMail : String?



    




) {}
