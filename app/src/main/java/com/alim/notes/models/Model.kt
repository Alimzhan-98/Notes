package com.alim.notes.models


data class Task @JvmOverloads constructor(
        var title: String,
        val todos: MutableList<Todo> = mutableListOf(),
        var tags:  Tag? = null
)


data class Todo(
   var description: String,
   var isComplete: Boolean
)


data class Note(
   var description: String,
   var tag: Tag? = null
)

data class Tag(
   val name: String,
   val colourResId: Int
)

data class Control(

        private var type: String? = null,
        private var text: String? = null,
        private var action: String? = null
)

