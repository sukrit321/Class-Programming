import java.util.Scanner;

class Content {
    String name;
    int price;
    public Content(String name, int price) {
        this.name = name;
        this.price = price;
    }

    void updatePrice(int newprice){
        if(newprice > 0){
            this.price = newprice;
        }
    }

    void printSummary(){
        System.out.println(name + " " + price);
    }
}

class Food {
    String name;
    Content[] contents;
    public Food(String name, Content[] contents) {
        this.name = name;
        this.contents = contents;
    }
    
    void printSummary(){
        int sum = 0;
        for (Content content : contents) {
            sum += content.price;
        }
        System.out.println(name + " " + sum);
    }
}
public class FoodMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numContents = sc.nextInt();
        Content[] contents = new Content[numContents];
        for (int i = 0; i < contents.length; ++i) {
            String name = sc.next();
            int price = sc.nextInt();
            contents[i] = new Content(name, price);
        }
        int numFoods = sc.nextInt();
        Food[] foods = new Food[numFoods];
        for (int i = 0; i < foods.length; ++i) {
            String name = sc.next();
            int numFoodContents = sc.nextInt();
            Content[] foodContents = new Content[numFoodContents];
            for (int j = 0; j < foodContents.length; ++j) {
                int contentId = sc.nextInt();
                foodContents[j] = contents[contentId];
            }
            foods[i] = new Food(name, foodContents);
        }
        for(;;){
            int index = sc.nextInt();
            if(index == -1){
                break;
            }
            int newprice = sc.nextInt();
            contents[index].updatePrice(newprice);
            contents[index].printSummary();
        }
        for (Food i : foods) {
            i.printSummary();
        }
        sc.close();
    }
}  