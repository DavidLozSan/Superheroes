package edu.iesam.superheroes.features.superheroes.domain

interface SuperheroRepository {

    fun getSuperheroes(): List<Superhero>
}