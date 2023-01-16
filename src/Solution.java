import java.util.ArrayList;
import java.util.stream.Collectors;

class Solution {
    public int myAtoi(String s) {
        String number = "0";

        String word = s.trim();
        ArrayList<String> digits = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            if (word.length() == 1 && !Character.isDigit(word.charAt(0))) break;

            if (!Character.isDigit(word.charAt(1)) && !digits.isEmpty()) break;

            if (Character.isDigit(word.charAt(i)) ||
                    (word.charAt(0) == '-' && i==0) ||
                    (word.charAt(0) == '+' && i==0)
            )
            digits.add(Character.toString(word.charAt(i)));
            else break;
        }

        if (!digits.isEmpty()) number = digits.stream().collect(Collectors.joining(""));

        if (Double.parseDouble(number) < -(Math.pow(2, 31))) return (int) -(Math.pow(2, 31));
        if (Double.parseDouble(number) > Math.pow(2, 31) - 1) return (int) Math.pow(2, 31);
        int res = Integer.parseInt(number);
        return res;

    }
}