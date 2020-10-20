package com.example.simplenote.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.simplenote.model.database.dao.NoteDaoImpl
import com.example.simplenote.model.database.dbmodels.NoteModel

import com.example.simplenote.model.repository.RepositoryImpl
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.*

class DetailNoteViewModel(application: Application) : AndroidViewModel(application) {

    private val compositeDisposable = CompositeDisposable()

    fun saveNote(noteTitle: String, noteText: String, noteDate: Date, oldNote: NoteModel?){
        val note = oldNote ?: NoteModel(0, noteTitle,noteText,repositoryImpl.dateFormat().format(noteDate).toString())
        repositoryImpl.saveNote(note).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

            },{

            }).let {
                compositeDisposable.add(it)
            }
    }


    private val repositoryImpl: RepositoryImpl

    init {
        val noteDao = NoteDaoImpl.getDatabaseInstance(application).notesDao()
        repositoryImpl = RepositoryImpl(noteDao)
    }
//
//    fun saveNote(noteTitle: String, noteText: String, noteDate: Date, oldNote: NoteModel?) {
//
//       val note = oldNote ?: NoteModel(0, noteTitle,noteText,repositoryImpl.dateFormat().format(noteDate).toString())
//
//        repositoryImpl.saveNote(note)
//    }

}
