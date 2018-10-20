package kz.kolesa.devfest.advertlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kz.kolesa.devfest.data.api.ADVERTISEMENT_SERVICE
import kz.kolesa.devfest.data.api.AdvertisementService
import kz.kolesa.devfest.data.mapper.ApiAdvertisementMapper
import kz.kolesa.devfest.domain.entity.Advertisement

class AdvertListViewModel(
        private val advertisementService: AdvertisementService = ADVERTISEMENT_SERVICE,
        private val apiAdvertisementMapper: ApiAdvertisementMapper = ApiAdvertisementMapper()
) : ViewModel() {

    private val advertListLiveData = MutableLiveData<List<Advertisement>>()

    fun getAdvertisements(): LiveData<List<Advertisement>> = advertListLiveData
}