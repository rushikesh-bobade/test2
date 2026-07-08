using System;

public class Test
{
    public static void Main()
    {
        int t = int.Parse(Console.ReadLine());

        while (t-- > 0)
        {
            string s = Console.ReadLine();

            int remainder = 0;

            foreach (char c in s)
            {
                remainder = (remainder * 10 + (c - '0')) % 20;
            }

            Console.WriteLine(remainder);
        }
    }
}