package com.alim.notes.notes

import androidx.lifecycle.ViewModel
import com.alim.notes.models.Note

class NoteViewModel: ViewModel() {

    fun getFakeData(): MutableList<Note> = mutableListOf(
            Note("clear monitor"),
            Note("read book")
    )

}