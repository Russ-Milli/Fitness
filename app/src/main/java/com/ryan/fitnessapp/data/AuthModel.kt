package com.ryan.fitnessapp.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.ryan.fitnessapp.model.User

import com.ryan.fitnessapp.navigation.ROUTE_LOGIN
import com.ryan.fitnessapp.navigation.ROUTE_MAIN
import com.ryan.fitnessapp.navigation.ROUTE_REGISTER


class AuthModel(var navController: NavController, var context: Context) {

    var mAuth: FirebaseAuth
    val progress: ProgressDialog

    init {
        mAuth = FirebaseAuth.getInstance()
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("PLease Wait.....")
    }

    fun signup(email: String, pass: String, confpass: String) {
        progress.show()

        if (email.isBlank() || pass.isBlank() || confpass.isBlank()) {
            progress.dismiss()
            Toast.makeText(context, "Please email and password cannot be blank", Toast.LENGTH_LONG)
                .show()
            return
        } else if (pass != confpass) {
            Toast.makeText(context, "Password do not match", Toast.LENGTH_LONG).show()
            return
        } else {
            mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                if (it.isSuccessful) {
                    val userdata = User(email, pass, mAuth.currentUser!!.uid)
                    val regRef = FirebaseDatabase.getInstance().getReference()
                        .child("Users/" + mAuth.currentUser!!.uid)
                    regRef.setValue(userdata).addOnCompleteListener {

                        if (it.isSuccessful) {
                            Toast.makeText(context, "Registered Successfully", Toast.LENGTH_LONG)
                                .show()
                            navController.navigate(ROUTE_LOGIN)

                        } else {
                            Toast.makeText(context, "${it.exception!!.message}", Toast.LENGTH_LONG)
                                .show()
                            navController.navigate(ROUTE_LOGIN)
                        }
                    }
                } else {
                    navController.navigate(ROUTE_REGISTER)
                }

            }
        }

    }

    fun login(email: String, pass: String) {
        progress.show()

        mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Succeffully Logged in", Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_MAIN)
//                navController.navigate(ROUTE_REGISTER)TO TAKE YOU TO A DIIFFERNT PAGE
            } else {
                Toast.makeText(context, "${it.exception!!.message}", Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_LOGIN)
            }
        }

    }

    fun isloggedin():Boolean{
        return mAuth.currentUser !=null
    }

}














