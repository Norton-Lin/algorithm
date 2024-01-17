package day.leetcode_1792;

import java.util.PriorityQueue;

class Solution {
	//class[i] = {pass[i], total[i]}
    //classes[i] 第i个学校有total[i]个学生，pass[i]个学生可以通过考试
    //extraStudents学生一定可以通过考试
    //要让所有班级平均通过率最高
	//[[2,4],[3,9],[4,5],[2,10]]
	//每次针对递增价值最大的班级操作
    public double maxAverageRatio(int[][] classes, int extraStudents) {
    	PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
    		long val1 = (long) (b[1] + 1) * b[1] * (a[1] - a[0]);
            long val2 = (long) (a[1] + 1) * a[1] * (b[1] - b[0]);
            if (val1 == val2) {
                return 0;
            }
            return val1 < val2 ? 1 : -1;
    	});
    	double ans = 0;
    	for(int[] e:classes)
    		pq.offer(e);
    	while(extraStudents>0)
    	{
    		int[] e = pq.poll();
    		//pq.add()
    		pq.offer(new int[] {e[0]+1,e[1]+1});
            --extraStudents;
    	}
    	for(int[] e: pq)
    		ans+=(double)e[0]/(double)e[1];
    	ans/=classes.length;
    	return ans;
    }
}
