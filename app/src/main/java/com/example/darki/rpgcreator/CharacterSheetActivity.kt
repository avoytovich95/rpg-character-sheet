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
import com.example.darki.rpgcreator.fragments.SPellsFragment
import com.example.darki.rpgcreator.fragments.StatsFragment
import kotlinx.android.synthetic.main.activity_character_sheet.*
import kotlinx.android.synthetic.main.app_bar_character_sheet.*
import kotlinx.android.synthetic.main.nav_header_character_sheet.view.*

const val PARAM_1 = "CharacterSheet"

class CharacterSheetActivity :
    AppCompatActivity(),
    NavigationView.OnNavigationItemSelectedListener,
    StatsFragment.OnFragmentInteractionListener,
    SPellsFragment.OnFragmentInteractionListener{

    lateinit var cs: CharacterSheet

    lateinit var statsFrag: Fragment
    lateinit var inventoryFrag: Fragment
    lateinit var spellFrag: Fragment
    lateinit var moneyFrag: Fragment
    lateinit var equipedFrag: Fragment
    lateinit var charFrag: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_sheet)

        cs = intent.getSerializableExtra(PARAM_1) as CharacterSheet
        title = cs.characterName
        nav_view
            .getHeaderView(0)
            .character_name
            .text = cs.characterName


        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        statsFrag = StatsFragment.newInstance(cs.stats, cs.skills)
        spellFrag = SPellsFragment.newInstance(cs.spells)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.character_sheet, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.stats -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, statsFrag)
                    .commit()
            }
            R.id.inventory -> {}
            R.id.spells -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, spellFrag)
                    .commit()
            }
            R.id.money -> {}
            R.id.equipped -> {}
            R.id.skills -> {}
            R.id.character -> {}
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onFragmentInteraction(uri: Uri) {
    }
}
