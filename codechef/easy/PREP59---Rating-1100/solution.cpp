import java.util.*;

class Codechef {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();

            int balance = 0;
            boolean valid = true;

            for (char ch : s.toCharArray()) {
                if (ch == '(') {
                    balance++;
                } else {
                    balance--;
                }

                // closing bracket without matching opening
                if (balance < 0) {
                    valid = false;
                    break;
                }
            }

            if (balance != 0) {
                valid = false;
            }

            System.out.println(valid ? 1 : 0);
        }
    }
}