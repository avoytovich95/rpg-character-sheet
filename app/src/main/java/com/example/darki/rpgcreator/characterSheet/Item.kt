package com.arbys.rpgcharactersheetmaker.characterSheet

import java.io.Serializable

class Item: Serializable {
    lateinit var itemName: String
    lateinit var itemType: String
    var weight = 0
    var cost: Int = 0
    var itemAttributes = ArrayList<String>()
    var notes = ArrayList<String>()
}