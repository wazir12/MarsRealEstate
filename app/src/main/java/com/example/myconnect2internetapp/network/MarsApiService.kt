package com.example.myconnect2internetapp.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://mars.udacity.com/"


/**
 * Build the Moshi object that Retrofit will be using, making sure to add the Kotlin adapter for
 * full Kotlin compatibility.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * Use the Retrofit builder to build a retrofit object using a Moshi converter with our Moshi
 * object.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()


/**Creating  a MarsApiService interface, that defines a getProperties() method to request the JSON response string.
        **Annotate the method with @GET to specify the endpoint for the JSON real estate response
        * and  than create the Retrofit Call object that will start the HTTP request.
      */

interface MarsApiService {

    /**
     * Returns a Retrofit callback that delivers a [List] of [MarsProperty]
     * The @GET annotation indicates that the "realestate" endpoint will be requested with the GET
     * HTTP method
     */
    @GET("realestate")
    fun getProperties():
    // The Coroutine Call Adapter allows us to return a Deferred, a Job with a result
            Deferred<List<MarsProperty>>
}
/**
* Passing in the service API you just defined,
* create a public object called MarsApi to expose the Retrofit service to the rest of the app:
* */

object MarsApi {
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}