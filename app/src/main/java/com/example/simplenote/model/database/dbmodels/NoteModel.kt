package com.example.simplenote.model.database.dbmodels

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity (tableName = NoteModel.TABLE_NAME)
data class NoteModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    var noteId: Int,
    @ColumnInfo(name = NAME)
    var noteName: String? = null,
    @ColumnInfo(name = TEXT)
    var noteText: String? = null,
    @ColumnInfo(name = TIME)
    var noteTime: String? = null,
    var noteColor: String? = null
) : Parcelable
{
    companion object{
        const val TABLE_NAME = "notes_table"
        const val ID = "note_id"
        const val NAME = "note_name"
        const val TEXT = "note_text"
        const val TIME = "note_time"
    }
}