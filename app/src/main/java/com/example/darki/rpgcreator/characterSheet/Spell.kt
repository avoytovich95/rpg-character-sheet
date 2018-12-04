package com.arbys.rpgcharactersheetmaker.characterSheet

import java.io.Serializable

class Spell: Serializable {
    var spellName = ""
    var level = ""
    var castingTime = ""
    var duration = ""
    var rangeArea = ""
    var attackSave = ""
    var damageEffect = ""

    fun getAttributesList(): ArrayList<String> {
        val list = ArrayList<String>()
        if (level != "")
            list += "Level: $level"
        if (castingTime != "")
            list += "Casting Time: $castingTime"
        if (duration != "")
            list += "Duration: $duration"
        if (rangeArea != "")
            list += "Range/Area: $rangeArea"
        if (attackSave != "")
            list += "Attack/Save: $attackSave"
        if (damageEffect != "")
            list += "Damage/Effect: $damageEffect"
        return list
    }

    override fun toString(): String {
        return "$spellName, $level, $castingTime, $duration, $rangeArea, $attackSave, $damageEffect"
    }
}

