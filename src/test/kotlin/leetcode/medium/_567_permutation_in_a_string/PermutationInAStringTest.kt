package leetcode.medium._567_permutation_in_a_string

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PermutationInAStringTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()
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
    }

    @Test
    fun checkInclusionAlt() {
//        assertTrue(
//            solution.checkInclusion(
//                s1 = "trinitrophenylmethylnitramine",
//                s2 = "trinitrophenylmethylnitramine"
//            )
//        )
        assertTrue(
            solution.checkInclusion(
                s1 = "trinitrophenylmethylnitramine",
                s2 = "dinitrophenylhydrazinetrinitrophenylmethylnitramine"
            )
        )
    }

    @Test
    fun checkInclusionLarge() {
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
    }


    @Test
    fun checkInclusionAlt2() {
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
    fun checkInclusionLarge2() {
        assertFalse(
            solution2.checkInclusion(
                s1 = "zftgfmnoxmfkwufwadd",
                s2 = longS2
            )
        )
    }
}
