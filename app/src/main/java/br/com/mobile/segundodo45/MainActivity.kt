package br.com.mobile.segundodo45

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import br.com.mobile.segundodo45.databinding.LoginBinding

class MainActivity : DebugActivity() {
    private val binding by lazy {
        LoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.imagemLogin.setImageResource(R.drawable.image_login)
        binding.textoLogin.text = "Nova mensagem de login"

        binding.botaoLogin.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
            Toast.makeText(this, "Clicou em login", Toast.LENGTH_LONG).show()

            val intent = Intent(this, TelaInicialActivity::class.java)
            val params = Bundle()
            params.putString("nome", "Thiago")
            params.putInt("numero", 10)

            intent.putExtras(params)

            val nome_usuario = binding.campoUsuario.text.toString()
            intent.putExtra("nome_usuario", nome_usuario)

            startActivity(intent)
        }
    }
}