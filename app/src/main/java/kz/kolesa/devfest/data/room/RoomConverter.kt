package kz.kolesa.devfest.data.room

import androidx.room.TypeConverter
import java.util.*

/**
 * Используется для записи [Date] виде [Long] и чтения обратно
 */
@Suppress("unused")
object DateConverter {

    @TypeConverter
    @JvmStatic
    fun toDate(timestamp: Long?): Date? = timestamp?.let { Date(timestamp) }

    @TypeConverter
    @JvmStatic
    fun toTimestamp(date: Date?): Long? = date?.time
}

/**
 * Используется для записи объектов [RoomAdvertisement] чтобы могли записать их SQLite
 * и вытащить обратно.
 */
@Suppress("unused")
object AdvertisementConverter {

    private const val DELIMITER = ", "
    private const val LABEL_VALUE_DELIMITER = "="

    @JvmStatic
    fun toPhotoList(photoListRaw: String?): List<RoomPhoto>? {
        return photoListRaw?.split(DELIMITER)?.map { RoomPhoto(it) }
    }

    @JvmStatic
    fun toPhotoListRaw(photoList: List<RoomPhoto>?): String? {
        return photoList?.joinToString(separator = DELIMITER) { it.url }
    }

    @JvmStatic
    fun toPhoneList(phoneListRaw: String?): List<RoomPhone>? {
        return phoneListRaw?.split(DELIMITER)?.map { RoomPhone(it) }
    }

    @JvmStatic
    fun toPhoneListRaw(phoneList: List<RoomPhone>?): String? {
        return phoneList?.joinToString(separator = DELIMITER) { it.number }
    }

    @JvmStatic
    fun toParameterList(parameterListRaw: String?): List<RoomParameter>? {
        return parameterListRaw?.split(DELIMITER)?.map {
            val labelValue = it.split(LABEL_VALUE_DELIMITER)
            RoomParameter(
                    label = labelValue[0],
                    value = labelValue[1]
            )
        }
    }

    @JvmStatic
    fun toParameterListRaw(parameterList: List<RoomParameter>?): String? {
        return parameterList?.joinToString(separator = DELIMITER) {
            it.label + LABEL_VALUE_DELIMITER + it.value
        }
    }
}