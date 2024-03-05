class Solution {
    public int missingNumber(int[] nums) {
        int size = nums.length;
        int total = (size*(size+1))/2;
        for(int i=0;i<nums.length;i++){
            total=total-nums[i];
        }
        return total;
    }
}