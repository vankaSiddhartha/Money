package com.vanka.chimki.auth.createAccount

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.FirebaseApp
import com.vanka.chimki.R
import com.vanka.chimki.ReaptedCode.FragmentIntent.intentFragment
import com.vanka.chimki.ReaptedCode.Loading.dismissDialogForLoading
import com.vanka.chimki.ReaptedCode.Loading.showAlertDialogForLoading
import com.vanka.chimki.databinding.FragmentCreateAccountBinding



class CreateAccountFragment : Fragment() {
 private lateinit var binding:FragmentCreateAccountBinding
 private lateinit var createAccountViewModel:CreateAccountViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        FirebaseApp.initializeApp(requireContext())
        binding = FragmentCreateAccountBinding.inflate(inflater, container, false)
        createAccountViewModel = ViewModelProvider(this)[CreateAccountViewModel::class.java]

        // Inflate the layout for this fragment
        // Observe the loading state to show/hide loading indicator
        createAccountViewModel.loadingState.observe(requireActivity()) { isLoading ->
            if (isLoading) {
                dismissDialogForLoading()
                intentFragment(R.id.authFrame,ChooseAuthFragment(),requireContext())
            } else {
                showAlertDialogForLoading(requireContext())
            }
        }

        binding.nextBtn.setOnClickListener {
            val email = binding.emailCaTv.text.toString()
            val password = binding.passwordCaEt.text.toString()

           checkNullValuesInET(email,password)
        }
        return binding.root
    }

    private fun checkNullValuesInET(email: String, password: String) {
        showAlertDialogForLoading(requireContext())
        if (email.isNotEmpty()&&password.isNotEmpty()){
            createAccountViewModel.createAccount(email,password)
        }else{
            Toast.makeText(requireContext(), "Error!!", Toast.LENGTH_SHORT).show()
        }
    }



}