package kz.kolesa.devfest.advertlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.experimental.DefaultDispatcher
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.withContext
import kz.kolesa.devfest.data.api.ADVERTISEMENT_SERVICE
import kz.kolesa.devfest.data.api.AdvertisementService
import kz.kolesa.devfest.data.mapper.ApiAdvertisementMapper
import kz.kolesa.devfest.domain.entity.Advertisement

class AdvertListViewModel(
        private val advertisementService: AdvertisementService = ADVERTISEMENT_SERVICE,
        private val apiAdvertisementMapper: ApiAdvertisementMapper = ApiAdvertisementMapper()
) : ViewModel() {

    private val advertListLiveData = MutableLiveData<List<Advertisement>>()

    fun getAdvertisements(): LiveData<List<Advertisement>> = advertListLiveData.apply {
        if (value == null) {
            requestAdvertisements()
        }
    }

    private fun requestAdvertisements() {
        launch(UI) {
            val advertisements = withContext(DefaultDispatcher) {
                val searchResponse = advertisementService.searchAdvertisements().execute()
                searchResponse.body()?.map { apiAdvertisementMapper.map(it) }
            }
            TODO("Уведомляем LiveData")
        }
    }
}