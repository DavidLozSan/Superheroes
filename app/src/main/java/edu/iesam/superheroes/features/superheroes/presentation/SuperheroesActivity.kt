package edu.iesam.superheroes.features.superheroes.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.superheroes.R
import edu.iesam.superheroes.app.domain.ErrorApp
import edu.iesam.superheroes.features.superheroes.domain.Superhero

class SuperheroesActivity : AppCompatActivity() {

    private lateinit var superheroFactory: SuperheroFactory
    private lateinit var viewModel: SuperheroesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superheroes)

        superheroFactory = SuperheroFactory(this)
        viewModel = superheroFactory.buildViewModel()

        setupObserver()

        viewModel.viewCreated()
    }

    private fun setupObserver() {
        val nameObserver = Observer<SuperheroesViewModel.UiState> { uiState ->
            uiState.superheroes?.let {
                binData(it)
            }
            uiState.errorApp?.let {
                showError(it)
            }
            if (uiState.isLoading) {
                Log.d("@dev", "Loading...")
            } else {
                //hide loading
            }
        }
        viewModel.uiState.observe(this, nameObserver)
    }

    private fun binData(superheroes: List<Superhero>) {

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = SuperheroAdapter(superheroes) { superheroId ->
            navigateToSuperheroDetail(superheroId)
        }
    }

    private fun showError(error: ErrorApp) {
        when (error) {
            ErrorApp.DataErrorApp -> TODO()
            ErrorApp.InternetErrorApp -> TODO()
            ErrorApp.ServerErrorApp -> TODO()
            ErrorApp.UnknowErrorApp -> TODO()
        }
    }

    private fun navigateToSuperheroDetail(superheroId: String) {
        startActivity(SuperheroDetailActivity.getIntent(this, superheroId))
    }
}