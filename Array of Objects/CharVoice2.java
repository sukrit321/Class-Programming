import java.util.Scanner;

class Character{
    String[] text;
    int n;

    public Character(String[] text, int n){
        this.text = new String[n];
        this.text = text;
        this.n = n;
    }

    void speak(int num){
        System.out.println(this.text[num]);
    }
}

public class CharVoice2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        Character[] ch = new Character[c];
        for(int i = 0; i < c; i++){
            int n = sc.nextInt();
            String[] text = new String[n];
            sc.nextLine();
            for(int j = 0; j < n; j++){
                text[j] = sc.nextLine();
            }
            ch[i] = new Character(text, n);
        }
        int[] num = new int[c];
        int K = sc.nextInt();
        for(int i = 0; i < K; i++){
            int x = sc.nextInt();
            if(num[x - 1] == ch[x - 1].n){
                num[x - 1] = 0;
                ch[x - 1].speak(num[x - 1]);
                num[x - 1]++; 
            }
            else {
                ch[x - 1].speak(num[x - 1]);
                num[x - 1]++;
            }
        }
    }
}