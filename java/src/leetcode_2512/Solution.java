package leetcode_2512;
/*
 * @lc app=leetcode.cn id=2512 lang=java
 *
 * [2512] 奖励最顶尖的 K 名学生
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

// @lc code=start
class Solution {
    // 暴力匹配
    // 用hash存储关键字，遍历评价列表，获取学生评价，后进行排序获取前k个值
    // 时间复杂度O(nlogn) 空间复杂度O(n)
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        HashSet<String> pos_set = new HashSet<>();
        HashSet<String> neg_set = new HashSet<>();
        PriorityQueue<Integer[]> queue = new PriorityQueue<>(new Comparator<Integer[]>() {
            public int compare(Integer[] a,Integer[] b)
            {
                if(a[1]==b[1])
                    return a[0]-b[0];
                return b[1]-a[1];
            }
        });
        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i<positive_feedback.length;++i)
            pos_set.add(positive_feedback[i]);
        for(int i = 0;i<negative_feedback.length;++i)
            neg_set.add(negative_feedback[i]);
        for(int i = 0;i<report.length;++i)
        {
            String cur[] = report[i].split(" ");
            int num = 0;
            for(int j = 0;j<cur.length;++j)
            {
                if(pos_set.contains(cur[j]))
                    num+=3;
                else if(neg_set.contains(cur[j]))
                    num-=1;
            }
            queue.offer(new Integer[]{student_id[i],num});
        }
        for(int i = 0;i<k;++i)
            ans.add(queue.poll()[0]);
        return ans;
    }
}
// @lc code=end

