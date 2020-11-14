package br.com.luizmarcicano.imccalculator

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        skbPeso.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                // Display the current progress of SeekBar
                txtPeso.text = "Peso (em Kg): $i"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })

        skbAltura.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                // Display the current progress of SeekBar
                var aux = i/100.0
                txtAltura.text = "Altura (em metros): $aux"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })

        btnCalcular.setOnClickListener{
            val altura = skbAltura.progress/100.0;
            val peso = skbPeso.progress
            if(altura==0.00 || peso==0){
            Toast.makeText(this, "Preencher campos", Toast.LENGTH_LONG).show()
            } else{
                /*val minhasPreferencias = getSharedPreferences(
                    "dados-$peso",
                    Context.MODE_PRIVATE
                )

                val edicao = minhasPreferencias.edit()
                edicao.putInt("CHAVE_PESO", peso)
                edicao.putFloat("CHAVE_ALTURA", altura.toFloat())

                edicao.apply()
                 */

                var mIntent = Intent(this, ResultActivity::class.java)
                mIntent.putExtra("CHAVE_PESO", peso)
                mIntent.putExtra("CHAVE_ALTURA", altura.toFloat())
                startActivity(mIntent)
                finishAffinity()
            }

        }

    }
}
