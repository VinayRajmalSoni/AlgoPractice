class Solution {
    /*
    A very efficient trick comes from this key observation:

    Subtracting 1 from a number flips the rightmost 1 bit to 0 and turns all bits to its right into 1
    Performing n & (n - 1) removes the rightmost 1 bit from n
    So every time we do:
    n = n & (n - 1) we eliminate exactly one 1 bit.

    eg 111
    111 & 110 = 110
    110 & 101 = 100
    100 & 011 = 0
    count becomes 3
    */
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n &= n - 1;
            res++;
        }
        return res;        
    }

    public int hammingWeightNonOptimal(int n) {
        int res = 0;
        while (n != 0) {
            res += (n & 1) == 1 ? 1 : 0;
            n >>= 1;
        }
        return res;
    }
}
