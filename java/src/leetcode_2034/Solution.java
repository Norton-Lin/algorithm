package leetcode_2034;

import java.util.HashMap;
import java.util.PriorityQueue;

class StockPrice {
    int cur;// 最新时间对应的price
    int time;// 最新时间对应的timestamp
    PriorityQueue<int[]> maxi;
    PriorityQueue<int[]> mini;
    HashMap<Integer, Integer> hash;
    public StockPrice() {
        cur = 0;
        time = 0;
        mini = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        maxi = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        hash = new HashMap<>();
    }

    // 更新时间戳对应的price
    public void update(int timestamp, int price) {
        if (timestamp >= time)// 更新最新price
        {
            time = timestamp;
            cur = price;
        }   
        maxi.add(new int[] { timestamp, price });
        mini.add(new int[] { timestamp, price });
        hash.put(timestamp, price);
    }

    // 获取时间戳最大的price
    // cur一旦出现只会逐步更新，不会消失，因此只需考虑最大最小price
    // 最大最小值用优先队列维护？那么更新的时候额，我如何找这个timestamp?
    // 若用hash,如何维护最大最小？总不能遍历一下hash
    // hash记录优先队列维护？
    public int current() {
        return cur;
    }

    // 获取当前最大的price
    public int maximum() {
        int price,timestamp;
        while(true){
            price = maxi.peek()[1];
            timestamp = maxi.peek()[0];
            if(hash.get(timestamp) == price)
                break;
            maxi.poll();
        }
        return maxi.peek()[1];
    }

    // 获取当前最小的price
    public int minimum() {
        int price,timestamp;
        while(true){
            price = mini.peek()[1];
            timestamp = mini.peek()[0];
            if(hash.get(timestamp) == price)
                break;
            mini.poll();
        }
        return mini.peek()[1];
    }
}

public class Solution {
    public static void main(String args[]) {
        StockPrice sp = new StockPrice();
        sp.update(1, 10);
        sp.update(2, 5);
        System.out.println(sp.current());
        System.out.println(sp.maximum());
    }
}
