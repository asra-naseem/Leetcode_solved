class Solution {
    public String reorganizeString(String s) {
        char [] res = new char[s.length()];
        int hash[] = new int[26];
        Arrays.fill(hash,0);
        for(int i=0;i<s.length();i++){
            hash[s.charAt(i)-'a']++;
        }
        int max = Integer.MIN_VALUE;
        int letter=0;
        for(int i=0;i<26;i++){
            if(max<hash[i])
            {
                max=hash[i];
                letter=i;
            }
        }
        if(max>(s.length()+1)/2)
        return "";
        int ind=0;
        while(hash[letter]>0 && ind<s.length()){
        res[ind]= (char)(letter+'a');
        ind+=2;
        hash[letter]--;

        }
        for(int i=0;i<26;i++){
            
             while(hash[i]>0){
             if(ind>s.length()-1)
             ind=1;
             res[ind]= (char)(i+'a');
             ind+=2;
             hash[i]--;
             }
        }
        return String.valueOf(res);
    }
}