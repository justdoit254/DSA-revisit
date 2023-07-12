package BasicMath;

public class CountDigits {
    public static void main(String[] args) {
        int N = 12;
         int num = N;
        int counter = 0;
        while(num!=0) {
            int digit = num%10;
            if(digit!=0 && N%digit==0) {
                counter++;
            }
            num /= 10;
        }
        System.out.println(counter);
    }
}
