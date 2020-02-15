package com.example.a1_witview.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.a1_witview.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), AdapterView.OnItemSelectedListener{


    var spinner: Spinner? = null
    var textView_msg: TextView? = null
    var Times = arrayOf("9.15","10.15", "11.15", "12.15","13.15","14.15", "15.15", "16.15", "17.15")

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        /*Find the id of spinner*/
        val spinner = timetable_spinner

        /*set an adapter with strings */
        spinner.adapter = ArrayAdapter(
            activity,
            R.layout.support_simple_spinner_dropdown_item,
            Times
        )

        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)


    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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