package com.example.todolistapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NotesDao {

    @Insert
    fun addNote(note: Note)

    @Query("SELECT * FROM note ORDER BY id DESC")
     fun getAllNotes() : List<Note>


}