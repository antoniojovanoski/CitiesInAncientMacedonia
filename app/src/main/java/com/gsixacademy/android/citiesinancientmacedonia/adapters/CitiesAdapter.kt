package com.gsixacademy.android.citiesinancientmacedonia.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gsixacademy.android.citiesinancientmacedonia.R
import com.gsixacademy.android.citiesinancientmacedonia.data.CityData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.city_list_row.view.*

class CitiesAdapter(
    val citiesDatas: ArrayList<CityData>,
   val citiesAdapterClickEvent: (CitiesAdapterClickEvent) ->Unit
):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.city_list_row,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val myViewHolder= holder as MyViewHolder
        myViewHolder.bindData(citiesDatas[position],position)
    }

    override fun getItemCount(): Int {
        return citiesDatas.size
    }

    inner class MyViewHolder(view:View):RecyclerView.ViewHolder(view){
        fun  bindData(cityData: CityData,position: Int){
            itemView.text_view_name.text = cityData.name
            itemView.text_view_location.text = cityData.locality
            itemView.text_view_period.text =cityData.period
            Picasso.get().load(cityData.images!![0]).centerCrop().fit().into(itemView.image_view_thumbnail)

            itemView.constraint_layout_main.setOnClickListener{
                citiesAdapterClickEvent.invoke(CitiesAdapterClickEvent.CitiesAdapterItemClicked(cityData))

            }

        }
    }
}