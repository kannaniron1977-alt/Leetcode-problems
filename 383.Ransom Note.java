class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] counts = new int[26];

        // Count letter frequencies in magazine
        for (char c : magazine.toCharArray()) {
            counts[c - 'a']++;
        }

        // Subtract letter frequencies needed by ransomNote
        for (char c : ransomNote.toCharArray()) {
            counts[c - 'a']--;
            if (counts[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
