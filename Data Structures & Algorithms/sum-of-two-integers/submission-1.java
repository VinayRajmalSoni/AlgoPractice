class Solution {
    /*
    eg 101 + 011
    Step 1
    carry = 001 << 1 = 010
    a = 110
    b = 010

    Step 2
    carry = 010 << 1 = 100
    a = 100
    b = 100
    
    Step 3
    carry = 1000
    a = 0
    b = 1000

    Step 4
    carry = 0
    a = 1000
    b = 0 (end of loop)
    */
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a ^= b;
            b = carry;
        }
        return a;        
    }
}
