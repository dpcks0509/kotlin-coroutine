package section.section11.code4

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

var count = 0
val mutex = Mutex()

fun main() = runBlocking<Unit> {
  withContext(Dispatchers.Default) {
    repeat(10_000) {
      launch {
        section.section11.code4.mutex.withLock {
          section.section11.code4.count += 1
        }
      }
    }
  }
  println("count = ${section.section11.code4.count}")
}