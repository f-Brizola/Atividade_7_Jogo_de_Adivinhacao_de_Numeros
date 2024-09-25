package com.example.atividade_7_jogo_de_adivinhacao_de_numeros

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val random = Random
        val randomIntRange = random.nextInt(1,101)


        val inputPalpite = findViewById<EditText>(R.id.edPalpite)
        val resultado = findViewById<TextView>(R.id.resultado)
        val botaoVerificar = findViewById<Button>(R.id.btnVerificar)

        botaoVerificar.setOnClickListener {

            val palpite = inputPalpite.text.toString()
            val numRandom = randomIntRange

            if (palpite.isNotEmpty()){

                val palpiteInt = palpite.toInt()

                if(numRandom == palpiteInt){
                    resultado.setText("Parabéns! Você acertou $randomIntRange")
                }else if (palpiteInt < numRandom){
                    resultado.setText("Seu palpite é muito baixo $palpiteInt")
                }else if (palpiteInt > numRandom){
                    resultado.setText("Seu palpite é muito alto $palpiteInt")
                }

            }else{
                resultado.setText("Insira um palpite")
            }

        }

    }

    fun limparValores(view: View){
        val inputPalpite = findViewById<EditText>(R.id.edPalpite)
        val resultado = findViewById<TextView>(R.id.resultado)

        inputPalpite.setText("")
        resultado.setText("")
    }
}