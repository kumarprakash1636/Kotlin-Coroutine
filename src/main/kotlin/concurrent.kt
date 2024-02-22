import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() =
    runBlocking { // Coroutine scope started on main thread by blocking the main thread.
        println(Thread.currentThread().name)

        val time =
            measureTimeMillis {
                val message1 = async { getFirstMessage() } // First child coroutine on main thread.
                val message2 = async { getSecondMessage() } // Second child coroutine on main thread.
                println("First message is ${message1.await()} and second message is ${message2.await()}.")
            }
        println("Time taken: $time")
        println(Thread.currentThread().name)
    }

suspend fun getFirstMessage(): String {
    delay(1000)
    return "Hello"
}

suspend fun getSecondMessage(): String {
    delay(1000)
    // println("Complete me.")                          // If await() fn is not called then this statement will be executed at last.
    return "World"
}
