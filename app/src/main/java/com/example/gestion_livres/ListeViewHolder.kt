import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gestion_livres.R
import com.squareup.picasso.Picasso

class ListeViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun updatelivre(livres : Livres) {
        itemView.findViewById<TextView>(R.id.titre).text = livres.Titre
        itemView.findViewById<TextView>(R.id.auteur).text = livres.Auteur
        itemView.findViewById<TextView>(R.id.description).text = livres.Description
        Picasso.get().load(livres.photo).into(itemView.findViewById<ImageView>(R.id.photo))
    }
}