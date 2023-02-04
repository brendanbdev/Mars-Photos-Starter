package com.example.marsphotos.network

import retrofit2.Retrofit
import retrofit2.http.GET
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType

private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
    .baseUrl(BASE_URL)
    .build()

interface MarsApiService {
    /*
    Use the @GET annotation to tell Retrofit that this is a GET request and
    specify an endpoint for that web service method. In this case, the endpoint
    is "photos", as in /photos, which will be appended to the base URL.
    */
    @GET("photos")
    /*
    Make getPhotos() a suspend function to make it asynchronous and not block
    the calling thread. You call this function from inside a viewModelScope.
    */
    suspend fun getPhotos(): List<MarsPhoto>
}

object MarsApi {
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}
