package com.example.simplenote.view.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.simplenote.R
import com.example.simplenote.viewmodel.DetailNoteViewModel
import kotlinx.android.synthetic.main.detail_note_fragment.*
import java.util.*

class DetailNoteFragment : Fragment() {

    private lateinit var viewModel: DetailNoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.detail_note_fragment, container, false)

        viewModel = ViewModelProvider(this).get(DetailNoteViewModel::class.java)

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        note_save_btn.setOnClickListener {
            val noteTitle = note_title_ed.text
            val noteText = note_text_ed.text
            val noteTime = Date()
            saveNote(noteTitle.toString(), noteText.toString(), noteTime)
            findNavController().navigate(R.id.action_detailNoteFragment_to_allNotesFragment)
        }
    }


    private fun saveNote(noteTitle: String, noteText: String, noteTime: Date) {
        viewModel.saveNote(noteTitle, noteText, noteTime, null)
    }

}
