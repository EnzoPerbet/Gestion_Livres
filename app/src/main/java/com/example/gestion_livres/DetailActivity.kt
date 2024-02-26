package com.example.gestion_livres

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val titre = intent.getStringExtra("Titre")
        val auteur = intent.getStringExtra("Auteur")
        val description = intent.getStringExtra("Description")
        val photo = intent.getStringExtra("photo")
        val posseder = intent.getBooleanExtra("posseder", false)

        findViewById<TextView>(R.id.titre).text = titre
        findViewById<TextView>(R.id.auteur).text = auteur
        findViewById<TextView>(R.id.description).text = description
        Picasso.get().load(photo).into(findViewById<ImageView>(R.id.photo))
        findViewById<CheckBox>(R.id.checkBox).isChecked = posseder

        val checkbox = findViewById<CheckBox>(R.id.checkBox)

        checkbox.setOnCheckedChangeListener { buttonView, isChecked ->
            val bdd = FirebaseFirestore.getInstance()
            val livresCollection = bdd.collection("Livres")
            if (isChecked) {
                livresCollection.whereEqualTo("Titre", titre).get().addOnSuccessListener { result ->
                    val document = result.documents[0]
                    document.reference.update("Posseder", true)
                }
            } else {
                livresCollection.whereEqualTo("Titre", titre).get().addOnSuccessListener { result ->
                    val document = result.documents[0]
                    document.reference.update("Posseder", false)
                }
            }
        }
        val retourButton = findViewById<Button>(R.id.button_retour)
        retourButton.setOnClickListener {
            finish()
        }
    }
}