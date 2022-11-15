package com.moappdev.phrases.data.network

import com.moappdev.phrases.data.model.QuoteModel
import com.moappdev.phrases.di.NetworkModule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class QuoteService {
    private val retrofit= RetrofitHelper.getRetrofit()

    suspend fun getQuote(): QuoteModel? {
        return withContext(Dispatchers.IO){
            val response : Response<QuoteModel> = retrofit.create(QuoteApiClient::class.java).getQoute() //api.getQoute()
            response.body()
        }
    }
}