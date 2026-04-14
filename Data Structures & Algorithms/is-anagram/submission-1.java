class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] set = new int[26];
        
        for(char ch : s.toCharArray()) {
            set[ch - 'a']++;
        }
        for(char ch : t.toCharArray()) {
            set[ch - 'a']--;
        }

        for(char ch : s.toCharArray()) {
            if(set[ch - 'a'] != 0){
                return false;
            }
        }
        return true;
    }
}
