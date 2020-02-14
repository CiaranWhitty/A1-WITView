package com.example.a1_witview.ui.map

import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.example.a1_witview.R
import com.google.android.gms.maps.CameraUpdate
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.fragment_map.*
import org.jetbrains.anko.toast

class MapFragment : Fragment(), OnMapReadyCallback {


    private lateinit var map: GoogleMap

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        map_view.onCreate(savedInstanceState)
        map_view.onResume()

        map_view.getMapAsync(this)

        arguments?.let {

        }

    }


    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        val wit = LatLng(52.2457058,-7.1387681)
        val zoomLevel = 17.2f

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(wit, zoomLevel))

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map, container, false)
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
