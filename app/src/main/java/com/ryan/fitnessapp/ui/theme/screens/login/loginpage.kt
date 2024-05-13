package com.ryan.fitnessapp.ui.theme.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ryan.fitnessapp.data.AuthModel
import com.ryan.fitnessapp.navigation.ROUTE_REGISTER



@Composable
fun Fitness(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember {
        mutableStateOf("")
    }

    val context= LocalContext.current



    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)


    ) {
        Text(
            text = "Welcome Back",
            fontFamily = FontFamily.SansSerif,
            fontSize = 50.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold

        )
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Login to your account",
            fontFamily = FontFamily.SansSerif,
            fontSize = 25.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold

        )
        Spacer(modifier = Modifier.height(50.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "email") },
            label = { Text(text = "User Name / E-mail"
                , color = Color.Red,
                fontFamily = FontFamily.Serif) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password=it },
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "password") },
            label = { Text(text = "Enter password" , color = Color.Red,
                fontFamily = FontFamily.Serif) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        )
        Spacer(modifier = Modifier.height(15.dp))




        Button(onClick = {
            val mylogin=  AuthModel(navController, context )
            mylogin.login(email.trim(),password.trim())

            },
            modifier = Modifier.width(300.dp)) {
            Text(text = "Login",
                fontSize = 25.sp)

        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Don't have an account?",
            fontFamily = FontFamily.SansSerif,
            fontSize = 20.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold

        )



        TextButton(onClick = {navController.navigate(ROUTE_REGISTER)},
            modifier = Modifier.width(300.dp)) {
            Text(text = "Sign up",
                fontSize = 25.sp)

        }

    }


}




@Preview
@Composable
private fun Loginprev() {
    Fitness(navController = rememberNavController())
}

