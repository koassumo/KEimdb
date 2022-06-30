package com.example.keimdb.retrofit.api

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
class ObjectListDTO (
    @Expose var items        : List<ItemDTO>? = listOf(),
    @Expose var errorMessage : String?          = null
): Parcelable