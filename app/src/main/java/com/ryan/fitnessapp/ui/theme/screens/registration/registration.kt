package com.ryan.fitnessapp.ui.theme.screens.registration

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ryan.fitnessapp.R
import com.ryan.fitnessapp.data.AuthModel
import com.ryan.fitnessapp.navigation.ROUTE_LOGIN
import com.ryan.fitnessapp.navigation.ROUTE_REGISTER
//import kotlin.coroutines.jvm.internal.CompletedContinuation.context


@Composable
fun Fit(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var pass by remember {
        mutableStateOf("")
    }
    var confirmpass by remember {
        mutableStateOf("")
    }

    var mail by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Black)


    ) {
        Text(
            text = "Registration",
            fontFamily = FontFamily.SansSerif,
            fontSize = 28.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold

        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Create an account",
            fontFamily = FontFamily.SansSerif,
            fontSize = 28.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold

        )

        Spacer(modifier = Modifier.height(50.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "email"
                )
            },
            label = {
                Text(
                    text = "User Name / Mail", color = Color.Red,
                    fontFamily = FontFamily.Serif
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        )
        OutlinedTextField(
            value = mail,
            onValueChange = { mail = it },
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "email") },
            label = {
                Text(
                    text = "user@gmail.com", color = Color.Red,
                    fontFamily = FontFamily.Serif
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = pass,
            onValueChange = { pass = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "password"
                )
            },
            label = {
                Text(
                    text = "Enter password", color = Color.Red,
                    fontFamily = FontFamily.Serif
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            value = confirmpass,
            onValueChange = { confirmpass = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Confirm password"
                )
            },
            label = {
                Text(
                    text = "Confirm password", color = Color.Red,
                    fontFamily = FontFamily.Serif
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))







        Button(
            onClick = { val myregister= AuthModel(navController,context)
                myregister.signup(email.trim(),pass.trim(), confirmpass.trim()) },
            modifier = Modifier.width(300.dp)
        ) {
            Text(
                text = "Sign up",
                fontSize = 25.sp
            )

        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "You can also find us on:",
            fontFamily = FontFamily.SansSerif,
            fontSize = 20.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold

        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .background(Black)
                .padding(40.dp)
        ){
            Image(painter = painterResource(id = R.drawable.ig), contentDescription = "Instagram",
                modifier = Modifier.clickable {  }

            )

            Spacer(modifier = Modifier.height(20.dp))

            Image(painter = painterResource(id = R.drawable.g), contentDescription = "Google",
                modifier = Modifier.clickable {  }

            )
        }










        }
    }






@Preview
@Composable
private fun Registerprev() {
    Fit(navController = rememberNavController())


}
