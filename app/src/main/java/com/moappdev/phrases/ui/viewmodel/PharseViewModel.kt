package com.moappdev.phrases.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moappdev.phrases.data.model.QuoteModel
import com.moappdev.phrases.data.model.QuoteProvider
import com.moappdev.phrases.domain.GetQuoteUseCase
import com.moappdev.phrases.domain.GetRandomQuoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


class PharseViewModel:ViewModel() {
    private var quotes= GetQuoteUseCase() //invoca directamente a la funcion invoke
    private var quoteRandom= GetRandomQuoteUseCase()

    val pharse=MutableLiveData<QuoteModel>()
    val is_loading=MutableLiveData<Boolean>(false)


    fun onCreate(){
        viewModelScope.launch {
            is_loading.postValue(true)
            (0..11).forEach {
                quotes()
            }
            randomQuote()
            is_loading.postValue(false)
        }
    }
    fun randomQuote(){
        is_loading.postValue(true)
        val result= quoteRandom()
        result?.let{
            pharse.postValue(it)
            is_loading.postValue(false)
        }
    }
}