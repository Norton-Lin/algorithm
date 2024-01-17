package day.leetcode_1255;

class Solution {
    //贪心？先计算每个单词的最大得分 不可行
    //dp dp[i][0:1]对第i个单词，是否进行选择 ->回溯
    private int ans = 0; 
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] table = new int[26];//记录各字母数量
        int[] values = new int[words.length];//记录各字符价值
        for(int i = 0;i<letters.length;++i)
            ++table[(int)(letters[i]-'a')];
        for(int i = 0;i<words.length;++i)
            for(char c:words[i].toCharArray())
                values[i]+=score[(int)(c-'a')];
        backtrack(words, table, values, 0, 0);
        return ans;
    }
    public void backtrack(String[] words,int[] table,int[] values,int start, int cur)
    {
        if(start == words.length)
        {
            ans = Math.max(ans, cur);
            return ;
        }
        int[] temp = new int[26];
        int index = 0;
        boolean judge = true;
        for(int i = 0;i<words[start].length();++i)
        {
            index = (int)(words[start].charAt(i)-'a');
            temp[index]++;
            if(temp[index]>table[index])
            {
                judge = false;
                break;
            }
        }
        if(judge)//单词可选
        {
            for(int i = 0;i<26;++i)
                table[i] -= temp[i];
            backtrack(words, table, values, start+1, cur+values[start]);
            for(int i = 0;i<26;++i)
                table[i] += temp[i];
        }
        backtrack(words, table, values, start+1, cur);
    }
}