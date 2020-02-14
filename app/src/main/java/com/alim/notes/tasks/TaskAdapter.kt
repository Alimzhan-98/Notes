package com.alim.notes.tasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alim.notes.R
import com.alim.notes.foundations.BaseRecyclerAdapter
import com.alim.notes.models.Task
import com.alim.notes.views.TaskView

class TaskAdapter(
        private val taskList: MutableList<Task> = mutableListOf()
): BaseRecyclerAdapter<Task>(taskList) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = if(viewType == TYPE_INFO) {
        TaskViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false))
    }else{
        AddButtonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_add_button , parent, false))
    }


    class AddButtonViewHolder(view: View): BaseViewHolder<Unit>(view){
        override fun onBind(data: Unit) {

        }

    }


    class TaskViewHolder(view: View): BaseViewHolder<Task>(view){
        override fun onBind(data: Task) {
            (view as TaskView).initView(data)
        }

    }

}