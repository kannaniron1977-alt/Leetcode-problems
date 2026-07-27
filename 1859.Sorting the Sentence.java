class Solution {
    public String sortSentence(String s) {
        String[] words = s.split(" ");
        String[] result = new String[words.length];

        for (String word : words) {
            // Last character is the digit indicating position (1-indexed)
            int position = word.charAt(word.length() - 1) - '0';
            String actualWord = word.substring(0, word.length() - 1);
            result[position - 1] = actualWord;
        }

        return String.join(" ", result);
    }
}
