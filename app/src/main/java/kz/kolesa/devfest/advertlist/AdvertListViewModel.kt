package kz.kolesa.devfest.advertlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kz.kolesa.devfest.domain.entity.Advertisement

class AdvertListViewModel: ViewModel() {

    private val advertListLiveData = MutableLiveData<List<Advertisement>>()

    fun getAdvertisements(): LiveData<List<Advertisement>> = advertListLiveData
}