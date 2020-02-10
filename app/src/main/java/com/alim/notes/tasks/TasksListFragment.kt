package com.alim.notes.tasks

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.alim.notes.R
import com.alim.notes.models.Task
import com.alim.notes.models.Todo
import kotlinx.android.synthetic.main.fragment_tasks_list.*

class TasksListFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootview = inflater.inflate(R.layout.fragment_tasks_list, container, false)
        return rootview
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = TaskAdapter(mutableListOf(
                Task("Task1", mutableListOf(Todo("Todo1"),
                        Todo("Todo1.2",true))),
                Task("Task2")
        ))

        recyclerView.adapter = adapter
        
    }

    companion object {
        fun newInstance() = TasksListFragment()

    }
}