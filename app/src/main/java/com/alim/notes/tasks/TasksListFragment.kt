package com.alim.notes.tasks

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.alim.notes.R
import kotlinx.android.synthetic.main.fragment_tasks_list.*

class TasksListFragment : Fragment() {

    lateinit var viewModel: TaskViewModel
    lateinit var touchActionDelegete: TouchActionDelegete


    override fun onAttach(context: Context?) {
        super.onAttach(context)

        context?.let {
            if(it is TouchActionDelegete){
                touchActionDelegete = it
            }
        }

    }




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootview = inflater.inflate(R.layout.fragment_tasks_list, container, false)
        return rootview
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        bindViewModel()

        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = TaskAdapter(viewModel.getFakeData(),touchActionDelegete)

        recyclerView.adapter = adapter
        
    }

    private fun bindViewModel(){
        viewModel = ViewModelProviders.of(this).get(TaskViewModel::class.java)

//
//        viewModel.taskListLiveData.observe(this, Observer {
//
//        })
    }

    companion object {
        fun newInstance() = TasksListFragment()
    }


    interface TouchActionDelegete{
        fun onAddButtonClick(value: String)
    }




}