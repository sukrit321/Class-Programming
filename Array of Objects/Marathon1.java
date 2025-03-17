import java.util.Scanner;

class Runner{
    String[] name;
    int[] type;
    int n;
    
    Runner(String[] name, int[] type, int n){
        this.name = new String[n];
        this.type = new int[n];
        this.name = name;
        this.type = type;
        this.n = n;
    }

    void printInfo(){
        int cnt = 0;
        for(int i = 0; i < this.n; i++){
            if(this.type[i] < 1 || this.type[i] > 4){
                System.out.println("INVALID");
            }
            else if(this.type[i] == 1){
                if(cnt < 10){
                    System.out.println("A" + String.format("%03d", cnt + 1) + " " + this.name[i]);
                    cnt++;
                }
                else {
                    System.out.println("A" + String.format("%03d", cnt + 1) + " " + this.name[i]);
                    cnt++;
                }
            }
            else if(this.type[i] == 2){
                if(cnt < 10){
                    System.out.println("B" + String.format("%03d", cnt + 1) + " " + this.name[i]);
                    cnt++;
                }
                else {
                    System.out.println("B" + String.format("%03d", cnt + 1) + " " + this.name[i]);
                    cnt++;
                }
            }
            else if(this.type[i] == 3){
                if(cnt < 10){
                    System.out.println("C" + String.format("%03d", cnt + 1) + " " + this.name[i]);
                    cnt++;
                }
                else {
                    System.out.println("C" + String.format("%03d", cnt + 1) + " " + this.name[i]);
                    cnt++;
                }
            }
            else if(this.type[i] == 4){
                if(cnt < 10){
                    System.out.println("D" + String.format("%03d", cnt + 1) + " " + this.name[i]);
                    cnt++;
                }
                else {
                    System.out.println("D" + String.format("%03d", cnt + 1) + " " + this.name[i]);
                    cnt++;
                }
            }
        }
    }
}

public class Marathon1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] name = new String[n];
        int[] type = new int[n];
        for(int i = 0; i < n; i++){
            name[i] = sc.next();
            type[i] = sc.nextInt();
        }
        Runner run = new Runner(name, type, n);
        run.printInfo();

    }
}
