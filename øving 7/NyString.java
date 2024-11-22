public class NyString {
    private final String tekst; //immutable
//
    public NyString(String tekst){
        this.tekst = tekst;
    }

    public String forkorte() {
        //Separate the text based on space inbetween
        String[] ord = tekst.split(" ");
        StringBuilder forkortetTekst = new StringBuilder();

        //get first letter
        for (String ordet : ord) { //go through every element ordet in tabell ord
            if (!ordet.isEmpty()) { //check that ordet is NOT empty
                forkortetTekst.append(ordet.charAt(0)); //shorten to the first letter
            }
        }
        return forkortetTekst.toString();
    }

    public String fjernTegn(char tegn) {
        StringBuilder nyTekst = new StringBuilder();
        int lengde = tekst.length();

        //go through each character in text
        for (int i = 0; i < lengde; i++) {
            //add unspecified character 
            if (tekst.charAt(i) != tegn) {
                nyTekst.append(tekst.charAt(i));
            }
        }
        return nyTekst.toString();
    }

    public static void main(String[] args) {
        NyString minTekst = new NyString("denne setningen kan forkortes");
        System.out.println("Forkortet tekst:" + minTekst.forkorte());
        System.out.println("Tekst uten 'e':" + minTekst.fjernTegn('e'));
    }
}

