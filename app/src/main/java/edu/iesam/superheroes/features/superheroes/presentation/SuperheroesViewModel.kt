package edu.iesam.superheroes.features.superheroes.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.superheroes.app.domain.ErrorApp
import edu.iesam.superheroes.features.superheroes.domain.GetSuperheroesUseCase
import edu.iesam.superheroes.features.superheroes.domain.Superhero
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SuperheroesViewModel(
    private val getSuperheroesUseCase: GetSuperheroesUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun viewCreated() {
        _uiState.value = (UiState(isLoading = true))

        viewModelScope.launch(Dispatchers.IO) {
            val superheroes = getSuperheroesUseCase.invoke()
            delay(5000)
            _uiState.postValue(UiState(superheroes = superheroes))
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val superheroes: List<Superhero>? = null
    )
}