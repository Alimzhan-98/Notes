package com.alim.notes.notes

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.alim.notes.R
import com.alim.notes.models.Note
import com.alim.notes.tasks.TaskViewModel
import com.alim.notes.tasks.TasksListFragment
import kotlinx.android.synthetic.main.fragment_notes_list.*

/**
 * A simple [Fragment] subclass.
 * Use the [NotesListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NotesListFragment : Fragment() {

    lateinit var viewModel: NoteViewModel
    lateinit var touchActionDelegete: TouchActionDelegete


    override fun onAttach(context: Context?) {
        super.onAttach(context)

        context?.let {
            if(it is TouchActionDelegete){
                touchActionDelegete = it
            }
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? { // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notes_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        bindViewModel()

        recyclerView.layoutManager = LinearLayoutManager(context)

        val adapter = NoteAdapter( viewModel.getFakeData(),touchActionDelegete)

        recyclerView.adapter = adapter

    }

    private fun bindViewModel(){
        viewModel = ViewModelProviders.of(this).get(NoteViewModel::class.java)
    }

    companion object {
        fun newInstance() = NotesListFragment()
    }

    interface TouchActionDelegete{
        fun onAddButtonClick(value: String)
    }



}