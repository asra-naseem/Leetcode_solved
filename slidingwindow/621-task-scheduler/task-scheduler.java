class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[]freq= new int[26];
        for(int i=0;i<tasks.length;i++){
            freq[tasks[i]-'A']++;
        }
        Arrays.sort(freq);
        
        int chunck = freq[25]-1;
        int idle = chunck*n;
        for(int i=24;i>=0;i--){
            idle -= Math.min(chunck,freq[i]);
        }
        return idle>0?idle+tasks.length:tasks.length;
        
    }
}