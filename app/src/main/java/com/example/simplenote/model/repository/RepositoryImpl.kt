package com.example.simplenote.model.repository

import com.example.simplenote.model.database.dao.NoteDaoImpl
import com.example.simplenote.model.database.dao.NotesDao
import com.example.simplenote.model.database.dbmodels.NoteModel
import java.text.SimpleDateFormat

class RepositoryImpl(private val notesDao: NotesDao) : Repository {

    override fun readAllNotes() = notesDao.getAllNotes()

    override fun readNote(noteId: Int) = notesDao.getNote(noteId)

    override fun deleteNote(note: NoteModel) = notesDao.deleteNote(note)

    override fun updateNote(note: NoteModel)  = notesDao.updateNote(note)

    override fun saveNote(note: NoteModel) = notesDao.saveNotes(note)

    fun dateFormat() = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
}