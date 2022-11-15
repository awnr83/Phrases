package com.moappdev.phrases.data

import com.moappdev.phrases.data.model.QuoteModel
import com.moappdev.phrases.data.model.QuoteProvider
import com.moappdev.phrases.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository  {
    private val api= QuoteService()

    suspend fun getQuote(): QuoteModel? {
        val response= api.getQuote()
        response?.let {
            //se almacena localmente
            QuoteProvider.qoutes.add(response)
        }
        return response
    }
}