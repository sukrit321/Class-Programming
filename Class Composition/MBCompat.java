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

class MainBoard{
    String mainmodel;
    int mainsocket;
    int mainmemType;
    boolean b;
    public MainBoard(String mainmodel, int mainsocket, int mainmemType) {
        this.mainmodel = mainmodel;
        this.mainsocket = mainsocket;
        this.mainmemType = mainmemType;
        this.b = isValidSpec(mainmodel, mainsocket, mainmemType);
    }
    boolean isValidSpec(String mainmodel, int mainsocket, int mainmemType){
        if((mainmodel != null && mainmodel != "" )  && mainsocket > 0 && (mainmemType > 0 && mainmemType <= 10)){
            return true;
        }
        else {
            return false;
        }
    }

    void printIofo(){
        System.out.println(mainmodel);
        System.out.println(mainsocket);
        System.out.println(mainmemType);
        System.out.println(b);
    }

}

class Computer{
    CPU cpu;
    MainBoard mainBoard;
    boolean c;

    public Computer(CPU cpu, MainBoard mainBoard) {
        this.cpu = cpu;
        this.mainBoard = mainBoard;
        this.c = isValidCom(cpu, mainBoard);
    }

    boolean isValidCom(CPU cpu, MainBoard mainBoard){
        if(cpu.socket == mainBoard.mainsocket && cpu.memType == mainBoard.mainmemType && cpu.a && mainBoard.b){
            return true;
        }
        else {
            return false;
        }
    }

    void printIofo(){
        if(c){
            System.out.println(cpu.model);
            System.out.println(cpu.clocks);
            System.out.println(mainBoard.mainmodel);
            System.out.println(mainBoard.mainsocket);
            System.out.println(mainBoard.mainmemType);
        }
        else {
            System.out.println("Invalid Spec");
            cpu.printIofo();
            mainBoard.printIofo();
        }
    }
}

public class MBCompat {
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
        
        sc.nextLine();
        String mainmodel = sc.nextLine();
        int mainsocket = sc.nextInt();
        int mainmemType = sc.nextInt();
        if(mainmodel.length() == 0 && mainsocket % 2 == 0){
            mainmodel = null;
        }
        MainBoard mainBoard = new MainBoard(mainmodel, mainsocket, mainmemType);
        Computer com = new Computer(cpu, mainBoard);
        com.printIofo();
    }
}
