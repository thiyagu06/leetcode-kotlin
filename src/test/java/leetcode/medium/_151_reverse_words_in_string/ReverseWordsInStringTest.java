package leetcode.medium._151_reverse_words_in_string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseWordsInStringTest {

    private final Solution solution = new Solution();

    @Test
    public void reverseWords() {
        assertEquals("blue is sky the", solution.reverseWords("the sky is blue"));
        assertEquals("blue is sky the", solution.reverseWords("    the sky is blue   "));
        assertEquals("blue is sky the", solution.reverseWords("    the      sky   is  blue   "));
    }
}