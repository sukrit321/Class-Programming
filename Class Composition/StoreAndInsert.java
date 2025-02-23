import java.util.Scanner;
import java.util.ArrayList;
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
class Store {
    private ProductInfo[] products;
    private int a = 0;
    
    public Store(int size) {
        products = new ProductInfo[size];
    }

    void enterProductInfo(Scanner scan){

        String name = scan.next();
        int N = scan.nextInt();
        int[] prices = new int[N];
        for(int i = 0; i < N; ++i){
            prices[i] = scan.nextInt(); 
        }
        products[a++] = new ProductInfo(name, prices);
    }

    void printAllProductInfo(){
        for (int i = 0; i < a; i++) {
            products[i].printInfo();
        }
    }
}
public class StoreAndInsert {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int K = scan.nextInt();
        Store store = new Store(K);
        for(int i = 0; i < K; ++i) {
            store.enterProductInfo(scan);
        }
        store.printAllProductInfo();
    }
}