package kz.kolesa.devfest.domain.entity

import java.util.*

/**
 * @author marshal@kolesa.kz
 */
data class Advertisement(
        val id: Long,
        val title: String,
        val price: Long,
        val createdDate: Date,
        val text: String,
        val specification: String,
        val photos: List<AdvertisementPhoto>,
        val parameters: List<AdvertisementParameter>,
        val phones: List<AdvertisementPhone>
)

data class AdvertisementParameter(
        val label: String,
        val value: String
)

data class AdvertisementPhoto(
        val url: String
)

data class AdvertisementPhone(
        val number: String
)