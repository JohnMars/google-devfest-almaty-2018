package kz.kolesa.devfest.domain.entity

import java.util.*

val FAKE_ADVERITISEMENT: Advertisement by lazy {
    Advertisement(
            id = 1,
            price = 8300000,
            title = "Toyota Camry 2018 года",
            createdDate = Date(1539705559),
            text = "Автомобиль в замечательном состоянии, без вложений. Все вопросы в телефон режиме! Торг!",
            specification = "литые диски, ксенон, кожа, USB, ГУР, ABS, SRS, бортовой компьютер, свежепригнан, налог уплачен, вложений не требует",
            phones = listOf(AdvertisementPhone("+77071234567"), AdvertisementPhone("+77077654321")),
            photos = listOf(
                    AdvertisementPhoto("https://photos-b-kl.kcdn.kz/68/689db250-d36d-4bf5-9897-1daf97939a1f/1-full.jpg"),
                    AdvertisementPhoto("https://photos-a-kl.kcdn.kz/68/689db250-d36d-4bf5-9897-1daf97939a1f/2-full.jpg"),
                    AdvertisementPhoto("https://photos-a-kl.kcdn.kz/68/689db250-d36d-4bf5-9897-1daf97939a1f/3-full.jpg"),
                    AdvertisementPhoto("https://photos-a-kl.kcdn.kz/68/689db250-d36d-4bf5-9897-1daf97939a1f/4-full.jpg"),
                    AdvertisementPhoto("https://photos-a-kl.kcdn.kz/68/689db250-d36d-4bf5-9897-1daf97939a1f/5-full.jpg")
            ),
            parameters = listOf(
                    AdvertisementParameter(label = "Город", value = "Алматы"),
                    AdvertisementParameter(label = "Кузов", value = "Седан"),
                    AdvertisementParameter(label = "Объем двигателя", value = "2.5 (бензин)"),
                    AdvertisementParameter(label = "Пробег", value = "3 774 км"),
                    AdvertisementParameter(label = "Коробка передач", value = "автомат"),
                    AdvertisementParameter(label = "Руль", value = "слева"),
                    AdvertisementParameter(label = "Привод", value = "передний привод"),
                    AdvertisementParameter(label = "Растаможен", value = "Да")
            )
    )
}