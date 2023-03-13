package leetcode_2383;

class Solution {
    //击败对手需要经验精力都严格大于
    //击败一个对手，经验+，精力-
    //一次遍历
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
    	int ans = 0;
    	for(int i = 0;i<energy.length;++i)
    	{
    		if(!(initialEnergy>energy[i]&&initialExperience>experience[i]))//要训练
    		{
    			if(initialEnergy<=energy[i])
    			{
    				ans+=(energy[i]-initialEnergy)+1;
    				initialEnergy+=(energy[i]-initialEnergy)+1;
    			}
    			if(initialExperience<=experience[i])
    			{
    				ans+=(experience[i]-initialExperience)+1;
    				initialExperience+=(experience[i]-initialExperience)+1;
    			}
			}
    		initialEnergy-=energy[i];
			initialExperience+=experience[i];
    	}
    	return ans;
    }
}
