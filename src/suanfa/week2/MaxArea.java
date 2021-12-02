package suanfa.week2;

/**
 * 盛最大的水量
 */
public class MaxArea {
    /**
     * https://leetcode-cn.com/problems/container-with-most-water/solution/sheng-zui-duo-shui-de-rong-qi-by-leetcode-solution/
     */
    public int maxArea(int[] height){
        int l = 0,r = height.length - 1;
        int ans = 0;
        while (1 < r){
            int area = Math.min(height[1],height[r]) * (r - 1);
            ans = Math.max(ans,area);
            if (height[l] <= height[r]){
                ++l;
            }else{
                --r;
            }
        }
        return ans;
    }
}
