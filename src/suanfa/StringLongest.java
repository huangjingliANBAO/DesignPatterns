package suanfa;

import java.net.SocketTimeoutException;
import java.util.HashSet;
import java.util.Set;

public class StringLongest {
    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     */
    /**
     * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetc-2/
     */
    public static void main(String[] args) {
        String a = "abccchjftv";
        System.out.println(lengthOfLongesSubstring(a));
    }
    public static int lengthOfLongesSubstring(String s){
        //哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        //右指针，初始值为-1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1,ans = 0;
        /**
         * 1、 i++ 返回原来的值，++i 返回加1后的值。
         * 2、 i++ 不能作为左值，而++i 可以。
         */
        for (int i = 0; i < n; ++i){
          if (i != 0){
              //左指针向右移动一格，移除一个字符
              occ.remove(s.charAt(i - 1));
          }
          while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))){
              // 不断地移动右指针
              occ.add(s.charAt(rk + 1));
              ++rk;
          }
          //第i到rk个字符是一个极长的无重复字符字串
            ans = Math.max(ans,rk - i + 1);
        }
        return ans;
    }
}
