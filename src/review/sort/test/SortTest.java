package review.sort.test;

import org.junit.Test;
import review.sort.domain.Sort;
import review.sort.utils.SortUtils;

/**
 * 八大排序算法单元测试
 */
public class SortTest {
    private static int[] arrays = SortUtils.getArrays();

    //冒泡排序
    @Test
    public void bubbleTest(){
        System.out.println("*****冒泡排序*****");
        Sort.BubbleSort(arrays);
    }

    //选择排序
    @Test
    public void selectionTest(){
        System.out.println("*****选择排序*****");
        Sort.SelectionSort(arrays);
    }

    //插入排序
    @Test
    public void insertTest(){
        System.out.println("*****插入排序*****");
        Sort.insertSort(arrays);
    }

    //快速排序
    @Test
    public void quickTest(){
        System.out.println("*****快速排序*****");
        Sort.quickSort(arrays,0,arrays.length-1);
        System.out.println("==========");
        SortUtils.traverse(arrays);
    }
}
