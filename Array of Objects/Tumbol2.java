import java.util.Scanner;
class Tumbol{
    String name;
    int x;
    int y;
    int people;
    int availBudget;

    public Tumbol(String name, int x, int y, int people) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.people = people;
        this.availBudget = 5000 * people;
    }

    int allocateBudget(int[] arr){
        int sum = 0;
        boolean a = false;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] <= availBudget){
                System.out.print(i + 1 + " ");
                availBudget -= arr[i];
                sum += arr[i];
                a = true;
            }
        }
        if(!a){
            System.out.print("none");
        }
        System.out.println();
        return sum;
    }


    
}

public class Tumbol2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        Tumbol[] tumbols = new Tumbol[k];
        for(int i = 0; i < k; ++i) {
        String name = scan.next();
        int x = scan.nextInt();
        int y = scan.nextInt();
        int population = scan.nextInt();
            tumbols[i] = new Tumbol(name, x, y, population);
        }

        int total = 0;
        for(int i = 0; i < k; ++i) {
            int N = scan.nextInt();
            int[] budget = new int[N];
            for(int j = 0; j < N; j++){
                budget[j] = scan.nextInt();
            }
            total += tumbols[i].allocateBudget(budget);
        }
        System.out.println(total);
    }
}
