package Array.Medium;

public class StockBuyAndSell {
    public static void main(String[] args) {
//        int[] arr = {23, 13, 25, 29, 33, 19, 34, 45, 65, 67};
        int[] arr = { 100, 180, 260, 310, 40, 535, 695 };
        int n = arr.length;
        int buy = 0, sell = 0;
        int maxProfit = 0;

         int i=0,flag=0,j=0;
        while(i<n-1)
        {
            while(i<n-1 && arr[i+1]>arr[i])
            {
                i++;
            }
            if(i!=j && arr[i]>arr[j])
            {
                flag=1;
                System.out.print("("+j+" "+i+") ");
            }
            j=i+1;
            i=j;
        }
        if(flag==0)
        {
            System.out.print("No Profit");
        }
        System.out.println();

    }
}
