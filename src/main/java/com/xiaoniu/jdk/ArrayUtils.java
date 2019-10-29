package com.xiaoniu.jdk;

/**
 * @author lihoujing
 * @date 2019/10/8 19:01
 */
public class ArrayUtils {



    public static int binarySearch(int[] a, int key){
        return binarySearch0(a, 0, a.length, key);
    }


    private static int binarySearch0(int[] a, int fromIndex, int toIndex, int key){
        int low = fromIndex;
        int high = toIndex -1;

        while (low <= high){
            int mid = low + high;
            int midVal = a[mid];

            if(midVal < key){
                low = mid + 1;
            }else if(midVal > key){
                high = mid - 1;
            }else {
                return mid;
            }
        }

        return -(low + 1);
    }


    /**
     * 目标
     * @param arrays
     * @param targetSum
     * @return
     */
    public static int[] twoSum(int[] arrays, int targetSum){

        for (int i = 0; i<arrays.length; i++){
            for (int j = i + 1; j < arrays.length-i; j++){
                if(arrays[i] + arrays[j] == targetSum){
                    return new int[]{i,j};
                }
            }
        }

        return null;

    }

    public static void main(String[] args) {
        int[] arrays = {1,3,5,7,8,9,2};

        int[] ints = twoSum(arrays, 3);

        System.out.println(ints[0]);
        System.out.println(ints[1]);

    }





}

