package com.moappdev.phrases.data.network

import com.moappdev.phrases.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("/")
    suspend fun getQoute():Response<QuoteModel>
}