import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class Solution3 {
    public int myAtoi(String s) {
        if (s.isEmpty()) return 0;
        int sign = 1, i = 0, base = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-'))
            if (s.charAt(i++) == '-') sign = -1;

        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            if (base > Integer.MAX_VALUE / 10 ||
                    base == Integer.MAX_VALUE / 10 &&
                            s.charAt(i) - '0' > 7)
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            base = (base * 10) + s.charAt(i++) - '0';
        }
        return base * sign;

    }
}
