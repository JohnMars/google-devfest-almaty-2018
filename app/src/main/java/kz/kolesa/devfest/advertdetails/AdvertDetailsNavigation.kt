package kz.kolesa.devfest.advertdetails

sealed class AdvertDetailsNavigation {
    data class Call(val phoneNumber: String) : AdvertDetailsNavigation()
    object GoBack : AdvertDetailsNavigation()
}