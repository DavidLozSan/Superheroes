package edu.iesam.superheroes.features.superheroes.domain

class GetSuperheroesUseCase(private val superheroRepository: SuperheroRepository) {

    operator fun invoke(): List<Superhero> {
        return superheroRepository.getSuperheroes()
    }
}