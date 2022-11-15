package com.moappdev.phrases.data.model

import com.google.gson.annotations.SerializedName

data class QuoteModel (
    @SerializedName("quote")
    val quote:String,
    val author:String?="Anonimus"
)
