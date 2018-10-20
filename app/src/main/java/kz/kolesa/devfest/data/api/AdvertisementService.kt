package kz.kolesa.devfest.data.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AdvertisementService {

    @GET("advertisement/search.json")
    fun searchAdvertisements(): Call<List<ApiAdvertisement>>

    @GET("advertisement/{advert_id}.json")
    fun getAdvertisement(
            @Path("advert_id")
            id: Long
    ): Call<ApiAdvertisement>
}