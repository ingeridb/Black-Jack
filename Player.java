import java.util.ArrayList;
import java.util.Stack;

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

    public void drawCard(Deck deck){
        Card c = deck.cards.pop();
        hand.add(c);
        updateHandValue(c);
        updateScoreStatus();
    }

    private void updateHandValue(Card c){
        if(c.value == 'A'){
            handValue += 11;
        } else if(c.value == 'Q' || c.value == 'K' || c.value == 'J'){
            handValue += 10;
        } else{
            int newValue = Character.getNumericValue(c.value);
            handValue += newValue;
        }
    }

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
