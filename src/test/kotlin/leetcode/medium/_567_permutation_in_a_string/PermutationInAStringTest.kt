package leetcode.medium._567_permutation_in_a_string

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PermutationInAStringTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()
    private val solution3 = SolutionThree()
    private val longS2 =
        "lcqhdarsfkqymriptcqrpfugsymeoambboebqrtgesytmyudzjnzmscgqpimvadeevwbtxewzccwqfxsshbwtjzasyvwujxfzcpmocyxmdhsyqogwyissjqbkecbqaweiqhhgcbvhuwfmhatdfidqeexuicsljbxempkpcxbattiikmnehqmblbvahgetyuabowbieiekihbdygpeboewbqlikxdxvnmvihmhmzzodkqagvrvyxyyjdcnroyvfzggadihpqtrtrihigysexvcyehkdyellqbxzjwubynduenjwaxobcokfnhclqvuhvcafsdygiqgmdmavobulleslqcfyghgeodfxsitawupalbudwehqzzdczxyhyweivuoeqgdurotkbbsolcsnkhqakpppdgklrgszdwnpkysbqczkjvwwdezbrmrwyapocwulmllnezndrmyyalyvvthjeizrmrccvqnfxrrwcsjilnlznohgwthbwnguqkloqnxwudkeeosimjihasknogkxafsgnvgrlymvhrubnekdmdgumgtlwhskyqsmvmsynsjadsghjhidbugtxhfrpzkhjwtqarwjyowdkjmpwnjfsznxokxhdjjxdqycbjqywipfcoxyzmwmemnihzcmdadegxzxkxnworbdjfmtyiwowfddmfmkxgauffznfgadsvfkbsfwpuhcjxtzfmwsllyglclaaheddqkglshspemwmymyexknqenbyzaxbecbzhteuysdcvxwzyommsmitpxnqdwnhxtitrxtfhfyddqsmqszmovivbiqknfdvqkioovsxbcouxpcqygsltosewaomqhkqlercbdxidazvddrlwbhwgqetjvusxynwljtwoluegezwumsvfocuyqxnrjkqqxfdkcueylgakvpqecgwlkmttdjxkgbmvbxyjsbtshudbvvsneiwbhzvpulsjtxkgbljnryzqmgkrjbmcqaxfstedhyyejdrgeoumzhjilrmemrrkfogbiwjifosipawkhbxruzwkgpbwvkxnrtkktuozwrlgdcqnoezzwqdgutsykwaizvgoccmnkujioxnoffhjpssqezpthqikhbckbyimozhcxszoqoknxmvkzmcigiwjplxjyssiauwgnvrgvokaxjvibbhodcxejzejobqeeppxyhvmozjprvrcodalyojuberheagstturwtvkpkkerjbiivuqmwjehuisjmciopnkjanghmfemxoawjzkjgiqsmoutxzuzguvfmobmxfhwzgchvvhmoudjmmxcwkjvezbvyqznpkaontyoepfabphrxrzdzldnwswbljdrervcmzgmqfsisxxicxxocgbvrciboavalvksmrwwfhjcbdsubewpbxqqpxnplrnlvbeuetesxfezuhymaalkjlahnvqwiruouafpxawrmhbmqfofpgdgckasfhjyrsknfpgnlfuxhzhoaoqdynfv"

    @Test
    fun checkInclusion() {
        assertFalse(solution.checkInclusion(s1 = "a", s2 = "b"))
        assertTrue(solution.checkInclusion(s1 = "ab", s2 = "eidbaooo"))
        assertFalse(solution.checkInclusion(s1 = "ab", s2 = "eidboaoo"))
        assertTrue(solution.checkInclusion(s1 = "ab", s2 = "zbba"))
        assertFalse(solution.checkInclusion(s1 = "ab", s2 = "zbboa"))
        assertTrue(solution.checkInclusion(s1 = "abc", s2 = "zabcb"))
        assertFalse(solution.checkInclusion(s1 = "abc", s2 = "zabbc"))
        assertFalse(solution.checkInclusion(s1 = "xy", s2 = "axbcdefy"))
        assertTrue(solution.checkInclusion(s1 = "xy", s2 = "axbcdefyx"))
        assertFalse(solution.checkInclusion(s1 = "xxxyyy", s2 = "axxyxybc"))
        assertTrue(solution.checkInclusion(s1 = "xxxyyy", s2 = "axxyxyybc"))
        assertTrue(solution.checkInclusion(s1 = "adc", s2 = "dcda"))
    }

    @Test
    fun checkInclusionLong() {
        assertTrue(
            solution.checkInclusion(
                s1 = "trinitrophenylmethylnitramine",
                s2 = "trinitrophenylmethylnitramine"
            )
        )
        assertTrue(
            solution.checkInclusion(
                s1 = "trinitrophenylmethylnitramine",
                s2 = "dinitrophenylhydrazinetrinitrophenylmethylnitramine"
            )
        )
    }

    @Test
    fun checkInclusionVeryLong() {
        assertFalse(
            solution.checkInclusion(
                s1 = "zftgfmnoxmfkwufwadd",
                s2 = longS2
            )
        )
    }

    @Test
    fun checkInclusion2() {
        assertFalse(solution2.checkInclusion(s1 = "a", s2 = "b"))
        assertTrue(solution2.checkInclusion(s1 = "ab", s2 = "eidbaooo"))
        assertFalse(solution2.checkInclusion(s1 = "ab", s2 = "eidboaoo"))
        assertTrue(solution2.checkInclusion(s1 = "ab", s2 = "zbba"))
        assertFalse(solution2.checkInclusion(s1 = "ab", s2 = "zbboa"))
        assertTrue(solution2.checkInclusion(s1 = "abc", s2 = "zabcb"))
        assertFalse(solution2.checkInclusion(s1 = "abc", s2 = "zabbc"))
        assertFalse(solution2.checkInclusion(s1 = "xy", s2 = "axbcdefy"))
        assertTrue(solution2.checkInclusion(s1 = "xy", s2 = "axbcdefyx"))
        assertFalse(solution2.checkInclusion(s1 = "xxxyyy", s2 = "axxyxybc"))
        assertTrue(solution2.checkInclusion(s1 = "xxxyyy", s2 = "axxyxyybc"))
        assertTrue(solution2.checkInclusion(s1 = "adc", s2 = "dcda"))
    }

    @Test
    fun checkInclusionLong2() {
        assertTrue(
            solution2.checkInclusion(
                s1 = "trinitrophenylmethylnitramine",
                s2 = "trinitrophenylmethylnitramine"
            )
        )
        assertTrue(
            solution2.checkInclusion(
                s1 = "trinitrophenylmethylnitramine",
                s2 = "dinitrophenylhydrazinetrinitrophenylmethylnitramine"
            )
        )
    }

    @Test
    fun checkInclusionVeryLong2() {
        assertFalse(
            solution2.checkInclusion(
                s1 = "zftgfmnoxmfkwufwadd",
                s2 = longS2
            )
        )
    }

    @Test
    fun checkInclusion3() {
        assertFalse(solution3.checkInclusion(s1 = "a", s2 = "b"))
        assertTrue(solution3.checkInclusion(s1 = "ab", s2 = "eidbaooo"))
        assertFalse(solution3.checkInclusion(s1 = "ab", s2 = "eidboaoo"))
        assertTrue(solution3.checkInclusion(s1 = "ab", s2 = "zbba"))
        assertFalse(solution3.checkInclusion(s1 = "ab", s2 = "zbboa"))
        assertTrue(solution3.checkInclusion(s1 = "abc", s2 = "zabcb"))
        assertFalse(solution3.checkInclusion(s1 = "abc", s2 = "zabbc"))
        assertFalse(solution3.checkInclusion(s1 = "xy", s2 = "axbcdefy"))
        assertTrue(solution3.checkInclusion(s1 = "xy", s2 = "axbcdefyx"))
        assertFalse(solution3.checkInclusion(s1 = "xxxyyy", s2 = "axxyxybc"))
        assertTrue(solution3.checkInclusion(s1 = "xxxyyy", s2 = "axxyxyybc"))
        assertTrue(solution3.checkInclusion(s1 = "adc", s2 = "dcda"))
    }

    @Test
    fun checkInclusionLong3() {
        assertTrue(
            solution3.checkInclusion(
                s1 = "trinitrophenylmethylnitramine",
                s2 = "trinitrophenylmethylnitramine"
            )
        )
        assertTrue(
            solution3.checkInclusion(
                s1 = "trinitrophenylmethylnitramine",
                s2 = "dinitrophenylhydrazinetrinitrophenylmethylnitramine"
            )
        )
    }

    @Test
    fun checkInclusionVeryLong3() {
        assertFalse(
            solution3.checkInclusion(
                s1 = "zftgfmnoxmfkwufwadd",
                s2 = longS2
            )
        )
    }
}