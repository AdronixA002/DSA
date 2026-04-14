import java.util.Scanner;

public class NQT {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of zone: ");
        int zone = 0;
        if(sc.hasNextInt()){
            zone = sc.nextInt();
        }else System.out.println("Invalid input");

        System.out.println("Enter zone id's: ");
        int[] id = new int[zone];

        for(int i=0;i<zone;i++){
            if(sc.hasNextInt()){
                id[i] = sc.nextInt();
            }else System.out.println("Invalid input");
        }

        int count=0;
        if(zone==id.length){
            for(int i=0;i<zone-2;i++){
                for(int j=i+2;j<zone;j++){
                    if(id[i]==id[j]){
                        count++;
                    }
                }
            }
        }else {
            System.out.println("Invalid input");
        }
        System.out.println("Number of migration pattern is: "+count);
        
    }
}
