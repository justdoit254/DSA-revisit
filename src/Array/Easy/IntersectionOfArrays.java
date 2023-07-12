package Array.Easy;

import java.util.Arrays;
import java.util.HashSet;

public class IntersectionOfArrays {
    public static void main(String[] args) {
        int[] arr1 = {89, 24, 75, 11, 23};
        int[] arr2 = {89, 2, 4};
        int n = arr1.length;
        int m = arr2.length;

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        HashSet<Integer> set = new HashSet<>();
        int i = 0, j = 0;
        while (i<n && j<m) {
            if (arr1[i]==arr2[j]) {
                set.add(arr1[i]);
                i++; j++;
            } else if (arr1[i]<arr2[j]) {
                i++;
            } else if (arr1[i]>arr2[j]) {
                j++;
            }
        }
        System.out.println(set.size());
    }
}
