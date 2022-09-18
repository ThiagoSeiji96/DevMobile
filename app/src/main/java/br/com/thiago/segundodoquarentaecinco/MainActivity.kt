package br.com.thiago.segundodoquarentaecinco

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import br.com.thiago.segundodoquarentaecinco.databinding.ActivityTelaInicialBinding
import br.com.thiago.segundodoquarentaecinco.databinding.LoginBinding

class MainActivity : DebugActivity() {

    private val binding by lazy { //binding é só o nome dado a variavel pelo método que usamos
        LoginBinding.inflate(layoutInflater) // o arquivo interpreta o nome do arquivo xml
        // sempre com a primeira letra maiuscula e sem traços ou underlines
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root) // para acessar a tela utilize o "binding.root"

        binding.imagemLogin.setImageResource(R.drawable.imagem_login)
        // binding.usuarioLabel.text = "olha só eu mudei" irá alterar o texto "Usuario" em cima do
        // input de usuario

        binding.botaoLogin.setOnClickListener {
            Toast.makeText(this, "Clicou em login", Toast.LENGTH_LONG).show()

            val intent = Intent(this, tela_inicial_activity::class.java) //navegação de
            // tela em tela
            val params = Bundle()
            params.putString("nome", "Fernanado")
            params.putInt("numero", 10)
            intent.putExtras(params)

            val nome_usuario = binding.campoUsuario.text.toString() //obtendo valor do campo de usuario
            intent.putExtra("nome_usuario", nome_usuario)

            startActivity(intent)
        }
    }
}