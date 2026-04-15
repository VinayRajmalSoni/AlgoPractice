class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int val : nums) {
            minHeap.add(val);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();        
    }

    public int findKthLargestQuickSelect(int[] nums, int k) {        
        // since we are looking for the kth largest the position we are looking for n - k
        // if we were looking for the kth smallest that would be at position k -1
        k = nums.length - k;
        //shuffle(nums);
        return quickSelect(nums, k, 0, nums.length - 1);
    }
    
    public int quickSelect(int[] nums, int k, int start, int end){
        // Use quickselect here
        int pivotIndex = partition(nums, start, end);
        if(pivotIndex == k)
            return nums[pivotIndex];
        
        if(pivotIndex > k){
            // search left
            return quickSelect(nums, k, start, pivotIndex - 1);
        }
        else{
            // search right
            return quickSelect(nums, k, pivotIndex + 1, end);
        }
    }
   
    public int partition(int[] nums, int start, int end){
        int pivotIndex = start + (end-start)/2;// any random index is fine here
        int pivotElement = nums[pivotIndex];
        swap(nums, start, pivotIndex);
        int smaller = start; // exact postion where this element needs to be will be determined using smaller
        int index = start + 1;
        while(index <= end ){
            if(nums[index] < pivotElement){
                smaller++;
                swap(nums, smaller, index);
            }
            index++;
        }
        swap(nums, start, smaller);// move the pivotElement to position where all the numbers smaller than it 
        return smaller;        
    }
                           
    public void swap(int[] nums, int p1, int p2){
        if(p1 == p2)// this is important if we are using xor to swap numbers, else they will become zero
            return;
        nums[p1] = nums[p1] ^ nums[p2];
        nums[p2] = nums[p1] ^ nums[p2];
        nums[p1] = nums[p1] ^ nums[p2];
    }   
    
    // this can be used to shuffle the array to avoid worst case complexity
    private void shuffle(int arr[]) {
        // this is called Floyd-Gates shuffling which gives all permutations of a shuffle to have equal probability
        // resulting in shuffling where every element is equally likely to be shuffled
        final Random random = new Random();
        for(int ind = 1; ind < arr.length; ind++) {
            final int r = random.nextInt(ind + 1);
            swap(arr, ind, r);
        }
    } 
}
