package com.example.fakestore.presentation.ui.screenLogin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.fakestore.R
import com.example.fakestore.presentation.common.sharedComponents.ValidateError
import com.example.fakestore.presentation.common.sharedComponents.validateOffFocus
import com.example.fakestore.presentation.navigation.Screen
import com.example.fakestore.presentation.ui.screenLogin.components.LinkSocial
import com.example.fakestore.presentation.ui.screenLogin.components.ModalLogin

@Composable
fun ScreenLogin(
    modifier: Modifier,
    navController: NavHostController = rememberNavController(),
    viewModelLogin: ViewModelLogin = hiltViewModel()
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight(0.4f)
                .fillMaxWidth(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                painterResource(R.drawable.header_imagen),
                contentDescription = "header",
                modifier = Modifier.fillMaxHeight(0.95f)
            )
        }

        ModalLogin(
            Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    stringResource(R.string.welcome_back),
                    style = MaterialTheme.typography.displayMedium,
                    modifier = Modifier.padding(top = 16.dp)
                )

                Column(modifier = Modifier.fillMaxWidth(0.9f)) {
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .validateOffFocus {
                                viewModelLogin.validateEmail(email)
                            },
                        onValueChange = { email = it },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        maxLines = 1,
                        isError = viewModelLogin.errorEmail != null,
                        singleLine = true,
                        label = { Text(stringResource(R.string.email)) },
                        value = email,
                    )
                    ValidateError(error = viewModelLogin.errorEmail)
                }

                Column(modifier = Modifier.fillMaxWidth(0.9f)) {
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth().validateOffFocus{
                            viewModelLogin.validatePassword(password)
                        },
                        onValueChange = { password = it },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        maxLines = 1,
                        isError = viewModelLogin.errorPassword != null,
                        singleLine = true,
                        visualTransformation = if (!showPassword)
                            PasswordVisualTransformation() else VisualTransformation.None,
                        trailingIcon = {
                            IconButton({showPassword = !showPassword}) {
                                Icon(
                                    imageVector = if (showPassword) Icons.Default.VisibilityOff else
                                        Icons.Default.Visibility,
                                    contentDescription = "password"
                                )
                            }
                        },
                        label = { Text(stringResource(R.string.password)) },
                        value = password,
                    )
                    ValidateError(error = viewModelLogin.errorPassword)
                }

                Row(modifier = Modifier.fillMaxWidth()) {
                    Spacer(modifier = Modifier.fillMaxWidth(0.05f))
                    Text(
                        stringResource(R.string.forgot_password),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                Button(
                    {viewModelLogin.login(
                        email = email,
                        password = password
                    ) {
                        if (it) navController.navigate(Screen.HomeScreen.route){
                            launchSingleTop = true
                            popUpTo(Screen.LoginScreen.route){
                                inclusive = true
                            }
                        }
                    }},
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth(0.9f)
                ) {
                    Text(stringResource(R.string.sign_in))
                }
                Text(stringResource(R.string.or_sign_in_with))

                Row(modifier = Modifier.fillMaxWidth(0.9f)) {
                    LinkSocial(
                        modifier = Modifier
                            .weight(1f),
                        painter = painterResource(R.drawable.facebook),
                        text = "Facebook",
                        contentDescription = stringResource(R.string.authenticate_with_facebook)
                    )

                    Spacer(modifier = Modifier.weight(0.05f))

                    LinkSocial(
                        modifier = Modifier
                            .weight(1f),
                        painter = painterResource(R.drawable.google),
                        text = "Google",
                        contentDescription = stringResource(R.string.authenticate_with_google)
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        stringResource(R.string.don_t_have_an_account),
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        modifier = Modifier.clickable {
                            navController.navigate(Screen.RegisterScreen.route) {
                                launchSingleTop = true
                            }
                        },
                        text = stringResource(R.string.sign_up),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}
