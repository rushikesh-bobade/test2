import java.util.*;

class Codechef {
    public static void main (String[] args) throws java.lang.Exception {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();

            int n = s.length();

            if (n < 10) {
                System.out.println("NO");
                continue;
            }

            boolean lower = false;
            boolean upper = false;
            boolean digit = false;
            boolean special = false;

            // lowercase anywhere
            for (int i = 0; i < n; i++) {
                if (Character.isLowerCase(s.charAt(i))) {
                    lower = true;
                    break;
                }
            }

            // strict middle checks
            for (int i = 1; i < n - 1; i++) {
                char c = s.charAt(i);

                if (Character.isUpperCase(c)) upper = true;
                else if (Character.isDigit(c)) digit = true;
                else if (c == '@' || c == '#' || c == '%' || c == '&' || c == '?') {
                    special = true;
                }
            }

            if (lower && upper && digit && special)
                System.out.println("YES");
            else
                System.out.println("NO");
        }

        sc.close();
    }
}