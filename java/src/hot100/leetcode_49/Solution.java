package hot100.leetcode_49;
/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// @lc code=start
class Solution {
    //哈希记录
    public List<List<String>> groupAnagrams(String[] strs) {
        //List<List<String>> ans = new ArrayList<List<String>>() {};
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str: strs){
            char[] arr = str.toCharArray();//String转char[]
            Arrays.sort(arr);
            String key = new String(arr);//char[]转回String，不要用数组作为key
            //简洁方式跳过判断
            List<String> list= map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key,list);
            /**
            if(map.containsKey(key)){
                List<String> list = map.get(key);
                list.add(str);
                map.put(key,list);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key,list);
            } */
        }
        //for(String key: map.keySet())
        //    ans.add(map.get(key));
        //return ans;
        return new ArrayList<List<String>>(map.values());//直接生成List<List<String>>
    }
}
// @lc code=end

