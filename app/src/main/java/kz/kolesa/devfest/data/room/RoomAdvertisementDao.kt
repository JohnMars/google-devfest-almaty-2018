package kz.kolesa.devfest.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface RoomAdvertisementDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg advertisement: RoomAdvertisement)
}