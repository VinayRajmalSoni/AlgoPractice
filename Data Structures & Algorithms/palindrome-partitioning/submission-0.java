class Solution {
    public List<List<String>> partition(String s) {
       List<List<String>> list = new ArrayList<>();
       backtrack(list, new ArrayList<>(), s, 0);
       return list;
    }

    public void backtrack(List<List<String>> list, List<String> tempList, String s, int start){
       if(start == s.length())
          list.add(new ArrayList<>(tempList));
       else{
          for(int i = start; i < s.length(); i++){
             if(isPalindrome(s, start, i)){
                tempList.add(s.substring(start, i + 1));
                backtrack(list, tempList, s, i + 1);
                tempList.remove(tempList.size() - 1);
             }
          }
       }
    }

    public boolean isPalindrome(String s, int low, int high){
       while(low < high)
          if(s.charAt(low++) != s.charAt(high--)) return false;
       return true;
    } 
    /*
    Time Complexity: O(n · 2^n)
Here's why, broken into two parts:

1. Number of Possible Partitions → 2^(n-1)
For a string of length n, there are n-1 positions between characters where you can cut or not cut.

For example, "aab" has 2 gaps → 2² = 4 possible ways:

a | a | b
a | ab
aa | b
aab
This gives 2^(n-1) possible partitions ≈ O(2^n)

2. Work Per Partition → O(n)
For each partition explored, the code does:

isPalindrome() check → O(n) in worst case
Copying the valid result into the list → O(n)
Putting It Together
Total = (number of partitions) × (work per partition)
      = O(2^n)              ×  O(n)
      = O(n · 2^n)
Space Complexity: O(n)
Recursion depth goes at most n levels deep (one character per cut)
tempList holds at most n elements
    */
}
