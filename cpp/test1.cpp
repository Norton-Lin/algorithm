#include<iostream>
#include<vector>
#include<string>
using namespace std;
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