package suanfa.week2;

import sun.misc.PostVMInitHook;

//数字反转
public class ShuziFanzhuan {
    public static void main(String[] args) {
        int a = 54;
        System.out.println(reverse(a));
    }
    /**
     * https://leetcode-cn.com/problems/reverse-integer/solution/zheng-shu-fan-zhuan-by-leetcode-solution-bccn/
     */
    public static int reverse(int x){
        int rev = 0;
        while (x != 0){
            if (rev < Integer.MAX_VALUE/10 || rev > Integer.MAX_VALUE/10){
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }
}
