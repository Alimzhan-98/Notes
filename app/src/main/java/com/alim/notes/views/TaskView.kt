package com.alim.notes.views

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.alim.notes.R
import com.alim.notes.models.Task
import kotlinx.android.synthetic.main.item_task.view.*
import kotlinx.android.synthetic.main.view_todo.view.*

class TaskView@JvmOverloads constructor(
        context: Context?,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 1) : ConstraintLayout(context) {


    lateinit var task: Task


    fun initView(task: Task){

        this.task = task


        checkTaskComplete()

        task.todos.forEach{ todo ->
            val todoView =  (LayoutInflater.from(context).inflate(R.layout.view_todo,todoContainer,false) as TodoView).apply {
                initView(todo){
                  checkTaskComplete()
                }
            }
            todoContainer.addView(todoView)
        }




    }

    fun checkTaskComplete() {
        if(isTaskComplete()){
            createStrikeThought()
        }else{
            removeSrtikeThrough()
        }
    }

    fun isTaskComplete(): Boolean = task.todos.filter { !it.isComplete }.isEmpty()

    private fun createStrikeThought() {

        titleView.apply {
            paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }


    }

    private fun removeSrtikeThrough() {

        titleView.apply{
            paintFlags = paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }


    }



}