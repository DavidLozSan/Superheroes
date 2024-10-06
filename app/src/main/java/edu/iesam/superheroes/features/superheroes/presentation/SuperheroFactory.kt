package edu.iesam.superheroes.features.superheroes.presentation

import edu.iesam.superheroes.features.superheroes.data.SuperheroDataRepository
import edu.iesam.superheroes.features.superheroes.data.remote.SuperheroRemoteDataSource
import edu.iesam.superheroes.features.superheroes.domain.GetSuperheroesUseCase

class SuperheroFactory {

    private val superheroRemote = SuperheroRemoteDataSource()
    private val superheroDataRepository = SuperheroDataRepository(superheroRemote)
    private val getSuperheroesUseCase = GetSuperheroesUseCase(superheroDataRepository)

    fun buildViewModel(): SuperheroesViewModel {
        return SuperheroesViewModel(getSuperheroesUseCase)
    }
}