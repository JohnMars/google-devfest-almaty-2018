package kz.kolesa.devfest.data.room

import androidx.room.Database
import androidx.room.RoomDatabase

const val KOLESA_DATABASE_NAME = "kolesa"

@Database()
abstract class KolesaDatabase : RoomDatabase()