package com.example.simplenote.model.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.simplenote.model.database.dbmodels.NoteModel


@Dao
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveNotes(note: NoteModel)

    @Query("SELECT * FROM ${NoteModel.TABLE_NAME}")
    fun getAllNotes(): LiveData<List<NoteModel>>

    @Delete
    suspend fun deleteNote(note: NoteModel)

    @Update
    suspend fun updateNote(note: NoteModel)
}