class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;        
        int maxFreq = 0;
        int maxLength = 0;
        for(int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(s.charAt(right)));
            while((right - left + 1) - maxFreq > k) {
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;        
    }
}
