import java.util.ArrayList;
import java.util.stream.Collectors;

class Solution {
    public int myAtoi(String s) {
        String number;
        int res = 0;

        String word = s.trim();
        ArrayList<String> digits = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            if (Character.isDigit(word.charAt(i)) ||
                    word.charAt(i) == '-' ||
                    word.charAt(i) == '+')
                digits.add(Character.toString(word.charAt(i)));
            else break;
        }

        if (!digits.isEmpty())  {
            number = digits.stream().collect(Collectors.joining(""));
            res = Integer.parseInt(number);}

        if (res < -(Math.pow(2, 31))) return (int) -(Math.pow(2, 31));
        if (res > Math.pow(2, 31) - 1) return (int) Math.pow(2, 31) - 1;
        return (int) res;

    }
}