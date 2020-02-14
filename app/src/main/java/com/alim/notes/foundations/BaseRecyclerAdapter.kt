package com.alim.notes.foundations

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alim.notes.tasks.TaskAdapter

abstract class BaseRecyclerAdapter<T>(
    protected val mutableList: MutableList<T> = mutableListOf()
):RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun getItemViewType(position: Int):Int = if(position==0){
        TYPE_ADD_BUTTON
    }else{
        TYPE_INFO
    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is TaskAdapter.AddButtonViewHolder){
          holder.onBind(Unit)
        }else{
            (holder as BaseViewHolder<T>).onBind(mutableList[position])
        }
    }

    override fun getItemCount() = mutableList.count()


    abstract class BaseViewHolder<E>(val view: View): RecyclerView.ViewHolder(view){
         abstract fun onBind(data: E)
    }


    companion object{
        const val TYPE_ADD_BUTTON = 0
        const val TYPE_INFO = 1
    }

}