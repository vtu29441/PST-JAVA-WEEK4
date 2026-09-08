class Solution {
    public boolean halvesAreAlike(String s) {
        int vowelsCount = 0;
        int n = s.length();
        String vowels = "aeiouAEIOU";
        
        for (int i = 0; i < n / 2; i++) {
            // Check first half
            if (vowels.indexOf(s.charAt(i)) >= 0) {
                vowelsCount++;
            }
            // Check second half
            if (vowels.indexOf(s.charAt(i + n / 2)) >= 0) {
                vowelsCount--;
            }
        }
        
        return vowelsCount == 0;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna