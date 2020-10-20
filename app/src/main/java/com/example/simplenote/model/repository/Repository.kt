package com.example.simplenote.model.repository

import androidx.lifecycle.LiveData
import com.example.simplenote.model.database.dbmodels.NoteModel

interface Repository {

    suspend fun readNote(noteId: Int) : NoteModel

    suspend fun deleteNote(note: NoteModel)

    suspend fun updateNote(note: NoteModel)

    suspend fun saveNote(note: NoteModel)

}