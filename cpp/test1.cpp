#include<iostream>
#include<vector>
#include<string>
using namespace std;
/**
    给你一个由小写英文字母组成的字符串 s ，请你找出并返回第一个出现 两次 的字母。
注意：
    如果 a 的 第二次 出现比 b 的 第二次 出现在字符串中的位置更靠前，则认为字母 a 在字母 b 之前出现两次。
    s 包含至少一个出现两次的字母。
*/
class Solution {
public:
    char repeatedCharacter(string s) {
        vector<bool> ans(26,false);
        for(int i =0;i<s.size();++i)
        {
            if(ans[s[i] - 'a'])
                return s[i];
            else
                ans[s[i]-'a'] = true;
        }
        return 'a';
    }
};
int main()
{
    return 0;
}