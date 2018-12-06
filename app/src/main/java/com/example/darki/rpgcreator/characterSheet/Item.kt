package com.arbys.rpgcharactersheetmaker.characterSheet

import java.io.Serializable

class Item: Serializable {
    var itemName = ""
    var itemType = ""
    var weight = 0
    var cost: Int = 0
    var itemAttributes = ArrayList<String>()
    var notes = ArrayList<String>()

    fun getAttributesList(): ArrayList<String> {
        val list = ArrayList<String>()
        if (itemType != "")
            list += "Item Type: $itemType"
        list += "Weight: $weight"
        list += "Cost: $cost"
        itemAttributes.forEach { a -> list += "attr: $a" }
        notes.forEach { n -> list += "note: $n" }
        return list
    }

    //basically a formatted toString():
    private fun itemSplit(list: ArrayList<String>): String {

        var retString = ""

        for (i in list) {retString += (i + ", ")}

        return retString
    }

    override fun toString(): String {
        return "$itemName: $itemType: $weight: $cost: " +
                itemSplit(itemAttributes) +
                itemSplit(notes)
    }
}