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

class Factory{
    Car[] cars;
    boolean[] model;
    int labors;
    public Factory(Car[] cars, boolean[] model, int labors) {
        this.cars = new Car[cars.length];
        this.cars = cars;
        this.model = new boolean[model.length];
        this.model = model;
        this.labors = labors;
    }

}

public class AliCarCar2 {
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
                x++;
            }
        }

        Factory[] factory = new Factory[5];
        for(int i = 0; i < 5; i++){
            int labors = scan.nextInt();
            boolean[] model = new boolean[N];
            for(int j = 0; j < N; j++){
                int z = scan.nextInt();
                if(z == 1){
                    model[j] = true;
                }
                else {
                    model[j] = false;
                }
            }
            factory[i] = new Factory(cars, model, labors);
        }
        
        int k = scan.nextInt();
        for(int i = 0; i < k; i++){
            int y = scan.nextInt();
            if(y > x){
                System.out.println("invalid model");
            }
            else {
                boolean c = false;
                for(int j = 0; j < 5; j++){
                    if(factory[j].labors >= cars[y - 1].labor && factory[j].model[y - 1]){
                        System.out.println("okay " + (j + 1));
                        factory[j].labors -= cars[y - 1].labor;
                        c = true;
                        break;
                    }
                }
                if(!c){
                    System.out.println("unable to build");
                }
            }
        }
    }
}