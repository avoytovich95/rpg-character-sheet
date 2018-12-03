package com.example.darki.rpgcreator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import com.arbys.rpgcharactersheetmaker.characterSheet.CharacterSheet

class MainActivity : AppCompatActivity() {

    val cs = CharacterSheet()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<LinearLayout>(R.id.first).setOnClickListener {openCharacter()}
    }

    fun openCharacter() {
        val intent = Intent(this, CharacterSheetActivity::class.java).apply {
            putExtra("CharacterSheet", cs)
        }
        startActivity(intent)
    }
}




