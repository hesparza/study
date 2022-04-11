package hesparza.problems;

public class FindMedianSortedArrays {
    public final void run() {
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0;
        final int count = nums1.length + nums2.length;
        int[] arraysMerged = new int[count];
        for (int i = 0, j =0, counter = 0; counter < count; counter++) {
            if (i < nums1.length && j < nums2.length) {
                //both have elements
                if (nums1[i] <= nums2[j]) {
                    arraysMerged[counter] = nums1[i];
                    i++;
                } else {
                    arraysMerged[counter] = nums2[j];
                    j++;
                }
            } else if (i < nums1.length) {
                //only nums1 has elements
                arraysMerged[counter] = nums1[i];
                i++;
            } else {
                //only nums2 has elements
                arraysMerged[counter] = nums2[j];
                j++;
            }
        }
        if (count % 2 == 0) {
            int middlePosition = count/2 - 1;
            result = (arraysMerged[middlePosition] + arraysMerged[middlePosition + 1])/2.0;
        } else {
            int middlePosition = (int) Math.ceil(count/2);
            result = arraysMerged[middlePosition];
        }
        return result;
    }
}
