package com.vanka.chimki.ReaptedCode

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.vanka.chimki.databinding.CustomProgressBarForLoadingLayoutBinding




object Loading {
    private lateinit var loadingDialog: AlertDialog




    private fun loadingProgressBarCreation(context: Context): AlertDialog.Builder {
        val binding: CustomProgressBarForLoadingLayoutBinding = CustomProgressBarForLoadingLayoutBinding.inflate(
            LayoutInflater.from(context)
        )

        val alertDialog = AlertDialog.Builder(context)
        alertDialog.setView(binding.root)
        return alertDialog
    }

  private fun creatingProgressBarForLoading(context: Context): AlertDialog {
        val alertDialogBuilder = loadingProgressBarCreation(context)
        return alertDialogBuilder.create()
    }

    fun showAlertDialogForLoading(context: Context) {
        loadingDialog = creatingProgressBarForLoading(context)
        loadingDialog.setOnShowListener {
            val window = loadingDialog.window
            window?.setBackgroundDrawableResource(android.R.color.transparent)
        }
        loadingDialog.show()
    }

    fun dismissDialogForLoading() {
        loadingDialog.dismiss()
    }


}