package leetcode_1138;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    //最快速度找到字母，并输出
    //计算不同字符间的间距
    //有z时需要特殊处理
    //太粗暴了，考完改改
    public String alphabetBoardPath(String target) {
        HashMap<Character, ArrayList<Integer>> map = new HashMap<Character, ArrayList<Integer>>();
        StringBuilder ans = new StringBuilder();
        for(int i =0;i<26;++i)
        {
        	ArrayList<Integer> list = new ArrayList<>();
        	list.add(i%5);
        	list.add(i/5);
        	map.put((char)('a'+i), list);
        }
        int x = 0,y =0 ,x_next = 0,y_next = 0,x_len = 0,y_len = 0;
        for(char c: target.toCharArray())
        {
        	x_next = map.get(c).get(0);
        	y_next = map.get(c).get(1);
        	x_len = x_next - x;
        	y_len = y_next - y;
            if((y == 5 || y_next ==5 )&&(y_len!=0))
            {
                if(y ==5)//从z出去
                {
                    ans.append('U');
        		    ++y_len;
                }
                else
                {
                    while(x_len<0)
        	        {
        		        ans.append('L');
        		        ++x_len;
        	        }
                }
            }
            while(y_len>0) 
        	{
        		ans.append('D');
        		--y_len;
        	}
        	while(y_len<0) 
        	{
        		ans.append('U');
        		++y_len;
        	}
        	while(x_len>0)
        	{
        		ans.append('R');
        		--x_len;
        	}
        	while(x_len<0)
        	{
        		ans.append('L');
        		++x_len;
        	}
        	x = x_next;
        	y = y_next;
            ans.append('!');
        }
        return ans.toString();
    }
}