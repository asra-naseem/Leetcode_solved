class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> hs = new HashSet<>();

        int L = 0;
        for (int R = 0; R < nums.length; R++) {
            if (R - L > k) {
                hs.remove(nums[L]);
                L++;
            }
            if (hs.contains(nums[R])) {
                return true;
            }
            hs.add(nums[R]);
        }
        return false;
    }
}
