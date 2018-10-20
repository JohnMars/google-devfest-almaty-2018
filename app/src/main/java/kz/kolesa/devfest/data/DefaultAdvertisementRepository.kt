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

            return getLocalAdvertisements()
        }

        val advertisementDao = kolesaDatabase.advertisementDao()
        val advertisementList = response.body()?.map {
            val advertisement = apiAdvertisementMapper.map(it)
            val roomAdvertisement = advertToRoomMapper.map(advertisement)
            advertisementDao.insertAll(roomAdvertisement)

            advertisement
        }

        return advertisementList ?: emptyList() // TODO вытащить объявлении из AdvertisementDao
    }

    override fun getAdvertisement(id: Long): Advertisement? {
        val advertisementDao = kolesaDatabase.advertisementDao()
        return advertisementDao.find(id)?.let {
            roomToAdvertisementMapper.map(it)
        }
    }

    private fun getLocalAdvertisements(): List<Advertisement> {
        return kolesaDatabase.advertisementDao().getAll().map {
            roomToAdvertisementMapper.map(it)
        }
    }

    private fun requestAdvertisement(id: Long): Advertisement? {
        val response = advertisementService.getAdvertisement(id).execute()

        return response.body()?.let { apiAdvertisementMapper.map(it) }
    }
}