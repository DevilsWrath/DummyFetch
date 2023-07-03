package com.example.dummyfetch

import java.io.Serializable

data class DummyData(
    val id: Int,
    val firstName: String?,
    val lastName: String?,
    val maidenName: String?,
    val age: Int,
    val gender: String?,
    val email: String?,
    val phone: String?,
    val username: String?,
    val password: String?,
    val birthDate: String?
) : Serializable