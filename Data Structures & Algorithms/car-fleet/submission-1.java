class Solution {
    public class Car {
        public int position;
        public int speed;

        public Car(int position, int speed) {
            this.position = position; // Fix #1: use 'this' to refer to instance fields
            this.speed = speed;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        Car[] cars = new Car[position.length];
        for (int i = 0; i < position.length; i++) {
            cars[i] = new Car(position[i], speed[i]);
        }
        Stack<Double> stack = new Stack<>();
        // sort by position in descending order
        Arrays.sort(cars, (p, q) -> (q.position - p.position));
        
        for (int i = 0; i < cars.length; i++) {
            double time = (double)(target - cars[i].position) / cars[i].speed; // cast to double to avoid integer division
            if (stack.isEmpty() || stack.peek() < time) { // push only if current car is SLOWER (can't catch up) i.e takes more time
                stack.push(time);
            }
        }
        return stack.size();
    }
}
