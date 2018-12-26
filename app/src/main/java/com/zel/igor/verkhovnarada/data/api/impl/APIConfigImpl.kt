package com.zel.igor.verkhovnarada.data.api.impl

import com.zel.igor.verkhovnarada.data.api.APIConfig

class APIConfigImpl : APIConfig {
    override fun baseUrl(): String {
        return "https://www.chesno.org"
    }
}