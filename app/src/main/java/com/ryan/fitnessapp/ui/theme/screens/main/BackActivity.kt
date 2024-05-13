package com.ryan.fitnessapp.ui.theme.screens.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ryan.fitnessapp.MainActivity
import com.ryan.fitnessapp.R
import com.ryan.fitnessapp.navigation.ROUTE_MAIN
import com.ryan.fitnessapp.ui.theme.FitnessAppTheme

class BackActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FitnessAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")





                }
            }
        }
    }


}



@Composable
fun Backrow(model: Armsmodel)

{

    val context = LocalContext.current
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .background(Color.Black)
    ) {
        Image(
            painter = painterResource(id = model.image),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .padding(5.dp)
        )
        Text(
            text = model.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
    }


    Spacer(modifier = Modifier.height(20.dp))



}

private val Backworkouts= mutableListOf<Armsmodel>().apply{
    add(Armsmodel("Hyperextension(14)", R.drawable.hyper))
    add(Armsmodel("Pike Push ups(14)", R.drawable.pike))
    add(Armsmodel("Inchworms (16)", R.drawable.inch))
    add(Armsmodel("Cat Cow Pose (30 seconds)", R.drawable.cat))
    add(Armsmodel("Supine push up (14)", R.drawable.supinepushup))
    add(Armsmodel("Reverse snow angels(10)", R.drawable.snowangels))



}

@Composable
fun Backtin(navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        items(Backworkouts) { model ->
            Backrow(model = model)

        }

    }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
    ) {
        // ...
    }


}

@Preview
@Composable
private fun Backprev() {
    Backtin(rememberNavController())
}

