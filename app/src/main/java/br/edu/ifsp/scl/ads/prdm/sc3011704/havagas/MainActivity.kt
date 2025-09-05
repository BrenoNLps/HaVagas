package br.edu.ifsp.scl.ads.prdm.sc3011704.havagas

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.ifsp.scl.ads.prdm.sc3011704.havagas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val formacoes = resources.getStringArray(R.array.formacoes)

        binding.formacaoSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selecionado = formacoes[position]
                binding.camposAdicionais.removeAllViews()

                when (selecionado) {
                    "Fundamental", "Médio" -> {
                        binding.camposAdicionais.addView(criarCampo("Ano de formatura"))
                    }
                    "Graduação", "Especialização" -> {
                        binding.camposAdicionais.addView(criarCampo("Ano de conclusão"))
                        binding.camposAdicionais.addView(criarCampo("Instituição"))
                    }
                    "Mestrado", "Doutorado" -> {
                        binding.camposAdicionais.addView(criarCampo("Ano de conclusão"))
                        binding.camposAdicionais.addView(criarCampo("Instituição"))
                        binding.camposAdicionais.addView(criarCampo("Título da monografia"))
                        binding.camposAdicionais.addView(criarCampo("Orientador"))
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        binding.telefoneRg.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.telefone_fixo_rb,R.id.telefone_celular_rb -> {
                    binding.telefoneEt.visibility = View.VISIBLE
                }
                else -> {
                    binding.telefoneEt.visibility = View.GONE
                }
            }
        }

        binding.enviarBt.setOnClickListener {
            val nome = binding.nomeEt.text.toString()
            val email = binding.emailEt.text.toString()
            val receberEmail = when(binding.receberEmailCb.isChecked){
                true -> "Sim"
                false -> "Não"
            }
            val telefone = binding.telefoneEt.text.toString()
            val sexo = when (binding.sexoRg.checkedRadioButtonId) {
                R.id.masculino_rb -> "Masculino"
                R.id.feminino_rb -> "Feminino"
                else -> ""
                }
            val formacao = binding.formacaoSpinner.selectedItem.toString()
            val vagasInteresse = binding.vagasInteresseEt.text.toString()
            val camposAdicionais = mutableListOf<String>()
            for (i in 0 until binding.camposAdicionais.childCount) {
                val campo = binding.camposAdicionais.getChildAt(i) as EditText
                if (campo.text.isNotEmpty()) {
                    camposAdicionais.add(campo.text.toString())
                }
                else{
                    camposAdicionais.add("Não informado")

                }
                val mensagem = """
                    Nome: $nome
                    E-mail: $email
                    Receber vagas por e-mail: $receberEmail
                    Telefone: $telefone
                    Sexo: $sexo
                    Formação: $formacao
                    Sobre Formação: ${camposAdicionais.joinToString(", ")}
                    Vagas de Interesse: $vagasInteresse
                """.trimIndent()

                AlertDialog.Builder(this)
                    .setTitle("Confirmação")
                    .setMessage(mensagem)
                    .setPositiveButton("OK") { _, _ -> }
                    .setNegativeButton("Cancelar") { _, _ -> }
                    .show()

            }

        }
    }

    private fun criarCampo(hint: String): EditText {
        val campo = EditText(this)
        campo.hint = hint
        campo.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        return campo
    }

}