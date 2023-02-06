package leetcode_1604;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//哈希+排序
class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String> ans = new ArrayList<String>();
        Map<String,ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>(); //记录员工名和当前打卡次数
        for(int i =0;i<keyName.length;++i)
        {
        	String name = keyName[i];
        	String time = keyTime[i];
        	map.putIfAbsent(name,new ArrayList<Integer>());
        	int hour = (time.charAt(0)-'0')*10+(time.charAt(1)-'0');
        	int min = (time.charAt(3)-'0')*10+(time.charAt(4)-'0');
        	map.get(name).add(hour*60+min);
        }
        for(String name : map.keySet())
        {
        	List<Integer> list = map.get(name);
            Collections.sort(list);
            int size = list.size();
            for (int i = 2; i < size; i++) {
                int time1 = list.get(i - 2), time2 = list.get(i);
                int difference = time2 - time1;
                if (difference <= 60) {
                    ans.add(name);
                    break;
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
