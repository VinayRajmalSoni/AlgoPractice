public class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0])); // sort by start time
        // minHeap the first element is the length of interval and last element is the endtime of the interval
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        Map<Integer, Integer> res = new HashMap<>();
        int i = 0;
        int[] sortedQueries = queries.clone();
        Arrays.sort(sortedQueries);
        for (int q : sortedQueries) {
            // all the intervals whose start time is less than equals query can be added to minHeap
            // logic is we add in minheap with duration as first criteria and end time as second
            // then when we poll, we check endtime, if its greater than equals then we can pick that duration as the answer
            while (i < intervals.length && intervals[i][0] <= q) {
                int l = intervals[i][0];
                int r = intervals[i][1];
                minHeap.offer(new int[]{r - l + 1, r});
                i++;
            }

            // remove all the intervals which end before this query
            while (!minHeap.isEmpty() && minHeap.peek()[1] < q) {
                minHeap.poll();
            }
            res.put(q, minHeap.isEmpty() ? -1 : minHeap.peek()[0]);
        }
        int[] result = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            result[j] = res.get(queries[j]);
        }
        return result;
    }
}
