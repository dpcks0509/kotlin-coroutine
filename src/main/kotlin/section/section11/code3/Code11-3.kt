package section.section11.code3

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex

var count = 0
val mutex = Mutex()

fun main() = runBlocking<Unit> {
  withContext(Dispatchers.Default) {
    repeat(10_000) {
      launch {
        mutex.lock()
        section.section11.code1.count += 1
        mutex.unlock()
      }
    }
  }
  println("count = ${section.section11.code1.count}")
}