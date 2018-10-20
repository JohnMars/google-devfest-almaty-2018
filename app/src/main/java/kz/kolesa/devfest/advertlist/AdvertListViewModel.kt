package kz.kolesa.devfest.advertlist

import androidx.lifecycle.ViewModel
import kz.kolesa.devfest.domain.entity.Advertisement

class AdvertListViewModel: ViewModel() {

    fun getAdvertisements(): List<Advertisement> = emptyList()
}