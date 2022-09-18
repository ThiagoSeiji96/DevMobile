package br.com.thiago.segundodoquarentaecinco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import br.com.thiago.segundodoquarentaecinco.databinding.ActivityTelaInicialBinding

class tela_inicial_activity : DebugActivity() {

    private val binding by lazy {
        ActivityTelaInicialBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //setSupportActionBar(binding.toolbarInclude.toolbar)
        supportActionBar?.title = "Área do usuário"
        //supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val params = intent.extras //extras e intent foram criados na mainActivity
        // é usado para chamar esses valores para aparecerem nessa tela

        val nome = params?.getSerializable("nome") // obtendo valor do params nome
        val numero = params?.getInt("numero")
        Toast.makeText(this, "Nome:$nome, Número $numero", Toast.LENGTH_LONG).show()

        val nome_usuario = params?.getString("nome_usuario")
        binding.mensagemTelaInicial.text = "Olá $nome_usuario"
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_buscar) {
            Toast.makeText(this, "Clicou buscar", Toast.LENGTH_LONG).show()
        }

        else if (id == R.id.action_atualizar) {
            Toast.makeText(this, "Clicou atualizar", Toast.LENGTH_LONG).show()
        }

        else if (id == R.id.action_plus) {
            Toast.makeText(this, "Clicou config", Toast.LENGTH_LONG).show()
        }

        else if (id == android.R.id.home) {
            finish()
        }

        return super.onOptionsItemSelected(item)
    }

}