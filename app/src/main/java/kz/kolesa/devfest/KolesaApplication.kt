package kz.kolesa.devfest

import android.app.Application
import kz.kolesa.devfest.data.room.KolesaDatabase

class KolesaApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        KolesaDatabase.initialize(this)
    }
}