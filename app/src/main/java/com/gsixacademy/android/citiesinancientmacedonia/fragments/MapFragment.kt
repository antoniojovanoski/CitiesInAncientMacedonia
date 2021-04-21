package com.gsixacademy.android.citiesinancientmacedonia.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions
import com.gsixacademy.android.citiesinancientmacedonia.MainActivity
import com.gsixacademy.android.citiesinancientmacedonia.R
import com.gsixacademy.android.citiesinancientmacedonia.data.CityListModel

class MapFragment:Fragment() ,OnMapReadyCallback{
    private var cityListModel:CityListModel? = null
    private lateinit var map :GoogleMap
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val mapFragment =
            childFragmentManager.findFragmentById(R.id.fragment_map) as SupportMapFragment
        cityListModel = (activity as MainActivity).cityListModel
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(activity, R.raw.my_map_style))
        setMarkers()
    }
    fun setMarkers() {
        if (cityListModel?.cities != null) {
            val builder = LatLngBounds.builder()
            for (tree in cityListModel!!.cities!!) {
                val markerOptions = MarkerOptions().position(
                    LatLng(
                        tree.lat_long?.latitude!!,
                        tree.lat_long?.longitude!!
                    )
                )
                    .title(tree.name)
                builder.include(markerOptions.position)
                map.addMarker(markerOptions).tag = tree.id

            }
            val bounds=builder.build()
            val padding=90
            val cameraUpdate= CameraUpdateFactory.newLatLngBounds(bounds,padding)
            map.moveCamera(cameraUpdate)
        }
    }
}