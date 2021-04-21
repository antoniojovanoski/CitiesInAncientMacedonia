package com.gsixacademy.android.citiesinancientmacedonia.utils

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import java.util.*

object LocaleManager {
    var englishFlag = "en"
    var macedonianFlag = "mk"


    fun setLocale(context: Context?): Context {
        return updateResources(context!!, getCurrentlanguage(context))
    }

    fun setNewLocale(context: Context, language: String?) {
        SharedPreferenceManager(context).languageLocale = language
        updateResources(context, language)
    }

     fun getCurrentlanguage(context: Context): String? {

        return SharedPreferenceManager(context).languageLocale
    }

    fun updateResources(context: Context, currentlanguage: String?): Context {
        var contextPom = context
        var locale = Locale(currentlanguage.toString())
        Locale.setDefault(locale)
        val resources = context.resources
        val configuration = Configuration(resources.configuration)
        configuration.setLocale(locale)
        contextPom = context.createConfigurationContext(configuration)
        return contextPom

    }
}