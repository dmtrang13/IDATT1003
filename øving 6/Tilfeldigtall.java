import java.util.Random;

public class Tilfeldigtall {
    public static void main(String[] args){
        Random random = new Random();

        int[] antall = new int[10];

        for (int i = 0; i < 1000; i++) {
            int tall = random.nextInt(10);
            antall[tall]++;     //Øker tellingen
        }

        System.out.println("Tall | Antall | Histogram");
        System.out.println("--------------------------");

        for (int i = 0; i < 10; i++) {
            int stjerner = (int) Math.round(antall[i] / 10.0);  //Antall stjerner
            System.out.print(i + "    | " + antall[i] + "     | ");

            for (int j = 0; j < stjerner; j++){
                System.out.print("*");
            }

            System.out.println();
        } 
    }    
}
