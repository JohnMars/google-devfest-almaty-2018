package kz.kolesa.devfest.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase

const val KOLESA_DATABASE_NAME = "kolesa"

@Database(
        entities = [RoomAdvertisement::class],
        version = 1
)
abstract class KolesaDatabase : RoomDatabase() {

    companion object {

        private const val KOLESA_DATABASE_NAME = "kolesa"
        private lateinit var instance: KolesaDatabase

        fun get(): KolesaDatabase = instance

        fun initialize(context: Context) {
            instance = create(context)
        }

        private fun create(context: Context): KolesaDatabase {
            TODO("Создание instance KolesaDatabase")
        }
    }

    abstract fun advertisementDao(): RoomAdvertisementDao
}