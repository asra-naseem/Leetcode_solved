import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int appendCharacters(String s, String t) {
        int p1 = s.length();
        int p2 = t.length();
        int i=0,j=0;
        while(i<p1 && j<p2){
            if(s.charAt(i)==t.charAt(j)){
            j++;}
            i++;
        }

        if(i==p1)
        return (p2-j);
        return 0;
    }
}
