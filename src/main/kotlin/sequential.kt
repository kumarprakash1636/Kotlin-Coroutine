import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    println(Thread.currentThread().name)

    val time = measureTimeMillis {
        printFirstMessage("Hello")
        printSecondMessage("World")
    }
    println(time)
    println(Thread.currentThread().name)
}

suspend fun printFirstMessage(str: String) {
    delay(1000)
    println(str)
}

suspend fun printSecondMessage(str: String) {
    delay(1000)
    println(str)
}