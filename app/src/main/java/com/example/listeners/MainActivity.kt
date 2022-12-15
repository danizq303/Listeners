package com.example.listeners

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.example.listeners.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            if (binding.textView3.text.toString().isNotEmpty())
                binding.textView3.text = (binding.textView3.text.toString().toInt() + 1).toString()
        }

        binding.button2.setOnClickListener {
            if (binding.textView3.text.toString().isNotEmpty())
                if (binding.textView3.text.toString().toInt() > 0)
                    binding.textView3.text = (binding.textView3.text.toString().toInt() - 1).toString()
        }

        binding.editTextNumber3.addTextChangedListener { text ->
            if (text.isNullOrEmpty())
                binding.textView3.text = "0"
            else
                binding.textView3.text = text.toString()
        }

        binding.editTextNumber3.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                binding.button.setBackgroundColor(Color.parseColor("#FF0000"))
                binding.button2.setBackgroundColor(Color.parseColor("#FF0000"))

                binding.textView3.text = binding.editTextNumber3.text.toString()
            } else {
                binding.button.setBackgroundColor(resources.getColor(R.color.purple_500))
                binding.button2.setBackgroundColor(resources.getColor(R.color.purple_500))
            }

        }
    }
}