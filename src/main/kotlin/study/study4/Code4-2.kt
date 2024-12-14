package study.study4

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

fun main() =
    runBlocking<Unit> {
        val whileJob: Job =
            launch(Dispatchers.Default) {
                while (true) {
                    println("작업 중")
                    yield()
                }
            }
        delay(100L)
        whileJob.cancel()
    }
