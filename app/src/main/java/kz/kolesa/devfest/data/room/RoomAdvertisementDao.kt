package kz.kolesa.devfest.data.room

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface RoomAdvertisementDao {

    @Insert()
    fun insertAll(vararg advertisement: RoomAdvertisement)
}