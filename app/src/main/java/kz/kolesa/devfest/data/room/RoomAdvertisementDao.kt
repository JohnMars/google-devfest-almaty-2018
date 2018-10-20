package kz.kolesa.devfest.data.room

import androidx.room.Dao

@Dao
interface RoomAdvertisementDao {

    fun insertAll(vararg advertisement: RoomAdvertisement)
}