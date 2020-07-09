
package review.sort.utils;

public class SortUtils {
    public static void traverse(int[] arrays) {
        for(int i = 0; i < arrays.length; ++i) {
            System.out.print(i < arrays.length - 1 ? arrays[i] + "," : arrays[i]);
        }
        System.out.println();
    }

    public static int[] getArrays(){
        int[] arrays = {0,2,5,3,8,11,4,3,7};
        System.out.print("原数组：    ");
        SortUtils.traverse(arrays);
        return arrays;
    }

}
