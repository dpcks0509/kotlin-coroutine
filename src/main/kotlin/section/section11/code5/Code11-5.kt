package section.section11.code5

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.util.concurrent.locks.ReentrantLock

var count = 0
val reentrantLock = ReentrantLock()

fun main() = runBlocking<Unit> {
  withContext(Dispatchers.Default) {
    repeat(10_000) {
      launch {
        section.section11.code5.reentrantLock.lock()
        section.section11.code5.count += 1
        section.section11.code5.reentrantLock.unlock()
      }
    }
  }
  println("count = ${section.section11.code5.count}")
}