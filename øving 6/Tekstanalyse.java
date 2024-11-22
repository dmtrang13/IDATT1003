//FILE DOES NOT WORK IN VSCODE. TRY INTELLJ//

import java.util.Scanner;
import java.nio.charset.StandardCharsets;

public class Tekstanalyse {
    private int[] antallTegn;
    private int totalTegn;

    private static final int INDEX_AE = 26;
    private static final int INDEX_OE = 27;
    private static final int INDEX_AA = 28;
    private static final int INDEX_OTHERS = 29;



    public Tekstanalyse(String tekst) { //tekst as parameter
        antallTegn = new int[30];
        tekst = tekst.toLowerCase();
        totalTegn = tekst.length();

        for (int i = 0; i < tekst.length(); i++){
            char tegn = tekst.charAt(i);
            //System.out.println("Character read: " + tegn);
            if (tegn >= 'a' && tegn <= 'z'){
                antallTegn[tegn - 'a']++;            
            } else if (tegn == 'æ'){
                antallTegn[INDEX_AE]++;
            } else if (tegn == 'ø'){
                antallTegn[INDEX_OE]++;
            } else if (tegn == 'å'){
                antallTegn[INDEX_AA]++;
            } else {
                antallTegn[INDEX_OTHERS]++;
            }
        }
    }

    //finn forskjellen
    public int finnForskjell() {
        int antallForskjellig = 0;
        for (int i = 0; i < 29; i++){
            if (antallTegn[i] > 0){
                antallForskjellig++;
            }
        }
        return antallForskjellig;
    }

    //finn total antall bokstaver
    public int finnTotal() {
        int totalBokstaver = 0;
        for (int i = 0; i < 29; i++){
            totalBokstaver += antallTegn[i];
        }
        return totalBokstaver;
    }
    
    //finn prosentforskjell
    public double finnProsent() {
        int antallAndre = antallTegn[29];
        return (double) antallAndre / totalTegn * 100;
    }

    //finne antall forekmomster av en bestemt bokstav
    public int finnForekomst(char bokstav) {
        bokstav = Character.toLowerCase(bokstav);
        if (bokstav >= 'a' && bokstav <= 'z'){
            return antallTegn[bokstav - 'a'];
        } else if (bokstav == 'æ'){
            return antallTegn[INDEX_AE];
        } else if (bokstav == 'ø'){
            return antallTegn[INDEX_OE];
        } else if (bokstav == 'å'){
            return antallTegn[INDEX_AA];
        } else {
            return 0;
        }
    }

    //finn vanligst forekomst 
    public String finnVanligst() {
        int maks = 0;
        StringBuilder vanligstbokstav = new StringBuilder();

        //finn maksimal forekomst 
        for (int i = 0; i < 29; i++){
            if (antallTegn[i] > maks){
                maks = antallTegn[i];
            }
        }

        //finn bokstaven som forekommer oftest
        for (int i = 0; i < 29; i++){
            if (antallTegn[i] == maks){
                if (i < 26){
                    vanligstbokstav.append((char) ('a' + i)).append(" ");
                } else if (i == INDEX_AE) {
                    vanligstbokstav.append('æ');
                } else if (i == INDEX_OE) {
                    vanligstbokstav.append('ø');
                } else if (i == INDEX_AA) {
                    vanligstbokstav.append('å');
                }
            }
        }
        return vanligstbokstav.toString().trim(); //trimme mellomrom
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in, StandardCharsets.UTF_8);

        //analysere teksten
        while (true) {
            System.out.println("Skriv inn en tekst (exit for å avslutte):");
            String tekst = input.nextLine();

            if (tekst.equalsIgnoreCase("exit")){
                break;
            }
            
            Tekstanalyse analyse = new Tekstanalyse(tekst);
            System.out.println("Antall forskjellige bokstaver: " + analyse.finnForskjell());
            System.out.println("Totalt antall bokstaver: " + analyse.finnTotal());
            System.out.printf("Prosent av tegn som ikke er bokstaver: %.2f%%\n", analyse.finnProsent());

            System.out.println("Skriv inn en bokstav for å finne antall forekomster:");
            char bokstav = input.nextLine().charAt(0);
            System.out.println("Antall forekomster av '" + bokstav + "':" + analyse.finnForekomst(bokstav));
            System.out.println("Mest vanlige bokstev(er) er:" + analyse.finnVanligst());
        }
        input.close();
    }

}
