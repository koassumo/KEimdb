package com.example.keimdb.retrofit.api

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemDTO(
    @Expose var id              : String? = null,
    @Expose var rank            : String? = null,
    @Expose var title           : String? = null,
    @Expose var fullTitle       : String? = null,
    @Expose var year            : String? = null,
    @Expose var image           : String? = null,
    @Expose var crew            : String? = null,
    @Expose var imDbRating      : String? = null,
    @Expose var imDbRatingCount : String? = null,
): Parcelable