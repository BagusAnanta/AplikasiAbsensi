package com.bsoftware.aplikasiabsensi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.bsoftware.aplikasiabsensi.ui.theme.AplikasiAbsensiTheme

class CreateDosenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AplikasiAbsensiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CreatePage()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreatePage(){
    // in here we decrare remember mutablestate
    // in "Hadir","Sakit","Izin","Alpha","tangga" we set a default 0, except tanggal, you can use function getDate
    var nidn by remember{ mutableStateOf("") }
    var nama by remember{ mutableStateOf("") }
    var matakuliah by remember { mutableStateOf("") }
    var jurusanmengajar by remember { mutableStateOf("") }
    var jammasuk by remember { mutableStateOf("") }
    var jamkeluar by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
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


    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CreateDosenPreview() {
    AplikasiAbsensiTheme {
        CreatePage()
    }
}