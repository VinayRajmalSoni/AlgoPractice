class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisHelper(n, n, new StringBuilder(), 0, 0, result);
        return result;
    }
    
    public void generateParenthesisHelper(int openMax, int closeMax, StringBuilder slate, int openCount, int closeCount,
                                          List<String> result){
        if(closeCount > openCount){
            return;
        }
        if(openCount > openMax){
            return;
        }
        else if(closeCount == closeMax){
            result.add(slate.toString());
            return;
        }
        else{
            // add an opening parenthesis
            slate.append('(');
            openCount++;
            generateParenthesisHelper(openMax, closeMax, slate, openCount, closeCount, result);
            openCount--;
            slate.deleteCharAt(slate.length() - 1);
            
            // add a closing parenthesis
            slate.append(')');
            closeCount++;
            generateParenthesisHelper(openMax, closeMax, slate, openCount, closeCount, result);
            closeCount--;
            slate.deleteCharAt(slate.length() - 1);
        }
        
    }
}
