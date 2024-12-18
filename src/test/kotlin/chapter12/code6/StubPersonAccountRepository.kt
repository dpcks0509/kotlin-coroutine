package chapter12.code6

import kotlinx.coroutines.delay
import section.section12.code6.Follower
import section.section12.code6.PersonAccountRepository

class StubPersonAccountRepository(
  private val users: List<Follower.PersonAccount>
) : PersonAccountRepository {
  override suspend fun searchByName(name: String): Array<Follower.PersonAccount> {
    delay(1000L)
    return users.filter { user ->
      user.name.contains(name)
    }.toTypedArray()
  }
}