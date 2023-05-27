package com.example.afeela.di.module

import android.content.Context
import com.example.afeela.BuildConfig
import com.serjltt.moshi.adapters.Wrapped
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.example.core.retrofit.AddHeadersInterceptor
import com.example.core.retrofit.ConnectivityInterceptor
import com.example.core.retrofit.ExceptionInterceptor
import com.example.core.utils.StringProvider
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

@Module
class RetrofitModule {
    companion object {
        private const val TIMEOUT = 30L

        @Provides
        fun provideLoggingInterceptor(): HttpLoggingInterceptor {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.BASIC
            return loggingInterceptor
        }

        @Provides
        fun provideConnectivityInterceptor(
            context: Context,
            stringProvider: StringProvider,
        ): ConnectivityInterceptor =
            ConnectivityInterceptor(context = context, stringProvider = stringProvider)

        @Provides
        fun provideAuthorizationInterceptor(): AddHeadersInterceptor =
            AddHeadersInterceptor()

        @Provides
        fun provideExceptionInterceptor(): ExceptionInterceptor =
            ExceptionInterceptor()

        @Provides
        fun provideHttpClient(
            connectivityInterceptor: ConnectivityInterceptor,
            loggingInterceptor: HttpLoggingInterceptor,
            addHeadersInterceptor: AddHeadersInterceptor,
            exceptionInterceptor: ExceptionInterceptor,
        ): OkHttpClient {
            return OkHttpClient.Builder()
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(connectivityInterceptor)
                .addInterceptor(loggingInterceptor)
                .addInterceptor(addHeadersInterceptor)
                .addInterceptor(exceptionInterceptor)
                .build()
        }

        @Provides
        fun provideMoshi(): Moshi = Moshi.Builder()
            .add(Wrapped.ADAPTER_FACTORY)
            .add(KotlinJsonAdapterFactory())
            .build()

        @Provides
        fun provideRetrofit(client: OkHttpClient, moshi: Moshi): Retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()
    }
}