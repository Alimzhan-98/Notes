package com.alim.notes.views

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.alim.notes.models.Todo
import kotlinx.android.synthetic.main.view_todo.view.*

class TodoView @JvmOverloads constructor(
        context: Context?,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 1) : ConstraintLayout(context) {

    fun initView(todo: Todo,callback: (() -> Unit)? = null) {
        descriptionView.setText(todo.description)
        completeCheckBox.setChecked(todo.isComplete)
        if (todo.isComplete) {
            createStrikeThought()
        }
        setUpCheckStateListener(todo,callback)
    }

    fun setUpCheckStateListener(todo: Todo,callback: (() -> Unit)? = null) {
        completeCheckBox.setOnCheckedChangeListener { _, isChecked: Boolean ->
            todo.isComplete = isChecked
            callback?.invoke()
            if (isChecked) {
                createStrikeThought()
            } else {
                removeSrtikeThrough()
            }
        }
    }

    private fun createStrikeThought() {
        descriptionView.paintFlags = descriptionView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    }

    private fun removeSrtikeThrough() {
        descriptionView.paintFlags = descriptionView.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
    }
}