import java.util.Scanner;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;

public class Main{

    public static void main(String[]args){
        List<String> cards = null;
        List<String> fullDeck = Arrays.asList(
        "S1", "S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "S10", "SJ", "SQ", "SK", "SA",
        "H1", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10", "HJ", "HQ", "HK", "HA",
        "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10", "DJ", "DQ", "DK", "DA",
        "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "CJ", "CQ", "CK", "CA");

        if (args.length == 0){
            Collections.shuffle(fullDeck);
            cards = fullDeck;
        } else{
            try {
                cards = readFile(args[0]);
            } catch (FileNotFoundException e) {
                System.out.println("Error: Could not find the file");
                System.exit(1);
            }
        }

        Deck deck = new Deck(cards);
        Player dealer = new Player("dealer");
        Player sam = new Player("sam");
        BlackJack game = new BlackJack(deck, sam, dealer);
        game.playBlackJack();

    }

    public static List<String> readFile(String filename)throws FileNotFoundException{
        File file = new File(filename);
        Scanner fileReader = new Scanner(file);
        String [] cards = fileReader.nextLine().split(", ");
        List<String> cardList = Arrays.asList(cards);
        return cardList;
    }
}
