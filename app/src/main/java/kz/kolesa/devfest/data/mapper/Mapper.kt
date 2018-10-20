package kz.kolesa.devfest.data.mapper

interface Mapper<in V, out K> {

    fun map(value : V) : K
}