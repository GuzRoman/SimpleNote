package com.example.simplenote.model.repository.inteface

import com.example.simplenote.model.database.dbmodels.NoteModel

interface DAORepository {

    suspend fun deleteNote(note: NoteModel)

    suspend fun updateNote(note: NoteModel)

    suspend fun saveNote(note: NoteModel)

}