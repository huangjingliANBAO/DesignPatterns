package paixu;

import java.util.ArrayList;
import java.util.Arrays;

public class Paixu2 {
    public static void main(String[] args) {
        int[] a = {10,9,11,0,6,-9};
        ArrayList<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(0);
        b.add(2);
       // b.forEach(System.out::println);
        //bucketSort(b,3).forEach(System.out::println);
        System.out.println(Arrays.toString(radixSort(a)));
    }
    static int len;
    /**
     * 将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
     * 将堆顶元素R[1]与最后一个元素R[n]交换，
     * 此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),
     * 且满足R[1,2…n-1]<=R[n]；
     * 由于交换后新的堆顶R[1]可能违反堆的性质，
     * 因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，
     * 然后再次将R[1]与无序区最后一个元素交换，
     * 得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。
     * 不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。
     */
    public static int[] heapSort(int[] array){
        len = array.length;
        if (len < 1) return array;
        //1.构建一个最大堆
        buildMaxHeap(array);
        //2.循环将堆首位（最大值）与末位交换，然后在重新调整最大堆
        while (len > 0){
            swap(array,0,len - 1);
            len --;
            adjustHeap(array,0);
        }
        return array;
    }
    public static void buildMaxHeap(int[] array){
        //从最后一个非叶子节点开始向上构造最大堆
        for (int i = (len/2 - 1); i >= 0; i--){
            adjustHeap(array,i);
        }
    }
    public static void adjustHeap(int[] array,int i){
        int maxIndex = i;
        //如果有左子树，且左子树大于父节点，则将最大指针指向左子树
        if (i * 2 < len && array[i * 2] > array[maxIndex])
            maxIndex = i * 2;
        //如果有右子树，且右子树大于父节点，则将最大指针指向右子树
        if (i * 2 + 1 < len && array[i * 2 + 1] > array[maxIndex])
            maxIndex = i * 2 + 1;
        //如果父节点不是最大值，则将父节点于最大值交换，并且递归调整父节点交换的位置
        if (maxIndex != i){
            swap(array,maxIndex,i);
            adjustHeap(array,maxIndex);
        }
    }
    public static void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    /**
     * 找出待排序的数组中最大和最小的元素；
     * 统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
     * 对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
     * 反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。
     */
    public static int[] countingSort(int[] array){
        if (array.length == 0) return array;
        int bias, min = array[0],max = array[0];
        for (int i = 1; i < array.length; i++){
            if (array[i] > max)
                max = array[i];
            if (array[i] < min)
                min = array[i];
        }
        bias = 0 - min;
        int[] bucket = new int[max - min + 1];
        /**
         * public static void fill(int[] a, int val) {
         *         for (int i = 0, len = a.length; i < len; i++)
         *             a[i] = val;
         */
        Arrays.fill(bucket,0);
        for (int i = 0; i < array.length;i++){
            bucket[array[i] + bias]++;
        }
        int index = 0, i = 0;
        while (index < array.length){
            if (bucket[i] != 0){
                array[index] = i - bias;
                bucket[i]--;
                index++;
            }else
                i++;

        }
        return array;
    }
    /**
     * 人为设置一个BucketSize，作为每个桶所能放置多少个不同数值（例如当BucketSize==5时，
     * 该桶可以存放｛1,2,3,4,5｝这几种数字，但是容量不限，即可以存放100个3）；
     * 遍历输入数据，并且把数据一个一个放到对应的桶里去；
     * 对每个不是空的桶进行排序，可以使用其它排序方法，也可以递归使用桶排序；
     * 从不是空的桶里把排好序的数据拼接起来
     */
     public static ArrayList<Integer> bucketSort(ArrayList<Integer> array,int bucketSize){
         if (array == null || array.size() < 2)
             return array;
         int max = array.get(0),min = array.get(0);
         //找到最大值，最小值
         for (int i = 0; i < array.size(); i++){
             if (array.get(i) > max)
                 max = array.get(i);
             if (array.get(i) < min)
                 min = array.get(i);
         }
         int bucketCount = (max - min) / bucketSize + 1;
         ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
         ArrayList<Integer> resultArr = new ArrayList<>();
         for (int i = 0; i < bucketCount;i++){
             bucketArr.add(new ArrayList<Integer>());
         }
         for (int i = 0; i < array.size(); i++){
             bucketArr.get((array.get(i) - min) / bucketSize).add(array.get(i));
         }
         for (int i = 0; i < bucketCount; i++){
             if (bucketSize == 1){
                 for (int j = 0; j < bucketArr.get(i).size(); j++){
                     resultArr.add(bucketArr.get(i).get(j));
                 }
             }else{
                 if (bucketCount == 1)
                     bucketSize--;
                 ArrayList<Integer> temp = bucketSort(bucketArr.get(i),bucketSize);
                 for (int j = 0; j < temp.size(); j++)
                     resultArr.add(temp.get(j));
             }
         }
         return resultArr;
     }
    /**
     * 取得数组中的最大数，并取得位数；
     * arr为原始数组，从最低位开始取每个位组成radix数组；
     * 对radix进行计数排序（利用计数排序适用于小范围数的特点）；
     */
    public static int[] radixSort(int[] array){
        if (array == null || array.length < 2)
            return array;
        //1.先算出最大数的位数
        int max = array[0];
        for (int i = 1; i < array.length; i++){
            max = Math.max(max,array[i]);
        }
        int maxDigit = 0;
        while (max != 0){
            max /= 10;
            maxDigit++;
        }
        int mod = 10,div = 1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++)
            bucketList.add(new ArrayList<Integer>());
        for (int i = 0; i < maxDigit; i++, mod *= 10,div *= 10){
            for (int j = 0; j < array.length; j++){
                int num = (array[j] % mod) / div;
                bucketList.get(num).add(array[j]);
            }
            int index = 0;
            for (int j = 0; j < bucketList.size(); j++){
                for (int k = 0; k < bucketList.get(j).size(); k++)
                    array[index++] = bucketList.get(j).get(k);
                bucketList.get(j).clear();
            }
        }
        return array;
    }

}
