class Solution {

    public boolean isPalindrome(String s) {
        return pal(0, s.length() - 1, s);
    }

    public boolean pal(int l, int r, String s) {

        // base case
        if (l >= r) return true;

        // skip non-alphanumeric from left
        if (!Character.isLetterOrDigit(s.charAt(l))) {
            return pal(l + 1, r, s);
        }

        // skip non-alphanumeric from right
        if (!Character.isLetterOrDigit(s.charAt(r))) {
            return pal(l, r - 1, s);
        }

        // compare lowercase
        if (Character.toLowerCase(s.charAt(l)) !=
            Character.toLowerCase(s.charAt(r))) {
            return false;
        }

        return pal(l + 1, r - 1, s);
    }
}
