import java.util.Scanner;
class House {
    int landSize;
    int quality;
    int floors;
    int houseArea;
    int price;

    House(int landSize, int quality, int floors, int houseArea){
        this.landSize = landSize;
        this.quality = quality;
        this.floors = floors;
        this.houseArea = houseArea;
        computePrice(landSize, quality, floors, houseArea);
    }

    int computePrice(int landSize, int quality, int floors, int houseArea){
        if(quality == 1){
            int sum = (landSize * 10000) + (houseArea * 10000) + ((floors - 1) * 200000);
            return this.price = sum;
        }
        else if(quality == 2){
            int sum = (landSize * 10000) + (houseArea * 8000) + ((floors - 1)  * 200000);
            return this.price = sum;
        }
        else {
            int sum = (landSize * 10000) + (houseArea * 5000) + ((floors - 1)  * 200000);
            return this.price = sum;
        }
    }
}
public class HousePrice2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        House[] house = new House[n];
        for(int i = 0; i < n; i++){
            int landSize = scan.nextInt();
            int quality = scan.nextInt();
            int floors = scan.nextInt();
            int houseArea = scan.nextInt();
            house[i] = new House(landSize, quality, floors, houseArea);
        }
        int cost = scan.nextInt();
        int area = scan.nextInt();
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(house[i].price <= cost && house[i].houseArea >= area){
                System.out.print(house[i].landSize + " " + house[i].quality + " " + house[i].floors + " " + house[i].houseArea + " ");
                System.out.println(house[i].price);
                cnt++;
            }
        }
        if(cnt == 0){
            System.out.println("none");
        }
    }
}