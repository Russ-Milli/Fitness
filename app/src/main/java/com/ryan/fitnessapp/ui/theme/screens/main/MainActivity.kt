package com.ryan.fitnessapp.ui.theme.screens.main

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.ryan.fitnessapp.MainActivity
import com.ryan.fitnessapp.navigation.ROUTE_ABS
import com.ryan.fitnessapp.navigation.ROUTE_ADDREVIEWS
import com.ryan.fitnessapp.navigation.ROUTE_ARMS
import com.ryan.fitnessapp.navigation.ROUTE_BACK
import com.ryan.fitnessapp.navigation.ROUTE_CALC
import com.ryan.fitnessapp.navigation.ROUTE_FULLBODY
import com.ryan.fitnessapp.navigation.ROUTE_LEGS
import com.ryan.fitnessapp.navigation.ROUTE_LOGIN
import com.ryan.fitnessapp.navigation.ROUTE_MAIN
//import com.ryan.fitnessapp.navigation.ROUTE_PRODUCTS
import com.ryan.fitnessapp.navigation.ROUTE_REVIEWS


@Composable

fun Mainserver(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)


    ) {
        Text(
            text = "Welcome back!",
            fontFamily = FontFamily.SansSerif,
            fontSize = 28.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold

        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Kindly select the area you would like to focus on.",
            fontFamily = FontFamily.SansSerif,
            fontSize = 15.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold

        )
        Button(onClick = {navController.navigate(ROUTE_LEGS)
        },
            modifier = Modifier.width(300.dp),

                ) {
            Text(text = "Legs",
                fontSize = 15.sp)

        }

        Button(onClick = {navController.navigate(ROUTE_BACK)
        },
            modifier = Modifier.width(300.dp),

            ) {
            Text(text = "Back",
                fontSize = 15.sp)

        }

        Button(onClick = {navController.navigate(ROUTE_FULLBODY)
        },
            modifier = Modifier.width(300.dp),

            ) {
            Text(text = "Full Body",
                fontSize = 15.sp)

        }

        Button(onClick = {navController.navigate(ROUTE_ARMS)
        },
            modifier = Modifier.width(300.dp),

            ) {
            Text(text = "Arms",
                fontSize = 15.sp)

        }

        Button(onClick = {navController.navigate(ROUTE_ABS)
        },
            modifier = Modifier.width(300.dp),

            ) {
            Text(text = "Abs",
                fontSize = 15.sp)

        }

        Spacer(modifier = Modifier.height(20.dp))


            Text(
                text = "Do you know your BMI? ",
                fontFamily = FontFamily.Serif,
                fontSize = 25.sp,
                color = Color.Black
            )

            TextButton(onClick = {navController.navigate(ROUTE_CALC)},
                modifier = Modifier.width(300.dp)) {
                Text(text = "Click here to learn to calculate your BMI",
                    fontSize = 15.sp)

            }


        Spacer(modifier = Modifier.height(20.dp))

        TextButton(onClick = {navController.navigate(ROUTE_ADDREVIEWS)},
            modifier = Modifier.width(300.dp)) {
            Text(text = "Click here to give us feedback on the app",
                fontSize = 15.sp)

        }


        }



}


@Preview
@Composable
private fun Mainprev() {

    Mainserver(navController = rememberNavController())


}
