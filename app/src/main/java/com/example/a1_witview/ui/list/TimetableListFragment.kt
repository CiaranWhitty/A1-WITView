package com.example.a1_witview.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a1_witview.Main.MainApp
import com.example.a1_witview.MainActivity

import com.example.a1_witview.R
import com.example.a1_witview.adapters.TimetableAdapter
import kotlinx.android.synthetic.main.fragment_timetablelist.*
import kotlinx.android.synthetic.main.fragment_timetablelist.view.*
import org.jetbrains.anko.support.v4.intentFor

class TimetableListFragment : Fragment() {

    lateinit var app: MainApp


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.title = getString(R.string.menu_timetablelist)
        app = activity?.application as MainApp



        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_timetablelist, container, false)


        return root

    }


    companion object {
        @JvmStatic
        fun newInstance() =
            TimetableListFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }



}
