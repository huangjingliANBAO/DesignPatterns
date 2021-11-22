package suanfa;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 */
public class DichotomousSearch {
    /**
     * 在升序数组 \textit{nums}nums 中寻找目标值 \textit{target}target，对于特定下标 ii，
     * 比较 \textit{nums}[i]nums[i] 和 \textit{target}target 的大小：
     *
     * 如果 \textit{nums}[i] = \textit{target}nums[i]=target，则下标 ii 即为要寻找的下标；
     *
     * 如果 \textit{nums}[i] > \textit{target}nums[i]>target，则 \textit{target}target 只可能在下标 ii 的左侧；
     *
     * 如果 \textit{nums}[i] < \textit{target}nums[i]<target，则 \textit{target}target 只可能在下标 ii 的右侧。
     *
     * 基于上述事实，可以在有序数组中使用二分查找寻找目标值。
     *
     * 二分查找的做法是，定义查找的范围 [\textit{left}, \textit{right}][left,right]，
     * 初始查找范围是整个数组。每次取查找范围的中点 \textit{mid}mid，
     * 比较 \textit{nums}[\textit{mid}]nums[mid] 和 \textit{target}target 的大小，
     * 如果相等则 \textit{mid}mid 即为要寻找的下标，如果不相等则根据 \textit{nums}[\textit{mid}]nums[mid]
     * 和 \textit{target}target 的大小关系将查找范围缩小一半。
     *
     * 由于每次查找都会将查找范围缩小一半，因此二分查找的时间复杂度是 O(\log n)O(logn)，其中 nn 是数组的长度。
     *
     * 二分查找的条件是查找范围不为空，即 \textit{left} \le \textit{right}left≤right。
     * 如果 \textit{target}target 在数组中，二分查找可以保证找到 \textit{target}target，
     * 返回 \textit{target}target 在数组中的下标。如果 \textit{target}target 不在数组中，
     * 则当 \textit{left} > \textit{right}left>right 时结束查找，返回 -1−1。
     */
    public int search(int[] nums,int target){
        int low = 0, high = nums.length - 1;
        while ( low <= high){
            int mid = (high - low) /2 + low;
            int num = nums[mid];
            if (num == target){
                return mid;
            }else if (num > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
