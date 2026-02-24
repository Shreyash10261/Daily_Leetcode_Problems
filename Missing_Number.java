class Missing_Number {
    public int missingNumber(int[] nums) {
        int range=nums.length;
        int as=(range*(range+1))/2;
        int cs=0;
        for(int i=0;i<nums.length;i++)
        {
            cs=cs+nums[i];
        }
        int ans=as-cs;
        return ans;
    }
}
