package com.example.simonsvoss_homework

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.simonsvoss_homework.models.Data
import com.example.simonsvoss_homework.models.Lock

class MainRecyclerViewAdapter(private val data: Data) :
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
        holder.lockTextView.text = data.locks[position].name
        holder.buildingTextView.text =
            getBuildingShortcutFloorRoomNumberString(data.locks[position])
    }

    private fun getBuildingShortcutFloorRoomNumberString(lock: Lock): String {
        val buildingShortcut = data.buildings.first { lock.buildingId == it.id }.shortCut
        val floor = lock.floor
        val roomNumber = lock.roomNumber

        return "$buildingShortcut-$floor-$roomNumber"
    }

    override fun getItemCount(): Int {
        return data.locks.size
    }
}