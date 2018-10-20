package kz.kolesa.devfest.data.api

import com.fasterxml.jackson.annotation.JsonProperty

data class ApiAdvertisement(
        @JsonProperty("id")
        val id: Long,
        @JsonProperty("title")
        val title: String,
        @JsonProperty("text")
        val text: String,
        @JsonProperty("specification")
        val specification: String,
        @JsonProperty("price")
        val price: Long,
        @JsonProperty("created_at")
        val createdAt: Long,
        @JsonProperty("photos")
        val photos: List<ApiAdvertisementPhoto>,
        @JsonProperty("parameters")
        val parameters: List<ApiAdvertisementParameter>,
        @JsonProperty("phones")
        val phones: List<ApiAdvertisementPhone>
)

data class ApiAdvertisementPhoto(
        @JsonProperty("url")
        val url: String
)

data class ApiAdvertisementParameter(
        @JsonProperty("label")
        val label: String,
        @JsonProperty("value")
        val value: String
)

data class ApiAdvertisementPhone(
        @JsonProperty("number")
        val number: String
)