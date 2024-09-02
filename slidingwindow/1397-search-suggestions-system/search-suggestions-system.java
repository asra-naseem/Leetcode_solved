class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products); // Sort the products lexicographically
        List<List<String>> ans = new ArrayList<>();
        int left = 0, right = products.length - 1;

        for (int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);

            // Narrow down the left boundary
            while (left <= right && (products[left].length() <= i || products[left].charAt(i) != c)) {
                left++;
            }

            // Narrow down the right boundary
            while (left <= right && (products[right].length() <= i || products[right].charAt(i) != c)) {
                right--;
            }

            // Add up to 3 products to the result list
            List<String> item = new ArrayList<>();
            for (int j = left; j < left + 3 && j <= right; j++) {
                item.add(products[j]);
            }

            ans.add(item);
        }

        return ans;
    }
}