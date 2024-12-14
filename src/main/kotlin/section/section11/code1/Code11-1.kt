package section.section11.code1

import kotlinx.coroutines.*

var count = 0

fun main() = runBlocking<Unit> {
  withContext(Dispatchers.Default) {
    repeat(10_000) {
      launch {
        section.section11.code2.count += 1
      }
    }
  }
  println("count = ${section.section11.code2.count}")
}