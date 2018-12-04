package com.arbys.rpgcharactersheetmaker.characterSheet

import java.io.Serializable

class CharacterSheet: Serializable {
    val stats = Stats()
    val inventory = ArrayList<Item>()
    val spells = ArrayList<Spell>()
    val equipment = ArrayList<Item>()
    val skills = Skills()

    var characterClass = ""
    var characterBackground =""
    var characterName = ""
    var faction =""
    var race = ""
    var allignment = ""
    var experiace = ""
    var epxerianceNeeded = ""
    var level = ""
}