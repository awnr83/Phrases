package com.moappdev.phrases.data.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitHelper {
    fun getRetrofit():Retrofit{
        val moshi= Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val retrofit= Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl("https://api.kanye.rest")
            .build()

        return retrofit
    }
}