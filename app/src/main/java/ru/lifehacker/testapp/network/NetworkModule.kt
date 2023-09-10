package ru.lifehacker.testapp.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideLifeHackerApi(retrofit: Retrofit): LifeHackerApi =
        retrofit.create(LifeHackerApi::class.java)

    @Provides
    fun provideRetrofit(baseUrl: String, httpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .baseUrl(baseUrl)
        .build()

    @Provides
    fun providesBaseUrl(): String = "https://lifehacker.ru/api/"

    @Provides
    fun provideHttpClient(logging: HttpLoggingInterceptor) = OkHttpClient.Builder()
        .apply {
            addInterceptor(logging)
        }.build()

    @Provides
    fun provideHttpLogging() = HttpLoggingInterceptor()
        .apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }

}