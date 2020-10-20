package com.example.simplenote.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.simplenote.R
import com.example.simplenote.model.database.dbmodels.NoteModel
import com.example.simplenote.viewmodel.AllNotesViewModel
import com.example.simplenote.viewmodel.adapter.AllNotesAdapter
import kotlinx.android.synthetic.main.all_notes_fragment.*
import kotlinx.android.synthetic.main.all_notes_fragment.view.*

class AllNotesFragment : Fragment() {

    private lateinit var allNotesViewModel: AllNotesViewModel
    private lateinit var allNotesAdapter: AllNotesAdapter
    private lateinit var allNotesRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.all_notes_fragment, container, false)
        allNotesAdapter = AllNotesAdapter()
        allNotesViewModel = ViewModelProvider(this).get(AllNotesViewModel::class.java)
        allNotesRecyclerView = view.all_notes_recyclerview



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setData()

        all_notes_add_btn.setOnClickListener {
            findNavController().navigate(R.id.action_allNotesFragment_to_detailNoteFragment)
        }

    }

    private fun setData() {
        allNotesViewModel.notesList.observe(viewLifecycleOwner, Observer {
            allNotesViewModel.getNotes()
            if (it.isEmpty()){
                handleData(it)
            } else {
                handleEmpty()
            }
        })
    }

    private fun handleData(notes: List<NoteModel>){
        allNotesAdapter.setData(notes)
    }

    private fun handleEmpty(){
        allNotesAdapter.setData(listOf())
    }
}