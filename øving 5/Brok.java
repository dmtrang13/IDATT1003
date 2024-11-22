public class Brok {
    private int nevner;
    private int teller;

    //Konstruktør 1
    public Brok(int teller, int nevner){
        if (nevner == 0){
            throw new IllegalArgumentException("Nevner kan ikke være null.");
        }
        this.teller = teller;
        this.nevner = nevner;
        forkorte();
    }

    //Konstruktør 2
    public Brok(int teller){    //antar nevneren er 1 når bare telleren er oppgitt
        this.teller = teller;
        this.nevner = 1;
    }

    public int getTeller() {
        return teller;
    }
    
    public int getNevner() {
        return nevner;
    }

    public void add(Brok annen) {
        this.teller = this.teller * annen.getNevner() + annen.getTeller() * this.nevner;
        this.nevner = this.nevner * annen.getNevner();
        forkorte();
    }

    public void subtract(Brok annen) {
        this.teller = this.teller * annen.getNevner() - annen.getTeller() * this.nevner;
        this.nevner = this.nevner * annen.getNevner();
        forkorte();
    }

    public void multiply(Brok annen) {
        this.teller = this.teller * annen.getTeller();
        this.nevner = this.nevner * annen.getNevner();
        forkorte();
    }

    public void divide(Brok annen) {
        if (annen.getTeller() == 0) {
            throw new IllegalArgumentException("Kan ikke dele på null.");  
        }
        this.teller = this.teller * annen.getNevner();
        this.nevner = this.nevner * annen.getTeller();
        forkorte();
    }

    public void forkorte() {
        int gcd = findGCD(teller,nevner); // Greatest common divisor
        teller = teller / gcd;
        nevner = nevner / gcd;
    }

    private int findGCD(int a, int b) {
        if (b == 0) {  // Euclidean algorithm
            return Math.abs(a);
        } else {
            return findGCD(b, a % b);
        }
    }

    @Override //brøk i teller/nevner format
    public String toString() {
        if (nevner == 1) {
            return String.valueOf(teller);
        }
        return teller + "/" + nevner;
    }

    //Test-klient
    public static void main(String[] args){
        Brok b1 = new Brok(2,3);
        Brok b2 = new Brok(4,5);

        System.out.println("b1:" + b1);
        System.out.println("b2:" + b2);

        //Addisjon
        b1.add(b2);
        System.out.println("b1 + b2:" + b1);

        //Substraksjon
        b1 = new Brok(2,3);
        b1.subtract(b2);
        System.out.println("b1 - b2:" + b1);

        //Multiplikasjon
        b1 = new Brok(2,3);
        b1.multiply(b2);
        System.out.println("b1 * b2:" + b1);

        //Divisjon
        b1 = new Brok(2,3);
        b1.divide(b2);
        System.out.println("b1 / b2:" + b1);
    }
}
