package suanfa.doublepointer;

import java.util.Arrays;

public class ArrayReverse {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        rotate(a,10);

    }
    public static void rotate(int[] nums,int k){
     k %= nums.length;
     reverse(nums,0,nums.length - 1);
     reverse(nums,0,k -1);
     reverse(nums,k,nums.length - 1);
     System.out.println(Arrays.toString(nums));
    }
    public static void reverse(int[] nums,int start,int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
