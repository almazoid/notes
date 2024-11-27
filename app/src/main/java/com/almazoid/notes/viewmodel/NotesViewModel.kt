package com.almazoid.notes.viewmodel

import androidx.lifecycle.ViewModel
import com.almazoid.notes.NoteUiModel
import com.almazoid.notes.NotesUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class NotesViewModel() : ViewModel() {

    private val _uiState = MutableStateFlow(NotesUiState(isLoading = true))
    val uiState: StateFlow<NotesUiState> = _uiState.asStateFlow()

    fun getNotes() {
        _uiState.update { currentState ->
            currentState.copy(
                isLoading = false,
                notes = listOf(
                    NoteUiModel(
                        title = "FirstTitle",
                        text = "FirstText FirstText FirstText FirstText FirstText FirstText FirstText",
                        author = "Almaz",
                        date = "27.11.24",
                        onClick = {

                        }
                    ),
                    NoteUiModel(
                        title = "SecondTitle",
                        text = "SecondText SecondText SecondText SecondText SecondText SecondText",
                        author = "Almaz",
                        date = "28.11.24",
                        onClick = {

                        }
                    ),
                    NoteUiModel(
                        title = "ThirdTitle",
                        text = "ThirdText ThirdText ThirdText ThirdText ThirdText ThirdText ThirdText",
                        author = "Almaz",
                        date = "29.11.24",
                        onClick = {

                        }
                    )
                )
            )
        }
    }
}