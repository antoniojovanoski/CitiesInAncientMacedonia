package com.gsixacademy.android.citiesinancientmacedonia.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gsixacademy.android.citiesinancientmacedonia.R
import com.gsixacademy.android.citiesinancientmacedonia.utils.LocaleManager
import kotlinx.android.synthetic.main.fragment_info.*

class InfoFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_info, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        image_view_flag_en.setOnClickListener {
            val currentLanguage = LocaleManager.getCurrentlanguage(requireActivity().applicationContext)
            if (currentLanguage==LocaleManager.macedonianFlag){
                LocaleManager.setNewLocale(requireActivity(), LocaleManager.englishFlag)
                activity?.recreate()
            }
        }
        image_view_flag_mk.setOnClickListener {
            val currentLanguage = LocaleManager.getCurrentlanguage(requireActivity().applicationContext)
            if (currentLanguage==LocaleManager.englishFlag){
                LocaleManager.setNewLocale(requireActivity(),LocaleManager.macedonianFlag)
                activity?.recreate()
            }
        }
    }
}