import java.util.Scanner;
class Truck{
    int weight;
    int amount;
    
    public Truck(int weight, int amount) {
        this.weight = weight;
        this.amount = amount;
    }
    
    double calFuel(int distance){
        double cal = (distance + this.weight) / 10.0;
        return Math.ceil(cal);
    }
}
public class TestTruck {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Truck[] t = new Truck[n];
        for(int i=0;i<n;i++){
            t[i] = new Truck(in.nextInt(), in.nextInt());
        }
        int m = in.nextInt();
        for(int i=0;i<m;i++) {
            int x = in.nextInt();
            int distance = in.nextInt();
            double b = t[x - 1].calFuel(distance);
            System.out.println(b);
        }
    }
}