package com.arbys.rpgcharactersheetmaker.characterSheet

import java.io.Serializable

class Spell: Serializable {
    lateinit var spellName: String
    lateinit var level: String
    lateinit var castingTime: String
    lateinit var duration: String
    lateinit var rangeArea: String
    lateinit var attackSave: String
    lateinit var damageEffect: String
}