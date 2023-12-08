package com.bsoftware.aplikasiabsensi

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bsoftware.aplikasiabsensi.dataViewModel.DosenViewModel
import com.bsoftware.aplikasiabsensi.dateClass.GetDate
import com.bsoftware.aplikasiabsensi.ui.theme.AplikasiAbsensiTheme

class CreateDosenActivity : ComponentActivity() {

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
                    CreatePage(dosenViewModel)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreatePage(dosenviewmodel : DosenViewModel = DosenViewModel()){
    // in here we decrare remember mutablestate
    // in "Hadir","Sakit","Izin","Alpha","tanggal","tanggal tidak masuk" we set a default 0, except tanggal, you can use function getDate
    var nidn by remember{ mutableStateOf("") }
    var nama by remember{ mutableStateOf("") }
    var matakuliah by remember { mutableStateOf("") }
    var jurusanmengajar by remember { mutableStateOf("") }
    var jammasuk by remember { mutableStateOf("") }
    var jamkeluar by remember { mutableStateOf("") }

    // default value
    val hadir : Int? = 0
    val sakit : Int? = 0
    val izin : Int? = 0
    val alpha : Int? = 0
    val tanggal : String? = GetDate().getDateNow()
    val tanggaltidakmasuk : String? = "-"

    val context : Context = LocalContext.current
    val activity : Activity? = (LocalContext.current as? Activity)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Column{
            Text(
                text = "Buat Data Dosen",
                style = TextStyle(
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = "Isi Data Dosen Dibawah ini dengan sesuai",
                style = TextStyle(
                    fontSize = 15.sp
                )
            )
        }

        Column(
            modifier = Modifier.padding(top = 30.dp)
        ) {
            OutlinedTextField(
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
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),

            )
            OutlinedTextField(
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
                    .padding(top = 10.dp),
                shape = RoundedCornerShape(10.dp)
            )
            OutlinedTextField(
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
                    .padding(top = 10.dp),
                shape = RoundedCornerShape(10.dp)
            )
            OutlinedTextField(
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
                    .padding(top = 10.dp),
                shape = RoundedCornerShape(10.dp)
            )
            OutlinedTextField(
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
                    .padding(top = 10.dp),
                shape = RoundedCornerShape(10.dp)
            )
            OutlinedTextField(
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
                    .padding(top = 10.dp),
                shape = RoundedCornerShape(10.dp)
            )
            Button(
                onClick = {
                    dosenviewmodel.createDataDosen(
                        nidn = nidn,
                        nama = nama,
                        matakuliah = matakuliah,
                        jurusanmengajar = jurusanmengajar,
                        hadir = hadir,
                        sakit = sakit,
                        izin = izin,
                        alpha = alpha,
                        jammasuk = jammasuk,
                        jamkeluar = jamkeluar,
                        tanggal = tanggal,
                        tanggaltidakhadir = tanggaltidakmasuk
                    )
                    // intent back into homeAdminActivity
                    Toast.makeText(context,"Data Berhasil Ditambahkan", Toast.LENGTH_SHORT).show()
                    context.startActivity(Intent(context,HomeAdminActivity::class.java))
                    activity?.finish()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            ) {
                Text(text = "Tambah Data")
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CreateDosenPreview() {
    AplikasiAbsensiTheme {
        CreatePage()
    }
}