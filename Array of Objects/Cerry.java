import java.util.Scanner;
class Ship{
    int capacity;

    Ship(int cap){
        if(cap > 0 ){
            this.capacity = cap;
        }
        else {
            this.capacity = 10;
        }
    }

    int load(int[] weight, int p1){
        int cnt = 0;
        for(int i = p1; i < weight.length; i++){
            if(weight[i] <= capacity){
                capacity -= weight[i];
                cnt++;
            }
            else{
                break;
            }
        }
        return cnt;

    }
}
public class Cerry {
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        Ship[] ship = new Ship[m];
        for (int i=0;i<m;i++){
            int cap = in.nextInt();
            ship[i] = new Ship(cap);
        }
        int p1 = 0;
        int[] weight = new int[n];
        for (int i=0;i<n;i++){
            weight[i] = in.nextInt();
        }
        for (int i=0;i<m;i++){
            p1 += ship[i].load(weight, p1);
        }
        System.out.print(p1+" ");
        int sum_weight = 0;
        for (int i=0;i<p1;i++){
        sum_weight += weight[i];
        }
        System.out.println(sum_weight);
    }
}