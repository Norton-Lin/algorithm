package leetcode_1233;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//先排序
//1.暴力逐一比对 -》跳跃逐一比对
//2.字典树
class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < folder.length;) 
        {
            String s = folder[i] + "/";
            result.add(folder[i]);
            int k = i +1;
            while(k < folder.length && folder[k].startsWith(s)) //跳跃
                k++;
            i = k;
        }
        return result;
    }
}

