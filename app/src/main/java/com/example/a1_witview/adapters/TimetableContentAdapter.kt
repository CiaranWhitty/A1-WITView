package com.example.a1_witview.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a1_witview.Models.TimetableModel
import com.example.a1_witview.R
import kotlinx.android.synthetic.main.card_timetable_details.view.*
import kotlinx.android.synthetic.main.sidecard_timetable.view.*

class TimetableContentAdapter constructor(private var timetables: List<TimetableModel>,
                                   private val listener: TimetableListener) : RecyclerView.Adapter<TimetableAdapter.MainHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimetableAdapter.MainHolder {


        return TimetableAdapter.MainHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.card_timetable_details, parent, false))


    }

    override fun onBindViewHolder(holder: TimetableAdapter.MainHolder, position: Int) {
        val timetable = timetables[holder.adapterPosition]
        holder.bind(timetable, listener)
    }


    override fun getItemCount(): Int = timetables.size

    class MainHolders constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(timetable: TimetableModel) {
            itemView.timetablename.text = timetable.title

            itemView.timetable_subject.text = timetable.subject
            itemView.timetable_lecturer.text = timetable.lecturer
            itemView.timetable_room.text = timetable.room
            itemView.timetable_Times.text = timetable.spinnerT
            itemView.timetable_Days.text = timetable.spinnerD

        }
    }



}