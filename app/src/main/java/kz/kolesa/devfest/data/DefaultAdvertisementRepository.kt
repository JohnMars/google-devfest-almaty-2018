package kz.kolesa.devfest.data

import android.util.Log
import kz.kolesa.devfest.data.api.ADVERTISEMENT_SERVICE
import kz.kolesa.devfest.data.api.AdvertisementService
import kz.kolesa.devfest.data.mapper.AdvertisementToRoomMapper
import kz.kolesa.devfest.data.mapper.ApiAdvertisementMapper
import kz.kolesa.devfest.data.mapper.RoomToAdvertisementMapper
import kz.kolesa.devfest.data.room.KolesaDatabase
import kz.kolesa.devfest.domain.entity.Advertisement
import kz.kolesa.devfest.domain.repository.AdvertisementRepository
import java.io.IOException

val DEFAULT_ADVERTISEMENT_REPOSITORY: AdvertisementRepository by lazy {
    DefaultAdvertisementRepository()
}

class DefaultAdvertisementRepository(
        private val advertisementService: AdvertisementService = ADVERTISEMENT_SERVICE,
        private val apiAdvertisementMapper: ApiAdvertisementMapper = ApiAdvertisementMapper(),
        private val kolesaDatabase: KolesaDatabase = KolesaDatabase.get(),
        private val advertToRoomMapper: AdvertisementToRoomMapper = AdvertisementToRoomMapper(),
        private val roomToAdvertisementMapper: RoomToAdvertisementMapper = RoomToAdvertisementMapper()
) : AdvertisementRepository {

    override fun searchAdvertisement(): List<Advertisement> {
        val response = try {
            advertisementService.searchAdvertisements().execute()
        } catch (e: IOException) {
            Log.e("AdvertisementRepository", e.localizedMessage, e)

            return emptyList() // TODO вытащить объявлении из AdvertisementDao
        }

        val advertisementList = response.body()?.map {
            apiAdvertisementMapper.map(it)
        }

        return advertisementList ?: emptyList() // TODO вытащить объявлении из AdvertisementDao
    }

    override fun getAdvertisement(id: Long): Advertisement? {
        return requestAdvertisement(id) // TODO: Вытащить объявление из AdvertisementDao
    }

    private fun getLocalAdvertisements(): List<Advertisement> {
        TODO("Вытащить список из AdvertisementDao")
    }

    private fun requestAdvertisement(id: Long): Advertisement? {
        val response = advertisementService.getAdvertisement(id).execute()

        return response.body()?.let { apiAdvertisementMapper.map(it) }
    }
}