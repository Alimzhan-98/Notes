package com.alim.notes.tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alim.notes.models.Task
import com.alim.notes.models.Todo

class TaskViewModel: ViewModel() {


    private val _taskListLiveData: MutableLiveData<List<Task>> = MutableLiveData()
    val taskListLiveData: LiveData<List<Task>> = _taskListLiveData


    init {
        _taskListLiveData.postValue(getFakeData())
    }


    fun getFakeData(): MutableList<Task> = mutableListOf(
            Task("Task1", mutableListOf(Todo("Todo1"),
                    Todo("Todo1.2",true))),
            Task("Task2", mutableListOf(
                    Todo("Todo 2.1",true),
                    Todo("Todo 2.2",true),
                    Todo("Todo 2.3",true)
            )),
                    Task("Task3", mutableListOf(
            Todo("Todo 3.1",true)))
    )

}