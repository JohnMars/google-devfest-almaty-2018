package kz.kolesa.devfest.advertdetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kz.kolesa.devfest.domain.entity.Advertisement

/**
 * ViewModel для экрана объявления
 */
class AdvertDetailsViewModel: ViewModel() {

    val advertisementLiveData = MutableLiveData<Advertisement>()

    fun onCallClicked() {
        TODO("Вытащить номер телефон из advertisementLiveData")
    }

    private fun requestAdvertisement(advertisementId: Long) {
        TODO("Загрузить объявление из Repository")
    }
}