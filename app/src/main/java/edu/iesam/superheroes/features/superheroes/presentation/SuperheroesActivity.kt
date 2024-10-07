package edu.iesam.superheroes.features.superheroes.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.superheroes.R
import edu.iesam.superheroes.features.superheroes.domain.Superhero

class SuperheroesActivity : AppCompatActivity() {

    private lateinit var superheroFactory: SuperheroFactory
    private lateinit var viewModel: SuperheroesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superheroes)

        superheroFactory = SuperheroFactory()
        viewModel = superheroFactory.buildViewModel()

        val superheroes = viewModel.viewCreated()
        binData(superheroes)
    }

    private fun binData(superheroes: List<Superhero>) {

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = SuperheroAdapter(superheroes) {
            //cambiar a vista de superhero detallada
        }
    }
}