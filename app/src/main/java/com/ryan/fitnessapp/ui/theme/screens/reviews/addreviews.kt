package com.ryan.fitnessapp.ui.theme.screens.reviews

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ryan.fitnessapp.data.reviewmodel
import com.ryan.fitnessapp.navigation.ROUTE_MAIN
import com.ryan.fitnessapp.navigation.ROUTE_REVIEWS
import com.ryan.fitnessapp.navigation.ROUTE_UPDATE_ID

@Composable
fun Reviewscreen(navController: NavController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var context = LocalContext.current
        Text(
            text = "Add Review",
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.Red,
            modifier = Modifier.padding(20.dp),
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline
        )

        var productName by remember { mutableStateOf(TextFieldValue("")) }
        var productQuantity by remember { mutableStateOf(TextFieldValue("")) }
        var productPrice by remember { mutableStateOf(TextFieldValue("")) }

        OutlinedTextField(
            value = productName,
            onValueChange = { productName = it },
            label = { Text(text = "Name of Reviewer*") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = productQuantity,
            onValueChange = { productQuantity = it },
            label = { Text(text = "Type in your review *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))



        OutlinedTextField(
            value = productPrice,
            onValueChange = { productPrice = it },
            label = { Text(text = "Where do we need to improve*") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )





        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {

            val productRepository = reviewmodel(navController, context)
            productRepository.saveProduct(
                productName.text.trim(), productQuantity.text.trim(),
                productPrice.text
            )

            navController.navigate(ROUTE_REVIEWS)


        }) {
            Text(text = "Save")
        }


        Button(onClick = {navController.navigate(ROUTE_MAIN)
        },
            modifier = Modifier.width(90.dp),

            ) {
            Text(text = "Back",
                fontSize = 15.sp)

        }

    }
}

@Preview
@Composable
private fun Reviewprev() {
    Reviewscreen(navController = rememberNavController())
}