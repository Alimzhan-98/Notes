package com.alim.notes.tasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alim.notes.R
import com.alim.notes.foundations.BaseRecyclerAdapter
import com.alim.notes.models.Task
import kotlinx.android.synthetic.main.item_task.view.*

class TaskAdapter(
        private val taskList: MutableList<Task> = mutableListOf()
): BaseRecyclerAdapter<Task>(taskList) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task,parent,false))

     

    class ViewHolder(view: View): BaseRecyclerAdapter.BaseViewHolder<Task>(view){
        override fun onBind(data: Task) {
            view.titleView.text = data.title

            data.todos.forEach{ todo ->
                LayoutInflater.from(view.context).inflate(R.layout.view_todo,view.todoContainer,false)
            }

            
        }

    }

}