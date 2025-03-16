import java.util.Scanner;
class Car {
    int pin;
    String name;
    int price;
    int labor;

    Car(int pin, String name, int price, int labor){
        this.pin = pin;
        this.name = name;
        this.price = price;
        this.labor = labor;
    }

    static boolean check(String name, int price, int labor){
        if(name.length() != 0 && price > 0 && labor > 0){
            return true;
        }
        else {
            return false;
        }
    }
}
public class AliCarCar1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        Car[] cars = new Car[N];

        int x = 0;
        for(int i = 0; i < N; ++i) {
            String name = scan.next();
            int price = scan.nextInt();
            int labor = scan.nextInt();
            boolean a = Car.check(name, price, labor);
            if(a) {
                cars[x] = new Car(x + 1, name, price, labor);
                System.out.println("valid");
                x++;
            } else {
                System.out.println("invalid");
            }
        }

        for(int i = 0; i < x; i++){
            System.out.println(cars[i].pin + " " + cars[i].name);
        }
    }
}