package com.example.simplenote.viewmodel.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.simplenote.R
import com.example.simplenote.model.database.dbmodels.NoteModel

class AllNotesAdapter: RecyclerView.Adapter<AllNotesAdapter.AllNotesViewHolder>() {

    private var notes = mutableListOf<NoteModel>()

    class AllNotesViewHolder(item : View) : RecyclerView.ViewHolder(item){
        var title: TextView = item.findViewById(R.id.notes_item_name)
        var date: TextView = item.findViewById(R.id.notes_item_date)
        var number: TextView = item.findViewById(R.id.notes_item_nubmer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllNotesViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_notes, parent, false)
        return AllNotesViewHolder(view)
    }

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: AllNotesViewHolder, position: Int) {
        val note = notes[position]
        holder.number.text = note.noteId.toString()
        holder.title.text = note.noteName
        holder.date.text = note.noteTime
    }

    fun setData(setNotes: List<NoteModel>){
        notes.clear()
        notes.addAll(setNotes)
        notifyDataSetChanged()
    }

}