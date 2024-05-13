package com.ryan.fitnessapp.ui.theme.screens.calculatebmi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun Calculatorscreen(navController: NavController) {

    var firstnum by remember { mutableStateOf(TextFieldValue("")) }
    var secondnum by remember { mutableStateOf(TextFieldValue("")) }
    var answer by remember { mutableStateOf("") }
    val context= LocalContext.current

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)) {

        Text(text = answer,
            color = Color.White,
            fontSize = 30.sp
        )


        Spacer(modifier = Modifier.height(70.dp))
        OutlinedTextField(
            value =firstnum ,
            label = { Text(text = "Enter Weight (Kg)",
                color = Color.White,
                fontSize = 30.sp)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange ={
                firstnum=it

            } )


        Spacer(modifier = Modifier.height(30.dp))
        OutlinedTextField(
            value =secondnum ,
            label = { Text(text = "Enter height (M)",
                color = Color.White,
                fontSize = 30.sp)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange ={

                secondnum=it

            } )
        Spacer(modifier = Modifier.height(30.dp))

        OutlinedButton(
            onClick = {
                val myfirstnum=firstnum.text.trim()
                val mysecondnum=secondnum.text.trim()
                if (myfirstnum.isEmpty() &&mysecondnum.isEmpty()){
                    answer="Please fill in all detail"
                }else{
                    val myanswer=myfirstnum.toDouble() + mysecondnum.toDouble()
                    answer=myanswer.toString()
                }

            },
            colors = ButtonDefaults.buttonColors(Color.Blue),
            shape = RoundedCornerShape(16.dp),


            ) {
            Text(text = "+",
                fontSize = 30.sp)


        }
        Spacer(modifier = Modifier.height(30.dp))

        OutlinedButton(
            onClick = {
                val myfirstnum=firstnum.text.trim()
                val mysecondnum=secondnum.text.trim()
                if (myfirstnum.isEmpty() &&mysecondnum.isEmpty()){
                    answer="Please fill in all detail"
                }else{
                    val myanswer=myfirstnum.toDouble() - mysecondnum.toDouble()
                    answer=myanswer.toString()
                }
            },
            colors = ButtonDefaults.buttonColors(Color.Red),
            shape = RoundedCornerShape(16.dp),


            ) {
            Text(text = "-",
                fontSize = 30.sp)


        }
        Spacer(modifier = Modifier.height(30.dp))

        OutlinedButton(
            onClick = {
                val myfirstnum=firstnum.text.trim()
                val mysecondnum=secondnum.text.trim()
                if (myfirstnum.isEmpty() &&mysecondnum.isEmpty()){
                    answer="Please fill in all detail"
                }else{
                    val myanswer=myfirstnum.toDouble() * mysecondnum.toDouble()
                    answer=myanswer.toString()
                }


            },
            colors = ButtonDefaults.buttonColors(Color.Green),
            shape = RoundedCornerShape(16.dp),


            ) {
            Text(text = "*",
                fontSize = 30.sp)


        }
        Spacer(modifier = Modifier.height(30.dp))

        OutlinedButton(
            onClick = {  val myfirstnum=firstnum.text.trim()
                val mysecondnum=secondnum.text.trim()
                if (myfirstnum.isEmpty() &&mysecondnum.isEmpty()){
                    answer="Please fill in all detail"
                }else{
                    val myanswer=myfirstnum.toDouble() / mysecondnum.toDouble()
                    answer=myanswer.toString()
                } },
            colors = ButtonDefaults.buttonColors(Color.Cyan),
            shape = RoundedCornerShape(16.dp),


            ) {
            Text(text = "/",
                fontSize = 30.sp)


        }
        Spacer(modifier = Modifier.height(10.dp))


        Text(
            text = "Calculate your BMI by dividing your weight against your height in square metres.",
            fontFamily = FontFamily.SansSerif,
            fontSize = 25.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold

        )

    }


}



@Preview
@Composable
private fun Calcprev() {
    Calculatorscreen(navController = rememberNavController())
}