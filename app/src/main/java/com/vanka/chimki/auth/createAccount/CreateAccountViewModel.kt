package com.vanka.chimki.auth.createAccount


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth


class CreateAccountViewModel : ViewModel() {
    private val firebaseAuth = FirebaseAuth.getInstance()

    // LiveData to observe the loading state
    private val _loadingState = MutableLiveData<Boolean>()
    val loadingState: LiveData<Boolean>
        get() = _loadingState

    // Callback to communicate with the UI layer
    private var loadingCallback: (() -> Unit)? = null

    // Function to set the loading callback
    fun setLoadingCallback(callback: (() -> Unit)?) {
        loadingCallback = callback
    }

    // Function to create a new account
    fun createAccount(email: String, password: String) {
        // Show loading indicator

        // Set the callback to show the loading dialog in the UI layer
        loadingCallback?.invoke()

        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                _loadingState.value = false // Hide loading indicator

                // Call the callback to dismiss the loading dialog in the UI layer
                loadingCallback?.invoke()

                if (task.isSuccessful) {
                    _loadingState.value = true
                    // Account creation succeeded
                } else {
                    _loadingState.value = false
                    // Account creation failed
                    val exception = task.exception.toString()
                    // Handle the error, such as displaying a Toast
                }
            }
    }
}
