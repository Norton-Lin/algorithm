package day.leetcode_1702;
/*
 * @lc app=leetcode.cn id=1702 lang=java
 *
 * [1702] 修改后的最大二进制字符串
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    //00转10,10转01，让高位充满1
    //答案中最多一个零
    //问题来了，这个零放哪里
    //两个0中间夹n个1
    //变成10+n个1、
    //优化，有几个0就从头开始的1串结束位置后移
    /**
    public String maximumBinaryString(String binary) {
        char[] s = binary.toCharArray();
        int len = s.length;
        for(int i = 0,j = 0;i<len;++i){
            if(s[i] == '1')
                continue;
            else{//找下一个0
                j = j>i?j:i+1;//j位置定位，保证持续向后不回退
                for(;j<len&&s[j] == '1';++j);
                if(j<len){
                    s[i] = '1';
                    s[i+1] = '0';
                    if(i!=j-1)
                        s[j] = '1';
                }
            }
        }
        return new String(s);
    }*/
    public String maximumBinaryString(String binary) {
        char[] s = binary.toCharArray();
        int len = s.length;
        int i = 0;
        int count = 0;

        for(i=0;i<len&&s[i]=='1';++i);
        int index = i;
        for(;i<len;++i){
            if(s[i] == '0')
                ++count;
        }
        if(count > 1){
            Arrays.fill(s,'1');
            s[index + count-1] = '0';
        }
        return new String(s);
    }
}
// @lc code=end

