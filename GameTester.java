import java.util.List;
import java.util.Stack;
import java.util.Arrays;
import java.util.ArrayList;

class GameTester{

    public static void main(String[]args){
        testSamWins();
        testDealerWins();
        testDouble22();
        System.out.println(
        "\n####################\nPassed all the tests\n####################");
    }

    public static void testSamWins(){
        //Tests where Sam should win the game

        //arrange
        Player dealer = new Player("dealer");
        Player sam = new Player("sam");
        List<String> cards = Arrays.asList("CA", "D5", "H9", "HQ", "S8", "H2");
        Deck deck = new Deck(cards);

        //act
        BlackJack game = new BlackJack(deck, sam, dealer);
        game.playBlackJack();

        //assert
        if(!game.winner.name.equals("sam")) throw new RuntimeException("Wrong winner");
        if(!game.deck.cards.peek().suite.equals("H")) throw new RuntimeException("Error in deck.cards");
    }

    public static void testDealerWins(){
        //Tests if Sam wins the game
        //arrange
        Player dealer = new Player("dealer");
        Player sam = new Player("sam");
        List<String> cards = Arrays.asList("CA", "D9", "HA", "HQ");
        Deck deck = new Deck(cards);

        //act
        BlackJack game = new BlackJack(deck, sam, dealer);
        game.playBlackJack();

        //assert
        if(!game.winner.name.equals("dealer")) throw new RuntimeException("Wrong winner");
        if(game.dealer.handValue != 19) throw new RuntimeException("Wrong handValue of dealer");
        if(game.player.handValue != 22) throw new RuntimeException("Wrong handValue of player");
        if(!game.player.hand.get(0).suite.equals("C")) throw new RuntimeException("Wrong card on hand");
    }

    public static void testDouble22(){
        //Tests if dealer wins if they both get 22
        //arrange
        Player dealer = new Player("dealer");
        Player sam = new Player("sam");
        List<String> cards = Arrays.asList("CA", "DA", "HA", "DA");
        Deck deck = new Deck(cards);

        //act
        BlackJack game = new BlackJack(deck, sam, dealer);
        game.playBlackJack();

        //assert
        if(!game.winner.name.equals("dealer")) throw new RuntimeException("Wrong winner");
        if(game.dealer.handValue != 22) throw new RuntimeException("Wrong handValue of dealer");
        if(game.player.handValue != 22) throw new RuntimeException("Wrong handValue of player");
        if(!game.player.hand.get(1).suite.equals("H")) throw new RuntimeException("Wrong card on hand");
    }

}
