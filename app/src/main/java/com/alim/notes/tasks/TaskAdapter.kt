package com.alim.notes.tasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.alim.notes.R
import com.alim.notes.foundations.BaseRecyclerAdapter
import com.alim.notes.models.Task
import com.alim.notes.navigation.NavigationActivyty
import com.alim.notes.views.TaskView
import kotlinx.android.synthetic.main.view_add_button.view.*

class TaskAdapter(
        taskList: MutableList<Task> = mutableListOf(),
        val touchActionDelegete: TasksListFragment.TouchActionDelegete
): BaseRecyclerAdapter<Task>(taskList) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = if(viewType == TYPE_INFO) {
        TaskViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false))
    }else{
        AddButtonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_add_button , parent, false))
    }



    class TaskViewHolder(view: View): BaseViewHolder<Task>(view){
        override fun onBind(data: Task) {
            (view as TaskView).initView(data)

        }

    }


    inner class AddButtonViewHolder(view: View): BaseViewHolder<Unit>(view){
        override fun onBind(data: Unit) {
            view.buttonText.text = view.context.getText(R.string.add_button_task_text)

            view.setOnClickListener {
                touchActionDelegete.onAddButtonClick(NavigationActivyty.FRAGMENT_VALUE_TASK)
            }
        }

    }





}