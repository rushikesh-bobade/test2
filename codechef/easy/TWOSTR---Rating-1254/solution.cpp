import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            String x = scanner.next();
            String y = scanner.next();

            boolean possible = true;

            for (int i = 0; i < x.length(); i++) {
                char a = x.charAt(i);
                char b = y.charAt(i);

                if (a != '?' && b != '?' && a != b) {
                    possible = false;
                    break;
                }
            }

            if (possible)
                System.out.println("Yes");
            else
                System.out.println("No");
        }

        scanner.close();
    }
}