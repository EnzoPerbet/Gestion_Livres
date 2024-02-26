package com.example.gestion_livres

import ListeViewHolder
import Livres
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView


class ListeAdapter : RecyclerView.Adapter<ListeViewHolder>() {
    var mlivre = listOf<Livres>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListeViewHolder {
        val context = viewGroup.context
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_list, viewGroup, false)
        return ListeViewHolder(itemView)
    }

    override fun onBindViewHolder(listeViewHolder: ListeViewHolder, position: Int) {
        val livre = mlivre[position]
        listeViewHolder.updatelivre(livre)

        val fond = if (livre.posseder) R.color.green else R.color.red
        listeViewHolder.itemView.setBackgroundColor(ContextCompat.getColor(listeViewHolder.itemView.context, fond))

        listeViewHolder.itemView.setOnClickListener {
            val intent = Intent(listeViewHolder.itemView.context, DetailActivity::class.java).apply {
                putExtra("titre", livre.Titre)
                putExtra("auteur", livre.Auteur)
                putExtra("description", livre.Description)
                putExtra("photo", livre.photo)
                putExtra("posseder", livre.posseder)
            }
            listeViewHolder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = mlivre.size
}