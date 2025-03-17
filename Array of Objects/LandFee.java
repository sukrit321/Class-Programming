import java.util.Scanner;

class Bill{
    String PIN;
    String saleDate;
    int size;
    int price;
    double tax;
    double fee;
    double stamp;
    public Bill(String PIN, String saleDate, int size, int price) {
        this.PIN = PIN;
        this.saleDate = saleDate;
        this.size = size;
        this.price = price;
        this.tax = size * price * 0.03;
        this.fee = size * price * 0.05;
        this.stamp = size * price * 0.01;
    }

    void printInfo(){
        System.out.println(PIN + " " + saleDate + " " + size + " " + price);
        System.out.println(tax + "+" + fee + "+" + stamp + "=" + (tax + fee + stamp));
    }

    
}
public class LandFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Bill[] bills = new Bill[n];
        for(int i = 0; i < n; i++){
            String PIN = sc.next();
            String saleDate = sc.next();
            int size = sc.nextInt();
            int price = sc.nextInt();
            bills[i] = new Bill(PIN, saleDate, size, price);
            bills[i].printInfo();
        }

    }
}
