import java.util.Scanner;
//
public class InchConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner (input) object

//Create input
        System.out.print("Enter a decimal :");
        double num = scanner.nextDouble();     //Read the input num 
        double inch = num / 2.54;   // Convert function

        //Print out
        System.out.print( num + "cm is equivalent to" + " " + inch + "inches");   

        //Close function
        scanner.close(); 

    }

}


