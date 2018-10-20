package kz.kolesa.devfest.data.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

private val RETROFIT: Retrofit by lazy {
    val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(RequestInterceptor())
            .build()
    Retrofit.Builder()
            .baseUrl("https://stash.kolesa-team.org/projects/MAPG/repos/sample/raw/")
            .client(okHttpClient)
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
}

val ADVERTISEMENT_SERVICE: AdvertisementService by lazy {
    RETROFIT.create(AdvertisementService::class.java)
}