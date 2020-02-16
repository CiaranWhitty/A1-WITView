package com.example.a1_witview.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.get
import androidx.fragment.app.Fragment
import com.example.a1_witview.R
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.support.v4.toast

class HomeFragment : Fragment(), AdapterView.OnItemSelectedListener, AnkoLogger{

    lateinit var D_time: TextView
    lateinit var D_day: TextView
    var Times = arrayOf("9.15","10.15", "11.15", "12.15","13.15","14.15", "15.15", "16.15", "17.15")
    var Days = arrayOf("Monday","Tuesday", "Wednesday", "Thursday", "Friday")



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activity?.title = getString(R.string.menu_home)


        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_home, container, false)

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

    companion object {
        @JvmStatic
        fun newInstance() =
            HomeFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }



}