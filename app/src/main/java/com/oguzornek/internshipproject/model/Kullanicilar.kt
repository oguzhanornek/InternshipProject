package com.oguzornek.internshipproject.model

import com.google.gson.annotations.SerializedName

data class Kullanicilar(
    @SerializedName("id")
    val userId : Int? ,
    @SerializedName("username")
    val kullaniciAdi : String?,
    @SerializedName("name")
    val isim:String?,
    @SerializedName("email")
    val kullaniciMail : String?



    




) {}
