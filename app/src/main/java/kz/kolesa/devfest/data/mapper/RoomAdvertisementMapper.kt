package kz.kolesa.devfest.data.mapper

import kz.kolesa.devfest.data.room.RoomAdvertisement
import kz.kolesa.devfest.data.room.RoomParameter
import kz.kolesa.devfest.data.room.RoomPhone
import kz.kolesa.devfest.data.room.RoomPhoto
import kz.kolesa.devfest.domain.entity.Advertisement
import kz.kolesa.devfest.domain.entity.AdvertisementParameter
import kz.kolesa.devfest.domain.entity.AdvertisementPhone
import kz.kolesa.devfest.domain.entity.AdvertisementPhoto

class AdvertisementToRoomMapper : Mapper<Advertisement, RoomAdvertisement> {

    override fun map(value: Advertisement): RoomAdvertisement {
        return RoomAdvertisement(
                id = value.id,
                title = value.title,
                price = value.price,
                specification = value.specification,
                text = value.text,
                date = value.createdDate,
                parameters = value.parameters.map { RoomParameter(it.label, it.value) },
                photos = value.photos.map { RoomPhoto(it.url) },
                phones = value.phones.map { RoomPhone(it.number) }
        )
    }
}

class RoomToAdvertisementMapper : Mapper<RoomAdvertisement, Advertisement> {
    override fun map(value: RoomAdvertisement): Advertisement {
        return Advertisement(
                id = value.id,
                title = value.title,
                price = value.price,
                specification = value.specification,
                text = value.text,
                createdDate = value.date,
                parameters = value.parameters.map { AdvertisementParameter(it.label, it.value) },
                photos = value.photos.map { AdvertisementPhoto(it.url) },
                phones = value.phones.map { AdvertisementPhone(it.number) }
        )
    }
}