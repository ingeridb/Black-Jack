import java.util.ArrayList;
import java.util.Stack;

/**
 * Player --- A player for Black Jack
 * A player has a hand of cards, and can keep track of handvalue and
 * possible Black Jack scores (over 17, 21, over 21).
 * @author    Ingerid Bergesen
 */
public class Player{

    public String name;
    public ArrayList<Card> hand = new ArrayList<>();
    public int handValue = 0;
    public boolean blackJack = false;
    public boolean higherThan17 = false;
    public boolean lostGame = false;

    public Player(String name){
        this.name = name;
    }

    /**
    * The player can draw a card from a Deck and add it to their hand.
    * Updates the players handValue and scorestatuses.
    * @param A Deck object
    * @return No return value.
    */
    public void drawCard(Deck deck){
        Card c = deck.cards.pop();
        hand.add(c);
        updateHandValue(c);
        updateScoreStatus();
    }

    /**
    * Updates the hand value of the player
    * @param A Card object
    * @return No return value.
    */
    private void updateHandValue(Card c){
        if(c.getValue() == 'A'){
            handValue += 11;
        } else if(c.getValue() == 'Q' || c.getValue() == 'K' || c.getValue() == 'J'){
            handValue += 10;
        } else{
            int newValue = Character.getNumericValue(c.getValue());
            handValue += newValue;
        }
    }

    /**
    * Updates the status of the player to check if the player has a score over
    * 17, a score of 21 (blackjack) or a score over 21 (lost the game)
    * @param No parameters
    * @return No return value.
    */
    private void updateScoreStatus(){
        if (handValue == 21){
            blackJack = true;
        } else if(handValue >= 17 && handValue <= 21){
            higherThan17 = true;
        } else if(handValue >= 22){
            lostGame = true;
        }
    }

}
