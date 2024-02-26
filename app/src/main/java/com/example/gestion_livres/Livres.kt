
import com.google.firebase.firestore.QuerySnapshot

class Livres {
    var Titre = ""
    var Auteur = ""
    var Description = ""
    var photo = ""
    var posseder = false
}

class LivresDAO {

    fun creerlivre(result: QuerySnapshot?): List<Livres> {
        val livres = mutableListOf<Livres>()
        if (result != null) {
            for (document in result) {
                val livre = Livres()
                livre.Titre = document.data["Titre"] as String
                livre.Auteur = document.data["Auteur"] as String
                livre.Description = document.data["Description"] as String
                livre.photo = document.data["photo"] as String
                livre.posseder = document.data["posseder"] as Boolean
                livres.add(livre)
            }
        }
        return livres
    }
}