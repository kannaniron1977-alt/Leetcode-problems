class Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenExponent = false;
        boolean seenDot = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                seenDigit = true;
            } else if (c == '+' || c == '-') {
                // Sign must be at the start, or right after 'e'/'E'
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (c == 'e' || c == 'E') {
                // Must have seen a digit before, and no previous exponent
                if (seenExponent || !seenDigit) {
                    return false;
                }
                seenExponent = true;
                seenDigit = false; // reset: need at least one digit after 'e'
            } else if (c == '.') {
                // No dot allowed after exponent, and no repeated dot
                if (seenDot || seenExponent) {
                    return false;
                }
                seenDot = true;
            } else {
                // Any other character is invalid
                return false;
            }
        }

        return seenDigit;
    }
}
