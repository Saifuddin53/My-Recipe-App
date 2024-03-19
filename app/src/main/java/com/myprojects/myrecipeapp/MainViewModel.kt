package com.myprojects.myrecipeapp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.Recomposer
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel: ViewModel() {

    private val _categoryState = mutableStateOf(RecipeState())
    val categoryState: State<RecipeState> = _categoryState

    private fun getResponse() {
        viewModelScope.launch {
            try {
                val response = retrofitService.getCategories()
                _categoryState.value = _categoryState.value.copy(
                    loading = false,
                    categories = response.categories,
                    error = null
                )
            }catch (e: Exception) {
                _categoryState.value = _categoryState.value.copy(
                    loading = false,
                    error("${e.message}")
                )
            }
        }
    }

    data class RecipeState(
        val loading: Boolean = true,
        val categories: List<Category> = emptyList(),
        val error: String? = null
    )
}