package leetcode.easy._929_unique_email_addresses

import org.junit.Test

import kotlin.test.assertEquals

class UniqueEmailAddressesTest {

    private val solution = Solution()

    @Test
    fun numUniqueEmails() {
        assertEquals(
            2,
            solution.numUniqueEmails(
                arrayOf(
                    "test.email+alex@leetcode.com",
                    "test.e.mail+bob.cathy@leetcode.com",
                    "testemail+david@lee.tcode.com"
                )
            )
        )
    }
}