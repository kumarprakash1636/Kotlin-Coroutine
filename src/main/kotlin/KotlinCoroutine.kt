import kotlinx.coroutines.*
/**
 * Two threads are running parallel.
 * Main thread doesn't wait for the coroutine scope completion.
 */
fun main() { // main thread.
    println("This process is done by ${Thread.currentThread().name} thread.")

    GlobalScope.launch { //creates a background coroutine which runs on a background thread.
        println(Thread.currentThread().name)
        Thread.sleep(1000)
        println(Thread.currentThread().name)
    }
    Thread.sleep(2000)
    println("This process is done by ${Thread.currentThread().name} thread.")
}