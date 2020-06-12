package com.kluivert.covid19updates.model

data class CasesData(
    val updated: Long,
    val country: String?,
    val countryInfo: CountryInfo?,
    val cases: Int,
    val todayCases: Int,
    val deaths: Int,
    val todayDeaths: Int,
    val recovered: Int,
    val active: Int,
    val critical: Int,
    val casesPerOneMillion: Float,
    val deathsPerOneMillion: Float,
    val tests: Int,
    val testsPerOneMillion: Float,
    val affectedCountries: Int?
) {
    data class CountryInfo(
        val _id: Int,
        val iso2: String,
        val iso3: String,
        val lat: Double,
        val long: Double,
        val flag: String
    )
}
