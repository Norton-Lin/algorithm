package day.leetcode_1096;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

class Solution {
    private TreeSet<String> s = new TreeSet<>();//无序不可重复，但是可以按照元素的大小顺序自动排序

    public List<String> braceExpansionII(String expression) {
        dfs(expression);
        return new ArrayList<>(s);
    }

    private void dfs(String exp) {
        int j = exp.indexOf('}');//寻找第一个}
        if (j == -1) {//不存在}
            s.add(exp);
            return;
        }
        int i = j;
        while (exp.charAt(i) != '{') {
            --i;
        }//找到第一个配对的{
        String a = exp.substring(0, i);
        String c = exp.substring(j + 1);
        for (String b : exp.substring(i + 1, j).split(",")) //a和c，与b内各元素组合
            dfs(a + b + c);
    }
}