package com.vanka.chimki.auth.uploadProfile

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.storage.FirebaseStorage
import com.vanka.chimki.ReaptedCode.Loading.dismissDialogForLoading
import com.vanka.chimki.ReaptedCode.Loading.showAlertDialogForLoading
import java.util.*
import kotlin.contracts.contract

class UploadProfileViewModel : ViewModel() {

    // Initialize Firebase authentication and storage instances
    private val auth = FirebaseAuth.getInstance()
    private val storage = FirebaseStorage.getInstance()
    private val storageReference = storage.reference

    // Function to upload image to Firebase Storage
    fun uploadImageToFirebase(imageUri: Uri, requireContext: Context) {
        val sharedPreferences = requireContext.getSharedPreferences("userData", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        // Show loading dialog using a utility function
        showAlertDialogForLoading(requireContext)

        // Get the current user
        val user = auth.currentUser
        user?.let {
            val userId = it.uid

            // Create a storage reference for the image with a unique name
            val storageRef = storageReference.child("profile/$userId/${UUID.randomUUID()}")

            // Upload the image file to Firebase Storage
            storageRef.putFile(imageUri)
                .addOnSuccessListener {
                    // Once the image is successfully uploaded, get its download URL
                    storageRef.downloadUrl.addOnSuccessListener { imgLink ->
                        // Save the image URL in a shared object for later use
                        editor.putString("profile",imgLink.toString())
                        editor.apply()


                        // Dismiss the loading dialog using a utility function
                          dismissDialogForLoading()
                    }
                }
                .addOnFailureListener {
                    // If image upload fails, show an error message
                    Toast.makeText(requireContext, "Image upload failed", Toast.LENGTH_SHORT).show()
                }
        }
    }
}
