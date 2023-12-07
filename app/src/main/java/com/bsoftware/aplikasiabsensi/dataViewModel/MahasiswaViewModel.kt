package com.bsoftware.aplikasiabsensi.dataViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bsoftware.aplikasiabsensi.dataClass.MahasiswaDataClass
import com.bsoftware.aplikasiabsensi.databaseAPIInterface.MahasiswaDatabaseAPI
import com.bsoftware.aplikasiabsensi.retrofitInit.RetrofitInitial
import kotlinx.coroutines.launch

class MahasiswaViewModel : ViewModel() {
    private val apiInterfaceMahasiswa = RetrofitInitial().retrofitMahasiswa.create(MahasiswaDatabaseAPI::class.java)
    private val mutableListMahasiswaData = MutableLiveData<List<MahasiswaDataClass>>()
    val livedataMahasiswaData : LiveData<List<MahasiswaDataClass>> = mutableListMahasiswaData

    private var connectionStatus : Boolean = false
    // read data mahasiswa in here
    fun readDataMahasiswa(){
        viewModelScope.launch {
            try {
                val getDataMahasiswa = apiInterfaceMahasiswa.readMahasiswaData()
                mutableListMahasiswaData.postValue(getDataMahasiswa)
            } catch (e : Exception){
                Log.e("readDataMahasiswa() Exception", e.toString())
                // setconnectionstatus in here
                setConnectionStatus(false)
            }
        }
    }

    // create data mahasiswa in here
    fun createDataMahasiswa(nim : String?, nama : String?, kelas : String?, jurusan : String?, keterangan : String?, tanggal : String?){
        viewModelScope.launch {
            try {
                val createDataMahasiswa = apiInterfaceMahasiswa.createMahasiswaData(nim,nama,kelas,jurusan,keterangan,tanggal)
            } catch (e : Exception){
                Log.e("createDataMahasiswa() Exception", e.toString())
            }
        }
    }

    // update data mahasiswa in here
    fun updateDataMahasiswa(nim : String?, nama : String?, kelas : String?, jurusan : String?, keterangan : String?, tanggal : String?){
        viewModelScope.launch {
            try{
                val updateMahasiswaData = apiInterfaceMahasiswa.updateMahasiswaData(nim,nama,kelas,jurusan,keterangan,tanggal)
            } catch (e : Exception){
                Log.e("updateDataMahasiswa() Exception", e.toString())
            }
        }
    }

    //delete data mahasiswa in here
    fun deleteDataMahasiswaByNim(nim : String?){
        viewModelScope.launch {
            try {
                val deleteMahasiswaData = apiInterfaceMahasiswa.deleteMahasiswaDataByNim(nim)
            } catch (e : Exception){
                Log.e("deleteDataMahasiswaByNim() Exception", e.toString())
            }
        }
    }

    private fun setConnectionStatus(isConnection : Boolean){
        connectionStatus = isConnection
    }

    fun getConnectionStatus() : Boolean{
        return connectionStatus
    }
}