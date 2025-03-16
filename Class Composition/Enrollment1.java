import java.util.Scanner;

class Course{
    String name;
    int nummax;
    int[] num;
    int cnt = 0;

    Course(String name, int nummax) {
        this.name = name;
        this.nummax = nummax;
        this.num = new int[nummax];
    }

    boolean enroll(int x){
        if(cnt == this.nummax){
            return false;
        }
        else {
            for(int i = 0; i < nummax; i++){
                if(this.num[i] == x){
                    return false;
                }
            }
            this.num[cnt] = x;
            this.cnt++;
            return true;  
        }
    }

    void printInfo(){
        System.out.println(name + " " + cnt);
        for(int i = 0; i< cnt; i++){
            System.out.println(num[i]);
        }
    }

    
}

public class Enrollment1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int nummax = sc.nextInt();
        Course course = new Course(name, nummax);

        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            boolean a = course.enroll(x);
            System.out.println(a);
        }
        course.printInfo();

    }
}
