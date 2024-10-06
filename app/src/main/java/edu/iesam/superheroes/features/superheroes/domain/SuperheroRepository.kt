package edu.iesam.superheroes.features.superheroes.domain

interface SuperheroRepository {

    fun getSuperheroes(): List<Superhero>

    fun getSuperhero(superheroId: String): Superhero?
}