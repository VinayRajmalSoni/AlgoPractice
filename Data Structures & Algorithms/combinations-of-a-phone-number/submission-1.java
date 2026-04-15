class Solution {
    /*
    Complexity: O(4ⁿ × n)
    Where n = digits.length()

    Breaking it down:

    4ⁿ — the number of combinations generated

    At each recursive level, you iterate over letters of a digit (3 or 4 choices)
    For n digits, in the worst case (digits like 7, 9 with 4 letters), you branch 4 times per level
    This creates a recursion tree with up to 4ⁿ leaf nodes
    × n — cost of slate.toString() at each leaf

    When index == digits.length(), you call slate.toString() which copies n characters
    This happens once per leaf node → 4ⁿ times
    Visualization (e.g., digits = "23")
            root
            / | \
        a  b  c        ← choices for '2'
        /|\ /|\ /|\
        d e f d e f d e f  ← choices for '3'
    → 3 × 3 = 9 combinations
    */    
    public List<String> letterCombinations(String digits) {        
        List<String> result = new ArrayList<>();
        if(digits.length() == 0){
            return result;
        }
        HashMap<Character, String> map = constructMap();        
        letterCombinationsHelper(digits, 0, new StringBuilder(), map, result);
        return result;
    }
    
    public void letterCombinationsHelper(String digits, int index, StringBuilder slate,  HashMap<Character, String> map, List<String> result){
        if(index == digits.length()){
            result.add(slate.toString());
            return;
        }    
        else {
            String numberVals = map.get(digits.charAt(index));
            for(char val: numberVals.toCharArray()){
                slate.append(val);
                letterCombinationsHelper(digits, index + 1, slate, map, result);
                slate.deleteCharAt(slate.length() - 1);
            }
        }        
    }
    
    public HashMap<Character, String> constructMap(){
        // String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        /*HashMap<Character, String> mapDial = new HashMap<>();
        mapDial.put('2', "abc");
        mapDial.put('3', "def");
        mapDial.put('4', "ghi");
        mapDial.put('5', "jkl");
        mapDial.put('6', "mno");
        mapDial.put('7', "pqrs");
        mapDial.put('8', "tuv");
        mapDial.put('9', "wxyz");
        mapDial.put('1', "1");
        mapDial.put('0', "0");
        return mapDial;*/
        Map<Character, String> map = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
        );
        return new HashMap<>(map);
    }
}
