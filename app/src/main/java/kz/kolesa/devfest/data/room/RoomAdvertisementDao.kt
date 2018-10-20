package kz.kolesa.devfest.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RoomAdvertisementDao {

    @Query("SELECT * FROM advertisements")
    fun getAll(): List<RoomAdvertisement>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg advertisement: RoomAdvertisement)
}