import java.util.Scanner;

class Blade {
    int size;
    int number;
    int angle;
    double hp;
    boolean valid = false;
    int cut = 0;
    
    Blade(int size,int number,int angle,double hp){
        this.size = size;
        this.number = number;
        this.angle = angle;
        this.hp = hp;
    }

    void printInfo(){
        if(this.size < 16 || this.size > 24 || this.size % 2 != 0){
            System.out.println("invalid size");
            valid = false;
            cut++;
        }
        if(this.number < 3 || this.number > 5){
            System.out.println("invalid number of blades");
            valid = false;
            cut++;
        }
        if(this.angle == 27 || this.angle == 30 || this.angle == 33){
        }
        else {
            System.out.println("invalid angle");
            valid = false;
            cut++;
        }
        if(this.hp < 0){
            System.out.println("invalid horsepower");
            valid = false;
            cut++;
        }
        if(cut == 0){
            valid = true;
        }
        System.out.println(this.size + " " + this.number + " " + this.angle + " " + this.hp + " " + this.valid);

    }
}
class Motor{
    double V,I,eff;
    Motor(double V,double I, double eff){
        this.V = V;
        this.I = I;
        this.eff = eff / 100;
    }
    Motor(double I,double eff){
        this.V = 220;
        this.I = I;
        this.eff = eff / 100;
    }
    double horsepower(){
        return (this.V * this.I * this.eff) / 746;
    }
    void printInfo(){
    double hp = horsepower();
    System.out.println(V + " " + I + " " + eff +" " + String.format("%.2f", hp));
    }
}

class ElectricFan{
    int productID;
    Blade ablade;
    Motor motor;
    boolean status = false;
    static int count = 0;
    ElectricFan(Blade ablade, Motor motor){
        count++;
        this.productID = count;
        this.ablade = ablade;
        this.motor = motor;
        if(motor.horsepower() >= ablade.hp){
            this.status = true;
        }
    }

    void changeBlade(Blade ablade){
        this.ablade = ablade;
        if(motor.horsepower() >= ablade.hp){
            this.status = true;
        }
        else {
            this.status = false;
        }
    }

    void changeMotor(Motor motor){
        this.motor = motor;
        if(motor.horsepower() >= ablade.hp){
            this.status = true;
        }
        else {
            this.status = false;
        }
    }

    void printInfo(){
        System.out.println(productID + " " + ablade.size + " " + this.ablade.hp + " " + this.motor.I + " " + String.format("%.2f", motor.horsepower()) + " " + this.status);
    }
}

public class FanCompany3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int size,numb,angle;
        double hp,v,i,eff;
        Blade ablade = null;
        Motor motor = null;
        ElectricFan eFan= null;
        for(int index=0;index<n;index++){
            int cmd = sc.nextInt();
            if (cmd==0){
                size = sc.nextInt();
                numb = sc.nextInt();
                angle = sc.nextInt();
                hp = sc.nextDouble();
                ablade = new Blade(size,numb,angle,hp);
                v = sc.nextDouble();
                i = sc.nextDouble();
                eff = sc.nextDouble();
                motor = new Motor(v,i,eff);
                eFan = new ElectricFan(ablade, motor);
            } else if(cmd==1){
                size = sc.nextInt();
                numb = sc.nextInt();
                angle = sc.nextInt();
                hp = sc.nextDouble();
                ablade = new Blade(size,numb,angle,hp);
                eFan.changeBlade(ablade);
            } else if(cmd==2){
                v = sc.nextDouble();
                i = sc.nextDouble();
                eff = sc.nextDouble();
                motor = new Motor(v,i,eff);
                eFan.changeMotor(motor);
            }
                eFan.printInfo();
        }
    }
}