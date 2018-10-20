package kz.kolesa.devfest.domain.repository

import kz.kolesa.devfest.domain.entity.Advertisement

interface AdvertisementRepository {

    fun searchAdvertisement(): List<Advertisement>

    fun getAdvertisement(id: Long): Advertisement?
}