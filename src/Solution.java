class Solution {
    public int myAtoi(String s) {
        boolean isNeg;
        int res = 0;

        String word = s.trim();
        isNeg = word.charAt(0) == '-';

        for (int i = 0; i < word.length(); i++) {
            if (Character.isDigit(word.charAt(i)))
                res = res * 10 + (int) word.charAt(i);
        }

        if (res < -(Math.pow(2, 31))) return (int) -(Math.pow(2, 31));
        if (res > Math.pow(2, 31) - 1) return (int) Math.pow(2, 31) - 1;
        if (isNeg) res = Integer.signum(res);
        return res;

    }
}