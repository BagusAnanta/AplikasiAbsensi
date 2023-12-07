package com.bsoftware.aplikasiabsensi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.bsoftware.aplikasiabsensi.ui.theme.AplikasiAbsensiTheme

class DeleteDosenActivity : ComponentActivity() {

    private val dosenViewModel :  DosenViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AplikasiAbsensiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DeletePage(dosenViewModel)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeletePage(dosenviewmodel : DosenViewModel = DosenViewModel()) {
    // delete page with nidn number
    var nidn by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
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

        Button(
            onClick = {
               dosenviewmodel.deleteDataDosenByNidn(nidn)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        ) {
            Text(text = "Hapus Data")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DeleteDosenPreview() {
    AplikasiAbsensiTheme {
        DeletePage()
    }
}