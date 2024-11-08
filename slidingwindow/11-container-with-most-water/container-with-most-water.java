class Solution {
    public int maxArea(int[] height) {
        int left =0;
        int right = height.length-1;
        int result = 0;
        while(left<right){
           int  length = Math.min(height[left],height[right]);
        int breadth = right-left;
        int area = length*breadth;
        if(area>result)
        result = area;
        if(height[left]>height[right])
        right--;
        else
        left++;


        }
        return result;
        
    }
}