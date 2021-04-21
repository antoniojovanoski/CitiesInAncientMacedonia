package com.gsixacademy.android.citiesinancientmacedonia.utils

import android.content.Context
import android.os.Build
import java.util.*

object LocaleHelper {

    var systemDefaultLanguage :String? = "en"
    var systemDefaultLanguageTemporary:String?="en"


    fun setLocale(context:Context,language:String):Context{
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
        updateResources(context,language)
        else
            updateResourcesLegacy(context,language)
    }
    private fun updateResources(context: Context, language: String): Context {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val configuration = context.resources.configuration
        configuration.setLocale(locale)
        return context.createConfigurationContext(configuration)
    }
    @Suppress("DEPRECATION")
    private fun updateResourcesLegacy(context: Context, language: String): Context  {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val resources = context.resources
        val configuration = resources.configuration
        configuration.locale = locale
        resources.updateConfiguration(configuration, resources.displayMetrics)
        return context
    }
}