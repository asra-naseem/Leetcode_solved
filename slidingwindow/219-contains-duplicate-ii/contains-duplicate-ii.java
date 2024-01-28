class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer>hm = new HashMap<>();
        boolean result=false;
        for(int i=0;i<nums.length;i++){
           if(hm.containsKey(nums[i])){
              int index= hm.get(nums[i]);
              if(i-index<=k)
              result=true;

           }
           hm.put(nums[i],i);
        }
        return result;
    }
}