import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        // Map to store the most recent index of each character
        HashMap<Character, Integer> map = new HashMap<>();
        
        int left = 0; // Left boundary of the sliding window
        
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // If the character was seen inside the current window, move the left pointer
            if (map.containsKey(currentChar)) {
                left = Math.max(left, map.get(currentChar) + 1);
            }
            
            // Update or add the character's latest index
            map.put(currentChar, right);
            
            // Calculate maximum length seen so far
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}