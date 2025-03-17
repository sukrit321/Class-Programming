import java.util.Scanner;

class Character{
    String[] text;

    public Character(String[] text, int n){
        this.text = new String[n];
        this.text = text;
    }

    void speak(int num){
        System.out.println(this.text[num]);
    }
}

public class CharVoice1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] text = new String[n];
        sc.nextLine();
        for(int i = 0; i < n; i++){
            text[i] = sc.nextLine();
        }
        int K = sc.nextInt();
        Character ch = new Character(text, n);
        int num = 0;
        for(int i = 0; i < K; i++){
            if(num == n){
                num = 0;
                ch.speak(num);
                num++;
            }
            else {
                ch.speak(num);
                num++;
            }
        }



    }
}