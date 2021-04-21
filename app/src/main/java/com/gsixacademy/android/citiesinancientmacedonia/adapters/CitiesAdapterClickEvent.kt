package com.gsixacademy.android.citiesinancientmacedonia.adapters

import com.gsixacademy.android.citiesinancientmacedonia.data.CityData

sealed class CitiesAdapterClickEvent {
    data class CitiesAdapterItemClicked(val cityData: CityData):CitiesAdapterClickEvent()
}