package com.example.simplenote.model.database.dbmodels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = NoteModel.TABLE_NAME)
data class NoteModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    var noteId: Int? = null,
    @ColumnInfo(name = NAME)
    var noteName: String? = null,
    @ColumnInfo(name = TEXT)
    var noteText: String? = null,
    @ColumnInfo(name = TIME)
    var noteTime: String? = null,
    var noteColor: String? = null
) {
    companion object{
        const val TABLE_NAME = "notes_table"
        const val ID = "note_id"
        const val NAME = "note_name"
        const val TEXT = "note_text"
        const val TIME = "note_time"
    }
}