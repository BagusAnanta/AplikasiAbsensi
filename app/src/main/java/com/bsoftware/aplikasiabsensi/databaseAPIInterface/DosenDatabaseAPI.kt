package com.bsoftware.aplikasiabsensi.databaseAPIInterface

import com.bsoftware.aplikasiabsensi.dataClass.DosenDataClass
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface DosenDatabaseAPI {

    @GET("Read.php")
    suspend fun readDosenData() : List<DosenDataClass>

    @GET("ReadNidnName.php")
    suspend fun readDosenNidnNama() : List<DosenDataClass>

    @FormUrlEncoded
    @POST("ReadHadir.php")
    suspend fun readHadirWithNidn(
        @Field("NIDN") nidn : String?
    ) : Response<DosenDataClass>

    @FormUrlEncoded
    @POST("ReadIzin.php")
    suspend fun readIzinWithNidn(
        @Field("NIDN") nidn : String?
    ) : Response<DosenDataClass>

    @FormUrlEncoded
    @POST("ReadSakit.php")
    suspend fun readSakitWithNidn(
        @Field("NIDN") nidn : String?
    ) : Response<DosenDataClass>

    @FormUrlEncoded
    @POST("ReadAlpha.php")
    suspend fun readAlphaWithNidn(
        @Field("NIDN") nidn : String?
    ) : Response<DosenDataClass>

    @FormUrlEncoded
    @POST("Create.php")
    suspend fun createDosenData(
        @Field("NIDN") nidn : String?,
        @Field("Nama") nama : String?,
        @Field("MataKuliah") matakuliah : String?,
        @Field("JurusanMengajar") jurusanMengajar : String?,
        @Field("Hadir") hadir : Int?,
        @Field("Sakit") sakit : Int?,
        @Field("Izin") izin : Int?,
        @Field("Alpha") alpha : Int?,
        @Field("JamMasuk") jammasuk : String?,
        @Field("JamKeluar") jamkeluar : String?,
        @Field("Tanggal") tanggal : String?,
        @Field("TanggalTidakHadir") tanggaltidakhadir : String?
    ) : Response<DosenDataClass>

    @FormUrlEncoded
    @POST("Update.php")
    suspend fun updateDosenData(
        @Field("NIDN") nidn : String?,
        @Field("Nama") nama : String?,
        @Field("MataKuliah") matakuliah : String?,
        @Field("JurusanMengajar") jurusanMengajar : String?,
        @Field("Hadir") hadir : Int?,
        @Field("Sakit") sakit : Int?,
        @Field("Izin") izin : Int?,
        @Field("Alpha") alpha : Int?,
        @Field("JamMasuk") jammasuk : String?,
        @Field("JamKeluar") jamkeluar : String?,
        @Field("Tanggal") tanggal : String?,
        @Field("TanggalTidakHadir") tanggaltidakhadir : String?
    ) : Response<DosenDataClass>

    @FormUrlEncoded
    @POST("UpdateHadir.php")
    suspend fun updateHadir(
        @Field("NIDN") nidn: String?,
        @Field("Hadir") hadir: Int?
    ) : Response<DosenDataClass>

    @FormUrlEncoded
    @POST("UpdateSakit.php")
    suspend fun updateSakit(
        @Field("NIDN") nidn: String?,
        @Field("Sakit") sakit: Int?
    ) : Response<DosenDataClass>

    @FormUrlEncoded
    @POST("UpdateIzin.php")
    suspend fun updateIzin(
        @Field("NIDN") nidn: String?,
        @Field("Izin") izin: Int?
    ) : Response<DosenDataClass>

    @FormUrlEncoded
    @POST("UpdateAlpha.php")
    suspend fun updateAlpha(
        @Field("NIDN") nidn: String?,
        @Field("Alpha") alpha: Int?
    ) : Response<DosenDataClass>

    @FormUrlEncoded
    @POST("Delete.php")
    suspend fun deleteDosenDataByNidn(
        @Field("NIDN") nidn : String?
    ) : Response<DosenDataClass>
}