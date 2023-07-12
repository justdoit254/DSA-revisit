package String;

import java.util.Arrays;

public class sumOfBeauty {
    public static void main(String[] args) {
//        String s = "geeksforgeeks";
        String s = "aaac";
        int n = s.length();
        int sum = 0;
        for (int i = 0; i < n+1; i++) {
            for (int j = i+1; j < n+1; j++) {
                String sub = s.substring(i,j);
                sum += findBeauty(sub);
            }
        }
        System.out.println(sum);

        //O(n^2)
        int ans = 0;
        int len = s.length();

        for(int start = 0; start < len; start++){ //a aa aaa aaac
            int[] arr = new int[26];

            for(int end = start; end < len; end++){
                arr[s.charAt(end) - 'a']++;
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;

                for(int k = 0; k < 26; k++){
                    max = Math.max(max, arr[k]);
                    if(arr[k] != 0){ // we don't check min at 0 index because both min and max can't be present for a single indexed string
                        min = Math.min(min, arr[k]);
                    }
                }
                ans += max - min;
            }
        }
        System.out.println(ans);
    }

    private static int findBeauty(String sub) {
        int n = sub.length();
        if (n==1) return 0;
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        //Filling the array
        for (int i = 0; i < n; i++) {
            char ch = sub.charAt(i);
            arr[ch-'a']++;
        }
        //Find the min
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int j : arr) {
            if (j >= 0 && j < min) {
                min = j;
            }
            if (j >= 0 && j > max) {
                max = j;
            }
        }
//        System.out.println(Arrays.toString(arr));
        return (max-min);

    }
}
