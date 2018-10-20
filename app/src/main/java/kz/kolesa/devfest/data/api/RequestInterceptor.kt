package kz.kolesa.devfest.data.api

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        Log.d("Http request", "Sending request ${request.url()} on ${chain.connection()}")

        return chain.proceed(request)
    }
}