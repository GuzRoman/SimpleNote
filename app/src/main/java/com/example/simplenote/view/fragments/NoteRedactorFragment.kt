package com.example.simplenote.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.simplenote.R
import com.example.simplenote.model.database.dbmodels.NoteModel
import com.example.simplenote.viewmodel.NoteRedactorViewModel
import kotlinx.android.synthetic.main.note_redactor_fragment.*
import kotlinx.android.synthetic.main.note_redactor_fragment.view.*


class NoteRedactorFragment : Fragment() {

    private val args by navArgs<NoteRedactorFragmentArgs>()

    private lateinit var noteRedactorViewModel: NoteRedactorViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.note_redactor_fragment, container, false)

        noteRedactorViewModel = ViewModelProvider(this).get(NoteRedactorViewModel::class.java)

        view.note_title_ed.setText(args.selectedNote.noteName)
        view.note_text_ed.setText(args.selectedNote.noteText)

        view.note_save_btn.setOnClickListener {
            updateItem()
            findNavController().navigate(R.id.action_noteRedactor_to_allNotesFragment)
        }

        view.note_del_btn.setOnClickListener{
            deleteNote()
            findNavController().navigate(R.id.action_noteRedactor_to_allNotesFragment)
        }

        return view
    }

    private fun updateItem(){
        val noteTitle = note_title_ed.text.toString()
        val noteText = note_text_ed.text.toString()

        if (noteText.isEmpty() || noteTitle.isEmpty()) {
            Toast.makeText(requireContext(), "Заполните все поля", Toast.LENGTH_SHORT).show()
        } else {
            val updatedNote = NoteModel(args.selectedNote.noteId, noteTitle, noteText, noteRedactorViewModel.updateTime())
            noteRedactorViewModel.updateNote(updatedNote)
            Toast.makeText(requireContext(), "Заметка обновлена", Toast.LENGTH_SHORT).show()
        }
    }

    private fun deleteNote(){
        noteRedactorViewModel.deleteNote(args.selectedNote)
        Toast.makeText(requireContext(), "Заметка удалена", Toast.LENGTH_SHORT).show()
    }

}
