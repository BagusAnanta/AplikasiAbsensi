package com.bsoftware.aplikasiabsensi

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bsoftware.aplikasiabsensi.dateClass.GetDate
import com.bsoftware.aplikasiabsensi.ui.theme.AplikasiAbsensiTheme

class HomeAdminActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AplikasiAbsensiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeAdminPage()
                }
            }
        }
    }
}

@Composable
fun HomeAdminPage(){
    val name = "User"

    val context : Context = LocalContext.current
    val activity : Activity? = (LocalContext.current as? Activity)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ){
        Column {
            Text(
                text = "Halo Admin $name",
                style = TextStyle(
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = "Selamat datang di Aplikasi Administrasi Dosen",
                style = TextStyle(
                    fontSize = 15.sp
                )
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .padding(top = 20.dp),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                )
            ) {
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxSize()
                ) {
                    Text(
                        text = "Sistem Management Administasi Dosen",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = "Aplikasi ini merupakan aplikasi sistem administrasi data dosen dan absensi dosen ",
                        modifier = Modifier.padding(top = 5.dp)
                    )
                    Text(
                        text = stringResource(id = R.string.tanggal,GetDate().getDateNow().toString()),
                        modifier = Modifier.padding(top = 10.dp),
                        style = TextStyle(
                            fontWeight = FontWeight.Bold
                        )

                    )
                }
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(440.dp)
                    .padding(top = 30.dp),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                )
            ){
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxSize()
                ){
                    Column {
                        Text(
                            text = "Kartu Aksi Cepat",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Text(
                            text = "Gunakan kartu ini untuk mengatur administrasi dosen",
                            modifier = Modifier.padding(top = 5.dp)
                        )
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center
                    ){
                        Row(
                            modifier = Modifier.padding(top = 10.dp),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Card(
                                modifier = Modifier
                                    .size(120.dp, 130.dp)
                                    .clickable {
                                        context.startActivity(
                                            Intent(
                                                context,
                                                CreateDosenActivity::class.java
                                            )
                                        )
                                    },
                                colors = CardDefaults.elevatedCardColors(
                                    containerColor = Color.White
                                ),
                                shape = RoundedCornerShape(20.dp),
                                elevation = CardDefaults.elevatedCardElevation(
                                    defaultElevation = 6.dp
                                )
                            ) {
                                Column(modifier = Modifier.padding(5.dp)) {
                                    Text(
                                        text = "Buat Data Dosen",
                                        style = TextStyle(
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 15.sp
                                        )
                                    )
                                }
                            }

                            Card(
                                modifier = Modifier
                                    .size(120.dp, 130.dp)
                                    .clickable {
                                        context.startActivity(
                                            Intent(
                                                context,
                                                ReadDosenActivity::class.java
                                            )
                                        )
                                    },
                                colors = CardDefaults.elevatedCardColors(
                                    containerColor = Color.White
                                ),
                                shape = RoundedCornerShape(20.dp),
                                elevation = CardDefaults.elevatedCardElevation(
                                    defaultElevation = 6.dp
                                )
                            ){
                                Column(modifier = Modifier.padding(5.dp)) {
                                    Text(
                                        text = "Lihat Data Dosen",
                                        style = TextStyle(
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 15.sp
                                        )
                                    )
                                }
                            }
                        }

                        Row(
                            modifier = Modifier.padding(top = 10.dp),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Card(
                                modifier = Modifier
                                    .size(120.dp, 130.dp)
                                    .clickable {
                                        context.startActivity(
                                            Intent(
                                                context,
                                                UpdateDosenActivity::class.java
                                            )
                                        )
                                    },
                                colors = CardDefaults.elevatedCardColors(
                                    containerColor = Color.White
                                ),
                                shape = RoundedCornerShape(20.dp),
                                elevation = CardDefaults.elevatedCardElevation(
                                    defaultElevation = 6.dp
                                )
                            ) {
                                Column(modifier = Modifier.padding(5.dp)) {
                                    Text(
                                        text = "Ubah Data Dosen",
                                        style = TextStyle(
                                            fontSize = 15.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                    )
                                }
                            }

                            Card(
                                modifier = Modifier
                                    .size(120.dp, 130.dp)
                                    .clickable {
                                        context.startActivity(
                                            Intent(
                                                context,
                                                DeleteDosenActivity::class.java
                                            )
                                        )
                                    },
                                colors = CardDefaults.elevatedCardColors(
                                    containerColor = Color.White
                                ),
                                shape = RoundedCornerShape(20.dp),
                                elevation = CardDefaults.elevatedCardElevation(
                                    defaultElevation = 6.dp
                                )
                            ){
                                Column(modifier = Modifier.padding(5.dp)) {
                                    Text(
                                        text = "Hapus Data Dosen",
                                        style = TextStyle(
                                            fontSize = 15.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeActivityPreview() {
    AplikasiAbsensiTheme {
        HomeAdminPage()
    }
}