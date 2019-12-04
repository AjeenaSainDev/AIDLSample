/*
package com.rjil.jiostbsetting.listener

import android.view.View
import androidx.recyclerview.widget.RecyclerView


fun RecyclerView.addOnItemClickListener(onClickListener: OnItemClickListener) {
    this.addOnChildAttachStateChangeListener(object :
            RecyclerView.OnChildAttachStateChangeListener {

        override fun onChildViewDetachedFromWindow(view: View) {
            view.setOnClickListener(null)
        }

        override fun onChildViewAttachedToWindow(view: View) {
            view.setOnClickListener {
                val holder = getChildViewHolder(view)
                onClickListener.onItemViewClick(holder.adapterPosition, view)
                //onClickListener.onLayoutChange(holder.adapterPosition,holder)

            }
        }
    })
}*/
