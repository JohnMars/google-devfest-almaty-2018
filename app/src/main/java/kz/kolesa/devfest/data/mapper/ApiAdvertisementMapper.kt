package kz.kolesa.devfest.data.mapper

import kz.kolesa.devfest.data.api.ApiAdvertisement
import kz.kolesa.devfest.domain.entity.Advertisement
import kz.kolesa.devfest.domain.entity.AdvertisementParameter
import kz.kolesa.devfest.domain.entity.AdvertisementPhone
import kz.kolesa.devfest.domain.entity.AdvertisementPhoto
import java.util.*

class ApiAdvertisementMapper : Mapper<ApiAdvertisement, Advertisement> {

    override fun map(value: ApiAdvertisement) = Advertisement(
            id = value.id,
            price = value.price,
            createdDate = Date(value.createdAt),
            title = value.title,
            text = value.text,
            specification = value.specification,
            photos = value.photos.map { AdvertisementPhoto(it.url) },
            parameters = value.parameters.map { AdvertisementParameter(it.label, it.value) },
            phones = value.phones.map { AdvertisementPhone("tel:${it.number}") }
    )
}