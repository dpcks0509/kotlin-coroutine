package section.section11.code7

import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicInteger

var count = AtomicInteger(0)

fun main() = runBlocking<Unit> {
  withContext(Dispatchers.Default) {
    repeat(10_000) {
      launch {
        section.section11.code7.count.getAndUpdate { it + 1 }
      }
    }
  }
  println("count = ${section.section11.code7.count}")
}