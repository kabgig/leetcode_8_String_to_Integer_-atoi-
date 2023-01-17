import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class Solution3 {
    public int myAtoi(String s) {
        if (s.isEmpty()) return 0;
        int sign = 1, i = 0, base = 0;
        while (s.charAt(i) == ' ') i++;

        if (s.charAt(i) == '+' || s.charAt(i) == '-')
            if (s.charAt(i++) == '-') sign = -1;

        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            if (base > Math.pow(2, 31))
                return (sign == 1) ? (int)Math.pow(2, 31) : -(int)Math.pow(2, 31);
            base = (base * 10) + s.charAt(i++)-'0';
        }
        return base * sign;

    }
}
