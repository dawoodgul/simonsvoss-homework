package com.example.simonsvoss_homework

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainRecyclerViewAdapter(private val dataForAdapterArray: ArrayList<DataForAdapter>) :
    RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val lockTextView: TextView = view.findViewById(R.id.lockTextView)
        val buildingTextView: TextView = view.findViewById(R.id.buildingTextView)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_recycler_view_row_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.lockTextView.text = dataForAdapterArray[position].lockName
        holder.buildingTextView.text =
            dataForAdapterArray[position].buildingShortcutFloorRoomNumberString
    }

    override fun getItemCount(): Int {
        return dataForAdapterArray.size
    }
}