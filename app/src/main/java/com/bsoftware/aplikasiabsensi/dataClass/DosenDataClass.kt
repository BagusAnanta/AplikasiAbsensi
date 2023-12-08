package com.bsoftware.aplikasiabsensi.dataClass

import com.google.gson.annotations.SerializedName

data class DosenDataClass(
    @SerializedName("NIDN")                 var nidn : String?,
    @SerializedName("Nama")                 var nama : String?,
    @SerializedName("MataKuliah")           var matakuliah : String?,
    @SerializedName("JurusanMengajar")      var jurusanmengajar : String?,
    @SerializedName("Hadir")                var hadir : Int?,
    @SerializedName("Sakit")                var sakit : Int?,
    @SerializedName("Izin")                 var izin : Int?,
    @SerializedName("Alpha")                var alpha : Int?,
    @SerializedName("JamMasuk")             var jammasuk : String?,
    @SerializedName("JamKeluar")            var jamkeluar : String?,
    @SerializedName("Tanggal")              var tanggal : String?,
    @SerializedName("TanggalTidakHadir")    var tanggaltidakhadir : String?
) : java.io.Serializable
