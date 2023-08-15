package com.vanka.chimki.splaeshScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.auth.FirebaseAuth
import com.vanka.chimki.MainActivity
import com.vanka.chimki.databinding.ActivitySplaeshScreenBinding
import kotlinx.coroutines.MainScope

class SplaeshScreen : AppCompatActivity() {
    private lateinit var binding:ActivitySplaeshScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplaeshScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Handler(mainLooper).postDelayed({
            if (FirebaseAuth.getInstance().currentUser!=null){
                startActivity(Intent(this, MainActivity::class.java))
            }else{
                startActivity(Intent(this,MainActivity::class.java))
            }

        },1000)
    }
}