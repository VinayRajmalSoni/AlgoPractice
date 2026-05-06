class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            // put length then / then string
            sb.append(s.length()).append('/').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> result = new ArrayList<String>();        
        int i = 0;
        while(i < s.length()) {
            // get the index of slash starting from index i so first slash after i location
            int slash = s.indexOf('/', i);
            // get the substring from i to slash this will be the length
            int size = Integer.parseInt(s.substring(i, slash));
            // add slash +1 to slash + size +1 to the result array
            result.add(s.substring(slash + 1, slash + 1 + size));
            i = slash + size + 1;
        }
        return result;
    }
}
