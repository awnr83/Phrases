package com.moappdev.phrases.domain

import com.moappdev.phrases.data.QuoteRepository
import com.moappdev.phrases.data.model.QuoteModel
import com.moappdev.phrases.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase {

    operator fun invoke():QuoteModel?{
        val quotes = QuoteProvider.qoutes
        return if(!quotes.isEmpty()){
            quotes.random()
        }else
            null
    }
}