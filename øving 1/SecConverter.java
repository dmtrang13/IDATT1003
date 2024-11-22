import java.util.Scanner;

public class SecConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner (input) object

//Create input
        System.out.print("Enter the hours :");
        
        int hour = scanner.nextInt();     //Read the input hour 
        int sech = hour * 3600;   // Convert function

        System.out.print("Enter the minutes :");
        int min = scanner.nextInt();     //Read the input min 
        int secm = min * 60;   // Convert function

        int totsec = sech + secm; //Total seconds


        //Print out
        System.out.print( hour + "hours" + " " + min + "minutes is equivalent to" + " " + totsec + "seconds" );   

        //Close function
        scanner.close(); 
    }

}