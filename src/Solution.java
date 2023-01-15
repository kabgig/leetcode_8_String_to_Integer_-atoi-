import java.util.ArrayList;
import java.util.stream.Collectors;

class Solution {
    public int myAtoi(String s) {
        String number = "0";
        int res = 0;

        String word = s.trim();
        ArrayList<String> digits = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            if (word.length() == 1 && (
                            word.charAt(0) == '+' ||
                            word.charAt(0) == '-' ||
                            word.charAt(0) == '0' ||
                            word.charAt(0) == '.' ||
                            word.charAt(0) == ' '
            )) break;

            if (word.charAt(0) == '0' && word.charAt(1) == '0') break;

            if (word.length() > 1 && (word.charAt(1) == '+' || word.charAt(1) == '-')) break;

            if (Character.isDigit(word.charAt(i)) ||
                    (word.charAt(i) == '-' && word.length() > 1) ||
                    (word.charAt(i) == '+' && word.length() > 1)
            ) digits.add(Character.toString(word.charAt(i)));

            else break;
        }

        if (!digits.isEmpty()) number = digits.stream().collect(Collectors.joining(""));

        if (Double.parseDouble(number) < -(Math.pow(2, 31))) return (int) -(Math.pow(2, 31));
        if (Double.parseDouble(number) > Math.pow(2, 31) - 1) return (int) Math.pow(2, 31);
        res = Integer.parseInt(number);
        return (int) res;

    }
}