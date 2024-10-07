package edu.iesam.superheroes.features.superheroes.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.superheroes.features.superheroes.domain.GetSuperheroUseCase
import edu.iesam.superheroes.features.superheroes.domain.Superhero

class SuperheroDetailViewModel(
    private val getSuperheroUseCase: GetSuperheroUseCase
) : ViewModel() {

    fun viewCreated(superheroId: String): Superhero? {
        return getSuperheroUseCase.invoke(superheroId)
    }
}