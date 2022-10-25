fun main() {

    // set it to a variable to initialize it
    val squareCabin = SquareCabin(5)

    // shorten your code with the with statement
    // without it, it would look like

    // println("\n${squareCabin.dwellingName}\n=========")
    with(squareCabin) {
        println("\n${dwellingName}\n=========")
        println("Capacity: $capacity")
        println("Material: $buildingMaterial")
        println("Has room? ${hasRoom()}")
    }

    val roundHut = roundHut(3)

    with(roundHut) {
        println("\n${dwellingName}\n========")
        println("Capacity: $capacity")
        println("Material: $buildingMaterial")
        println("Has  Room? ${hasRoom()}")
    }

    val roundTower = tower(3)

    with(roundTower) {
        println("\n${dwellingName}\n========")
        println("Capacity: $capacity")
        println("Material: $buildingMaterial")
        println("Has  Room? ${hasRoom()}")
    }
}

// The abstract class can not be called on  its on and needs a subclass to inherit it.
abstract class Dwelling(private var residents: Int) {
    abstract val dwellingName: String
    abstract val buildingMaterial: String
    abstract val capacity: Int

    fun hasRoom(): Boolean {
        return residents < capacity
    }
}

// This class is final and can not be inherited from
class SquareCabin(residents: Int) : Dwelling(residents) {
    override val dwellingName = "Square Cabin"
    override val buildingMaterial = "Wood"
    override val capacity = 6
}

// Mark as open to allow the subclass to be inherited from
open class roundHut(residents: Int) : Dwelling(residents) {
    override val dwellingName = "Round Hut"
    override val buildingMaterial = "Straw"
    override val capacity = 3
}

class tower(residents: Int) : roundHut(residents) {
    override val dwellingName = "Round Tower"
    override val buildingMaterial = "Stone"
    override val capacity = 3
}