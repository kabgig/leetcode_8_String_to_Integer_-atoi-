import java.util.ArrayList;
import java.util.stream.Collectors;

class Solution {
    public int myAtoi(String s) {
        String word = s.trim();
        if(s.equals("") || s.equals(" ")) return 0;
        boolean isNeg = word.charAt(0) == '-';
        int result = 0;

        int i;
        if (word.charAt(0) == '+' || word.charAt(0) == '-') i = 1;
        else i = 0;

        ArrayList<String> digits = new ArrayList<>();
        for (int j = i; j < word.length(); j++) {
            if (Character.isDigit(word.charAt(j)))
                digits.add(String.valueOf(word.charAt(j)));
            else break;
        }

        if (!digits.isEmpty()) word =
                digits.stream()
                        .collect(Collectors.joining(""));
        else word = "0";

        if (isNeg && !word.equals("0")) word= "-" + word;
        if (Double.parseDouble(word) < -(Math.pow(2, 31))) return (int) -(Math.pow(2, 31));
        if (Double.parseDouble(word) > Math.pow(2, 31) - 1) return (int) Math.pow(2, 31);
        result = Integer.parseInt(word);
        return result;
    }
}