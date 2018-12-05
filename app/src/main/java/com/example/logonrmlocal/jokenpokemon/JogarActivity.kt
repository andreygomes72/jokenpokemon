package com.example.logonrmlocal.jokenpokemon

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_jogar.*
import java.util.*

class JogarActivity : AppCompatActivity() {

    val AGUA = 0
    val FOGO = 1
    val GRAMA = 2

    var playerSelection = AGUA
    var androidSelection = AGUA

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogar)

        ivAgua.setOnClickListener {
            ivPlayer.setImageResource(R.drawable.squirtle)
            playerSelection = AGUA
            setAndroidSelection()
        }

        ivFogo.setOnClickListener {
            ivPlayer.setImageResource(R.drawable.charmander)
            playerSelection = FOGO
            setAndroidSelection()
        }

        ivGrama.setOnClickListener {
            ivPlayer.setImageResource(R.drawable.bulbasaur)
            playerSelection = GRAMA
            setAndroidSelection()
        }
    }

    fun setAndroidSelection() {
        var computerSelection = Random().nextInt(3)
        var computerImage: Int?

        when (computerSelection) {
            AGUA -> {
                computerImage = R.drawable.squirtle
                androidSelection = AGUA
            }
            FOGO -> {
                computerImage = R.drawable.charmander
                androidSelection = FOGO
            }

            GRAMA -> {
                computerImage =  R.drawable.bulbasaur
                androidSelection = GRAMA
            }
            else -> {
                computerImage = R.drawable.botao_azul
                androidSelection = AGUA
            }
        }
        ivComputer.setImageResource(computerImage!!)
        checkResult()
    }

    fun checkResult() {
        var resultado = "empate"

        if (playerSelection == AGUA) {
            if (androidSelection == GRAMA) {
                resultado = "derrota"
            }
            if (androidSelection == FOGO) {
                resultado = "vitoria"
            }
        }

        if (playerSelection == FOGO) {
            if (androidSelection == AGUA) {
                resultado = "derrota"
            }
            if (androidSelection == GRAMA) {
                resultado = "vitoria"
            }
        }

        if (playerSelection == GRAMA) {
            if (androidSelection == FOGO) {
                resultado = "derrota"
            }
            if (androidSelection == AGUA) {
                resultado = "vitoria"
            }
        }

        when (resultado) {
            "derrota" -> {
                tvResultado.text = "Você perdeu!"
                tvResultado.setTextColor(Color.parseColor("#ff0000"))
            }
            "vitoria" -> {
                tvResultado.text = "Você ganhou!"
                tvResultado.setTextColor(Color.parseColor("#00ff00"))
            }
            else -> {
                tvResultado.text = "Empate!"
                tvResultado.setTextColor(Color.parseColor("#000000"))
            }
        }
    }
}