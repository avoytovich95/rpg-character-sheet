package com.arbys.rpgcharactersheetmaker.characterSheet

import java.io.Serializable

class Item: Serializable {
    var itemName = ""
    var itemType = ""
    var weight = 0
    var cost: Int = 0
    var itemAttributes = ArrayList<String>()
    var notes = ArrayList<String>()

    override fun toString(): String {
        return "$itemName: $itemType"
    }
}