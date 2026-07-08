import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		while (T-- > 0) {
			int N = sc.nextInt();
			String S = sc.next();

			int count = 0;

			for (int i = 1; i < N; i++) {
				if (S.charAt(i) == S.charAt(i - 1)) {
					count++;
				}
			}

			System.out.println(count);
		}

		sc.close();
	}
}