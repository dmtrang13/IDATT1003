import java.util.Scanner;

public class TimeConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner (input) object


//Create input
        System.out.print("Enter the seconds :");
        double sech = scanner.nextDouble();     //Read the input num 

        if (sech < 0) { 
            System.out.print("Tid kan ikke være negativ dumbass");
        }

        else {
            double hour = sech/3600;   // Convert function seconds into hour
            int h = (int) Math.floor(hour);       //Round down the hour into smallest whole number + Convert type double to type int

            double secm = sech%3600;        //Rest of the hour
            int min = (int) secm/60;           //Convert rest of hour into minutes + Convert type double to type int
            double sec = secm%60;           //Rest of minute function equal seconds

            //Print out
            System.out.print( sech + "seconds is equivalent to" + "\n" + h + "hours" + "\n" + min + "minutes" + "\n" + sec + "seconds");  
        }

        //Close function
        scanner.close(); 
    }

}