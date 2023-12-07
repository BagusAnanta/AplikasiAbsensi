package com.bsoftware.aplikasiabsensi.databaseAPIInterface

import com.bsoftware.aplikasiabsensi.dataClass.AdminDataClass
import com.bsoftware.aplikasiabsensi.dataClass.DosenDataClass
import retrofit2.http.GET

interface AdminDatabaseAPI {

    @GET("Read.php")
    suspend fun readAdminData() : List<AdminDataClass>
}