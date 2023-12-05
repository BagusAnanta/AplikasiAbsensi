package com.bsoftware.aplikasiabsensi.dataClass

import com.google.gson.annotations.SerializedName

data class MahasiswaDataClass(
    @SerializedName("NIM")          var nim : String?,
    @SerializedName("Nama")         var nama : String?,
    @SerializedName("Kelas")        var kelas : String?,
    @SerializedName("Jurusan")      var jurusan : String?,
    @SerializedName("Keterangan")   var keterangan : String?,
    @SerializedName("Tanggal")      var tanggal : String?
) : java.io.Serializable
