package com.example.calisthenicsquest.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class AuthViewModel: ViewModel() {
    val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()


}