package ru.lifehacker.testapp.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideLifeHackerApi(retrofit: Retrofit): LifeHackerApi =
        retrofit.create(LifeHackerApi::class.java)

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String, httpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .baseUrl(baseUrl)
        .build()

    @Provides
    fun providesBaseUrl(): String = "https://lifehacker.ru/api/"

    @Provides
    @Singleton
    fun provideHttpClient(logging: HttpLoggingInterceptor) = OkHttpClient.Builder()
        .apply {
            addInterceptor(logging)
        }.build()

    @Provides
    @Singleton
    fun provideHttpLogging() = HttpLoggingInterceptor()
        .apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
}