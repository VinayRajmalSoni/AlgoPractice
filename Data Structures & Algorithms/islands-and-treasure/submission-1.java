class Solution {
    public void islandsAndTreasure(int[][] rooms) {
        // do a BFS at each gate to find the distance of each empth room from it
        // BFS gives the smallest distance if nothing is weighed
        if(rooms.length == 0)
            return;
        int ROOM = Integer.MAX_VALUE;
        int GATE = 0;
        int WALL = -1;
        
        int m = rooms.length;
        int n = rooms[0].length;
        int[][] dirs = {{-1,0}, {0,1}, {0,-1}, {1,0}}; // top, right, left, bottom
        Queue<int[]> queue = new LinkedList<>();
        // add all gates to the queue
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (rooms[i][j] == GATE) {// add to queue if gate
                    queue.add(new int[] {i,j});
                }
            }
        }
        // update distance from gates using BFS
        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();
            for (int[] dir: dirs) {
                int X = curPos[0] + dir[0];
                int Y = curPos[1] + dir[1];
                if (X<0 || Y <0 || X >= m || Y >= n || rooms[X][Y] != ROOM) continue;
                rooms[X][Y] = rooms[curPos[0]][curPos[1]]+1;
                queue.add(new int[] {X, Y});
            }
        } 
    }
}
