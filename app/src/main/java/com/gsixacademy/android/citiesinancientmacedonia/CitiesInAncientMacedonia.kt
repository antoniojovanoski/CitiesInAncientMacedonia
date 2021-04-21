package com.gsixacademy.android.citiesinancientmacedonia

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import com.gsixacademy.android.citiesinancientmacedonia.utils.LocaleManager

class CitiesInAncientMacedonia():Application() {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(LocaleManager.setLocale(base))
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        LocaleManager.setLocale(this)
    }
}