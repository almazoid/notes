package com.almazoid.notes

import androidx.recyclerview.widget.RecyclerView
import com.almazoid.notes.databinding.HolderNoteBinding

class NoteViewHolder(private val binding: HolderNoteBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(note: NoteUiModel) {
        with(binding) {
            title.text = note.title
            text.text = note.text
            author.text = note.author
            date.text = note.date

            root.setOnClickListener {
                note.onClick.invoke()
            }
        }
    }
}