package com.example.indofriendly.data.model

data class User(
    val id: Int,
    val fullName: String,
    val email: String,
    val role: String
)

data class LoginRequest(
    val email: String,
    val password: String
)

data class RegisterRequest(
    val fullName: String,
    val email: String,
    val password: String,
    val role: String
)

data class AuthResponse(
    val accessToken: String,
    val refreshToken: String,
    val user: User
)