package com.example.darki.rpgcreator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import com.arbys.rpgcharactersheetmaker.characterSheet.CharacterSheet
import com.arbys.rpgcharactersheetmaker.characterSheet.Item
import com.arbys.rpgcharactersheetmaker.characterSheet.Spell
import com.arbys.rpgcharactersheetmaker.characterSheet.Valuable
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
        cs.allignment = "Good"
        cs.characterBackground = "Sailor"
        cs.characterClass = "Rogue"
        cs.race = "Gnome"
        cs.level = "1"
        cs.characterName = "Riker"
        cs.equipment.run {
            add(Item().run {
                cost = 3
                itemAttributes.add("Small and Sturdy")
                itemName = "Short Bow"
                itemType = "ranged weapon(simple,bow)"
                notes.add("Piercing, Range, two-Handed")
                weight = 2
                this
            })
            add(Item().run {
                cost = 62
                itemAttributes.add("Really hot")
                itemName = "Dagger"
                itemType = "melee weapon(simple, dagger)"
                notes.add("Piercing, Light, Range, Thrown")
                weight = 1
                this
            })
        }
        cs.allignment = "good"
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
                this.spellName = "Arcane Burst"
                this.castingTime = "1 turn"
                this.damageEffect = "Destroys a players weapon"
                this.rangeArea = "2 tiles"
                this
            })
            add(Spell().run {
                this.spellName = "Fire Blast"
                this.castingTime = "1 second"
                this.damageEffect = "3 health, burns player"
                this.duration = "2 turns"
                this
            })
        }
        cs.money.coins = 425
        cs.money.valuables.run {
            put("Gold Ring", Valuable(2, 76))
            put("Sapphire", Valuable(1, 125))
            put("Emerald", Valuable(1, 150))
        }
    }
}




