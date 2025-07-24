package com.example.calisthenicsquest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class AuthViewModel : ViewModel() {
    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    var authState = MutableLiveData<AuthState>()
        private set

    init {
        checkAuthStatus()
    }

    private fun checkAuthStatus() {
        authState.value =
            if (firebaseAuth.currentUser == null) AuthState.UnAuthenticated else AuthState.Authenticated
    }

    fun login(email: String, password: String) {
        authState.value = AuthState.Loading
        if(email.isEmpty() || password.isEmpty()){
            authState.value = AuthState.Error("Email and Password can't be empty")
            return
        }

        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) authState.value = AuthState.Authenticated
            else authState.value = AuthState.Error(task.exception?.localizedMessage ?: "Something went wrong. Please try again.")
        }
    }

    fun signUp(email: String, password: String) {
        authState.value = AuthState.Loading
        if(email.isEmpty() || password.isEmpty()){
            authState.value = AuthState.Error("Email and Password can't be empty")
            return
        }

        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) authState.value = AuthState.Authenticated
            else authState.value = AuthState.Error(task.exception?.localizedMessage ?: "Something went wrong. Please try again.")
        }
    }

    fun signOut() {
        firebaseAuth.signOut()
        authState.value = AuthState.UnAuthenticated
    }

}

sealed class AuthState {
    data object Authenticated : AuthState()
    data object UnAuthenticated : AuthState()
    data object Loading : AuthState()
    data class Error(val message: String) : AuthState()
}