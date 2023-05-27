package com.example.core.exception

import java.io.IOException

sealed class AppException(message: String?) : IOException(message) {
    class ConnectivityException(message: String?) : AppException(message)
    class NetworkException(message: String?) : AppException(message)
}