package edu.iesam.superheroes.features.superheroes.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.superheroes.R
import edu.iesam.superheroes.app.extensions.loadUrl
import edu.iesam.superheroes.features.superheroes.domain.Superhero

class SuperheroDetailActivity : AppCompatActivity() {

    private lateinit var superheroFactory: SuperheroFactory
    private lateinit var viewModel: SuperheroDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero_detail)

        superheroFactory = SuperheroFactory(this)
        viewModel = superheroFactory.buildSuperheroDetailViewModel()

        getSuperheroId()?.let { superheroId ->
            viewModel.viewCreated(superheroId)?.let { superhero ->
                binData(superhero)
            }
        }
    }

    private fun getSuperheroId(): String? {
        return intent.getStringExtra(KEY_SUPERHERO_ID)
    }

    private fun binData(superhero: Superhero) {
        val imageView = findViewById<ImageView>(R.id.superheroImage)
        imageView.loadUrl(superhero.principalData.imageUrl)
        val superheroName = findViewById<TextView>(R.id.superheroName)
        superheroName.text = superhero.principalData.name
        val superheroAlignment = findViewById<TextView>(R.id.superheroAlignment)
        superheroAlignment.text = superhero.biography.alignment
        val superheroGender = findViewById<TextView>(R.id.superheroGender)
        superheroGender.text = superhero.principalData.appearance.gender
        val superheroRace = findViewById<TextView>(R.id.superheroRace)
        superheroRace.text = superhero.principalData.appearance.race
        val superheroHeight = findViewById<TextView>(R.id.superheroHeight)
        superheroHeight.text = superhero.principalData.appearance.height.toString()
        val superheroWeight = findViewById<TextView>(R.id.superheroWeight)
        superheroWeight.text = superhero.principalData.appearance.weight.toString()
        val superheroINT = findViewById<TextView>(R.id.superheroINT)
        superheroINT.text = superhero.principalData.stats.intelligence.toString()
        val superheroSTR = findViewById<TextView>(R.id.superheroSTR)
        superheroSTR.text = superhero.principalData.stats.strength.toString()
        val superheroSPD = findViewById<TextView>(R.id.superheroSPD)
        superheroSPD.text = superhero.principalData.stats.speed.toString()
        val superheroDUR = findViewById<TextView>(R.id.superheroDUR)
        superheroDUR.text = superhero.principalData.stats.durability.toString()
        val superheroPWR = findViewById<TextView>(R.id.superheroPWR)
        superheroPWR.text = superhero.principalData.stats.power.toString()
        val superheroCBT = findViewById<TextView>(R.id.superheroCBT)
        superheroCBT.text = superhero.principalData.stats.combat.toString()
    }

    companion object {
        val KEY_SUPERHERO_ID = "key_superhero_id"

        fun getIntent(context: Context, superheroId: String): Intent {
            val intent = Intent(context, SuperheroDetailActivity::class.java)
            intent.putExtra(KEY_SUPERHERO_ID, superheroId)
            return intent
        }
    }
}