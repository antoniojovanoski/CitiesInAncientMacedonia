package com.gsixacademy.android.citiesinancientmacedonia.utils

import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceManager constructor(context : Context){
    private val LANGUAGE_LOCALE = "LANGUAGE_LOCALE"
    private val sharedPreferences = context.getSharedPreferences("com.gsixacademy.android.citiesinancientmacedonia.prefs",Context.MODE_PRIVATE)
    var languageLocale: String?
        get() = sharedPreferences.getString(LANGUAGE_LOCALE,"en")
        set(value) = sharedPreferences.edit().putString(LANGUAGE_LOCALE, value).apply()
}