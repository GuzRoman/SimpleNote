package com.example.simplenote.model.repository

import com.example.simplenote.model.database.dbmodels.NoteModel
import io.reactivex.Completable
import io.reactivex.Single

interface Repository {

    fun readAllNotes(): Single<List<NoteModel>>

    fun readNote(noteId: Int) : Single<NoteModel>

    fun deleteNote(note: NoteModel) : Completable

    fun updateNote(note: NoteModel)

    fun saveNote(note: NoteModel) : Completable

}