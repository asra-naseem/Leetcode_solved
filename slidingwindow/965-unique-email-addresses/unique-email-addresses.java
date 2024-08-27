class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> ans = new HashSet<String>();
        for(String email : emails){
            String [] local = email.split("@");
            String [] parts = local[0].split("\\+");
            ans.add(parts[0].replace(".","")+"@"+local[1]);

             
        }
        return ans.size();
        
    }
}