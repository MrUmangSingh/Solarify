package com.example.solarify.screens

import android.annotation.SuppressLint
import android.content.ContentValues
import android.util.Log
import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AreaChart
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.solarify.R
import com.example.solarify.navigation.Screen
import com.example.solarify.ui.theme.SolarifyTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@SuppressLint("UnrememberedMutableState")
@Composable
fun SignUp(navController: NavController) {
    val focusManager = LocalFocusManager.current

    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var area by remember {
        mutableStateOf("")
    }
    var name by remember {
        mutableStateOf("")
    }
    val isEmailValid by derivedStateOf { Patterns.EMAIL_ADDRESS.matcher(email).matches() }
    val isPasswordValid by derivedStateOf { password.length > 6 }
    var isPasswordVisible by remember {
        mutableStateOf(false)
    }

    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.mainback),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 10.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.Bottom),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                Modifier.size(100.dp)
            )
            Text(text = "New to Solarify??\n   SignUp baby!!",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                lineHeight = 35.sp
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .padding(all = 10.dp)
                    .fillMaxWidth(0.7f)
            ) {
                OutlinedTextField(value = name,
                    onValueChange = {name= it},
                    textStyle = TextStyle(color = Color.White),
                    label = { Text(text = "Full Name", color = Color.White) },
                    leadingIcon = { Icon(imageVector = Icons.Filled.Person, tint = Color.White ,contentDescription = null) },
                    shape = RoundedCornerShape(18.dp),
                    placeholder = { Text(text = "Umang Singh", color = Color.White) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Down) }
                    )
                )
                OutlinedTextField(value = email,
                    onValueChange = {email = it},
                    textStyle = TextStyle(color = Color.White),
                    label = { Text(text = "Email",color = Color.White) },
                    leadingIcon = { Icon(imageVector = Icons.Filled.Email, tint = Color.White,contentDescription = null) },
                    shape = RoundedCornerShape(18.dp),
                    placeholder = { Text(text = "umangsingh@gmail.com") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Down) }
                    ),
                    isError = !isEmailValid
                )

                OutlinedTextField(value = password,
                    onValueChange = {password = it},
                    textStyle = TextStyle(color = Color.White),
                    label = { Text(text = "Password",color = Color.White) },
                    leadingIcon = { Icon(imageVector = Icons.Filled.Lock,tint = Color.White ,contentDescription = null) },
                    shape = RoundedCornerShape(18.dp),
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Down) }
                    ),
                    isError = !isPasswordValid,
                    trailingIcon = {
                        IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                            Icon(imageVector = if(isPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                                contentDescription = null)
                        }
                    },
                    visualTransformation = if(isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation()
                )

                OutlinedTextField(value = area,
                    onValueChange = {area = it},
                    textStyle = TextStyle(color = Color.White),
                    label = { Text(text = "Area of house in ft sq",color = Color.White) },
                    leadingIcon = { Icon(imageVector = Icons.Filled.AreaChart, tint = Color.White,contentDescription = null) },
                    shape = RoundedCornerShape(18.dp),
                    placeholder = { Text(text = "1200") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { focusManager.clearFocus() }
                    )
                )
            }

            Button(onClick ={

            },
                modifier = Modifier.fillMaxWidth(0.3f),
//                enabled = isEmailValid && isPasswordValid
            ) {
                Text(text = "Sign Up",
                    Modifier.padding(vertical = 8.dp),
                    fontWeight = FontWeight.Bold
                )
            }
            Divider(
                color = Color.White.copy(alpha = 0.3f),
                thickness = 1.dp,
                modifier = Modifier.padding(top = 120.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Already have an account?", color = Color.White)
                TextButton(onClick = {
                    navController.navigate(Screen.SignIn.route)
                }) {
                    Text(text = "Sign In", color = Color.White)
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun Prev1(){
//    SolarifyTheme {
//        SignUp()
//    }
//}