fun main() {

    // set it to a variable to initialize it
    val squareCabin = SquareCabin(5, 50.0)

    // shorten your code with the with statement
    // without it, it would look like

    // println("\n${squareCabin.dwellingName}\n=========")
    with(squareCabin) {
        println("\n${dwellingName}\n=========")
        println("Capacity: $capacity")
        println("Material: $buildingMaterial")
        println("Has room? ${hasRoom()}")
        println("Floor Area: ${floorArea()}")
    }

    val roundHut = roundHut(3, 15.0)

    with(roundHut) {
        println("\n${dwellingName}\n========")
        println("Capacity: $capacity")
        println("Material: $buildingMaterial")
        println("Has  Room? ${hasRoom()}")
        println("Floor Area: ${floorArea()}")
    }

    val roundTower = tower(3, 12.0, 3)

    with(roundTower) {
        println("\n${dwellingName}\n========")
        println("Capacity: $capacity")
        println("Material: $buildingMaterial")
        println("Has  Room? ${hasRoom()}")
        println("Floor Area: ${floorArea()}")
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

    abstract fun floorArea(): Double

    fun getRoom() {
        if(capacity > residents) {
            residents++
            println("You get a room!")
        } else {
            println("Sorry, no rooms left.")
        }
    }
}


// This class is final and can not be inherited from
class SquareCabin(residents: Int, val length: Double) : Dwelling(residents) {
    override val dwellingName = "Square Cabin"
    override val buildingMaterial = "Wood"
    override val capacity = 6

    override fun floorArea(): Double {
        return length * length
    }
}

// Mark as open to allow the subclass to be inherited from
open class roundHut(residents: Int, val radius: Double) : Dwelling(residents) {
    override val dwellingName = "Round Hut"
    override val buildingMaterial = "Straw"
    override val capacity = 3

    override fun floorArea(): Double {
        return radius * radius * Math.PI
    }
}

class tower(residents: Int, radius: Double, val floors: Int = 2) : roundHut(residents, radius) {
    override val dwellingName = "Round Tower"
    override val buildingMaterial = "Stone"
    override val capacity = 3

    override fun floorArea(): Double {
        return super.floorArea() * floors
    }
}