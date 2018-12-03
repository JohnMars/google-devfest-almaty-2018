package kz.kolesa.devfest.advertdetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.experimental.DefaultDispatcher
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.withContext
import kz.kolesa.devfest.data.DEFAULT_ADVERTISEMENT_REPOSITORY
import kz.kolesa.devfest.domain.entity.Advertisement
import kz.kolesa.devfest.domain.repository.AdvertisementRepository
import kotlin.coroutines.experimental.CoroutineContext

/**
 * ViewModel для экрана объявления
 */
class AdvertDetailsViewModel(
        private val advertisementId: Long,
        private val advertisementRepository: AdvertisementRepository = DEFAULT_ADVERTISEMENT_REPOSITORY,
        private val uiContext: CoroutineContext = UI,
        private val ioContext: CoroutineContext = DefaultDispatcher
): ViewModel() {

    val advertisementLiveData = MutableLiveData<Advertisement>()

    init {
        requestAdvertisement(advertisementId)
    }

    fun onCallClicked() {
        TODO("Вытащить номер телефон из advertisementLiveData")
    }

    private fun requestAdvertisement(advertisementId: Long) {
        launch(uiContext) {
            val advertisement = withContext(ioContext) {
                advertisementRepository.getAdvertisement(advertisementId)
            }
            advertisementLiveData.value = advertisement
        }
    }
}