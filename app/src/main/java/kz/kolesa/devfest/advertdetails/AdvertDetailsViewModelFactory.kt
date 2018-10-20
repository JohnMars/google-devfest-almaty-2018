package kz.kolesa.devfest.advertdetails

import androidx.lifecycle.ViewModelProvider

class AdvertDetailsViewModelFactory(
        private val advertisementId: Long
) : ViewModelProvider.Factory