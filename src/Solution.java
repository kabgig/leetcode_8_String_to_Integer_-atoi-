import java.util.ArrayList;
import java.util.stream.Collectors;

class Solution {
    public int myAtoi(String s) {
  //      boolean isNeg;

        String word = s.trim();
 //       isNeg = word.charAt(0) == '-';
        ArrayList<String> digits = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            if (Character.isDigit(word.charAt(i)) || word.charAt(i) == '-')
                digits.add(Character.toString(word.charAt(i)));
            else if (digits.isEmpty()) continue;
            else break;
        }

        String number = digits.stream().collect(Collectors.joining(""));
        int res = Integer.parseInt(number);

        if (res < -(Math.pow(2, 31))) return (int) -(Math.pow(2, 31));
        if (res > Math.pow(2, 31) - 1) return (int) Math.pow(2, 31) - 1;
    //    if (isNeg) res = Integer.signum((int) res);
        return (int) res;

    }
}