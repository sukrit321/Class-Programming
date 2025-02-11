import java.util.Scanner;
class Carriage {
    int type;
    int capa;
    int id;
    int num = 0;
    int num1 = 0;

    Carriage(int capa, int type, int id){
        this.type = type;
        this.capa = capa;
        this.id = id;
    }


    void reserveSeats(int q){
        if(this.type == 3){
            int x = q;
            if(q + this.num <= this.capa){
                this.num += q;
            }
            else{
                if(this.num != this.capa){
                    int a = this.capa - this.num;
                    x = q - a;
                    this.num = this.capa;
                    this.num1 += x;
                }
                else {
                    if(q + this.num1 <= 10){
                        this.num1 += q;
                    }
                }
            }
        }
        else {
            if(q + num <= capa){
                num += q;
            }
        }
    }
    
    void printStats(){
        if(this.type == 3){
            System.out.println(this.id + " " + this.type + " " + this.num + " " + this.capa + " " + this.num1 + " 10");
        }
        else {
            System.out.println(this.id + " " + this.type + " " + this.num + " " + this.capa);
        }
    }
}
public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final int N = scan.nextInt();
        Carriage[] car = new Carriage[N];
        for(int i = 0; i < N; i++) {
            int type = scan.nextInt();
            int capa = scan.nextInt();
            int id = scan.nextInt();
            car[i] = new Carriage(capa, type, id);
        }

        final int K = scan.nextInt();
        for(int i = 0; i < K; i++) {
            int p = scan.nextInt();
            int q = scan.nextInt();
            car[p - 1].reserveSeats(q);
        }

        for(int i = 0 ; i < N; i++) {
            car[i].printStats();
        }
    }
}