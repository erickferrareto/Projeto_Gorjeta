package com.example.myapplication3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        val howMuch = findViewById<TextView>(R.id.textView)

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                howMuch.text = "$p1" + "%"

                //Criando a porcentagem
                val porcentagem      = p1.toDouble()
                val prices           = findViewById<TextInputEditText>(R.id.price)
                val tips             = findViewById<TextView>(R.id.tips)
                var pagamento        = prices.getText().toString()
                var pagamentoNumero  = pagamento.toDouble()
                var porcenta         = ((porcentagem / 100) * pagamentoNumero)

                tips.setText("R$ " + Math.round(porcenta))

                //Criando o Total
                var total = findViewById<TextView>(R.id.total)
                var totalFim = (porcenta + pagamentoNumero)
                total.text = "R$ " + Math.round(totalFim)
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })


    }
}
