package com.bsoftware.aplikasiabsensi.databaseAPIInterface

import com.bsoftware.aplikasiabsensi.dataClass.DosenDataClass
import com.bsoftware.aplikasiabsensi.dataClass.MahasiswaDataClass
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface MahasiswaDatabaseAPI {

    @GET("Read.php")
    suspend fun readMahasiswaData() : List<MahasiswaDataClass>

    @FormUrlEncoded
    @POST("Create.php")
    suspend fun createMahasiswaData(
        @Field("NIM") nim : String?,
        @Field("Nama") nama : String?,
        @Field("Kelas") kelas : String?,
        @Field("Jurusan") jurusan : String?,
        @Field("Keterangan") keterangan : String?,
        @Field("Tanggal") tanggal : String?
    ) : Response<MahasiswaDataClass>

    @FormUrlEncoded
    @POST("Update.php")
    suspend fun updateMahasiswaData(
        @Field("NIM") nim : String?,
        @Field("Nama") nama : String?,
        @Field("Kelas") kelas : String?,
        @Field("Jurusan") jurusan : String?,
        @Field("Keterangan") keterangan : String?,
        @Field("Tanggal") tanggal : String?
    ) : Response<MahasiswaDataClass>

    @DELETE("Delete.php")
    suspend fun deleteMahasiswaDataByNim(
        @Field("NIM") nim : String?
    ) : Response<MahasiswaDataClass>
}