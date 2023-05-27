package com.example.core.retrofit

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.example.core.R
import com.example.core.exception.AppException
import com.example.core.utils.StringProvider
import okhttp3.Interceptor
import okhttp3.Response

class ConnectivityInterceptor(
    private val context: Context,
    private val stringProvider: StringProvider
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isNetworkAvailable()) {
            throw AppException.ConnectivityException(stringProvider.getString(R.string.error_connectivity))
        }

        val httpUrlBuilder = chain
            .request()
            .url
            .newBuilder()

        val httpUrl = httpUrlBuilder.build()
        return chain.proceed(chain.request().newBuilder().url(httpUrl).build())
    }

    @SuppressLint("MissingPermission")
    private fun isNetworkAvailable(): Boolean {
        (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).apply {
            return getNetworkCapabilities(activeNetwork)?.run {
                when {
                    hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                    hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                    hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                    else -> false
                }
            } ?: false
        }
    }
}