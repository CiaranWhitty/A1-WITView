package com.example.a1_witview.adapters


import android.view.LayoutInflater
import android.view.OrientationEventListener
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a1_witview.Models.TimetableModel
import com.example.a1_witview.R
import kotlinx.android.synthetic.main.sidecard_timetable.view.*



class TimetableAdapter constructor(private var timetables: List<TimetableModel>)
    : RecyclerView.Adapter<TimetableAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        return MainHolder(
            LayoutInflater.from(parent?.context).inflate(R.layout.card_timetable, parent, false))
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val timetable = timetables[holder.adapterPosition]
        holder.bind(timetable)
    }

    override fun getItemCount(): Int = timetables.size



    class MainHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(timetable: TimetableModel) {
            itemView.timetablename.text = timetable.title
        }
    }
}