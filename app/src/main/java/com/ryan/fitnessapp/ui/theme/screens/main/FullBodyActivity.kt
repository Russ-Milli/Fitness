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
//import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ryan.fitnessapp.MainActivity
import com.ryan.fitnessapp.R
import com.ryan.fitnessapp.navigation.ROUTE_MAIN
import com.ryan.fitnessapp.ui.theme.FitnessAppTheme


class FullBodyActivity : ComponentActivity() {
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
fun Fullrow(model: Armsmodel)



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

private val Fullworkouts= mutableListOf<Armsmodel>().apply{
    add(Armsmodel("Burpees(14)", R.drawable.burpees))
    add(Armsmodel("Push ups(14)", R.drawable.push))
    add(Armsmodel("Mountain Climber (16)", R.drawable.mountain))
    add(Armsmodel("Plank (30 seconds)", R.drawable.plank))
    add(Armsmodel("Lunges (14)", R.drawable.lunges))
    add(Armsmodel("Squats (12)", R.drawable.squats))


}

@Composable
fun Fulltin(navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        items(Fullworkouts) { model ->
            Fullrow(model = model)

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
    Fulltin(rememberNavController())
}




