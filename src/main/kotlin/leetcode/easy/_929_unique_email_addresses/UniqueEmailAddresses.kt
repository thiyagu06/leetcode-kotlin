package leetcode.easy._929_unique_email_addresses

/**
 * 929 - https://leetcode.com/problems/unique-email-addresses/
 */
class Solution {
    /**
     * Time: O(n^2)
     * Space: O(n)
     */
    fun numUniqueEmails(emails: Array<String>): Int =
        emails.fold(initial = HashSet<String>()) { acc, email ->
            val (rawLocal, domain) = email.split('@')
            val local = rawLocal.filterNot { it == '.' }.takeWhile { it != '+' }
            acc.apply { acc += "$local@$domain" }
        }.size
}