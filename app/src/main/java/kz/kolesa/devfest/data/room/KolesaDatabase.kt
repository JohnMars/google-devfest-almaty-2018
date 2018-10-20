package kz.kolesa.devfest.data.room

import androidx.room.Database
import androidx.room.RoomDatabase

const val KOLESA_DATABASE_NAME = "kolesa"

@Database(
        entities = [RoomAdvertisement::class],
        version = 1
)
abstract class KolesaDatabase : RoomDatabase() {

    abstract fun advertisementDao(): RoomAdvertisementDao
}