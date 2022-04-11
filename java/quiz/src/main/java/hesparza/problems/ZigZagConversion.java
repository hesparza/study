package hesparza.problems;

public class ZigZagConversion {
    public void run() {
//        System.out.println(convert("PAYPALISHIRING", 4));
//        System.out.println(convert("PAYPALISHIRING", 3));
//        System.out.println(convert("PABLITOCLAVOUNCLAVITO", 6));
//        System.out.println(convert("A", 1));
//        System.out.println(convert("A", 1));
        System.out.println(convert("AB", 3));
        System.out.println(convert("ABC", 4));
    }

    //Accepted
    private String convert(String s, int numRows) {
        final char[] result = new char[s.length()];
        final int zigZagCols = numRows - 2 > 0 ? numRows - 2  : 0;
        int zigZagOffset = s.length() > 2 ? 2 : 0;
        int pos = 0;
        for (int row = 0; pos < s.length(); row++) {
            int offset = row;
            boolean isEdgeRow = row == 0 || row == numRows -1;
            while (offset - zigZagOffset < s.length()) {
                //it's a zig zag letter
                if (offset != row && !isEdgeRow) {
                    result[pos] = s.charAt(offset - zigZagOffset);
                    pos++;
                }
                //no zig zag letter
                if (offset < s.length()) {
                    result[pos] = s.charAt(offset);
                    pos++;
                }
                offset += numRows + zigZagCols;
            }
            if (!isEdgeRow) {
                zigZagOffset += 2;
            }
        }
        return String.valueOf(result);
    }
}
