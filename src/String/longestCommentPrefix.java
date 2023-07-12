package String;

public class longestCommentPrefix {
    public static void main(String[] args) {
        String[] arr = {"geeksforgeeks", "geeks", "geek",
         "geezer"};
        int n = arr.length;     //property
        String ans = arr[0];
        for (int i = 1; i < n; i++) {
            String temp = arr[i];
            int n1 = ans.length();      //function
            int n2 = temp.length();
            int j = 0, k = 0;
            while (j<n1 && k<n2) {
                if (ans.charAt(j)==temp.charAt(k)) {
                    j++; k++;
                } else {
                    break;
                }
            }
            ans = temp.substring(0, j);
        }
        if (ans.length()==0) System.out.println(-1);
        else System.out.println(ans);
    }
}
