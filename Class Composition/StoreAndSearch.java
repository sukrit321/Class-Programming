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

    void search(String name){
        int cnt = 0;
        for(int i = 0; i < products.length; i++){
            if(products[i].name.indexOf(name) != -1){
                cnt++;
            }
        }
        System.out.println(cnt);
        if(cnt == 0){
            System.out.println("product not found");
        }
        else {
            for(int i = 0; i < products.length; i++){
                if(products[i].name.indexOf(name) != -1){
                    products[i].printInfo();
                }
            }
        }
    }

    void printAllProductInfo(){
        for (int i = 0; i < a; i++) {
            products[i].printInfo();
        }
    }
}
public class StoreAndSearch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int K = scan.nextInt();
        Store store = new Store(K);
        for(int i = 0; i < K; ++i) {
            store.enterProductInfo(scan);
        }
        String name  = scan.next();
        store.search(name);
    }
}