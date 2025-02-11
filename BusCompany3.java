import java.util.Scanner;
class Bus {
    public String id;
    public int type;
    public int seats;
    int a = 0;
    public String car = "Active";

    public Bus(String id, int type, int seats){
        this.id = id;
        this.type = type;
        this.seats = seats;
    }

    boolean reserve(int K){
        if(K <= 0 || K + this.a > this.seats || this.car.equals("Inactive")){
            return false;
        }
        else {
            a += K;
            return true;
        }
        
    }

    void sendToRepair(){
        car = "Inactive";
    }

    void backToService(){
        car = "Active";
    }

    void printStats(){
        System.out.println(this.id);
        if(this.type == 1){
            System.out.println("Fan");
        }
        else if(this.type == 2){
            System.out.println("P1");
        }
        else {
            System.out.println("VIP");
        }
        System.out.println(a + " " + this.seats);
        System.out.println(car);
    }
}
public class BusCompany3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int Q = scan.nextInt();
        Bus[] bus = new Bus[Q];
        for(int i = 0; i < Q; i++){
            String id = scan.next();
            int type = scan.nextInt();
            int seats = scan.nextInt();
            bus[i] = new Bus(id, type, seats);
        }
        

        int N = scan.nextInt();
        for(int i = 0; i < N; ++i) {
            int P = scan.nextInt();
            int K = scan.nextInt();
            int T = scan.nextInt();
            boolean a = false;
            boolean b = false;
            if(P == 1){
                for(int j = 0; j < Q; j++){
                    if(T == bus[j].type){
                        b = bus[j].reserve(K);
                        if(b){
                            System.out.println(bus[j].id);
                            break;
                        }
                    }
                }
                if(!b){
                    System.out.println("sorry");
                }
            }
            else if(P == 2){
                bus[T - 1].sendToRepair();
            }
            else if(P == 3){
                bus[T - 1].backToService();
            }
        }
    }
}
