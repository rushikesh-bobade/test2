public static long stringToNumber(String str) {
    long num = 0;

    for (int i = 0; i < str.length(); i++) {
        int digit = str.charAt(i) - '0';
        num = num * 10 + digit;
    }

    return num;
}