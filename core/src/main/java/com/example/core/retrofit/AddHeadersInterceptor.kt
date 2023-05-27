package com.example.core.retrofit

import okhttp3.Interceptor
import okhttp3.Response

class AddHeadersInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = request.newBuilder()

        builder.addHeader("Content-Type", "application/json;charset=UTF-8")

        val newRequest = builder.build()
        return chain.proceed(newRequest)
    }
}