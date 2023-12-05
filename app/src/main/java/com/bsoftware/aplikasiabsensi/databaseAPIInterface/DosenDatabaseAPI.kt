package com.bsoftware.aplikasiabsensi.databaseAPIInterface

import com.bsoftware.aplikasiabsensi.dataClass.DosenDataClass
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface DosenDatabaseAPI {

    @GET("Read.php")
    suspend fun readDosenData() : List<DosenDataClass>

    @FormUrlEncoded
    @POST("Create.php")
    suspend fun createDosenData(
        @Field("NIDN") nidn : String?,
        @Field("Nama") nama : String?,
        @Field("MataKuliah") matakuliah : String?,
        @Field("JurusanMengajar") jurusanMengajar : String?,
        @Field("Keterangan") keterangan : String?,
        @Field("Tanggal") tanggal : String?
    ) : Response<DosenDataClass>

    @FormUrlEncoded
    @POST("Update.php")
    suspend fun updateDosenData(
        @Field("NIDN") nidn : String?,
        @Field("Nama") nama : String?,
        @Field("MataKuliah") matakuliah : String?,
        @Field("JurusanMengajar") jurusanMengajar : String?,
        @Field("Keterangan") keterangan : String?,
        @Field("Tanggal") tanggal : String?
    ) : Response<DosenDataClass>

    @DELETE("Delete.php")
    suspend fun deleteDosenDataByNidn(
        @Field("NIDN") nidn : String?
    ) : Response<DosenDataClass>
}