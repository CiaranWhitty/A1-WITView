package com.example.a1_witview.Helpers

import android.content.Context
import com.example.a1_witview.Models.TimetableModel
import com.example.a1_witview.Models.TimetableStore
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import org.jetbrains.anko.AnkoLogger
import java.util.*

val JSON_FILE = "timetables.json"
val gsonBuilder = GsonBuilder().setPrettyPrinting().create()
val listType = object : TypeToken<java.util.ArrayList<TimetableModel>>() {}.type

fun generateRandomId(): Long {
    return Random().nextLong()
}

class TimetableJSONStore : TimetableStore, AnkoLogger {

    override fun findById(id: Long): TimetableModel? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    val context: Context
    var timetables = mutableListOf<TimetableModel>()

    constructor (context: Context) {
        this.context = context
        if (exists(context, JSON_FILE)) {
            deserialize()
        }
    }

    override fun findAll(): MutableList<TimetableModel> {
        return timetables
    }

    override fun create(timetable: TimetableModel) {
        timetable.id = generateRandomId()
        timetables.add(timetable)
        serialize()
    }



    private fun serialize() {
        val jsonString = gsonBuilder.toJson(timetables, listType)
        write(context, JSON_FILE, jsonString)
    }

    private fun deserialize() {
        val jsonString = read(context, JSON_FILE)
        timetables = Gson().fromJson(jsonString, listType)
    }
}