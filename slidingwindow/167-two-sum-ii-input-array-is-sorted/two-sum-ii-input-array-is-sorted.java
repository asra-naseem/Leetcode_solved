class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int index1=-1,index2=-1,sum;
        int [] x=new int[2];
        int firstptr=0,lastptr=numbers.length-1;
        while(firstptr<=lastptr){
            sum=numbers[firstptr]+numbers[lastptr];
            if(sum>target)
                lastptr--;
            else if(sum<target)
                firstptr++;
            else
            {
                 return new int[]{firstptr+1,lastptr+1};
            }
            
        }
       
        
  return x;
    }
}