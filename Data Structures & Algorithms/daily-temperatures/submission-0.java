class Solution {
    public int[] dailyTemperatures(int[] temps) {
        int[] res = new int[temps.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < temps.length ; i++) {
            int t = temps[i];
            while(!stack.isEmpty() && temps[stack.peek()] < t) {
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}
