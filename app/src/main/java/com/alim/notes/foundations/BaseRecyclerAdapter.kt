package com.alim.notes.foundations

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapter<T>(
    protected val mutableList: MutableList<T> = mutableListOf()
):RecyclerView.Adapter<BaseRecyclerAdapter.BaseViewHolder<T>>() {


    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.onBind(mutableList[position])
    }

    override fun getItemCount() = mutableList.count()


    abstract class BaseViewHolder<E>(val view: View): RecyclerView.ViewHolder(view){
         abstract fun onBind(data: E)
    }

}