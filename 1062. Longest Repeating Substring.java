class Solution {

//https://leetcode.com/problems/longest-repeating-substring/submissions/
    
    //Time complexity: O(Nlog N) in average, and O(N^2) is the worst case
    //Space complexity: O(N^2) That’s because hashtable stores original string along with its hash to avoid hash collision. Approach 2 will not work in case of hash collision.
    public int longestRepeatingSubstring(String S) {
        if (S == null || S.length() < 2) {
            return 0;
        } 
        
        int n = S.length();
        int left = 1;
        int right = n;
        int len;
        while (left <= right) {
            len = left + (right - left)/2;
            if (search(len, n, S) != -1) {
                left = len + 1;
            } else {
                right = len -1;
            }
        }
        return left - 1;
    }
    
    public int search(int len, int n, String s) {
        Set<String> seen = new HashSet<>();
        // To reduce the memory consumption.. we don't have to store the full strings, we could just store their hashes/
        String temp;
        // check the boundary here.
        for (int i = 0; i < n - len + 1 ; i++) {
            temp = s.substring(i, i + len);
            if (seen.contains(temp)) return i;
            seen.add(temp);
        }
        return -1;
    } 
}
