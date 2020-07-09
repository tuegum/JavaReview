package review.sort.domain;

import review.sort.utils.SortUtils;

public class Sort {
    private static int count = 0;
    /**
     * 冒泡排序
     * 冒泡排序（Bubble Sort，台湾译为：泡沫排序或⽓泡排序）是⼀种简单的排序算法。它重复地⾛
     * 访过要排序的数列，⼀次⽐较两个元素，如果他们的顺序错误就把他们交换过来。⾛访数列的⼯
     * 作是重复地进⾏直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因
     * 为越⼤的元素会经由交换慢慢“浮”到数列的顶端，故名
     * @param arrays
     */
    public static void BubbleSort(int[] arrays) {
        boolean isChange;
        for (int i = 0; i < arrays.length; i++) {
            isChange = false;
            for (int j = 0; j < arrays.length - i - 1; j++) {
                if (arrays[j] > arrays[j+1]){
                    arrays[j] = arrays[j] + arrays[j+1];
                    arrays[j+1] = arrays[j] - arrays[j+1];
                    arrays[j] = arrays[j] - arrays[j+1];
                    isChange = true;
                }
            }
            if (!isChange){
                System.out.println("共排序了" + i + "次");
                break;
            }
            System.out.print("第" + i + "次排序:  ");
            SortUtils.traverse(arrays);
        }
    }

    /**
     * 选择排序
     * 它的⼯作原理是每⼀次从待排序的数据元素中选出最⼩(或最⼤)的⼀个元素，存放在序列的起始(末尾)位（和"最后一个交换位置"）
     * 置，直到全部待排序的数据元素排完
     * @param arrays
     */
    public static void SelectionSort(int[] arrays) {
        int pos;
        //交换的变量
        int temp;
        for (int i = 0; i < arrays.length -1; i++) {
            pos = 0;//找到最大数的角标
            for (int j = 0; j < (arrays.length - i); j++) {
                pos = arrays[j] > arrays[pos] ? j : pos;
            }
            //交换
            temp = arrays[pos];
            arrays[pos] = arrays[arrays.length - 1 - i];
            arrays[arrays.length - 1 - i] = temp;
            //选择排序，以下交换有问题，同一地址的数，交换相减都为0
//            arrays[pos] = arrays[pos] + arrays[arrays.length - i - 1];
//            arrays[arrays.length - i -1] = arrays[pos] - arrays[arrays.length - i -1];
//            arrays[pos] = arrays[pos] - arrays[arrays.length - i - 1];
            System.out.print("第" + (i+1) + "次排序:  ");
            SortUtils.traverse(arrays);
        }
    }

    /**
     * 插入排序
     * ⽤数组的第⼆个数与第⼀个数(看成是已有序的数据)⽐较
     * 如果⽐第⼀个数⼤，那就不管他
     * 如果⽐第⼀个数⼩，将第⼀个数往后退⼀步，将第⼆个数插⼊第⼀个数去
     * @param arrays
     */
    public static void insertSort(int[] arrays) {
        int temp;
        for (int i = 1; i < arrays.length; i++) {
            temp = arrays[i];
            //如果前⼀位(已排序的数据)⽐当前数据要⼤，那么就进⼊循环⽐较[参考第⼆趟排序]
            int j = i - 1;
            while (j >= 0 && arrays[j] > temp) {
                //往后退⼀个位置，让当前数据与之前前位进⾏⽐较
                arrays[j + 1] = arrays[j];
                //不断往前，直到退出循环
                j--;
            }
            //退出了循环说明找到了合适的位置了，将当前数据插⼊合适的位置中
            arrays[j + 1] = temp;
            System.out.print("第" + i + "次排序:  ");
            SortUtils.traverse(arrays);
        }
    }

    /**
     * 快速排序
     * @param arr
     * @param low
     * @param high
     * @return
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 找寻基准数据的正确索引
            int index = getIndex(arr, low, high);

            // 进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, high);
        }
        System.out.print("第" + ++count + "次排序:  ");
        SortUtils.traverse(arr);
    }

    private static int getIndex(int[] arr, int low, int high) {
        // 基准数据
        int tmp = arr[low];
        while (low < high) {
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            // 如果队尾元素小于tmp了,需要将其赋值给low
            arr[low] = arr[high];
            // 当队首元素小于等于tmp时,向前挪动low指针
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            // 当队首元素大于tmp时,需要将其赋值给high
            arr[high] = arr[low];

        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        arr[low] = tmp;
        return low; // 返回tmp的正确位置
    }



}
