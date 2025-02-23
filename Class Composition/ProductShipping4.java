import java.util.Scanner;

class Product {
    String nameProduct;
    int weight;
    int price;

    Product(String name, int weight, int price){
        this.nameProduct = name;
        this.weight = weight;
        this.price = price;
    }

    void printInfo(){
        System.out.println(weight + " grams of " + nameProduct + " costs " + price + " baht.");
    }
}

class PurchaseOrder {
    int n;
    Product[] products;
    int[] amount;
    int sumprice;
    int sumwei;

    PurchaseOrder(int n, Product[] products, int[] amount){
        this.n = n;
        this.products = new Product[n];
        this.amount = new int[n];
        this.products = products;
        this.amount = amount;
        for(int i = 0 ; i < n; i++){
            this.sumprice += (products[i].price * amount[i]);
        }
        for(int i = 0 ; i < n; i++){
            this.sumwei += (products[i].weight * amount[i]);
        }

    }

    void printInfo(){
        System.out.println(n + " items = " + sumprice + " baht " + sumwei + " grams");
        for(int i = 0; i < n; i++){
            System.out.println(products[i].nameProduct + " " + amount[i] + "x" + products[i].price + " = " + (amount[i] * products[i].price));
        }
    }
}

// class Truck {
    int netWeight;
    PurchaseOrder purchaseOrders;
    int dest;
    double fee;

    Truck(int capacity){
        this.netWeight = capacity;
        this.dest = 0;
        this.fee = 0;
    }

    void add(PurchaseOrder purchaseOrders, int dest){
        this.purchaseOrders = purchaseOrders;
        this.dest = dest;
        setFee();
    }

    void setFee(){
        this.fee = (purchaseOrders.sumwei * this.dest) / 1000.0;
    }

    double getFee(){
        return this.fee;
    }
}

class SpecialTruck extends Truck{

    SpecialTruck(int capacity){
        super(capacity);
    }

    @Override
    void setFee() {
        this.fee = 2 * (purchaseOrders.sumwei * this.dest) / 1000.0;

    }


}

public class ProductShipping4 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        Truck[] trucks = new Truck[m];
        for (int i=0;i<m;i++){
            int capacity = in.nextInt();
            int type = in.nextInt();
        if (type==1)
            trucks[i] = new Truck(capacity);
        else
            trucks[i] = new SpecialTruck(capacity);
        }
        int n = in.nextInt();
        int dest = in.nextInt();
        Product[] products = new Product[n];
        int[] amount = new int[n];
        for(int i=0;i<n;i++){
            String name = in.next();
            int weight = in.nextInt();
            int price = in.nextInt();
            products[i] = new Product(name,weight,price);
            amount[i] = in.nextInt();
        }
        PurchaseOrder po = new PurchaseOrder(n,products, amount);
        int minvalue = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i=0;i<m;i++){
            if((trucks[i].netWeight>=po.sumwei)&&(minvalue>trucks[i].netWeight)){
                minvalue = trucks[i].netWeight;
                minIndex = i;
            }
        }
        if (minIndex >= 0){
            trucks[minIndex].add(po, dest);
            System.out.println("Truck#"+ (minIndex+1));
            System.out.println("Fee="+ trucks[minIndex].getFee());
        } else {
            System.out.println("No truck");
            double fee = po.sumwei*dest/1000.0;
            System.out.println("Fee="+ fee +" "+(2*fee));
        }
    }
}