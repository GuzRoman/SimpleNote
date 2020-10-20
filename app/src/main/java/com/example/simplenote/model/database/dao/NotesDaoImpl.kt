package com.example.simplenote.model.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.simplenote.model.database.dbmodels.NoteModel

@Database(entities = [NoteModel::class], version = DB_VERSION)
abstract class NoteDaoImpl: RoomDatabase() {

    abstract fun notesDao(): NotesDao

    companion object{
        @Volatile
        private var databaseInstance : NoteDaoImpl? = null

        fun getDatabaseInstance(context: Context) : NoteDaoImpl =
            databaseInstance ?: synchronized(this) {
                databaseInstance ?: buildDatabaseInstance(context).also {
                    databaseInstance = it
                }
            }


    private fun buildDatabaseInstance(context: Context) =
        Room.databaseBuilder(context, NoteDaoImpl::class.java, DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }
}

const val DB_VERSION = 1

const val DB_NAME = "NotesData.db"