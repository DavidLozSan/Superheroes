package edu.iesam.superheroes.features.superheroes.data

import edu.iesam.superheroes.features.superheroes.data.local.SuperheroLocalDataSource
import edu.iesam.superheroes.features.superheroes.data.remote.SuperheroRemoteDataSource
import edu.iesam.superheroes.features.superheroes.domain.Superhero
import edu.iesam.superheroes.features.superheroes.domain.SuperheroRepository

class SuperheroDataRepository(
    private val remote: SuperheroRemoteDataSource,
    private val local: SuperheroLocalDataSource
) : SuperheroRepository {

    override fun getSuperheroes(): List<Superhero> {
        val superheroesFromLocal = local.findAll()
        if (superheroesFromLocal.isEmpty()) {
            val superheroesFromRemote = remote.getSuperheroes()
            local.saveAll(superheroesFromRemote)
            return superheroesFromRemote
        } else {
            return superheroesFromLocal
        }
    }

    override fun getSuperhero(superheroId: String): Superhero? {
        val localSuperhero = local.findById(superheroId)
        if (localSuperhero == null) {
            remote.getSuperhero(superheroId)?.let {
                local.save(it)
                return it
            }
        }
        return localSuperhero
    }
}