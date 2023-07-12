package Array.Easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class UnionOfSortedArrays {
    public static void main(String[] args) {
//        int[] arr1 = {2,2,3,4,5};
        int[] arr1 = {1,35};
//        int[] arr2 = {1,1,2,3,4};
        int[] arr2 = {6, 9, 13, 15, 20, 25, 29, 46};
        int n = arr1.length;
        int m = arr2.length;

        ArrayList<Integer> list = new ArrayList<>();
        int i=0, j=0;
        while (i<n && j<m) {
            if (arr1[i]==arr2[j]) {
               if (!list.contains(arr1[i]))list.add(arr1[i]);
                i++; j++;
            } else if (arr1[i]<arr2[j]) {
                if (!list.contains(arr1[i]))list.add(arr1[i]);
                i++;
            } else if (arr1[i]>arr2[j]) {
                if (!list.contains(arr2[j]))list.add(arr2[j]);
                j++;
            }
        }
        while (i<n) {
            if (!list.contains(arr1[i]))list.add(arr1[i]);
            i++;
        }
        while (j<m) {
            if (!list.contains(arr2[j]))list.add(arr2[j]);
            j++;
        }

        System.out.println(list);

//        Using Hashset or Treeset
//        HashSet<Integer> set = new HashSet<>();
        TreeSet<Integer> set = new TreeSet<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int item : arr1) {
            set.add(item);
        }
        for (int value : arr2) {
            set.add(value);
        }
        for (int el : set) {
            ans.add(el);
        }
        System.out.println(ans);
    }
}
