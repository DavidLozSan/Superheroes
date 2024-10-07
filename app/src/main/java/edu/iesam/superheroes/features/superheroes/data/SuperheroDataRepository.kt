package edu.iesam.superheroes.features.superheroes.data

import edu.iesam.superheroes.features.superheroes.data.remote.SuperheroRemoteDataSource
import edu.iesam.superheroes.features.superheroes.domain.Superhero
import edu.iesam.superheroes.features.superheroes.domain.SuperheroRepository

class SuperheroDataRepository(
    private val remote: SuperheroRemoteDataSource
) : SuperheroRepository {

    override fun getSuperheroes(): List<Superhero> {
        return remote.getSuperheroes()
    }
}