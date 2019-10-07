package com.example.todolistapp.ui


import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.todolistapp.R
import com.example.todolistapp.db.Note
import com.example.todolistapp.db.NoteDatabase
import kotlinx.android.synthetic.main.fragment_add.*

/**
 * A simple [Fragment] subclass.
 */
class AddFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        fab_save.setOnClickListener setOnClickListner@{
            val titlee = title.text.toString()
            val note = description.text.toString()

            if (titlee.isEmpty()) {
                title.error = "Field Required"
                title.requestFocus()
                return@setOnClickListner
            }
            if (note.isEmpty()) {
                description.error = "Field Required"
                description.requestFocus()
                return@setOnClickListner
            }

            val notee = Note(titlee, note)
            save(notee)

            Toast.makeText(context,"Saved",Toast.LENGTH_LONG).show()
        }
    }
    private fun save(note : Note){
        class Save : AsyncTask<Void, Void, Void>(){
            override fun doInBackground(vararg p0: Void?): Void? {

                NoteDatabase(activity!!).getNoteDao().addNote(note)
                return null
            }


        }

        Save().execute()
    }
}
