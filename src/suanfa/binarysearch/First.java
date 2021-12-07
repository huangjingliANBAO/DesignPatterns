package suanfa.binarysearch;

public class First{
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        System.out.println(searchInsert(nums,9));
    }
    public static int search(int[] nums,int target){
       int low = 0,high = nums.length - 1;
       while (low <= high){
           int mid = (high - low)/2 + low;
           int num = nums[mid];
           if (num == target){
               return mid;
           }else if (target > num){
               low = mid + 1;
           }else {
               high = mid - 1;
           }

       }
       return -1;
    }
    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

}
