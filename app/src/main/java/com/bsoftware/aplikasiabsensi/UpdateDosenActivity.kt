package com.bsoftware.aplikasiabsensi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bsoftware.aplikasiabsensi.dataViewModel.DosenViewModel
import com.bsoftware.aplikasiabsensi.dateClass.GetDate
import com.bsoftware.aplikasiabsensi.ui.theme.AplikasiAbsensiTheme

class UpdateDosenActivity : ComponentActivity() {

    private val dosenViewModel : DosenViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AplikasiAbsensiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UpdatePage()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdatePage(dosenViewModel: DosenViewModel = DosenViewModel()){
    var nidn by remember{ mutableStateOf("") }
    var nama by remember{ mutableStateOf("") }
    var matakuliah by remember { mutableStateOf("") }
    var jurusanmengajar by remember { mutableStateOf("") }
    var hadir by remember { mutableStateOf("") }
    var sakit by remember { mutableStateOf("") }
    var izin by remember { mutableStateOf("") }
    var alpha by remember { mutableStateOf("") }
    var jammasuk by remember { mutableStateOf("") }
    var jamkeluar by remember { mutableStateOf("") }
    var tanggaltidakhadir by remember { mutableStateOf("") }

    val tanggal : String? = GetDate().getDateNow()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
       LazyColumn{
           item {
               TextField(
                   value = nidn,
                   onValueChange = {nidn = it},
                   label = {
                       Text(
                           text = "Masukkan NIDN",
                           style = TextStyle(
                               fontWeight = FontWeight.Bold
                           )
                       )
                   },
                   modifier = Modifier.fillMaxWidth()

               )
               TextField(
                   value = nama,
                   onValueChange = {nama = it},
                   label = {
                       Text(
                           text = "Masukkan Nama Dosen",
                           style = TextStyle(
                               fontWeight = FontWeight.Bold
                           )
                       )
                   },
                   modifier = Modifier
                       .fillMaxWidth()
                       .padding(top = 10.dp)
               )
               TextField(
                   value = matakuliah,
                   onValueChange = {matakuliah = it},
                   label = {
                       Text(
                           text = "Masukkan Matakuliah",
                           style = TextStyle(
                               fontWeight = FontWeight.Bold
                           )
                       )
                   },
                   modifier = Modifier
                       .fillMaxWidth()
                       .padding(top = 10.dp)
               )
               TextField(
                   value = jurusanmengajar,
                   onValueChange = {jurusanmengajar = it},
                   label = {
                       Text(
                           text = "Masukkan Jurusan Mengajar",
                           style = TextStyle(
                               fontWeight = FontWeight.Bold
                           )
                       )
                   },
                   modifier = Modifier
                       .fillMaxWidth()
                       .padding(top = 10.dp)
               )
               TextField(
                   value = hadir,
                   onValueChange = {hadir = it},
                   label = {
                       Text(
                           text = "Masukkan jumlah hadir (angka)",
                           style = TextStyle(
                               fontWeight = FontWeight.Bold
                           )
                       )
                   },
                   modifier = Modifier
                       .fillMaxWidth()
                       .padding(top = 10.dp)
               )
               TextField(
                   value = sakit,
                   onValueChange = {sakit = it},
                   label = {
                       Text(
                           text = "Masukkan jumlah sakit (angka)",
                           style = TextStyle(
                               fontWeight = FontWeight.Bold
                           )
                       )
                   },
                   modifier = Modifier
                       .fillMaxWidth()
                       .padding(top = 10.dp)
               )
               TextField(
                   value = izin,
                   onValueChange = {izin = it},
                   label = {
                       Text(
                           text = "Masukkan jumlah izin (angka)",
                           style = TextStyle(
                               fontWeight = FontWeight.Bold
                           )
                       )
                   },
                   modifier = Modifier
                       .fillMaxWidth()
                       .padding(top = 10.dp)
               )
               TextField(
                   value = alpha,
                   onValueChange = {alpha = it},
                   label = {
                       Text(
                           text = "Masukkan jumlah alpha (angka)",
                           style = TextStyle(
                               fontWeight = FontWeight.Bold
                           )
                       )
                   },
                   modifier = Modifier
                       .fillMaxWidth()
                       .padding(top = 10.dp)
               )
               TextField(
                   value = jammasuk,
                   onValueChange = {jammasuk = it},
                   label = {
                       Text(
                           text = "Masukkan Jam Masuk",
                           style = TextStyle(
                               fontWeight = FontWeight.Bold
                           )
                       )
                   },
                   modifier = Modifier
                       .fillMaxWidth()
                       .padding(top = 10.dp)
               )
               TextField(
                   value = jamkeluar,
                   onValueChange = {jamkeluar = it},
                   label = {
                       Text(
                           text = "Masukkan Jam Keluar",
                           style = TextStyle(
                               fontWeight = FontWeight.Bold
                           )
                       )
                   },
                   modifier = Modifier
                       .fillMaxWidth()
                       .padding(top = 10.dp)
               )
               TextField(
                   value = tanggaltidakhadir,
                   onValueChange = {tanggaltidakhadir = it},
                   label = {
                       Text(
                           text = "Masukkan tanggal tidak masuk",
                           style = TextStyle(
                               fontWeight = FontWeight.Bold
                           )
                       )
                   },
                   modifier = Modifier
                       .fillMaxWidth()
                       .padding(top = 10.dp)
               )
               Button(
                   onClick = {
                       dosenViewModel.updateDataDosen(
                           nidn = nidn,
                           nama = nama,
                           matakuliah = matakuliah,
                           jurusanmengajar = jurusanmengajar,
                           hadir = hadir.toInt(),
                           sakit = sakit.toInt(),
                           izin = izin.toInt(),
                           alpha = alpha.toInt(),
                           jammasuk = jammasuk,
                           jamkeluar = jamkeluar,
                           tanggal = tanggal,
                           tanggaltidakhadir = tanggaltidakhadir
                       )
                   },
                   modifier = Modifier
                       .fillMaxWidth()
                       .padding(top = 10.dp)
               ) {
                   Text(text = "Update Data")
               }
           }
       }
    }
}


@Preview(showBackground = true)
@Composable
fun UpdateDosenPreview() {
    AplikasiAbsensiTheme {
        // preview in here
        UpdatePage()
    }
}