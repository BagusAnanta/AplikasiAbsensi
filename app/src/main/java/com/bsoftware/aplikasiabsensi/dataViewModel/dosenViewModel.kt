package com.bsoftware.aplikasiabsensi.dataViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bsoftware.aplikasiabsensi.dataClass.DosenDataClass
import com.bsoftware.aplikasiabsensi.databaseAPIInterface.DosenDatabaseAPI
import com.bsoftware.aplikasiabsensi.retrofitInit.RetrofitInitial
import kotlinx.coroutines.launch

class dosenViewModel : ViewModel() {
    private val apiInterfaceDosen = RetrofitInitial().retrofitDosen.create(DosenDatabaseAPI::class.java)
    private val mutableListDosenData = MutableLiveData<List<DosenDataClass>>()
    val livedataDosenData : LiveData<List<DosenDataClass>> = mutableListDosenData

    private val connectionStatus : Boolean = false;

    // read data dosen in here
    fun readDataDosen(){
        viewModelScope.launch {
            try {
                val getDataDosen = apiInterfaceDosen.readDosenData()
                mutableListDosenData.postValue(getDataDosen)
            } catch (e : Exception){
                Log.e("readDataDosen() Exception", e.toString())
                // setconnectionstatus in here
            }
        }
    }

    // create data dosen in here
    fun createDataDosen(nidn : String?, nama : String?, matakuliah : String?, jurusanmengajar : String?, keterangan : String?, tanggal : String?){
        viewModelScope.launch {
            try {
                val createDosenData = apiInterfaceDosen.createDosenData(nidn,nama,matakuliah,jurusanmengajar,keterangan,tanggal)
            } catch (e : Exception){
                Log.e("createDataDosen() Exception", e.toString())
            }
        }
    }

    // update data dosen in here
    fun updateDataDosen(nidn : String?, nama : String?, matakuliah : String?, jurusanmengajar : String?, keterangan : String?, tanggal : String?){
        viewModelScope.launch {
            try{
                val updateDosenData = apiInterfaceDosen.updateDosenData(nidn,nama,matakuliah,jurusanmengajar,keterangan,tanggal)
            } catch (e : Exception){
                Log.e("updateDataDosen() Exception", e.toString())
            }
        }
    }

    //delete data dosen in here
    fun deleteDataDosenByNidn(nidn : String?){
        viewModelScope.launch {
            try {
                val deleteDosenData = apiInterfaceDosen.deleteDosenDataByNidn(nidn)
            } catch (e : Exception){
                Log.e("deleteDataDosenByNidn() Exception", e.toString())
            }
        }
    }
}