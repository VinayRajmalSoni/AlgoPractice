class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: s1.toCharArray()) {
            if(!map.containsKey(ch)) {
                count++;
            }
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int runningCount = count;

        for(int right = 0 ; right < s2.length(); right++) {
            char ch = s2.charAt(right);
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) == 0) {
                    runningCount--;
                }
            }
            while(runningCount == 0) {
                if (right - left + 1 == s1.length()) return true;
                char lch = s2.charAt(left);
                if(map.containsKey(lch)) {
                    map.put(lch, map.get(lch) + 1);
                    if(map.get(lch) > 0) {
                        runningCount++;
                    }
                }
                left++;
            }     
        }       
        return false;      
    }
}

