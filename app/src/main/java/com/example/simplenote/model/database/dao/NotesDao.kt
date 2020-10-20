package com.example.simplenote.model.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.simplenote.model.database.dbmodels.NoteModel


@Dao
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveNotes(note: NoteModel)

    @Query("SELECT * FROM ${NoteModel.TABLE_NAME}")
    fun getAllNotes(): LiveData<List<NoteModel>>

    @Query("SELECT * FROM ${NoteModel.TABLE_NAME} WHERE ${NoteModel.ID} LIKE :noteId")
    suspend fun getNote(noteId: Int): NoteModel

    @Delete
    suspend fun deleteNote(note: NoteModel)

    @Update
    suspend fun updateNote(note: NoteModel)
}