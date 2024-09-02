class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long totalChalkNeeded = 0l;
        for(int chalkitem:chalk)
        totalChalkNeeded+=chalkitem;

        long chalkRem = k*1l;
        chalkRem %= totalChalkNeeded;
        for(int i=0;i<chalk.length;i++){
           // long chlkNeed = chalk[]
            if(chalk[i]*1l<=chalkRem)
            chalkRem-=chalk[i]*1l;
            else
            return i;
        }
        return -1;
    
        
    }
}