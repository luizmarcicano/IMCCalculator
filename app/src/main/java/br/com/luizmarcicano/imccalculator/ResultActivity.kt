package br.com.luizmarcicano.imccalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*
import java.text.DecimalFormat

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val peso = intent.getIntExtra("CHAVE_PESO", 0)
        val altura = intent.getFloatExtra("CHAVE_ALTURA", 0.toFloat())

        val imc1 = altura*altura;
        val imc2 = peso/imc1;
        val casasDecimais = DecimalFormat("#,##.00")
        val imc3 = casasDecimais.format(imc2)
        txtIMC.text= "IMC: $imc3"
        if(imc2<18.5){
            txtClassificacao.text = "Abaixo do Peso"
        } else if(imc2>18.5 && imc2<24.9){
            txtClassificacao.text = "Peso Ideal"
        } else if(imc2>25.0 && imc2<29.9){
            txtClassificacao.text = "Levemente acima do peso"
        } else if(imc2>30.0 && imc2<34.9){
            txtClassificacao.text = "Obesidade Grau I"
        } else if(imc2>35.0 && imc2<39.9){
            txtClassificacao.text = "Obesidade Grau II (Severa)"
        } else if(imc2>40){
            txtClassificacao.text = "Obesidade Grau III (Mórbida)"
        }


        btnVoltar.setOnClickListener{
            val mIntent = Intent(this, MainActivity::class.java)
            startActivity(mIntent)
            finishAffinity()
        }
    }
}
