package com.example.todolistapp.ui


import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager

import com.example.todolistapp.R
import com.example.todolistapp.db.Note
import com.example.todolistapp.db.NoteDatabase
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recycler_view.setHasFixedSize(true)
        recycler_view.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        launch {
            context?.let{
                val note = NoteDatabase(it).getNoteDao().getAllNotes()
                recycler_view.adapter=NotesAdapter(note)

            }
        }


        fab_add.setOnClickListener {

            val action = HomeFragmentDirections.actionAddNotes()
            Navigation.findNavController(it).navigate(action)

        }

    }

}
