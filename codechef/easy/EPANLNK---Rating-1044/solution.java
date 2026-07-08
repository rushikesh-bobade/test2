import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            String s = scanner.next();

            int remainder = 0;

            for (int i = 0; i < s.length(); i++) {
                remainder = (remainder * 10 + (s.charAt(i) - '0')) % 20;
            }

            System.out.println(remainder);
        }

        scanner.close();
    }
}