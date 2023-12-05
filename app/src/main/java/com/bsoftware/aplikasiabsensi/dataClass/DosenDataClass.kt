package com.bsoftware.aplikasiabsensi.dataClass

import com.google.gson.annotations.SerializedName

data class DosenDataClass(
    @SerializedName("NIDN")                 var nim : String?,
    @SerializedName("Nama")                 var nama : String?,
    @SerializedName("MataKuliah")           var kelas : String?,
    @SerializedName("JurusanMengajar")      var jurusan : String?,
    @SerializedName("Keterangan")           var keterangan : String?,
    @SerializedName("Tanggal")              var tanggal : String?
) : java.io.Serializable
