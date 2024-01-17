package day.leetcode_1163;

class Solution {
    //找到排在最后的子串
	//暴力全排列 no
	//长串字典序必然比短串大 前缀相同时
	//双指针，一个指当前前缀，一个指下一个匹配前缀
    //i+len串指向第一个和index1串不同的字符
	//此时考虑index1转移和i匹配的跳跃
	//O（n)
    public String lastSubstring(String s) {
        int index1 = 0;
        int len = 0;
        for(int i = 1;i<s.length();++i)
        {
        	len = 0;
        	//index1+len<s.length() i一定比index1大
        	while(i+len<s.length()&&s.charAt(index1+len)==s.charAt(i+len))
        		++len;
        	//index1转移
        	if(i+len<s.length()&&s.charAt(index1+len)<s.charAt(i+len))
        		index1 = i;
        	//跳跃
        	//当前比较子串内存在更大串 eg cacacb 控制跳跃距离
            i += len-2>0?len-2:0;//就是不跳跃/跳到倒数第二个开始匹配，因为倒一不同，大小关系可能发生变化
        }
        return s.substring(index1);
    }
}
//优化
/**
class Solution {
public String lastSubstring(String s) {
    int n = s.length();
    int i = 0;
    for (int j = 1, k = 0; j + k < n;) {
        int d = s.charAt(i + k) - s.charAt(j + k);
        if (d == 0) {
            ++k;
        } else if (d < 0) {
            i += k + 1;
            k = 0;
            if (i >= j) {
                j = i + 1;
            }
        } else {
            j += k + 1;
            k = 0;
        }
    }
    return s.substring(i);
}
}
*/