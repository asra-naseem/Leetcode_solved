class Solution {
    public int helper(int[] nums, int t) {
        int l = 0, r = 0;
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        while (r < nums.length) {
            hm.put(nums[r], hm.getOrDefault(nums[r], 0) + 1);
            
            while (hm.size() > t) {
                int sum = hm.get(nums[l]);
                hm.put(nums[l], sum - 1);
                
                if (hm.get(nums[l]) == 0) {
                    hm.remove(nums[l]);
                }
                
                l++;
            }
            
            count += r - l + 1;
            r++;
        }
        
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);
        
    }
}