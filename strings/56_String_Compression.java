/*
 * Problem: String Compression
 * 
 * Approach:
 * The task is to compress the given character array in-place by replacing consecutive 
 * repeating characters with the character followed by its count:
 * - Use two pointers:
 *   - `left` to mark the start of a group of repeating characters.
 *   - `index` to track the position where compressed characters are written.
 * - For each group of consecutive identical characters:
 *   - Count the length of the group (`count`).
 *   - Write the character at `chars[index]` and increment `index`.
 *   - If `count > 1`, convert the count to a string and write each digit into `chars[index]`.
 * - Move `left` to the next group and repeat until the array is fully processed.
 * - Return `index`, which represents the new compressed length of the array.
 * 
 * Complexity:
 * - Time Complexity: O(n) → Each character is processed once.
 * - Space Complexity: O(1) → Compression is done in-place using constant extra space.
 */

class Solution {
    public int compress(char[] chars) {
        
        if(chars.length==1){
            return 1;
        }
        
        int left=0;    
        int index=0;
     
      
            while(left<chars.length){
                int right =left;

                while(right<chars.length && chars[right]==chars[left]){
                    right++;
                }

                int count= right-left;

                chars[index] = chars[left];
                index++;

                if(count>1){
                    String countstr = Integer.toString(count);
                    for(int i=0; i<countstr.length(); i++){
                        chars[index] = countstr.charAt(i);
                        index++;
                    }
                }
                left=right;
            }
              return index;
            }
        
        
           

        
        }
    
