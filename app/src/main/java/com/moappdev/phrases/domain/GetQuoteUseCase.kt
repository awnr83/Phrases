package com.moappdev.phrases.domain

import com.moappdev.phrases.data.QuoteRepository
import com.moappdev.phrases.data.model.QuoteModel
import javax.inject.Inject

class GetQuoteUseCase {
    private val repository= QuoteRepository()

    suspend operator fun invoke(): QuoteModel?{
        return repository.getQuote()
    }
}