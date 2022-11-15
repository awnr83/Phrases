package com.moappdev.phrases.di

import com.moappdev.phrases.data.model.QuoteModel
import com.moappdev.phrases.data.network.QuoteApiClient
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import javax.inject.Singleton

//se define el alcance a toda la aplicacion
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    //para que cree una sola y use esa
    @Singleton
    @Provides
    fun providerRetrofit():Retrofit{
        val moshi= Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl("https://api.kanye.rest")
            .build()
    }

    //todo para poder proveer la interfaz
    @Singleton
    @Provides
    fun providerQuoteApiClient(retrofit: Retrofit):QuoteApiClient {
        return retrofit.create(QuoteApiClient::class.java)
    }
}