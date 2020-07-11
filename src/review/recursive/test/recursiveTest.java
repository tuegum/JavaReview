package review.recursive.test;

import org.junit.Test;
import review.recursive.Domain.RecursiveDemo1;
import review.recursive.utils.recursiveUtils;

public class recursiveTest {
    //递归，找出数组最⼤的值
    @Test
    public void MaxArrayTest(){
        int[] arrays = recursiveUtils.getArrays();
        System.out.println("MAX = " + RecursiveDemo1.findMax(arrays,0,arrays.length-1));
    }

    //冒泡排序递归算法测试
    @Test
    public void bubbleTest(){
        int[] arrays = recursiveUtils.getArrays();
        RecursiveDemo1.bubbleSort(arrays,0,arrays.length-1);
    }

    //斐波拉契数列
    @Test
    public void fibonacciTest(){
        System.out.println(RecursiveDemo1.fibonacci(3));
    }

    //汉诺塔
    @Test
    public void hanoiTest(){
        RecursiveDemo1.hanoi(3, 'A','B','C');
    }
}
