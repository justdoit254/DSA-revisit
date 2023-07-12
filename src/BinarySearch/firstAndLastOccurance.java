package BinarySearch;

import java.util.ArrayList;

public class firstAndLastOccurance {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 5, 5, 5, 67, 123, 125 };
        int n = arr.length;
        int k = 5;
        int l = 0, h = n-1, m = 0;
        while (l<=h) {
            m = (l+h)/2;
            if (arr[m]==k) {
                System.out.println(m);
                break;
            }
            else if (arr[m] > k) {
                h = m-1;
            } else {
                l = m+1;
            }
        }
        ArrayList<Integer> list = new ArrayList();
        int left = m;
        while (left>=0) {
            if (arr[left] == k) left--;
            else break;
        }
        int right = m;
        while (right<n) {
            if (arr[right] == k) right++;
            else break;
        }
        list.add(left+1);
        list.add(right-1);
        System.out.println(list);
    }
}
