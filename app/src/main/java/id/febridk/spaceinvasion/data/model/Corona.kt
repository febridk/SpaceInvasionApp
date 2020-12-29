package id.febridk.spaceinvasion.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize

data class Corona(
    val location: String = "",
    val confirmed:  String = "",
    val dead: String = "",
    val recovered: String = ""
) : Parcelable