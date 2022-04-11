package hesparza.problems;

import java.util.Arrays;

public class MergeSortedArrays {

    public void run() {
        int[] nums1 = new int[]{-1, 0, 0, 3, 3, 3, 0, 0, 0};
        int[] nums2 = new int[]{1, 2, 2};
        merge(nums1, 6, nums2, nums2.length);
        nums1 = new int[]{1, 2, 3, 0, 0, 0};
        nums2 = new int[]{2, 5, 6};
        merge(nums1, 3, nums2, nums2.length);
        nums1 = new int[]{0};
        nums2 = new int[]{1};
        merge(nums1, 0, nums2, nums2.length);
        nums1 = new int[]{-1, -1, 0, 0, 0, 0};
        nums2 = new int[]{-1, 0};
        merge(nums1, 4, nums2, nums2.length);
        nums1 = new int[]{-1, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0};
        nums2 = new int[]{-1, -1, 0, 0, 1, 2};
        merge(nums1, 5, nums2, nums2.length);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        int i = 0;
        int[] aux = Arrays.copyOf(nums1, nums1.length);

        for (int x = 0; x < aux.length; x++) {
            if (i < m && j < n) {
                //compare
                if (aux[i] <= nums2[j]) {
                    nums1[x] = aux[i];
                    i++;
                } else {
                    nums1[x] = nums2[j];
                    j++;
                }
            } else if (i < m) {
                //take from nums1 aka aux
                nums1[x] = aux[i];
                i++;
            } else {
                //take from nusm2
                nums1[x] = nums2[j];
                j++;
            }
        }

        for (int z = 0; z < nums1.length; z++) {
            System.out.print(nums1[z] + ",");
        }
        System.out.println();
    }

    public void merge_bu(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        int i = 0;
        final int INVALID = 201;
        int[] aux = Arrays.copyOf(nums1, nums1.length);
        int currNums2 = n == 0 ? INVALID : nums2[0];

        for (int x = 0; x < aux.length; x++) {
            if (aux[i] <= currNums2 || currNums2 == INVALID) {
                if ((x >= m) && aux[i] == 0 && currNums2 != INVALID) {
                    nums1[x] = currNums2;
                    j++;
                    currNums2 = j >= n ? INVALID : nums2[j];
                } else {
                    nums1[x] = aux[i];
                    i++;
                }
            } else {
                nums1[x] = currNums2;
                j++;
                currNums2 = j >= n ? INVALID : nums2[j];
            }
        }

        for (int z = 0; z < nums1.length; z++) {
            System.out.print(nums1[z] + ",");
        }
        System.out.println();
    }
}
