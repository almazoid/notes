package com.almazoid.notes

data class NotesUiState(
    val isLoading: Boolean,
    val errorMsg: String? = null,
    val notes: List<NoteUiModel>? = null
)