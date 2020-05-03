package com.example.a1_witview.Models


interface TimetableStore {

    fun findAll(): List<TimetableModel>
    fun findById(id: Long): TimetableModel?
    fun create(timetable: TimetableModel)
    fun update(timetable: TimetableModel)
}