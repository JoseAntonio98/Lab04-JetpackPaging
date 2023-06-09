package org.idnp.jetpackpagingsample.model

import android.util.Log
import org.idnp.jetpackpagingsample.entities.Country

class CountryRepository() {
    fun getCountries(nextPageNumber: Int): ArrayList<Country> {
        Log.d("[Next Page Number]: ", nextPageNumber.toString())

        val countries = arrayListOf<Country>()
        var country: Country

        val start: Int = 100 * nextPageNumber
        val end: Int = start + 20

        for (i in start..end) {
            country = Country(
                name_en = "Name_en $i",
                name_es = "Name_es $i",
                continent_en = "Continent_en $i",
                continent_es = "Continent_es $i",
                capital_en = "Capital_en $i",
                capital_es = "Capital_es $i",
                dial_code = "Dial_code $i",
                code_2 = "Code_2 $i",
                code_3 = "Code_3 $i",
                tld = "Tld $i",
                km2 = i * 1000f
            )

            countries.add(country)
        }

        return countries
    }
}