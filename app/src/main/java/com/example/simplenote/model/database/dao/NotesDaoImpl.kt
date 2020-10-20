package com.example.simplenote.model.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.simplenote.model.database.dbmodels.NoteModel

@Database(entities = [NoteModel::class], version = 1)
abstract class NoteDaoImpl : RoomDatabase() {

    abstract fun notesDao(): NotesDao

    companion object {
        @Volatile
        private var databaseInstance: NoteDaoImpl? = null

        fun getDatabaseInstance(context: Context): NoteDaoImpl {
            val tempInstance = databaseInstance
            if (tempInstance != null)
                return tempInstance

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDaoImpl::class.java,
                    "NotesData.db"
                ).build()
                databaseInstance = instance

                return instance
            }

        }

    }
}