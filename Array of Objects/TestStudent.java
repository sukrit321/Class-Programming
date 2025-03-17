import java.util.Scanner;
class Student {
    final static int NUM_TEST = 4;
    public String fname;
    public String lname;
    private int[] stepScore;

    Student(String fname, String lname){
        this.fname = fname;
        this.lname = lname;
        this.stepScore = new int[NUM_TEST];
    }

    int getTestScore(int testNum){
        return stepScore[testNum - 1];
    }

    void setTestScore(int j, int score){    
        stepScore[j - 1] = score;
    }

    int computeTotal(){
        int sum = 0;
        for (int i : stepScore) {
            sum += i;
        }
        return sum;
    }

    void printInfo(){
        System.out.println(fname + " " + lname + " " + computeTotal());
    }
}
public class TestStudent {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        Student[] roster = new Student[N];
        for (int i = 0; i < N; i++) {
            String fname = scan.next();
            String lname = scan.next();
            roster[i] = new Student(fname, lname);
            for (int j = 1; j <= 4; j++) {
                int score = scan.nextInt();
                roster[i].setTestScore(j, score);
            }
            roster[i].printInfo();
        }
        int K = scan.nextInt();
        for (int i = 0; i < K; i++) {
            int rosterNum = scan.nextInt();
            int testNum = scan.nextInt();
            System.out.println(roster[rosterNum - 1].getTestScore(testNum));
        }
    }
}