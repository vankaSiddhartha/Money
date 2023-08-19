package com.vanka.chimki.auth.createAccount


import android.content.Context
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.vanka.chimki.ReaptedCode.FragmentIntent.intentFragment
import com.vanka.chimki.ReaptedCode.Loading
import com.vanka.chimki.ReaptedCode.Loading.dismissDialogForLoading
import com.vanka.chimki.ReaptedCode.Loading.showAlertDialogForLoading


class CreateAccountViewModel : ViewModel() {
    private val firebaseAuth = FirebaseAuth.getInstance()

    fun createAccount(email: String, password: String, context: Context, id:Int, fragment: Fragment) {
        showAlertDialogForLoading(context)
        firebaseAuth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    intentFragment(id,fragment,context)
                    dismissDialogForLoading()
                } else {
                    // Sign-in failed
                    val exception = task.exception.toString()
                    // Handle the error
                    Toast.makeText(context, exception, Toast.LENGTH_SHORT).show()
                    dismissDialogForLoading()
                }
            }
    }
}
