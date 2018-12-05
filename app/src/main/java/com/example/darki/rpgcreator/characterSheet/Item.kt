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
        if (itemName != "")
            list += "Item Name: $itemName"
        if (itemType != "")
            list += "Item Type: $itemType"
        if (weight != 0)
            list += "Weight: $weight"
        if (cost != 0)
            list += "Cost: $cost"
        if (!itemAttributes.isEmpty())
            list += "Item Attributes: " + list.addAll(itemAttributes)
        if (!notes.isEmpty())
            list += "Notes: " + list.addAll(notes)
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