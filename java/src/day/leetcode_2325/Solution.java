package day.leetcode_2325;


class Solution {
	public String decodeMessage(String key, String message) {
        StringBuilder s = new StringBuilder();
        char[] table = new char[26];
        int count = 0;
        for(char cur:key.toCharArray())
        {
            if(cur == ' ')
                continue;
        	if(table[cur-'a']==0)
        		table[cur-'a'] = (char)('a'+count++);
        	if(count == 26)
        		break;
        }
        for(char cur:message.toCharArray())
        {
            if(cur == ' ')
                s.append(cur);
            else
        	    s.append(table[cur-'a']);
        }
        return s.toString();
    }
}