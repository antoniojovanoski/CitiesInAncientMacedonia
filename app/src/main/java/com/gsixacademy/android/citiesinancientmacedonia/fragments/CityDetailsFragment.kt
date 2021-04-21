package com.gsixacademy.android.citiesinancientmacedonia.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gsixacademy.android.citiesinancientmacedonia.R
import com.gsixacademy.android.citiesinancientmacedonia.adapters.ViewPagerAdapter
import com.gsixacademy.android.citiesinancientmacedonia.data.CityData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_city_details.*

class CityDetailsFragment : Fragment() {

    lateinit var cityData: CityData
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_city_details, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        cityData = arguments?.get("cityData") as CityData


        view__pager_city.adapter = cityData.images?.let { ViewPagerAdapter(it) }
        text_view_name_value.text = cityData.name
        text_view_period_value.text = "${cityData.period}"
        text_view_location_value.text = cityData.locality
    }
}