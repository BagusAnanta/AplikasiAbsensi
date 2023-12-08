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

class DosenViewModel : ViewModel() {
    private val apiInterfaceDosen = RetrofitInitial().retrofitDosen.create(DosenDatabaseAPI::class.java)
    private val mutableListDosenData = MutableLiveData<List<DosenDataClass>>()
    val livedataDosenData : LiveData<List<DosenDataClass>> = mutableListDosenData

    private var connectionStatus : Boolean = false;

    // read data dosen in here
    fun readDataDosen(){
        viewModelScope.launch {
            try {
                val getDataDosen = apiInterfaceDosen.readDosenData()
                mutableListDosenData.postValue(getDataDosen)
            } catch (e : Exception){
                Log.e("readDataDosen() Exception", e.toString())
                // setconnectionstatus in here
                setConnection(false)
            }
        }
    }

    // create data dosen in here
    fun createDataDosen(nidn : String?, nama : String?, matakuliah : String?, jurusanmengajar : String?, hadir : Int?, sakit : Int?, izin : Int?, alpha : Int?, jammasuk : String?,jamkeluar : String?,tanggal : String?,tanggaltidakhadir : String?){
        viewModelScope.launch {
            try {
                val createDosenData = apiInterfaceDosen.createDosenData(
                    nidn,
                    nama,
                    matakuliah,
                    jurusanmengajar,
                    hadir,
                    sakit,
                    izin,
                    alpha,
                    jammasuk,
                    jamkeluar,
                    tanggal,
                    tanggaltidakhadir
                )

                Log.d("CreateDosenData", createDosenData.toString())

                if(!createDosenData.isSuccessful){
                    Log.e("CreateDosenData Fail",createDosenData.message())
                } else {
                    Log.i("CreateDosenData Success", createDosenData.message())
                }
            } catch (e : Exception){
                Log.e("createDataDosen() Exception", e.toString())
            }
        }
    }

    // update data dosen in here
    fun updateDataDosen(nidn : String?, nama : String?, matakuliah : String?, jurusanmengajar : String?, hadir : Int?, sakit : Int?, izin : Int?, alpha : Int?, jammasuk : String?,jamkeluar : String?,tanggal : String?,tanggaltidakhadir : String?){
        viewModelScope.launch {
            try{
                val updateDosenData = apiInterfaceDosen.updateDosenData(
                    nidn,
                    nama,
                    matakuliah,
                    jurusanmengajar,
                    hadir,
                    sakit,
                    izin,
                    alpha,
                    jammasuk,
                    jamkeluar,
                    tanggal,
                    tanggaltidakhadir
                )

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
                if(deleteDosenData.isSuccessful){
                    // if delet successfull
                    readDataDosen()
                } else {
                    Log.e("DeleteDataDosenByNidn() Error", "Error While Delete a data")
                }
            } catch (e : Exception){
                Log.e("deleteDataDosenByNidn() Exception", e.toString())
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