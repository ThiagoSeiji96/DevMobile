package br.com.mobile.segundodo45

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.mobile.segundodo45.DisciplinaService.getDisciplinas
import br.com.mobile.segundodo45.databinding.ActivityTelaInicialBinding
import com.google.android.material.navigation.NavigationView

class TelaInicialActivity : DebugActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val binding by lazy {
        ActivityTelaInicialBinding.inflate(layoutInflater)
    }

    private var disciplinas = listOf<Disciplina>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val params = intent.extras
        //val nome = params?.getString("nome")
        //val numero = params?.getInt("numero")
        //Toast.makeText(this, "Nome: $nome, Número: $numero", Toast.LENGTH_LONG).show()

        val nome_usuario = params?.getString("nome_usuario")
        //binding.mensagemTelaInicial.text = "Olá $nome_usuario"
        //val senha_usuario = params?.getString("senha_usuario")
        //binding.mensagemTelaInicial.text = "Sua senha é $senha_usuario"

        setSupportActionBar(binding.toolbarInclude.toolbar)

        supportActionBar?.title = "Disciplinas"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        configuraMenuLateral()

        binding.recyclerDisciplinas?.layoutManager = LinearLayoutManager(this)
        binding.recyclerDisciplinas?.setHasFixedSize(true)
    }

    override fun onResume(){
        super.onResume()
        disciplinas = DisciplinaService.getDisciplinas()
        binding.recyclerDisciplinas?.adapter = DisciplinaAdapter(disciplinas) {
            onClickDisciplina(it)
        }
    }

    fun onClickDisciplina(disciplina: Disciplina) {
        Toast.makeText(this, "Clicou na disciplina", Toast.LENGTH_LONG).show()

        var it = Intent(this, DisciplinaActivity::class.java)
        it.putExtra("disciplina", disciplina)
        startActivity(it)
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
            Toast.makeText(this, "Clicou atualizar", Toast.LENGTH_SHORT).show()
        }

        else if (id == R.id.action_config) {
            Toast.makeText(this, "Clicou config", Toast.LENGTH_LONG).show()
        }
        else if (id == android.R.id.home) {
            finish()
        }

        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_disciplinas -> {
                Toast.makeText(this, "Clicou em disciplinas", Toast.LENGTH_LONG).show()
            }
            R.id.nav_configuracoes -> {
                Toast.makeText(this, "Clicou em configurações", Toast.LENGTH_LONG).show()
            }
            R.id.nav_localizacao -> {
                Toast.makeText(this, "Clicou em localização", Toast.LENGTH_LONG).show()
            }
        }
        binding.layoutMenuLateral.closeDrawer(GravityCompat.START)
        return true
    }

    private fun configuraMenuLateral(){
        var toggle = ActionBarDrawerToggle(this, binding.layoutMenuLateral,
            binding.toolbarInclude.toolbar,R.string.abrir,R.string.fechar)
        binding.layoutMenuLateral.addDrawerListener(toggle)
        toggle.syncState()

        binding.menuLateral.setNavigationItemSelectedListener(this)
    }

}