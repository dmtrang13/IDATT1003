public class Terningspill {
    private int sumPoeng;
    private java.util.Random terning ;

    public Terningspill() {
        this.sumPoeng = 0; //current value
        this.terning = new java.util.Random();
    }
  

    public int kastTerningen() {
        int terningkast = terning.nextInt(6) + 1; //random from 1 to 6

        if (terningkast == 1){
            sumPoeng = 0;
        } else {
            sumPoeng += terningkast;
        }
    return terningkast; 

    }

    public int getPoeng() {
        if (sumPoeng > 100) {
            sumPoeng = 100 - (sumPoeng - 100);
        }
        return sumPoeng;
    }
    
    //boolean TRUE
    public boolean erFerdig() {
        return sumPoeng == 100;
    }

    public static void main(String[] args) {
        Terningspill spillerA = new Terningspill();
        Terningspill spillerB = new Terningspill();
        int runde = 1;
        

        //while NOT
        while (!spillerA.erFerdig() && !spillerB.erFerdig()) {
            System.out.println();
            System.out.println("Runde " + " " + runde);

            int terningkastA = spillerA.kastTerningen();
            System.out.println("Spiller A kastet: " + " " + terningkastA + " " + ", Poeng: " + " " + spillerA.getPoeng());

            int terningkastB = spillerB.kastTerningen();
            System.out.println("Spiller B kastet: " + " " + terningkastB + " " + ", Poeng: " + " " + spillerB.getPoeng());

            runde++;
        }
        
        if (spillerA.erFerdig()) {
            System.out.println("Spiller A vant!");
        } else if (spillerB.erFerdig()) {
            System.out.println("Spiller B vant!");
        }
    }
}

