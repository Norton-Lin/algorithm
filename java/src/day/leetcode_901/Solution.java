package day.leetcode_901;

import java.util.ArrayDeque;
import java.util.Deque;

class StockSpanner {
    /** 
    ArrayList<Integer> arr = null;
    public StockSpanner() {
         arr = new ArrayList<>();
        arr.add(0);
    }
    
    public int next(int price) {
        int res = 1;
        for(int i = 0;i<arr.size()-1;++i)
        {
            if(price<arr.get(i))
                break;
            ++res;
        }
        arr.add(0,price);
        return res;
    }*/
    //单调栈
    Deque<int[]> stack;
    int idx;

    public StockSpanner() {
        stack = new ArrayDeque<int[]>();
        stack.push(new int[]{-1, Integer.MAX_VALUE});
        idx = -1;
    }

    public int next(int price) {
        idx++;
        while (price >= stack.peek()[1]) {
            stack.pop();
        }
        int ret = idx - stack.peek()[0];
        stack.push(new int[]{idx, price});
        return ret;
    }
}