/*
 * Problem: Substring with Concatenation of All Words
 * 
 * Approach:
 * The task is to find all starting indices of substrings in `s` that are formed by 
 * concatenating all words in `words` exactly once and without any intervening characters:
 * - Compute the length of each word (`wordLen`), the number of words (`wordCount`), 
 *   and the total length of the concatenated substring (`totalLen`).
 * - Build a frequency map (`wordMap`) of the words in `words`.
 * - Iterate over possible starting offsets (0 to `wordLen - 1`) to handle alignment.
 * - For each offset, use a sliding window with two pointers (`left` and `right`) and 
 *   a `seenWords` map to track word frequencies in the current window.
 * - Extract substrings of length `wordLen` as potential words:
 *   - If the word exists in `wordMap`, add it to `seenWords` and increment count.
 *   - If its frequency exceeds the allowed count, shrink the window from the left 
 *     until valid.
 *   - If the count equals `wordCount`, record the starting index (`left`) as a valid solution.
 *   - If the word does not exist in `wordMap`, reset the window and clear `seenWords`.
 * - Continue until all possible windows are checked.
 * 
 * Complexity:
 * - Time Complexity: O(n * wordLen) → Each character is processed in chunks of `wordLen`, 
 *   with sliding window adjustments.
 * - Space Complexity: O(m) → HashMaps store frequencies of words, where `m` is the number of words.
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> indices = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return indices;

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;
        int sLen = s.length();

        if (sLen < totalLen) return indices;

   
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int right = i;
            int count = 0; 
            Map<String, Integer> seenWords = new HashMap<>();

            while (right + wordLen <= sLen) {
          
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordMap.containsKey(word)) {
                    seenWords.put(word, seenWords.getOrDefault(word, 0) + 1);
                    count++;

               
                    while (seenWords.get(word) > wordMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seenWords.put(leftWord, seenWords.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

               
                    if (count == wordCount) {
                        indices.add(left);
                    }
                } else {
     
                    seenWords.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return indices;
    }
}
