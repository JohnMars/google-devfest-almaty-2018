package kz.kolesa.devfest.advertdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AdvertDetailsViewModelFactory(
        private val advertisementId: Long
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if (modelClass.isAssignableFrom(AdvertDetailsViewModel::class.java)) {
            return AdvertDetailsViewModel(advertisementId) as T
        }

        throw IllegalArgumentException("Could not instantiate " +
                AdvertDetailsViewModel::class.java.simpleName)
    }
}