package com.arbys.rpgcharactersheetmaker.characterSheet

class Money {
    var coins = 0
    val valuables = HashMap<String, Valuable>()
}

class Valuable(var quantity: Int, var cost: Int)