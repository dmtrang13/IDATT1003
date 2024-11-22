import javax.swing.JOptionPane;


public class Valuta {
    public static void main(String[] args) {
        String[] options = {"1. dollar", "2. euro", "3. svenske kroner", "4. avslutt"};
        int choice;

        do {
          
            choice = JOptionPane.showOptionDialog(null, "Velg en Valuta", "Valuta", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);


            if (choice >= 0 && choice <= 2) {
                String nokint = JOptionPane.showInputDialog("Skriv inn beløpet i nok: ");

                try {
                    float nok = Float.parseFloat(nokint); //Convert input into float

                    switch (choice) {
                        case 0:
                            float usd = nok / 10.64f;
                            JOptionPane.showMessageDialog(null, nok + " " + "nok" + " " + "kr tilsvarer" + " " + usd + " " + "usd");
                            break;
                        case 1:
                            float euro = nok / 11.82f;
                            JOptionPane.showMessageDialog(null, nok + " " + "nok" + " " + "kr tilsvarer" + " " + euro + " " + "eur");
                            break;
                        case 2:
                            float sek = nok / 1.04f;
                            JOptionPane.showMessageDialog(null, nok + " " + "nok" + " " + "kr tilsvarer" + " " + sek + " " + "sek");
                            break;
                    }

                    int confirm = JOptionPane.showConfirmDialog(null, "Vil du fortsette?", "Bekreft", JOptionPane.YES_NO_OPTION);

                    if (confirm == JOptionPane.NO_OPTION) {
                        choice = 3;
                    }


                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Ugyldig beløp. Prøv igjen.");
                }         
            
            } 
        } while (choice != 3);
        
        JOptionPane.showMessageDialog(null, "Avslutter...");
    
    }    
        
}
