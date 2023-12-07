package com.bsoftware.aplikasiabsensi.dataClass

import com.google.gson.annotations.SerializedName

data class AdminDataClass(
    @SerializedName("Username")          var username : String?,
    @SerializedName("Password")          var password : String?,
) : java.io.Serializable
