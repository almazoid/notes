package com.almazoid.notes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.almazoid.notes.databinding.FragmentNotesBinding
import com.almazoid.notes.viewmodel.NotesViewModel
import kotlinx.coroutines.launch

class NotesFragment: Fragment(R.layout.fragment_notes) {

    private var _binding: FragmentNotesBinding? = null
    private val binding get() = _binding!!

    private val viewModel: NotesViewModel by viewModels()
    private val adapter = NoteAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotesBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getNotes()
        binding.noteList.adapter = adapter
        binding.noteList.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.uiState.collect { notesUiState ->
                adapter.submitList(notesUiState.notes)
            }
        }

       /* binding.button.setOnClickListener {
            findNavController().navigate(NotesFragmentDirections.navigateToNoteDetail(noteId = "012345"))
        }*/
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}