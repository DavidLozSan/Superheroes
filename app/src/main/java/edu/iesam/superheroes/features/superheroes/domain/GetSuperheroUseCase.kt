package edu.iesam.superheroes.features.superheroes.domain

class GetSuperheroUseCase(private val superheroRepository: SuperheroRepository) {

    operator fun invoke(superheroId: String): Superhero? {
        return superheroRepository.getSuperhero(superheroId)
    }
}