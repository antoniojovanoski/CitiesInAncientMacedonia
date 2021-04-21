package com.gsixacademy.android.citiesinancientmacedonia.data

import android.os.Parcel
import android.os.Parcelable
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
class CityData():Parcelable {
    var id: Int = 0
    var name: String? = null
    var period: String? = null
    var locality: String? = null
    var images: ArrayList<String>? = null
    var lat_long: LatLongData? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readInt()
        name = parcel.readString()
        period = parcel.readString()
        locality = parcel.readString()
        lat_long = parcel.readParcelable(LatLongData::class.java.classLoader)
    }
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(period)
        parcel.writeString(locality)
        parcel.writeParcelable(lat_long, flags)
    }
    override fun describeContents(): Int {
        return 0
    }
    companion object CREATOR : Parcelable.Creator<CityData> {
        override fun createFromParcel(parcel: Parcel): CityData {
            return CityData(parcel)
        }
        override fun newArray(size: Int): Array<CityData?> {
            return arrayOfNulls(size)
        }
    }
}