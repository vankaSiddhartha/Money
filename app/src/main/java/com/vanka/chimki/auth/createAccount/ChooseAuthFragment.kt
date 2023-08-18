package com.vanka.chimki.auth.createAccount

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vanka.chimki.R
import com.vanka.chimki.ReaptedCode.FragmentIntent.intentFragment
import com.vanka.chimki.databinding.FragmentChooseAuthBinding


class ChooseAuthFragment : Fragment() {

 private lateinit var binding:FragmentChooseAuthBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChooseAuthBinding.inflate(LayoutInflater.from(requireContext()))
        binding.createAccount.setOnClickListener {
            intentFragment(R.id.authFrame,CreateAccountFragment(),requireContext())
        }
        // on clicking login button
        binding.login.setOnClickListener {
            //intentFragment(R.id.authFrame,LoginFragment(),requireContext())
        }
        return binding.root
    }


}