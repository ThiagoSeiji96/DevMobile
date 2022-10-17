package br.com.mobile.segundodo45

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.mobile.segundodo45.databinding.ActivityDisciplinaBinding

class DisciplinaActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityDisciplinaBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var d = intent.extras?.getSerializable("disciplina") as Disciplina
        binding.nomeDisciplina.text = d.professor
    }
}