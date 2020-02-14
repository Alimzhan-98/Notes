package com.alim.notes.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alim.notes.R
import com.alim.notes.foundations.BaseRecyclerAdapter
import com.alim.notes.models.Note
import com.alim.notes.models.Task
import com.alim.notes.tasks.TaskAdapter
import com.alim.notes.views.NoteView
import kotlinx.android.synthetic.main.item_note.view.*

class NoteAdapter(
        private val noteList: MutableList<Note> = mutableListOf()
) : BaseRecyclerAdapter<Note>(noteList) {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false))


    class ViewHolder(view: View): BaseViewHolder<Note>(view) {
        override fun onBind(note: Note){
            (view as NoteView).initView(note)
        }
    }

}