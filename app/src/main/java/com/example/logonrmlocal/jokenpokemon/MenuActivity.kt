package com.example.logonrmlocal.jokenpokemon

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        btnJogar.setOnClickListener {
            startActivity(Intent(this, JogarActivity::class.java))
            finish()
        }
    }
}