public class Tekstbehandling {
    private final String tekst;

    public Tekstbehandling(String tekst) {
        this.tekst = tekst;
    }

    public int antallOrd() {
        String[] ord = tekst.split("\\s+"); //Separate on one or more space
        return ord.length;
    }

    //find average word length
    public double gjennomsnittsOrdlengde() {
        String[] ord = tekst.split("\\s+");
        int totalBokstaver = 0;
        
        for (String ordet : ord){
            ordet = ordet.replaceAll("[^\\p{L}]"," "); //remove all delimiter, only letters remain
            totalBokstaver += ordet.length();
        }
        return (double) totalBokstaver/ord.length;
    }

    public double gjennomsnittsOrdperPeriode(){
        String[] perioder = tekst.split("[.!?;:]"); //Separate on . ! ? ; :
        int totalOrd = antallOrd();

        return(double) totalOrd/perioder.length;
    }

    public String erstattOrd(String gammeltOrd, String nyttOrd){
        String lowerCaseText = tekst.toLowerCase();
        return lowerCaseText.replaceAll("\\b" + gammeltOrd.toLowerCase() + "\\b", nyttOrd); // \\b for matching the exact whole word
    }

    //Get normal text
    public String hentTekst() {
        return tekst;
    }

    //Get capitalised text
    public String hentTekstStor() {
        return tekst.toUpperCase();
    }

    //Tekstklient

    public static void main(String[] args){
        String tekst = "Kvinnen Hedda Gabler gir fra åpningsscenen i stykket av samme navn, et kaldt, strengt og distansert inntrykk. Hun er fra første møte mer av en skikkelse enn en kropp. Ansiktet, og resten av henne, er «edelt og fornemt formet», og drakten hun bærer sitter løst på henne. Denne unge kvinnen, som er General Gablers datter i stykket, synes å bære sin 'ro' med en militant selvdisiplin når hun inntar scenen som Jørgen Tesmans nye hustru. Hennes kropp er som meislet i hardt metall, slik hennes øyne også er av «stålgrå» farge.";
        Tekstbehandling tb = new Tekstbehandling(tekst);

        System.out.println("Originaltekst: " + tb.hentTekst());
        System.out.println("Antall ord: " + tb.antallOrd());
        System.out.println("Gjennomsnittlig ordlengde: " + tb.gjennomsnittsOrdlengde());
        System.out.println("Gjennomsnittlig antall ord per periode: " + tb.gjennomsnittsOrdperPeriode());

        System.out.println("Erstattet ord: " + tb.erstattOrd("kvinnen", "kvinna"));

        System.out.println("Tekst i store bokstaver: " + tb.hentTekstStor());
    }
}