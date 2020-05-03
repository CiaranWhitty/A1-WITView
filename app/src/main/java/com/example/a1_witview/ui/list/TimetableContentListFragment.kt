package com.example.a1_witview.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a1_witview.Main.MainApp
import com.example.a1_witview.MainActivity
import com.example.a1_witview.Models.TimetableModel
import com.example.a1_witview.R
import com.example.a1_witview.adapters.TimetableContentAdapter
import com.example.a1_witview.adapters.TimetableListener
import kotlinx.android.synthetic.main.card_timetable_details.*
import kotlinx.android.synthetic.main.card_timetable_details.view.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_timetablecontentlist.*
import kotlinx.android.synthetic.main.fragment_timetablecontentlist.view.*
import kotlinx.android.synthetic.main.fragment_timetablelist.view.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.support.v4.intentFor
import org.jetbrains.anko.support.v4.toast




class TimetableContentListFragment : Fragment(), TimetableListener, AdapterView.OnItemSelectedListener,
    AnkoLogger {

    lateinit var app: MainApp
    var timetable = TimetableModel()

    lateinit var D_time: TextView
    lateinit var D_day: TextView
    var Times = arrayOf("9.15","10.15", "11.15", "12.15","13.15","14.15", "15.15", "16.15", "17.15")
    var Days = arrayOf("Monday","Tuesday", "Wednesday", "Thursday", "Friday")


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.title = getString(R.string.menu_timetablelist)
        app = activity?.application as MainApp


        // Adding Timetables contents
        timetable_create.setOnClickListener() {


            timetable.subject = Subject_Input.text.toString()
            timetable.lecturer = Lecturer_Input.text.toString()
            timetable.room = Room_Input.text.toString()

            timetable.spinnerT = Display_Time.text.toString()
            timetable.spinnerD = Display_Day.text.toString()


            if (timetable.subject.isNotEmpty() && timetable.lecturer.isNotEmpty() &&
                timetable.room.isNotEmpty()) {


                app.timetableStore.create(timetable.copy())

                info ("Title: $timetableTitle")
                info (app.timetableStore)
                info (app.timetableStore.findAll())

                toast (timetable.title + " - Updated")

            }
            else {
                toast ("Please Fill All Text Fields")
            }

        }


        arguments?.let {

        }
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val root = inflater.inflate(R.layout.fragment_timetablecontentlist, container, false)

        root.recyclerViewContent.layoutManager = LinearLayoutManager(activity)
        root.recyclerViewContent.adapter = TimetableContentAdapter(app.timetableStore.findAll(), this)


        /*Find the id of spinner*/
        val spinnerTimes = root.timetable_spinner_times
        val spinnerDays = root.timetable_spinner_days

        /*set an adapter with strings */
        spinnerTimes.adapter = ArrayAdapter(activity, R.layout.support_simple_spinner_dropdown_item, Times)
        spinnerDays.adapter = ArrayAdapter(activity, R.layout.support_simple_spinner_dropdown_item, Days)

        spinnerTimes.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                root.Display_Time.setText(Times.get(position))



            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                root.Display_Time.setText("Select a time")

            }
        }

        spinnerDays.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                root.Display_Day.setText(Days.get(position))

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                root.Display_Day.setText("Select a Day")

            }
        }


        return root


    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {



    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTimetableClick(timetable: TimetableModel) {

        startActivityForResult(intentFor<MainActivity>().putExtra("timetable_edit", timetable), 0)

    }


    companion object {
        @JvmStatic
        fun newInstance() =
            TimetableContentListFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

}






