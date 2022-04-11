package hesparza.problems;

public class StringToInteger {
    public void run() {
        System.out.println(myAtoi("-1"));
        System.out.println(myAtoi("   -1"));
        System.out.println(myAtoi("   2147483647"));
        System.out.println(myAtoi("   2147483649"));
        System.out.println(myAtoi("   -2147483649"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("-+12"));
    }

    public int myAtoi(String s) {
        int result = 0;
        StringBuilder val = new StringBuilder();
        char curr;
        for (int i = 0; i < s.length(); i++) {
            curr = s.charAt(i);
            if (val.length() == 0) {
                if (curr == '-') {
                    val.append(curr);
                    continue;
                }
                if (curr == ' ') {
                    continue;
                }
            }
            if (Character.isDigit(curr)) {
                val.append(curr);
            } else {
                break;
            }
        }
        if (val.length() == 0) {
            val.append("0");
        }
        try {
            result = Integer.parseInt(val.toString());
        } catch (NumberFormatException nfe) {
            if (val.toString().contains("-")) {
                result = Integer.MIN_VALUE;
            } else {
                result = Integer.MAX_VALUE;
            }
        }
        return result;
    }
}
