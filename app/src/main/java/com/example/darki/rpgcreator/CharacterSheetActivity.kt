package com.example.darki.rpgcreator

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.arbys.rpgcharactersheetmaker.characterSheet.CharacterSheet
import com.example.darki.rpgcreator.fragments.StatsFragment
import kotlinx.android.synthetic.main.activity_character_sheet.*
import kotlinx.android.synthetic.main.app_bar_character_sheet.*

class CharacterSheetActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, StatsFragment.OnFragmentInteractionListener {

    lateinit var cs: CharacterSheet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_sheet)

//        cs = intent.getSerializableExtra("CharacterSheet") as CharacterSheet

        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.character_sheet, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.\
        var fragment: Fragment? = null
        var fragmentClass: Class<Fragment>
        when (item.itemId) {
            R.id.stats -> {
                fragment = StatsFragment.newInstance("Hello", "World")
            }
            R.id.inventory -> {}
            R.id.spells -> {}
            R.id.money -> {}
            R.id.equipped -> {}
            R.id.skills -> {}
            R.id.character -> {}
        }
//        val fragManager = supportFragmentManager
        if (fragment != null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onFragmentInteraction(uri: Uri) {
    }
}
