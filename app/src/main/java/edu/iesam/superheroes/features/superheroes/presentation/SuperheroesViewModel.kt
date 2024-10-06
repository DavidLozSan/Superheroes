package edu.iesam.superheroes.features.superheroes.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.superheroes.features.superheroes.domain.GetSuperheroesUseCase
import edu.iesam.superheroes.features.superheroes.domain.Superhero

class SuperheroesViewModel(
    private val getSuperheroesUseCase: GetSuperheroesUseCase
) : ViewModel() {

    fun viewCreated(): List<Superhero> {
        return getSuperheroesUseCase.invoke()
    }
}