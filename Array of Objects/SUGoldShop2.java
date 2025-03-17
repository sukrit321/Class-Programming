import java.util.Scanner;

class Item{
    boolean type;
    double weight;
    static double s;
    static double b;
    static double s_price;
    static double b_price;

    Item(boolean type, double weight){
        this.type = type;
        this.weight = weight;
        
    }

    Item(double weight){
        this(true, weight);
    }

    void saleprice(double pricegold){
        if(type){
            s_price += (pricegold * weight) + (1000 * weight);
            s += weight;
        }
        else {
            s_price += pricegold * weight;
            s += weight;
        }
    }

    void buyprice(double pricegold){
        if(type){
            b_price += pricegold * weight * 0.98;
            b += weight;
        }
        else {
            b_price += (pricegold - 100) * weight;
            b += weight;
        }
    }

    void showdetail(double pricegold){
        if(type){
            System.out.print("ornament " + weight + " baht");
        }
        else {
            System.out.print("bar " + weight + " baht");
        }
    }
}
public class SUGoldShop2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        double pricegold = input.nextDouble();
        Item[] arrayx = new Item[n];
        for (int i=0;i<n;i++){
            String cmdline = input.next();
            String attgold = input.next();
            double weight = input.nextDouble();
            if (attgold.equalsIgnoreCase("t"))
                arrayx[i] = new Item(true,weight);
            else
                arrayx[i] = new Item(false,weight);
            if(cmdline.equalsIgnoreCase("s"))
                arrayx[i].saleprice(pricegold); 
            else 
                arrayx[i].buyprice(pricegold); 
        }
        System.out.println(Item.s + " " + Item.s_price);
        System.out.println(Item.b + " " + Item.b_price);
        

    }
}