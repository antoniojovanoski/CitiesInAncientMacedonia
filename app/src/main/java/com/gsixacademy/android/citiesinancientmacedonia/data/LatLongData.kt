package com.gsixacademy.android.citiesinancientmacedonia.data

import android.os.Parcel
import android.os.Parcelable
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
class LatLongData() : Parcelable {
    var latitude: Double? = null
    var longitude: Double? = null
    constructor(parcel: Parcel) : this() {
        latitude = parcel.readDouble()
        longitude = parcel.readDouble()
    }
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        latitude?.let { parcel.writeDouble(it) }
        longitude?.let { parcel.writeDouble(it) }
    }
    override fun describeContents(): Int {
        return 0
    }
    companion object CREATOR : Parcelable.Creator<LatLongData> {
        override fun createFromParcel(parcel: Parcel): LatLongData {
            return LatLongData(parcel)
        }
        override fun newArray(size: Int): Array<LatLongData?> {
            return arrayOfNulls(size)
        }
    }
}
