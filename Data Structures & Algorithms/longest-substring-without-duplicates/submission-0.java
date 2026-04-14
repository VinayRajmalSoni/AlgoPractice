class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int l = 0, res = 0;

        for (int r = 0; r < s.length(); r++) {
            mp.put(s.charAt(r), mp.getOrDefault(s.charAt(r), 0) + 1);
            while (mp.containsKey(s.charAt(r)) && mp.get(s.charAt(r)) > 1) {
                mp.put(s.charAt(l), mp.get(s.charAt(l)) - 1);
                l++;
            }            
            res = Math.max(res, r - l + 1);
        }
        return res;
        
    }
}
