package br.com.mobile.segundodo45

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class DisciplinaAdapter (
    val disciplinas: List<Disciplina>,
    val onClick: (Disciplina) -> Unit):
    RecyclerView.Adapter<DisciplinaAdapter.DisciplinaViewHolder>() {
        class DisciplinaViewHolder(view: View): RecyclerView.ViewHolder(view) {

            val cardNome: TextView
            var cardImage: ImageView
            var cardView: CardView

            init {
                cardNome = view.findViewById(R.id.cardNome)
                cardImage = view.findViewById(R.id.cardImage)
                cardView = view.findViewById(R.id.cardDisciplinas)
            }
        }

        override fun getItemCount() = this.disciplinas.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisciplinaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_disciplina,parent,
        false)

        val holder = DisciplinaViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: DisciplinaViewHolder, position: Int) {

        val disciplina = this.disciplinas[position]

        holder.cardNome.text = disciplina.nome

        Picasso.with(holder.itemView.context).load(disciplina.foto).fit().into(holder.cardImage,
            object: com.squareup.picasso.Callback {
                override fun onError() {

                }

                override fun onSuccess() {

                }
        })

        holder.itemView.setOnClickListener {onClick(disciplina)}

    }

}