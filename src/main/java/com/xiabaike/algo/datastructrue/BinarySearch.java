package com.xiabaike.algo.datastructrue;

/**
 * @Author xiabaike
 * @Date 2019/3/10 17:08
 */
public class BinarySearch {

    public int binarySearch(int key, int[] array) {
        int left = 0;
        int rigth = array.length - 1;
        int mid;

        while(left < rigth) {
            mid = (rigth - left) / 2 + left;
            if(key == array[mid]) {
                return mid;
            }
            if(key > array[mid]) {
                left = mid + 1;
            } else {
                rigth = mid + 1;
            }
        }
        return 0;
    }

}
