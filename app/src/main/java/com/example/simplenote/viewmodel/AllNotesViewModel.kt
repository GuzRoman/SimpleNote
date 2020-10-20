package com.example.simplenote.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.simplenote.model.database.dao.NoteDaoImpl
import com.example.simplenote.model.database.dbmodels.NoteModel
import com.example.simplenote.model.repository.RepositoryImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class AllNotesViewModel(application: Application) : AndroidViewModel(application) {

    private val compositeDisposable = CompositeDisposable()
    private val repositoryImpl: RepositoryImpl
    var notesList = MutableLiveData<List<NoteModel>>()

    init {
        val noteDao = NoteDaoImpl.getDatabaseInstance(application).notesDao()
        repositoryImpl = RepositoryImpl(noteDao)
    }

    fun getNotes() {
        repositoryImpl.readAllNotes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({notes ->
                if (notes == null) {
                    notesList.postValue(listOf())
                } else {
                    notesList.postValue(notes)
                }
            }, {

            }).let {
                compositeDisposable.add(it)
            }
    }

}
