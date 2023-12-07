package com.bsoftware.aplikasiabsensi

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bsoftware.aplikasiabsensi.ui.theme.AplikasiAbsensiTheme

class OptionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AplikasiAbsensiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    OptionPage()
                }
            }
        }
    }
}

@Composable
fun OptionPage(){

    val context : Context = LocalContext.current
    val activity : Activity? = (LocalContext.current as? Activity)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                // intent into SignInDosenActivity
                context.startActivity(Intent(context,SignInDosenActivity::class.java))
                activity?.finish()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Sign In Sebagai Dosen")
        }

        Button(
            onClick = {
               // intent into SignInAdminAcitivy
               context.startActivity(Intent(context,SignInAdminActivity::class.java))
                activity?.finish()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Sign In Sebagai Admin")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview2() {
    AplikasiAbsensiTheme {
        OptionPage()
    }
}