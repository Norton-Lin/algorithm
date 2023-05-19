package leetcode_1079;

import java.util.Arrays;
import java.util.HashSet;

class Solution {
	//排列组合，DFS+HASH,太暴力哩
	//如何剪枝
	HashSet<String> set = new HashSet<>();
	HashSet<Integer> tag = new HashSet<>();
    public int numTilePossibilities(String tiles) {
    	int[] tag = new int[tiles.length()];
    	Arrays.fill(tag, 0);
    	for(int i = 1;i<=tiles.length();++i)
    	{
    		dfs("", tiles.length(),tiles);
    	}
    	return set.size();
    }
    /**
     * 
     * @param cur 当前字符串
     * @param len 字符串枚举长度
     * @param tag 标记位，标记活字使用情况
     */
    public void dfs(String cur, int len, String tiles)
    {
    	if(cur.length()==len)
    	{
    		set.add(cur);
    		return;
    	}
    	for(int i = 0 ;i<tiles.length();++i)
    	{
    		if(tag.contains(i))
    			continue;
    		else {
    			tag.add(i);
    			dfs(cur+tiles.charAt(i), len+1, tiles);
    			tag.remove(i);
    		}
    	}
    }
    //数位dp
    /**
     * 
    public int numTilePossibilities(String tiles) {
        int[] cnt = new int[26];
        for (char c : tiles.toCharArray()) {
            ++cnt[c - 'A'];
        }
        return dfs(cnt);
    }

    private int dfs(int[] cnt) {
        int res = 0;
        for (int i = 0; i < cnt.length; ++i) {
            if (cnt[i] > 0) {
                ++res;
                --cnt[i];
                res += dfs(cnt);
                ++cnt[i];
            }
        }
        return res;
    }
     */
}
