package com.almazoid.notes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.almazoid.notes.databinding.HolderNoteBinding

class NoteAdapter : ListAdapter<NoteUiModel, NoteViewHolder>(NoteItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): NoteViewHolder {
        val binding = HolderNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class NoteItemDiffCallback : DiffUtil.ItemCallback<NoteUiModel>() {
        override fun areItemsTheSame(oldItem: NoteUiModel, newItem: NoteUiModel): Boolean = oldItem == newItem

        override fun areContentsTheSame(oldItem: NoteUiModel, newItem: NoteUiModel): Boolean =
            oldItem.title == newItem.title &&
            oldItem.text == newItem.text &&
            oldItem.author == newItem.author &&
            oldItem.date == newItem.date

    }

}