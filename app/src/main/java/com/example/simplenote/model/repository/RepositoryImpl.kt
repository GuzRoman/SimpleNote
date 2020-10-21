package com.example.simplenote.model.repository

import com.example.simplenote.model.database.dao.NotesDao
import com.example.simplenote.model.database.dbmodels.NoteModel
import com.example.simplenote.model.repository.inteface.DAORepository
import com.example.simplenote.model.repository.inteface.StringFormatterRepository
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


class RepositoryImpl(private val notesDao: NotesDao) :
    DAORepository, StringFormatterRepository {

    val readAllNotes = notesDao.getAllNotes()

    override suspend fun deleteNote(note: NoteModel) {
        notesDao.deleteNote(note)
    }

    override suspend fun updateNote(note: NoteModel) {
        notesDao.updateNote(note)
    }

    override suspend fun saveNote(note: NoteModel) {
        notesDao.saveNotes(note)
    }

    override fun getCurrentTime(): String {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd.MM HH:mm")
        val formattedTime = current.format(formatter).toString()
        return formattedTime
    }


}