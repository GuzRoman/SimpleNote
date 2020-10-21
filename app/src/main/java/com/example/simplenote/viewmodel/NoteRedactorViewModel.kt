package com.example.simplenote.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplenote.model.database.dao.NoteDaoImpl
import com.example.simplenote.model.database.dbmodels.NoteModel
import com.example.simplenote.model.repository.RepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteRedactorViewModel(aplication: Application) : AndroidViewModel(aplication) {

    private val repositoryImpl: RepositoryImpl

    init {
        val noteDao = NoteDaoImpl.getDatabaseInstance(aplication).notesDao()
        repositoryImpl = RepositoryImpl(noteDao)
    }

    fun updateTime(): String{
        return repositoryImpl.getCurrentTime()
    }

    fun updateNote(note: NoteModel){
        viewModelScope.launch(Dispatchers.IO) {
            repositoryImpl.updateNote(note)
        }
    }

    fun deleteNote(note: NoteModel){
        viewModelScope.launch(Dispatchers.IO) {
            repositoryImpl.deleteNote(note)
        }
    }

}