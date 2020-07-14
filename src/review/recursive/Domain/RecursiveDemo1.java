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

    /**
     * 汉诺塔
     * @param n n个盘⼦
     * @param start 起始柱⼦
     * @param transfer 中转柱⼦
     * @param target ⽬标柱⼦
     */
    public static void hanoi(int n, char start, char transfer, char target) {
        //只有⼀个盘⼦，直接搬到⽬标柱⼦
        if (n == 1) {
            System.out.println("第" + ++count + "次" + start + "---->" + target);
        } else {
            //起始柱⼦借助⽬标柱⼦将盘⼦都移动到中转柱⼦中(除了最⼤的盘⼦)
            hanoi(n - 1, start, target, transfer);
            System.out.println("第" + ++count + "次" + start + "---->" + target);
            //中转柱⼦借助起始柱⼦将盘⼦都移动到⽬标柱⼦中
            hanoi(n - 1, transfer, start, target);
        }
    }

}
