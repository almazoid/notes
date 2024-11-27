package com.almazoid.notes

data class NoteUiModel(
    val title: String?,
    val text: String?,
    val date: String?,
    val author: String?,
    val onClick: () -> Unit
)