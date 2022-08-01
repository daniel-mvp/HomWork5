package com.example.homwork5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.homwork5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var isLemur = false
    var isCat = false
    var isDog = false
    private var nameAnimal = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            btnDog.setOnClickListener {
                binding.ivCapture.setImageResource(R.drawable.dog)
                isLemur = false
                isDog = true
                isCat = false
                nameAnimal = "Dog"
            }
            btnCat.setOnClickListener {
                ivCapture.setImageResource(R.drawable.cat)
                isLemur = false
                isDog = false
                isCat = true
                nameAnimal = "Cat"
            }

            btnGiraffe.setOnClickListener {
                binding.ivCapture.setImageResource(R.drawable.lemur)
                isLemur = true
                isDog = false
                isCat = false
                nameAnimal = "Lemur"
            }

            btnThatDog.setOnClickListener {
                if (isDog) {
                    Toast.makeText(applicationContext, "Верно", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(applicationContext, "Неверно", Toast.LENGTH_LONG).show()
                }
            }

            btnThatCat.setOnClickListener {
                if (isCat) {
                    Toast.makeText(applicationContext, "Верно", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(applicationContext, "Неверно", Toast.LENGTH_LONG).show()
                }
            }

            btnThatGiraffe.setOnClickListener {
                if (isLemur) {
                    Toast.makeText(applicationContext, "Верно", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(applicationContext, "Неверно", Toast.LENGTH_LONG).show()
                }
            }

            btnSend.setOnClickListener {
                val intent: Intent = Intent(this@MainActivity, ResultActivity::class.java)
                intent.putExtra("key", nameAnimal)
                startActivity(intent)
            }
        }
    }
}