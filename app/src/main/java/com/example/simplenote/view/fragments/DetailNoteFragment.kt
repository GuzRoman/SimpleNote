package com.example.simplenote.view.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.simplenote.R
import com.example.simplenote.model.database.dbmodels.NoteModel
import com.example.simplenote.viewmodel.DetailNoteViewModel
import kotlinx.android.synthetic.main.detail_note_fragment.*
import kotlinx.android.synthetic.main.detail_note_fragment.view.*

class DetailNoteFragment : Fragment() {

    private lateinit var detailNoteViewModel: DetailNoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.detail_note_fragment, container, false)

        detailNoteViewModel = ViewModelProvider(this).get(DetailNoteViewModel::class.java)

        view.note_add_btn.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val noteTitle = note_title_ed.text.toString()
        val noteText = note_text_ed.text.toString()
        if (noteText.isEmpty() || noteTitle.isEmpty()) {
            Toast.makeText(requireContext(), "Заполните все поля", Toast.LENGTH_SHORT).show()
        } else {
            val note = NoteModel(0,noteTitle, noteText,detailNoteViewModel.getCurrentTime())
            saveNote(note)
            Toast.makeText(requireContext(), "Заметка сохранена", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_detailNoteFragment_to_allNotesFragment)
        }
    }

    private fun saveNote(note: NoteModel) {
        detailNoteViewModel.saveNote(note)
    }

}
