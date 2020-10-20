package com.example.simplenote.model.repository

import com.example.simplenote.model.database.dao.NotesDao
import com.example.simplenote.model.database.dbmodels.NoteModel


class RepositoryImpl(private val notesDao: NotesDao) : Repository {

    val readAllNotes = notesDao.getAllNotes()

    override suspend fun readNote(noteId: Int): NoteModel {
        return notesDao.getNote(noteId)
    }

    override suspend fun deleteNote(note: NoteModel) {
        notesDao.deleteNote(note)
    }

    override suspend fun updateNote(note: NoteModel) {
        notesDao.updateNote(note)
    }

    override suspend fun saveNote(note: NoteModel) {
        notesDao.saveNotes(note)
    }


}