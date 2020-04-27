package com.example.a1_witview.Models

import android.util.Log

var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class TimetableMemStore : TimetableStore {

    val timetables = ArrayList<TimetableModel>()

    override fun findAll(): List<TimetableModel> {
        return timetables
    }

    override fun findById(id:Long) : TimetableModel? {
        val foundtimetable: TimetableModel? = timetables.find { it.id == id }
        return foundtimetable
    }

    override fun create(timetable: TimetableModel) {
        timetable.id = getId()
        timetables.add(timetable)
        logAll()
    }

    fun logAll() {
        Log.v("Timetable","** Timetables List **")
        timetables.forEach { Log.v("Timetable","${it}") }
    }
}
