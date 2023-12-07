package com.bsoftware.aplikasiabsensi.retrofitInit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitial {
    var retrofitDosen = Retrofit.Builder()
        .baseUrl("http://192.168.100.11/AbsensiJurusan/AbsensiDosen/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var retrofitMahasiswa = Retrofit.Builder()
        .baseUrl("http://192.168.100.11/AbsensiJurusan/AbsensiMahasiswa/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var retrofitAdmin = Retrofit.Builder()
        .baseUrl("http://192.168.100.11/AbsensiJurusan/AdminLogin/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}