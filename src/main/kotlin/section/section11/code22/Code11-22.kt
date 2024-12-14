package section.section11.code22

import kotlinx.coroutines.CancellableContinuation
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

fun main() = runBlocking<Unit> {
  val result : section.section11.code22.Response = section.section11.code22.executeNetworkCall()
  println(result) // 코루틴 재개 시 반환 받은 결과 출력
}

suspend fun executeNetworkCall(): section.section11.code22.Response {
  return suspendCancellableCoroutine<section.section11.code22.Response> { continuation: CancellableContinuation<section.section11.code22.Response> ->
      section.section11.code22.executeNetworkCallAsync(
          onSuccess = {
              continuation.resume(section.section11.code22.Response.Success(it))
          },
          onFail = {
              continuation.resume(section.section11.code22.Response.Fail(it))
          }
      )
  }
}

sealed class Response() {
  data class Success(val string: String) : section.section11.code22.Response()
  data class Fail(val throwable: Throwable): section.section11.code22.Response()
}

fun executeNetworkCallAsync(onSuccess: (String) -> Unit, onFail: (Throwable) -> Unit) {
  // 네트워크 요청 실행
  onSuccess("네트워크 요청 성공")
}