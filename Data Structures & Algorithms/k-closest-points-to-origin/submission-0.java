class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            // distance from origin is sqrt((x1 - 0)^2 + (y1 - 0)^2)
            // making the distance sqrt((x1)^2 + (y1)^2)
            // we dont need to take square root for comparison purposes
            (p,q)->( (q[0]*q[0] + q[1]*q[1]) - (p[0]*p[0] + p[1]*p[1]) )
        );
        
        for(int i = 0; i < points.length; i++){
            maxHeap.add(points[i]);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        
        int[][] result = new int[k][2];
        int i = 0;
        while(!maxHeap.isEmpty()){
            result[i] = maxHeap.poll();
            i++;
        }        
        return result;  
    }
}
