package com.rafael.firstapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rafael.firstapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // ViewBinding: dá acesso direto aos elementos do XML (activity_main.xml)
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        enableEdgeToEdge()
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Referências dos elementos da tela
        val editTextEmail = binding.editText        // campo de e-mail
        val editTextSenha = binding.editTextSenha   // campo de senha (novo)
        val button = binding.button                 // botão "Entrar"

        // Ao clicar no botão, lê os dois campos e mostra em um Toast
        button.setOnClickListener {
            val email = editTextEmail.text.toString()
            val senha = editTextSenha.text.toString()

            Toast.makeText(
                this,
                "Email: $email\nSenha: $senha",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}