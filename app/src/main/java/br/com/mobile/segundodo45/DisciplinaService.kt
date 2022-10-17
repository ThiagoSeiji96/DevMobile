package br.com.mobile.segundodo45

object DisciplinaService {

    fun getDisciplinas(): List<Disciplina> {
        var disciplinas = mutableListOf<Disciplina>()

        for (i in 1..10) {
            var d = Disciplina()
            d.nome = "Disciplina $i"
            d.ementa = "Ementa $i"
            d.professor = "Professor $i"
            d.foto = "https://www.educationcorner.com/images/featured-classroom-design-layout.jpg"
            disciplinas.add(d)
        }
        return disciplinas
    }
}