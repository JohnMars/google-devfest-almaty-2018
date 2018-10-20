package kz.kolesa.devfest.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
        entities = [RoomAdvertisement::class],
        version = 1
)
@TypeConverters
abstract class KolesaDatabase : RoomDatabase() {

    companion object {

        private const val KOLESA_DATABASE_NAME = "kolesa"
        private lateinit var instance: KolesaDatabase

        fun get(): KolesaDatabase = instance

        fun initialize(context: Context) {
            instance = create(context)
        }

        private fun create(context: Context): KolesaDatabase {
            return Room.databaseBuilder(
                    context.applicationContext,
                    KolesaDatabase::class.java,
                    KOLESA_DATABASE_NAME
            ).build()
        }
    }

    abstract fun advertisementDao(): RoomAdvertisementDao
}