package com.example.a1_witview

import android.os.Bundle
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.app.ActivityCompat
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.a1_witview.Main.MainApp
import com.example.a1_witview.Models.TimetableModel
import com.example.a1_witview.adapters.TimetableListener
import com.example.a1_witview.ui.home.HomeFragment
import com.example.a1_witview.ui.list.TimetableListFragment
import com.example.a1_witview.ui.map.MapFragment
import com.example.a1_witview.ui.news.NewsFragment

import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.activity_main.*

import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast

import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,
    TimetableListener {

    lateinit var app: MainApp

    lateinit var ft: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        nav_view.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        ft = supportFragmentManager.beginTransaction()

        val fragment = HomeFragment.newInstance()
        ft.replace(R.id.nav_host_fragment, fragment)
        ft.commit()


        val permissions = arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION)
        ActivityCompat.requestPermissions(this, permissions,0)

    }



    override fun onTimetableClick(timetable: TimetableModel) {

        startActivityForResult(intentFor<MainActivity>(), 0)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.nav_home -> navigateTo(HomeFragment.newInstance())
            R.id.nav_map -> navigateTo(MapFragment.newInstance())
            R.id.nav_news -> navigateTo(NewsFragment.newInstance())
            R.id.nav_timetable -> navigateTo(TimetableListFragment.newInstance())






            else -> toast("You Selected Something Else")
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            // LogOut
            R.id.action_Logout -> {FirebaseAuth.getInstance().signOut() ; finish()}

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START))
            drawer_layout.closeDrawer(GravityCompat.START)
        else
            super.onBackPressed()
    }

    private fun navigateTo(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, fragment)
            .addToBackStack(null)
            .commit()
    }
}
