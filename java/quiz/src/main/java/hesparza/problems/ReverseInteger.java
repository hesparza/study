package hesparza.problems;

public class ReverseInteger {
    public void run() {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(-120));
    }

    public int reverse(int x) {
        int result;
        final String sign = x > 0 ? "" : "-";
        final String val = String.valueOf(Math.abs(x));
        StringBuilder valReverted = new StringBuilder(sign);
        for (int i = val.length() - 1; i >= 0; i--) {
            valReverted.append(val.charAt(i));
        }
        try {
            result = Integer.parseInt(valReverted.toString());
        } catch (NumberFormatException nfe) {
            result = 0;
        }
        return result;
    }
}
