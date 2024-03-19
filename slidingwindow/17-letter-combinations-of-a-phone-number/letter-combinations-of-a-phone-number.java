class Solution {
    public void helper(int index,HashMap<Integer,String>map,List<String>ans,String digits,StringBuilder s){
        if(index==digits.length()){
            ans.add(s.toString());
            return;
        }
        for(int i=0;i<map.get(digits.charAt(index)-'0').length();i++){
            s.append(map.get(digits.charAt(index)-'0').charAt(i));
            helper(index+1,map,ans,digits,s);
            s.deleteCharAt(s.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length()==0)
        return ans;
        HashMap<Integer,String> hm = new HashMap<>();
        hm.put(2,"abc");
        hm.put(3,"def");
        hm.put(4,"ghi");
        hm.put(5,"jkl");
        hm.put(6,"mno");
        hm.put(7,"pqrs");
        hm.put(8,"tuv");
        hm.put(9,"wxyz");
        helper(0,hm,ans,digits,new StringBuilder(""));
        return ans;

    }
}