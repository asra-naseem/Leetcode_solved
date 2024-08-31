class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxCount = 0;
        int currentCount = 0;
        Integer prev = null;

        for (Integer ele : set) {
            if (prev != null && ele == prev + 1) {
                currentCount++;
            } else {
                currentCount = 1; // Reset the count for a new sequence
            }
            maxCount = Math.max(maxCount, currentCount);
            prev = ele;
        }

        return maxCount;
    }
}