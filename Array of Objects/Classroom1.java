import java.util.Scanner;
class Classroom {
    String name;
    int numSeats;
    int nProj;
    int nVisual;
    int nSmart;
    int nCam;
    boolean use = true;

    public Classroom(String name, int numSeats, int nProj, int nVisual, int nSmart, int nCam) {
        this.name = name;
        this.numSeats = numSeats;
        this.nProj = nProj;
        this.nVisual = nVisual;
        this.nSmart = nSmart;
        this.nCam = nCam;
    }

    boolean isAvailable(int numSeats, int nProj, int nVisual, int nSmart, int nCam){
        if(this.numSeats >= numSeats && this.nProj >= nProj && this.nVisual >= nVisual && this.nSmart >= nSmart && this.nCam >= nCam && use){
            return true;
        }
        else {
            return false;
        }
    }

    boolean reserve(int numSeats, int nProj, int nVisual, int nSmart, int nCam){
        boolean a = isAvailable(numSeats, nProj, nVisual, nSmart, nCam);
        if(a){
            this.use = false;
            return true;
        }
        else {
            return false;
        }
    }
}
public class Classroom1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Classroom[] rooms = new Classroom[n];
        for(int i = 0; i < n; i++) {
            String name = scan.next();
            int numSeats = scan.nextInt();
            int nProj = scan.nextInt();
            int nVisual = scan.nextInt();
            int nSmart = scan.nextInt();
            int nCam = scan.nextInt();
            rooms[i] = new Classroom(name, numSeats, nProj, nVisual, nSmart, nCam);
        }

        int k = scan.nextInt();
        for(int i = 0 ; i < k; i++) {
            int numSeats = scan.nextInt();
            int nProj = scan.nextInt();
            int nVisual = scan.nextInt();
            int nSmart = scan.nextInt();
            int nCam = scan.nextInt();
            boolean a = false;
            for(int j = 0; j < n; j++) {
                a = rooms[j].isAvailable(numSeats, nProj, nVisual, nSmart, nCam);
                if(a){
                    System.out.println(rooms[j].name);
                    rooms[j].reserve(numSeats, nProj, nVisual, nSmart, nCam);
                    break;
                }

            }
            if(!a){
                System.out.println("classroom not available");
            }
        }

    }
}