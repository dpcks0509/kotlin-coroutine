package section.section7.code12

import kotlinx.coroutines.*

fun main() {
  val coroutineScope = CoroutineScope(Dispatchers.IO)
  coroutineScope.launch {
    delay(100L) // 100밀리초 대기
    println("[${Thread.currentThread().name}] 코루틴 실행 완료")
  }
  Thread.sleep(1000L)
}