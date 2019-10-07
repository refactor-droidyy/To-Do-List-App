package com.example.todolistapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.util.concurrent.locks.Lock

@Database(
    entities = [ Note::class],
    version = 1
)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun getNoteDao() : NotesDao

    companion object{
        @Volatile
        // volatile so that is is immidiately available for all the threads

        private var instance : NoteDatabase? = null
        private val Lock = Any()

        operator fun invoke(context : Context) = instance ?: synchronized(Lock){
            // if the instance is null
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) =  Room.databaseBuilder(
            context.applicationContext,
            NoteDatabase::class.java,
            "notedatabase"
        ).build()

    }
}