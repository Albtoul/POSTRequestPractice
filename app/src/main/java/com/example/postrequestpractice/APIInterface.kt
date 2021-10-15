package com.example.postrequestpractice


import android.widget.EditText
import retrofit2.Call
import retrofit2.http.*


interface APIInterface {
    @Headers("Content-Type: application/json")
    @GET("/test/")
     fun getUser(): Call<List<Users.UserDetails>>


    @Headers("Content-Type: application/json")
    @POST("/test/")
     fun addUser(@Body userData: Users.UserDetails): Call<Users.UserDetails>

    @Headers("Content-Type: application/json")
    @POST("/test/{id}")
    abstract fun update(id: Int, f: Users.UserDetails): Call<Users.UserDetails>

    @Headers("Content-Type: application/json")
    @POST("/test/{id}")
     fun delete(@Path("id") id: EditText):Call<Void>



}