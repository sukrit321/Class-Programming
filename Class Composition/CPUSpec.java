import java.util.Scanner;

class CPU{
    public String model;
    public int clocks;
    public int socket;
    public int memType;
    public boolean a;
    public CPU(String model, int clocks, int socket, int memType) {
        this.model = model;
        this.clocks = clocks;
        this.socket = socket;
        this.memType = memType;
        this.a = isValidSpec(model, clocks, socket, memType);
    }

    boolean isValidSpec(String model, int clocks, int socket, int memType){
        if((model != null && model != "" ) && clocks > 0 && socket > 0 && (memType > 0 && memType <= 10)){
            return true;
        }
        else {
            return false;
        }
    }

    void printIofo(){
        System.out.println(model);
        System.out.println(clocks);
        System.out.println(socket);
        System.out.println(memType);
        System.out.println(a);
    }
}

public class CPUSpec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String model = sc.nextLine();
        int clocks = sc.nextInt();
        int socket = sc.nextInt();
        int memType = sc.nextInt();

        if(model.length() == 0 && socket % 2 == 0){
            model = null;
        }
        CPU cpu = new CPU(model, clocks, socket, memType);
        cpu.printIofo();
    }
}
