package com.example.indofriendly.viewmodel

import android.util.Patterns
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class AuthUiState(
    val fullName: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val role: String = "international",
    val fullNameError: String? = null,
    val emailError: String? = null,
    val passwordError: String? = null,
    val confirmPasswordError: String? = null,
    val message: String? = null
)

class AuthViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(AuthUiState())
    val uiState: StateFlow<AuthUiState> = _uiState.asStateFlow()

    fun onFullNameChange(value: String) =
        _uiState.update { it.copy(fullName = value, fullNameError = null, message = null) }

    fun onEmailChange(value: String) =
        _uiState.update { it.copy(email = value, emailError = null, message = null) }

    fun onPasswordChange(value: String) =
        _uiState.update { it.copy(password = value, passwordError = null, message = null) }

    fun onConfirmPasswordChange(value: String) =
        _uiState.update { it.copy(confirmPassword = value, confirmPasswordError = null, message = null) }

    fun onRoleChange(value: String) =
        _uiState.update { it.copy(role = value) }

    fun submitLogin() {
        val s = _uiState.value
        val emailError = validateEmail(s.email)
        val passwordError = if (s.password.isBlank()) "Password is required" else null
        val valid = emailError == null && passwordError == null
        _uiState.update {
            it.copy(
                emailError = emailError,
                passwordError = passwordError,
                message = if (valid) "Form is valid. Server login will be connected next." else null
            )
        }
    }

    fun submitRegister() {
        val s = _uiState.value
        val nameError =
            if (s.fullName.trim().length < 3) "Enter your full name (at least 3 characters)" else null
        val emailError = validateEmail(s.email)
        val passwordError =
            if (s.password.length < 8) "Password must be at least 8 characters" else null
        val confirmError =
            if (s.confirmPassword != s.password) "Passwords do not match" else null
        val valid = listOf(nameError, emailError, passwordError, confirmError).all { it == null }
        _uiState.update {
            it.copy(
                fullNameError = nameError,
                emailError = emailError,
                passwordError = passwordError,
                confirmPasswordError = confirmError,
                message = if (valid) "Form is valid. Server registration will be connected next." else null
            )
        }
    }

    private fun validateEmail(email: String): String? = when {
        email.isBlank() -> "Email is required"
        !Patterns.EMAIL_ADDRESS.matcher(email.trim()).matches() -> "Enter a valid email address"
        else -> null
    }
}
