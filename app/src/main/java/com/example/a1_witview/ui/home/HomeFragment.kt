package com.example.a1_witview.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a1_witview.Main.MainApp
import com.example.a1_witview.Models.TimetableModel
import com.example.a1_witview.R
import com.example.a1_witview.adapters.TimetableAdapter
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.support.v4.toast

class HomeFragment : Fragment(), AdapterView.OnItemSelectedListener, AnkoLogger{

    var timetable = TimetableModel()
    lateinit var app: MainApp

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        app = activity?.application as MainApp



        // Adding Timetables
        timetable_create.setOnClickListener() {

            timetable.title = Title_Input.text.toString()


            if (timetable.title.isNotEmpty()) {


                app.timetableStore.create(timetable.copy())

                info ("Title: $timetableTitle")
                info (app.timetableStore)
                info (app.timetableStore.findAll())

                toast (Title_Input.text.toString() + " - is Now Created")

            }
            else {
                toast ("Please Enter a Title")
            }

        }



        arguments?.let {

        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        activity?.title = getString(R.string.menu_home)


        return root
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {



    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            HomeFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }



}