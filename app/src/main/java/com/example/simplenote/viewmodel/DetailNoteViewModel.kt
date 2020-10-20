package com.example.simplenote.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplenote.model.database.dao.NoteDaoImpl
import com.example.simplenote.model.database.dbmodels.NoteModel
import com.example.simplenote.model.repository.RepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class DetailNoteViewModel(application: Application) : AndroidViewModel(application) {

    fun saveNote(noteTitle: String, noteText: String, noteDate: Date, oldNote: NoteModel?){
        val note = oldNote ?: NoteModel(0,noteTitle, noteText, noteDate.toString())
        viewModelScope.launch(Dispatchers.IO) {
            repositoryImpl.saveNote(note)
        }
    }

    private val repositoryImpl: RepositoryImpl

    init {
        val noteDao = NoteDaoImpl.getDatabaseInstance(application).notesDao()
        repositoryImpl = RepositoryImpl(noteDao)
    }

}
