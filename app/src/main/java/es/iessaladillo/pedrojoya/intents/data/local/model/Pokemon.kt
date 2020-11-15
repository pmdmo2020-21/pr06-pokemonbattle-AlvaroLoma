package es.iessaladillo.pedrojoya.intents.data.local.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Pokemon(val fuerza:Int, val nombre:String, val imagen:Int,val id:Long): Parcelable