package com.example.icetask3studentapp

import java.util.Date

data class StudentModel(
    val userid: String,
    val username : String,
    val Qualification: String,
    val StudentNumber: String,
    val categoryID: String,
    val photoURL: String? = null
)