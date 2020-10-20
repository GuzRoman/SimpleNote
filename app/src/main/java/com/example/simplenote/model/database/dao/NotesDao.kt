package com.example.simplenote.model.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.simplenote.model.database.dbmodels.NoteModel
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveNotes(note: NoteModel) : Completable

    @Query("SELECT * FROM ${NoteModel.TABLE_NAME}")
    fun getAllNotes(): Single<List<NoteModel>>

    @Query("SELECT * FROM ${NoteModel.TABLE_NAME} WHERE ${NoteModel.ID} LIKE :noteId")
    fun getNote(noteId: Int): Single<NoteModel>

    @Delete
    fun deleteNote(note: NoteModel) : Completable

    @Update
    fun updateNote(note: NoteModel)
}