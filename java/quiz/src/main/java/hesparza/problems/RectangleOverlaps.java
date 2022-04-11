package hesparza.problems;

public class RectangleOverlaps {

    private enum SegmentPosition {
        left, right;
    }

    public void run() {

//        System.out.println(isRectangleOverlap(new int[]{0,0,2,2}, new int[]{1,1,3,3}));
//        System.out.println(isRectangleOverlap(new int[]{0,0,2,2}, new int[]{0,0,2,2}));
//        System.out.println(isRectangleOverlap(new int[]{0,0,1,1}, new int[]{1,0,2,1}));
//        System.out.println(isRectangleOverlap(new int[]{0,0,1,1}, new int[]{2,2,3,3}));
//        System.out.println(isRectangleOverlap(new int[]{7,8,13,15}, new int[]{10,8,12,20}));
//        System.out.println(isRectangleOverlap(new int[]{0,0,1,1}, new int[]{2,2,3,3}));
        System.out.println(isRectangleOverlap(new int[]{-193634870,-175701756,958697367,607619635}, new int[]{91619846,10349052,822028072,696611776}));
    }

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = 0;
        int x2 = 0;
        int y1 = 0;
        int y2 = 0;
        boolean result;

        try {
            final int segmentX1 = rec1[2] - rec1[0];
            final int segmentX2 = rec2[2] - rec2[0];
            if (segmentX1 >= segmentX2) {
                x1 = getXPoint(rec1[0], rec1[2], rec2[0], SegmentPosition.left);
                x2 = getXPoint(rec1[0], rec1[2], rec2[2], SegmentPosition.right);
            } else {
                x1 = getXPoint(rec2[0], rec2[2], rec1[0], SegmentPosition.left);
                x2 = getXPoint(rec2[0], rec2[2], rec1[2], SegmentPosition.right);
            }
            final int segmentY1 = rec1[3] - rec1[1];
            final int segmentY2 = rec2[3] - rec2[1];
            if (segmentY1 >= segmentY2) {
                y1 = getXPoint(rec1[1], rec1[3], rec2[1], SegmentPosition.left);
                y2 = getXPoint(rec1[1], rec1[3], rec2[3], SegmentPosition.right);
            } else {
                y1 = getXPoint(rec2[1], rec2[3], rec1[1], SegmentPosition.left);
                y2 = getXPoint(rec2[1], rec2[3], rec1[3], SegmentPosition.right);
            }

            int area = Math.abs((x2 - x1) * (y2 - y1));
            result = area > 0;
        } catch(Exception e) {
            result = false;
        }
        return result;
    }

    /**
     * Returns the crossing point of a segment and a point
     * @param x1 - first point of the segment
     * @param x2 - second point of the segment
     * @param p - a point
     * @param segmentPos - tells if the segment is expected to the left or to the right
     * @return
     */
    private int getXPoint(int x1, int x2, int p, SegmentPosition segmentPos) {
        int crossingPoint = 0;
        if (x1 <= p && p <= x2) {
            crossingPoint = p;
        } else if (segmentPos == SegmentPosition.left) {
            if (x1 >= p) {
                crossingPoint = x1;
            } else {
                throw new IllegalStateException("No crossing point for segment: [" + x1 + "," + x2 + "] and point: " + p);
            }
        } else {
            if (x2 <= p) {
                crossingPoint = x2;
            } else {
                throw new IllegalStateException("No crossing point for segment: [" + x1 + "," + x2 + "] and point: " + p);
            }
        }
        return crossingPoint;
    }
}
