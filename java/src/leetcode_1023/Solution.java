package leetcode_1023;

import java.util.ArrayList;
import java.util.List;

class Solution {
    //字典树，所有pattern构建字典树？
    //只能插入小写字母
    //暴力 双指针
	//我觉得这得算easy
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<Boolean>();
        for(int i = 0;i<queries.length;++i)
        {
        	int count = 0;
            int j = 0;
        	for(j = 0 ;j<queries[i].length();++j)
        	{
                char cur = pattern.charAt(count);
                char c = queries[i].charAt(j);
                if(c<='Z'&&c>='A'&&c!=cur)
                    break;
        		if(c== cur)
        			++count;
        		if(count == pattern.length())
        			break;
                
        	}
        	if(count == pattern.length())
            {
                for(j+=1;j<queries[i].length();++j)
                {
                    char c = queries[i].charAt(j);
                    if(c<='Z'&&c>='A')
                        break;
                }
                if(j == queries[i].length())
                    ans.add(true);
                else
                    ans.add(false);
            }
        	else 
				ans.add(false);
			
        }
        return ans;
    }
    
}