package com.myprojects.myrecipeapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

val retrofit: Retrofit = Retrofit.Builder().baseUrl("www.themealdb.com/api/json/v1/1")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val retrofitService: ApiService = retrofit.create(ApiService::class.java)
interface ApiService {
    @GET("categories.php")
    fun getCategories(): CategoriesResponse
}