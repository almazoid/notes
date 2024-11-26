package com.almazoid.notes

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class NotesListFragment: Fragment(R.layout.fragment_notes_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            findNavController().navigate(NotesListFragmentDirections.navigateToNoteDetail(noteId = "012345"))
        }
    }
}