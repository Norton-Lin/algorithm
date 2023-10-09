package leetcode_2251;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
class Solution {
    public static void main(String[] args) {
        int[][] flowers = new int[][]{{1,6},{3,7},{9,12},{4,13}};
        int[] people = new int[]{2,3,7,11};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.fullBloomFlowers(flowers, people)));
    }
    // flowers 从0开始的二维数组
    // flowers[i] = [start, end] 表示第i朵花在第start天开放，在第end天枯萎
    // people 从0开始的一维数组, people[i]天表第i人在people[i]到达
    // 返回一个一维数组，表示第i个人在第几天可以看到第i朵花
    // 状态压缩 第i - j 天内有k朵花开放
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] answer = new int[people.length];
        //如果 第i个人来的时候没有花开花落怎么办？
        //所以 每一天都需要记录内存会不会爆？
        //记录花落花开然后lowerbound
        int start = 0;
        int end = 0;
        HashMap<Integer, Integer> bloom = new HashMap<>();//第k天累积开放的花
        HashSet<Integer> record = new HashSet<>();//第k天开放的花
        for(int i = 0;i<flowers.length;++i){
            start = Math.min(flowers[i][0], start);
            end = Math.max(flowers[i][1], end);
            record.add(flowers[i][0]);
            bloom.put(flowers[i][0], bloom.getOrDefault(flowers[i][0], 0) + 1);
            bloom.put(flowers[i][1], bloom.getOrDefault(flowers[i][1], 0) - 1);
        }
        int[] days = new int[record.size()];
        int count = 0;
        for(int day : record){
            days[count++] = day;
        }
        Arrays.sort(days);
        for(int i = 0; i < people.length; ++i){
            int day = people[i];
            day = days[lowerBound(days, 0, days.length-1, day)];
            if(bloom.containsKey(day))
                answer[i] = bloom.get(day);
            else{
                answer[i] = 0;
            }
        }
        return answer;
    }
    public int lowerBound(int[] nums,int l ,int r,int target) {
		while(l<r) {
			int m = (l+r)/2;
			if(nums[m] >= target)
				r = m-1;
			else {
				l = m+1;
			}
		}
		return l;
	}

}
