class Solution {
    public int beautySum(String s) {
        int total = 0;
        
        for(int i=0;i<s.length();i++){
            Map<Character,Integer> mapping = new HashMap<>();
            for(int j=i+1;j<=s.length();j++){
                mapping.put(s.charAt(j-1),mapping.getOrDefault(s.charAt(j-1),0)+1);
                int maxi = Integer.MIN_VALUE;
                int mini = Integer.MAX_VALUE;
                for(Map.Entry<Character,Integer>entry : mapping.entrySet()){
                    maxi = Math.max(maxi,entry.getValue());
                    mini = Math.min(mini,entry.getValue());}
                    total+=(maxi-mini);

            }
        }
        return total;
        
    }
}