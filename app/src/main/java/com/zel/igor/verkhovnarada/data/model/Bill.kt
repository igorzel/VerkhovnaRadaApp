package com.zel.igor.verkhovnarada.data.model

data class Bill(
    val number: String,
    val title: String,
    val status: BillConsiderationState,
    val url: String
)
