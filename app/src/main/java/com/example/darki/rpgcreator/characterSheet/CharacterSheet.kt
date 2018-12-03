package com.arbys.rpgcharactersheetmaker.characterSheet

import java.io.Serializable

class CharacterSheet: Serializable {
    val stats = Stats()
    val inventory = ArrayList<Item>()
    val spells = ArrayList<Spell>()
    val equipment = ArrayList<Spell>()
    val skills = Skills()

    lateinit var characterClass: String
    lateinit var characterBackground: String
    lateinit var characterName: String
    lateinit var faction: String
    lateinit var race: String
    lateinit var allignment: String
    lateinit var experiace: String
}