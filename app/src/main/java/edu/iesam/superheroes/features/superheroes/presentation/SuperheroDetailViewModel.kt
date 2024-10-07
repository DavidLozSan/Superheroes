package edu.iesam.superheroes.features.superheroes.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.superheroes.app.domain.ErrorApp
import edu.iesam.superheroes.features.superheroes.domain.GetSuperheroUseCase
import edu.iesam.superheroes.features.superheroes.domain.Superhero
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SuperheroDetailViewModel(
    private val getSuperheroUseCase: GetSuperheroUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun viewCreated(superheroId: String) {
        _uiState.value = UiState(isLoading = true)

        viewModelScope.launch(Dispatchers.IO) {
            val superhero = getSuperheroUseCase.invoke(superheroId)
            delay(2000)
            _uiState.postValue(UiState(superhero = superhero))
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val superhero: Superhero? = null
    )
}