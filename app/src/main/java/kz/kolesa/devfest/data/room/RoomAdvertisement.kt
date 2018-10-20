package kz.kolesa.devfest.data.room

import java.util.*

data class RoomAdvertisement(
        val id: Long,
        val title: String,
        val price: Long,
        val specification: String,
        val text: String,
        val date: Date,
        val parameters: List<RoomParameter>,
        val photos: List<RoomPhoto>,
        val phones: List<RoomPhone>
)

data class RoomPhoto(
        val url: String
)

data class RoomParameter(
        val label: String,
        val value: String
)

data class RoomPhone(
        val number: String
)