class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        // increment the count for each task and store in a hash map
        for(char c: tasks){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));        
        
        maxHeap.addAll(map.values());
        int cycles = 0;
        while(!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            // allocate tasks in the cycle
            // n + 1 because we want to wait n cycles after adding current task
            for(int i = 0; i < n+1 ; i++){
                // if anything on heap then remove it and add it as part of cycle once in (n + 1) set of cycles                
                if(!maxHeap.isEmpty()){
                    temp.add(maxHeap.poll());
                }
                // else its an idle cycle
            }
            
            for(int t : temp) {
                t--;
                if(t > 0) {
                    maxHeap.add(t);
                }
            }
            cycles += maxHeap.isEmpty() ? temp.size() : n + 1;            
        }
        return cycles;        
    }
}
