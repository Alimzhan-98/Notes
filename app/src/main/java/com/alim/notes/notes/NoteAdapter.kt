package com.alim.notes.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alim.notes.R
import com.alim.notes.foundations.BaseRecyclerAdapter
import com.alim.notes.models.Note
import com.alim.notes.models.Task
import com.alim.notes.navigation.NavigationActivyty
import com.alim.notes.tasks.TaskAdapter
import com.alim.notes.tasks.TasksListFragment
import com.alim.notes.views.NoteView
import kotlinx.android.synthetic.main.item_note.view.*
import kotlinx.android.synthetic.main.view_add_button.view.*

class NoteAdapter(
        noteList: MutableList<Note> = mutableListOf(),
        val touchActionDelegete: NotesListFragment.TouchActionDelegete
) : BaseRecyclerAdapter<Note>(noteList) {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = if (viewType == TYPE_ADD_BUTTON) {
        AddButtonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_add_button , parent, false))
    }else{
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false))
    }


    class ViewHolder(view: View): BaseViewHolder<Note>(view) {
        override fun onBind(note: Note){
            (view as NoteView).initView(note)
        }
    }


    inner class AddButtonViewHolder(view: View): BaseViewHolder<Unit>(view){
        override fun onBind(data: Unit) {
            view.buttonText.text = view.context.getText(R.string.add_button_note_text)

            view.setOnClickListener {
                touchActionDelegete.onAddButtonClick(NavigationActivyty.FRAGMENT_VALUE_NOTE)
            }
        }

    }

}