import java.util.Scanner;;
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

    void allocateBudget(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] <= availBudget){
                System.out.print(i + 1 + " ");
                availBudget -= arr[i];
            }
        }
    }


    
}

public class Tumbol1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int people = sc.nextInt();
        Tumbol tumbol = new Tumbol(name, x, y, people);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        tumbol.allocateBudget(arr);
    }
}
