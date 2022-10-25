import kotlin.random.Random

fun dinnerGenie() {
    val dinners = mapOf<Int, String>(1 to "Sushi", 2 to "pizza", 3 to "ramen", 4 to "chipotle", 5 to "pasta")

    val choice = Random.nextInt(1, 5)

    val urchoice = dinners.get(choice)
    println("You get ${urchoice}")

}

fun main() {
    dinnerGenie()
}