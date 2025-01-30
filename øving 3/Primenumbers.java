import java.util.Scanner;

public class Primenumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number:");
        int p = scanner.nextInt();

        // ignore problem.
        boolean prime = primenumbers(p); //Define prime is function of primenumbers(p)
        System.out.println(p + " " + "is a prime number?" + " " + primenumbers(p));
        scanner.close();
    }

    public static boolean primenumbers(int p) { //Function of primenumbers
        boolean prime = true; //Define prime as true

        // Define conditions for prime is false
        if (p <= 1) {
            prime = false;
        }
        else{
            int stop = (int) Math.sqrt(p) + 1; //Stop range for testing 
        
            for (int i = 2; i < stop; i++) {
                if (p%i == 0){
                    prime = false;
                    break;
                }
            }
        }
        return prime;

    }
}
