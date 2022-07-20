package com.solulab.example

import RetrofitApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object Config {

    private var retrofitApi: RetrofitApi? = null
    private var retrofit: Retrofit? = null
    //Here we are using the GsonConverterFactory to directly convert json data to object

    //creating the api interface
    fun getRetroFitApi(): RetrofitApi? {

        if (retrofitApi == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(RetrofitApi.Companion.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .client(getLoggingInterceptor()!!)
                .build()

            //creating the api interface
            retrofitApi = retrofit!!.create(RetrofitApi::class.java)
        }

        return retrofitApi
    }

    fun getLoggingInterceptor(): OkHttpClient? {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }


}