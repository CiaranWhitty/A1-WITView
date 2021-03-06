package com.example.a1_witview.ui.map

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import kotlinx.android.synthetic.main.fragment_map.*
import org.jetbrains.anko.support.v4.toast
import com.example.a1_witview.MainActivity
import com.example.a1_witview.R
import kotlinx.android.synthetic.main.fragment_map.view.*


class MapFragment : Fragment(), OnMapReadyCallback, AdapterView.OnItemSelectedListener {


    var spinner: Spinner? = null
    var textView_msg: TextView? = null
    var buildings = arrayOf("Unselected", "Main","IT", "FTG", "TL")



    private lateinit var map: GoogleMap

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activity?.title = getString(R.string.menu_map)

        map_view.onCreate(savedInstanceState)
        map_view.onResume()

        map_view.getMapAsync(this)

        btn_Map_Refresh.setOnClickListener(){

            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)

            map_view.onDestroy()

            toast("Refreshed")
        }



        arguments?.let {

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_map, container, false)

        /*Find the id of spinner*/
        val spinnerBulding = root.Bulding_spinner

        /*set an adapter with strings */
        spinnerBulding.adapter = ArrayAdapter(activity, R.layout.support_simple_spinner_dropdown_item, buildings)

        spinnerBulding.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{



            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                buildings[position]

                val IT = LatLng(52.2457685,-7.1373688)
                val FTG = LatLng(52.246349,-7.1380473)
                val TL = LatLng(52.2452466,-7.1418789)
                val wit = LatLng(52.2457058,-7.1387681)



                if (buildings.asList().indexOf(buildings[position]) == 0) {

                    toast("Please select an option")

                }

                if (buildings.asList().indexOf(buildings[position]) == 1) {

                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(wit, 18f))

                }
                if (buildings.asList().indexOf(buildings[position]) == 2) {

                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(IT, 20f))

                }
                if (buildings.asList().indexOf(buildings[position]) == 3) {
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(FTG, 19f))

                }
                if (buildings.asList().indexOf(buildings[position]) == 4) {
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(TL, 18f))

                }


                }

            override fun onNothingSelected(parent: AdapterView<*>?) {


            }

        }


        return root

    }

    override fun onItemSelected(arg0: AdapterView<*>, arg1: View, position: Int, id: Long) {


    }

    override fun onNothingSelected(arg0: AdapterView<*>) {

    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        val wit = LatLng(52.2457058,-7.1387681)
        val zoomLevel = 17.2f

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(wit, zoomLevel))

    }

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
        @JvmStatic
        fun newInstance() =
            MapFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

}

// https://www.youtube.com/watch?v=m_H3JuybsJ0
// https://www.raywenderlich.com/230-introduction-to-google-maps-api-for-android-with-kotlin#toc-anchor-004
// https://codelabs.developers.google.com/codelabs/advanced-android-kotlin-training-maps/#4
// https://support.google.com/maps/answer/18539?co=GENIE.Platform%3DDesktop&hl=en&oco=0
// https://stackoverflow.com/questions/50461881/java-lang-noclassdeffounderrorfailed-resolution-of-lorg-apache-http-protocolve

// https://stackoverflow.com/questions/48325639/how-to-use-an-arrayadapter-in-a-fragment-with-kotlin/48325799
// https://www.tutorialkart.com/kotlin-android/android-spinner-kotlin-example/