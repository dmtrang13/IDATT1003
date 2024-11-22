import java.util.Scanner;

public class Skuddaar{
    public static boolean isLeap(int year) {

        if (year%4 == 0 && year%100 != 0 || year%400 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a year");
        int year = scanner.nextInt();

        System.out.println("Is" + year + " " + "a leap year?" + isLeap(year));
        scanner.close();

    }
    
}


 /*

 eller

 public class Skuddaar {
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a year:");
        int year = scanner.nextInt();
    
        if (year%4 == 0 && year%100 != 0 || year%400 == 0) {
            
            System.out.print(year + " " + "er et skuddår");
        }

        
        else {
            System.out.print(year + " " + "er ikke et skuddår");
        }

        scanner.close();

    }
}
    
*/





