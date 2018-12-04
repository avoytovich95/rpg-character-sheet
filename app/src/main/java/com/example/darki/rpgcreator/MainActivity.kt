package com.example.darki.rpgcreator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import com.arbys.rpgcharactersheetmaker.characterSheet.CharacterSheet
import com.arbys.rpgcharactersheetmaker.characterSheet.Item
import com.arbys.rpgcharactersheetmaker.characterSheet.Spell
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val cs = CharacterSheet()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        first.setOnClickListener { openCharacter() }

        createCharacterSheet()
    }

    fun openCharacter() {
        val intent = Intent(this, CharacterSheetActivity::class.java).apply {
            putExtra("CharacterSheet", cs)
        }
        startActivity(intent)
    }

    fun createCharacterSheet() {
        cs.allignment = ""
        cs.characterBackground = "Sailor"
        cs.characterClass = "Rogue 1"
        cs.characterName = "Riker"
        cs.equipment.run {
            add(Item().run {
                cost = 3
                itemAttributes.add("Shiny")
                itemName = "Great sword"
                itemType = "Weapon"
                notes.add("An exceptional weapon")
                weight = 15
                this
            })
            add(Item().run {
                cost = 62
                itemAttributes.add("Really hot")
                itemName = "Fire wand"
                itemType = "Magical weapon"
                notes.add("It gets really hot when you tough it")
                weight = 3
                this
            })
        }
        cs.allignment = ""
        cs.experiace = "15"
        cs.faction = ""
        cs.inventory.run {
            add(Item().run {
                cost = 16
                itemName = "Health potion"
                itemAttributes.add("Restores health")
                itemType = "Potion"
                weight = 1
                this
            })
        }
        cs.spells.run {
            add(Spell().run {

                this
            })
        }
    }
}




