package com.example.a1_witview.Main

import android.app.Application
import com.example.a1_witview.Helpers.TimetableJSONStore
import com.example.a1_witview.Models.TimetableMemStore
import com.example.a1_witview.Models.TimetableModel
import com.example.a1_witview.Models.TimetableStore
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class MainApp : Application(), AnkoLogger {

    lateinit var timetableStore: TimetableStore

    override fun onCreate() {
        super.onCreate()
        timetableStore = TimetableJSONStore(applicationContext)
        info("WITView has started")


    }
}