package com.example.core.retrofit

import com.example.core.exception.AppException
import okhttp3.Interceptor
import okhttp3.Response

class ExceptionInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        return try {
            val request = chain.request()
            val response = chain.proceed(request)
            throwExceptionWhenResponseIsNotSuccessful(response)
            response
        } catch (e: Exception) {
            when (e) {
                is AppException.NetworkException -> {
                    throw AppException.NetworkException(e.message)
                }
                is AppException.ConnectivityException -> {
                    throw AppException.ConnectivityException(e.message)
                }
                else -> {
                    throw AppException.NetworkException(e.message)
                }
            }
        }
    }

    private fun throwExceptionWhenResponseIsNotSuccessful(response: Response) {
        if (!response.isSuccessful) {
            throw AppException.NetworkException(response.message)
        }
    }
}