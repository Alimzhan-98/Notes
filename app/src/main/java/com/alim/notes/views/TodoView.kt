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

    fun initView(todo: Todo) {
        descriptionView.setText(todo.description)
        completeCheckBox.setChecked(todo.isComplete)
        if (todo.isComplete) {
            createStrikeThought()
        }
        setUpCheckStateListener()
    }

    fun setUpCheckStateListener() {
        completeCheckBox.setOnCheckedChangeListener { _, isChecked: Boolean ->
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