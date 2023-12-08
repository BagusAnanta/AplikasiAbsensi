package com.bsoftware.aplikasiabsensi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.bsoftware.aplikasiabsensi.dataClass.DosenDataClass
import com.bsoftware.aplikasiabsensi.dataViewModel.DosenViewModel
import com.bsoftware.aplikasiabsensi.ui.theme.AplikasiAbsensiTheme

class ReadDosenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AplikasiAbsensiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ReadPage()
                }
            }
        }
    }
}

@Composable
fun ReadPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ){
            items(2){
                Card(
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth()
                ) {

                }
            }
        }
    }
}

fun GetDosenData(dosenviewmodel : DosenViewModel = DosenViewModel(),lifecycleOwner: LifecycleOwner) : List<DosenDataClass>{
    var nidn : String?
    var nama : String?
    var matakuliah : String?
    var jurusanmengajar : String?
    var hadir : Int?
    var sakit : Int?
    var izin : Int?
    var alpha : Int?
    var jammasuk : String?
    var jamkeluar : String?
    var tanggal : String?
    var tanggaltidakhadir : String?

    val listData = listOf<DosenDataClass>()

    dosenviewmodel.livedataDosenData.observe(lifecycleOwner, Observer { dosendata ->
        for(dataDosen in dosendata){
            nidn = dataDosen.nidn
            nama = dataDosen.nama
            matakuliah = dataDosen.matakuliah
            jurusanmengajar = dataDosen.jurusanmengajar
            hadir = dataDosen.hadir
            sakit = dataDosen.sakit
            izin = dataDosen.izin
            alpha = dataDosen.alpha
            jammasuk = dataDosen.jammasuk
            jamkeluar = dataDosen.jamkeluar
            tanggal = dataDosen.tanggal
            tanggaltidakhadir = dataDosen.tanggaltidakhadir

            listData.forEach {
                it.nidn = nidn
                it.nama = nama
                it.matakuliah = matakuliah
                it.jurusanmengajar = jurusanmengajar
                it.hadir = hadir
                it.sakit = sakit
                it.izin = izin
                it.alpha = alpha
                it.jammasuk = jammasuk
                it.jamkeluar = jamkeluar
                it.tanggal = tanggal
                it.tanggaltidakhadir = tanggaltidakhadir
            }

        }
    })
    dosenviewmodel.readDataDosen()
    return listData
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ReadDosenPreview() {
    AplikasiAbsensiTheme {
        ReadPage()
    }
}