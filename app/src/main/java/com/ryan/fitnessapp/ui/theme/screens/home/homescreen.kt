package com.ryan.fitnessapp.ui.theme.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ryan.fitnessapp.navigation.ROUTE_LOGIN
import com.ryan.fitnessapp.navigation.ROUTE_REGISTER

@Composable
fun FitnessHome(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)


    ) {
        Text(
            text = "FITNESS APP",
            fontFamily = FontFamily.SansSerif,
            fontSize = 28.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold

        )
        Spacer(modifier = Modifier.height(90.dp))
        Text(
            text = "A healthy body for a better you",
            fontFamily = FontFamily.Default,
            fontSize = 25.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold

        )
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "This application ensures you achieve your dream body and ensures you live a more healthy life.",
            fontFamily = FontFamily.Default,
            fontSize = 20.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold

        )

        Spacer(modifier = Modifier.height(80.dp))

        Button(
            onClick = { navController.navigate(ROUTE_LOGIN) },
            modifier = Modifier.width(300.dp)
        ) {
            Text(
                text = "Sign in",
                fontSize = 25.sp
            )

        }


        Spacer(modifier = Modifier.height(40.dp))

        TextButton(onClick = {navController.navigate(ROUTE_REGISTER)},
            modifier = Modifier.width(300.dp)) {
            Text(text = "Create an account",
                fontSize = 25.sp)

        }


    }


}

@Preview
@Composable
private fun Homeprev() {
    FitnessHome(navController = rememberNavController())}



