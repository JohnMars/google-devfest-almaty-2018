package kz.kolesa.devfest.advertlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.experimental.DefaultDispatcher
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.withContext
import kz.kolesa.devfest.data.DEFAULT_ADVERTISEMENT_REPOSITORY
import kz.kolesa.devfest.domain.entity.Advertisement
import kz.kolesa.devfest.domain.repository.AdvertisementRepository

class AdvertListViewModel(
        private val advertisementRepository: AdvertisementRepository = DEFAULT_ADVERTISEMENT_REPOSITORY
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
                advertisementRepository.searchAdvertisement()
            }
            advertListLiveData.value = advertisements
        }
    }
}