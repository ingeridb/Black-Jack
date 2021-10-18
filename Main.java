import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main{

    public static void main(String[]args){
        if (args.length == 0){
            System.out.println("Feil, mangler fil");
        } else{
            try {
                readFile(args[0]);
            } catch (FileNotFoundException e) {
                System.out.printf("FEIL: Kunne ikke lese fra '%s'\n", args[0]);
                System.exit(1);
            }
        }
    }

    public static void readFile(String filename)throws FileNotFoundException{
        File file = new File(filename);
        Scanner fileReader = new Scanner(file);
        String [] cards = fileReader.nextLine().split(", ");
        for (int i = 0; i < cards.length; i++){
            System.out.println(cards[i].substring(0, 1));
            System.out.println(cards[i].substring(1, 2));
        }
        Deck deck = new Deck(cards);
    }
}
