package com.example.fakestore.presentation.ui.screenRegister

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.fakestore.R
import com.example.fakestore.presentation.navigation.Screen

@Composable
fun ScreenRegister(modifier: Modifier, navController: NavHostController = rememberNavController()) {
    var checked by remember { mutableStateOf(false) }
    var email by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(CardDefaults.cardColors().containerColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(top = 16.dp, bottom = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(Icons.Default.Close, contentDescription = "exit", modifier = Modifier.clickable{
                navController.popBackStack(
                    Screen.LoginScreen.route,
                    inclusive = false
                )
            })
            Text(
                "Create Account",
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold
                ),
                textAlign = TextAlign.Center
            )
        }

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(0.9f),
            onValueChange = {email = it},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            maxLines = 1,
            singleLine = true,
            label = { Text(stringResource(R.string.email)) },
            value = email,
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(0.9f),
            onValueChange = {name = it},
            label = { Text(stringResource(R.string.name)) },
            value = name,
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(0.9f),
            onValueChange = {username = it},
            label = { Text(stringResource(R.string.username)) },
            value = username,
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(0.9f),
            onValueChange = { phoneNumber = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            maxLines = 1,
            singleLine = true,
            label = { Text(stringResource(R.string.phone_number)) },
            value = phoneNumber,
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(0.9f),
            onValueChange = {password = it},
            label = { Text(stringResource(R.string.password)) },
            value = password,
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(0.9f),
            onValueChange = {confirmPassword = it},
            label = { Text(stringResource(R.string.confirm_password)) },
            value = confirmPassword,
        )

        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier.fillMaxWidth(0.9f),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it }
            )
            Text(
                "I agree with the terms of service and privacy policy"
            )
        }

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(bottom = 16.dp),
            shape = RoundedCornerShape(12.dp),
        ) {
            Text(stringResource(R.string.sign_up))
        }

    }
} 