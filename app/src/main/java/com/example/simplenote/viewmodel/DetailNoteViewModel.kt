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

    fun saveNote(note: NoteModel){
        viewModelScope.launch(Dispatchers.IO) {
            repositoryImpl.saveNote(note)
        }
    }

    fun getCurrentTime(): String{
        return repositoryImpl.getCurrentTime()
    }

    private val repositoryImpl: RepositoryImpl

    init {
        val noteDao = NoteDaoImpl.getDatabaseInstance(application).notesDao()
        repositoryImpl = RepositoryImpl(noteDao)
    }

}
