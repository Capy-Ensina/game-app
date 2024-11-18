package br.com.capyensina.main.database

data class User(
    var name: String,
    var user: String,
    var password: String,
    var birthdate: String,
    var city: String,
    var email: String,
    var registerDate: String,
    var moneyQtd: Double,
    var level: Int,
    var stage: Int,
    var minigame: Array<Minigame>,
    var desbloqueio: Array<Desbloqueio>,

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (name != other.name) return false
        if (user != other.user) return false
        if (password != other.password) return false
        if (birthdate != other.birthdate) return false
        if (city != other.city) return false
        if (email != other.email) return false
        if (registerDate != other.registerDate) return false
        if (moneyQtd != other.moneyQtd) return false
        if (level != other.level) return false
        if (stage != other.stage) return false
        if (!minigame.contentEquals(other.minigame)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + user.hashCode()
        result = 31 * result + password.hashCode()
        result = 31 * result + birthdate.hashCode()
        result = 31 * result + city.hashCode()
        result = 31 * result + email.hashCode()
        result = 31 * result + registerDate.hashCode()
        result = 31 * result + moneyQtd.hashCode()
        result = 31 * result + level
        result = 31 * result + stage
        result = 31 * result + minigame.contentHashCode()
        return result
    }
}


