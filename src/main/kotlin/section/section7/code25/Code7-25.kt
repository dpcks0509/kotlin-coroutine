package section.section7.code25

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val newRootJob = Job() // 루트 Job 생성
  launch(CoroutineName("Coroutine1") + newRootJob) {
    launch(CoroutineName("Coroutine3")) {
      delay(100L)
      println("[${Thread.currentThread().name}] 코루틴 실행")
    }
    launch(CoroutineName("Coroutine4")) {
      delay(100L)
      println("[${Thread.currentThread().name}] 코루틴 실행")
    }
  }
  launch(CoroutineName("Coroutine2") + newRootJob) {
    launch(CoroutineName("Coroutine5")) {
      delay(100L)
      println("[${Thread.currentThread().name}] 코루틴 실행")
    }
  }
  delay(1000L)
}