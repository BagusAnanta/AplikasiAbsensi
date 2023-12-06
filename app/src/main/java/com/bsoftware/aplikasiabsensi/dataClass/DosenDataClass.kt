package com.bsoftware.aplikasiabsensi.dataClass

import com.google.gson.annotations.SerializedName

data class DosenDataClass(
    @SerializedName("NIDN")                 var nim : String?,
    @SerializedName("Nama")                 var nama : String?,
    @SerializedName("MataKuliah")           var kelas : String?,
    @SerializedName("JurusanMengajar")      var jurusan : String?,
    @SerializedName("Hadir")                var hadir : String?,
    @SerializedName("Sakit")                var sakit : String?,
    @SerializedName("Izin")                 var izin : String?,
    @SerializedName("Alpha")                var alpha : String?,
    @SerializedName("JamMasuk")             var jammasuk : String?,
    @SerializedName("JamKeluar")            var jamkeluar : String?,
    @SerializedName("Tanggal")              var tanggal : String?,
    @SerializedName("TanggalTidakHadir")    var tanggaltidakhadir : String?
) : java.io.Serializable
