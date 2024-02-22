import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() =
    runBlocking {
        println("Different operations performed on two numbers 5 and 5 in thread: ${Thread.currentThread().name}")

        val time =
            measureTimeMillis {
                val sum = async { addition(5, 5) }
                val difference = async { substraction(5, 5) }
                val product = async { multiplication(5, 5) }
                val quotient = async { division(5, 5) }
                println(
                    """Sum:${sum.await()}
                    |Difference:${difference.await()}
                    |Product:${product.await()}
                    |Quotient:${quotient.await()}
                    """.trimMargin(),
                )
            }
        println("Time taken: $time.")
        println("All operations are done in thread: ${Thread.currentThread().name}")
    }

suspend fun addition(
    a: Int,
    b: Int,
): Int {
    delay(1000)
    return a + b
}

suspend fun substraction(
    a: Int,
    b: Int,
): Int {
    delay(1000)
    return a - b
}

suspend fun multiplication(
    a: Int,
    b: Int,
): Int {
    delay(1000)
    return a * b
}

suspend fun division(
    a: Int,
    b: Int,
): Int {
    delay(1000)
    return a / b
}
