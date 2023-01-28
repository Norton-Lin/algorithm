package leetcode_2315;

class Solution {
    public int countAsterisks(String s) {
        int count = 0;
        boolean sign = true;
        for(char c:s.toCharArray())
        {
            if(sign)
            {
                if(c == '*')
                    ++count;
                else if(c == '|')
                    sign = false;
            }
            else
            {
                if(c == '|')
                    sign = true;
            }
        }
        return count;
    }
}