class Solution {
    public String replaceDigits(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                result.append(c);
            } else {
                // c is a digit; shift the previous letter by this digit's value
                char prevLetter = s.charAt(i - 1);
                char shifted = (char) (prevLetter + (c - '0'));
                result.append(shifted);
            }
        }

        return result.toString();
    }
}
