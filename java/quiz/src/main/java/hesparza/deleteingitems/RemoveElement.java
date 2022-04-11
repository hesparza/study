package hesparza.deleteingitems;

public class RemoveElement {

    public void run() {
        removeElement(new int[]{3,2,2,3}, 3);
        removeElement(new int[]{0,1,2,2,3,0,4,2}, 2);
    }

    public int removeElement(int[] nums, int val) {
        int shifPositions = 0;
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                shifPositions++;
                continue;
            }
            if (shifPositions > 0) {
                nums[i - shifPositions] = nums[i];
            }
            k++;
        }
        System.out.print("k = " + k + " array = " );
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                System.out.print(nums[i] + ",");
            } else {
                System.out.print("_,");
            }
        }
        return k;
    }
}
