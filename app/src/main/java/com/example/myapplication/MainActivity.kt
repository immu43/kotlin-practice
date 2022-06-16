package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var _binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)






        _binding.btnLogin.setOnClickListener {
            val userId = _binding.etUserName.text?.trim().toString()
            val pass  = _binding.etPass.text?.trim().toString()
            if(_binding.etUserName.text.toString() == ""){
                _binding.etUserName.error = "Please Enter Your Email/Mobile Number"

            }
            if(_binding.etPass.text.toString() == ""){
                _binding.etPass.error = "Please Enter Your Password"
            }
            val intent = Intent(this, MainActivity2::class.java)
            if(userId.isNotEmpty() && pass.isNotEmpty()){
                if (userId.lowercase() == "imran" && pass.lowercase() == "1234"){
                    startActivity(intent)
                }else{
                    Toast.makeText(baseContext, "Your Email or Password is Wrong", Toast.LENGTH_SHORT).show();
                }

            }

        }

    }
}