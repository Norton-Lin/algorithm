package leetcode_1247;

class Solution {
    //两种情况
    //1.当x，y的各自总数不为偶数，无解 -- >差异位是奇数
    //2.当x,y的各自总数为偶数，记录差异位，针对差异位两种情况
    //2.1两侧x,y平衡
    //差异位为2,4时，交换次数是2，此为最小单位
    //其余的数 num ，交换次数为 num/2 或 num/2+1
    //2.2两侧x,y不平衡
    //差异位为2时，交换次数是1，此为最小单位
    //其余的数 num ，交换次数为 num/2 或 num/2+1
    public int minimumSwap(String s1, String s2) {
        int num = 0;
        int countx = 0;
        int county = 0;
        int ans = 0;
        for(int i =0;i<s1.length();++i)
        {
            if(s1.charAt(i)!=s2.charAt(i))
            {
                ++num;
                if(s1.charAt(i) == 'x')
                    ++countx;
                else
                    ++county;
            }
        }
        if(num%2 == 1)//差异位为奇，无解
            ans = -1;
        else if(countx == county)
            ans = (num / 2)%2 == 0?num/2:num/2+1;
        else
        {
            if(countx<county)
            {
                int temp = countx;
                countx = county;
                county = temp;
            }
            ans = (countx-county)/2;
            ans += county%2 == 0?county:county+1;
        }
        return ans;
    }
}