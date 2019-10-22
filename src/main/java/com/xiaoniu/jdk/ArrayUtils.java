package com.xiaoniu.jdk;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

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


    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setAge(10);
        userList.add(user1);
        User user2 = new User();
        user2.setAge(20);
        userList.add(user2);
        User user3 = new User();
        user3.setAge(25);
        userList.add(user3);

        int ageSum = userList.parallelStream().mapToInt(User::getAge).sum();



    }


}


class User{


    private Integer age;


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
