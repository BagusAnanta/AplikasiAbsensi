package com.bsoftware.aplikasiabsensi.dataViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bsoftware.aplikasiabsensi.dataClass.AdminDataClass
import com.bsoftware.aplikasiabsensi.databaseAPIInterface.AdminDatabaseAPI
import com.bsoftware.aplikasiabsensi.retrofitInit.RetrofitInitial
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class AdminViewModel : ViewModel() {
    private val apiInterfaceAdmin = RetrofitInitial().retrofitAdmin.create(AdminDatabaseAPI::class.java)
    private val mutableListAdminData = MutableLiveData<List<AdminDataClass>>()
    val livedataAdminData : LiveData<List<AdminDataClass>> = mutableListAdminData

    private var connectionStatus : Boolean = false

    fun readDataAdmin(){
        viewModelScope.launch {
            try{
                val getDataAdmin = apiInterfaceAdmin.readAdminData()
                mutableListAdminData.postValue(getDataAdmin)
            } catch (e : Exception){
                Log.e("readDataAdmin() Exception", e.toString())
                // in here we gonna set connection status into false
                setConnection(false)
            }
        }
    }

    private fun setConnection(isConnection : Boolean){
        connectionStatus = isConnection
    }

    fun getConnectionStatus() : Boolean{
        return connectionStatus
    }

}