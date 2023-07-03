package com.example.dummyfetch

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface DummyApiService {
    @GET("users")
    fun getDummyData(): Call<ApiResponse>
}

data class ApiResponse(
    val users: List<DummyData>
)