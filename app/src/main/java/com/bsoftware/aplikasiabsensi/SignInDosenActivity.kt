package com.bsoftware.aplikasiabsensi

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bsoftware.aplikasiabsensi.ui.theme.AplikasiAbsensiTheme

class SignInDosenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AplikasiAbsensiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SignInPageDosen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInPageDosen(){
    var name by remember {mutableStateOf("")}
    var nim by remember { mutableStateOf("") }

    val focusmanager = LocalFocusManager.current
    val context : Context = LocalContext.current
    val activity : Activity? = (LocalContext.current as? Activity)

    Column(
        modifier = Modifier
            .padding(start = 20.dp,end = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = name,
            onValueChange = {name = it},
            modifier = Modifier
                .fillMaxWidth(),
            label = {
                Text(
                    text = "Name",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold
                    )
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            )
        )
        TextField(
            value = nim,
            onValueChange = {nim = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            label = {
                Text(
                    text = "NIM",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold
                    )
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusmanager.clearFocus() }
            )
        )

        OutlinedButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        ) {
            Text(
                text = "Sign In",
                style = TextStyle(
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignInDosenPreview() {
    AplikasiAbsensiTheme {
        SignInPageDosen()
    }
}