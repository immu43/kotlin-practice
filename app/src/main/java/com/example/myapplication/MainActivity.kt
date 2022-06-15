package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var _binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        val userId = _binding.etUserName.text?.trim().toString()
        val pass  = _binding.etPass.text?.trim().toString()

        _binding.btnLogin.setOnClickListener {
            val message = arrayListOf<String>(userId, pass)
            val intent = Intent(this, MainActivity2::class.java).apply {
                putExtra("data", message)
            }
            startActivity(intent)
        }

    }
}