import java.util.Scanner;
class ProductInfo {
    String name;
    int[] prices;

    ProductInfo(String name, int[] prices){
        this.name = name;
        this.prices = prices;
    }

    void printInfo(){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] > max){
                max = prices[i];
            }
            if(prices[i] < min){
                min = prices[i];
            }
        }
        System.out.println(name + " " + min + " " + max);
    }
}
public class FindBestDeal {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        int N = scan.nextInt();
        int[] prices = new int[N];
        for(int i = 0; i < N; ++i){
            prices[i] = scan.nextInt(); 
        }
        ProductInfo pInfo = new ProductInfo(name, prices);
        pInfo.printInfo();
    }
}
