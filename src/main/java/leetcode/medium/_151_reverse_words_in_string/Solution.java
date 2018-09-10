package leetcode.medium._151_reverse_words_in_string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String reverseWords(String s) {
        final String trimmed = s.trim();
        final String[] split = trimmed.split(" ");
        final List<String> words = Arrays.stream(split).filter(word -> !word.isEmpty()).collect(Collectors.toList());
        Collections.reverse(words);
        return String.join(" ", words);
    }
}