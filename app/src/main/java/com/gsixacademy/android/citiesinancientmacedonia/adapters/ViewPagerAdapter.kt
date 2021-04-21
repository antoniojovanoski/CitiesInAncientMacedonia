package com.gsixacademy.android.citiesinancientmacedonia.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.gsixacademy.android.citiesinancientmacedonia.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.image_view_pager_row.view.*


class ViewPagerAdapter(private val imagesList:ArrayList<String>):PagerAdapter() {
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return imagesList.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater= LayoutInflater.from(container.context)
        val view=inflater.inflate(R.layout.image_view_pager_row,container,false) as ViewGroup

        Picasso.get().load(imagesList.get(position)).fit().centerInside().into(view.image_view_details_main)


        container.addView(view)
        return view
    }
}