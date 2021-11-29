package suanfa.week2;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 */
public class Zpailie {
    /**
     * https://leetcode-cn.com/problems/zigzag-conversion/solution/z-zi-xing-bian-huan-by-leetcode/
     */
    /**
     * 方法一：按行排序
     * 思路
     *
     * 通过从左向右迭代字符串，我们可以轻松地确定字符位于 Z 字形图案中的哪一行。
     *
     * 算法
     *
     * 我们可以使用 \text{min}( \text{numRows}, \text{len}(s))min(numRows,len(s)) 个列表来表示
     * Z 字形图案中的非空行。
     *
     * 从左到右迭代 ss，将每个字符添加到合适的行。可以使用当前行和当前方向这两个变量对合适的行进行跟踪。
     *
     * 只有当我们向上移动到最上面的行或向下移动到最下面的行时，当前方向才会发生改变。
     *
     * @param s
     * @param numRows
     * @return
     */
     public String convert(String s,int numRows){
         if (numRows == 1) return s;
         List<StringBuilder> rows = new ArrayList<>();
         for (int i = 0; i < Math.min(numRows,s.length());i++){
             rows.add(new StringBuilder());
         }
         int curRow = 0;
         boolean goingDown = false;
         for (char c:s.toCharArray()){
             rows.get(curRow).append(c);
             if (curRow == 0 || curRow == numRows - 1)goingDown = !goingDown;
             curRow += goingDown ? 1:-1;
         }
         StringBuilder ret = new StringBuilder();
         for (StringBuilder row:rows)ret.append(row);
         return ret.toString();
     }

    /**
     * 按行访问
     * 思路
     *
     * 按照与逐行读取 Z 字形图案相同的顺序访问字符串。
     *
     * 算法
     *
     * 首先访问 行 0 中的所有字符，接着访问 行 1，然后 行 2，依此类推...
     *
     * 对于所有整数 kk，
     *
     * 行 00 中的字符位于索引 k \; (2 \cdot \text{numRows} - 2)k(2⋅numRows−2) 处;
     * 行 \text{numRows}-1numRows−1 中的字符位于索引 k \; (2 \cdot \text{numRows} - 2)
     * + \text{numRows} - 1k(2⋅numRows−2)+numRows−1 处;
     * 内部的 行 ii 中的字符位于索引 k \; (2 \cdot \text{numRows}-2)+ik(2⋅numRows−2)+i
     * 以及 (k+1)(2 \cdot \text{numRows}-2)- i(k+1)(2⋅numRows−2)−i 处;

     * @param s
     * @param numRows
     * @return
     */
     public String convert2(String s,int numRows){
         if (numRows == 1)return s;
         StringBuilder ret = new StringBuilder();
         int n = s.length();
         int cycleLen = 2*numRows - 2;
         for (int i = 0; i < numRows; i++){
             for (int j = 0; j + i < n; j += cycleLen){
                 ret.append(s.charAt(j + i));
                 if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                     ret.append(s.charAt(j + cycleLen - i));
             }
         }
         return ret.toString();
     }
}
