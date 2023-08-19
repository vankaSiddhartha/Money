package com.vanka.chimki.auth.createAccount

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.vanka.chimki.R
import com.vanka.chimki.ReaptedCode.FragmentIntent.intentFragment
import com.vanka.chimki.auth.uploadProfile.UploadProfileFragment
import com.vanka.chimki.databinding.FragmentUploadNameBinding

class UploadName : Fragment() {

private lateinit var binding:FragmentUploadNameBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUploadNameBinding.inflate(inflater,container,false)
        val sharedPreferences = requireContext().getSharedPreferences("userData", Context.MODE_PRIVATE)
        // Inflate the layout for this fragment
        val editor = sharedPreferences.edit()


        binding.nextBtn.setOnClickListener {
            if (binding.nameEt.text.toString().isNotEmpty() ) {
                editor.putString("name",binding.nameEt.text.toString())
                editor.apply()
                intentFragment(R.id.authFrame,UploadProfileFragment(), requireContext())
            }
            else{
                Toast.makeText(requireContext(), "Empty is not allowed!!", Toast.LENGTH_SHORT).show()
            }


        }
        return binding.root
    }


}