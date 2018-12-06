package com.arbys.rpgcharactersheetmaker.characterSheet

import java.io.Serializable

class Money: Serializable {
    var coins = 0
    val valuables = HashMap<String, Valuable>()
}

class Valuable(var quantity: Int, var cost: Int): Serializable {
    fun toList(): ArrayList<String> {
        val list = ArrayList<String>()
        list += "Quantity $quantity"
        list += "Cost: $cost"
        return list
    }
}