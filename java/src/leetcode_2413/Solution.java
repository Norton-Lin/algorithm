package leetcode_2413;

class Solution {
    public int smallestEvenMultiple(int n) {
        //return n%2==0?n:2*n;
        return n<<(n&1);
    }
}
