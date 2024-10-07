package edu.iesam.superheroes.features.superheroes.presentation

import android.content.Context
import edu.iesam.superheroes.features.superheroes.data.SuperheroDataRepository
import edu.iesam.superheroes.features.superheroes.data.local.SuperheroLocalDataSource
import edu.iesam.superheroes.features.superheroes.data.remote.SuperheroRemoteDataSource
import edu.iesam.superheroes.features.superheroes.domain.GetSuperheroUseCase
import edu.iesam.superheroes.features.superheroes.domain.GetSuperheroesUseCase

class SuperheroFactory(private val context: Context) {

    private val superheroRemote = SuperheroRemoteDataSource()
    private val superheroLocal = SuperheroLocalDataSource(context)
    private val superheroDataRepository = SuperheroDataRepository(superheroRemote, superheroLocal)
    private val getSuperheroesUseCase = GetSuperheroesUseCase(superheroDataRepository)
    private val getSuperheroUseCase = GetSuperheroUseCase(superheroDataRepository)

    fun buildViewModel(): SuperheroesViewModel {
        return SuperheroesViewModel(getSuperheroesUseCase)
    }

    fun buildSuperheroDetailViewModel(): SuperheroDetailViewModel {
        return SuperheroDetailViewModel(getSuperheroUseCase)
    }
}