package com.example.fakestore.presentation.ui.screenLogin

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fakestore.domain.useCase.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import android.util.Patterns.EMAIL_ADDRESS
import com.example.fakestore.R
import com.example.fakestore.data.pref.TokenPref.setInstancesPref
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ViewModelLogin @Inject constructor(
    val useCase: UseCase,
    @ApplicationContext val context: Context
) : ViewModel() {
    var errorEmail by mutableStateOf<String?>(null)
    var errorPassword by mutableStateOf<String?>(null)

    fun validatePassword(password: String) {
        errorPassword = when {
            password.isBlank() -> context.getString(R.string.the_password_cannot_be_empty)
            password.length < 6 -> context.getString(R.string.the_password_must_have_at_least_6_characters)
            else -> null
        }
    }

    fun validateEmail(email: String) {
        errorEmail = when {
            email.isBlank() -> context.getString(R.string.the_email_cannot_be_empty)
            !EMAIL_ADDRESS.matcher(email)
                .matches() -> context.getString(R.string.Invalid_email_format)

            else -> null
        }
    }

    fun login(email: String, password: String, result:(Boolean)-> Unit) {

        viewModelScope.launch {
            validateEmail(email)
            validatePassword(password)
            if (errorEmail == null && errorPassword == null) {
                val response = useCase.auth.login(email = email, password = password)

                 response.onSuccess {
                     setInstancesPref(context, it.accessToken)
                     result(true)
                }.onFailure {
                    Timber.d(it.message)
                     result(false)
                }
            }
        }
    }
}

