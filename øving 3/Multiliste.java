import java.util.ArrayList;
import java.util.List;

public class Multiliste{
    public static void main(String[] args) {
        List<Integer> multi = new ArrayList<>(List.of(13,14,15));
  
        
        for (int e = 0; e < multi.size(); e++) {    //Go through each element in the list multi
            int ogVa = multi.get(e);
            System.out.println(ogVa + " " + "multiplikasjon");

            for (int i = 1; i <= 10; i++) { 
                int result = i * ogVa;
                System.out.println(i + "*" + ogVa + " " + "=" + " " + result);

            }
            System.out.println();
        
        }
    }
}