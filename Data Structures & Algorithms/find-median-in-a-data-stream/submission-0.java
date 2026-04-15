class MedianFinder {

    //max heap of smallest elements
    PriorityQueue<Integer> maxHeap;
    // min heap of largest elements
    PriorityQueue<Integer> minHeap;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((p, q) -> (q-p) );
        // comparator in priority queue is min heap by default
        minHeap = new PriorityQueue<>();        
    }
    
    public void addNum(int num) {
        // trying to keep maxHeap one size greater than minHeap
        if(maxHeap.size() <= minHeap.size()) {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        } else {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if(minHeap.size() == maxHeap.size()){
            return (double)(minHeap.peek() + maxHeap.peek())/2;
        }
        else{
            return maxHeap.peek();
        }
    }
}
