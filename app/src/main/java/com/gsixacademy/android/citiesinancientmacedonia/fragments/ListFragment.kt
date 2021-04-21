package com.gsixacademy.android.citiesinancientmacedonia.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gsixacademy.android.citiesinancientmacedonia.MainActivity
import com.gsixacademy.android.citiesinancientmacedonia.R
import com.gsixacademy.android.citiesinancientmacedonia.adapters.CitiesAdapter
import com.gsixacademy.android.citiesinancientmacedonia.adapters.CitiesAdapterClickEvent
import com.gsixacademy.android.citiesinancientmacedonia.data.CityData
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {

        var cityListModel = (activity as MainActivity).cityListModel
        recycler_view_main.adapter = cityListModel?.cities?.let { cities ->
            cityListModel.cities?.let { cities ->
                CitiesAdapter(cities){
                    if (it is CitiesAdapterClickEvent.CitiesAdapterItemClicked){
                        var bundle = Bundle()
                        bundle.putParcelable("cityData", it.cityData)
                        findNavController().navigate(R.id.action_listFragment_to_cityDetailsFragment,bundle)
                    }
                }
            }

        }
//        var cityList= ArrayList<CityData>()
//
//recycler_view_main.adapter= CitiesAdapter(cityList){
//
//}
    }
}