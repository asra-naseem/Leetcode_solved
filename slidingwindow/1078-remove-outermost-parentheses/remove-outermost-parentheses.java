class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder str = new StringBuilder();
        int i=0;
        int len = s.length();
        int count=0;
        while(i<len){
            if(s.charAt(i)=='('){
              count++;
              if(count>1)
              str.append('(');
            }
            else{
                if(count>1)
                str.append(')');
                count--;

            }


            i++;
        }
        return str.toString();
    }
}