package com.example.todolistapp.ui

import android.os.Parcel
import android.os.Parcelable
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistapp.R
import com.example.todolistapp.db.Note
import kotlinx.android.synthetic.main.note_layout.view.*

class NotesAdapter(private val notes :List<Note>) :RecyclerView.Adapter<NotesAdapter.NoteviewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteviewHolder {
        return NoteviewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.note_layout,parent,false)
        )
    }

    override fun getItemCount(): Int = notes.size

    override fun onBindViewHolder(holder: NoteviewHolder, position: Int) {
       holder.view.title_txt.text =  notes[position].title
        holder.view.note_txt.text = notes[position].note
    }


    class NoteviewHolder(val view : View) : RecyclerView.ViewHolder(view)

}