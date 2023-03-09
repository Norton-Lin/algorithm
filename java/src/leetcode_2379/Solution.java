package leetcode_2379;

class Solution {
    //记录每个位置前k个位置，白色块的数量
    public int minimumRecolors(String blocks, int k) {
        int ans = 0,cur = 0;
        for(int i = 0;i<k;++i)
        {
            if(blocks.charAt(i) == 'W')
            {
                ++ans;
                ++cur;
            }
        }
        for(int i = k;i<blocks.length();++i)
        {
            if(blocks.charAt(i-k) == 'W')
                --cur;
            if(blocks.charAt(i) == 'W')
                ++cur;
            ans = Math.min(ans,cur);
        }
        return ans;
    }
}
