package com.ryan.fitnessapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ryan.fitnessapp.ui.theme.screens.calculatebmi.Calculatorscreen
//import com.ryan.fitnessapp.ui.theme.review.Reviews
//import com.ryan.fitnessapp.ui.theme.review.Reviewscreen
//import com.ryan.fitnessapp.ui.theme.review.Productscreen
import com.ryan.fitnessapp.ui.theme.screens.home.FitnessHome
import com.ryan.fitnessapp.ui.theme.screens.login.Fitness
import com.ryan.fitnessapp.ui.theme.screens.main.Abstin
import com.ryan.fitnessapp.ui.theme.screens.main.Backtin
import com.ryan.fitnessapp.ui.theme.screens.main.Customtin
import com.ryan.fitnessapp.ui.theme.screens.main.Fulltin
import com.ryan.fitnessapp.ui.theme.screens.main.Legtin
//import com.ryan.fitnessapp.ui.theme.screens.main.Arms
//import com.ryan.fitnessapp.ui.theme.screens.main.Legs
import com.ryan.fitnessapp.ui.theme.screens.main.Mainserver
import com.ryan.fitnessapp.ui.theme.screens.registration.Fit
import com.ryan.fitnessapp.ui.theme.screens.reviews.Reviews
import com.ryan.fitnessapp.ui.theme.screens.reviews.Reviewscreen
//import com.ryan.fitnessapp.ui.theme.screens.reviews.UpdateProductsScreen

@Composable
fun Appnavhost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String= ROUTE_HOMEFITNESS
) { NavHost(navController = navController,
    modifier= modifier,
    startDestination=startDestination){


    composable(ROUTE_HOMEFITNESS){
        FitnessHome(navController)
    }
    composable(ROUTE_LOGIN){
        Fitness(navController)
    }
    composable(ROUTE_REGISTER){
        Fit(navController)
    }
    composable(ROUTE_MAIN){
        Mainserver(navController)
    }
    composable(ROUTE_ADDREVIEWS){
        Reviewscreen(navController)

    }
    composable(ROUTE_ARMS){
        Customtin(navController)

    }
    composable(ROUTE_BACK){
        Backtin(navController)
    }
composable(ROUTE_FULLBODY){
    Fulltin(navController)

}
composable(ROUTE_LEGS){
    Legtin(navController)
}

    composable(ROUTE_REVIEWS){
        Reviews(navController)
    }



composable(ROUTE_ABS){
    Abstin(navController)
}

    composable(ROUTE_CALC){
     Calculatorscreen(navController)
    }
}

}