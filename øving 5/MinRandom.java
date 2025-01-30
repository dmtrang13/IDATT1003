import java.util.Random;

public class MinRandom{
    private Random random;

    public MinRandom(){
        random = new Random();
    }

    public int nesteHeltall(int nedre, int ovre) {
        return nedre + random.nextInt(ovre - nedre); //Forskyver med nedre for riktig interval
    }

    public double nesteDesimaltall(double nedre, double ovre) {
        return nedre + (random.nextDouble() * (ovre - nedre)); //Skaler opp til riktig interval
    }
    // Test-klient
    public static void main(String[] args) {
        MinRandom minRandom = new MinRandom();

        System.out.println("Tilfeldig heltall i intervallet [15,30):");
        for (int i = 0; i < 5; i++){
            int tilfeldigInt = minRandom.nesteHeltall(15,30);
            System.out.println(tilfeldigInt);
        }

        System.out.println("Tilfeldig desimaltall i intervallet (0.5,2.5):");
        for (int i = 0; i < 5; i++){
            double tilfeldigDec = minRandom.nesteDesimaltall(0.5,2.5);
            System.out.println(tilfeldigDec);
        }
    }
}
