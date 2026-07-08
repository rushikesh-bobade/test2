import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            String S = sc.next();
            String T = sc.next();

            StringBuilder M = new StringBuilder();

            for (int i = 0; i < 5; i++) {
                if (S.charAt(i) == T.charAt(i)) {
                    M.append('G');
                } else {
                    M.append('B');
                }
            }

            System.out.println(M.toString());
        }

        sc.close();
    }
}