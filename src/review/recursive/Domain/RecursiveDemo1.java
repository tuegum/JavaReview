package review.recursive.Domain;

import review.sort.utils.SortUtils;

public class RecursiveDemo1 {
    public static int count = 0;

    /**
     * 递归，找出数组最⼤的值
     *
     * @param arrays 数组
     * @param L      左边界，第⼀个数
     * @param R      右边界，数组的⻓度
     * @return
     */
    public static int findMax(int[] arrays, int L, int R) {
        //如果该数组只有⼀个数，那么最⼤的就是该数组第⼀个值了,否则递归
        return L == R ? arrays[L] : (Math.max(arrays[L], findMax(arrays, L + 1, R)));
    }

    /**
     * 冒泡排序递归实现
     *
     * @param arrays
     * @param L
     * @param R
     */
    public static void bubbleSort(int[] arrays, int L, int R) {
        int temp;
        if (L == R) {
            return;
        } else {
            for (int i = L; i < R; i++) {
                if (arrays[i] > arrays[i + 1]) {
                    temp = arrays[i];
                    arrays[i] = arrays[i + 1];
                    arrays[i + 1] = temp;
                }
            }
            System.out.print("第" + ++count + "次排序:  ");
            SortUtils.traverse(arrays);
        }
        bubbleSort(arrays, L, R - 1);
    }

    /**
     * 斐波那契数列
     *
     * @param n
     * @return
     */
    public static int fibonacci(int n) {
        return n == 1 ? 1 : (n == 2 ? 1 :fibonacci(n - 1) + fibonacci(n - 2));
    }


}
