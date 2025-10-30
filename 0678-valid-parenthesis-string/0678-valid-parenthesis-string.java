class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0; // lowest possible '(' count
        int maxOpen = 0; // highest possible '(' count

        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else { // c == '*'
                // '*' could be '(' or ')' or ''
                minOpen--; // if '*' is ')'
                maxOpen++; // if '*' is '('
            }

            // If at any point, too many closing brackets
            if (maxOpen < 0) return false;

            // minOpen can't be negative (treat extra ')' as '*')
            if (minOpen < 0) minOpen = 0;
        }

        // valid if at end, all opens can be matched
        return minOpen == 0;
    }
}
