package section.section11.code2

import kotlinx.coroutines.*

@Volatile
var count = 0

fun main() = runBlocking<Unit> {
  withContext(Dispatchers.Default) {
    repeat(10_000) {
      launch {
        section.section11.code1.count += 1
      }
    }
  }
  println("count = ${section.section11.code1.count}")
}