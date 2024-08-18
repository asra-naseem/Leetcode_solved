class Solution {
    public int maxScore(int[] c, int k) {
    int sum = 0;
    int maxSum = 0;

    // Calculate the initial sum of the first k elements
    for (int i = 0; i < k; i++) {
        sum += c[i];
    }

    maxSum = sum;  // Initialize maxSum with the initial sum

    int lindex = k - 1;
    int rindex = c.length - 1;

    // Slide the window from the left end to the right end
    while (lindex >= 0) {
        sum = sum - c[lindex] + c[rindex];
        maxSum = Math.max(sum, maxSum);
        lindex--;
        rindex--;
    }

    return maxSum;
}

}