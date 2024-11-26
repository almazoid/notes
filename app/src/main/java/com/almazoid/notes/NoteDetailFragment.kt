package com.almazoid.notes

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

class NoteDetailFragment: Fragment(R.layout.fragment_note_detail) {

    val args by navArgs<NoteDetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.text).text = args.noteId
    }
}