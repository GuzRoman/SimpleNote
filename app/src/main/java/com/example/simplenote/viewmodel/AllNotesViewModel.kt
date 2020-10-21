package com.example.simplenote.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.simplenote.model.database.dao.NoteDaoImpl
import com.example.simplenote.model.database.dbmodels.NoteModel
import com.example.simplenote.model.repository.RepositoryImpl


class AllNotesViewModel(application: Application) : AndroidViewModel(application) {


    private val repositoryImpl: RepositoryImpl
    var notesList : LiveData<List<NoteModel>>

    init {
        val noteDao = NoteDaoImpl.getDatabaseInstance(application).notesDao()
        repositoryImpl = RepositoryImpl(noteDao)
        notesList = repositoryImpl.readAllNotes
    }




}
