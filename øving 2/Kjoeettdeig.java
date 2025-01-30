
public class Kjoeettdeig{ 
    public static void main(String[] args) {
        double A = 35.90/450*100;
        double B = 35.90/500*100;

        System.out.println("Merke A koster" + " " + A + " " + "kr per 100g");
        System.out.println("Merke B koster" + " " + B + " " + "kr per 100g");


        if (A < B) {
            System.out.println("Merke A er biligere med" + " " + Math.abs(B - A) + " " + "kr");
        } else {
            System.out.println("Merke B er biligere med" + " " + Math.abs(A - B) + " " + "kr");
        }
        
    } 

}