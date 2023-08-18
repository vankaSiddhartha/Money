package com.vanka.chimki.auth

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import com.vanka.chimki.R
import com.vanka.chimki.ReaptedCode.FragmentIntent.intentFragment
import com.vanka.chimki.auth.createAccount.ChooseAuthFragment
import com.vanka.chimki.databinding.ActivityChooseAuthBinding

class AuthContainerActivity : AppCompatActivity() {
    private lateinit var binding:ActivityChooseAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChooseAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val window: Window = window

        // Set the navigation bar color
        window.navigationBarColor = Color.BLACK
        intentFragment(R.id.authFrame,ChooseAuthFragment(),this)
    }
}