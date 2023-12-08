package com.bsoftware.aplikasiabsensi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.bsoftware.aplikasiabsensi.dataClass.DosenDataClass
import com.bsoftware.aplikasiabsensi.dataViewModel.DosenViewModel
import com.bsoftware.aplikasiabsensi.ui.theme.AplikasiAbsensiTheme
import kotlinx.coroutines.runBlocking

class ReadDosenActivity : ComponentActivity() {

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
                    val dosenData by dosenViewModel.livedataDosenData.observeAsState(emptyList())
                    ReadPage(dosenData)
                }
            }
        }
        dosenViewModel.readDataDosen()
    }
}

@Composable
fun ReadPage(dosenDataList : List<DosenDataClass>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(dosenDataList) { item ->
                Card(
                    modifier = Modifier
                        .height(300.dp)
                        .fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(10.dp)
                    ) {
                        Column {
                            Text(text = stringResource(id = R.string.nidn, item.nidn!!))
                            Text(text = stringResource(id = R.string.name, item.nama!!))
                            Text(text = stringResource(id = R.string.matakuliah, item.matakuliah!!))
                            Text(text = stringResource(id = R.string.jurusanmengajar,item.jurusanmengajar!!))
                            Text(text = stringResource(id = R.string.jammasuk, item.jammasuk!!))
                            Text(text = stringResource(id = R.string.jamkeluar, item.jamkeluar!!))
                            Text(text = stringResource(id = R.string.tanggal, item.tanggal!!))
                            Text(text = stringResource(id = R.string.tanggaltidakhadir,item.tanggaltidakhadir!!))
                            Text(text = stringResource(id = R.string.hadir,item.hadir!!))
                            Text(text = stringResource(id = R.string.izin, item.izin!!))
                            Text(text = stringResource(id = R.string.sakit, item.sakit!!))
                            Text(text = stringResource(id = R.string.alpha, item.alpha!!))
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ReadDosenPreview() {
    AplikasiAbsensiTheme {
        // ReadPage()
    }
}